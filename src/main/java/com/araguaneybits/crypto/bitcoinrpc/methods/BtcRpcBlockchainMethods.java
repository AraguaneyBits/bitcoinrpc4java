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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.araguaneybits.crypto.bitcoinrpc.RpcOutputMessage;
import com.araguaneybits.crypto.bitcoinrpc.constants.EnumBlockVerbosity;
import com.araguaneybits.crypto.bitcoinrpc.constants.RpcBlockchainMethodsConstants;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockHeaderResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockWithTxResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockchainInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetChainTipsResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetChainTxStatsResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetMempoolEntryResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetMempoolInfoResponse;
import com.araguaneybits.crypto.utils.TransformBeanUtils;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * The Class BtcRpcBlockchainMethods.
 *
 * @author jestevez
 */
public class BtcRpcBlockchainMethods extends BaseBtcRpcMethods {

    /**
     * Instantiates a new btc rpc blockchain methods.
     *
     * @param btcRpcGateway the btc rpc gateway
     */
    public BtcRpcBlockchainMethods(BtcRpcGateway btcRpcGateway) {
        super(btcRpcGateway);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.5.0
     * </p>
     * <p>
     * The getbestblockhash RPC returns the header hash of the most recent block on the best block chain.
     * </p>
     * 
     * <pre>
     *     getbestblockhash
     *     
     *     Returns the hash of the best (tip) block in the longest blockchain.
     *     
     *     Result:
     *     "hex"      (string) the block hash hex encoded
     *     
     *     Examples:
     *     > bitcoin-cli getbestblockhash 
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getbestblockhash", "params": [] }
     * </pre>
     *
     * @return the best block hash
     */
    public String getBestBlockHash() {
        return (String) callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_BEST_BLOCK_HASH);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.6.0
     * </p>
     * <p>
     * The getblock RPC gets a block with a particular header hash from the local block database either as a JSON object or as a serialized block.
     * </p>
     * 
     * <pre>
     *     getblock "blockhash" ( verbosity ) 
     *     
     *     If verbosity is 0, returns a string that is serialized, hex-encoded data for block 'hash'.
     *     If verbosity is 1, returns an Object with information about block .
     *     If verbosity is 2, returns an Object with information about block  and information about each transaction. 
     *     
     *     Arguments:
     *     1. "blockhash"          (string, required) The block hash
     *     2. verbosity              (numeric, optional, default=1) 0 for hex encoded data, 1 for a json object, and 2 for json object with transaction data
     *     
     *     Result (for verbosity = 0):
     *     "data"             (string) A string that is serialized, hex-encoded data for block 'hash'.
     *     
     *     Result (for verbosity = 1):
     *     {
     *     "hash" : "hash",     (string) the block hash (same as provided)
     *     "confirmations" : n,   (numeric) The number of confirmations, or -1 if the block is not on the main chain
     *     "size" : n,            (numeric) The block size
     *     "strippedsize" : n,    (numeric) The block size excluding witness data
     *     "weight" : n           (numeric) The block weight as defined in BIP 141
     *     "height" : n,          (numeric) The block height or index
     *     "version" : n,         (numeric) The block version
     *     "versionHex" : "00000000", (string) The block version formatted in hexadecimal
     *     "merkleroot" : "xxxx", (string) The merkle root
     *     "tx" : [               (array of string) The transaction ids
     *      "transactionid"     (string) The transaction id
     *      ,...
     *     ],
     *     "time" : ttt,          (numeric) The block time in seconds since epoch (Jan 1 1970 GMT)
     *     "mediantime" : ttt,    (numeric) The median block time in seconds since epoch (Jan 1 1970 GMT)
     *     "nonce" : n,           (numeric) The nonce
     *     "bits" : "1d00ffff", (string) The bits
     *     "difficulty" : x.xxx,  (numeric) The difficulty
     *     "chainwork" : "xxxx",  (string) Expected number of hashes required to produce the chain up to this block (in hex)
     *     "nTx" : n,             (numeric) The number of transactions in the block.
     *     "previousblockhash" : "hash",  (string) The hash of the previous block
     *     "nextblockhash" : "hash"       (string) The hash of the next block
     *     }
     *     
     *     Result (for verbosity = 2):
     *     {
     *     ...,                     Same output as verbosity = 1.
     *     "tx" : [               (array of Objects) The transactions in the format of the getrawtransaction RPC. Different from verbosity = 1 "tx" result.
     *          ,...
     *     ],
     *     ,...                     Same output as verbosity = 1.
     *     }
     *     
     *     Examples:
     *     > bitcoin-cli getblock "00000000c937983704a73af28acdec37b049d214adbda81d7e2a3dd146f6ed09"
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblock", "params": ["00000000c937983704a73af28acdec37b049d214adbda81d7e2a3dd146f6ed09"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param blockhash the blockhash
     * @return the block
     */
    public String getBlock(String blockhash) {
        return (String) callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_BLOCK, blockhash,
                EnumBlockVerbosity.SERIALIZED_HEX_ENCODED.getValue());
    }

