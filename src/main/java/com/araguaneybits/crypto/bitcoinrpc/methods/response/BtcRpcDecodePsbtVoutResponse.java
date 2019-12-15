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
 * The Class BtcRpcDecodePsbtVoutResponse.
 *
 * @author jestevez
 */
public class BtcRpcDecodePsbtVoutResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -691571323051650888L;

    /** The value. */
    @JsonProperty("value")
    private BigDecimal value;

    /** The n. */
    @JsonProperty("n")
    private Long n;

    /** The script pub key. */
    @JsonProperty("scriptPubKey")
    private BtcRpcDecodePsbtScriptPubKeyResponse scriptPubKey;

    /**
     * Instantiates a new btc rpc decode psbt vout response.
     */
    public BtcRpcDecodePsbtVoutResponse() {
        super();
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets the n.
     *
     * @return the n
     */
    public Long getN() {
        return n;
    }

    /**
     * Sets the n.
     *
     * @param n the new n
     */
    public void setN(Long n) {
        this.n = n;
    }

    /**
     * Gets the script pub key.
     *
     * @return the script pub key
     */
    public BtcRpcDecodePsbtScriptPubKeyResponse getScriptPubKey() {
        return scriptPubKey;
    }

    /**
     * Sets the script pub key.
     *
     * @param scriptPubKey the new script pub key
     */
    public void setScriptPubKey(BtcRpcDecodePsbtScriptPubKeyResponse scriptPubKey) {
        this.scriptPubKey = scriptPubKey;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcDecodePsbtVoutResponse [value=" + value + ", n=" + n + ", scriptPubKey=" + scriptPubKey + "]";
    }

}
