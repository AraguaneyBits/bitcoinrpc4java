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
import java.math.BigInteger;

import com.araguaneybits.crypto.bitcoinrpc.constants.RpcMiningMethodsConstants;

/**
 * @author jestevez
 */
public class BtcRpcMiningMethods extends BaseBtcRpcMethods {
    public BtcRpcMiningMethods(BtcRpcGateway btcRpcGateway) {
        super(btcRpcGateway);
    }

    /**
     * <p>
     * Call category: mining
     * </p>
     * <p>
     * Available since: 0.7.0
     * </p>
     * <p>
     * The getblocktemplate RPC gets a block template or proposal for use with mining software.
     * </p>
     * 
     * <pre>
    
    getblocktemplate "template_request"
    
    If the request parameters include a 'mode' key, that is used to explicitly select between the default 'template' request or a 'proposal'.
    It returns data needed to construct a block to work on.
    For full specification, see BIPs 22, 23, 9, and 145:
    https://github.com/bitcoin/bips/blob/master/bip-0022.mediawiki
    https://github.com/bitcoin/bips/blob/master/bip-0023.mediawiki
    https://github.com/bitcoin/bips/blob/master/bip-0009.mediawiki#getblocktemplate_changes
    https://github.com/bitcoin/bips/blob/master/bip-0145.mediawiki
    
    Arguments:
    1. template_request         (json object, required) A json object in the following spec             
     {
       "mode": "str",       (string, optional) This must be set to "template", "proposal" (see BIP 23), or omitted
       "capabilities": [    (json array, optional) A list of strings
         "support",         (string) client side supported feature, 'longpoll', 'coinbasetxn', 'coinbasevalue', 'proposal', 'serverlist', 'workid'
         ...
       ],
       "rules": [           (json array, required) A list of strings
         "support",         (string) client side supported softfork deployment
         ...
       ],
     }
    
    Result:
    {
    "version" : n,                    (numeric) The preferred block version
    "rules" : [ "rulename", ... ],    (array of strings) specific block rules that are to be enforced
    "vbavailable" : {                 (json object) set of pending, supported versionbit (BIP 9) softfork deployments
      "rulename" : bitnumber          (numeric) identifies the bit number as indicating acceptance and readiness for the named softfork rule
      ,...
    },
    "vbrequired" : n,                 (numeric) bit mask of versionbits the server requires set in submissions
    "previousblockhash" : "xxxx",     (string) The hash of current highest block
    "transactions" : [                (array) contents of non-coinbase transactions that should be included in the next block
      {
         "data" : "xxxx",             (string) transaction data encoded in hexadecimal (byte-for-byte)
         "txid" : "xxxx",             (string) transaction id encoded in little-endian hexadecimal
         "hash" : "xxxx",             (string) hash encoded in little-endian hexadecimal (including witness data)
         "depends" : [                (array) array of numbers 
             n                          (numeric) transactions before this one (by 1-based index in 'transactions' list) that must be present in the final block if this one is
             ,...
         ],
         "fee": n,                    (numeric) difference in value between transaction inputs and outputs (in satoshis); for coinbase transactions, this is a negative Number of the total collected block fees (ie, not including the block subsidy); if key is not present, fee is unknown and clients MUST NOT assume there isn't one
         "sigops" : n,                (numeric) total SigOps cost, as counted for purposes of block limits; if key is not present, sigop cost is unknown and clients MUST NOT assume it is zero
         "weight" : n,                (numeric) total transaction weight, as counted for purposes of block limits
      }
      ,...
    ],
    "coinbaseaux" : {                 (json object) data that should be included in the coinbase's scriptSig content
      "flags" : "xx"                  (string) key name is to be ignored, and value included in scriptSig
    },
    "coinbasevalue" : n,              (numeric) maximum allowable input to coinbase transaction, including the generation award and transaction fees (in satoshis)
    "coinbasetxn" : { ... },          (json object) information for coinbase transaction
    "target" : "xxxx",                (string) The hash target
    "mintime" : xxx,                  (numeric) The minimum timestamp appropriate for next block time in seconds since epoch (Jan 1 1970 GMT)
    "mutable" : [                     (array of string) list of ways the block template may be changed 
     "value"                          (string) A way the block template may be changed, e.g. 'time', 'transactions', 'prevblock'
     ,...
    ],
    "noncerange" : "00000000ffffffff",(string) A range of valid nonces
    "sigoplimit" : n,                 (numeric) limit of sigops in blocks
    "sizelimit" : n,                  (numeric) limit of block size
    "weightlimit" : n,                (numeric) limit of block weight
    "curtime" : ttt,                  (numeric) current timestamp in seconds since epoch (Jan 1 1970 GMT)
    "bits" : "xxxxxxxx",              (string) compressed target of next block
    "height" : n                      (numeric) The height of the next block
    }
    
    Examples:
    > bitcoin-cli getblocktemplate {"rules": ["segwit"]}
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblocktemplate", "params": [{"rules": ["segwit"]}] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     */
    public Object getblocktemplate() {
        // TODO Partially implemented method
        return callRpcMethod(RpcMiningMethodsConstants.MINING_GET_BLOCK_TEMPLATE);
    }

