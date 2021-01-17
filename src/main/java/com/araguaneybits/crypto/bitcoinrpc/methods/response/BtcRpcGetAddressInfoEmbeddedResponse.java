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
 * The Class BtcRpcGetAddressInfoEmbeddedResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetAddressInfoEmbeddedResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2136750189069807225L;

    /** The isscript. */
    @JsonProperty("isscript")
    private Boolean isscript;

    /** The iswitness. */
    @JsonProperty("iswitness")
    private Boolean iswitness;

    /** The witness version. */
    @JsonProperty("witness_version")
    private Long witnessVersion;

    /** The witness program. */
    @JsonProperty("witness_program")
    private String witnessProgram;

    /** The pubkey. */
    @JsonProperty("pubkey")
    private String pubkey;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The script pub key. */
    @JsonProperty("scriptPubKey")
    private String scriptPubKey;

    /**
     * Instantiates a new btc rpc get address info embedded response.
     */
    public BtcRpcGetAddressInfoEmbeddedResponse() {
        super();
    }

    /**
     * Gets the isscript.
     *
     * @return the isscript
     */
    public Boolean getIsscript() {
        return isscript;
    }

    /**
     * Sets the isscript.
     *
     * @param isscript the new isscript
     */
    public void setIsscript(Boolean isscript) {
        this.isscript = isscript;
    }

    /**
     * Gets the iswitness.
     *
     * @return the iswitness
     */
    public Boolean getIswitness() {
        return iswitness;
    }

    /**
     * Sets the iswitness.
     *
     * @param iswitness the new iswitness
     */
    public void setIswitness(Boolean iswitness) {
        this.iswitness = iswitness;
    }

    /**
     * Gets the witness version.
     *
     * @return the witness version
     */
    public Long getWitnessVersion() {
        return witnessVersion;
    }

    /**
     * Sets the witness version.
     *
     * @param witnessVersion the new witness version
     */
    public void setWitnessVersion(Long witnessVersion) {
        this.witnessVersion = witnessVersion;
    }

    /**
     * Gets the witness program.
     *
     * @return the witness program
     */
    public String getWitnessProgram() {
        return witnessProgram;
    }

    /**
     * Sets the witness program.
     *
     * @param witnessProgram the new witness program
     */
    public void setWitnessProgram(String witnessProgram) {
        this.witnessProgram = witnessProgram;
    }

    /**
     * Gets the pubkey.
     *
     * @return the pubkey
     */
    public String getPubkey() {
        return pubkey;
    }

    /**
     * Sets the pubkey.
     *
     * @param pubkey the new pubkey
     */
    public void setPubkey(String pubkey) {
        this.pubkey = pubkey;
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
     * Gets the script pub key.
     *
     * @return the script pub key
     */
    public String getScriptPubKey() {
        return scriptPubKey;
    }

    /**
     * Sets the script pub key.
     *
     * @param scriptPubKey the new script pub key
     */
    public void setScriptPubKey(String scriptPubKey) {
        this.scriptPubKey = scriptPubKey;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetAddressInfoEmbeddedResponse [isscript=" + isscript + ", iswitness=" + iswitness + ", witnessVersion=" + witnessVersion
                + ", witnessProgram=" + witnessProgram + ", pubkey=" + pubkey + ", address=" + address + ", scriptPubKey=" + scriptPubKey + "]";
    }

}
