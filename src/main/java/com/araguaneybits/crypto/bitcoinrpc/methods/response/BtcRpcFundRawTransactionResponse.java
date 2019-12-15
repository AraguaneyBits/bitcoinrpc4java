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
 * The Class BtcRpcFundRawTransactionResponse.
 *
 * @author jestevez
 */
public class BtcRpcFundRawTransactionResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9017138360816606160L;

    /** The hex. */
    @JsonProperty("hex")
    private String hex;

    /** The fee. */
    @JsonProperty("fee")
    private BigDecimal fee;

    /** The changepos. */
    @JsonProperty("changepos")
    private Long changepos;

    /**
     * Instantiates a new btc rpc fund raw transaction response.
     */
    public BtcRpcFundRawTransactionResponse() {
        super();
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
     * Gets the changepos.
     *
     * @return the changepos
     */
    public Long getChangepos() {
        return changepos;
    }

    /**
     * Sets the changepos.
     *
     * @param changepos the new changepos
     */
    public void setChangepos(Long changepos) {
        this.changepos = changepos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcFundRawTransactionResponse [hex=" + hex + ", fee=" + fee + ", changepos=" + changepos + "]";
    }

}
