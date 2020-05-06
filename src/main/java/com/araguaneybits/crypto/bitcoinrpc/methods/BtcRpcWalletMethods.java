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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.araguaneybits.crypto.bitcoinrpc.RpcOutputMessage;
import com.araguaneybits.crypto.bitcoinrpc.constants.EnumAddressType;
import com.araguaneybits.crypto.bitcoinrpc.constants.EnumEstimateMode;
import com.araguaneybits.crypto.bitcoinrpc.constants.EnumSighashType;
import com.araguaneybits.crypto.bitcoinrpc.constants.RpcWalletMethodsConstants;
import com.araguaneybits.crypto.bitcoinrpc.methods.request.BtcRpcLockUnspentRequest;
import com.araguaneybits.crypto.bitcoinrpc.methods.request.BtcRpcSignRawTransactionWithWalletRequest;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcAddMultiSigAddressResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcBumpFeeResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetAddressInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetAddressesByLabelResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetTransactionResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListReceivedByLabelResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListUnspentResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcReceivedByAddressResponse;
import com.araguaneybits.crypto.utils.TransformBeanUtils;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * The Class BtcRpcWalletMethods.
 */
public class BtcRpcWalletMethods extends BaseBtcRpcMethods {

    /**
     * Instantiates a new btc rpc wallet methods.
     *
     * @param btcRpcGateway the btc rpc gateway
     */
    public BtcRpcWalletMethods(BtcRpcGateway btcRpcGateway) {
        super(btcRpcGateway);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.12.0
     * </p>
     * <p>
     * Mark in-wallet transaction as abandoned
     * </p>
     * 
     * <pre>
     *     bandontransaction "txid"
     *     
     *     Mark in-wallet transaction  as abandoned
     *     This will mark this transaction and all its in-wallet descendants as abandoned which will allow
     *     for their inputs to be respent.  It can be used to replace "stuck" or evicted transactions.
     *     It only works on transactions which are not included in a block and are not currently in the mempool.
     *     It has no effect on transactions which are already abandoned.
     *     
     *     Arguments:
     *     1. "txid"    (string, required) The transaction id
     *     
     *     Result:
     *     
     *     Examples:
    *       bitcoin-cli abandontransaction "1075db55d416d3ca199f55b6084e2115b9345e16c5cf302fc80e9d5fbf5d48d"
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "abandontransaction", "params": ["1075db55d416d3ca199f55b6084e2115b9345e16c5cf302fc80e9d5fbf5d48d"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param txid the transaction id
     * @return the object
     */
    public Object abandonTransaction(String txid) {
        return callRpcMethod(RpcWalletMethodsConstants.WALLET_ABANDON_TRANSACTION, txid);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.6.0
     * </p>
     * <p>
     * The addmultisigaddress RPC adds a P2SH multisig address to the wallet.
     * </p>
     * 
     * <pre>
     *     addmultisigaddress nrequired ["key",...] ( "label" "address_type" )
     *     
     *     Add a nrequired-to-sign multisignature address to the wallet. Requires a new wallet backup.
     *     Each key is a Bitcoin address or hex-encoded public key.
     *     This functionality is only intended for use with non-watchonly addresses.
     *     See `importaddress` for watchonly p2sh address support.
     *     If 'label' is specified, assign address to that label.
     *     
     *     Arguments:
     *     1. nrequired                      (numeric, required) The number of required signatures out of the n keys or addresses.
     *     2. "keys"                         (string, required) A json array of bitcoin addresses or hex-encoded public keys
     *      [
     *        "address"                  (string) bitcoin address or hex-encoded public key
     *        ...,
     *      ]
     *     3. "label"                        (string, optional) A label to assign the addresses to.
     *     4. "address_type"                 (string, optional) The address type to use. Options are "legacy", "p2sh-segwit", and "bech32". Default is set by -addresstype.
     *     
     *     Result:
     *     {
     *     "address":"multisigaddress",    (string) The value of the new multisig address.
     *     "redeemScript":"script"         (string) The string value of the hex-encoded redemption script.
     *     }
     *     
     *     Examples:
     *     
     *     Add a multisig address from 2 addresses
    *       bitcoin-cli addmultisigaddress 2 "[\"16sSauSf5pF2UkUwvKGq4qjNRzBZYqgEL5\",\"171sgjn4YtPu27adkKGrdDwzRTxnRkBfKV\"]"
     *     
     *     As json rpc call
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "addmultisigaddress", "params": [2, "[\"16sSauSf5pF2UkUwvKGq4qjNRzBZYqgEL5\",\"171sgjn4YtPu27adkKGrdDwzRTxnRkBfKV\"]"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param nrequired the nrequired
     * @param keys the keys
     * @param label the label
     * @param addressType the address type
     * @return the btc rpc add multi sig address response
     */
    public BtcRpcAddMultiSigAddressResponse addMultiSigAddress(Long nrequired, String[] keys, String label, EnumAddressType addressType) {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_ADD_MULTI_SIG_ADDRESS, nrequired, keys, label, addressType.getValue());
        RpcOutputMessage<?> rpcOutputMessage = (RpcOutputMessage<?>) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcAddMultiSigAddressResponse>>() {
                });
        return (BtcRpcAddMultiSigAddressResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.14.0
     * </p>
     * <p>
     * The bumpfee RPC replaces an unconfirmed wallet transaction that signaled RBF with a new transaction that pays a higher fee.
     * </p>
     * 
     * <pre>
     *      bumpfee "txid" ( options ) 
     *     
     *     Bumps the fee of an opt-in-RBF transaction T, replacing it with a new transaction B.
     *     An opt-in RBF transaction with the given txid must be in the wallet.
     *     The command will pay the additional fee by decreasing (or perhaps removing) its change output.
     *     If the change output is not big enough to cover the increased fee, the command will currently fail
     *     instead of adding new inputs to compensate. (A future implementation could improve this.)
     *     The command will fail if the wallet or mempool contains a transaction that spends one of T's outputs.
     *     By default, the new fee will be calculated automatically using estimatesmartfee.
     *     The user can specify a confirmation target for estimatesmartfee.
     *     Alternatively, the user can specify totalFee, or use RPC settxfee to set a higher fee rate.
     *     At a minimum, the new fee rate must be high enough to pay an additional new relay fee (incrementalfee
     *     returned by getnetworkinfo) to enter the node's mempool.
     *     
     *     Arguments:
     *     1. txid                  (string, required) The txid to be bumped
     *     2. options               (object, optional)
     *     {
     *      "confTarget"        (numeric, optional) Confirmation target (in blocks)
     *      "totalFee"          (numeric, optional) Total fee (NOT feerate) to pay, in satoshis.
     *                          In rare cases, the actual fee paid might be slightly higher than the specified
     *                          totalFee if the tx change output has to be removed because it is too close to
     *                          the dust threshold.
     *      "replaceable"       (boolean, optional, default true) Whether the new transaction should still be
     *                          marked bip-125 replaceable. If true, the sequence numbers in the transaction will
     *                          be left unchanged from the original. If false, any input sequence numbers in the
     *                          original transaction that were less than 0xfffffffe will be increased to 0xfffffffe
     *                          so the new transaction will not be explicitly bip-125 replaceable (though it may
     *                          still be replaceable in practice, for example if it has unconfirmed ancestors which
     *                          are replaceable).
     *      "estimate_mode"     (string, optional, default=UNSET) The fee estimate mode, must be one of:
     *          "UNSET"
     *          "ECONOMICAL"
     *          "CONSERVATIVE"
     *     }
     *     
     *     Result:
     *     {
     *     "txid":    "value",   (string)  The id of the new transaction
     *     "origfee":  n,         (numeric) Fee of the replaced transaction
     *     "fee":      n,         (numeric) Fee of the new transaction
     *     "errors":  [ str... ] (json array of strings) Errors encountered during processing (may be empty)
     *     }
     *     
     *     Examples:
     *     
     *     Bump the fee, get the new transaction's txid
    *       bitcoin-cli bumpfee
     * </pre>
     *
     * @param txid the txid
     * @return the btc rpc bump fee response
     */
    public BtcRpcBumpFeeResponse bumpFee(String txid) {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_BUMP_FEE, txid);
        RpcOutputMessage<?> rpcOutputMessage = (RpcOutputMessage<?>) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcBumpFeeResponse>>() {
                });
        return (BtcRpcBumpFeeResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.6.0
     * </p>
     * <p>
     * The dumpprivkey RPC returns the wallet-import-format (WIF) private key corresponding to an address. (But does not remove it from the wallet.)
     * </p>
     * 
     * <pre>
     *     dumpprivkey "address"
     *     
     *     Reveals the private key corresponding to 'address'.
     *     Then the importprivkey can be used with this output
     *     
     *     Arguments:
     *     1. "address"   (string, required) The bitcoin address for the private key
     *     
     *     Result:
     *     "key"                (string) The private key
     *     
     *     Examples:
    *       bitcoin-cli dumpprivkey "myaddress"
    *       bitcoin-cli importprivkey "mykey"
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "dumpprivkey", "params": ["myaddress"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param address the address
     * @return the string
     */
    public String dumpPrivkey(String address) {
        return (String) callRpcMethod(RpcWalletMethodsConstants.WALLET_DUMP_PRIVKEY, address);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The getaddressesbylabel RPC returns the list of addresses assigned the specified label.
     * </p>
     * 
     * <pre>
     *     getaddressesbylabel "label"
     *     
     *     Returns the list of addresses assigned the specified label.
     *     
     *     Arguments:
     *     1. "label"  (string, required) The label.
     *     
     *     Result:
     *     { (json object with addresses as keys)
     *     "address": { (json object with information about address)
     *     "purpose": "string" (string)  Purpose of address ("send" for sending address, "receive" for receiving address)
     *     },...
     *     }
     *     
     *     Examples:
    *       bitcoin-cli getaddressesbylabel "tabby"
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getaddressesbylabel", "params": ["tabby"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param label the label
     * @return the addresses by label
     */
    public BtcRpcGetAddressesByLabelResponse getAddressesByLabel(String label) {

        Map<String, Map<String, String>> response = (Map) callRpcMethod(RpcWalletMethodsConstants.WALLET_GET_ADDRESSES_BY_LABEL, label);

        Map.Entry<String, Map<String, String>> entry = response.entrySet().iterator().next();
        String key = entry.getKey();
        Map<String, String> purpose = entry.getValue();

        BtcRpcGetAddressesByLabelResponse btcRpcGetAddressesByLabelResponse = new BtcRpcGetAddressesByLabelResponse();
        btcRpcGetAddressesByLabelResponse.setAddress(key);
        btcRpcGetAddressesByLabelResponse.setPurpose(purpose.get("purpose"));
        return btcRpcGetAddressesByLabelResponse;

    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The getaddressinfo RPC returns information about the given bitcoin address. Some information requires the address to be in the wallet.
     * </p>
     * Return information about the given bitcoin address. Some information requires the address to be in the wallet.
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. address (string, required) The bitcoin address to get the information of.
     * </p>
     * 
     * <pre>
     *     Result:
     *     {
     *     "address" : "address",        (string) The bitcoin address validated
     *     "scriptPubKey" : "hex",       (string) The hex-encoded scriptPubKey generated by the address
     *     "ismine" : true|false,        (boolean) If the address is yours or not
     *     "iswatchonly" : true|false,   (boolean) If the address is watchonly
     *     "solvable" : true|false,      (boolean) Whether we know how to spend coins sent to this address, ignoring the possible lack of private keys
     *     "desc" : "desc",            (string, optional) A descriptor for spending coins sent to this address (only when solvable)
     *     "isscript" : true|false,      (boolean) If the key is a script
     *     "ischange" : true|false,      (boolean) If the address was used for change output
     *     "iswitness" : true|false,     (boolean) If the address is a witness address
     *     "witness_version" : version   (numeric, optional) The version number of the witness program
     *     "witness_program" : "hex"     (string, optional) The hex value of the witness program
     *     "script" : "type"             (string, optional) The output script type. Only if "isscript" is true and the redeemscript is known. Possible types: nonstandard, pubkey, pubkeyhash, scripthash, multisig, nulldata, witness_v0_keyhash, witness_v0_scripthash, witness_unknown
     *     "hex" : "hex",                (string, optional) The redeemscript for the p2sh address
     *     "pubkeys"                     (string, optional) Array of pubkeys associated with the known redeemscript (only if "script" is "multisig")
     *     [
     *       "pubkey"
     *       ,...
     *     ]
     *     "sigsrequired" : xxxxx        (numeric, optional) Number of signatures required to spend multisig output (only if "script" is "multisig")
     *     "pubkey" : "publickeyhex",    (string, optional) The hex value of the raw public key, for single-key addresses (possibly embedded in P2SH or P2WSH)
     *     "embedded" : {...},           (object, optional) Information about the address embedded in P2SH or P2WSH, if relevant and known. It includes all getaddressinfo output fields for the embedded address, excluding metadata ("timestamp", "hdkeypath", "hdseedid") and relation to the wallet ("ismine", "iswatchonly").
     *     "iscompressed" : true|false,  (boolean, optional) If the pubkey is compressed
     *     "label" :  "label"         (string) The label associated with the address, "" is the default label
     *     "timestamp" : timestamp,      (number, optional) The creation time of the key if available in seconds since epoch (Jan 1 1970 GMT)
     *     "hdkeypath" : "keypath"       (string, optional) The HD keypath if the key is HD and available
     *     "hdseedid" : ""      (string, optional) The Hash160 of the HD seed
     *     "hdmasterfingerprint" : "" (string, optional) The fingperint of the master key.
     *     "labels"                      (object) Array of labels associated with the address.
     *     [
     *       { (json object of label data)
     *         "name": "labelname" (string) The label
     *         "purpose": "string" (string) Purpose of address ("send" for sending address, "receive" for receiving address)
     *       },...
     *     ]
     *     }
     * </pre>
     *
     * @param address the address
     * @return the address info
     */
    public BtcRpcGetAddressInfoResponse getAddressInfo(String address) {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_GET_ADDRESS_INFO, address);
        RpcOutputMessage<?> rpcOutputMessage = (RpcOutputMessage<?>) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetAddressInfoResponse>>() {
                });
        return (BtcRpcGetAddressInfoResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.3.18
     * </p>
     * <p>
     * The getbalance RPC gets the balance in decimal bitcoins across all accounts or for a particular account.
     * </p>
     * <p>
     * getbalance ( "(dummy)" minconf include_watchonly )
     * </p>
     * <p>
     * Returns the total available balance. The available balance is what the wallet considers currently spendable, and is thus affected by options
     * which limit spendability such as -spendzeroconfchange.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. (dummy) (string, optional) Remains for backward compatibility. Must be excluded or set to "*".
     * </p>
     * <p>
     * 2. minconf (numeric, optional, default=0) Only include transactions confirmed at least this many times.
     * </p>
     * <p>
     * 3. include_watchonly (bool, optional, default=false) Also include balance in watch-only addresses (see 'importaddress')
     * </p>
     * 
     * <pre>
     *     Result:
     *     amount              (numeric) The total amount in BTC received for this account.
     * </pre>
     *
     * @param dummy the dummy
     * @param minconf the minconf
     * @param includeWatchonly the include watchonly
     * @return the balance in BTC
     */
    public BigDecimal getBalance(String dummy, Integer minconf, Boolean includeWatchonly) {
        return (BigDecimal) callRpcMethod(RpcWalletMethodsConstants.WALLET_GET_BALANCE, dummy, minconf, includeWatchonly);
    }

    /**
     * Gets the balance.
     *
     * @return the balance
     */
    public BigDecimal getBalance() {
        return (BigDecimal) callRpcMethod(RpcWalletMethodsConstants.WALLET_GET_BALANCE);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: &lt; 0.4.1
     * </p>
     * <p>
     * The getnewaddress RPC returns a new Bitcoin address for receiving payments. If an account is specified, payments received with the address will
     * be credited to that account.
     * </p>
     * <p>
     * Returns a new Bitcoin address for receiving payments. If 'label' is specified, it is added to the address book so payments received with the
     * address will be associated with 'label'.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "label" (string, optional) The label name for the address to be linked to. If not provided, the default label "" is used. It can also be set
     * to the empty string "" to represent the default label. The label does not need to exist, it will be created if there is no label by the given
     * name.
     * </p>
     * <p>
     * 2. "address_type" (string, optional) The address type to use. Options are "legacy", "p2sh-segwit", and "bech32". Default is set by
     * -addresstype.
     * </p>
     * 
     * <pre>
     *      Result:
     *     "address"    (string) The new bitcoin address
     * </pre>
     *
     * @param label the label
     * @param enumAddressType the enum address type
     * @return the new address
     */
    public String getNewAddress(String label, EnumAddressType enumAddressType) {
        return (String) callRpcMethod(RpcWalletMethodsConstants.WALLET_GET_NEW_ADDRESS, label, enumAddressType.getValue());
    }

    /**
     * Gets the new address.
     *
     * @return the new address
     */
    public String getNewAddress() {
        return (String) callRpcMethod(RpcWalletMethodsConstants.WALLET_GET_NEW_ADDRESS);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.9.0
     * </p>
     * <p>
     * The getrawchangeaddress RPC returns a new Bitcoin address for receiving change. This is for use with raw transactions, not normal use.
     * </p>
     * Returns a new Bitcoin address, for receiving change. This is for use with raw transactions, NOT normal use.
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "address_type" (string, optional) The address type to use. Options are "legacy", "p2sh-segwit", and "bech32". Default is set by -changetype.
     * </p>
     * 
     * <pre>
     *      Result:
     *     "address"    (string) The address
     * </pre>
     *
     * @param enumAddressType the enum address type
     * @return the raw change address
     */
    public String getRawChangeAddress(EnumAddressType enumAddressType) {
        return (String) callRpcMethod(RpcWalletMethodsConstants.WALLET_GET_RAW_CHANGE_ADDRESS, enumAddressType.getValue());
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: &lt; 0.16.0
     * </p>
     * <p>
     * The getreceivedbyaddress RPC returns the total amount received by the specified address in transactions with the specified number of
     * confirmations. It does not count coinbase transactions.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "address" (string, required) The bitcoin address for transactions.
     * </p>
     * <p>
     * 2. minconf (numeric, optional, default=1) Only include transactions confirmed at least this many times.
     * </p>
     * 
     * <pre>
     *      Result:
     *      amount   (numeric) The total amount in BTC received at this address.
     * </pre>
     *
     * @param address the address
     * @param minconf the minconf
     * @return the received by address
     */
    public BigDecimal getReceivedByAddress(String address, Integer minconf) {
        return (BigDecimal) callRpcMethod(RpcWalletMethodsConstants.WALLET_GET_RECEIVED_BY_ADDRESS, address, minconf);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The getreceivedbylabel RPC returns the total amount received by addresses with in transactions with at least [minconf] confirmations.
     * </p>
     * Returns the total amount received by addresses with in transactions with at least [minconf] confirmations.
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "label" (string, required) The selected label, may be the default label using "".
     * </p>
     * <p>
     * 2. minconf (numeric, optional, default=1) Only include transactions confirmed at least this many times.
     * </p>
     * 
     * <pre>
     *     Result:
     *     amount              (numeric) The total amount in BTC received for this label.
     * </pre>
     *
     * @param label the label
     * @param minconf the minconf
     * @return the received by label
     */
    public BigDecimal getReceivedByLabel(String label, Integer minconf) {
        return (BigDecimal) callRpcMethod(RpcWalletMethodsConstants.WALLET_GET_RECEIVED_BY_LABEL, label, minconf);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: &lt; 0.10.0
     * </p>
     * <p>
     * The gettransaction RPC gets detailed information about an in-wallet transaction
     * </p>
     * <p>
     * Get detailed information about in-wallet transaction
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "txid" (string, required) The transaction id
     * </p>
     * <p>
     * 2. "include_watchonly" (bool, optional, default=false) Whether to include watch-only addresses in balance calculation and details[]
     * </p>
     * 
     * <pre>
     *      Result:
     *     {
     *     "amount" : x.xxx,        (numeric) The transaction amount in BTC
     *     "fee": x.xxx,            (numeric) The amount of the fee in BTC. This is negative and only available for the 
     *                               'send' category of transactions.
     *     "confirmations" : n,     (numeric) The number of confirmations
     *     "blockhash" : "hash",  (string) The block hash
     *     "blockindex" : xx,       (numeric) The index of the transaction in the block that includes it
     *     "blocktime" : ttt,       (numeric) The time in seconds since epoch (1 Jan 1970 GMT)
     *     "txid" : "transactionid",   (string) The transaction id.
     *     "time" : ttt,            (numeric) The transaction time in seconds since epoch (1 Jan 1970 GMT)
     *     "timereceived" : ttt,    (numeric) The time received in seconds since epoch (1 Jan 1970 GMT)
     *     "bip125-replaceable": "yes|no|unknown",  (string) Whether this transaction could be replaced due to BIP125 (replace-by-fee);
     *                                                    may be unknown for unconfirmed transactions not in the mempool
     *     "details" : [
     *     {
     *       "account" : "accountname",      (string) DEPRECATED. This field will be removed in a V0.18. To see this deprecated field, start bitcoind with -deprecatedrpc=accounts. The account name involved in the transaction, can be "" for the default account.
     *       "address" : "address",          (string) The bitcoin address involved in the transaction
     *       "category" : "send|receive",    (string) The category, either 'send' or 'receive'
     *       "amount" : x.xxx,                 (numeric) The amount in BTC
     *       "label" : "label",              (string) A comment for the address/transaction, if any
     *       "vout" : n,                       (numeric) the vout value
     *       "fee": x.xxx,                     (numeric) The amount of the fee in BTC. This is negative and only available for the 
     *                                            'send' category of transactions.
     *       "abandoned": xxx                  (bool) 'true' if the transaction has been abandoned (inputs are respendable). Only available for the 
     *                                            'send' category of transactions.
     *     }
     *     ,...
     *     ],
     *     "hex" : "data"         (string) Raw data for transaction
     *     }
     * </pre>
     *
     * @param txid the txid
     * @return the transaction
     */
    public BtcRpcGetTransactionResponse getTransaction(String txid) {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_GET_TRANSACTION, txid);
        RpcOutputMessage<?> rpcOutputMessage = (RpcOutputMessage<?>) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetTransactionResponse>>() {
                });

        return (BtcRpcGetTransactionResponse) rpcOutputMessage.getResult();

    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.9.0
     * </p>
     * <p>
     * The getunconfirmedbalance RPC returns the wallet's total unconfirmed balance.
     * </p>
     * <p>
     * Returns the server's total unconfirmed balance
     * </p>
     *
     * @return the unconfirmed balance
     */
    public BigDecimal getUnconfirmedBalance() {
        return (BigDecimal) callRpcMethod(RpcWalletMethodsConstants.WALLET_GET_UNCONFIRMED_BALANCE);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.10.0
     * </p>
     * <p>
     * The importaddress RPC adds an address or pubkey script to the wallet without the associated private key, allowing you to watch for transactions
     * affecting that address or pubkey script without being able to spend any of its outputs.
     * </p>
     * 
     * <pre>
     *     importaddress "address" ( "label" rescan p2sh )
     *     
     *     Adds an address or script (in hex) that can be watched as if it were in your wallet but cannot be used to spend. Requires a new wallet backup.
     *     
     *     Arguments:
     *     1. "address"          (string, required) The Bitcoin address (or hex-encoded script)
     *     2. "label"            (string, optional, default="") An optional label
     *     3. rescan               (boolean, optional, default=true) Rescan the wallet for transactions
     *     4. p2sh                 (boolean, optional, default=false) Add the P2SH version of the script as well
     *     
     *     Note: This call can take over an hour to complete if rescan is true, during that time, other rpc calls
     *     may report that the imported address exists but related transactions are still missing, leading to temporarily incorrect/bogus balances and unspent outputs until rescan completes.
     *     If you have the full public key, you should call importpubkey instead of this.
     *     
     *     Note: If you import a non-standard raw script in hex form, outputs sending to it will be treated
     *     as change, and not show up in many RPCs.
     *     
     *     Examples:
     *     
     *     Import an address with rescan
    *       bitcoin-cli importaddress "myaddress"
     *     
     *     Import using a label without rescan
    *       bitcoin-cli importaddress "myaddress" "testing" false
     *     
     *     As a JSON-RPC call
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "importaddress", "params": ["myaddress", "testing", false] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param address the address
     * @param label the label
     * @param rescan the rescan
     * @param p2sh the p 2 sh
     * @return the boolean
     */
    public Boolean importAddress(String address, String label, Boolean rescan, Boolean p2sh) {
        callRpcMethod(RpcWalletMethodsConstants.WALLET_IMPORT_ADDRESS, address, label, rescan, p2sh);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.14.0
     * </p>
     * <p>
     * The importmulti RPC imports addresses or scripts (with private keys, public keys, or P2SH redeem scripts) and optionally performs the minimum
     * necessary rescan for all imports.
     * </p>
     * 
     * <pre>
     *      
     *     importmulti "requests" ( "options" )
     *     
     *     Import addresses/scripts (with private or public keys, redeem script (P2SH)), optionally rescanning the blockchain from the earliest creation time of the imported scripts. Requires a new wallet backup.
     *     If an address/script is imported without all of the private keys required to spend from that address, it will be watchonly. The 'watchonly' option must be set to true in this case or a warning will be returned.
     *     Conversely, if all the private keys are provided and the address/script is spendable, the watchonly option must be set to false, or a warning will be returned.
     *     
     *     Note: This call can take over an hour to complete if rescan is true, during that time, other rpc calls
     *     may report that the imported keys, addresses or scripts exists but related transactions are still missing.
     *     
     *     Arguments:
     *     1. requests                                                         (json array, required) Data to be imported
     *      [
     *        {                                                            (json object)
     *          "desc": "str",                                             (string) Descriptor to import. If using descriptor, do not also provide address/scriptPubKey, scripts, or pubkeys
     *          "scriptPubKey": "&lt;script&gt;" | { "address":"&lt;address&gt;" },    (string / json, required) Type of scriptPubKey (string for script, json for address). Should not be provided if using a descriptor
     *          "timestamp": timestamp | "now",                            (integer / string, required) Creation time of the key in seconds since epoch (Jan 1 1970 GMT),
     *                                                                     or the string "now" to substitute the current synced blockchain time. The timestamp of the oldest
     *                                                                     key will determine how far back blockchain rescans need to begin for missing wallet transactions.
     *                                                                     "now" can be specified to bypass scanning, for keys which are known to never have been used, and
     *                                                                     0 can be specified to scan the entire blockchain. Blocks up to 2 hours before the earliest key
     *                                                                     creation time of all keys being imported by the importmulti call will be scanned.
     *          "redeemscript": "str",                                     (string) Allowed only if the scriptPubKey is a P2SH or P2SH-P2WSH address/scriptPubKey
     *          "witnessscript": "str",                                    (string) Allowed only if the scriptPubKey is a P2SH-P2WSH or P2WSH address/scriptPubKey
     *          "pubkeys": [                                               (json array, optional, default=empty array) Array of strings giving pubkeys to import. They must occur in P2PKH or P2WPKH scripts. They are not required when the private key is also provided (see the "keys" argument).
     *            "pubKey",                                                (string)
     *            ...
     *          ],
     *          "keys": [                                                  (json array, optional, default=empty array) Array of strings giving private keys to import. The corresponding public keys must occur in the output or redeemscript.
     *            "key",                                                   (string)
     *            ...
     *          ],
     *          "range": n or [n,n],                                       (numeric or array) If a ranged descriptor is used, this specifies the end or the range (in the form [begin,end]) to import
     *          "internal": bool,                                          (boolean, optional, default=false) Stating whether matching outputs should be treated as not incoming payments (also known as change)
     *          "watchonly": bool,                                         (boolean, optional, default=false) Stating whether matching outputs should be considered watchonly.
     *          "label": "str",                                            (string, optional, default='') Label to assign to the address, only allowed with internal=false
     *          "keypool": bool,                                           (boolean, optional, default=false) Stating whether imported public keys should be added to the keypool for when users request new addresses. Only allowed when wallet private keys are disabled
     *        },
     *        ...
     *      ]
     *     2. options                                                          (json object, optional)
     *      {
     *        "rescan": bool,                                              (boolean, optional, default=true) Stating if should rescan the blockchain after all imports
     *      }
     *     
     *     Note: This call can take minutes to complete if rescan is true, during that time, other rpc calls
     *     may report that the imported keys, addresses or scripts exists but related transactions are still missing.
     *     
     *     Examples:
     *       bitcoin-cli importmulti '[{ "scriptPubKey": { "address": "[my address]" }, "timestamp":1455191478 }, { "scriptPubKey": { "address": "[my 2nd address]" }, "label": "example 2", "timestamp": 1455191480 }]'
     *       bitcoin-cli importmulti '[{ "scriptPubKey": { "address": "[my address]" }, "timestamp":1455191478 }]' '{ "rescan": false}'
     *     
     *     Response is an array with the same size as the input that has the execution result :
     *     [{"success": true}, {"success": true, "warnings": ["Ignoring irrelevant private key"]}, {"success": false, "error": {"code": -1, "message": "Internal Server Error"}}, ...]
     * </pre>
     *
     * @return the object
     */
    public Object importmulti() {
        // TODO method not implemented
        return callRpcMethod(RpcWalletMethodsConstants.WALLET_IMPORT_MULTI);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.6.0
     * </p>
     * <p>
     * The importprivkey RPC adds a private key to your wallet. The key should be formatted in the wallet import format created by the `dumpprivkey`
     * RPC.
     * </p>
     * 
     * <pre>
     *      importprivkey "privkey" ( "label" ) ( rescan )
     *     
     *     Adds a private key (as returned by dumpprivkey) to your wallet. Requires a new wallet backup.
     *     Hint: use importmulti to import more than one private key.
     *     
     *     Arguments:
     *     1. "privkey"          (string, required) The private key (see dumpprivkey)
     *     2. "label"            (string, optional, default="") An optional label
     *     3. rescan               (boolean, optional, default=true) Rescan the wallet for transactions
     *     
     *     Note: This call can take over an hour to complete if rescan is true, during that time, other rpc calls
     *     may report that the imported key exists but related transactions are still missing, leading to temporarily incorrect/bogus balances and unspent outputs until rescan completes.
     *     
     *     Examples:
     *     
     *     Dump a private key
    *       bitcoin-cli dumpprivkey "myaddress"
     *     
     *     Import the private key with rescan
    *       bitcoin-cli importprivkey "mykey"
     *     
     *     Import using a label and without rescan
    *       bitcoin-cli importprivkey "mykey" "testing" false
     *     
     *     Import using default blank label and without rescan
    *       bitcoin-cli importprivkey "mykey" "" false
     *     
     *     As a JSON-RPC call
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "importprivkey", "params": ["mykey", "testing", false] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param privkey the privkey
     * @param label the label
     * @param rescan the rescan
     * @return the boolean
     */
    public Boolean importPrivKey(String privkey, String label, Boolean rescan) {
        callRpcMethod(RpcWalletMethodsConstants.WALLET_IMPORT_PRIVKEY, privkey, label, rescan);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.13.0
     * </p>
     * <p>
     * The importprunedfunds RPC imports funds without the need of a rescan. Meant for use with pruned wallets.
     * </p>
     * 
     * <pre>
     *      importprunedfunds
     *     
     *     Imports funds without rescan. Corresponding address or script must previously be included in wallet. Aimed towards pruned wallets. The end-user is responsible to import additional transactions that subsequently spend the imported outputs or rescan after the point in the blockchain the transaction is included.
     *     
     *     Arguments:
     *     1. "rawtransaction" (string, required) A raw transaction in hex funding an already-existing address in wallet
     *     2. "txoutproof"     (string, required) The hex output from gettxoutproof that contains the transaction
     * </pre>
     *
     * @param rawtransaction the rawtransaction
     * @param txoutproof the txoutproof
     * @return the object
     */
    public Object importPrunedFunds(String rawtransaction, String txoutproof) {
        return callRpcMethod(RpcWalletMethodsConstants.WALLET_IMPORT_PRUNED_FUNDS, rawtransaction, txoutproof);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: &lt; 0.13.0
     * </p>
     * <p>
     * The importpubkey RPC adds a public key (in hex) that can be watched as if it were in your wallet but cannot be used to spend. Requires a new
     * wallet backup.
     * </p>
     * <p>
     * Adds a public key (in hex) that can be watched as if it were in your wallet but cannot be used to spend. Requires a new wallet backup.
     * </p>
     * <p>
     * Note: This call can take over an hour to complete if rescan is true, during that time, other rpc calls may report that the imported pubkey
     * exists but related transactions are still missing, leading to temporarily incorrect/bogus balances and unspent outputs until rescan completes.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "pubkey" (string, required) The hex-encoded public key
     * </p>
     * <p>
     * 2. "label" (string, optional, default="") An optional label
     * </p>
     * <p>
     * 3. rescan (boolean, optional, default=true) Rescan the wallet for transactions
     * </p>
     *
     * @param pubkey the pubkey
     * @param label the label
     * @param rescan the rescan
     * @return the object
     */
    public Object importPubkey(String pubkey, String label, Boolean rescan) {
        return callRpcMethod(RpcWalletMethodsConstants.WALLET_IMPORT_PUBKEY, pubkey, label, rescan);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: &lt; 0.10.0
     * </p>
     * <p>
     * The listreceivedbyaddress RPC lists the total number of bitcoins received by each address.
     * </p>
     * <p>
     * List balances by receiving address.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. minconf (numeric, optional, default=1) The minimum number of confirmations before payments are included.
     * </p>
     * <p>
     * 2. include_empty (bool, optional, default=false) Whether to include addresses that haven't received any payments.
     * </p>
     * <p>
     * 3. include_watchonly (bool, optional, default=false) Whether to include watch-only addresses (see 'importaddress').
     * </p>
     * <p>
     * 4. address_filter (string, optional) If present, only return information on this address.
     * </p>
     * 
     * <pre>
     *       Result:
     *         [
     *         {
     *         "involvesWatchonly" : true,        (bool) Only returned if imported addresses were involved in transaction
     *         "address" : "receivingaddress",  (string) The receiving address
     *         "account" : "accountname",       (string) DEPRECATED. Backwards compatible alias for label.
     *         "amount" : x.xxx,                  (numeric) The total amount in BTC received by the address
     *         "confirmations" : n,               (numeric) The number of confirmations of the most recent transaction included
     *         "label" : "label",               (string) The label of the receiving address. The default label is "".
     *         "txids": [
     *            "txid",                         (string) The ids of transactions received with the address 
     *            ...
     *         ]
     *         }
     *         ,...
     *         ]
     * </pre>
     *
     * @return the list
     */
    public List<BtcRpcReceivedByAddressResponse> listReceivedByAddress() {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_LIST_RECEIVED_BY_ADDRESS);
        RpcOutputMessage<?> rpcOutputMessage = (RpcOutputMessage<?>) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<ArrayList<BtcRpcReceivedByAddressResponse>>>() {
                });
        return (ArrayList<BtcRpcReceivedByAddressResponse>) rpcOutputMessage.getResult();

    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The listlabels RPC returns the list of all labels, or labels that are assigned to addresses with a specific purpose.
     * </p>
     * <p>
     * Returns the list of all labels, or labels that are assigned to addresses with a specific purpose.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "purpose" (string, optional) Address purpose to list labels for ('send','receive'). An empty string is the same as not providing this
     * argument.
     * </p>
     * 
     * <pre>
     *     Result:
     *     [               (json array of string)
     *     "label",      (string) Label name
     *     ...
     *     ]
     * </pre>
     *
     * @param purpose the purpose
     * @return the list
     */
    public List<String> listLabels(String purpose) {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_LIST_LABELS, purpose);

        RpcOutputMessage<?> rpcOutputMessage = (RpcOutputMessage<?>) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<ArrayList<String>>>() {
                });

        return (List<String>) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.8.0
     * </p>
     * <p>
     * The listlockunspent RPC returns a list of temporarily unspendable (locked) outputs.
     * </p>
     * 
     * <pre>
     *     listlockunspent
     *     
     *     Returns list of temporarily unspendable outputs.
     *     See the lockunspent call to lock and unlock transactions for spending.
     *     
     *     Result:
     *     [
     *     {
     *     "txid" : "transactionid",     (string) The transaction id locked
     *     "vout" : n                      (numeric) The vout value
     *     }
     *     ,...
     *     ]
     *     
     *     Examples:
     *     
     *     List the unspent transactions
    *       bitcoin-cli listunspent 
     *     
     *     Lock an unspent transaction
    *       bitcoin-cli lockunspent false "[{\"txid\":\"a08e6907dbbd3d809776dbfc5d82e371b764ed838b5655e72f463568df1aadf0\",\"vout\":1}]"
     *     
     *     List the locked transactions
    *       bitcoin-cli listlockunspent 
     *     
     *     Unlock the transaction again
    *       bitcoin-cli lockunspent true "[{\"txid\":\"a08e6907dbbd3d809776dbfc5d82e371b764ed838b5655e72f463568df1aadf0\",\"vout\":1}]"
     *     
     *     As a json rpc call
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listlockunspent", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the object
     */
    public Object listLockUnspent() {
        return callRpcMethod(RpcWalletMethodsConstants.WALLET_LIST_LOCK_UNSPENT);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The listreceivedbylabel RPC lists received transactions by label.
     * </p>
     * <p>
     * List received transactions by label.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. minconf (numeric, optional, default=1) The minimum number of confirmations before payments are included.
     * </p>
     * <p>
     * 2. include_empty (bool, optional, default=false) Whether to include labels that haven't received any payments.
     * </p>
     * <p>
     * 3. include_watchonly (bool, optional, default=false) Whether to include watch-only addresses (see 'importaddress').
     * 
     * <pre>
     *       
     *     Result:
     *     [
     *     {
     *     "involvesWatchonly" : true,   (bool) Only returned if imported addresses were involved in transaction
     *     "account" : "accountname",  (string) DEPRECATED. Backwards compatible alias for label.
     *     "amount" : x.xxx,             (numeric) The total amount received by addresses with this label
     *     "confirmations" : n,          (numeric) The number of confirmations of the most recent transaction included
     *     "label" : "label"           (string) The label of the receiving address. The default label is "".
     *     }
     *     ,...
     *     ]
     * </pre>
     *
     * @param minconf the minconf
     * @param includeEmpty the include empty
     * @param includeWatchonly the include watchonly
     * @return the list
     */
    public List<BtcRpcListReceivedByLabelResponse> listReceivedByLabel(Long minconf, Boolean includeEmpty, Boolean includeWatchonly) {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_LIST_RECEIVED_BY_LABEL, minconf, includeEmpty, includeWatchonly);
        RpcOutputMessage<?> rpcOutputMessage = (RpcOutputMessage<?>) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<ArrayList<BtcRpcListReceivedByLabelResponse>>>() {
                });
        return (List<BtcRpcListReceivedByLabelResponse>) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: &lt; 0.3.18
     * </p>
     * <p>
     * Call category: wallet Available since: 0.3.18 The listtransactions RPC returns the most recent transactions that affect the wallet.
     * </p>
     * <p>
     * Returns up to 'count' most recent transactions skipping the first 'from' transactions for account 'account'. Note that the "account" argument
     * and "otheraccount" return value have been removed in V0.17. To use this RPC with an "account" argument, restart bitcoind with
     * -deprecatedrpc=accounts
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "dummy" (string, optional) If set, should be "*" for backwards compatibility.
     * </p>
     * <p>
     * 2. count (numeric, optional, default=10) The number of transactions to return
     * </p>
     * <p>
     * 3. skip (numeric, optional, default=0) The number of transactions to skip
     * </p>
     * <p>
     * 4. include_watchonly (bool, optional, default=false) Include transactions to watch-only addresses (see 'importaddress')
     * </p>
     * 
     * <pre>
     *      Result:
     *     [
     *     {
     *     "address":"address",    (string) The bitcoin address of the transaction.
     *     "category":"send|receive", (string) The transaction category.
     *     "amount": x.xxx,          (numeric) The amount in BTC. This is negative for the 'send' category, and is positive
     *                                         for the 'receive' category,
     *     "label": "label",       (string) A comment for the address/transaction, if any
     *     "vout": n,                (numeric) the vout value
     *     "fee": x.xxx,             (numeric) The amount of the fee in BTC. This is negative and only available for the 
     *                                          'send' category of transactions.
     *     "confirmations": n,       (numeric) The number of confirmations for the transaction. Negative confirmations indicate the
     *                                          transaction conflicts with the block chain
     *     "trusted": xxx,           (bool) Whether we consider the outputs of this unconfirmed transaction safe to spend.
     *     "blockhash": "hashvalue", (string) The block hash containing the transaction.
     *     "blockindex": n,          (numeric) The index of the transaction in the block that includes it.
     *     "blocktime": xxx,         (numeric) The block time in seconds since epoch (1 Jan 1970 GMT).
     *     "txid": "transactionid", (string) The transaction id.
     *     "time": xxx,              (numeric) The transaction time in seconds since epoch (midnight Jan 1 1970 GMT).
     *     "timereceived": xxx,      (numeric) The time received in seconds since epoch (midnight Jan 1 1970 GMT).
     *     "comment": "...",       (string) If a comment is associated with the transaction.
     *     "bip125-replaceable": "yes|no|unknown",  (string) Whether this transaction could be replaced due to BIP125 (replace-by-fee);
     *                                                      may be unknown for unconfirmed transactions not in the mempool
     *     "abandoned": xxx          (bool) 'true' if the transaction has been abandoned (inputs are respendable). Only available for the 
     *                                          'send' category of transactions.
     *     }
     *     ]
     * </pre>
     *
     * @param dummy the dummy
     * @param count the count
     * @param skip the skip
     * @param includeWatchonly the include watchonly
     * @return the list
     */
    public List<BtcRpcGetTransactionResponse> listTransactions(String dummy, Long count, Long skip, Boolean includeWatchonly) {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_LIST_TRANSACTIONS, dummy, count, skip, includeWatchonly);
        RpcOutputMessage<?> rpcOutputMessage = (RpcOutputMessage<?>) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<ArrayList<BtcRpcGetTransactionResponse>>>() {
                });
        return (List<BtcRpcGetTransactionResponse>) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.7.0
     * </p>
     * <p>
     * The listunspent RPC returns an array of unspent transaction outputs belonging to this wallet.
     * </p>
     * <p>
     * Returns array of unspent transaction outputs with between minconf and maxconf (inclusive) confirmations. Optionally filter to only include
     * txouts paid to specified addresses.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. minconf (numeric, optional, default=1) The minimum confirmations to filter
     * </p>
     * <p>
     * 2. maxconf (numeric, optional, default=9999999) The maximum confirmations to filter
     * </p>
     * <p>
     * 3. addresses (json array, optional, default=empty array) A json array of bitcoin addresses to filter
     * </p>
     * 
     * <pre>
     *       [
     *        "address",                     (string) bitcoin address
     *        ...
     *      ]
     * </pre>
     * <p>
     * 4. include_unsafe (boolean, optional, default=true) Include outputs that are not safe to spend
     * </p>
     * <p>
     * 5. query_options (json object, optional) JSON with query options
     * </p>
     * 
     * <pre>
     *       {
     *            "minimumAmount": amount,       (numeric or string, optional, default=0) Minimum value of each UTXO in BTC
     *            "maximumAmount": amount,       (numeric or string, optional, default=unlimited) Maximum value of each UTXO in BTC
     *            "maximumCount": n,             (numeric, optional, default=unlimited) Maximum number of UTXOs
     *            "minimumSumAmount": amount,    (numeric or string, optional, default=unlimited) Minimum sum value of all UTXOs in BTC
     *          }
     * </pre>
     * 
     * <pre>
     *     Result:
     *     [                   (array of json object)
     *     {
     *     "txid" : "txid",          (string) the transaction id 
     *     "vout" : n,               (numeric) the vout value
     *     "address" : "address",    (string) the bitcoin address
     *     "label" : "label",        (string) The associated label, or "" for the default label
     *     "scriptPubKey" : "key",   (string) the script key
     *     "amount" : x.xxx,         (numeric) the transaction output amount in BTC
     *     "confirmations" : n,      (numeric) The number of confirmations
     *     "redeemScript" : "script" (string) The redeemScript if scriptPubKey is P2SH
     *     "witnessScript" : "script" (string) witnessScript if the scriptPubKey is P2WSH or P2SH-P2WSH
     *     "spendable" : xxx,        (bool) Whether we have the private keys to spend this output
     *     "solvable" : xxx,         (bool) Whether we know how to spend this output, ignoring the lack of keys
     *     "desc" : xxx,             (string, only when solvable) A descriptor for spending this output
     *     "safe" : xxx              (bool) Whether this output is considered safe to spend. Unconfirmed transactions
     *                               from outside keys and unconfirmed replacement transactions are considered unsafe
     *                               and are not eligible for spending by fundrawtransaction and sendtoaddress.
     *     }
     *     ,...
     *     ]
     * </pre>
     *
     * @param minconf the minconf
     * @param maxconf the maxconf
     * @param addresses the addresses
     * @param includeUnsafe the include unsafe
     * @param queryOptions the query options
     * @return the list
     */
    public List<BtcRpcListUnspentResponse> listUnspent(Long minconf, Long maxconf, String[] addresses, Boolean includeUnsafe, Object queryOptions) {
        String json = callSimpleRpcMethod(RpcWalletMethodsConstants.WALLET_LIST_UNSPENT, minconf, maxconf, addresses, includeUnsafe, queryOptions);
        RpcOutputMessage<?> rpcOutputMessage = (RpcOutputMessage<?>) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<ArrayList<BtcRpcListUnspentResponse>>>() {
                });
        return (List<BtcRpcListUnspentResponse>) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.8.0
     * </p>
     * <p>
     * The lockunspent RPC temporarily locks or unlocks specified transaction outputs. A locked transaction output will not be chosen by automatic
     * coin selection when spending bitcoins. Locks are stored in memory only, so nodes start with zero locked outputs and the locked output list is
     * always cleared when a node stops or fails.
     * </p>
     * <p>
     * Updates list of temporarily unspendable outputs. Temporarily lock (unlock=false) or unlock (unlock=true) specified transaction outputs. If no
     * transaction outputs are specified when unlocking then all current locked transaction outputs are unlocked. A locked transaction output will not
     * be chosen by automatic coin selection, when spending bitcoins. Locks are stored in memory only. Nodes start with zero locked outputs, and the
     * locked output list is always cleared (by virtue of process exit) when a node stops or fails. Also see the listunspent call
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. unlock (boolean, required) Whether to unlock (true) or lock (false) the specified transactions
     * </p>
     * <p>
     * 2. "transactions" (string, optional) A json array of objects. Each object the txid (string) vout (numeric)
     * </p>
     * 
     * <pre>
     *          [           (json array of json objects)
     *        {
     *          "txid":"id",    (string) The transaction id
     *          "vout": n         (numeric) The output number
     *        }
     *        ,...
     *      ]
     * </pre>
     * 
     * <pre>
     *     Result:
     *     true|false    (boolean) Whether the command was successful or not
     * </pre>
     *
     * @param unlock the unlock
     * @param transactions the transactions
     * @return the boolean
     */
    public Boolean lockUnspent(Boolean unlock, List<BtcRpcLockUnspentRequest> transactions) {
        return (Boolean) callRpcMethod(RpcWalletMethodsConstants.WALLET_LOCK_UNSPENT, unlock, transactions.toArray());
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.13.0
     * </p>
     * <p>
     * The removeprunedfunds RPC deletes the specified transaction from the wallet. Meant for use with pruned wallets and as a companion to
     * importprunedfunds.
     * </p>
     * <p>
     * Deletes the specified transaction from the wallet. Meant for use with pruned wallets and as a companion to importprunedfunds. This will affect
     * wallet balances.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "txid" (string, required) The hex-encoded id of the transaction you are deleting
     * </p>
     *
     * @param txid the txid
     * @return the object
     */
    public Object removePrunedFunds(String txid) {
        return callRpcMethod(RpcWalletMethodsConstants.WALLET_REMOVE_PRUNED_FUNDS, txid);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.3.21
     * </p>
     * <p>
     * The sendmany RPC creates and broadcasts a transaction which sends outputs to multiple addresses.
     * </p>
     * <p>
     * Send multiple times. Amounts are double-precision floating point numbers. Note that the "fromaccount" argument has been removed in V0.17. To
     * use this RPC with a "fromaccount" argument, restart bitcoind with -deprecatedrpc=accounts
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "dummy" (string, required) Must be set to "" for backwards compatibility.
     * </p>
     * <p>
     * 2. "amounts" (string, required) A json object with addresses and amounts
     * </p>
     * 
     * <pre>
     *       {
     *       "address":amount   (numeric or string) The bitcoin address is the key, the numeric amount (can be string) in BTC is the value
     *       ,...
     *     }
     * </pre>
     * <p>
     * 3. minconf (numeric, optional, default=1) Only use the balance confirmed at least this many times.
     * </p>
     * <p>
     * 4. "comment" (string, optional) A comment
     * </p>
     * <p>
     * 5. subtractfeefrom (array, optional) A json array with addresses. The fee will be equally deducted from the amount of each selected address.
     * Those recipients will receive less bitcoins than you enter in their corresponding amount field. If no addresses are specified here, the sender
     * pays the fee.
     * </p>
     * 
     * <pre>
     *          [
     *       "address"          (string) Subtract fee from this address
     *       ,...
     *     ]
     * </pre>
     * <p>
     * 6. replaceable (boolean, optional) Allow this transaction to be replaced by a transaction with higher fees via BIP 125
     * </p>
     * <p>
     * 7. conf_target (numeric, optional) Confirmation target (in blocks)
     * </p>
     * <p>
     * 8. "estimate_mode" (string, optional, default=UNSET) The fee estimate mode, must be one of: "UNSET" "ECONOMICAL" "CONSERVATIVE"
     * </p>
     * 
     * <pre>
     *     Result:
     *     "txid"                   (string) The transaction id for the send. Only 1 transaction is created regardless of 
     *                                     the number of addresses.
     *     
     *     curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "sendmany", "params": ["", {"1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX":0.01,"1353tsE8YMTA4EuV7dgUXGjNFf9KpVvKHz":0.02}, 6, "testing"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param amounts the amounts
     * @param minconf the minconf
     * @param comment the comment
     * @param subtractFeeFrom the subtract fee from
     * @param replaceable the replaceable
     * @param confTarget the conf target
     * @param enumEstimateMode the enum estimate mode
     * @return the string
     */
    public String sendMany(Map amounts, Integer minconf, String comment, String[] subtractFeeFrom, Boolean replaceable, Long confTarget,
            EnumEstimateMode enumEstimateMode) {
        String dummy = "";
        return (String) callRpcMethod(RpcWalletMethodsConstants.WALLET_SEND_MANY, dummy, amounts, minconf, comment, subtractFeeFrom, replaceable,
                confTarget, enumEstimateMode.getValue());
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: &lt; 0.10.0
     * </p>
     * <p>
     * The sendtoaddress RPC spends an amount to a given address.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "address" (string, required) The bitcoin address to send to.
     * </p>
     * <p>
     * 2. "amount" (numeric or string, required) The amount in BTC to send. eg 0.1
     * </p>
     * <p>
     * 3. "comment" (string, optional) A comment used to store what the transaction is for. This is not part of the transaction, just kept in your
     * wallet.
     * </p>
     * <p>
     * 4. "comment_to" (string, optional) A comment to store the name of the person or organization to which you're sending the transaction. This is
     * not part of the transaction, just kept in your wallet.
     * </p>
     * <p>
     * 5. subtractfeefromamount (boolean, optional, default=false) The fee will be deducted from the amount being sent
     * </p>
     * <p>
     * 6. replaceable (boolean, optional) Allow this transaction to be replaced by a transaction with higher fees via BIP 125
     * </p>
     * <p>
     * 7. conf_target (numeric, optional) Confirmation target (in blocks)
     * </p>
     * <p>
     * 8. "estimate_mode" (string, optional, default=UNSET) The fee estimate mode, must be one of: "UNSET" "ECONOMICAL" "CONSERVATIVE"
     * </p>
     * 
     * <pre>
     *      Result:
     *     "txid"                  (string) The transaction id.
     * </pre>
     *
     * @param toAddress the to address
     * @param amount the amount
     * @param comment the comment
     * @param commentTo the comment to
     * @param subtractFeeFromAmount the subtract fee from amount
     * @param replaceable the replaceable
     * @param confTarget the conf target
     * @param estimateMode the estimate mode
     * @return the string
     */
    public String sendToAddress(String toAddress, BigDecimal amount, String comment, String commentTo, Boolean subtractFeeFromAmount,
            Boolean replaceable, Long confTarget, EnumEstimateMode estimateMode) {
        return (String) callRpcMethod(RpcWalletMethodsConstants.WALLET_SEND_TO_ADDRESS, toAddress, amount, comment, commentTo, subtractFeeFromAmount,
                replaceable, confTarget, estimateMode);
    }

    /**
     * Send to address.
     *
     * @param toAddress the to address
     * @param amount the amount
     * @param comment the comment
     * @return the string
     */
    public String sendToAddress(String toAddress, BigDecimal amount, String comment) {
        return (String) callRpcMethod(RpcWalletMethodsConstants.WALLET_SEND_TO_ADDRESS, toAddress, amount, comment);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The setlabel RPC intended as a replacement for the deprecated 'account' API.
     * </p>
     * <p>
     * Sets the label associated with the given address.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "address" (string, required) The bitcoin address to be associated with a label.
     * </p>
     * <p>
     * 2. "label" (string, required) The label to assign to the address.
     * </p>
     *
     * @param address the address
     * @param label the label
     * @return the boolean
     */
    public Boolean setLabel(String address, String label) {
        callRpcMethod(RpcWalletMethodsConstants.WALLET_SET_LABEL, address, label);
        return true;
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.3.22
     * </p>
     * <p>
     * The settxfee RPC sets the transaction fee per kilobyte paid by transactions created by this wallet.
     * </p>
     * <p>
     * Set the transaction fee per kB for this wallet. Overrides the global -paytxfee command line parameter.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. amount (numeric or string, required) The transaction fee in BTC/kB
     * </p>
     * 
     * <pre>
     *     Result
     *     true|false        (boolean) Returns true if successful
     * </pre>
     *
     * @param amount the amount
     * @return the boolean
     */
    public Boolean setTxFee(BigDecimal amount) {
        return (Boolean) callRpcMethod(RpcWalletMethodsConstants.WALLET_SET_TX_FEE, amount);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.5.0
     * </p>
     * <p>
     * The signmessage RPC signs a message with the private key of an address.
     * </p>
     * 
     * <pre>
     *     signmessage "address" "message"
     *     
     *     Sign a message with the private key of an address
     *     
     *     Arguments:
     *     1. "address"         (string, required) The bitcoin address to use for the private key.
     *     2. "message"         (string, required) The message to create a signature of.
     *     
     *     Result:
     *     "signature"          (string) The signature of the message encoded in base 64
     *     
     *     Examples:
     *     
     *     Unlock the wallet for 30 seconds
    *       bitcoin-cli walletpassphrase "mypassphrase" 30
     *     
     *     Create the signature
    *       bitcoin-cli signmessage "1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX" "my message"
     *     
     *     Verify the signature
    *       bitcoin-cli verifymessage "1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX" "signature" "my message"
     *     
     *     As json rpc
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "signmessage", "params": ["1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX", "my message"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/     *
     * </pre>
     *
     * @param address the address
     * @param message the message
     * @return the string
     */
    public String signMessage(String address, String message) {
        return (String) callRpcMethod(RpcWalletMethodsConstants.WALLET_SIGN_MESSAGE, address, message);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The signrawtransactionwithwallet RPC signs inputs for raw transaction
     * </p>
     * <p>
     * Sign inputs for raw transaction (serialized, hex-encoded). The second optional argument (may be null) is an array of previous transaction
     * outputs that this transaction depends on but may not yet be in the block chain.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. hexstring (string, required) The transaction hex string
     * </p>
     * <p>
     * 2. prevtxs (json array, optional) A json array of previous dependent transaction outputs
     * </p>
     * 
     * <pre>
     *           [
     *        {                            (json object)
     *          "txid": "hex",             (string, required) The transaction id
     *          "vout": n,                 (numeric, required) The output number
     *          "scriptPubKey": "hex",     (string, required) script key
     *          "redeemScript": "hex",     (string) (required for P2SH) redeem script
     *          "witnessScript": "hex",    (string) (required for P2WSH or P2SH-P2WSH) witness script
     *          "amount": amount,          (numeric or string, required) The amount spent
     *        },
     *        ...
     *      ]
     * </pre>
     * <p>
     * 3. sighashtype (string, optional, default=ALL) The signature hash type. Must be one of "ALL" "NONE" "SINGLE" "ALL|ANYONECANPAY"
     * "NONE|ANYONECANPAY" "SINGLE|ANYONECANPAY" 4.
     * </p>
     * 
     * <pre>
     *     
     *     Result:
     *     {
     *     "hex" : "value",                  (string) The hex-encoded raw transaction with signature(s)
     *     "complete" : true|false,          (boolean) If the transaction has a complete set of signatures
     *     "errors" : [                      (json array of objects) Script verification errors (if there are any)
     *     {
     *       "txid" : "hash",              (string) The hash of the referenced, previous transaction
     *       "vout" : n,                   (numeric) The index of the output to spent and used as input
     *       "scriptSig" : "hex",          (string) The hex-encoded signature script
     *       "sequence" : n,               (numeric) Script sequence number
     *       "error" : "text"              (string) Verification or signing error related to the input
     *     }
     *     ,...
     *     ]
     *     }
     * </pre>
     *
     * @param hexstring the hexstring
     * @param prevtxs the prevtxs
     * @param sighashtype the sighashtype
     * @return the object
     */
    public Object signRawTransactionWithWallet(String hexstring, List<BtcRpcSignRawTransactionWithWalletRequest> prevtxs,
            EnumSighashType sighashtype) {
        return callRpcMethod(RpcWalletMethodsConstants.WALLET_SIGN_RAW_TRANSACTION_WITH_WALLET, hexstring, prevtxs, sighashtype);
    }

    /**
     * Sign raw transaction with wallet.
     *
     * @param hexstring the hexstring
     * @return the string
     */
    public String signRawTransactionWithWallet(String hexstring) {
        Map<String, String> response = (Map<String, String>) callRpcMethod(RpcWalletMethodsConstants.WALLET_SIGN_RAW_TRANSACTION_WITH_WALLET,
                hexstring);

        return response.get("hex");
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The walletcreatefundedpsbt RPC creates a PSBT with the specified inputs and outputs, adds additional inputs and change to it to balance it out,
     * and adds relevant metadata. In particular, for inputs that the wallet knows about (counting towards its normal or watch-only balance), UTXO
     * information will be added. For outputs and inputs with UTXO information present, key and script information will be added which the wallet
     * knows about. It is equivalent to running createrawtransaction, followed by fundrawtransaction, and converttopsbt.
     * </p>
     * <p>
     * Creates and funds a transaction in the Partially Signed Transaction format. Inputs will be added if supplied inputs are not enough Implements
     * the Creator and Updater roles.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * "inputs" (array, required) A json array of json objects
     * </p>
     * 
     * <pre>
     *           [
     *        {
     *          "txid":"id",      (string, required) The transaction id
     *          "vout":n,         (numeric, required) The output number
     *          "sequence":n      (numeric, optional) The sequence number
     *        } 
     *        ,...
     *      ]
     * </pre>
     * <p>
     * 2. "outputs" (array, required) a json array with outputs (key-value pairs)
     * </p>
     * 
     * <pre>
     *         [
     *     {
     *       "address": x.xxx,    (obj, optional) A key-value pair. The key (string) is the bitcoin address, the value (float or string) is the amount in BTC
     *     },
     *     {
     *       "data": "hex"        (obj, optional) A key-value pair. The key must be "data", the value is hex encoded data
     *     }
     *     ,...                     More key-value pairs of the above form. For compatibility reasons, a dictionary, which holds the key-value pairs directly, is also
     *                              accepted as second parameter.
     *     ]
     * </pre>
     * <p>
     * 3. locktime (numeric, optional, default=0) Raw locktime. Non-0 value also locktime-activates inputs Allows this transaction to be replaced by a
     * transaction with higher fees. If provided, it is an error if explicit sequence numbers are incompatible.
     * </p>
     * <p>
     * 4. options (object, optional)
     * </p>
     * 
     * <pre>
     *         {
     *      "changeAddress"          (string, optional, default pool address) The bitcoin address to receive the change
     *      "changePosition"         (numeric, optional, default random) The index of the change output
     *      "change_type"            (string, optional) The output type to use. Only valid if changeAddress is not specified. Options are "legacy", "p2sh-segwit", and "bech32". Default is set by -changetype.
     *      "includeWatching"        (boolean, optional, default false) Also select inputs which are watch only
     *      "lockUnspents"           (boolean, optional, default false) Lock selected unspent outputs
     *      "feeRate"                (numeric, optional, default not set: makes wallet determine the fee) Set a specific fee rate in BTC/kB
     *      "subtractFeeFromOutputs" (array, optional) A json array of integers.
     *                               The fee will be equally deducted from the amount of each specified output.
     *                               The outputs are specified by their zero-based index, before any change output is added.
     *                               Those recipients will receive less bitcoins than you enter in their corresponding amount field.
     *                               If no outputs are specified here, the sender pays the fee.
     *                                   [vout_index,...]
     *      "replaceable"            (boolean, optional) Marks this transaction as BIP125 replaceable.
     *                               Allows this transaction to be replaced by a transaction with higher fees
     *      "conf_target"            (numeric, optional) Confirmation target (in blocks)
     *      "estimate_mode"          (string, optional, default=UNSET) The fee estimate mode, must be one of:
     *          "UNSET"
     *          "ECONOMICAL"
     *          "CONSERVATIVE"
     *     }
     * </pre>
     * <p>
     * 5. bip32derivs (boolean, optional, default=false) If true, includes the BIP 32 derivation paths for public keys if we know them
     * </p>
     * 
     * <pre>
     *     Result:
     *     {
     *     "psbt": "value",        (string)  The resulting raw transaction (base64-encoded string)
     *     "fee":       n,         (numeric) Fee in BTC the resulting transaction pays
     *     "changepos": n          (numeric) The position of the added change output, or -1
     *     }
     * </pre>
     *
     * @return the object
     */
    public Object walletcreatefundedpsbt() {
        return callRpcMethod(RpcWalletMethodsConstants.WALLET_WALLET_CREATE_FUNDED_PSBT);
    }

    /**
     * <p>
     * Call category: wallet
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The walletprocesspsbt RPC takes as input a PSBT, adds UTXO, key, and script data to inputs and outputs that miss it, and optionally signs
     * inputs. Where possible it also finalizes the partial signatures.
     * </p>
     * <p>
     * Update a PSBT with input information from our wallet and then sign inputs that we can sign for.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "psbt" (string, required) The transaction base64 string
     * </p>
     * <p>
     * 2. sign (boolean, optional, default=true) Also sign the transaction when updating
     * </p>
     * <p>
     * 3. "sighashtype" (string, optional, default=ALL) The signature hash type to sign with if not specified by the PSBT. Must be one of "ALL" "NONE"
     * "SINGLE" "ALL|ANYONECANPAY" "NONE|ANYONECANPAY" "SINGLE|ANYONECANPAY"
     * </p>
     * <p>
     * 4. bip32derivs (boolean, optional, default=false) If true, includes the BIP 32 derivation paths for public keys if we know them
     * </p>
     * 
     * <pre>
     *     
     *     Result:
     *     {
     *     "psbt" : "value",          (string) The base64-encoded partially signed transaction
     *     "complete" : true|false,   (boolean) If the transaction has a complete set of signatures
     *     ]
     * </pre>
     *
     * @return the object
     */
    public Object walletprocesspsbt() {
        return callRpcMethod(RpcWalletMethodsConstants.WALLET_WALLET_PROCESS_PSBT);
    }

}
