package com.araguaneybits.crypto.bitcoinrpc.methods.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcGetMempoolEntryResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetMempoolEntryResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4247293936687144242L;

    /** The fees. */
    @JsonProperty("fees")
    private BtcRpcGetMempoolEntryFeesResponse fees;

    /** The size. */
    @JsonProperty("size")
    private Long size;

    /** The fee. */
    @JsonProperty("fee")
    private BigDecimal fee;

    /** The modifiedfee. */
    @JsonProperty("modifiedfee")
    private BigDecimal modifiedfee;

    /** The time. */
    @JsonProperty("time")
    private Long time;

    /** The height. */
    @JsonProperty("height")
    private Long height;

    /** The descendantcount. */
    @JsonProperty("descendantcount")
    private Long descendantcount;

    /** The descendantsize. */
    @JsonProperty("descendantsize")
    private Long descendantsize;

    /** The descendantfees. */
    @JsonProperty("descendantfees")
    private Long descendantfees;

    /** The ancestorcount. */
    @JsonProperty("ancestorcount")
    private Long ancestorcount;

    /** The ancestorsize. */
    @JsonProperty("ancestorsize")
    private Long ancestorsize;

    /** The ancestorfees. */
    @JsonProperty("ancestorfees")
    private Long ancestorfees;

    /** The wtxid. */
    @JsonProperty("wtxid")
    private String wtxid;

    /** The depends. */
    @JsonProperty("depends")
    private List<String> depends;

    /** The spentby. */
    @JsonProperty("spentby")
    private List<String> spentby;

    /** The bip 125 replaceable. */
    @JsonProperty("bip125-replaceable")
    private Boolean bip125Replaceable;

    /**
     * Instantiates a new btc rpc get mempool ancestors response.
     */
    public BtcRpcGetMempoolEntryResponse() {
        super();
    }

    /**
     * Gets the fees.
     *
     * @return the fees
     */
    public BtcRpcGetMempoolEntryFeesResponse getFees() {
        return fees;
    }

    /**
     * Sets the fees.
     *
     * @param fees the new fees
     */
    public void setFees(BtcRpcGetMempoolEntryFeesResponse fees) {
        this.fees = fees;
    }

    /**
     * Gets the size.
     *
     * @return the size
     */
    public Long getSize() {
        return size;
    }

    /**
     * Sets the size.
     *
     * @param size the new size
     */
    public void setSize(Long size) {
        this.size = size;
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
     * Gets the modifiedfee.
     *
     * @return the modifiedfee
     */
    public BigDecimal getModifiedfee() {
        return modifiedfee;
    }

    /**
     * Sets the modifiedfee.
     *
     * @param modifiedfee the new modifiedfee
     */
    public void setModifiedfee(BigDecimal modifiedfee) {
        this.modifiedfee = modifiedfee;
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
     * Gets the height.
     *
     * @return the height
     */
    public Long getHeight() {
        return height;
    }

    /**
     * Sets the height.
     *
     * @param height the new height
     */
    public void setHeight(Long height) {
        this.height = height;
    }

    /**
     * Gets the descendantcount.
     *
     * @return the descendantcount
     */
    public Long getDescendantcount() {
        return descendantcount;
    }

    /**
     * Sets the descendantcount.
     *
     * @param descendantcount the new descendantcount
     */
    public void setDescendantcount(Long descendantcount) {
        this.descendantcount = descendantcount;
    }

    /**
     * Gets the descendantsize.
     *
     * @return the descendantsize
     */
    public Long getDescendantsize() {
        return descendantsize;
    }

    /**
     * Sets the descendantsize.
     *
     * @param descendantsize the new descendantsize
     */
    public void setDescendantsize(Long descendantsize) {
        this.descendantsize = descendantsize;
    }

    /**
     * Gets the descendantfees.
     *
     * @return the descendantfees
     */
    public Long getDescendantfees() {
        return descendantfees;
    }

    /**
     * Sets the descendantfees.
     *
     * @param descendantfees the new descendantfees
     */
    public void setDescendantfees(Long descendantfees) {
        this.descendantfees = descendantfees;
    }

    /**
     * Gets the ancestorcount.
     *
     * @return the ancestorcount
     */
    public Long getAncestorcount() {
        return ancestorcount;
    }

    /**
     * Sets the ancestorcount.
     *
     * @param ancestorcount the new ancestorcount
     */
    public void setAncestorcount(Long ancestorcount) {
        this.ancestorcount = ancestorcount;
    }

    /**
     * Gets the ancestorsize.
     *
     * @return the ancestorsize
     */
    public Long getAncestorsize() {
        return ancestorsize;
    }

    /**
     * Sets the ancestorsize.
     *
     * @param ancestorsize the new ancestorsize
     */
    public void setAncestorsize(Long ancestorsize) {
        this.ancestorsize = ancestorsize;
    }

    /**
     * Gets the ancestorfees.
     *
     * @return the ancestorfees
     */
    public Long getAncestorfees() {
        return ancestorfees;
    }

    /**
     * Sets the ancestorfees.
     *
     * @param ancestorfees the new ancestorfees
     */
    public void setAncestorfees(Long ancestorfees) {
        this.ancestorfees = ancestorfees;
    }

    /**
     * Gets the wtxid.
     *
     * @return the wtxid
     */
    public String getWtxid() {
        return wtxid;
    }

    /**
     * Sets the wtxid.
     *
     * @param wtxid the new wtxid
     */
    public void setWtxid(String wtxid) {
        this.wtxid = wtxid;
    }

    /**
     * Gets the depends.
     *
     * @return the depends
     */
    public List<String> getDepends() {
        return depends;
    }

    /**
     * Sets the depends.
     *
     * @param depends the new depends
     */
    public void setDepends(List<String> depends) {
        this.depends = depends;
    }

    /**
     * Gets the spentby.
     *
     * @return the spentby
     */
    public List<String> getSpentby() {
        return spentby;
    }

    /**
     * Sets the spentby.
     *
     * @param spentby the new spentby
     */
    public void setSpentby(List<String> spentby) {
        this.spentby = spentby;
    }

    /**
     * Gets the bip 125 replaceable.
     *
     * @return the bip 125 replaceable
     */
    public Boolean getBip125Replaceable() {
        return bip125Replaceable;
    }

    /**
     * Sets the bip 125 replaceable.
     *
     * @param bip125Replaceable the new bip 125 replaceable
     */
    public void setBip125Replaceable(Boolean bip125Replaceable) {
        this.bip125Replaceable = bip125Replaceable;
    }
}
