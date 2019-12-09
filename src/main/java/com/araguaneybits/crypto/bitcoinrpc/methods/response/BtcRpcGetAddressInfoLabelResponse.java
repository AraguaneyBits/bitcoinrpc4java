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
 * The Class BtcRpcGetAddressInfoLabelResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetAddressInfoLabelResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9039923597556903321L;

    /** The name. */
    @JsonProperty("name")
    private String name;

    /** The purpose. */
    @JsonProperty("purpose")
    private String purpose;

    /**
     * Instantiates a new btc rpc get address info label response.
     */
    public BtcRpcGetAddressInfoLabelResponse() {
        super();
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the purpose.
     *
     * @return the purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * Sets the purpose.
     *
     * @param purpose the new purpose
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetAddressInfoLabelResponse [name=" + name + ", purpose=" + purpose + "]";
    }

}
