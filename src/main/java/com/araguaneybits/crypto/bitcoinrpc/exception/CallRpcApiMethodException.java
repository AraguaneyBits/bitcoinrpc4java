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
package com.araguaneybits.crypto.bitcoinrpc.exception;

/**
 * The Class CallRpcApiMethodException.
 *
 * @author jestevez
 */
public class CallRpcApiMethodException extends BtcRpcBaseException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1260555831989404613L;

    /**
     * Instantiates a new call rpc api method exception.
     *
     * @param message the message
     * @param code the code
     */
    public CallRpcApiMethodException(String message, Integer code) {
        super(message, code);
    }

    /**
     * Instantiates a new call rpc api method exception.
     *
     * @param message the message
     */
    public CallRpcApiMethodException(String message) {
        super(message);
    }

}
