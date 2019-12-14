/*
 * Copyright 2019 AraguaneyBits.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.araguaneybits.crypto.bitcoinrpc.methods;

import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.araguaneybits.commons.constants.HttpConstants;
import com.araguaneybits.commons.http.ApiHttpClient;
import com.araguaneybits.commons.http.ApiHttpMediaType;
import com.araguaneybits.commons.http.ApiHttpResponse;
import com.araguaneybits.commons.http.ApiHttpType;
import com.araguaneybits.commons.http.EnumHttpStatusCode;
import com.araguaneybits.commons.utils.HttpUtils;
import com.araguaneybits.commons.utils.ProxyConfiguration;
import com.araguaneybits.crypto.bitcoinrpc.RpcInputMessage;
import com.araguaneybits.crypto.bitcoinrpc.exception.AuthenticationException;
import com.araguaneybits.crypto.bitcoinrpc.exception.CallRpcApiMethodException;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.HttpUrl;

/**
 * The Class BtcRpcGateway.
 *
 * @author jestevez
 */
public class BtcRpcGateway {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(BtcRpcGateway.class);

    /** The api http client. */
    private ApiHttpClient apiHttpClient;

    /** The credential. */
    private String credential;

    /** The Constant DEFAULT_PROTOCOL. */
    private static final String DEFAULT_PROTOCOL = "http";

    /** The Constant DEFAULT_WALLET. */
    private static final String DEFAULT_WALLET = "/wallet/";

    /**
     * Instantiates a new btc rpc gateway.
     *
     * @param httpUrl the http url
     * @param rpcUser the rpc user
     * @param rpcPassword the rpc password
     * @param proxyConfiguration the proxy configuration
     */
    public BtcRpcGateway(HttpUrl httpUrl, String rpcUser, String rpcPassword, ProxyConfiguration proxyConfiguration) {
        apiHttpClient = new ApiHttpClient(httpUrl, proxyConfiguration);
        credential = HttpUtils.toBasicAuthorization(rpcUser, rpcPassword);
    }

    /**
     * Instantiates a new btc rpc gateway.
     *
     * @param httpUrl the http url
     * @param rpcUser the rpc user
     * @param rpcPassword the rpc password
     */
    public BtcRpcGateway(HttpUrl httpUrl, String rpcUser, String rpcPassword) {
        this(httpUrl, rpcUser, rpcPassword, new ProxyConfiguration());
    }

    /**
     * Instantiates a new btc rpc gateway.
     *
     * @param rpcUser the rpc user
     * @param rpcPassword the rpc password
     * @param rpcHost the rpc host
     * @param rpcPort the rpc port
     */
    public BtcRpcGateway(String rpcUser, String rpcPassword, String rpcHost, String rpcPort) {
        this(rpcUser, rpcPassword, rpcHost, rpcPort, DEFAULT_PROTOCOL);
    }

    /**
     * Instantiates a new btc rpc gateway.
     *
     * @param rpcUser the rpc user
     * @param rpcPassword the rpc password
     * @param rpcHost the rpc host
     * @param rpcPort the rpc port
     * @param protocol the protocol
     */
    public BtcRpcGateway(String rpcUser, String rpcPassword, String rpcHost, String rpcPort, String protocol) {
        this(buidUrl(rpcHost, rpcPort, protocol, DEFAULT_WALLET), rpcUser, rpcPassword, new ProxyConfiguration());
    }

    /**
     * Instantiates a new btc rpc gateway.
     *
     * @param rpcUser the rpc user
     * @param rpcPassword the rpc password
     * @param rpcHost the rpc host
     * @param rpcPort the rpc port
     * @param protocol the protocol
     * @param proxyConfiguration the proxy configuration
     */
    public BtcRpcGateway(String rpcUser, String rpcPassword, String rpcHost, String rpcPort, String protocol, ProxyConfiguration proxyConfiguration) {
        this(buidUrl(rpcHost, rpcPort, protocol, DEFAULT_WALLET), rpcUser, rpcPassword, proxyConfiguration);
    }

    /**
     * Instantiates a new btc rpc gateway.
     *
     * @param rpcUser the rpc user
     * @param rpcPassword the rpc password
     * @param rpcHost the rpc host
     * @param rpcPort the rpc port
     * @param protocol the protocol
     * @param walletName the wallet name
     * @param proxyConfiguration the proxy configuration
     */
    public BtcRpcGateway(String rpcUser, String rpcPassword, String rpcHost, String rpcPort, String protocol, String walletName,
            ProxyConfiguration proxyConfiguration) {
        this(buidUrl(rpcHost, rpcPort, protocol, walletName), rpcUser, rpcPassword, proxyConfiguration);
    }

    /**
     * Buid url.
     *
     * @param rpcHost the rpc host
     * @param rpcPort the rpc port
     * @param protocol the protocol
     * @param wallet the wallet
     * @return the http url
     */
    private static HttpUrl buidUrl(String rpcHost, String rpcPort, String protocol, String wallet) {
        String url = "";
        if (protocol == null) {
            protocol = DEFAULT_PROTOCOL;
        }

        url = protocol + "://" + rpcHost;
        if (rpcPort != null && rpcPort.length() > 0) {
            url = url + ":" + rpcPort;
        }

        if (wallet != null) {
            url = url + wallet;
        }
        return HttpUrl.parse(url);
    }

    /**
     * Builds the rpc param.
     *
     * @param callMethod the call method
     * @param params the params
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static String buildRpcParam(String callMethod, Object... params) throws IOException {
        RpcInputMessage body = new RpcInputMessage();
        body.setMethod(callMethod);
        if (params != null && params.length > 0) {
            body.setParams(params);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String data = objectMapper.writeValueAsString(body);
        LOGGER.debug("RPC Params: [{}]", data);
        return data;
    }

    /**
     * Call rpc api method.
     *
     * @param callMethod the call method
     * @param params the params
     * @return the string
     */
    public String callRpcApiMethod(String callMethod, Object... params) {
        try {
            LOGGER.trace("RPC Request: Method: [{}] Params [{}] ", callMethod, params);
            String data = buildRpcParam(callMethod, params);
            HashMap<String, String> headers = new HashMap<>();
            headers.put(HttpConstants.AUTHORIZATION, String.format(credential));
            ApiHttpResponse apiResponse = apiHttpClient.send(ApiHttpType.POST, headers, data, ApiHttpMediaType.APPLICATION_JSON);
            if (apiResponse.getCode() == EnumHttpStatusCode.HTTP_UNAUTHORIZED.getCode()) {
                throw new AuthenticationException("http unauthorized");
            }
            String json = apiResponse.getBody();
            LOGGER.trace("RPC Response: [{}]", json);
            return json;
        } catch (Exception e) {
            LOGGER.error("Fail in callRpcApiMethod", e);
            throw new CallRpcApiMethodException("Fail to call method " + callMethod);
        }
    }

}
