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
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcGetTransactionResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetTransactionResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1306890086251744110L;

    /** The amount. */
    @JsonProperty("amount")
    private BigDecimal amount;

    /** The fee. */
    @JsonProperty("fee")
    private BigDecimal fee;

    /** The confirmations. */
    @JsonProperty("confirmations")
    private Long confirmations;

    /** The trusted. */
    @JsonProperty("trusted")
    private Boolean trusted;

    /** The txid. */
    @JsonProperty("txid")
    private String txid;

    /** The walletconflicts. */
    @JsonProperty("walletconflicts")
    private List<String> walletconflicts;

    /** The time. */
    @JsonProperty("time")
    private Long time;

    /** The timereceived. */
    @JsonProperty("timereceived")
    private Long timereceived;

    /** The bip 125 replaceable. */
    @JsonProperty("bip125-replaceable")
    private String bip125Replaceable;

    /** The details. */
    @JsonProperty("details")
    private List<BtcRpcGetTransactionDetailResponse> details;

    /** The hex. */
    @JsonProperty("hex")
    private String hex;

    /** The comment. */
    @JsonProperty("comment")
    private String comment;

    /** The replaces txid. */
    @JsonProperty("replaces_txid")
    private String replacesTxid;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The category. */
    @JsonProperty("category")
    private String category;

    /** The label. */
    @JsonProperty("label")
    private String label;

    /** The vout. */
    @JsonProperty("vout")
    private Long vout;

    /** The blockhash. */
    @JsonProperty("blockhash")
    private String blockhash;

    /** The blockindex. */
    @JsonProperty("blockindex")
    private Long blockindex;

    /** The blocktime. */
    @JsonProperty("blocktime")
    private Long blocktime;

    /**
     * Instantiates a new btc rpc get transaction response.
     */
    public BtcRpcGetTransactionResponse() {
        super();
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
     * Gets the fee.
     *
     * @return the fee
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * Sets the fee.
     *
     * @param fee the new fee
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
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
     * Gets the trusted.
     *
     * @return the trusted
     */
    public Boolean getTrusted() {
        return trusted;
    }

    /**
     * Sets the trusted.
     *
     * @param trusted the new trusted
     */
    public void setTrusted(Boolean trusted) {
        this.trusted = trusted;
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
     * Gets the walletconflicts.
     *
     * @return the walletconflicts
     */
    public List<String> getWalletconflicts() {
        return walletconflicts;
    }

    /**
     * Sets the walletconflicts.
     *
     * @param walletconflicts the new walletconflicts
     */
    public void setWalletconflicts(List<String> walletconflicts) {
        this.walletconflicts = walletconflicts;
    }

    /**
     * Gets the time.
     *
     * @return the time
     */
    public Long getTime() {
        return time;
    }

    /**
     * Sets the time.
     *
     * @param time the new time
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * Gets the timereceived.
     *
     * @return the timereceived
     */
    public Long getTimereceived() {
        return timereceived;
    }

    /**
     * Sets the timereceived.
     *
     * @param timereceived the new timereceived
     */
    public void setTimereceived(Long timereceived) {
        this.timereceived = timereceived;
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
     * Sets the bip 125 replaceable.
     *
     * @param bip125Replaceable the new bip 125 replaceable
     */
    public void setBip125Replaceable(String bip125Replaceable) {
        this.bip125Replaceable = bip125Replaceable;
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
     * Sets the comment.
     *
     * @param comment the new comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets the replaces txid.
     *
     * @return the replaces txid
     */
    public String getReplacesTxid() {
        return replacesTxid;
    }

    /**
     * Sets the replaces txid.
     *
     * @param replacesTxid the new replaces txid
     */
    public void setReplacesTxid(String replacesTxid) {
        this.replacesTxid = replacesTxid;
    }

    /**
     * Gets the details.
     *
     * @return the details
     */
    public List<BtcRpcGetTransactionDetailResponse> getDetails() {
        return details;
    }

    /**
     * Sets the details.
     *
     * @param details the new details
     */
    public void setDetails(List<BtcRpcGetTransactionDetailResponse> details) {
        this.details = details;
    }

    /**
     * Gets the hex.
     *
     * @return the hex
     */
    public String getHex() {
        return hex;
    }

    /**
     * Sets the hex.
     *
     * @param hex the new hex
     */
    public void setHex(String hex) {
        this.hex = hex;
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
     * Gets the category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
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
     * Gets the blockhash.
     *
     * @return the blockhash
     */
    public String getBlockhash() {
        return blockhash;
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
     * Gets the blockindex.
     *
     * @return the blockindex
     */
    public Long getBlockindex() {
        return blockindex;
    }

    /**
     * Sets the blockindex.
     *
     * @param blockindex the new blockindex
     */
    public void setBlockindex(Long blockindex) {
        this.blockindex = blockindex;
    }

    /**
     * Gets the blocktime.
     *
     * @return the blocktime
     */
    public Long getBlocktime() {
        return blocktime;
    }

    /**
     * Sets the blocktime.
     *
     * @param blocktime the new blocktime
     */
    public void setBlocktime(Long blocktime) {
        this.blocktime = blocktime;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetTransactionResponse [amount=" + amount + ", fee=" + fee + ", confirmations=" + confirmations + ", trusted=" + trusted
                + ", txid=" + txid + ", walletconflicts=" + walletconflicts + ", time=" + time + ", timereceived=" + timereceived
                + ", bip125Replaceable=" + bip125Replaceable + ", details=" + details + ", hex=" + hex + ", comment=" + comment + ", replacesTxid="
                + replacesTxid + "]";
    }

}