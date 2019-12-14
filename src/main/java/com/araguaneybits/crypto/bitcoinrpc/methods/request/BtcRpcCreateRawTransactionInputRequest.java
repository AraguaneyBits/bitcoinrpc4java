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
package com.araguaneybits.crypto.bitcoinrpc.methods.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcCreateRawTransactionInputRequest.
 *
 * @author jestevez
 */
public class BtcRpcCreateRawTransactionInputRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6208388735935098514L;

    /** The txid. */
    @JsonProperty("txid")
    private String txid;

    /** The vout. */
    @JsonProperty("vout")
    private Long vout;

    /**
     * Instantiates a new btc rpc create raw transaction request.
     */
    public BtcRpcCreateRawTransactionInputRequest() {
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcCreateRawTransactionRequest [txid=" + txid + ", vout=" + vout + "]";
    }

}
