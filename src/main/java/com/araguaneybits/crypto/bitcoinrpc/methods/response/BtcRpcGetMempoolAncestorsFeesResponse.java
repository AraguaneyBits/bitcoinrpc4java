package com.araguaneybits.crypto.bitcoinrpc.methods.response;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcGetMempoolAncestorsFeesResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetMempoolAncestorsFeesResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -428190165883622641L;

    /** The base. */
    @JsonProperty("base")
    private BigDecimal base;

    /** The modified. */
    @JsonProperty("modified")
    private BigDecimal modified;

    /** The ancestor. */
    @JsonProperty("ancestor")
    private BigDecimal ancestor;

    /** The descendant. */
    @JsonProperty("descendant")
    private BigDecimal descendant;

    /**
     * Instantiates a new btc rpc get mempool ancestors fees response.
     */
    public BtcRpcGetMempoolAncestorsFeesResponse() {
        super();
    }

    /**
     * Gets the base.
     *
     * @return the base
     */
    public BigDecimal getBase() {
        return base;
    }

    /**
     * Sets the base.
     *
     * @param base the new base
     */
    public void setBase(BigDecimal base) {
        this.base = base;
    }

    /**
     * Gets the modified.
     *
     * @return the modified
     */
    public BigDecimal getModified() {
        return modified;
    }

    /**
     * Sets the modified.
     *
     * @param modified the new modified
     */
    public void setModified(BigDecimal modified) {
        this.modified = modified;
    }

    /**
     * Gets the ancestor.
     *
     * @return the ancestor
     */
    public BigDecimal getAncestor() {
        return ancestor;
    }

    /**
     * Sets the ancestor.
     *
     * @param ancestor the new ancestor
     */
    public void setAncestor(BigDecimal ancestor) {
        this.ancestor = ancestor;
    }

    /**
     * Gets the descendant.
     *
     * @return the descendant
     */
    public BigDecimal getDescendant() {
        return descendant;
    }

    /**
     * Sets the descendant.
     *
     * @param descendant the new descendant
     */
    public void setDescendant(BigDecimal descendant) {
        this.descendant = descendant;
    }

}
