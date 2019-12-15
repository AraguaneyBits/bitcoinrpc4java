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
package com.araguaneybits.crypto.bitcoinrpc.methods.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcDecodePsbtVinResponse.
 *
 * @author jestevez
 */
public class BtcRpcDecodePsbtVinResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 14726960253228510L;

    /** The txid. */
    @JsonProperty("txid")
    private String txid;

    /** The vout. */
    @JsonProperty("vout")
    private Long vout;

    /** The script sig. */
    @JsonProperty("scriptSig")
    private BtcRpcDecodePsbtScriptSigResponse scriptSig;

    /** The sequence. */
    @JsonProperty("sequence")
    private Long sequence;

    /** The txinwitness. */
    @JsonProperty("txinwitness")
    private List<String> txinwitness;

    /**
     * Instantiates a new btc rpc decode psbt vin response.
     */
    public BtcRpcDecodePsbtVinResponse() {
        super();
    }

    /**
     * Gets the txid.
     *
     * @return the txid
     */
    public String getTxid() {
        return txid;
    }

    /**
     * Sets the txid.
     *
     * @param txid the new txid
     */
    public void setTxid(String txid) {
        this.txid = txid;
    }

    /**
     * Gets the vout.
     *
     * @return the vout
     */
    public Long getVout() {
        return vout;
    }

    /**
     * Sets the vout.
     *
     * @param vout the new vout
     */
    public void setVout(Long vout) {
        this.vout = vout;
    }

    /**
     * Gets the script sig.
     *
     * @return the script sig
     */
    public BtcRpcDecodePsbtScriptSigResponse getScriptSig() {
        return scriptSig;
    }

    /**
     * Sets the script sig.
     *
     * @param scriptSig the new script sig
     */
    public void setScriptSig(BtcRpcDecodePsbtScriptSigResponse scriptSig) {
        this.scriptSig = scriptSig;
    }

    /**
     * Gets the sequence.
     *
     * @return the sequence
     */
    public Long getSequence() {
        return sequence;
    }

    /**
     * Sets the sequence.
     *
     * @param sequence the new sequence
     */
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    /**
     * Gets the txinwitness.
     *
     * @return the txinwitness
     */
    public List<String> getTxinwitness() {
        return txinwitness;
    }

    /**
     * Sets the txinwitness.
     *
     * @param txinwitness the new txinwitness
     */
    public void setTxinwitness(List<String> txinwitness) {
        this.txinwitness = txinwitness;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcDecodePsbtVinResponse [txid=" + txid + ", vout=" + vout + ", scriptSig=" + scriptSig + ", sequence=" + sequence + "]";
    }

}
