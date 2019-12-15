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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcAnalyzePsbtInputResponse.
 *
 * @author jestevez
 */
public class BtcRpcAnalyzePsbtInputResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 510287818528427353L;

    /** The has utxo. */
    @JsonProperty("has_utxo")
    private Boolean hasUtxo;

    /** The is final. */
    @JsonProperty("is_final")
    private Boolean isFinal;

    /** The next. */
    @JsonProperty("next")
    private String next;

    /**
     * Instantiates a new btc rpc analyze psbt input response.
     */
    public BtcRpcAnalyzePsbtInputResponse() {
        super();
    }

    /**
     * Gets the checks for utxo.
     *
     * @return the checks for utxo
     */
    public Boolean getHasUtxo() {
        return hasUtxo;
    }

    /**
     * Sets the checks for utxo.
     *
     * @param hasUtxo the new checks for utxo
     */
    public void setHasUtxo(Boolean hasUtxo) {
        this.hasUtxo = hasUtxo;
    }

    /**
     * Gets the checks if is final.
     *
     * @return the checks if is final
     */
    public Boolean getIsFinal() {
        return isFinal;
    }

    /**
     * Sets the checks if is final.
     *
     * @param isFinal the new checks if is final
     */
    public void setIsFinal(Boolean isFinal) {
        this.isFinal = isFinal;
    }

    /**
     * Gets the next.
     *
     * @return the next
     */
    public String getNext() {
        return next;
    }

    /**
     * Sets the next.
     *
     * @param next the new next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcAnalyzePsbtInputResponse [hasUtxo=" + hasUtxo + ", isFinal=" + isFinal + ", next=" + next + "]";
    }

}
