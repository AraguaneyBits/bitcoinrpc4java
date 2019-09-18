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
 * The Class BtcRpcGetChainTipsResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetChainTipsResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2190908465289946340L;

    /** The height. */
    @JsonProperty("height")
    private Long height;

    /** The hash. */
    @JsonProperty("hash")
    private String hash;

    /** The branchlen. */
    @JsonProperty("branchlen")
    private Long branchlen;

    /** The status. */
    @JsonProperty("status")
    private String status;

    /**
     * Instantiates a new btc rpc get chain tips response.
     */
    public BtcRpcGetChainTipsResponse() {
        super();
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public Long getHeight() {
        return height;
    }

    /**
     * Sets the height.
     *
     * @param height the new height
     */
    public void setHeight(Long height) {
        this.height = height;
    }

    /**
     * Gets the hash.
     *
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * Sets the hash.
     *
     * @param hash the new hash
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * Gets the branchlen.
     *
     * @return the branchlen
     */
    public Long getBranchlen() {
        return branchlen;
    }

    /**
     * Sets the branchlen.
     *
     * @param branchlen the new branchlen
     */
    public void setBranchlen(Long branchlen) {
        this.branchlen = branchlen;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
