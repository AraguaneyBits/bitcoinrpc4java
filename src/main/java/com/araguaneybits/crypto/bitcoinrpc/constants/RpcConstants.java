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
package com.araguaneybits.crypto.bitcoinrpc.constants;

/**
 * The Class RpcConstants.
 *
 * @author jestevez
 */
public final class RpcConstants {

    /** The Constant RPC_RESULT. */
    public static final String RPC_RESULT = "result";

    /** The Constant RPC_ERROR. */
    public static final String RPC_ERROR = "error";

    /** The Constant RPC_MESSAGE. */
    public static final String RPC_MESSAGE = "message";

    /** The Constant RPC_CODE. */
    public static final String RPC_CODE = "code";

    /**
     * Instantiates a new rpc constants.
     */
    private RpcConstants() {
        throw new AssertionError();
    }
}
