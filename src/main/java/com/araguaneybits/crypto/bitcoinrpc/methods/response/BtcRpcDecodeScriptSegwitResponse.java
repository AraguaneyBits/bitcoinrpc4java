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
 * The Class BtcRpcDecodeScriptSegwitResponse.
 *
 * @author jestevez
 */
public class BtcRpcDecodeScriptSegwitResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2072905535326597405L;

    /** The asm. */
    @JsonProperty("asm")
    private String asm;

    /** The hex. */
    @JsonProperty("hex")
    private String hex;

    /** The req sigs. */
    @JsonProperty("reqSigs")
    private Long reqSigs;

    /** The type. */
    @JsonProperty("type")
    private String type;

    /** The addresses. */
    @JsonProperty("addresses")
    private List<String> addresses;

    /** The p 2 sh segwit. */
    @JsonProperty("p2sh-segwit")
    private String p2shSegwit;

    /**
     * Instantiates a new btc rpc decode script segwit response.
     */
    public BtcRpcDecodeScriptSegwitResponse() {
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
    public Long getReqSigs() {
        return reqSigs;
    }

    /**
     * Sets the req sigs.
     *
     * @param reqSigs the new req sigs
     */
    public void setReqSigs(Long reqSigs) {
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

    /**
     * Gets the p 2 sh segwit.
     *
     * @return the p 2 sh segwit
     */
    public String getP2shSegwit() {
        return p2shSegwit;
    }

    /**
     * Sets the p 2 sh segwit.
     *
     * @param p2shSegwit the new p 2 sh segwit
     */
    public void setP2shSegwit(String p2shSegwit) {
        this.p2shSegwit = p2shSegwit;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcDecodeScriptSegwitResponse [asm=" + asm + ", hex=" + hex + ", reqSigs=" + reqSigs + ", type=" + type + ", addresses="
                + addresses + ", p2shSegwit=" + p2shSegwit + "]";
    }

}
