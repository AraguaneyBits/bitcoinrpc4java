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
 * The Class RpcUtilMethodsConstants.
 *
 * @author jestevez
 */
public final class RpcUtilMethodsConstants {

    /** The Constant UTIL_CREATE_MULTISIG. */
    public static final String UTIL_CREATE_MULTISIG = "createmultisig";

    /** The Constant UTIL_DERIVE_ADDRESSES. */
    public static final String UTIL_DERIVE_ADDRESSES = "deriveaddresses";

    /** The Constant UTIL_ESTIMATE_RAWFEE. */
    public static final String UTIL_ESTIMATE_RAWFEE = "estimaterawfee";

    /** The Constant UTIL_ESTIMATE_SMART_FEE. */
    public static final String UTIL_ESTIMATE_SMART_FEE = "estimatesmartfee";

    /** The Constant UTIL_GET_DESCRIPTOR_INFO. */
    public static final String UTIL_GET_DESCRIPTOR_INFO = "getdescriptorinfo";

    /** The Constant UTIL_SIGN_MESSAGE_WITH_PRIVKEY. */
    public static final String UTIL_SIGN_MESSAGE_WITH_PRIVKEY = "signmessagewithprivkey";

    /** The Constant UTIL_VALIDATE_ADDRESS. */
    public static final String UTIL_VALIDATE_ADDRESS = "validateaddress";

    /** The Constant UTIL_VERIFY_MESSAGE. */
    public static final String UTIL_VERIFY_MESSAGE = "verifymessage";

    /**
     * Instantiates a new rpc util methods constants.
     */
    private RpcUtilMethodsConstants() {
        throw new AssertionError();
    }
}
