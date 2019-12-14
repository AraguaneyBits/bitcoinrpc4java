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
 * The Class BtcRpcBumpFeeResponse.
 *
 * @author jestevez
 */
public class BtcRpcBumpFeeResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7432753438792133812L;

    /** The txid. */
    @JsonProperty("txid")
    private String txid;

    /** The origfee. */
    @JsonProperty("origfee")
    private BigDecimal origfee;

    /** The fee. */
    @JsonProperty("fee")
    private BigDecimal fee;

    /** The errors. */
    @JsonProperty("errors")
    private List<Object> errors;

    /**
     * Instantiates a new btc rpc bump fee response.
     */
    public BtcRpcBumpFeeResponse() {
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
     * Gets the origfee.
     *
     * @return the origfee
     */
    public BigDecimal getOrigfee() {
        return origfee;
    }

    /**
     * Sets the origfee.
     *
     * @param origfee the new origfee
     */
    public void setOrigfee(BigDecimal origfee) {
        this.origfee = origfee;
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
     * Gets the errors.
     *
     * @return the errors
     */
    public List<Object> getErrors() {
        return errors;
    }

    /**
     * Sets the errors.
     *
     * @param errors the new errors
     */
    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcBumpFeeResponse [txid=" + txid + ", origfee=" + origfee + ", fee=" + fee + ", errors=" + errors + "]";
    }

}