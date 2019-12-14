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
 * The Class BtcRpcGetTransactionDetailResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetTransactionDetailResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 842100011599556028L;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The category. */
    @JsonProperty("category")
    private String category;

    /** The amount. */
    @JsonProperty("amount")
    private BigDecimal amount;

    /** The label. */
    @JsonProperty("label")
    private String label;

    /** The vout. */
    @JsonProperty("vout")
    private Long vout;

    /** The fee. */
    @JsonProperty("fee")
    private BigDecimal fee;

    /** The abandoned. */
    @JsonProperty("abandoned")
    private Boolean abandoned;

    /**
     * Instantiates a new btc rpc get transaction detail response.
     */
    public BtcRpcGetTransactionDetailResponse() {
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
     * Gets the abandoned.
     *
     * @return the abandoned
     */
    public Boolean getAbandoned() {
        return abandoned;
    }

    /**
     * Sets the abandoned.
     *
     * @param abandoned the new abandoned
     */
    public void setAbandoned(Boolean abandoned) {
        this.abandoned = abandoned;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetTransactionDetailResponse [address=" + address + ", category=" + category + ", amount=" + amount + ", label=" + label
                + ", vout=" + vout + ", fee=" + fee + ", abandoned=" + abandoned + "]";
    }

}