    /**
     * <p>
     * Call category: mining
     * </p>
     * <p>
     * Available since: 0.5.0
     * </p>
     * <p>
     * The getmininginfo RPC returns various mining-related information.
     * </p>
     * 
     * <pre>
    
    getmininginfo
    
    Returns a json object containing mining-related information.
    Result:
    {
    "blocks": nnn,             (numeric) The current block
    "currentblockweight": nnn, (numeric, optional) The block weight of the last assembled block (only present if a block was ever assembled)
    "currentblocktx": nnn,     (numeric, optional) The number of block transactions of the last assembled block (only present if a block was ever assembled)
    "difficulty": xxx.xxxxx    (numeric) The current difficulty
    "networkhashps": nnn,      (numeric) The network hashes per second
    "pooledtx": n              (numeric) The size of the mempool
    "chain": "xxxx",           (string) current network name as defined in BIP70 (main, test, regtest)
    "warnings": "..."          (string) any network and blockchain warnings
    }
    
    Examples:
    > bitcoin-cli getmininginfo 
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getmininginfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     */
    public Object getmininginfo() {
        // TODO Partially implemented method
        return callRpcMethod(RpcMiningMethodsConstants.MINING_GET_MINING_INFO);
    }

    /**
     * <p>
     * Call category: mining
     * </p>
     * <p>
     * Available since: 0.9.0
     * </p>
     * <p>
     * The getnetworkhashps RPC returns the estimated current or historical network hashes per second based on the last *n* blocks.
     * </p>
     * 
     * <pre>
    getnetworkhashps ( nblocks height )
    
    Returns the estimated network hashes per second based on the last n blocks.
    Pass in [blocks] to override # of blocks, -1 specifies since last difficulty change.
    Pass in [height] to estimate the network speed at the time when a certain block was found.
    
    Arguments:
    1. nblocks     (numeric, optional, default=120) The number of blocks, or -1 for blocks since last difficulty change.
    2. height      (numeric, optional, default=-1) To estimate at the time of the given height.
    
    Result:
    x             (numeric) Hashes per second estimated
    
    Examples:
    > bitcoin-cli getnetworkhashps 
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getnetworkhashps", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     */
    public BigDecimal getnetworkhashps(Integer nblocks, Integer height) {
        return (BigDecimal) callRpcMethod(RpcMiningMethodsConstants.MINING_GET_NETWORK_HASHPS, nblocks, height);
    }

