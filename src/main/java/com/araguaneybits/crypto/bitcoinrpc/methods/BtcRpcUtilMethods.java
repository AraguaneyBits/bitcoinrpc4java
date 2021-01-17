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

import java.util.LinkedHashMap;
import java.util.List;

import com.araguaneybits.crypto.bitcoinrpc.RpcOutputMessage;
import com.araguaneybits.crypto.bitcoinrpc.constants.EnumAddressType;
import com.araguaneybits.crypto.bitcoinrpc.constants.EnumEstimateMode;
import com.araguaneybits.crypto.bitcoinrpc.constants.RpcUtilMethodsConstants;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcCreateMultiSigResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcEstimateSmartFeeResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetDescriptorInfoResponse;
import com.araguaneybits.crypto.utils.TransformBeanUtils;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * The Class BtcRpcUtilMethods.
 *
 * @author jestevez
 */
public class BtcRpcUtilMethods extends BaseBtcRpcMethods {

    /**
     * Instantiates a new btc rpc util methods.
     *
     * @param btcRpcGateway the btc rpc gateway
     */
    public BtcRpcUtilMethods(BtcRpcGateway btcRpcGateway) {
        super(btcRpcGateway);
    }

    /**
     * <p>
     * Call category: util
     * </p>
     * <p>
     * Available since: &lt; 0.10.1
     * </p>
     * <p>
     * The createmultisig RPC creates a P2SH multi-signature address.
     * </p>
     * 
     * <pre>
     *     createmultisig nrequired ["key",...] ( "address_type" )
     *     
     *     Creates a multi-signature address with n signature of m keys required.
     *     It returns a json object with the address and redeemScript.
     *     
     *     Arguments:
     *     1. nrequired                    (numeric, required) The number of required signatures out of the n keys.
     *     2. "keys"                       (string, required) A json array of hex-encoded public keys
     *      [
     *        "key"                    (string) The hex-encoded public key
     *        ,...
     *      ]
     *     3. "address_type"               (string, optional) The address type to use. Options are "legacy", "p2sh-segwit", and "bech32". Default is legacy.
     *     
     *     Result:
     *     {
     *     "address":"multisigaddress",  (string) The value of the new multisig address.
     *     "redeemScript":"script"       (string) The string value of the hex-encoded redemption script.
     *     }
     *     
     *     Examples:
     *     
     *     Create a multisig address from 2 public keys
    *       bitcoin-cli createmultisig 2 "[\"03789ed0bb717d88f7d321a368d905e7430207ebbd82bd342cf11ae157a7ace5fd\",\"03dbc6764b8884a92e871274b87583e6d5c2a58819473e17e107ef3f6aa5a61626\"]"
     *     
     *     As a json rpc call
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "createmultisig", "params": [2, "[\"03789ed0bb717d88f7d321a368d905e7430207ebbd82bd342cf11ae157a7ace5fd\",\"03dbc6764b8884a92e871274b87583e6d5c2a58819473e17e107ef3f6aa5a61626\"]"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param nrequired the nrequired
     * @param keys the keys
     * @param addressType the address type
     * @return the btc rpc create multi sig response
     */
    public BtcRpcCreateMultiSigResponse createMultiSig(Long nrequired, String[] keys, EnumAddressType addressType) {
        String json = callSimpleRpcMethod(RpcUtilMethodsConstants.UTIL_CREATE_MULTISIG, nrequired, keys, addressType.getValue());
        RpcOutputMessage<?> rpcOutputMessage = (RpcOutputMessage<?>) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcCreateMultiSigResponse>>() {
                });
        return (BtcRpcCreateMultiSigResponse) rpcOutputMessage.getResult();

    }

    /**
     * <p>
     * Call category: util
     * </p>
     * <p>
     * Available since: 0.18.0
     * </p>
     * <p>
     * The deriveaddresses RPC returns one or more addresses corresponding to an output descriptor.
     * </p>
     * 
     * <pre>
     *      deriveaddresses "descriptor" ( range )
     *     
     *     Derives one or more addresses corresponding to an output descriptor.
     *     Examples of output descriptors are:
     *     pkh()                        P2PKH outputs for the given pubkey
     *     wpkh()                       Native segwit P2PKH outputs for the given pubkey
     *     sh(multi(,,,...)) P2SH-multisig outputs for the given threshold and pubkeys
     *     raw()                    Outputs whose scriptPubKey equals the specified hex scripts
     *     
     *     In the above,  either refers to a fixed public key in hexadecimal notation, or to an xpub/xprv optionally followed by one
     *     or more path elements separated by "/", where "h" represents a hardened child key.
     *     For more information on output descriptors, see the documentation in the doc/descriptors.md file.
     *     
     *     Arguments:
     *     1. descriptor    (string, required) The descriptor.
     *     2. range         (numeric or array, optional) If a ranged descriptor is used, this specifies the end or the range (in [begin,end] notation) to derive.
     *     
     *     Result:
     *     [ address ] (array) the derived addresses
     *     
     *     Examples:
     *     First three native segwit receive addresses
    *       bitcoin-cli deriveaddresses "wpkh([d34db33f/84h/0h/0h]xpub6DJ2dNUysrn5Vt36jH2KLBT2i1auw1tTSSomg8PhqNiUtx8QX2SvC9nrHu81fT41fvDUnhMjEzQgXnQjKEu3oaqMSzhSrHMxyyoEAmUHQbY/0/*)#trd0mf0l" "[0,2]"
     * </pre>
     *
     * @param descriptor the descriptor
     * @param range the range
     * @return the list
     */
    public List<String> deriveAddresses(String descriptor, Long[] range) {
        // https://github.com/bitcoin/bitcoin/blob/master/doc/descriptors.md
        // https://github.com/bitcoin/bitcoin/blob/master/src/test/descriptor_tests.cpp

        return (List) callRpcMethod(RpcUtilMethodsConstants.UTIL_DERIVE_ADDRESSES, descriptor);
    }

    /**
     * <p>
     * Call category: util
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The estimaterawfee RPC estimates the approximate fee per kilobyte needed for a transaction to begin confirmation within conf_target blocks if
     * possible. External clients can query and use this data in their own fee estimation logic.
     * </p>
     * 
     * <pre>
     *     estimaterawfee conf_target (threshold)
     *     
     *     WARNING: This interface is unstable and may disappear or change!
     *     
     *     WARNING: This is an advanced API call that is tightly coupled to the specific
     *          implementation of fee estimation. The parameters it can be called with
     *          and the results it returns will change if the internal implementation changes.
     *     
     *     Estimates the approximate fee per kilobyte needed for a transaction to begin
     *     confirmation within conf_target blocks if possible. Uses virtual transaction size as
     *     defined in BIP 141 (witness data is discounted).
     *     
     *     Arguments:
     *     1. conf_target (numeric) Confirmation target in blocks (1 - 1008)
     *     2. threshold   (numeric, optional) The proportion of transactions in a given feerate range that must have been
     *                confirmed within conf_target in order to consider those feerates as high enough and proceed to check
     *                lower buckets.  Default: 0.95
     *     
     *     Result:
     *     {
     *     "short" : {            (json object, optional) estimate for short time horizon
     *       "feerate" : x.x,        (numeric, optional) estimate fee rate in BTC/kB
     *       "decay" : x.x,          (numeric) exponential decay (per block) for historical moving average of confirmation data
     *       "scale" : x,            (numeric) The resolution of confirmation targets at this time horizon
     *       "pass" : {              (json object, optional) information about the lowest range of feerates to succeed in meeting the threshold
     *           "startrange" : x.x,     (numeric) start of feerate range
     *           "endrange" : x.x,       (numeric) end of feerate range
     *           "withintarget" : x.x,   (numeric) number of txs over history horizon in the feerate range that were confirmed within target
     *           "totalconfirmed" : x.x, (numeric) number of txs over history horizon in the feerate range that were confirmed at any point
     *           "inmempool" : x.x,      (numeric) current number of txs in mempool in the feerate range unconfirmed for at least target blocks
     *           "leftmempool" : x.x,    (numeric) number of txs over history horizon in the feerate range that left mempool unconfirmed after target
     *       },
     *       "fail" : { ... },       (json object, optional) information about the highest range of feerates to fail to meet the threshold
     *       "errors":  [ str... ]   (json array of strings, optional) Errors encountered during processing
     *     },
     *     "medium" : { ... },    (json object, optional) estimate for medium time horizon
     *     "long" : { ... }       (json object) estimate for long time horizon
     *     }
     *     
     *     Results are returned for any horizon which tracks blocks up to the confirmation target.
     *     
     *     Example:
    *       bitcoin-cli estimaterawfee 6 0.9
     * </pre>
     *
     * @param confTarget the conf target
     * @param threshold the threshold
     * @return the object
     */
    public Object estimateRawFee(Integer confTarget, Double threshold) {
        // TODO Implement response
        return callRpcMethod(RpcUtilMethodsConstants.UTIL_ESTIMATE_RAWFEE, confTarget, threshold);
    }

    /**
     * <p>
     * Call category: util
     * </p>
     * <p>
     * Available since: 0.14.0
     * </p>
     * <p>
     * The estimatesmartfee RPC estimates the approximate fee per kilobyte needed for a transaction to begin confirmation within conf_target blocks if
     * possible and return the number of blocks for which the estimate is valid.
     * </p>
     * 
     * <pre>
     *     estimatesmartfee conf_target ("estimate_mode")
     *     
     *     Estimates the approximate fee per kilobyte needed for a transaction to begin
     *     confirmation within conf_target blocks if possible and return the number of blocks
     *     for which the estimate is valid. Uses virtual transaction size as defined
     *     in BIP 141 (witness data is discounted).
     *     
     *     Arguments:
     *     1. conf_target     (numeric) Confirmation target in blocks (1 - 1008)
     *     2. "estimate_mode" (string, optional, default=CONSERVATIVE) The fee estimate mode.
     *                    Whether to return a more conservative estimate which also satisfies
     *                    a longer history. A conservative estimate potentially returns a
     *                    higher feerate and is more likely to be sufficient for the desired
     *                    target, but is not as responsive to short term drops in the
     *                    prevailing fee market.  Must be one of:
     *        "UNSET" (defaults to CONSERVATIVE)
     *        "ECONOMICAL"
     *        "CONSERVATIVE"
     *     
     *     Result:
     *     {
     *     "feerate" : x.x,     (numeric, optional) estimate fee rate in BTC/kB
     *     "errors": [ str... ] (json array of strings, optional) Errors encountered during processing
     *     "blocks" : n         (numeric) block number where estimate was found
     *     }
     *     
     *     The request target will be clamped between 2 and the highest target
     *     fee estimation is able to return based on how long it has been running.
     *     An error is returned if not enough transactions and blocks
     *     have been observed to make an estimate for any number of blocks.
     *     
     *     Example:
    *       bitcoin-cli estimatesmartfee 6
     * </pre>
     *
     * @param confTarget the conf target
     * @param enumEstimateMode the enum estimate mode
     * @return the btc rpc estimate smart fee response
     */
    public BtcRpcEstimateSmartFeeResponse estimateSmartFee(Integer confTarget, EnumEstimateMode enumEstimateMode) {
        String json = callSimpleRpcMethod(RpcUtilMethodsConstants.UTIL_ESTIMATE_SMART_FEE, confTarget, enumEstimateMode.getValue());
        RpcOutputMessage<?> rpcOutputMessage = (RpcOutputMessage<?>) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcEstimateSmartFeeResponse>>() {
                });
        return (BtcRpcEstimateSmartFeeResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: util
     * </p>
     * <p>
     * Available since: 0.18.0
     * </p>
     * <p>
     * The getdescriptorinfo RPC accepts a descriptor and returns information about it, including its computed checksum.
     * </p>
     * 
     * <pre>
     *     getdescriptorinfo "descriptor"
     *     
     *     Analyses a descriptor.
     *     
     *     Arguments:
     *     1. descriptor    (string, required) The descriptor.
     *     
     *     Result:
     *     {
     *     "descriptor" : "desc",         (string) The descriptor in canonical form, without private keys
     *     "isrange" : true|false,        (boolean) Whether the descriptor is ranged
     *     "issolvable" : true|false,     (boolean) Whether the descriptor is solvable
     *     "hasprivatekeys" : true|false, (boolean) Whether the input descriptor contained at least one private key
     *     }
     *     
     *     Examples:
     *     Analyse a descriptor
    *       bitcoin-cli getdescriptorinfo "wpkh([d34db33f/84h/0h/0h]0279be667ef9dcbbac55a06295Ce870b07029Bfcdb2dce28d959f2815b16f81798)"
     * </pre>
     *
     * @param descriptor the descriptor
     * @return the descriptor info
     */
    public BtcRpcGetDescriptorInfoResponse getDescriptorInfo(String descriptor) {
        String json = callSimpleRpcMethod(RpcUtilMethodsConstants.UTIL_GET_DESCRIPTOR_INFO, descriptor);
        RpcOutputMessage<?> rpcOutputMessage = (RpcOutputMessage<?>) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetDescriptorInfoResponse>>() {
                });

        return (BtcRpcGetDescriptorInfoResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: util
     * </p>
     * <p>
     * Available since: 0.13.0
     * </p>
     * <p>
     * The signmessagewithprivkey RPC signs a message with a given private key.
     * </p>
     * 
     * <pre>
     *     signmessagewithprivkey "privkey" "message"
     *     
     *     Sign a message with the private key of an address
     *     
     *     Arguments:
     *     1. "privkey"         (string, required) The private key to sign the message with.
     *     2. "message"         (string, required) The message to create a signature of.
     *     
     *     Result:
     *     "signature"          (string) The signature of the message encoded in base 64
     *     
     *     Examples:
     *     
     *     Create the signature
    *       bitcoin-cli signmessagewithprivkey "privkey" "my message"
     *     
     *     Verify the signature
    *       bitcoin-cli verifymessage "1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX" "signature" "my message"
     *     
     *     As json rpc
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "signmessagewithprivkey", "params": ["privkey", "my message"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param privkey the privkey
     * @param message the message
     * @return the string
     */
    public String signMessageWithPrivkey(String privkey, String message) {
        return (String) callRpcMethod(RpcUtilMethodsConstants.UTIL_SIGN_MESSAGE_WITH_PRIVKEY, privkey, message);
    }

    /**
     * <p>
     * Call category: util
     * </p>
     * <p>
     * Available since: 0.3.14
     * </p>
     * <p>
     * The validateaddress RPC returns information about the given Bitcoin address.
     * </p>
     * 
     * <pre>
     *     validateaddress "address"
     *     
     *     Return information about the given bitcoin address.
     *     DEPRECATION WARNING: Parts of this command have been deprecated and moved to getaddressinfo. Clients must
     *     transition to using getaddressinfo to access this information before upgrading to v0.18. The following deprecated
     *     fields have moved to getaddressinfo and will only be shown here with -deprecatedrpc=validateaddress: ismine, iswatchonly,
     *     script, hex, pubkeys, sigsrequired, pubkey, addresses, embedded, iscompressed, account, timestamp, hdkeypath, kdmasterkeyid.
     *     
     *     Arguments:
     *     1. "address"                    (string, required) The bitcoin address to validate
     *     
     *     Result:
     *     {
     *     "isvalid" : true|false,       (boolean) If the address is valid or not. If not, this is the only property returned.
     *     "address" : "address",        (string) The bitcoin address validated
     *     "scriptPubKey" : "hex",       (string) The hex encoded scriptPubKey generated by the address
     *     "isscript" : true|false,      (boolean) If the key is a script
     *     "iswitness" : true|false,     (boolean) If the address is a witness address
     *     "witness_version" : version   (numeric, optional) The version number of the witness program
     *     "witness_program" : "hex"     (string, optional) The hex value of the witness program
     *     }
     *     
     *     Examples:
    *       bitcoin-cli validateaddress "1PSSGeFHDnKNxiEyFrD1wcEaHr9hrQDDWc"
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "validateaddress", "params": ["1PSSGeFHDnKNxiEyFrD1wcEaHr9hrQDDWc"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param address the address
     * @return the boolean
     */
    public Boolean validateAddress(String address) {
        LinkedHashMap<Object, Object> result = (LinkedHashMap) callRpcMethod(RpcUtilMethodsConstants.UTIL_VALIDATE_ADDRESS, address);
        return (Boolean) result.get("isvalid");
    }

    /**
     * <p>
     * Call category: util
     * </p>
     * <p>
     * Available since: 0.5.0
     * </p>
     * <p>
     * The verifymessage RPC verifies a signed message.
     * </p>
     * 
     * <pre>
     *     verifymessage "address" "signature" "message"
     *     
     *     Verify a signed message
     *     
     *     Arguments:
     *     1. "address"         (string, required) The bitcoin address to use for the signature.
     *     2. "signature"       (string, required) The signature provided by the signer in base 64 encoding (see signmessage).
     *     3. "message"         (string, required) The message that was signed.
     *     
     *     Result:
     *     true|false   (boolean) If the signature is verified or not.
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
    *       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "verifymessage", "params": ["1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX", "signature", "my message"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param address the address
     * @param signature the signature
     * @param message the message
     * @return the boolean
     */
    public Boolean verifymessage(String address, String signature, String message) {
        return (Boolean) callRpcMethod(RpcUtilMethodsConstants.UTIL_VERIFY_MESSAGE, address, signature, message);
    }

}
