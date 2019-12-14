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
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcListUnspentResponse.
 *
 * @author jestevez
 */
public class BtcRpcListUnspentResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4966544181016358093L;

    /** The txid. */
    @JsonProperty("txid")
    private String txid;

    /** The vout. */
    @JsonProperty("vout")
    private Long vout;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The label. */
    @JsonProperty("label")
    private String label;

    /** The script pub key. */
    @JsonProperty("scriptPubKey")
    private String scriptPubKey;

    /** The amount. */
    @JsonProperty("amount")
    private BigDecimal amount;

    /** The confirmations. */
    @JsonProperty("confirmations")
    private Long confirmations;

    /** The spendable. */
    @JsonProperty("spendable")
    private Boolean spendable;

    /** The solvable. */
    @JsonProperty("solvable")
    private Boolean solvable;

    /** The desc. */
    @JsonProperty("desc")
    private String desc;

    /** The safe. */
    @JsonProperty("safe")
    private Boolean safe;

    /** The redeem script. */
    @JsonProperty("redeemScript")
    private String redeemScript;

    /**
     * Instantiates a new btc rpc list unspent response.
     */
    public BtcRpcListUnspentResponse() {
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
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label.
     *
     * @param label the new label
     */
    public void setLabel(String label) {
        this.label = label;
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

    /**
     * Gets the confirmations.
     *
     * @return the confirmations
     */
    public Long getConfirmations() {
        return confirmations;
    }

    /**
     * Sets the confirmations.
     *
     * @param confirmations the new confirmations
     */
    public void setConfirmations(Long confirmations) {
        this.confirmations = confirmations;
    }

    /**
     * Gets the spendable.
     *
     * @return the spendable
     */
    public Boolean getSpendable() {
        return spendable;
    }

    /**
     * Sets the spendable.
     *
     * @param spendable the new spendable
     */
    public void setSpendable(Boolean spendable) {
        this.spendable = spendable;
    }

    /**
     * Gets the solvable.
     *
     * @return the solvable
     */
    public Boolean getSolvable() {
        return solvable;
    }

    /**
     * Sets the solvable.
     *
     * @param solvable the new solvable
     */
    public void setSolvable(Boolean solvable) {
        this.solvable = solvable;
    }

    /**
     * Gets the desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the desc.
     *
     * @param desc the new desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Gets the safe.
     *
     * @return the safe
     */
    public Boolean getSafe() {
        return safe;
    }

    /**
     * Sets the safe.
     *
     * @param safe the new safe
     */
    public void setSafe(Boolean safe) {
        this.safe = safe;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcListUnspentResponse [txid=" + txid + ", vout=" + vout + ", address=" + address + ", label=" + label + ", scriptPubKey="
                + scriptPubKey + ", amount=" + amount + ", confirmations=" + confirmations + ", spendable=" + spendable + ", solvable=" + solvable
                + ", desc=" + desc + ", safe=" + safe + ", redeemScript=" + redeemScript + "]";
    }

}
