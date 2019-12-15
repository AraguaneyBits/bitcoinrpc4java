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
 * The Class BtcRpcDecodePsbtScriptPubKeyResponse.
 *
 * @author jestevez
 */
public class BtcRpcDecodePsbtScriptPubKeyResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4221892764501221126L;

    /** The asm. */
    @JsonProperty("asm")
    private String asm;

    /** The hex. */
    @JsonProperty("hex")
    private String hex;

    /** The req sigs. */
    @JsonProperty("reqSigs")
    private Integer reqSigs;

    /** The type. */
    @JsonProperty("type")
    private String type;

    /** The addresses. */
    @JsonProperty("addresses")
    private List<String> addresses;

    /**
     * Instantiates a new btc rpc decode psbt script pub key response.
     */
    public BtcRpcDecodePsbtScriptPubKeyResponse() {
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

    /**
     * Gets the req sigs.
     *
     * @return the req sigs
     */
    public Integer getReqSigs() {
        return reqSigs;
    }

    /**
     * Sets the req sigs.
     *
     * @param reqSigs the new req sigs
     */
    public void setReqSigs(Integer reqSigs) {
        this.reqSigs = reqSigs;
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
     * Gets the addresses.
     *
     * @return the addresses
     */
    public List<String> getAddresses() {
        return addresses;
    }

    /**
     * Sets the addresses.
     *
     * @param addresses the new addresses
     */
    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcDecodePsbtScriptPubKeyResponse [asm=" + asm + ", hex=" + hex + ", reqSigs=" + reqSigs + ", type=" + type + ", addresses="
                + addresses + "]";
    }

}
