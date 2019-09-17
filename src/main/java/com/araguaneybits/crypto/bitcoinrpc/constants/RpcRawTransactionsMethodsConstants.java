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
 * The Class RpcRawTransactionsMethodsConstants.
 *
 * @author jestevez
 */
public final class RpcRawTransactionsMethodsConstants {

    /** The Constant RAW_TRANSACTIONS_ANALYZE_PSBT. */
    public static final String RAW_TRANSACTIONS_ANALYZE_PSBT = "analyzepsbt";

    /** The Constant RAW_TRANSACTIONS_COMBINE_PSBT. */
    public static final String RAW_TRANSACTIONS_COMBINE_PSBT = "combinepsbt";

    /** The Constant RAW_TRANSACTIONS_COMBINE_RAW_TRANSACTION. */
    public static final String RAW_TRANSACTIONS_COMBINE_RAW_TRANSACTION = "combinerawtransaction";

    /** The Constant RAW_TRANSACTIONS_CONVERT_TO_PSBT. */
    public static final String RAW_TRANSACTIONS_CONVERT_TO_PSBT = "converttopsbt";

    /** The Constant RAW_TRANSACTIONS_CREATE_PSBT. */
    public static final String RAW_TRANSACTIONS_CREATE_PSBT = "createpsbt";

    /** The Constant RAW_TRANSACTIONS_CREATE_RAW_TRANSACTION. */
    public static final String RAW_TRANSACTIONS_CREATE_RAW_TRANSACTION = "createrawtransaction";

    /** The Constant RAW_TRANSACTIONS_DECODE_PSBT. */
    public static final String RAW_TRANSACTIONS_DECODE_PSBT = "decodepsbt";

    /** The Constant RAW_TRANSACTIONS_DECODE_RAW_TRANSACTION. */
    public static final String RAW_TRANSACTIONS_DECODE_RAW_TRANSACTION = "decoderawtransaction";

    /** The Constant RAW_TRANSACTIONS_DECODE_SCRIPT. */
    public static final String RAW_TRANSACTIONS_DECODE_SCRIPT = "decodescript";

    /** The Constant RAW_TRANSACTIONS_FINALIZE_PSBT. */
    public static final String RAW_TRANSACTIONS_FINALIZE_PSBT = "finalizepsbt";

    /** The Constant RAW_TRANSACTIONS_FUNDRAW_TRANSACTION. */
    public static final String RAW_TRANSACTIONS_FUNDRAW_TRANSACTION = "fundrawtransaction";

    /** The Constant RAW_TRANSACTIONS_GET_RAW_TRANSACTION. */
    public static final String RAW_TRANSACTIONS_GET_RAW_TRANSACTION = "getrawtransaction";

    /** The Constant RAW_TRANSACTIONS_JOIN_PSBTS. */
    public static final String RAW_TRANSACTIONS_JOIN_PSBTS = "joinpsbts";

    /** The Constant RAW_TRANSACTIONS_SEND_RAW_TRANSACTION. */
    public static final String RAW_TRANSACTIONS_SEND_RAW_TRANSACTION = "sendrawtransaction";

    /** The Constant RAW_TRANSACTIONS_SIGN_RAW_TRANSACTION_WITH_KEY. */
    public static final String RAW_TRANSACTIONS_SIGN_RAW_TRANSACTION_WITH_KEY = "signrawtransactionwithkey";

    /** The Constant RAW_TRANSACTIONS_TEST_MEMPOOL_ACCEPT. */
    public static final String RAW_TRANSACTIONS_TEST_MEMPOOL_ACCEPT = "testmempoolaccept";

    /** The Constant RAW_TRANSACTIONS_UTXO_UPDATE_PSBT. */
    public static final String RAW_TRANSACTIONS_UTXO_UPDATE_PSBT = "utxoupdatepsbt";

    /**
     * Instantiates a new rpc raw transactions methods constants.
     */
    private RpcRawTransactionsMethodsConstants() {
        throw new AssertionError();
    }
}
