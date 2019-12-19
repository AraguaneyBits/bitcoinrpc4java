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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.araguaneybits.crypto.bitcoinrpc.RpcOutputMessage;
import com.araguaneybits.crypto.bitcoinrpc.constants.RpcWalletMethodsConstants;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcCreateWalletResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetWalletInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListSinceBlockResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcLoadWalletResponse;
import com.araguaneybits.crypto.utils.TransformBeanUtils;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * The Class BtcRpcWalletToolsMethods.
 *
 * @author jestevez
 */
public class BtcRpcWalletToolsMethods extends BaseBtcRpcMethods {

    /**
     * Instantiates a new btc rpc wallet tools methods.
     *
     * @param btcRpcGateway the btc rpc gateway
     */
    public BtcRpcWalletToolsMethods(BtcRpcGateway btcRpcGateway) {
        super(btcRpcGateway);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.15.0
     * </p>
     * <p>
     * The abortrescan RPC stops current wallet rescan triggered by an RPC call, e.g. by an importprivkey call.
     * </p>
     * 
     * <pre>
     *     abortrescan
     *     
     *     Stops current wallet rescan triggered by an RPC call, e.g. by an importprivkey call.
     *     
     *     Examples:
     *     
     *     Import a private key
    *       bitcoin-cli importprivkey "mykey"
     *     
     *     Abort the running wallet rescan
    *       bitcoin-cli abortrescan 
     *     
     *     As a JSON-RPC call
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "abortrescan", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the boolean
     */
    public Boolean abortRescan() {
        return (Boolean) callRpcMethod(RpcWalletMethodsConstants.WALLET_ABORTRESCAN);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.3.12
     * </p>
     * <p>
     * The backupwallet RPC safely copies `wallet.dat` to the specified file, which can be a directory or a path with filename.
     * </p>
     * 
     * <pre>
     *     backupwallet "destination"
     *     
     *     Safely copies current wallet file to destination, which can be a directory or a path with filename.
     *     
     *     Arguments:
     *     1. "destination"   (string) The destination directory or file
     *     
     *     Examples:
    *       bitcoin-cli backupwallet "backup.dat"
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "backupwallet", "params": ["backup.dat"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param destination the destination
     * @return the boolean
     */
    public Boolean backupWallet(String destination) {
        callRpcMethod(RpcWalletMethodsConstants.WALLET_BACKUP_WALLET, destination);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The createwallet RPC creates and loads a new wallet.
     * </p>
     * 
     * <pre>
     *   
     *     createwallet "wallet_name" ( disable_private_keys blank )
     *     
     *     Creates and loads a new wallet.
     *     
     *     Arguments:
     *     1. wallet_name             (string, required) The name for the new wallet. If this is a path, the wallet will be created at the path location.
     *     2. disable_private_keys    (boolean, optional, default=false) Disable the possibility of private keys (only watchonlys are possible in this mode).
     *     3. blank                   (boolean, optional, default=false) Create a blank wallet. A blank wallet has no keys or HD seed. One can be set using sethdseed.
     *     
     *     Result:
     *     {
     *     "name" :    ,        (string) The wallet name if created successfully. If the wallet was created using a full path, the wallet_name will be the full path.
     *     "warning" : ,            (string) Warning message if wallet was not loaded cleanly.
     *     }
     *     
     *     Examples:
    *       bitcoin-cli createwallet "testwallet"
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "createwallet", "params": ["testwallet"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param walletName the wallet name
     * @param disablePrivateKeys the disable private keys
     * @param blank the blank
     * @return the btc rpc create wallet response
     */
    public BtcRpcCreateWalletResponse createWallet(String walletName, Boolean disablePrivateKeys, Boolean blank) {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_CREATE_WALLET, walletName, disablePrivateKeys, blank);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcCreateWalletResponse>>() {
                });
        return (BtcRpcCreateWalletResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.9.0
     * </p>
     * <p>
     * The dumpwallet RPC creates or overwrites a file with all wallet keys in a human-readable format.
     * </p>
     * 
     * <pre>
     *     dumpwallet "filename"
     *     
     *     Dumps all wallet keys in a human-readable format to a server-side file. This does not allow overwriting existing files.
     *     Imported scripts are included in the dumpfile, but corresponding BIP173 addresses, etc. may not be added automatically by importwallet.
     *     Note that if your wallet contains keys which are not derived from your HD seed (e.g. imported keys), these are not covered by
     *     only backing up the seed itself, and must be backed up too (e.g. ensure you back up the whole dumpfile).
     *     
     *     Arguments:
     *     1. "filename"    (string, required) The filename with path (either absolute or relative to bitcoind)
     *     
     *     Result:
     *     {                           (json object)
     *     "filename" : {        (string) The filename with full absolute path
     *     }
     *     
     *     Examples:
    *       bitcoin-cli dumpwallet "test"
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "dumpwallet", "params": ["test"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param filename the filename
     * @return the string
     */
    public String dumpWallet(String filename) {
        Map<String, String> response = (Map<String, String>) callRpcMethod(RpcWalletMethodsConstants.WALLET_DUMP_WALLET, filename);
        return response.get("filename");
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.4.0
     * </p>
     * <p>
     * The encryptwallet RPC encrypts the wallet with a passphrase. This is only to enable encryption for the first time. After encryption is enabled,
     * you will need to enter the passphrase to use private keys.
     * </p>
     * 
     * <pre>
     *     encryptwallet "passphrase"
     *     
     *     Encrypts the wallet with 'passphrase'. This is for first time encryption.
     *     After this, any calls that interact with private keys such as sending or signing 
     *     will require the passphrase to be set prior the making these calls.
     *     Use the walletpassphrase call for this, and then walletlock call.
     *     If the wallet is already encrypted, use the walletpassphrasechange call.
     *     Note that this will shutdown the server.
     *     
     *     Arguments:
     *     1. "passphrase"    (string) The pass phrase to encrypt the wallet with. It must be at least 1 character, but should be long.
     *     
     *     Examples:
     *     
     *     Encrypt your wallet
    *       bitcoin-cli encryptwallet "my pass phrase"
     *     
     *     Now set the passphrase to use the wallet, such as for signing or sending bitcoin
    *       bitcoin-cli walletpassphrase "my pass phrase"
     *     
     *     Now we can do something like sign
    *       bitcoin-cli signmessage "address" "test message"
     *     
     *     Now lock the wallet again by removing the passphrase
    *       bitcoin-cli walletlock 
     *     
     *     As a json rpc call
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "encryptwallet", "params": ["my pass phrase"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param passphrase the passphrase
     * @return the boolean
     */
    public Boolean encryptWallet(String passphrase) {
        callRpcMethod(RpcWalletMethodsConstants.WALLET_ENCRYPT_WALLET, passphrase);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.9.2.1
     * </p>
     * <p>
     * The getwalletinfo RPC provides information about the wallet.
     * </p>
     * 
     * <pre>
     *     getwalletinfo
     *     Returns an object containing various wallet state info.
     *     
     *     Result:
     *     {
     *     "walletname": xxxxx,               (string) the wallet name
     *     "walletversion": xxxxx,            (numeric) the wallet version
     *     "balance": xxxxxxx,                (numeric) the total confirmed balance of the wallet in BTC
     *     "unconfirmed_balance": xxx,        (numeric) the total unconfirmed balance of the wallet in BTC
     *     "immature_balance": xxxxxx,        (numeric) the total immature balance of the wallet in BTC
     *     "txcount": xxxxxxx,                (numeric) the total number of transactions in the wallet
     *     "keypoololdest": xxxxxx,           (numeric) the timestamp (seconds since Unix epoch) of the oldest pre-generated key in the key pool
     *     "keypoolsize": xxxx,               (numeric) how many new keys are pre-generated (only counts external keys)
     *     "keypoolsize_hd_internal": xxxx,   (numeric) how many new keys are pre-generated for internal use (used for change outputs, only appears if the wallet is using this feature, otherwise external keys are used)
     *     "unlocked_until": ttt,             (numeric) the timestamp in seconds since epoch (midnight Jan 1 1970 GMT) that the wallet is unlocked for transfers, or 0 if the wallet is locked
     *     "paytxfee": x.xxxx,                (numeric) the transaction fee configuration, set in BTC/kB
     *     "hdseedid": ""            (string, optional) the Hash160 of the HD seed (only present when HD is enabled)
     *     "hdmasterkeyid": ""       (string, optional) alias for hdseedid retained for backwards-compatibility. Will be removed in V0.18.
     *     "private_keys_enabled": true|false (boolean) false if privatekeys are disabled for this wallet (enforced watch-only wallet)
     *     }
     *     
     *     Examples:
    *       bitcoin-cli getwalletinfo 
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getwalletinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the wallet info
     */
    public BtcRpcGetWalletInfoResponse getWalletInfo() {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_GET_WALLET_INFO);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetWalletInfoResponse>>() {
                });
        return (BtcRpcGetWalletInfoResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.9.0
     * </p>
     * <p>
     * The importwallet RPC imports private keys from a file in wallet dump file format (see the `dumpwallet` RPC). These keys will be added to the
     * keys currently in the wallet. This call may need to rescan all or parts of the block chain for transactions affecting the newly-added keys,
     * which may take several minutes.
     * </p>
     * <p>
     * Imports keys from a wallet dump file (see dumpwallet). Requires a new wallet backup to include imported keys.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "filename" (string, required) The wallet file
     * </p>
     *
     * @param filename the filename
     * @return the boolean
     */
    public Boolean importWallet(String filename) {
        callRpcMethod(RpcWalletMethodsConstants.WALLET_IMPORT_WALLET, filename);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: &lt; 0.9.0
     * </p>
     * <p>
     * Fills the keypool. The keypoolrefill RPC fills the cache of unused pre-generated keys (the keypool). *
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. newsize (numeric, optional, default=100) The new keypool size
     * </p>
     *
     * @param newsize the newsize
     * @return the boolean
     */
    public Boolean keypoolRefill(Long newsize) {
        callRpcMethod(RpcWalletMethodsConstants.WALLET_KEYPOOL_REFILL, newsize);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.5.0
     * </p>
     * <p>
     * The listsinceblock RPC gets all transactions affecting the wallet which have occurred since a particular block, plus the header hash of a block
     * at a particular depth.
     * </p>
     * <p>
     * Get all transactions in blocks since block [blockhash], or all transactions if omitted. If "blockhash" is no longer a part of the main chain,
     * transactions from the fork point onward are included. Additionally, if include_removed is set, transactions affecting the wallet which were
     * removed are returned in the "removed" array.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "blockhash" (string, optional) The block hash to list transactions since
     * </p>
     * <p>
     * 2. target_confirmations: (numeric, optional, default=1) Return the nth block hash from the main chain. e.g. 1 would mean the best block hash.
     * Note: this is not used as a filter, but only affects [lastblock] in the return value
     * </p>
     * <p>
     * 3. include_watchonly: (bool, optional, default=false) Include transactions to watch-only addresses (see 'importaddress')
     * </p>
     * <p>
     * 4. include_removed: (bool, optional, default=true) Show transactions that were removed due to a reorg in the "removed" array
     * </p>
     * 
     * <pre>
     *     Result:
     *     {
     *     "transactions": [
     *     "account":"accountname",       (string) DEPRECATED. This field will be removed in V0.18. To see this deprecated field, start bitcoind with -deprecatedrpc=accounts. The account name associated with the transaction. Will be "" for the default account.
     *     "address":"address",    (string) The bitcoin address of the transaction. Not present for move transactions (category = move).
     *     "category":"send|receive",     (string) The transaction category. 'send' has negative amounts, 'receive' has positive amounts.
     *     "amount": x.xxx,          (numeric) The amount in BTC. This is negative for the 'send' category, and for the 'move' category for moves 
     *                                           outbound. It is positive for the 'receive' category, and for the 'move' category for inbound funds.
     *     "vout" : n,               (numeric) the vout value
     *     "fee": x.xxx,             (numeric) The amount of the fee in BTC. This is negative and only available for the 'send' category of transactions.
     *     "confirmations": n,       (numeric) The number of confirmations for the transaction. Available for 'send' and 'receive' category of transactions.
     *                                           When it's &lt; 0, it means the transaction conflicted that many blocks ago.
     *     "blockhash": "hashvalue",     (string) The block hash containing the transaction. Available for 'send' and 'receive' category of transactions.
     *     "blockindex": n,          (numeric) The index of the transaction in the block that includes it. Available for 'send' and 'receive' category of transactions.
     *     "blocktime": xxx,         (numeric) The block time in seconds since epoch (1 Jan 1970 GMT).
     *     "txid": "transactionid",  (string) The transaction id. Available for 'send' and 'receive' category of transactions.
     *     "time": xxx,              (numeric) The transaction time in seconds since epoch (Jan 1 1970 GMT).
     *     "timereceived": xxx,      (numeric) The time received in seconds since epoch (Jan 1 1970 GMT). Available for 'send' and 'receive' category of transactions.
     *     "bip125-replaceable": "yes|no|unknown",  (string) Whether this transaction could be replaced due to BIP125 (replace-by-fee);
     *                                                    may be unknown for unconfirmed transactions not in the mempool
     *     "abandoned": xxx,         (bool) 'true' if the transaction has been abandoned (inputs are respendable). Only available for the 'send' category of transactions.
     *     "comment": "...",       (string) If a comment is associated with the transaction.
     *     "label" : "label"       (string) A comment for the address/transaction, if any
     *     "to": "...",            (string) If a comment to is associated with the transaction.
     *     ],
     *     "removed": [
     *     
     *     Note: transactions that were re-added in the active chain will appear as-is in this array, and may thus have a positive confirmation count.
     *     ],
     *     "lastblock": "lastblockhash"     (string) The hash of the block (target_confirmations-1) from the best block on the main chain. This is typically used to feed back into listsinceblock the next time you call it. So you would generally use a target_confirmations of say 6, so you will be continually re-notified of transactions until they've reached 6 confirmations plus any new ones
     *     }
     * </pre>
     *
     * @param blockhash the blockhash
     * @param targetConfirmations the target confirmations
     * @param includeWatchonly the include watchonly
     * @param includeRemoved the include removed
     * @return the btc rpc list since block response
     */
    public BtcRpcListSinceBlockResponse listSinceBlock(String blockhash, Long targetConfirmations, Boolean includeWatchonly, Boolean includeRemoved) {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_LIST_SINCE_BLOCK, blockhash, targetConfirmations, includeWatchonly,
                includeRemoved);
        return getBtcRpcListSinceBlockResponse(json);
    }

    /**
     * List since block.
     *
     * @return the btc rpc list since block response
     */
    public BtcRpcListSinceBlockResponse listSinceBlock() {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_LIST_SINCE_BLOCK);
        return getBtcRpcListSinceBlockResponse(json);
    }

    /**
     * Gets the btc rpc list since block response.
     *
     * @param json the json
     * @return the btc rpc list since block response
     */
    private BtcRpcListSinceBlockResponse getBtcRpcListSinceBlockResponse(String json) {
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcListSinceBlockResponse>>() {
                });
        return (BtcRpcListSinceBlockResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.15.0
     * </p>
     * <p>
     * The listwallets RPC returns a list of currently loaded wallets.
     * </p>
     * <p>
     * Returns a list of currently loaded wallets. For full information on the wallet, use "getwalletinfo"
     * </p>
     * 
     * <pre>
     *     Result:
     *     [                         (json array of strings)
     *     "walletname"            (string) the wallet name
     *     ...
     *     ]
     * </pre>
     *
     * @return the list
     */
    public List<String> listWallets() {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_LIST_WALLETS);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<ArrayList<String>>>() {
                });
        return (ArrayList<String>) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.18.0
     * </p>
     * <p>
     * The listwalletdir RPC returns a list of wallets in the wallet directory (either the default wallet directory or the directory configured by the
     * -walletdir parameter).
     * </p>
     * <p>
     * Returns a list of wallets in the wallet directory.
     * </p>
     * 
     * <pre>
     *     Result:
     *     {
     *     "wallets" : [                (json array of objects)
     *     {
     *       "name" : "name"          (string) The wallet name
     *     }
     *     ,...
     *     ]
     *     }
     * </pre>
     *
     * @return the list
     */
    public List<String> listWalletDir() {
        List<String> list = new ArrayList<>();
        Map<String, Map> response = (Map<String, Map>) callRpcMethod(RpcWalletMethodsConstants.WALLET_LIST_WALLET_DIR);
        List<Map> names = ((List) response.get("wallets"));
        for (Map<String, String> map : names) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                list.add(entry.getValue());
            }
        }
        return list;
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The loadwallet RPC loads a wallet from a wallet file or directory.
     * </p>
     * <p>
     * Loads a wallet from a wallet file or directory. Note that all wallet command-line options used when starting bitcoind will be applied to the
     * new wallet (eg -zapwallettxes, upgradewallet, rescan, etc).
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "filename" (string, required) The wallet directory or .dat file.
     * </p>
     * 
     * <pre>
     *     Result:
     *     {
     *     "name" :    ,        (string) The wallet name if loaded successfully.
     *     "warning" : ,            (string) Warning message if wallet was not loaded cleanly.
     *     }
     * </pre>
     *
     * @param name the name
     * @return the btc rpc load wallet response
     */
    public BtcRpcLoadWalletResponse loadWallet(String name) {

        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_LOAD_WALLET, name);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcLoadWalletResponse>>() {
                });
        return (BtcRpcLoadWalletResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.16.0
     * </p>
     * <p>
     * The rescanblockchain RPC rescan the local blockchain for wallet related transactions.
     * </p>
     * <p>
     * Rescan the local blockchain for wallet related transactions.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "start_height" (numeric, optional) block height where the rescan should start
     * </p>
     * <p>
     * 2. "stop_height" (numeric, optional) the last block height that should be scanned
     * </p>
     * 
     * <pre>
     *     Result:
     *     {
     *     "start_height"     (numeric) The block height where the rescan has started. If omitted, rescan started from the genesis block.
     *     "stop_height"      (numeric) The height of the last rescanned block. If omitted, rescan stopped at the chain tip.
     *     }
     * </pre>
     *
     * @param startHeight the start height
     * @param stopHeight the stop height
     * @return the boolean
     */
    public Boolean rescanBlockchain(Long startHeight, Long stopHeight) {
        callRpcMethod(RpcWalletMethodsConstants.WALLET_RESCAN_BLOCKCHAIN, startHeight, stopHeight);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The sethdseed RPC allows users to set a new HD seed or set their own HD seed. This allows for a new HD seed to be used. A new backup must be
     * made when a new HD seed is set.
     * </p>
     * <p>
     * Set or generate a new HD wallet seed. Non-HD wallets will not be upgraded to being a HD wallet. Wallets that are already HD will have a new HD
     * seed set so that new keys added to the keypool will be derived from this new seed. Note that you will need to MAKE A NEW BACKUP of your wallet
     * after setting the HD wallet seed.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "newkeypool" (boolean, optional, default=true) Whether to flush old unused addresses, including change addresses, from the keypool and
     * regenerate it. If true, the next address from getnewaddress and change address from getrawchangeaddress will be from this new seed. If false,
     * addresses (including change addresses if the wallet already had HD Chain Split enabled) from the existing keypool will be used until it has
     * been depleted.
     * </p>
     * <p>
     * 2. "seed" (string, optional) The WIF private key to use as the new HD seed; if not provided a random seed will be used. The seed value can be
     * retrieved using the dumpwallet command. It is the private key marked hdseed=1
     * </p>
     * <p>
     *
     * @param newkeypool the newkeypool
     * @param seed the seed
     * @return the object
     */
    public Object setHdSeed(Boolean newkeypool, String seed) {
        return callRpcMethod(RpcWalletMethodsConstants.WALLET_SET_HD_SEED, newkeypool, seed);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The unloadwallet RPC unloads the wallet referenced by the request endpoint otherwise unloads the wallet specified in the argument.
     * </p>
     * <p>
     * Unloads the wallet referenced by the request endpoint otherwise unloads the wallet specified in the argument. Specifying the wallet name on a
     * wallet endpoint is invalid. Arguments:
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "wallet_name" (string, optional) The name of the wallet to unload.
     * </p>
     * 
     * <pre>
     *      Result:
     * </pre>
     *
     * @param walletName the wallet name
     * @return the object
     */
    public Object unloadWallet(String walletName) {
        return callRpcMethod(RpcWalletMethodsConstants.WALLET_UNLOAD_WALLET, walletName);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.4.0
     * </p>
     * <p>
     * The walletlock RPC removes the wallet encryption key from memory, locking the wallet. After calling this method, you will need to call
     * `walletpassphrase` again before being able to call any methods which require the wallet to be unlocked.
     * </p>
     * <p>
     * Removes the wallet encryption key from memory, locking the wallet. After calling this method, you will need to call walletpassphrase again
     * before being able to call any methods which require the wallet to be unlocked.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "passphrase" (string) The pass phrase to encrypt the wallet with. It must be at least 1 character, but should be long.
     * </p>
     *
     * @return the boolean
     */
    public Boolean walletLock() {
        callRpcMethod(RpcWalletMethodsConstants.WALLET_WALLET_LOCK);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.4.0
     * </p>
     * <p>
     * The walletpassphrase RPC stores the wallet decryption key in memory for the indicated number of seconds. Issuing the `walletpassphrase` command
     * while the wallet is already unlocked will set a new unlock time that overrides the old one.
     * </p>
     * <p>
     * Stores the wallet decryption key in memory for 'timeout' seconds. This is needed prior to performing transactions related to private keys such
     * as sending bitcoins
     * </p>
     * <p>
     * Note: Issuing the walletpassphrase command while the wallet is already unlocked will set a new unlock time that overrides the old one.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "passphrase" (string, required) The wallet passphrase
     * </p>
     * <p>
     * 2. timeout (numeric, required) The time to keep the decryption key in seconds; capped at 100000000 (~3 years).
     * </p>
     *
     * @param passphrase the passphrase
     * @param timeout the timeout
     * @return the boolean
     */
    public Boolean walletPassphrase(String passphrase, Long timeout) {
        callRpcMethod(RpcWalletMethodsConstants.WALLET_WALLET_PASSPHRASE, passphrase, timeout);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.4.0
     * </p>
     * <p>
     * The walletpassphrasechange RPC changes the wallet passphrase from 'old passphrase' to 'new passphrase'.
     * </p>
     * <p>
     * Changes the wallet passphrase from 'oldpassphrase' to 'newpassphrase'.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "oldpassphrase" (string) The current passphrase
     * </p>
     * <p>
     * 2. "newpassphrase" (string) The new passphrase
     * </p>
     *
     * @param oldpassphrase the oldpassphrase
     * @param newpassphrase the newpassphrase
     * @return the boolean
     */
    public Boolean walletPassphraseChange(String oldpassphrase, String newpassphrase) {
        callRpcMethod(RpcWalletMethodsConstants.WALLET_WALLET_PASSPHRASE_CHANGE, oldpassphrase, newpassphrase);
        return Boolean.TRUE;
    }

}
