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
 * The Class BtcRpcListSinceBlockResponse.
 *
 * @author jestevez
 */
public class BtcRpcListSinceBlockResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1758541832861878867L;

    /** The transactions. */
    @JsonProperty("transactions")
    private List<BtcRpcListSinceBlockTransactionResponse> transactions;

    /** The removed. */
    @JsonProperty("removed")
    private List<Object> removed;

    /** The lastblock. */
    @JsonProperty("lastblock")
    private String lastblock;

    /**
     * Instantiates a new btc rpc list since block response.
     */
    public BtcRpcListSinceBlockResponse() {
        super();
    }

    /**
     * Gets the transactions.
     *
     * @return the transactions
     */
    public List<BtcRpcListSinceBlockTransactionResponse> getTransactions() {
        return transactions;
    }

    /**
     * Sets the transactions.
     *
     * @param transactions the new transactions
     */
    public void setTransactions(List<BtcRpcListSinceBlockTransactionResponse> transactions) {
        this.transactions = transactions;
    }

    /**
     * Gets the removed.
     *
     * @return the removed
     */
    public List<Object> getRemoved() {
        return removed;
    }

    /**
     * Sets the removed.
     *
     * @param removed the new removed
     */
    public void setRemoved(List<Object> removed) {
        this.removed = removed;
    }

    /**
     * Gets the lastblock.
     *
     * @return the lastblock
     */
    public String getLastblock() {
        return lastblock;
    }

    /**
     * Sets the lastblock.
     *
     * @param lastblock the new lastblock
     */
    public void setLastblock(String lastblock) {
        this.lastblock = lastblock;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcListSinceBlockResponse [transactions=" + transactions + ", removed=" + removed + ", lastblock=" + lastblock + "]";
    }

}
