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
package com.araguaneybits.crypto.bitcoinrpc.methods.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcBlockTemplateRequest.
 *
 * @author jestevez
 */
public class BtcRpcBlockTemplateRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8042129927802790751L;

    /** The mode. */
    @JsonProperty("mode")
    private String mode;

    /** The capabilities. */
    @JsonProperty("capabilities")
    private String[] capabilities;

    /** The rules. */
    @JsonProperty("rules")
    private String[] rules;

    /**
     * Instantiates a new btc rpc block template request.
     */
    public BtcRpcBlockTemplateRequest() {
        super();
    }

    /**
     * Gets the mode.
     *
     * @return the mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the mode.
     *
     * @param mode the new mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    public String[] getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String[] capabilities) {
        this.capabilities = capabilities;
    }

    public String[] getRules() {
        return rules;
    }

    public void setRules(String[] rules) {
        this.rules = rules;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcBlockTemplateRequest [mode=" + mode + ", capabilities=" + capabilities + ", rules=" + rules + "]";
    }

}