    /**
     * <p>
     * Call category: mining
     * </p>
     * <p>
     * Available since: 0.10.0
     * </p>
     * <p>
     * The prioritisetransaction RPC adds virtual priority or fee to a transaction, allowing it to be accepted into blocks mined by this node (or
     * miners which use this node) with a lower priority or fee. (It can also remove virtual priority or fee, requiring the transaction have a higher
     * priority or fee to be accepted into a locally-mined block.)
     * </p>
     * 
     * <pre>
    prioritisetransaction   
    Accepts the transaction into mined blocks at a higher (or lower) priority
    
    Arguments:
    1. "txid"       (string, required) The transaction id.
    2. dummy          (numeric, optional) API-Compatibility for previous API. Must be zero or null.
                  DEPRECATED. For forward compatibility use named arguments and omit this parameter.
    3. fee_delta      (numeric, required) The fee value (in satoshis) to add (or subtract, if negative).
                  Note, that this value is not a fee rate. It is a value to modify absolute fee of the TX.
                  The fee is not actually paid, only the algorithm for selecting transactions into a block
                  considers the transaction as it would have paid a higher (or lower) fee.
    
    Result:
    true              (boolean) Returns true
    
    Examples:
    > bitcoin-cli prioritisetransaction "txid" 0.0 10000
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "prioritisetransaction", "params": ["txid", 0.0, 10000] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     */
    public Boolean prioritisetransaction(String txid, BigInteger feeDelta) {
        return (Boolean) callRpcMethod(RpcMiningMethodsConstants.MINING_PRIORITISE_TRANSACTION, txid, 0.0, feeDelta);
    }

    /**
     * <p>
     * Call category: mining
     * </p>
     * <p>
     * Available since: 0.7.0
     * </p>
     * <p>
     * The submitblock RPC accepts a block, verifies it is a valid addition to the block chain, and broadcasts it to the network. Extra parameters are
     * ignored by Bitcoin Core but may be used by mining pools or other programs.
     * </p>
     * 
     * <pre>
    submitblock "hexdata"  ( "dummy" )
    
    Attempts to submit new block to network.
    See https://en.bitcoin.it/wiki/BIP_0022 for full specification.
    
    Arguments
    1. "hexdata"        (string, required) the hex-encoded block data to submit
    2. "dummy"          (optional) dummy value, for compatibility with BIP22. This value is ignored.
    
    Result:
    
    Examples:
    > bitcoin-cli submitblock "mydata"
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "submitblock", "params": ["mydata"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     */
    public Object submitblock(String hexdata) {
        // TODO Partially implemented method
        return callRpcMethod(RpcMiningMethodsConstants.MINING_SUBMIT_BLOCK, hexdata);
    }

    /**
     * <p>
     * Call category: mining
     * </p>
     * <p>
     * Available since: 0.18.0
     * </p>
     * <p>
     * The submitheader RPC decodes the given hexdata as a header and submits it as a candidate chain tip if valid.
     * </p>
     * 
     * <pre>
    submitheader "hexdata"
    
    Decode the given hexdata as a header and submit it as a candidate chain tip if valid.
    Throws when the header is invalid.
    
    Arguments:
    1. hexdata    (string, required) the hex-encoded block header data
    
    Result:
    None
    Examples:
    > bitcoin-cli submitheader "aabbcc"
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "submitheader", "params": ["aabbcc"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     */
    public Object submitheader() {
        // TODO Partially implemented method
        return callRpcMethod(RpcMiningMethodsConstants.MINING_SUBMIT_HEADER);
    }

    /**
     * <p>
     * Call category: generating
     * </p>
     * <p>
     * Available since: 0.13.0
     * </p>
     * <p>
     * The generatetoaddress RPC mines blocks immediately to a specified address.
     * </p>
     * 
     * <pre>
    generatetoaddress nblocks address (maxtries)
    
    Mine blocks immediately to a specified address (before the RPC call returns)
    
    Arguments:
    1. nblocks      (numeric, required) How many blocks are generated immediately.
    2. address      (string, required) The address to send the newly generated bitcoin to.
    3. maxtries     (numeric, optional) How many iterations to try (default = 1000000).
    
    Result:
    [ blockhashes ]     (array) hashes of blocks generated
    
    Examples:
    
    Generate 11 blocks to myaddress
    > bitcoin-cli generatetoaddress 11 "myaddress"
     * </pre>
     */
    public Object generatetoaddress() {
        // TODO Partially implemented method
        return callRpcMethod(RpcMiningMethodsConstants.GENERATING_GENERATE_TO_ADDRESS);
    }
}
