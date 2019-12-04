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
 * The Class BtcRpcListSinceBlockTransactionResponse.
 *
 * @author jestevez
 */
public class BtcRpcListSinceBlockTransactionResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -697353182390561970L;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The category. */
    @JsonProperty("category")
    private String category;

    /** The amount. */
    @JsonProperty("amount")
    private Double amount;

    /** The vout. */
    @JsonProperty("vout")
    private Integer vout;

    /** The fee. */
    @JsonProperty("fee")
    private Double fee;

    /** The confirmations. */
    @JsonProperty("confirmations")
    private Integer confirmations;

    /** The blockhash. */
    @JsonProperty("blockhash")
    private String blockhash;

    /** The blockindex. */
    @JsonProperty("blockindex")
    private Integer blockindex;

    /** The blocktime. */
    @JsonProperty("blocktime")
    private Integer blocktime;

    /** The txid. */
    @JsonProperty("txid")
    private String txid;

    /** The walletconflicts. */
    @JsonProperty("walletconflicts")
    private List<Object> walletconflicts;

    /** The time. */
    @JsonProperty("time")
    private Integer time;

    /** The timereceived. */
    @JsonProperty("timereceived")
    private Integer timereceived;

    /** The bip 125 replaceable. */
    @JsonProperty("bip125-replaceable")
    private String bip125Replaceable;

    /** The comment. */
    @JsonProperty("comment")
    private String comment;

    /** The to. */
    @JsonProperty("to")
    private String to;

    /** The abandoned. */
    @JsonProperty("abandoned")
    private Boolean abandoned;

    /** The label. */
    @JsonProperty("label")
    private String label;

    /**
     * Instantiates a new btc rpc list since block transaction response.
     */
    public BtcRpcListSinceBlockTransactionResponse() {
        super();
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
     * Gets the category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Gets the vout.
     *
     * @return the vout
     */
    public Integer getVout() {
        return vout;
    }

    /**
     * Gets the fee.
     *
     * @return the fee
     */
    public Double getFee() {
        return fee;
    }

    /**
     * Gets the confirmations.
     *
     * @return the confirmations
     */
    public Integer getConfirmations() {
        return confirmations;
    }

    /**
     * Gets the blockhash.
     *
     * @return the blockhash
     */
    public String getBlockhash() {
        return blockhash;
    }

    /**
     * Gets the blockindex.
     *
     * @return the blockindex
     */
    public Integer getBlockindex() {
        return blockindex;
    }

    /**
     * Gets the blocktime.
     *
     * @return the blocktime
     */
    public Integer getBlocktime() {
        return blocktime;
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
     * Gets the walletconflicts.
     *
     * @return the walletconflicts
     */
    public List<Object> getWalletconflicts() {
        return walletconflicts;
    }

    /**
     * Gets the time.
     *
     * @return the time
     */
    public Integer getTime() {
        return time;
    }

    /**
     * Gets the timereceived.
     *
     * @return the timereceived
     */
    public Integer getTimereceived() {
        return timereceived;
    }

    /**
     * Gets the bip 125 replaceable.
     *
     * @return the bip 125 replaceable
     */
    public String getBip125Replaceable() {
        return bip125Replaceable;
    }

    /**
     * Gets the comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Gets the to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Gets the abandoned.
     *
     * @return the abandoned
     */
    public Boolean getAbandoned() {
        return abandoned;
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
     * Sets the address.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the category.
     *
     * @param category the new category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Sets the amount.
     *
     * @param amount the new amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Sets the vout.
     *
     * @param vout the new vout
     */
    public void setVout(Integer vout) {
        this.vout = vout;
    }

    /**
     * Sets the fee.
     *
     * @param fee the new fee
     */
    public void setFee(Double fee) {
        this.fee = fee;
    }

    /**
     * Sets the confirmations.
     *
     * @param confirmations the new confirmations
     */
    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    /**
     * Sets the blockhash.
     *
     * @param blockhash the new blockhash
     */
    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    /**
     * Sets the blockindex.
     *
     * @param blockindex the new blockindex
     */
    public void setBlockindex(Integer blockindex) {
        this.blockindex = blockindex;
    }

    /**
     * Sets the blocktime.
     *
     * @param blocktime the new blocktime
     */
    public void setBlocktime(Integer blocktime) {
        this.blocktime = blocktime;
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
     * Sets the walletconflicts.
     *
     * @param walletconflicts the new walletconflicts
     */
    public void setWalletconflicts(List<Object> walletconflicts) {
        this.walletconflicts = walletconflicts;
    }

    /**
     * Sets the time.
     *
     * @param time the new time
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * Sets the timereceived.
     *
     * @param timereceived the new timereceived
     */
    public void setTimereceived(Integer timereceived) {
        this.timereceived = timereceived;
    }

    /**
     * Sets the bip 125 replaceable.
     *
     * @param bip125Replaceable the new bip 125 replaceable
     */
    public void setBip125Replaceable(String bip125Replaceable) {
        this.bip125Replaceable = bip125Replaceable;
    }

    /**
     * Sets the comment.
     *
     * @param comment the new comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Sets the to.
     *
     * @param to the new to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Sets the abandoned.
     *
     * @param abandoned the new abandoned
     */
    public void setAbandoned(Boolean abandoned) {
        this.abandoned = abandoned;
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
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcListSinceBlockTransactionResponse [address=" + address + ", category=" + category + ", amount=" + amount + ", vout=" + vout
                + ", fee=" + fee + ", confirmations=" + confirmations + ", blockhash=" + blockhash + ", blockindex=" + blockindex + ", blocktime="
                + blocktime + ", txid=" + txid + ", walletconflicts=" + walletconflicts + ", time=" + time + ", timereceived=" + timereceived
                + ", bip125Replaceable=" + bip125Replaceable + ", comment=" + comment + ", to=" + to + ", abandoned=" + abandoned + ", label=" + label
                + "]";
    }

}
