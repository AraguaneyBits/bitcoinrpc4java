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
 * The Enum APICalls. Original Bitcoin reference https://en.bitcoin.it/wiki/Original_Bitcoin_client/API_calls_list
 *
 * @author Jose Luis Estevez jose.estevez.prieto@gmail.com
 */
public final class RpcWalletMethodsConstants {

    /** The Constant WALLET_ABANDON_TRANSACTION. */
    public static final String WALLET_ABANDON_TRANSACTION = "abandontransaction";

    /** The Constant WALLET_ABORTRESCAN. */
    public static final String WALLET_ABORTRESCAN = "abortrescan";

    /** The Constant WALLET_ADD_MULTI_SIG_ADDRESS. */
    public static final String WALLET_ADD_MULTI_SIG_ADDRESS = "addmultisigaddress";

    /** The Constant WALLET_BACKUP_WALLET. */
    public static final String WALLET_BACKUP_WALLET = "backupwallet";

    /** The Constant WALLET_BUMP_FEE. */
    public static final String WALLET_BUMP_FEE = "bumpfee";

    /** The Constant WALLET_CREATE_WALLET. */
    public static final String WALLET_CREATE_WALLET = "createwallet";

    /** The Constant WALLET_DUMP_PRIVKEY. */
    public static final String WALLET_DUMP_PRIVKEY = "dumpprivkey";

    /** The Constant WALLET_DUMP_WALLET. */
    public static final String WALLET_DUMP_WALLET = "dumpwallet";

    /** The Constant WALLET_ENCRYPT_WALLET. */
    public static final String WALLET_ENCRYPT_WALLET = "encryptwallet";

    /** The Constant WALLET_GET_ADDRESSES_BY_LABEL. */
    public static final String WALLET_GET_ADDRESSES_BY_LABEL = "getaddressesbylabel";

    /** The Constant WALLET_GET_ADDRESS_INFO. */
    public static final String WALLET_GET_ADDRESS_INFO = "getaddressinfo";

    /** The Constant WALLET_GET_BALANCE. */
    public static final String WALLET_GET_BALANCE = "getbalance";

    /** The Constant WALLET_GET_BALANCES. */
    public static final String WALLET_GET_BALANCES = "getbalances";

    /** The Constant WALLET_GET_NEW_ADDRESS. */
    public static final String WALLET_GET_NEW_ADDRESS = "getnewaddress";

    /** The Constant WALLET_GET_RAW_CHANGE_ADDRESS. */
    public static final String WALLET_GET_RAW_CHANGE_ADDRESS = "getrawchangeaddress";

    /** The Constant WALLET_GET_RECEIVED_BY_ADDRESS. */
    public static final String WALLET_GET_RECEIVED_BY_ADDRESS = "getreceivedbyaddress";

    /** The Constant WALLET_GET_RECEIVED_BY_LABEL. */
    public static final String WALLET_GET_RECEIVED_BY_LABEL = "getreceivedbylabel";

    /** The Constant WALLET_GET_TRANSACTION. */
    public static final String WALLET_GET_TRANSACTION = "gettransaction";

    /** The Constant WALLET_GET_UNCONFIRMED_BALANCE. */
    public static final String WALLET_GET_UNCONFIRMED_BALANCE = "getunconfirmedbalance";

    /** The Constant WALLET_GET_WALLET_INFO. */
    public static final String WALLET_GET_WALLET_INFO = "getwalletinfo";

    /** The Constant WALLET_IMPORT_ADDRESS. */
    public static final String WALLET_IMPORT_ADDRESS = "importaddress";

    /** The Constant WALLET_IMPORT_MULTI. */
    public static final String WALLET_IMPORT_MULTI = "importmulti";

    /** The Constant WALLET_IMPORT_PRIVKEY. */
    public static final String WALLET_IMPORT_PRIVKEY = "importprivkey";

    /** The Constant WALLET_IMPORT_PRUNED_FUNDS. */
    public static final String WALLET_IMPORT_PRUNED_FUNDS = "importprunedfunds";

    /** The Constant WALLET_IMPORT_PUBKEY. */
    public static final String WALLET_IMPORT_PUBKEY = "importpubkey";

    /** The Constant WALLET_IMPORT_WALLET. */
    public static final String WALLET_IMPORT_WALLET = "importwallet";

