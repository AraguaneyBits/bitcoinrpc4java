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
 * The Class RpcBlockchainMethodsConstants.
 *
 * @author jestevez
 */
public final class RpcBlockchainMethodsConstants {

    /** The Constant BLOCKCHAIN_GET_BESTBLOCK_HASH. */
    public static final String BLOCKCHAIN_GET_BESTBLOCK_HASH = "getbestblockhash";

    /** The Constant BLOCKCHAIN_GET_BLOCK. */
    public static final String BLOCKCHAIN_GET_BLOCK = "getblock";

    /** The Constant BLOCKCHAIN_GET_BLOCKCHAIN_INFO. */
    public static final String BLOCKCHAIN_GET_BLOCKCHAIN_INFO = "getblockchaininfo";

    /** The Constant BLOCKCHAIN_GET_BLOCK_COUNT. */
    public static final String BLOCKCHAIN_GET_BLOCK_COUNT = "getblockcount";

    /** The Constant BLOCKCHAIN_GET_BLOCK_HASH. */
    public static final String BLOCKCHAIN_GET_BLOCK_HASH = "getblockhash";

    /** The Constant BLOCKCHAIN_GET_BLOCK_HEADER. */
    public static final String BLOCKCHAIN_GET_BLOCK_HEADER = "getblockheader";

    /** The Constant BLOCKCHAIN_GET_BLOCK_STATS. */
    public static final String BLOCKCHAIN_GET_BLOCK_STATS = "getblockstats";

    /** The Constant BLOCKCHAIN_GET_CHAIN_TIPS. */
    public static final String BLOCKCHAIN_GET_CHAIN_TIPS = "getchaintips";

    /** The Constant BLOCKCHAIN_GET_CHAIN_TX_STATS. */
    public static final String BLOCKCHAIN_GET_CHAIN_TX_STATS = "getchaintxstats";

    /** The Constant BLOCKCHAIN_GET_DIFFICULTY. */
    public static final String BLOCKCHAIN_GET_DIFFICULTY = "getdifficulty";

    /** The Constant BLOCKCHAIN_GET_MEMPOOL_ANCESTORS. */
    public static final String BLOCKCHAIN_GET_MEMPOOL_ANCESTORS = "getmempoolancestors";

    /** The Constant BLOCKCHAIN_GET_MEMPOOL_DESCENDANTS. */
    public static final String BLOCKCHAIN_GET_MEMPOOL_DESCENDANTS = "getmempooldescendants";

    /** The Constant BLOCKCHAIN_GET_MEMPOOL_ENTRY. */
    public static final String BLOCKCHAIN_GET_MEMPOOL_ENTRY = "getmempoolentry";

    /** The Constant BLOCKCHAIN_GET_MEMPOOL_INFO. */
    public static final String BLOCKCHAIN_GET_MEMPOOL_INFO = "getmempoolinfo";

    /** The Constant BLOCKCHAIN_GET_RAW_MEMPOOL. */
    public static final String BLOCKCHAIN_GET_RAW_MEMPOOL = "getrawmempool";

    /** The Constant BLOCKCHAIN_GET_TXOUT. */
    public static final String BLOCKCHAIN_GET_TXOUT = "gettxout";

    /** The Constant BLOCKCHAIN_GET_TX_OUT_PROOF. */
    public static final String BLOCKCHAIN_GET_TX_OUT_PROOF = "gettxoutproof";

    /** The Constant BLOCKCHAIN_GET_TX_OUT_SET_INFO. */
    public static final String BLOCKCHAIN_GET_TX_OUT_SET_INFO = "gettxoutsetinfo";

    /** The Constant BLOCKCHAIN_PRECIOUS_BLOCK. */
    public static final String BLOCKCHAIN_PRECIOUS_BLOCK = "preciousblock";

    /** The Constant BLOCKCHAIN_PRUNE_BLOCKCHAIN. */
    public static final String BLOCKCHAIN_PRUNE_BLOCKCHAIN = "pruneblockchain";

    /** The Constant BLOCKCHAIN_SAVE_MEMPOOL. */
    public static final String BLOCKCHAIN_SAVE_MEMPOOL = "savemempool";

    /** The Constant BLOCKCHAIN_SCANTXOUTSET. */
    public static final String BLOCKCHAIN_SCANTXOUTSET = "scantxoutset";

    /** The Constant BLOCKCHAIN_VERIFYCHAIN. */
    public static final String BLOCKCHAIN_VERIFYCHAIN = "verifychain";

    /** The Constant BLOCKCHAIN_VERIFYTXOUTPROOF. */
    public static final String BLOCKCHAIN_VERIFYTXOUTPROOF = "verifytxoutproof";

    /** The Constant LEGACY_GET_INFO. */
    public static final String LEGACY_GET_INFO = "getinfo";

    /**
     * Instantiates a new rpc blockchain methods constants.
     */
    private RpcBlockchainMethodsConstants() {
        throw new AssertionError();
    }
}
