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
 * The Class BtcRpcDecodeScriptResponse.
 *
 * @author jestevez
 */
public class BtcRpcDecodeScriptResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1516315150009278828L;

    /** The asm. */
    @JsonProperty("asm")
    private String asm;

    /** The type. */
    @JsonProperty("type")
    private String type;

    /** The p 2 sh. */
    @JsonProperty("p2sh")
    private String p2sh;

    /** The segwit. */
    @JsonProperty("segwit")
    private BtcRpcDecodeScriptSegwitResponse segwit;

    /**
     * Instantiates a new btc rpc decode script response.
     */
    public BtcRpcDecodeScriptResponse() {
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
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the p 2 sh.
     *
     * @return the p 2 sh
     */
    public String getP2sh() {
        return p2sh;
    }

    /**
     * Sets the p 2 sh.
     *
     * @param p2sh the new p 2 sh
     */
    public void setP2sh(String p2sh) {
        this.p2sh = p2sh;
    }

    /**
     * Gets the segwit.
     *
     * @return the segwit
     */
    public BtcRpcDecodeScriptSegwitResponse getSegwit() {
        return segwit;
    }

    /**
     * Sets the segwit.
     *
     * @param segwit the new segwit
     */
    public void setSegwit(BtcRpcDecodeScriptSegwitResponse segwit) {
        this.segwit = segwit;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcDecodeScriptResponse [asm=" + asm + ", type=" + type + ", p2sh=" + p2sh + ", segwit=" + segwit + "]";
    }

}
