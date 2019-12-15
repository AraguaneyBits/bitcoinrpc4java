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
 * The Class BtcRpcFinalizePsbtResponse.
 *
 * @author jestevez
 */
public class BtcRpcFinalizePsbtResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3463821984057605616L;

    /** The psbt. */
    @JsonProperty("psbt")
    private String psbt;

    /** The hex. */
    @JsonProperty("hex")
    private String hex;

    /** The complete. */
    @JsonProperty("complete")
    private Boolean complete;

    /**
     * Instantiates a new btc rpc finalize psbt response.
     */
    public BtcRpcFinalizePsbtResponse() {
        super();
    }

    /**
     * Gets the psbt.
     *
     * @return the psbt
     */
    public String getPsbt() {
        return psbt;
    }

    /**
     * Sets the psbt.
     *
     * @param psbt the new psbt
     */
    public void setPsbt(String psbt) {
        this.psbt = psbt;
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
     * Gets the complete.
     *
     * @return the complete
     */
    public Boolean getComplete() {
        return complete;
    }

    /**
     * Sets the complete.
     *
     * @param complete the new complete
     */
    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcFinalizePsbtResponse [psbt=" + psbt + ", hex=" + hex + ", complete=" + complete + "]";
    }

}
