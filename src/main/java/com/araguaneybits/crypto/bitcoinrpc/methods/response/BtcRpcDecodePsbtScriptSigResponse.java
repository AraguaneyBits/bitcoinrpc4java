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
 * The Class BtcRpcDecodePsbtScriptSigResponse.
 *
 * @author jestevez
 */
public class BtcRpcDecodePsbtScriptSigResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -334840916817458291L;

    /** The asm. */
    @JsonProperty("asm")
    private String asm;

    /** The hex. */
    @JsonProperty("hex")
    private String hex;

    /**
     * Instantiates a new btc rpc decode psbt script sig response.
     */
    public BtcRpcDecodePsbtScriptSigResponse() {
        super();
    }

    /**
     * Gets the asm.
     *
     * @return the asm
     */
    public String getAsm() {
        return asm;
    }

    /**
     * Sets the asm.
     *
     * @param asm the new asm
     */
    public void setAsm(String asm) {
        this.asm = asm;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcDecodePsbtScriptSigResponse [asm=" + asm + ", hex=" + hex + "]";
    }

}
