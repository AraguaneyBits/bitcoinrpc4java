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
 * The Class BtcRpcGetDescriptorInfoResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetDescriptorInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7968583221668964859L;

    /** The descriptor. */
    @JsonProperty("descriptor")
    private String descriptor;

    /** The isrange. */
    @JsonProperty("isrange")
    private Boolean isrange;

    /** The issolvable. */
    @JsonProperty("issolvable")
    private Boolean issolvable;

    /** The hasprivatekeys. */
    @JsonProperty("hasprivatekeys")
    private Boolean hasprivatekeys;

    /**
     * Instantiates a new btc rpc get descriptor info response.
     */
    public BtcRpcGetDescriptorInfoResponse() {
        super();
    }

    /**
     * Gets the descriptor.
     *
     * @return the descriptor
     */
    public String getDescriptor() {
        return descriptor;
    }

    /**
     * Sets the descriptor.
     *
     * @param descriptor the new descriptor
     */
    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    /**
     * Gets the isrange.
     *
     * @return the isrange
     */
    public Boolean getIsrange() {
        return isrange;
    }

    /**
     * Sets the isrange.
     *
     * @param isrange the new isrange
     */
    public void setIsrange(Boolean isrange) {
        this.isrange = isrange;
    }

    /**
     * Gets the issolvable.
     *
     * @return the issolvable
     */
    public Boolean getIssolvable() {
        return issolvable;
    }

    /**
     * Sets the issolvable.
     *
     * @param issolvable the new issolvable
     */
    public void setIssolvable(Boolean issolvable) {
        this.issolvable = issolvable;
    }

    /**
     * Gets the hasprivatekeys.
     *
     * @return the hasprivatekeys
     */
    public Boolean getHasprivatekeys() {
        return hasprivatekeys;
    }

    /**
     * Sets the hasprivatekeys.
     *
     * @param hasprivatekeys the new hasprivatekeys
     */
    public void setHasprivatekeys(Boolean hasprivatekeys) {
        this.hasprivatekeys = hasprivatekeys;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetDescriptorInfoResponse [descriptor=" + descriptor + ", isrange=" + isrange + ", issolvable=" + issolvable
                + ", hasprivatekeys=" + hasprivatekeys + "]";
    }

}