    /**
     * Gets the block object with tx.
     *
     * @param blockhash the blockhash
     * @return the block object with tx
     */
    public BtcRpcGetBlockWithTxResponse getBlockObjectWithTx(String blockhash) {
        String json = callSimpleRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_BLOCK, blockhash,
                EnumBlockVerbosity.OBJECT_AND_TRANSACTION.getValue());
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetBlockWithTxResponse>>() {
                });
        return (BtcRpcGetBlockWithTxResponse) rpcOutputMessage.getResult();
    }

    /**
     * Gets the block object.
     *
     * @param blockhash the blockhash
     * @return the block object
     */
    public BtcRpcGetBlockResponse getBlockObject(String blockhash) {
        String json = callSimpleRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_BLOCK, blockhash, EnumBlockVerbosity.OBJECT.getValue());
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetBlockResponse>>() {
                });
        return (BtcRpcGetBlockResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category:
     * </p>
     * <p>
     * Available since: 0.9.2.1
     * </p>
     * <p>
     * The getblockchaininfo RPC provides information about the current state of the block chain.
     * </p>
     * 
     * <pre>
     *     getblockchaininfo
     *     Returns an object containing various state info regarding blockchain processing.
     *     
     *     Result:
     *     {
     *     "chain": "xxxx",              (string) current network name as defined in BIP70 (main, test, regtest)
     *     "blocks": xxxxxx,             (numeric) the current number of blocks processed in the server
     *     "headers": xxxxxx,            (numeric) the current number of headers we have validated
     *     "bestblockhash": "...",       (string) the hash of the currently best block
     *     "difficulty": xxxxxx,         (numeric) the current difficulty
     *     "mediantime": xxxxxx,         (numeric) median time for the current best block
     *     "verificationprogress": xxxx, (numeric) estimate of verification progress [0..1]
     *     "initialblockdownload": xxxx, (bool) (debug information) estimate of whether this node is in Initial Block Download mode.
     *     "chainwork": "xxxx"           (string) total amount of work in active chain, in hexadecimal
     *     "size_on_disk": xxxxxx,       (numeric) the estimated size of the block and undo files on disk
     *     "pruned": xx,                 (boolean) if the blocks are subject to pruning
     *     "pruneheight": xxxxxx,        (numeric) lowest-height complete block stored (only present if pruning is enabled)
     *     "automatic_pruning": xx,      (boolean) whether automatic pruning is enabled (only present if pruning is enabled)
     *     "prune_target_size": xxxxxx,  (numeric) the target size used by pruning (only present if automatic pruning is enabled)
     *     "softforks": [                (array) status of softforks in progress
     *      {
     *         "id": "xxxx",           (string) name of softfork
     *         "version": xx,          (numeric) block version
     *         "reject": {             (object) progress toward rejecting pre-softfork blocks
     *            "status": xx,        (boolean) true if threshold reached
     *         },
     *      }, ...
     *     ],
     *     "bip9_softforks": {           (object) status of BIP9 softforks in progress
     *      "xxxx" : {                 (string) name of the softfork
     *         "status": "xxxx",       (string) one of "defined", "started", "locked_in", "active", "failed"
     *         "bit": xx,              (numeric) the bit (0-28) in the block version field used to signal this softfork (only for "started" status)
     *         "startTime": xx,        (numeric) the minimum median time past of a block at which the bit gains its meaning
     *         "timeout": xx,          (numeric) the median time past of a block at which the deployment is considered failed if not yet locked in
     *         "since": xx,            (numeric) height of the first block to which the status applies
     *         "statistics": {         (object) numeric statistics about BIP9 signalling for a softfork (only for "started" status)
     *            "period": xx,        (numeric) the length in blocks of the BIP9 signalling period 
     *            "threshold": xx,     (numeric) the number of blocks with the version bit set required to activate the feature 
     *            "elapsed": xx,       (numeric) the number of blocks elapsed since the beginning of the current period 
     *            "count": xx,         (numeric) the number of blocks with the version bit set in the current period 
     *            "possible": xx       (boolean) returns false if there are not enough blocks left in this period to pass activation threshold 
     *         }
     *      }
     *     }
     *     "warnings" : "...",           (string) any network and blockchain warnings.
     *     }
     *     
     *     Examples:
     *     > bitcoin-cli getblockchaininfo 
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblockchaininfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the blockchain info
     */
    public BtcRpcGetBlockchainInfoResponse getBlockchainInfo() {
        String json = callSimpleRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_BLOCKCHAIN_INFO);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetBlockchainInfoResponse>>() {
                });
        return (BtcRpcGetBlockchainInfoResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.5.0
     * </p>
     * <p>
     * The getblockcount RPC returns the number of blocks in the local best block chain.
     * </p>
     * 
     * <pre>
     *     getblockcount
     *     
     *     Returns the number of blocks in the longest blockchain.
     *     
     *     Result:
     *     n    (numeric) The current block count
     *     
     *     Examples:
     *     > bitcoin-cli getblockcount 
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblockcount", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the block count
     */
    public BigInteger getBlockCount() {
        return (BigInteger) callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_BLOCK_COUNT);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.6.0
     * </p>
     * <p>
     * The getblockhash RPC returns the header hash of a block at the given height in the local best block chain.
     * </p>
     * 
     * <pre>
     *     getblockhash height
     *     
     *     Returns hash of block in best-block-chain at height provided.
     *     
     *     Arguments:
     *     1. height         (numeric, required) The height index
     *     
     *     Result:
     *     "hash"         (string) The block hash
     *     
     *     Examples:
     *     > bitcoin-cli getblockhash 1000
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblockhash", "params": [1000] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param height the height
     * @return the block hash
     */
    public String getBlockHash(Long height) {
        return (String) callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_BLOCK_HASH, height);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.12.0
     * </p>
     * <p>
     * The getblockheader RPC gets a block header with a particular header hash from the local block database either as a JSON object or as a
     * serialized block header.
     * </p>
     * 
     * <pre>
     *     getblockheader "hash" ( verbose )
     *     
     *     If verbose is false, returns a string that is serialized, hex-encoded data for blockheader 'hash'.
     *     If verbose is true, returns an Object with information about blockheader .
     *     
     *     Arguments:
     *     1. "hash"          (string, required) The block hash
     *     2. verbose           (boolean, optional, default=true) true for a json object, false for the hex encoded data
     *     
     *     Result (for verbose = true):
     *     {
     *     "hash" : "hash",     (string) the block hash (same as provided)
     *     "confirmations" : n,   (numeric) The number of confirmations, or -1 if the block is not on the main chain
     *     "height" : n,          (numeric) The block height or index
     *     "version" : n,         (numeric) The block version
     *     "versionHex" : "00000000", (string) The block version formatted in hexadecimal
     *     "merkleroot" : "xxxx", (string) The merkle root
     *     "time" : ttt,          (numeric) The block time in seconds since epoch (Jan 1 1970 GMT)
     *     "mediantime" : ttt,    (numeric) The median block time in seconds since epoch (Jan 1 1970 GMT)
     *     "nonce" : n,           (numeric) The nonce
     *     "bits" : "1d00ffff", (string) The bits
     *     "difficulty" : x.xxx,  (numeric) The difficulty
     *     "chainwork" : "0000...1f3"     (string) Expected number of hashes required to produce the current chain (in hex)
     *     "nTx" : n,             (numeric) The number of transactions in the block.
     *     "previousblockhash" : "hash",  (string) The hash of the previous block
     *     "nextblockhash" : "hash",      (string) The hash of the next block
     *     }
     *     
     *     Result (for verbose=false):
     *     "data"             (string) A string that is serialized, hex-encoded data for block 'hash'.
     *     
     *     Examples:
     *     > bitcoin-cli getblockheader "00000000c937983704a73af28acdec37b049d214adbda81d7e2a3dd146f6ed09"
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblockheader", "params": ["00000000c937983704a73af28acdec37b049d214adbda81d7e2a3dd146f6ed09"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param hash the hash
     * @return the block header
     */
    public BtcRpcGetBlockHeaderResponse getBlockHeader(String hash) {
        String json = callSimpleRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_BLOCK_HEADER, hash, true);

        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetBlockHeaderResponse>>() {
                });

        return (BtcRpcGetBlockHeaderResponse) rpcOutputMessage.getResult();
    }

    /**
     * Gets the block header hex.
     *
     * @param hash the hash
     * @return the block header hex
     */
    public String getBlockHeaderHex(String hash) {
        return (String) callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_BLOCK_HEADER, hash, false);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The getblockstats RPC computes per block statistics for a given window. All amounts are in satoshis.
     * </p>
     * 
     * <pre>
     *     getblockstats hash_or_height ( stats )
     *     
     *     Compute per block statistics for a given window. All amounts are in satoshis.
     *     It won't work for some heights with pruning.
     *     It won't work without -txindex for utxo_size_inc, *fee or *feerate stats.
     *     
     *     Arguments:
     *     1. "hash_or_height"     (string or numeric, required) The block hash or height of the target block
     *     2. "stats"              (array,  optional) Values to plot, by default all values (see result below)
     *     [
     *       "height",         (string, optional) Selected statistic
     *       "time",           (string, optional) Selected statistic
     *       ,...
     *     ]
     *     
     *     Result:
     *     {                           (json object)
     *     "avgfee": xxxxx,          (numeric) Average fee in the block
     *     "avgfeerate": xxxxx,      (numeric) Average feerate (in satoshis per virtual byte)
     *     "avgtxsize": xxxxx,       (numeric) Average transaction size
     *     "blockhash": xxxxx,       (string) The block hash (to check for potential reorgs)
     *     "feerate_percentiles": [  (array of numeric) Feerates at the 10th, 25th, 50th, 75th, and 90th percentile weight unit (in satoshis per virtual byte)
     *       "10th_percentile_feerate",      (numeric) The 10th percentile feerate
     *       "25th_percentile_feerate",      (numeric) The 25th percentile feerate
     *       "50th_percentile_feerate",      (numeric) The 50th percentile feerate
     *       "75th_percentile_feerate",      (numeric) The 75th percentile feerate
     *       "90th_percentile_feerate",      (numeric) The 90th percentile feerate
     *     ],
     *     "height": xxxxx,          (numeric) The height of the block
     *     "ins": xxxxx,             (numeric) The number of inputs (excluding coinbase)
     *     "maxfee": xxxxx,          (numeric) Maximum fee in the block
     *     "maxfeerate": xxxxx,      (numeric) Maximum feerate (in satoshis per virtual byte)
     *     "maxtxsize": xxxxx,       (numeric) Maximum transaction size
     *     "medianfee": xxxxx,       (numeric) Truncated median fee in the block
     *     "mediantime": xxxxx,      (numeric) The block median time past
     *     "mediantxsize": xxxxx,    (numeric) Truncated median transaction size
     *     "minfee": xxxxx,          (numeric) Minimum fee in the block
     *     "minfeerate": xxxxx,      (numeric) Minimum feerate (in satoshis per virtual byte)
     *     "mintxsize": xxxxx,       (numeric) Minimum transaction size
     *     "outs": xxxxx,            (numeric) The number of outputs
     *     "subsidy": xxxxx,         (numeric) The block subsidy
     *     "swtotal_size": xxxxx,    (numeric) Total size of all segwit transactions
     *     "swtotal_weight": xxxxx,  (numeric) Total weight of all segwit transactions divided by segwit scale factor (4)
     *     "swtxs": xxxxx,           (numeric) The number of segwit transactions
     *     "time": xxxxx,            (numeric) The block time
     *     "total_out": xxxxx,       (numeric) Total amount in all outputs (excluding coinbase and thus reward [ie subsidy + totalfee])
     *     "total_size": xxxxx,      (numeric) Total size of all non-coinbase transactions
     *     "total_weight": xxxxx,    (numeric) Total weight of all non-coinbase transactions divided by segwit scale factor (4)
     *     "totalfee": xxxxx,        (numeric) The fee total
     *     "txs": xxxxx,             (numeric) The number of transactions (excluding coinbase)
     *     "utxo_increase": xxxxx,   (numeric) The increase/decrease in the number of unspent outputs
     *     "utxo_size_inc": xxxxx,   (numeric) The increase/decrease in size for the utxo index (not discounting op_return and similar)
     *     }
     *     
     *     Examples:
     *     > bitcoin-cli getblockstats 1000 '["minfeerate","avgfeerate"]'
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblockstats", "params": [1000 '["minfeerate","avgfeerate"]'] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param block the block
     * @return the block stats
     */
    public Object getBlockStats(String block) {
        return callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_BLOCK_STATS, block);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.10.0
     * </p>
     * <p>
     * The getchaintips RPC returns information about the highest-height block (tip) of each local block chain.
     * </p>
     * 
     * <pre>
     *     getchaintips
     *     Return information about all known tips in the block tree, including the main chain as well as orphaned branches.
     *     
     *     Result:
     *     [
     *     {
     *     "height": xxxx,         (numeric) height of the chain tip
     *     "hash": "xxxx",         (string) block hash of the tip
     *     "branchlen": 0          (numeric) zero for main chain
     *     "status": "active"      (string) "active" for the main chain
     *     },
     *     {
     *     "height": xxxx,
     *     "hash": "xxxx",
     *     "branchlen": 1          (numeric) length of branch connecting the tip to the main chain
     *     "status": "xxxx"        (string) status of the chain (active, valid-fork, valid-headers, headers-only, invalid)
     *     }
     *     ]
     *     Possible values for status:
     *     1.  "invalid"               This branch contains at least one invalid block
     *     2.  "headers-only"          Not all blocks for this branch are available, but the headers are valid
     *     3.  "valid-headers"         All blocks are available for this branch, but they were never fully validated
     *     4.  "valid-fork"            This branch is not part of the active chain, but is fully validated
     *     5.  "active"                This is the tip of the active main chain, which is certainly valid
     *     
     *     Examples:
     *     > bitcoin-cli getchaintips 
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getchaintips", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the chain tips
     */
    public List<BtcRpcGetChainTipsResponse> getChainTips() {
        String json = callSimpleRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_CHAIN_TIPS);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<ArrayList<BtcRpcGetChainTipsResponse>>>() {
                });
        return (ArrayList<BtcRpcGetChainTipsResponse>) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.15.0
     * </p>
     * <p>
     * The getchaintxstats RPC computes statistics about the total number and rate of transactions in the chain.
     * </p>
     * 
     * <pre>
     *     getchaintxstats ( nblocks blockhash )
     *     
     *     Compute statistics about the total number and rate of transactions in the chain.
     *     
     *     Arguments:
     *     1. nblocks      (numeric, optional) Size of the window in number of blocks (default: one month).
     *     2. "blockhash"  (string, optional) The hash of the block that ends the window.
     *     
     *     Result:
     *     {
     *     "time": xxxxx,                         (numeric) The timestamp for the final block in the window in UNIX format.
     *     "txcount": xxxxx,                      (numeric) The total number of transactions in the chain up to that point.
     *     "window_final_block_hash": "...",      (string) The hash of the final block in the window.
     *     "window_block_count": xxxxx,           (numeric) Size of the window in number of blocks.
     *     "window_tx_count": xxxxx,              (numeric) The number of transactions in the window. Only returned if "window_block_count" is > 0.
     *     "window_interval": xxxxx,              (numeric) The elapsed time in the window in seconds. Only returned if "window_block_count" is > 0.
     *     "txrate": x.xx,                        (numeric) The average rate of transactions per second in the window. Only returned if "window_interval" is > 0.
     *     }
     *     
     *     Examples:
     *     > bitcoin-cli getchaintxstats 
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getchaintxstats", "params": [2016] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param nblocks the nblocks
     * @param blockhash the blockhash
     * @return the chain tx stats
     */
    public BtcRpcGetChainTxStatsResponse getChainTxStats(Long nblocks, String blockhash) {
        String json = callSimpleRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_CHAIN_TX_STATS, nblocks, blockhash);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetChainTxStatsResponse>>() {
                });
        return (BtcRpcGetChainTxStatsResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: < 0.10.0
     * </p>
     * <p>
     * The getdifficulty RPC returns the proof-of-work difficulty as a multiple of the minimum difficulty.
     * </p>
     * 
     * <pre>
     *     getdifficulty
     *     
     *     Returns the proof-of-work difficulty as a multiple of the minimum difficulty.
     *     
     *     Result:
     *     n.nnn       (numeric) the proof-of-work difficulty as a multiple of the minimum difficulty.
     *     
     *     Examples:
     *     > bitcoin-cli getdifficulty 
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getdifficulty", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the difficulty
     */
    public BigDecimal getDifficulty() {
        return (BigDecimal) callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_DIFFICULTY);
    }

    /**
     * Gets the mempool transaction id.
     *
     * @param callMethod the call method
     * @param params the params
     * @return the mempool transaction id
     */
    private List<BtcRpcGetMempoolEntryResponse> getMempoolTransactionId(String callMethod, Object... params) {

        List<BtcRpcGetMempoolEntryResponse> list = new ArrayList<>();
        LinkedHashMap<String, LinkedHashMap> map = (LinkedHashMap) callRpcMethod(callMethod, params);

        for (Map.Entry<String, LinkedHashMap> entry : map.entrySet()) {
            String key = entry.getKey();
            LinkedHashMap value = entry.getValue();
            String json = TransformBeanUtils.writeValueAsString(value);
            BtcRpcGetMempoolEntryResponse btcRpcGetMempoolAncestorsResponse = (BtcRpcGetMempoolEntryResponse) TransformBeanUtils.readValue(json,
                    BtcRpcGetMempoolEntryResponse.class);
            list.add(btcRpcGetMempoolAncestorsResponse);
        }
        return list;
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.13.0
     * </p>
     * <p>
     * The getmempoolancestors RPC returns all in-mempool ancestors for a transaction in the mempool.
     * </p>
     * 
     * <pre>
     *     getmempoolancestors "txid" ( verbose )
     *     
     *     If txid is in the mempool, returns all in-mempool ancestors.
     *     
     *     Arguments:
     *     1. txid       (string, required) The transaction id (must be in mempool)
     *     2. verbose    (boolean, optional, default=false) True for a json object, false for array of transaction ids
     *     
     *     Result (for verbose = false):
     *     [                       (json array of strings)
     *     "transactionid"           (string) The transaction id of an in-mempool ancestor transaction
     *     ,...
     *     ]
     *     
     *     Result (for verbose = true):
     *     {                           (json object)
     *     "transactionid" : {       (json object)
     *     "size" : n,             (numeric) virtual transaction size as defined in BIP 141. This is different from actual serialized size for witness transactions as witness data is discounted.
     *     "fee" : n,              (numeric) transaction fee in BTC (DEPRECATED)
     *     "modifiedfee" : n,      (numeric) transaction fee with fee deltas used for mining priority (DEPRECATED)
     *     "time" : n,             (numeric) local time transaction entered pool in seconds since 1 Jan 1970 GMT
     *     "height" : n,           (numeric) block height when transaction entered pool
     *     "descendantcount" : n,  (numeric) number of in-mempool descendant transactions (including this one)
     *     "descendantsize" : n,   (numeric) virtual transaction size of in-mempool descendants (including this one)
     *     "descendantfees" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) (DEPRECATED)
     *     "ancestorcount" : n,    (numeric) number of in-mempool ancestor transactions (including this one)
     *     "ancestorsize" : n,     (numeric) virtual transaction size of in-mempool ancestors (including this one)
     *     "ancestorfees" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) (DEPRECATED)
     *     "wtxid" : hash,         (string) hash of serialized transaction, including witness data
     *     "fees" : {
     *         "base" : n,         (numeric) transaction fee in BTC
     *         "modified" : n,     (numeric) transaction fee with fee deltas used for mining priority in BTC
     *         "ancestor" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) in BTC
     *         "descendant" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) in BTC
     *     }
     *     "depends" : [           (array) unconfirmed transactions used as inputs for this transaction
     *         "transactionid",    (string) parent transaction id
     *        ... ]
     *     "spentby" : [           (array) unconfirmed transactions spending outputs from this transaction
     *         "transactionid",    (string) child transaction id
     *        ... ]
     *     "bip125-replaceable" : true|false,  (boolean) Whether this transaction could be replaced due to BIP125 (replace-by-fee)
     *     }, ...
     *     }
     *     
     *     Examples:
     *     > bitcoin-cli getmempoolancestors "mytxid"
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getmempoolancestors", "params": ["mytxid"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param txid the txid
     * @param verbose the verbose
     * @return the mempool ancestors
     */
    public List<BtcRpcGetMempoolEntryResponse> getMempoolAncestors(String txid, Boolean verbose) {
        return getMempoolTransactionId(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_MEMPOOL_ANCESTORS, txid, verbose);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.13.0
     * </p>
     * <p>
     * The getmempooldescendants RPC returns all in-mempool descendants for a transaction in the mempool.
     * </p>
     * 
     * <pre>
     *     getmempooldescendants "txid" ( verbose )
     *     
     *     If txid is in the mempool, returns all in-mempool descendants.
     *     
     *     Arguments:
     *     1. txid       (string, required) The transaction id (must be in mempool)
     *     2. verbose    (boolean, optional, default=false) True for a json object, false for array of transaction ids
     *     
     *     Result (for verbose = false):
     *     [                       (json array of strings)
     *     "transactionid"           (string) The transaction id of an in-mempool descendant transaction
     *     ,...
     *     ]
     *     
     *     Result (for verbose = true):
     *     {                           (json object)
     *     "transactionid" : {       (json object)
     *     "size" : n,             (numeric) virtual transaction size as defined in BIP 141. This is different from actual serialized size for witness transactions as witness data is discounted.
     *     "fee" : n,              (numeric) transaction fee in BTC (DEPRECATED)
     *     "modifiedfee" : n,      (numeric) transaction fee with fee deltas used for mining priority (DEPRECATED)
     *     "time" : n,             (numeric) local time transaction entered pool in seconds since 1 Jan 1970 GMT
     *     "height" : n,           (numeric) block height when transaction entered pool
     *     "descendantcount" : n,  (numeric) number of in-mempool descendant transactions (including this one)
     *     "descendantsize" : n,   (numeric) virtual transaction size of in-mempool descendants (including this one)
     *     "descendantfees" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) (DEPRECATED)
     *     "ancestorcount" : n,    (numeric) number of in-mempool ancestor transactions (including this one)
     *     "ancestorsize" : n,     (numeric) virtual transaction size of in-mempool ancestors (including this one)
     *     "ancestorfees" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) (DEPRECATED)
     *     "wtxid" : hash,         (string) hash of serialized transaction, including witness data
     *     "fees" : {
     *         "base" : n,         (numeric) transaction fee in BTC
     *         "modified" : n,     (numeric) transaction fee with fee deltas used for mining priority in BTC
     *         "ancestor" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) in BTC
     *         "descendant" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) in BTC
     *     }
     *     "depends" : [           (array) unconfirmed transactions used as inputs for this transaction
     *         "transactionid",    (string) parent transaction id
     *        ... ]
     *     "spentby" : [           (array) unconfirmed transactions spending outputs from this transaction
     *         "transactionid",    (string) child transaction id
     *        ... ]
     *     "bip125-replaceable" : true|false,  (boolean) Whether this transaction could be replaced due to BIP125 (replace-by-fee)
     *     }, ...
     *     }
     *     
     *     Examples:
     *     > bitcoin-cli getmempooldescendants "mytxid"
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getmempooldescendants", "params": ["mytxid"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param txid the txid
     * @param verbose the verbose
     * @return the mempool descendants
     */
    public List<BtcRpcGetMempoolEntryResponse> getMempoolDescendants(String txid, Boolean verbose) {
        return getMempoolTransactionId(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_MEMPOOL_DESCENDANTS, txid, verbose);

    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.13.0
     * </p>
     * <p>
     * The getmempoolentry RPC returns mempool data for given transaction (must be in mempool).
     * </p>
     * 
     * <pre>
     *     getmempoolentry "txid"
     *     
     *     Returns mempool data for given transaction
     *     
     *     Arguments:
     *     1. txid    (string, required) The transaction id (must be in mempool)
     *     
     *     Result:
     *     {                           (json object)
     *     "size" : n,             (numeric) virtual transaction size as defined in BIP 141. This is different from actual serialized size for witness transactions as witness data is discounted.
     *     "fee" : n,              (numeric) transaction fee in BTC (DEPRECATED)
     *     "modifiedfee" : n,      (numeric) transaction fee with fee deltas used for mining priority (DEPRECATED)
     *     "time" : n,             (numeric) local time transaction entered pool in seconds since 1 Jan 1970 GMT
     *     "height" : n,           (numeric) block height when transaction entered pool
     *     "descendantcount" : n,  (numeric) number of in-mempool descendant transactions (including this one)
     *     "descendantsize" : n,   (numeric) virtual transaction size of in-mempool descendants (including this one)
     *     "descendantfees" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) (DEPRECATED)
     *     "ancestorcount" : n,    (numeric) number of in-mempool ancestor transactions (including this one)
     *     "ancestorsize" : n,     (numeric) virtual transaction size of in-mempool ancestors (including this one)
     *     "ancestorfees" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) (DEPRECATED)
     *     "wtxid" : hash,         (string) hash of serialized transaction, including witness data
     *     "fees" : {
     *         "base" : n,         (numeric) transaction fee in BTC
     *         "modified" : n,     (numeric) transaction fee with fee deltas used for mining priority in BTC
     *         "ancestor" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) in BTC
     *         "descendant" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) in BTC
     *     }
     *     "depends" : [           (array) unconfirmed transactions used as inputs for this transaction
     *         "transactionid",    (string) parent transaction id
     *        ... ]
     *     "spentby" : [           (array) unconfirmed transactions spending outputs from this transaction
     *         "transactionid",    (string) child transaction id
     *        ... ]
     *     "bip125-replaceable" : true|false,  (boolean) Whether this transaction could be replaced due to BIP125 (replace-by-fee)
     *     }
     *     
     *     Examples:
     *     > bitcoin-cli getmempoolentry "mytxid"
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getmempoolentry", "params": ["mytxid"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param txid the txid
     * @return the mempool entry
     */
    public BtcRpcGetMempoolEntryResponse getMempoolEntry(String txid) {
        String json = callSimpleRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_MEMPOOL_ENTRY, txid);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetMempoolEntryResponse>>() {
                });
        return (BtcRpcGetMempoolEntryResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.11.0
     * </p>
     * <p>
     * The getmempoolinfo RPC returns information about the node's current transaction memory pool.
     * </p>
     * 
     * <pre>
     *     getmempoolinfo
     *     
     *     Returns details on the active state of the TX memory pool.
     *     
     *     Result:
     *     {
     *     "size": xxxxx,               (numeric) Current tx count
     *     "bytes": xxxxx,              (numeric) Sum of all virtual transaction sizes as defined in BIP 141. Differs from actual serialized size because witness data is discounted
     *     "usage": xxxxx,              (numeric) Total memory usage for the mempool
     *     "maxmempool": xxxxx,         (numeric) Maximum memory usage for the mempool
     *     "mempoolminfee": xxxxx       (numeric) Minimum fee rate in BTC/kB for tx to be accepted. Is the maximum of minrelaytxfee and minimum mempool fee
     *     "minrelaytxfee": xxxxx       (numeric) Current minimum relay fee for transactions
     *     }
     *     
     *     Examples:
     *     > bitcoin-cli getmempoolinfo 
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getmempoolinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the mempool info
     */
    public BtcRpcGetMempoolInfoResponse getMempoolInfo() {
        String json = callSimpleRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_MEMPOOL_INFO);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetMempoolInfoResponse>>() {
                });
        return (BtcRpcGetMempoolInfoResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.7.0
     * </p>
     * <p>
     * Call category: blockchain Available since: 0.7.0 The getrawmempool RPC returns all transaction identifiers (TXIDs) in the memory pool as a JSON
     * array, or detailed information about each transaction in the memory pool as a JSON object.
     * </p>
     * 
     * <pre>
     *     getrawmempool ( verbose )
     *     
     *     Returns all transaction ids in memory pool as a json array of string transaction ids.
     *     
     *     Hint: use getmempoolentry to fetch a specific transaction from the mempool.
     *     
     *     Arguments:
     *     1. verbose    (boolean, optional, default=false) True for a json object, false for array of transaction ids
     *     
     *     Result (for verbose = false):
     *     [                     (json array of string)
     *     "transactionid"     (string) The transaction id
     *     ,...
     *     ]
     *     
     *     Result: (for verbose = true):
     *     {                           (json object)
     *     "transactionid" : {       (json object)
     *     "size" : n,             (numeric) virtual transaction size as defined in BIP 141. This is different from actual serialized size for witness transactions as witness data is discounted.
     *     "fee" : n,              (numeric) transaction fee in BTC (DEPRECATED)
     *     "modifiedfee" : n,      (numeric) transaction fee with fee deltas used for mining priority (DEPRECATED)
     *     "time" : n,             (numeric) local time transaction entered pool in seconds since 1 Jan 1970 GMT
     *     "height" : n,           (numeric) block height when transaction entered pool
     *     "descendantcount" : n,  (numeric) number of in-mempool descendant transactions (including this one)
     *     "descendantsize" : n,   (numeric) virtual transaction size of in-mempool descendants (including this one)
     *     "descendantfees" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) (DEPRECATED)
     *     "ancestorcount" : n,    (numeric) number of in-mempool ancestor transactions (including this one)
     *     "ancestorsize" : n,     (numeric) virtual transaction size of in-mempool ancestors (including this one)
     *     "ancestorfees" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) (DEPRECATED)
     *     "wtxid" : hash,         (string) hash of serialized transaction, including witness data
     *     "fees" : {
     *         "base" : n,         (numeric) transaction fee in BTC
     *         "modified" : n,     (numeric) transaction fee with fee deltas used for mining priority in BTC
     *         "ancestor" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) in BTC
     *         "descendant" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) in BTC
     *     }
     *     "depends" : [           (array) unconfirmed transactions used as inputs for this transaction
     *         "transactionid",    (string) parent transaction id
     *        ... ]
     *     "spentby" : [           (array) unconfirmed transactions spending outputs from this transaction
     *         "transactionid",    (string) child transaction id
     *        ... ]
     *     "bip125-replaceable" : true|false,  (boolean) Whether this transaction could be replaced due to BIP125 (replace-by-fee)
     *     }, ...
     *     }
     *     
     *     Examples:
     *     > bitcoin-cli getrawmempool true
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getrawmempool", "params": [true] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the raw mempool
     */
    public List<String> getRawMempool() {
        return (List<String>) callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_RAW_MEMPOOL, false);
    }

    /**
     * Gets the raw mempool verbose.
     *
     * @return the raw mempool verbose
     */
    public List<BtcRpcGetMempoolEntryResponse> getRawMempoolVerbose() {
        return getMempoolTransactionId(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_RAW_MEMPOOL, true);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.8.2
     * </p>
     * <p>
     * The gettxout RPC returns details about an unspent transaction output (UTXO).
     * </p>
     * 
     * <pre>
     *     gettxout "txid" n ( include_mempool )
     *     
     *     Returns details about an unspent transaction output.
     *     
     *     Arguments:
     *     1. "txid"             (string, required) The transaction id
     *     2. "n"                (numeric, required) vout number
     *     3. "include_mempool"  (boolean, optional) Whether to include the mempool. Default: true.     Note that an unspent output that is spent in the mempool won't appear.
     *     
     *     Result:
     *     {
     *     "bestblock":  "hash",    (string) The hash of the block at the tip of the chain
     *     "confirmations" : n,       (numeric) The number of confirmations
     *     "value" : x.xxx,           (numeric) The transaction value in BTC
     *     "scriptPubKey" : {         (json object)
     *      "asm" : "code",       (string) 
     *      "hex" : "hex",        (string) 
     *      "reqSigs" : n,          (numeric) Number of required signatures
     *      "type" : "pubkeyhash", (string) The type, eg pubkeyhash
     *      "addresses" : [          (array of string) array of bitcoin addresses
     *         "address"     (string) bitcoin address
     *         ,...
     *      ]
     *     },
     *     "coinbase" : true|false   (boolean) Coinbase or not
     *     }
     *     
     *     Examples:
     *     
     *     Get unspent transactions
     *     > bitcoin-cli listunspent 
     *     
     *     View the details
     *     > bitcoin-cli gettxout "txid" 1
     *     
     *     As a json rpc call
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "gettxout", "params": ["txid", 1] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param txid the txid
     * @param voutNumber the vout number
     * @param includeMempool the include mempool
     * @return the tx out
     */
    public Object getTxOut(String txid, Long voutNumber, Boolean includeMempool) {
        return callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_TXOUT, txid, voutNumber, includeMempool);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.11.0
     * </p>
     * <p>
     * The gettxoutproof RPC returns a hex-encoded proof that one or more specified transactions were included in a block.
     * </p>
     * 
     * <pre>
     *     gettxoutproof ["txid",...] ( blockhash )
     *     
     *     Returns a hex-encoded proof that "txid" was included in a block.
     *     
     *     NOTE: By default this function only works sometimes. This is when there is an
     *     unspent output in the utxo for this transaction. To make it always work,
     *     you need to maintain a transaction index, using the -txindex command line option or
     *     specify the block in which the transaction is included manually (by blockhash).
     *     
     *     Arguments:
     *     1. "txids"       (string) A json array of txids to filter
     *     [
     *       "txid"     (string) A transaction hash
     *       ,...
     *     ]
     *     2. "blockhash"   (string, optional) If specified, looks for txid in the block with this hash
     *     
     *     Result:
     *     "data"           (string) A string that is a serialized, hex-encoded data for the proof.
     * </pre>
     *
     * @return the tx out proof
     */
    public String getTxOutProof(String[] txids, String blockhash) {
        return (String) callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_TX_OUT_PROOF, txids, blockhash);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.8.2
     * </p>
     * <p>
     * The gettxoutsetinfo RPC returns statistics about the confirmed unspent transaction output (UTXO) set. Note that this call may take some time
     * and that it only counts outputs from confirmed transactions---it does not count outputs from the memory pool.
     * </p>
     * 
     * <pre>
     *     gettxoutsetinfo
     *     
     *     Returns statistics about the unspent transaction output set.
     *     Note this call may take some time.
     *     
     *     Result:
     *     {
     *     "height":n,     (numeric) The current block height (index)
     *     "bestblock": "hex",   (string) The hash of the block at the tip of the chain
     *     "transactions": n,      (numeric) The number of transactions with unspent outputs
     *     "txouts": n,            (numeric) The number of unspent transaction outputs
     *     "bogosize": n,          (numeric) A meaningless metric for UTXO set size
     *     "hash_serialized_2": "hash", (string) The serialized hash
     *     "disk_size": n,         (numeric) The estimated size of the chainstate on disk
     *     "total_amount": x.xxx          (numeric) The total amount
     *     }
     *     
     *     Examples:
     *     > bitcoin-cli gettxoutsetinfo 
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "gettxoutsetinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the tx out set info
     */
    public Object getTxOutSetInfo() {
        return callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_GET_TX_OUT_SET_INFO);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.14.0
     * </p>
     * <p>
     * The preciousblock RPC treats a block as if it were received before others with the same work.
     * </p>
     * 
     * <pre>
     *     preciousblock "blockhash"
     *     
     *     Treats a block as if it were received before others with the same work.
     *     
     *     A later preciousblock call can override the effect of an earlier one.
     *     
     *     The effects of preciousblock are not retained across restarts.
     *     
     *     Arguments:
     *     1. "blockhash"   (string, required) the hash of the block to mark as precious
     *     
     *     Result:
     *     
     *     Examples:
     *     > bitcoin-cli preciousblock "blockhash"
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "preciousblock", "params": ["blockhash"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the object
     */
    public Object preciousBlock() {
        return callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_PRECIOUS_BLOCK);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.14.0
     * </p>
     * <p>
     * The pruneblockchain RPC prunes the blockchain up to a specified height or timestamp.
     * </p>
     * 
     * <pre>
     *     pruneblockchain
     *     
     *     Arguments:
     *     1. "height"       (numeric, required) The block height to prune up to. May be set to a discrete height, or a unix timestamp
     *                   to prune blocks whose block time is at least 2 hours older than the provided timestamp.
     *     
     *     Result:
     *     n    (numeric) Height of the last block pruned.
     *     
     *     Examples:
     *     > bitcoin-cli pruneblockchain 1000
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "pruneblockchain", "params": [1000] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the object
     */
    public Object pruneBlockchain() {
        return callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_PRUNE_BLOCKCHAIN);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.16.0
     * </p>
     * <p>
     * The savemempool RPC allows the current mempool to be saved to disk at any time to avoid it being lost due to crashes / power loss.
     * </p>
     * 
     * <pre>
     *     savemempool
     *     
     *     Dumps the mempool to disk. It will fail until the previous dump is fully loaded.
     *     
     *     Examples:
     *     > bitcoin-cli savemempool 
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "savemempool", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the object
     */
    public Object saveMempool() {
        return callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_SAVE_MEMPOOL);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The scantxoutset RPC scan the UTXO set for entries that match certain output descriptors.
     * </p>
     * 
     * <pre>
     * </pre>
     *
     * @return the object
     */
    public Object scanTxOutSet() {
        return callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_SCANTXOUTSET);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.9.0
     * </p>
     * <p>
     * The verifychain RPC verifies each entry in the local block chain database.
     * </p>
     * 
     * <pre>
     *      verifychain ( checklevel nblocks )
     *     
     *     Verifies blockchain database.
     *     
     *     Arguments:
     *     1. checklevel   (numeric, optional, 0-4, default=3) How thorough the block verification is.
     *     2. nblocks      (numeric, optional, default=6, 0=all) The number of blocks to check.
     *     
     *     Result:
     *     true|false       (boolean) Verified or not
     *     
     *     Examples:
     *     > bitcoin-cli verifychain 
     *     > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "verifychain", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the object
     */
    public Object verifyChain() {
        return callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_VERIFYCHAIN);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since: 0.11.0
     * </p>
     * <p>
     * The verifytxoutproof RPC verifies that a proof points to one or more transactions in a block, returning the transactions the proof commits to
     * and throwing an RPC error if the block is not in our best block chain.
     * </p>
     * 
     * <pre>
     *      verifytxoutproof "proof"
     *     
     *     Verifies that a proof points to a transaction in a block, returning the transaction it commits to
     *     and throwing an RPC error if the block is not in our best chain
     *     
     *     Arguments:
     *     1. "proof"    (string, required) The hex-encoded proof generated by gettxoutproof
     *     
     *     Result:
     *     ["txid"]      (array, strings) The txid(s) which the proof commits to, or empty array if the proof can not be validated.
     * </pre>
     *
     * @return the object
     */
    public Object verifyTxOutProof() {
        return callRpcMethod(RpcBlockchainMethodsConstants.BLOCKCHAIN_VERIFYTXOUTPROOF);
    }

    /**
     * <p>
     * Call category: blockchain
     * </p>
     * <p>
     * Available since:
     * </p>
     * <p>
     * Returns an object containing various state info.
     * </p>
     * 
     * <pre>
     *  
     *      Result:
     *     {
     *     "version": xxxxx,           (numeric) the server version
     *     "protocolversion": xxxxx,   (numeric) the protocol version
     *     "walletversion": xxxxx,     (numeric) the wallet version
     *     "balance": xxxxxxx,         (numeric) the total bitcoin balance of the wallet
     *     "privatesend_balance": xxxxxx, (numeric) the anonymized bitcoin balance of the wallet
     *     "blocks": xxxxxx,           (numeric) the current number of blocks processed in the server
     *     "timeoffset": xxxxx,        (numeric) the time offset
     *     "connections": xxxxx,       (numeric) the number of connections
     *     "proxy": "host:port",     (string, optional) the proxy used by the server
     *     "difficulty": xxxxxx,       (numeric) the current difficulty
     *     "testnet": true|false,      (boolean) if the server is using testnet or not
     *     "keypoololdest": xxxxxx,    (numeric) the timestamp (seconds since GMT epoch) of the oldest pre-generated key in the key pool
     *     "keypoolsize": xxxx,        (numeric) how many new keys are pre-generated
     *     "unlocked_until": ttt,      (numeric) the timestamp in seconds since epoch (midnight Jan 1 1970 GMT) that the wallet is unlocked for transfers, or 0 if the wallet is locked
     *     "paytxfee": x.xxxx,         (numeric) the transaction fee set in bitcoin/kB
     *     "relayfee": x.xxxx,         (numeric) minimum relay fee for non-free transactions in bitcoin/kB
     *     "errors": "..."           (string) any error messages
     *     }
     * </pre>
     *
     * @return the info
     */
    public BtcRpcGetInfoResponse getInfo() {
        String json = callSimpleRpcMethod(RpcBlockchainMethodsConstants.LEGACY_GET_INFO);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetInfoResponse>>() {
                });

        return (BtcRpcGetInfoResponse) rpcOutputMessage.getResult();
    }

}
