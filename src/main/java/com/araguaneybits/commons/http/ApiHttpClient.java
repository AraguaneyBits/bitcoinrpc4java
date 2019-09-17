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
package com.araguaneybits.commons.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.araguaneybits.commons.utils.ProxyConfiguration;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;

/**
 * The Class ApiHttpClient.
 *
 * @author jestevez
 */
public class ApiHttpClient {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiHttpClient.class);

    /** The Constant DEFAULT_TIMEOUT. */
    private static final int DEFAULT_TIMEOUT = 60;

    /** The proxy configuration. */
    private ProxyConfiguration proxyConfiguration;

    /** The client. */
    private OkHttpClient client;

    /** The http url. */
    private HttpUrl httpUrl;

    /**
     * Instantiates a new api http client.
     *
     * @param url the url
     */
    public ApiHttpClient(String url) {
        this(HttpUrl.parse(url), new ProxyConfiguration());
    }

    /**
     * Instantiates a new api http client.
     *
     * @param httpUrl the http url
     */
    public ApiHttpClient(HttpUrl httpUrl) {
        this(httpUrl, new ProxyConfiguration());
    }

    /**
     * Instantiates a new api http client.
     *
     * @param httpUrl the http url
     * @param proxyConfiguration the proxy configuration
     */
    public ApiHttpClient(HttpUrl httpUrl, ProxyConfiguration proxyConfiguration) {
        this.httpUrl = httpUrl;
        this.proxyConfiguration = proxyConfiguration;
        init();
    }

    /**
     * Inits the ApiHttpClient.
     */
    private void init() {
        if (proxyConfiguration.isEnabled()) {

            // Connect proxy OKHTTP
            Authenticator proxyAuthenticator = new Authenticator() {
                @Override
                public Request authenticate(Route route, Response response) throws IOException {
                    if (response.request().header("Proxy-Authorization") != null) {
                        return null;
                    }
                    if (response.code() == EnumHttpStatusCode.HTTP_PROXY_AUTHENTICATION_REQUIRED.getCode()) {
                        return null;
                    }
                    LOGGER.debug("Authenticating for response: {} ", response);
                    LOGGER.debug("Challenges: {}", response.challenges());
                    String credential = Credentials.basic(proxyConfiguration.getUser(), proxyConfiguration.getPassword());
                    Request request = response.request().newBuilder().header("Proxy-Authorization", credential).build();
                    LOGGER.debug("Request: {}", request);
                    return request;
                }
            };
            Proxy proxy = new Proxy(Proxy.Type.HTTP,
                    new InetSocketAddress(proxyConfiguration.getUrl(), Integer.parseInt(proxyConfiguration.getPort())));
            LOGGER.debug("OkHttpClient with proxy: {}", proxy);
            client = new OkHttpClient.Builder().connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).proxy(proxy).proxyAuthenticator(proxyAuthenticator).build();

        } else {
            client = new OkHttpClient.Builder().connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).proxy(Proxy.NO_PROXY).build();
        }
    }

    /**
     * Send.
     *
     * @param httpType the http type
     * @param headers the headers
     * @return the api http response
     */
    public ApiHttpResponse send(ApiHttpType httpType, Map<String, String> headers) {
        return send(httpType, headers, null, null);
    }

    /**
     * Send.
     *
     * @param httpType the http type
     * @param headers the headers
     * @param stringBody the string body
     * @param apiMediaType the api media type
     * @return the api http response
     */
    public ApiHttpResponse send(ApiHttpType httpType, Map<String, String> headers, String stringBody, ApiHttpMediaType apiMediaType) {

        Request.Builder builder = new Request.Builder();

        builder = builder.url(httpUrl);
        LOGGER.debug("Endpoint {}", httpUrl);
        if (null == httpType) {
            builder = builder.get();
        } else {
            switch (httpType) {
            case POST:
                LOGGER.debug("Send POST raw body {} ", stringBody);
                builder = builder.post(RequestBody.create(MediaType.parse(apiMediaType.getMediaType()), stringBody));
                break;
            case PUT:
                LOGGER.debug("Send PUT raw body {} ", stringBody);
                builder = builder.put(RequestBody.create(MediaType.parse(apiMediaType.getMediaType()), stringBody));
                break;
            case DELETE:
                LOGGER.debug("Send DELETE raw body {} ", stringBody);
                builder = builder.delete(RequestBody.create(MediaType.parse(apiMediaType.getMediaType()), stringBody));
                break;
            default:
                builder = builder.get();
                break;
            }
        }

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null) {
                LOGGER.debug("Send Header key [{}]  value [{}] ", key, value);
                builder = builder.addHeader(key, value);
            }

        }

        Request request = builder.build();
        Response response;
        ApiHttpResponse apiResponse = new ApiHttpResponse();
        try {
            response = client.newCall(request).execute();
            int status = response.code();
            String body = "";
            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                body = responseBody.string();
                apiResponse.setBody(stringBody);
                responseBody.close();
            }
            apiResponse.setBody(body);
            apiResponse.setCode(status);
            LOGGER.debug("code {} body {}", status, body);
        } catch (IOException ex) {
            LOGGER.error("Fail to send {} to Url {} Headers {}, Body {}", httpType, httpUrl, headers, stringBody, ex);
        }
        return apiResponse;

    }

}
