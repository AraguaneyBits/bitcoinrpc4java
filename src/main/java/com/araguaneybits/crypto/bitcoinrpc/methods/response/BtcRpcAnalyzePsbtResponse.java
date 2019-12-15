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
 * The Class BtcRpcAnalyzePsbtResponse.
 *
 * @author jestevez
 */
public class BtcRpcAnalyzePsbtResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2912254042539872168L;

    /** The inputs. */
    @JsonProperty("inputs")
    private List<BtcRpcAnalyzePsbtInputResponse> inputs;

    /** The next. */
    @JsonProperty("next")
    private String next;

    /**
     * Instantiates a new btc rpc analyze psbt response.
     */
    public BtcRpcAnalyzePsbtResponse() {
        super();
    }

    /**
     * Gets the inputs.
     *
     * @return the inputs
     */
    public List<BtcRpcAnalyzePsbtInputResponse> getInputs() {
        return inputs;
    }

    /**
     * Sets the inputs.
     *
     * @param inputs the new inputs
     */
    public void setInputs(List<BtcRpcAnalyzePsbtInputResponse> inputs) {
        this.inputs = inputs;
    }

    /**
     * Gets the next.
     *
     * @return the next
     */
    public String getNext() {
        return next;
    }

    /**
     * Sets the next.
     *
     * @param next the new next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcAnalyzePsbtResponse [inputs=" + inputs + ", next=" + next + "]";
    }

}
