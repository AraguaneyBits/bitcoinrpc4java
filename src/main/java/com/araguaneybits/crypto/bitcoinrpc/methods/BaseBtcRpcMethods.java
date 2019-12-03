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

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

import com.araguaneybits.crypto.bitcoinrpc.constants.EnumRpcErrorCode;
import com.araguaneybits.crypto.bitcoinrpc.constants.RpcConstants;
import com.araguaneybits.crypto.bitcoinrpc.exception.BtcRpcBaseException;
import com.araguaneybits.crypto.bitcoinrpc.exception.InsufficientFundsException;
import com.araguaneybits.crypto.bitcoinrpc.exception.RpcMethodNotFoundException;
import com.araguaneybits.crypto.utils.TransformBeanUtils;

/**
 * The Class BaseBtcRpcMethods.
 *
 * @author jestevez
 */
public class BaseBtcRpcMethods {

    /** The btc rpc gateway. */
    private BtcRpcGateway btcRpcGateway;

    /**
     * Instantiates a new base btc rpc methods.
     *
     * @param btcRpcGateway the btc rpc gateway
     */
    protected BaseBtcRpcMethods(BtcRpcGateway btcRpcGateway) {
        super();
        this.btcRpcGateway = btcRpcGateway;
    }

    /**
     * Read generic values.
     *
     * @param json the json
     * @return the map
     */
    protected Map<Object, Object> readGenericValues(String json) {
        return TransformBeanUtils.readValue(json, LinkedHashMap.class);
    }

    /**
     * Check exception.
     *
     * @param json the json
     */
    protected void checkException(String json) {
        Map<Object, Object> response = readGenericValues(json);
        if (response.get(RpcConstants.RPC_ERROR) != null) {
            LinkedHashMap<Object, Object> errorJson = (LinkedHashMap) response.get(RpcConstants.RPC_ERROR);
            String message = (String) errorJson.get(RpcConstants.RPC_MESSAGE);
            BigInteger code = (BigInteger) errorJson.get(RpcConstants.RPC_CODE);

            if (EnumRpcErrorCode.RPC_WALLET_INSUFFICIENT_FUNDS.getCode().equals(code)) {
                throw new InsufficientFundsException(message);
            } else if (EnumRpcErrorCode.RPC_METHOD_NOT_FOUND.getCode().equals(code)) {
                throw new RpcMethodNotFoundException(message);
            } else {
                throw new BtcRpcBaseException(message, code.intValue());
            }

        }
    }

    /**
     * Call rpc method.
     *
     * @param callMethod the call method
     * @param params the params
     * @return the object
     */
    protected Object callRpcMethod(String callMethod, Object... params) {
        String json = getBtcRpcGateway().callRpcApiMethod(callMethod, params);
        checkException(json);
        Map<Object, Object> response = readGenericValues(json);
        return response.get(RpcConstants.RPC_RESULT);
    }

    /**
     * Call simple rpc method.
     *
     * @param callMethod the call method
     * @param params the params
     * @return the string
     */
    protected String callSimpleRpcMethod(String callMethod, Object... params) {
        String json = getBtcRpcGateway().callRpcApiMethod(callMethod, params);
        checkException(json);
        return json;
    }

    /**
     * Gets the btc rpc gateway.
     *
     * @return the btc rpc gateway
     */
    public BtcRpcGateway getBtcRpcGateway() {
        return btcRpcGateway;
    }

}
