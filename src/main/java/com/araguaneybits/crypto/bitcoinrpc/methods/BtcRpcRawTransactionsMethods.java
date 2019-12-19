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
import java.util.List;
import java.util.Map;

import com.araguaneybits.crypto.bitcoinrpc.RpcOutputMessage;
import com.araguaneybits.crypto.bitcoinrpc.constants.RpcRawTransactionsMethodsConstants;
import com.araguaneybits.crypto.bitcoinrpc.methods.request.BtcRpcCreateRawTransactionInputRequest;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcAnalyzePsbtResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcDecodePsbtResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcDecodeRawTransactionResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcDecodeScriptResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcFinalizePsbtResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcFundRawTransactionResponse;
import com.araguaneybits.crypto.utils.TransformBeanUtils;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * The Class BtcRpcRawTransactionsMethods.
 *
 * @author jestevez
 */
public class BtcRpcRawTransactionsMethods extends BaseBtcRpcMethods {

    /**
     * Instantiates a new btc rpc raw transactions methods.
     *
     * @param btcRpcGateway the btc rpc gateway
     */
    public BtcRpcRawTransactionsMethods(BtcRpcGateway btcRpcGateway) {
        super(btcRpcGateway);
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.18.0
     * </p>
     * <p>
     * The analyzepsbt RPC examines a PSBT and provides information about what the PSBT contains and the next steps that need to be taken in order to
     * complete the transaction. For each input of a PSBT, analyzepsbt provides information about what information is missing for that input,
     * including whether a UTXO needs to be provided, what pubkeys still need to be provided, which scripts need to be provided, and what signatures
     * are still needed. Every input will also list which role is needed to complete that input, and analyzepsbt will also list the next role in
     * general needed to complete the PSBT. analyzepsbt will also provide the estimated fee rate and estimated virtual size of the completed
     * transaction if it has enough information to do so.
     * </p>
     * <p>
     * Analyzes and provides information about the current status of a PSBT and its inputs
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. psbt (string, required) A base64 string of a PSBT
     * </p>
     * 
     * <pre>
     *     Result:
     *     {
     *     "inputs" : [                      (array of json objects)
     *     {
     *       "has_utxo" : true|false     (boolean) Whether a UTXO is provided
     *       "is_final" : true|false     (boolean) Whether the input is finalized
     *       "missing" : {               (json object, optional) Things that are missing that are required to complete this input
     *         "pubkeys" : [             (array, optional)
     *           "keyid"                 (string) Public key ID, hash160 of the public key, of a public key whose BIP 32 derivation path is missing
     *         ]
     *         "signatures" : [          (array, optional)
     *           "keyid"                 (string) Public key ID, hash160 of the public key, of a public key whose signature is missing
     *         ]
     *         "redeemscript" : "hash"   (string, optional) Hash160 of the redeemScript that is missing
     *         "witnessscript" : "hash"  (string, optional) SHA256 of the witnessScript that is missing
     *       }
     *       "next" : "role"             (string, optional) Role of the next person that this input needs to go to
     *     }
     *     ,...
     *     ]
     *     "estimated_vsize" : vsize       (numeric, optional) Estimated vsize of the final signed transaction
     *     "estimated_feerate" : feerate   (numeric, optional) Estimated feerate of the final signed transaction in BTC/kB. Shown only if all UTXO slots in the PSBT have been filled.
     *     "fee" : fee                     (numeric, optional) The transaction fee paid. Shown only if all UTXO slots in the PSBT have been filled.
     *     "next" : "role"                 (string) Role of the next person that this psbt needs to go to
     *     }
     * </pre>
     *
     * @param psbt the psbt
     * @return the btc rpc analyze psbt response
     */
    public BtcRpcAnalyzePsbtResponse analyzePsbt(String psbt) {
        String json = callSimpleRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_ANALYZE_PSBT, psbt);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcAnalyzePsbtResponse>>() {
                });
        return (BtcRpcAnalyzePsbtResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * Call category: rawtransactions Available since: 0.17.0 The combinepsbt RPC implements a Combiner. It can be used at any point in the workflow
     * to merge information added to different versions of the same PSBT. In particular it is useful to combine the output of multiple Updaters or
     * Signers.
     * </p>
     * <p>
     * Combine multiple partially signed Bitcoin transactions into one transaction. Implements the Combiner role.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "txs" (string) A json array of base64 strings of partially signed transactions [ "psbt" (string) A base64 string of a PSBT ,... ]
     * </p>
     * 
     * <pre>
     *     Result:
     *     "psbt"          (string) The base64-encoded partially signed transaction
     * </pre>
     *
     * @param txs the txs
     * @return the string
     */
    public String combinePsbt(String[] txs) {
        return (String) callRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_COMBINE_PSBT, txs);
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.15.0
     * </p>
     * <p>
     * The combinerawtransaction RPC combines multiple partially signed transactions into one transaction. The combined transaction may be another
     * partially signed transaction or a fully signed transaction.
     * </p>
     * <p>
     * Combine multiple partially signed transactions into one transaction. The combined transaction may be another partially signed transaction or a
     * fully signed transaction.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * Arguments: 1. "txs" (string) A json array of hex strings of partially signed transactions [ "hexstring" (string) A transaction hash ,... ]
     * </p>
     * 
     * <pre>
     *     Result:
     *     "hex"            (string) The hex-encoded raw transaction with signature(s)
     * </pre>
     *
     * @param hexstring the hexstring
     * @return the string
     */
    public String combineRawTransaction(String[] hexstring) {
        return (String) callRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_COMBINE_RAW_TRANSACTION, hexstring);
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The converttopsbt RPC converts an unsigned raw transaction to PSBT format. It ignores existing signatures.
     * </p>
     * <p>
     * Converts a network serialized transaction to a PSBT. This should be used only with createrawtransaction and fundrawtransaction createpsbt and
     * walletcreatefundedpsbt should be used for new applications.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "hexstring" (string, required) The hex string of a raw transaction
     * </p>
     * <p>
     * 2. permitsigdata (boolean, optional, default=false) If true, any signatures in the input will be discarded and conversion. will continue. If
     * false, RPC will fail if any signatures are present.
     * </p>
     * <p>
     * 3. iswitness (boolean, optional) Whether the transaction hex is a serialized witness transaction. If iswitness is not present, heuristic tests
     * will be used in decoding. If true, only witness deserializaion will be tried. If false, only non-witness deserialization wil be tried. Only has
     * an effect if permitsigdata is true.
     * </p>
     * <p>
     * 4.
     * </p>
     * 
     * <pre>
     *     Result:
     *     "psbt"        (string)  The resulting raw transaction (base64-encoded string)
     * </pre>
     *
     * @param hexstring the hexstring
     * @param permitsigdata the permitsigdata
     * @param iswitness the iswitness
     * @return the string
     */
    public String convertToPsbt(String hexstring, Boolean permitsigdata, Boolean iswitness) {
        return (String) callRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_CONVERT_TO_PSBT, hexstring, permitsigdata, iswitness);
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The createpsbt RPC takes a list of inputs and outputs and converts them to a PSBT with no additional information. It is equivalent to calling
     * createrawtransaction followed by converttopsbt.
     * </p>
     * <p>
     * Creates a transaction in the Partially Signed Transaction format. Implements the Creator role.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "inputs" (array, required) A json array of json objects [ { "txid":"id", (string, required) The transaction id "vout":n, (numeric, required)
     * The output number "sequence":n (numeric, optional) The sequence number } ,... ]
     * </p>
     * <p>
     * 2. "outputs" (array, required) a json array with outputs (key-value pairs) [ { "address": x.xxx, (obj, optional) A key-value pair. The key
     * (string) is the bitcoin address, the value (float or string) is the amount in BTC }, { "data": "hex" (obj, optional) A key-value pair. The key
     * must be "data", the value is hex encoded data } ,... More key-value pairs of the above form. For compatibility reasons, a dictionary, which
     * holds the key-value pairs directly, is also accepted as second parameter. ]
     * </p>
     * <p>
     * 3. locktime (numeric, optional, default=0) Raw locktime. Non-0 value also locktime-activates inputs
     * </p>
     * <p>
     * 4. replaceable (boolean, optional, default=false) Marks this transaction as BIP125 replaceable. Allows this transaction to be replaced by a
     * transaction with higher fees. If provided, it is an error if explicit sequence numbers are incompatible.
     * </p>
     * 
     * <pre>
     *     Result:
     *     "psbt"        (string)  The resulting raw transaction (base64-encoded string)
     * </pre>
     *
     * @param inputs the inputs
     * @param outputs the outputs
     * @param locktime the locktime
     * @param replaceable the replaceable
     * @return the string
     */
    public String createPsbt(List<BtcRpcCreateRawTransactionInputRequest> inputs, Map<String, String> outputs, Long locktime, Boolean replaceable) {
        return (String) callRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_CREATE_PSBT, inputs, outputs, locktime, replaceable);
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.7.0
     * </p>
     * <p>
     * The createrawtransaction RPC creates an unsigned serialized transaction that spends a previous output to a new output with a P2PKH or P2SH
     * address. The transaction is not stored in the wallet or transmitted to the network.
     * </p>
     * 
     * <pre>
     *     createrawtransaction [{"txid":"id","vout":n},...] [{"address":amount},{"data":"hex"},...] ( locktime ) ( replaceable )
     *     
     *     Create a transaction spending the given inputs and creating new outputs.
     *     Outputs can be addresses or data.
     *     Returns hex-encoded raw transaction.
     *     Note that the transaction's inputs are not signed, and
     *     it is not stored in the wallet or transmitted to the network.
     *     
     *     Arguments:
     *     1. "inputs"                (array, required) A json array of json objects
     *      [
     *        {
     *          "txid":"id",      (string, required) The transaction id
     *          "vout":n,         (numeric, required) The output number
     *          "sequence":n      (numeric, optional) The sequence number
     *        } 
     *        ,...
     *      ]
     *     2. "outputs"               (array, required) a json array with outputs (key-value pairs)
     *     [
     *     {
     *       "address": x.xxx,    (obj, optional) A key-value pair. The key (string) is the bitcoin address, the value (float or string) is the amount in BTC
     *     },
     *     {
     *       "data": "hex"        (obj, optional) A key-value pair. The key must be "data", the value is hex encoded data
     *     }
     *     ,...                     More key-value pairs of the above form. For compatibility reasons, a dictionary, which holds the key-value pairs directly, is also
     *                              accepted as second parameter.
     *     ]
     *     3. locktime                  (numeric, optional, default=0) Raw locktime. Non-0 value also locktime-activates inputs
     *     4. replaceable               (boolean, optional, default=false) Marks this transaction as BIP125 replaceable.
     *                              Allows this transaction to be replaced by a transaction with higher fees. If provided, it is an error if explicit sequence numbers are incompatible.
     *     
     *     Result:
     *     "transaction"              (string) hex string of the transaction
     *     
     *     Examples:
     *     > bitcoin-cli createrawtransaction "[{\"txid\":\"myid\",\"vout\":0}]" "[{\"address\":0.01}]"
     *     > bitcoin-cli createrawtransaction "[{\"txid\":\"myid\",\"vout\":0}]" "[{\"data\":\"00010203\"}]"
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "createrawtransaction", "params": ["[{\"txid\":\"myid\",\"vout\":0}]", "[{\"address\":0.01}]"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "createrawtransaction", "params": ["[{\"txid\":\"myid\",\"vout\":0}]", "[{\"data\":\"00010203\"}]"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param inputs the inputs
     * @param outputs the outputs
     * @param locktime the locktime
     * @param replaceable the replaceable
     * @return the string
     */
    public String createRawTransaction(List<BtcRpcCreateRawTransactionInputRequest> inputs, Map<String, String> outputs, Long locktime,
            Boolean replaceable) {
        return (String) callRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_CREATE_RAW_TRANSACTION, inputs, outputs, locktime,
                replaceable);
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The decodepsbt RPC shows all information in a PSBT in human-readable form, as well as compute its eventual fee if known.
     * </p>
     * <p>
     * Return a JSON object representing the serialized, base64-encoded partially signed Bitcoin transaction.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "psbt" (string, required) The PSBT base64 string
     * </p>
     * 
     * <pre>
     *     Result:
     *     {
     *     "tx" : {                   (json object) The decoded network-serialized unsigned transaction.
     *     ...                                      The layout is the same as the output of decoderawtransaction.
     *     },
     *     "unknown" : {                (json object) The unknown global fields
     *     "key" : "value"            (key-value pair) An unknown key-value pair
     *      ...
     *     },
     *     "inputs" : [                 (array of json objects)
     *     {
     *       "non_witness_utxo" : {   (json object, optional) Decoded network transaction for non-witness UTXOs
     *         ...
     *       },
     *       "witness_utxo" : {            (json object, optional) Transaction output for witness UTXOs
     *         "amount" : x.xxx,           (numeric) The value in BTC
     *         "scriptPubKey" : {          (json object)
     *           "asm" : "asm",            (string) The asm
     *           "hex" : "hex",            (string) The hex
     *           "type" : "pubkeyhash",    (string) The type, eg 'pubkeyhash'
     *           "address" : "address"     (string) Bitcoin address if there is one
     *         }
     *       },
     *       "partial_signatures" : {             (json object, optional)
     *         "pubkey" : "signature",           (string) The public key and signature that corresponds to it.
     *         ,...
     *       }
     *       "sighash" : "type",                  (string, optional) The sighash type to be used
     *       "redeem_script" : {       (json object, optional)
     *           "asm" : "asm",            (string) The asm
     *           "hex" : "hex",            (string) The hex
     *           "type" : "pubkeyhash",    (string) The type, eg 'pubkeyhash'
     *         }
     *       "witness_script" : {       (json object, optional)
     *           "asm" : "asm",            (string) The asm
     *           "hex" : "hex",            (string) The hex
     *           "type" : "pubkeyhash",    (string) The type, eg 'pubkeyhash'
     *         }
     *       "bip32_derivs" : {          (json object, optional)
     *         "pubkey" : {                     (json object, optional) The public key with the derivation path as the value.
     *           "master_fingerprint" : "fingerprint"     (string) The fingerprint of the master key
     *           "path" : "path",                         (string) The path
     *         }
     *         ,...
     *       }
     *       "final_scriptsig" : {       (json object, optional)
     *           "asm" : "asm",            (string) The asm
     *           "hex" : "hex",            (string) The hex
     *         }
     *        "final_scriptwitness": ["hex", ...] (array of string) hex-encoded witness data (if any)
     *       "unknown" : {                (json object) The unknown global fields
     *         "key" : "value"            (key-value pair) An unknown key-value pair
     *          ...
     *       },
     *     }
     *     ,...
     *     ]
     *     "outputs" : [                 (array of json objects)
     *     {
     *       "redeem_script" : {       (json object, optional)
     *           "asm" : "asm",            (string) The asm
     *           "hex" : "hex",            (string) The hex
     *           "type" : "pubkeyhash",    (string) The type, eg 'pubkeyhash'
     *         }
     *       "witness_script" : {       (json object, optional)
     *           "asm" : "asm",            (string) The asm
     *           "hex" : "hex",            (string) The hex
     *           "type" : "pubkeyhash",    (string) The type, eg 'pubkeyhash'
     *       }
     *       "bip32_derivs" : [          (array of json objects, optional)
     *         {
     *           "pubkey" : "pubkey",                     (string) The public key this path corresponds to
     *           "master_fingerprint" : "fingerprint"     (string) The fingerprint of the master key
     *           "path" : "path",                         (string) The path
     *           }
     *         }
     *         ,...
     *       ],
     *       "unknown" : {                (json object) The unknown global fields
     *         "key" : "value"            (key-value pair) An unknown key-value pair
     *          ...
     *       },
     *     }
     *     ,...
     *     ]
     *     "fee" : fee                      (numeric, optional) The transaction fee paid if all UTXOs slots in the PSBT have been filled.
     *     }
     * </pre>
     *
     * @param psbt the psbt
     * @return the btc rpc decode psbt response
     */
    public BtcRpcDecodePsbtResponse decodePsbt(String psbt) {
        String json = callSimpleRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_DECODE_PSBT, psbt);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcDecodePsbtResponse>>() {
                });
        return (BtcRpcDecodePsbtResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.7.0
     * </p>
     * <p>
     * The decoderawtransaction RPC decodes a serialized transaction hex string into a JSON object describing the transaction.
     * </p>
     * <p>
     * Return a JSON object representing the serialized, hex-encoded transaction.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "hexstring" (string, required) The transaction hex string
     * </p>
     * <p>
     * 2. iswitness (boolean, optional) Whether the transaction hex is a serialized witness transaction If iswitness is not present, heuristic tests
     * will be used in decoding
     * </p>
     * 
     * <pre>
     *     Result:
     *     {
     *     "txid" : "id",        (string) The transaction id
     *     "hash" : "id",        (string) The transaction hash (differs from txid for witness transactions)
     *     "size" : n,             (numeric) The transaction size
     *     "vsize" : n,            (numeric) The virtual transaction size (differs from size for witness transactions)
     *     "weight" : n,           (numeric) The transaction's weight (between vsize*4 - 3 and vsize*4)
     *     "version" : n,          (numeric) The version
     *     "locktime" : ttt,       (numeric) The lock time
     *     "vin" : [               (array of json objects)
     *      {
     *        "txid": "id",    (string) The transaction id
     *        "vout": n,         (numeric) The output number
     *        "scriptSig": {     (json object) The script
     *          "asm": "asm",  (string) asm
     *          "hex": "hex"   (string) hex
     *        },
     *        "txinwitness": ["hex", ...] (array of string) hex-encoded witness data (if any)
     *        "sequence": n     (numeric) The script sequence number
     *      }
     *      ,...
     *     ],
     *     "vout" : [             (array of json objects)
     *      {
     *        "value" : x.xxx,            (numeric) The value in BTC
     *        "n" : n,                    (numeric) index
     *        "scriptPubKey" : {          (json object)
     *          "asm" : "asm",          (string) the asm
     *          "hex" : "hex",          (string) the hex
     *          "reqSigs" : n,            (numeric) The required sigs
     *          "type" : "pubkeyhash",  (string) The type, eg 'pubkeyhash'
     *          "addresses" : [           (json array of string)
     *            "12tvKAXCxZjSmdNbao16dKXC8tRWfcF5oc"   (string) bitcoin address
     *            ,...
     *          ]
     *        }
     *      }
     *      ,...
     *     ],
     *     }
     * </pre>
     *
     * @param hexstring the hexstring
     * @param iswitness the iswitness
     * @return the btc rpc decode raw transaction response
     */
    public BtcRpcDecodeRawTransactionResponse decodeRawTransaction(String hexstring, Boolean iswitness) {
        String json = callSimpleRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_DECODE_RAW_TRANSACTION, hexstring, iswitness);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcDecodeRawTransactionResponse>>() {
                });
        return (BtcRpcDecodeRawTransactionResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.9.0
     * </p>
     * <p>
     * The decodescript RPC decodes a hex-encoded P2SH redeem script.
     * </p>
     * <p>
     * Decode a hex-encoded script.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "hexstring" (string) the hex encoded script
     * </p>
     * 
     * <pre>
     *     Result:
     *     {
     *     "asm":"asm",   (string) Script public key
     *     "hex":"hex",   (string) hex encoded public key
     *     "type":"type", (string) The output type
     *     "reqSigs": n,    (numeric) The required signatures
     *     "addresses": [   (json array of string)
     *      "address"     (string) bitcoin address
     *      ,...
     *     ],
     *     "p2sh","address" (string) address of P2SH script wrapping this redeem script (not returned if the script is already a P2SH).
     *     }
     * </pre>
     *
     * @param hexstring the hexstring
     * @return the btc rpc decode script response
     */
    public BtcRpcDecodeScriptResponse decodeScript(String hexstring) {
        String json = callSimpleRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_DECODE_SCRIPT, hexstring);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcDecodeScriptResponse>>() {
                });
        return (BtcRpcDecodeScriptResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The finalizepsbt RPC finalizes any partial signatures, and if all inputs are finalized, converts the result to a fully signed transaction which
     * can be broadcast with sendrawtransaction.
     * </p>
     * <p>
     * Finalize the inputs of a PSBT. If the transaction is fully signed, it will produce a network serialized transaction which can be broadcast with
     * sendrawtransaction. Otherwise a PSBT will be created which has the final_scriptSig and final_scriptWitness fields filled for inputs that are
     * complete. Implements the Finalizer and Extractor roles.
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "psbt" (string) A base64 string of a PSBT
     * </p>
     * <p>
     * 2. "extract" (boolean, optional, default=true) If true and the transaction is complete, extract and return the complete transaction in normal
     * network serialization instead of the PSBT.
     * </p>
     * <p>
     * 
     * <pre>
     *     Result:
     *     {
     *     "psbt" : "value",          (string) The base64-encoded partially signed transaction if not extracted
     *     "hex" : "value",           (string) The hex-encoded network transaction if extracted
     *     "complete" : true|false,   (boolean) If the transaction has a complete set of signatures
     *     ]
     *     }
     * </pre>
     *
     * @param psbt the psbt
     * @param extract the extract
     * @return the btc rpc finalize psbt response
     */
    public BtcRpcFinalizePsbtResponse finalizePsbt(String psbt, Boolean extract) {
        String json = callSimpleRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_FINALIZE_PSBT, psbt, extract);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcFinalizePsbtResponse>>() {
                });
        return (BtcRpcFinalizePsbtResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.12.0
     * </p>
     * <p>
     * The fundrawtransaction RPC adds inputs to a transaction until it has enough in value to meet its out value.
     * </p>
     * <p>
     * Add inputs to a transaction until it has enough in value to meet its out value. This will not modify existing inputs, and will add at most one
     * change output to the outputs. No existing outputs will be modified unless "subtractFeeFromOutputs" is specified. Note that inputs which were
     * signed may need to be resigned after completion since in/outputs have been added. The inputs added will not be signed, use signrawtransaction
     * for that. Note that all existing inputs must have their previous output transaction be in the wallet. Note that all inputs selected must be of
     * standard form and P2SH scripts must be in the wallet using importaddress or addmultisigaddress (to calculate fees). You can see whether this is
     * the case by checking the "solvable" field in the listunspent output. Only pay-to-pubkey, multisig, and P2SH versions thereof are currently
     * supported for watch-only
     * </p>
     * <p>
     * Arguments:
     * </p>
     * <p>
     * 1. "hexstring" (string, required) The hex string of the raw transaction
     * </p>
     * <p>
     * 2. options (object, optional) for backward compatibility: passing in a true instead of an object will result in {"includeWatching":true}
     * </p>
     * 
     * <pre>
     *       {
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
     * 3. iswitness (boolean, optional) Whether the transaction hex is a serialized witness transaction If iswitness is not present, heuristic tests
     * will be used in decoding
     * </p>
     * 
     * <pre>
     *     {
     *     "hex":       "value", (string)  The resulting raw transaction (hex-encoded string)
     *     "fee":       n,         (numeric) Fee in BTC the resulting transaction pays
     *     "changepos": n          (numeric) The position of the added change output, or -1
     *     }
     * </pre>
     *
     * @param rawtransactionhex the rawtransactionhex
     * @return the btc rpc fund raw transaction response
     */
    public BtcRpcFundRawTransactionResponse fundRawTransaction(String rawtransactionhex) {
        String json = callSimpleRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_FUNDRAW_TRANSACTION, rawtransactionhex);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcFundRawTransactionResponse>>() {
                });
        return (BtcRpcFundRawTransactionResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.7.0
     * </p>
     * <p>
     * The getrawtransaction RPC gets a hex-encoded serialized transaction or a JSON object describing the transaction. By default, Bitcoin Core only
     * stores complete transaction data for UTXOs and your own transactions, so the RPC may fail on historic transactions unless you use the
     * non-default `txindex=1` in your Bitcoin Core startup settings.
     * </p>
     * 
     * <pre>
     *     getrawtransaction "txid" ( verbose "blockhash" )
     *     
     *     Return the raw transaction data.
     *     
     *     By default this function only works for mempool transactions. When called with a blockhash
     *     argument, getrawtransaction will return the transaction if the specified block is available and
     *     the transaction is found in that block. When called without a blockhash argument, getrawtransaction
     *     will return the transaction if it is in the mempool, or if -txindex is enabled and the transaction
     *     is in a block in the blockchain.
     *     
     *     Hint: Use gettransaction for wallet transactions.
     *     
     *     If verbose is 'true', returns an Object with information about 'txid'.
     *     If verbose is 'false' or omitted, returns a string that is serialized, hex-encoded data for 'txid'.
     *     
     *     Arguments:
     *     1. txid         (string, required) The transaction id
     *     2. verbose      (boolean, optional, default=false) If false, return a string, otherwise return a json object
     *     3. blockhash    (string, optional) The block in which to look for the transaction
     *     
     *     Result (if verbose is not set or set to false):
     *     "data"      (string) The serialized, hex-encoded data for 'txid'
     *     
     *     Result (if verbose is set to true):
     *     {
     *     "in_active_chain": b, (bool) Whether specified block is in the active chain or not (only present with explicit "blockhash" argument)
     *     "hex" : "data",       (string) The serialized, hex-encoded data for 'txid'
     *     "txid" : "id",        (string) The transaction id (same as provided)
     *     "hash" : "id",        (string) The transaction hash (differs from txid for witness transactions)
     *     "size" : n,             (numeric) The serialized transaction size
     *     "vsize" : n,            (numeric) The virtual transaction size (differs from size for witness transactions)
     *     "weight" : n,           (numeric) The transaction's weight (between vsize*4-3 and vsize*4)
     *     "version" : n,          (numeric) The version
     *     "locktime" : ttt,       (numeric) The lock time
     *     "vin" : [               (array of json objects)
     *      {
     *        "txid": "id",    (string) The transaction id
     *        "vout": n,         (numeric) 
     *        "scriptSig": {     (json object) The script
     *          "asm": "asm",  (string) asm
     *          "hex": "hex"   (string) hex
     *        },
     *        "sequence": n      (numeric) The script sequence number
     *        "txinwitness": ["hex", ...] (array of string) hex-encoded witness data (if any)
     *      }
     *      ,...
     *     ],
     *     "vout" : [              (array of json objects)
     *      {
     *        "value" : x.xxx,            (numeric) The value in BTC
     *        "n" : n,                    (numeric) index
     *        "scriptPubKey" : {          (json object)
     *          "asm" : "asm",          (string) the asm
     *          "hex" : "hex",          (string) the hex
     *          "reqSigs" : n,            (numeric) The required sigs
     *          "type" : "pubkeyhash",  (string) The type, eg 'pubkeyhash'
     *          "addresses" : [           (json array of string)
     *            "address"        (string) bitcoin address
     *            ,...
     *          ]
     *        }
     *      }
     *      ,...
     *     ],
     *     "blockhash" : "hash",   (string) the block hash
     *     "confirmations" : n,      (numeric) The confirmations
     *     "blocktime" : ttt         (numeric) The block time in seconds since epoch (Jan 1 1970 GMT)
     *     "time" : ttt,             (numeric) Same as "blocktime"
     *     }
     *     
     *     Examples:
     *     > bitcoin-cli getrawtransaction "mytxid"
     *     > bitcoin-cli getrawtransaction "mytxid" true
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getrawtransaction", "params": ["mytxid", true] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     *     > bitcoin-cli getrawtransaction "mytxid" false "myblockhash"
     *     > bitcoin-cli getrawtransaction "mytxid" true "myblockhash"
     * </pre>
     *
     * @param txid the txid
     * @param verbose the verbose
     * @param blockhash the blockhash
     * @return the raw transaction
     */
    public BtcRpcDecodeRawTransactionResponse getRawTransaction(String txid, Boolean verbose, String blockhash) {
        String json = callSimpleRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_GET_RAW_TRANSACTION, txid, verbose);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcDecodeRawTransactionResponse>>() {
                });
        return (BtcRpcDecodeRawTransactionResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.18.0
     * </p>
     * <p>
     * The joinpsbts RPC merges multiple distinct PSBTs into a single PSBT. The multiple PSBTs must have different inputs. The resulting PSBT will
     * contain every input and output from all of the PSBTs. Any signatures provided in any of the PSBTs will be dropped.
     * </p>
     * 
     * <pre>
     *     joinpsbts ["psbt",...]
     *     
     *     Joins multiple distinct PSBTs with different inputs and outputs into one PSBT with inputs and outputs from all of the PSBTs
     *     No input in any of the PSBTs can be in more than one of the PSBTs.
     *     
     *     Arguments:
     *     1. txs            (json array, required) A json array of base64 strings of partially signed transactions
     *      [
     *        "psbt",    (string, required) A base64 string of a PSBT
     *        ...
     *      ]
     *     
     *     Result:
     *     "psbt"          (string) The base64-encoded partially signed transaction
     *     
     *     Examples:
     *     > bitcoin-cli joinpsbts "psbt"
     * </pre>
     *
     * @param txs the txs
     * @return the object
     */
    public Object joinPsbts(String[] txs) {
        return callRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_JOIN_PSBTS, txs);
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.7.0
     * </p>
     * <p>
     * The sendrawtransaction RPC validates a transaction and broadcasts it to the peer-to-peer network.
     * </p>
     * 
     * <pre>
     *     sendrawtransaction "hexstring" ( allowhighfees )
     *     
     *     Submits raw transaction (serialized, hex-encoded) to local node and network.
     *     
     *     Also see createrawtransaction and signrawtransaction calls.
     *     
     *     Arguments:
     *     1. "hexstring"    (string, required) The hex string of the raw transaction)
     *     2. allowhighfees    (boolean, optional, default=false) Allow high fees
     *     
     *     Result:
     *     "hex"             (string) The transaction hash in hex
     *     
     *     Examples:
     *     
     *     Create a transaction
     *     > bitcoin-cli createrawtransaction "[{\"txid\" : \"mytxid\",\"vout\":0}]" "{\"myaddress\":0.01}"
     *     Sign the transaction, and get back the hex
     *     > bitcoin-cli signrawtransaction "myhex"
     *     
     *     Send the transaction (signed hex)
     *     > bitcoin-cli sendrawtransaction "signedhex"
     *     
     *     As a json rpc call
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "sendrawtransaction", "params": ["signedhex"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param hex the hex
     * @param maxFeeRate the max fee rate
     * @return the string
     */
    public String sendRawTransaction(String hex, BigDecimal maxFeeRate) {
        return (String) callRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_SEND_RAW_TRANSACTION, hex);
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The signrawtransactionwithkey RPC signs inputs for raw transaction
     * </p>
     * 
     * <pre>
     *     signrawtransactionwithkey "hexstring" ["privatekey",...] ( [{"txid":"hex","vout":n,"scriptPubKey":"hex","redeemScript":"hex","witnessScript":"hex","amount":amount},...] "sighashtype" )
     *     
     *     Sign inputs for raw transaction (serialized, hex-encoded).
     *     The second argument is an array of base58-encoded private
     *     keys that will be the only keys used to sign the transaction.
     *     The third optional argument (may be null) is an array of previous transaction outputs that
     *     this transaction depends on but may not yet be in the block chain.
     *     
     *     Arguments:
     *     1. hexstring                        (string, required) The transaction hex string
     *     2. privkeys                         (json array, required) A json array of base58-encoded private keys for signing
     *      [
     *        "privatekey",                (string) private key in base58-encoding
     *        ...
     *      ]
     *     3. prevtxs                          (json array, optional) A json array of previous dependent transaction outputs
     *      [
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
     *     4. sighashtype                      (string, optional, default=ALL) The signature hash type. Must be one of:
     *                                     "ALL"
     *                                     "NONE"
     *                                     "SINGLE"
     *                                     "ALL|ANYONECANPAY"
     *                                     "NONE|ANYONECANPAY"
     *                                     "SINGLE|ANYONECANPAY"
     *                                     
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
     *     
     *     Examples:
     *     > bitcoin-cli signrawtransactionwithkey "myhex"
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "signrawtransactionwithkey", "params": ["myhex"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the object
     */
    public Object signrawtransactionwithkey() {
        return callRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_SIGN_RAW_TRANSACTION_WITH_KEY);
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * he testmempoolaccept RPC tests acceptance of a transaction to the mempool without adding it.
     * </p>
     * 
     * <pre>
     *     
     *     testmempoolaccept ["rawtxs"] ( allowhighfees )
     *     
     *     Returns if raw transaction (serialized, hex-encoded) would be accepted by mempool.
     *     
     *     This checks if the transaction violates the consensus or policy rules.
     *     
     *     See sendrawtransaction call.
     *     
     *     Arguments:
     *     1. ["rawtxs"]       (array, required) An array of hex strings of raw transactions.
     *                                         Length must be one for now.
     *     2. allowhighfees    (boolean, optional, default=false) Allow high fees
     *     
     *     Result:
     *     [                   (array) The result of the mempool acceptance test for each raw transaction in the input array.
     *                             Length is exactly one for now.
     *     {
     *     "txid"           (string) The transaction hash in hex
     *     "allowed"        (boolean) If the mempool allows this tx to be inserted
     *     "reject-reason"  (string) Rejection string (only present when 'allowed' is false)
     *     }
     *     ]
     *     
     *     Examples:
     *     
     *     Create a transaction
     *     > bitcoin-cli createrawtransaction "[{\"txid\" : \"mytxid\",\"vout\":0}]" "{\"myaddress\":0.01}"
     *     Sign the transaction, and get back the hex
     *     > bitcoin-cli signrawtransaction "myhex"
     *     
     *     Test acceptance of the transaction (signed hex)
     *     > bitcoin-cli testmempoolaccept "signedhex"
     *     
     *     As a json rpc call
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "testmempoolaccept", "params": [["signedhex"]] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the object
     */
    public Object testmempoolaccept() {
        return callRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_TEST_MEMPOOL_ACCEPT);
    }

    /**
     * <p>
     * Call category: rawtransactions
     * </p>
     * <p>
     * Available since: 0.18.0
     * </p>
     * <p>
     * The utxoupdatepsbt RPC searches the set of Unspent Transaction Outputs (UTXOs) to find the outputs being spent by the partial transaction.
     * PSBTs need to have the UTXOs being spent to be provided because the signing algorithm requires information from the UTXO being spent. For
     * segwit inputs, only the UTXO itself is necessary. For non-segwit outputs, the entire previous transaction is needed so that signers can be sure
     * that they are signing the correct thing. Unfortunately, because the UTXO set only contains UTXOs and not full transactions, utxoupdatepsbt will
     * only add the UTXO for segwit inputs.
     * </p>
     * 
     * <pre>
     *     utxoupdatepsbt "psbt"
     *     
     *     Updates a PSBT with witness UTXOs retrieved from the UTXO set or the mempool.
     *     
     *     Arguments:
     *     1. psbt    (string, required) A base64 string of a PSBT
     *     
     *     Result:
     *     "psbt"          (string) The base64-encoded partially signed transaction with inputs updated
     *     
     *     Examples:
     *     > bitcoin-cli utxoupdatepsbt "psbt"
     * </pre>
     *
     * @return the object
     */
    public Object utxoupdatepsbt() {
        return callRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_UTXO_UPDATE_PSBT);
    }

}
