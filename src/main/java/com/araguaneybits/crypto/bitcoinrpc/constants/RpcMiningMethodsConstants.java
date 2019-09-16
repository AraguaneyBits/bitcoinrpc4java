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
 * The Class RpcMiningMethodsConstants.
 *
 * @author jestevez
 */
public final class RpcMiningMethodsConstants {

    /** The Constant MINING_GET_BLOCK_TEMPLATE. */
    public static final String MINING_GET_BLOCK_TEMPLATE = "getblocktemplate";

    /** The Constant MINING_GET_MINING_INFO. */
    public static final String MINING_GET_MINING_INFO = "getmininginfo";

    /** The Constant MINING_GET_NETWORK_HASHPS. */
    public static final String MINING_GET_NETWORK_HASHPS = "getnetworkhashps";

    /** The Constant MINING_PRIORITISE_TRANSACTION. */
    public static final String MINING_PRIORITISE_TRANSACTION = "prioritisetransaction";

    /** The Constant MINING_SUBMIT_BLOCK. */
    public static final String MINING_SUBMIT_BLOCK = "submitblock";

    /** The Constant MINING_SUBMIT_HEADER. */
    public static final String MINING_SUBMIT_HEADER = "submitheader";

    /** The Constant GENERATING_GENERATE_TO_ADDRESS. */
    public static final String GENERATING_GENERATE_TO_ADDRESS = "generatetoaddress";

    /**
     * Instantiates a new rpc mining methods constants.
     */
    private RpcMiningMethodsConstants() {
        throw new AssertionError();
    }
}