    /** The Constant WALLET_KEYPOOL_REFILL. */
    public static final String WALLET_KEYPOOL_REFILL = "keypoolrefill";

    /** The Constant WALLET_LIST_LABELS. */
    public static final String WALLET_LIST_LABELS = "listlabels";

    /** The Constant WALLET_LIST_LOCK_UNSPENT. */
    public static final String WALLET_LIST_LOCK_UNSPENT = "listlockunspent";

    /** The Constant WALLET_LIST_RECEIVED_BY_ADDRESS. */
    public static final String WALLET_LIST_RECEIVED_BY_ADDRESS = "listreceivedbyaddress";

    /** The Constant WALLET_LIST_RECEIVED_BY_LABEL. */
    public static final String WALLET_LIST_RECEIVED_BY_LABEL = "listreceivedbylabel";

    /** The Constant WALLET_LIST_SINCE_BLOCK. */
    public static final String WALLET_LIST_SINCE_BLOCK = "listsinceblock";

    /** The Constant WALLET_LIST_TRANSACTIONS. */
    public static final String WALLET_LIST_TRANSACTIONS = "listtransactions";

    /** The Constant WALLET_LIST_UNSPENT. */
    public static final String WALLET_LIST_UNSPENT = "listunspent";

    /** The Constant WALLET_LIST_WALLET_DIR. */
    public static final String WALLET_LIST_WALLET_DIR = "listwalletdir";

    /** The Constant WALLET_LIST_WALLETS. */
    public static final String WALLET_LIST_WALLETS = "listwallets";

    /** The Constant WALLET_LOAD_WALLET. */
    public static final String WALLET_LOAD_WALLET = "loadwallet";

    /** The Constant WALLET_LOCK_UNSPENT. */
    public static final String WALLET_LOCK_UNSPENT = "lockunspent";

    /** The Constant WALLET_REMOVE_PRUNED_FUNDS. */
    public static final String WALLET_REMOVE_PRUNED_FUNDS = "removeprunedfunds";

    /** The Constant WALLET_RESCAN_BLOCKCHAIN. */
    public static final String WALLET_RESCAN_BLOCKCHAIN = "rescanblockchain";

    /** The Constant WALLET_SEND_MANY. */
    public static final String WALLET_SEND_MANY = "sendmany";

    /** The Constant WALLET_SEND_TO_ADDRESS. */
    public static final String WALLET_SEND_TO_ADDRESS = "sendtoaddress";

    /** The Constant WALLET_SET_HD_SEED. */
    public static final String WALLET_SET_HD_SEED = "sethdseed";

    /** The Constant WALLET_SET_LABEL. */
    public static final String WALLET_SET_LABEL = "setlabel";

    /** The Constant WALLET_SET_TX_FEE. */
    public static final String WALLET_SET_TX_FEE = "settxfee";

    /** The Constant WALLET_SIGN_MESSAGE. */
    public static final String WALLET_SIGN_MESSAGE = "signmessage";

    /** The Constant WALLET_SIGN_RAW_TRANSACTION_WITH_WALLET. */
    public static final String WALLET_SIGN_RAW_TRANSACTION_WITH_WALLET = "signrawtransactionwithwallet";

    /** The Constant WALLET_UNLOAD_WALLET. */
    public static final String WALLET_UNLOAD_WALLET = "unloadwallet";

    /** The Constant WALLET_WALLET_CREATE_FUNDED_PSBT. */
    public static final String WALLET_WALLET_CREATE_FUNDED_PSBT = "walletcreatefundedpsbt";

    /** The Constant WALLET_WALLET_LOCK. */
    public static final String WALLET_WALLET_LOCK = "walletlock";

    /** The Constant WALLET_WALLET_PASSPHRASE. */
    public static final String WALLET_WALLET_PASSPHRASE = "walletpassphrase";

    /** The Constant WALLET_WALLET_PASSPHRASE_CHANGE. */
    public static final String WALLET_WALLET_PASSPHRASE_CHANGE = "walletpassphrasechange";

    /** The Constant WALLET_WALLET_PROCESS_PSBT. */
    public static final String WALLET_WALLET_PROCESS_PSBT = "walletprocesspsbt";

    /**
     * Instantiates a new rpc wallet methods constants.
     */
    private RpcWalletMethodsConstants() {
        throw new AssertionError();
    }

}
