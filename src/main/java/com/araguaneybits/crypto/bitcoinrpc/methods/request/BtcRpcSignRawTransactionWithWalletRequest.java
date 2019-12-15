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
package com.araguaneybits.crypto.bitcoinrpc.methods.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcSignRawTransactionWithWalletRequest.
 *
 * @author jestevez
 */
public class BtcRpcSignRawTransactionWithWalletRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3230966560244001797L;

    /** The txid. */
    @JsonProperty("txid")
    private String txid;

    /** The vout. */
    @JsonProperty("vout")
    private Long vout;

    /** The script pub key. */
    @JsonProperty("scriptPubKey")
    private String scriptPubKey;

    /** The redeem script. */
    @JsonProperty("redeemScript")
    private String redeemScript;

    /** The witness script. */
    @JsonProperty("witnessScript")
    private String witnessScript;

    /** The amount. */
    @JsonProperty("amount")
    private BigDecimal amount;

    /**
     * Instantiates a new btc rpc sign raw transaction with wallet request.
     */
    public BtcRpcSignRawTransactionWithWalletRequest() {
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
     * Gets the script pub key.
     *
     * @return the script pub key
     */
    public String getScriptPubKey() {
        return scriptPubKey;
    }

    /**
     * Sets the script pub key.
     *
     * @param scriptPubKey the new script pub key
     */
    public void setScriptPubKey(String scriptPubKey) {
        this.scriptPubKey = scriptPubKey;
    }

    /**
     * Gets the redeem script.
     *
     * @return the redeem script
     */
    public String getRedeemScript() {
        return redeemScript;
    }

    /**
     * Sets the redeem script.
     *
     * @param redeemScript the new redeem script
     */
    public void setRedeemScript(String redeemScript) {
        this.redeemScript = redeemScript;
    }

    /**
     * Gets the witness script.
     *
     * @return the witness script
     */
    public String getWitnessScript() {
        return witnessScript;
    }

    /**
     * Sets the witness script.
     *
     * @param witnessScript the new witness script
     */
    public void setWitnessScript(String witnessScript) {
        this.witnessScript = witnessScript;
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     *
     * @param amount the new amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcSignRawTransactionWithWalletResponse [txid=" + txid + ", vout=" + vout + ", scriptPubKey=" + scriptPubKey + ", redeemScript="
                + redeemScript + ", witnessScript=" + witnessScript + ", amount=" + amount + "]";
    }

}
