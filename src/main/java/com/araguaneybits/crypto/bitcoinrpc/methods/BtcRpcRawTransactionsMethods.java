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

import java.util.List;
import java.util.Map;

import com.araguaneybits.crypto.bitcoinrpc.constants.RpcRawTransactionsMethodsConstants;
import com.araguaneybits.crypto.bitcoinrpc.methods.request.BtcRpcCreateRawTransactionInputRequest;

/**
 * @author jestevez
 */
public class BtcRpcRawTransactionsMethods extends BaseBtcRpcMethods {

    public BtcRpcRawTransactionsMethods(BtcRpcGateway btcRpcGateway) {
        super(btcRpcGateway);
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
    createrawtransaction [{"txid":"id","vout":n},...] [{"address":amount},{"data":"hex"},...] ( locktime ) ( replaceable )
    
    Create a transaction spending the given inputs and creating new outputs.
    Outputs can be addresses or data.
    Returns hex-encoded raw transaction.
    Note that the transaction's inputs are not signed, and
    it is not stored in the wallet or transmitted to the network.
    
    Arguments:
    1. "inputs"                (array, required) A json array of json objects
     [
       {
         "txid":"id",      (string, required) The transaction id
         "vout":n,         (numeric, required) The output number
         "sequence":n      (numeric, optional) The sequence number
       } 
       ,...
     ]
    2. "outputs"               (array, required) a json array with outputs (key-value pairs)
    [
    {
      "address": x.xxx,    (obj, optional) A key-value pair. The key (string) is the bitcoin address, the value (float or string) is the amount in BTC
    },
    {
      "data": "hex"        (obj, optional) A key-value pair. The key must be "data", the value is hex encoded data
    }
    ,...                     More key-value pairs of the above form. For compatibility reasons, a dictionary, which holds the key-value pairs directly, is also
                             accepted as second parameter.
    ]
    3. locktime                  (numeric, optional, default=0) Raw locktime. Non-0 value also locktime-activates inputs
    4. replaceable               (boolean, optional, default=false) Marks this transaction as BIP125 replaceable.
                             Allows this transaction to be replaced by a transaction with higher fees. If provided, it is an error if explicit sequence numbers are incompatible.
    
    Result:
    "transaction"              (string) hex string of the transaction
    
    Examples:
    > bitcoin-cli createrawtransaction "[{\"txid\":\"myid\",\"vout\":0}]" "[{\"address\":0.01}]"
    > bitcoin-cli createrawtransaction "[{\"txid\":\"myid\",\"vout\":0}]" "[{\"data\":\"00010203\"}]"
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "createrawtransaction", "params": ["[{\"txid\":\"myid\",\"vout\":0}]", "[{\"address\":0.01}]"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "createrawtransaction", "params": ["[{\"txid\":\"myid\",\"vout\":0}]", "[{\"data\":\"00010203\"}]"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     */
    public String createRawTransaction(List<BtcRpcCreateRawTransactionInputRequest> inputs, Map<String, String> outputs, Long locktime,
            Boolean replaceable) {
        return (String) callRpcMethod(RpcRawTransactionsMethodsConstants.RAW_TRANSACTIONS_CREATE_RAW_TRANSACTION, inputs, outputs, locktime,
                replaceable);
    }

}
