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
 * The Class BtcRpcLoadWalletResponse.
 *
 * @author jestevez
 */
public class BtcRpcLoadWalletResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4078005971597064602L;

    /** The name. */
    @JsonProperty("name")
    private String name;

    /** The warning. */
    @JsonProperty("warning")
    private String warning;

    /**
     * Instantiates a new btc rpc load wallet response.
     */
    public BtcRpcLoadWalletResponse() {
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
     * Gets the warning.
     *
     * @return the warning
     */
    public String getWarning() {
        return warning;
    }

    /**
     * Sets the warning.
     *
     * @param warning the new warning
     */
    public void setWarning(String warning) {
        this.warning = warning;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcLoadWalletResponse [name=" + name + ", warning=" + warning + "]";
    }

}
