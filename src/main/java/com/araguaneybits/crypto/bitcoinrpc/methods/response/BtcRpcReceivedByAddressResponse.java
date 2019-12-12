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
 * The Class ReceivedByAddress.
 *
 * @author Jose Luis Estevez jose.estevez.prieto@gmail.com
 * @version 1.0.0
 * @date 02-nov-2017
 */
public class BtcRpcReceivedByAddressResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3597136519765712835L;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The amount. */
    @JsonProperty("amount")
    private BigDecimal amount;

    /** The confirmations. */
    @JsonProperty("confirmations")
    private Long confirmations;

    /** The label. */
    @JsonProperty("label")
    private String label;

    /** The txids. */
    @JsonProperty("txids")
    private List<String> txids;

    /** The account. */
    @JsonProperty("account")
    private String account;

    /**
     * No args constructor for use in serialization.
     */
    public BtcRpcReceivedByAddressResponse() {
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
     * Gets the account.
     *
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the account.
     *
     * @param account the new account
     */
    public void setAccount(String account) {
        this.account = account;
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
     * Gets the txids.
     *
     * @return the txids
     */
    public List<String> getTxids() {
        return txids;
    }

    /**
     * Sets the txids.
     *
     * @param txids the new txids
     */
    public void setTxids(List<String> txids) {
        this.txids = txids;
    }

}
