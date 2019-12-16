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
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcEstimateSmartFeeResponse.
 *
 * @author jestevez
 */
public class BtcRpcEstimateSmartFeeResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4771558294948416404L;

    /** The feerate. */
    @JsonProperty("feerate")
    private BigDecimal feerate;

    /** The blocks. */
    @JsonProperty("blocks")
    private Long blocks;

    /**
     * Instantiates a new btc rpc estimate smart fee response.
     */
    public BtcRpcEstimateSmartFeeResponse() {
        super();
    }

    /**
     * Gets the feerate.
     *
     * @return the feerate
     */
    public BigDecimal getFeerate() {
        return feerate;
    }

    /**
     * Sets the feerate.
     *
     * @param feerate the new feerate
     */
    public void setFeerate(BigDecimal feerate) {
        this.feerate = feerate;
    }

    /**
     * Gets the blocks.
     *
     * @return the blocks
     */
    public Long getBlocks() {
        return blocks;
    }

    /**
     * Sets the blocks.
     *
     * @param blocks the new blocks
     */
    public void setBlocks(Long blocks) {
        this.blocks = blocks;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcEstimateSmartFeeResponse [feerate=" + feerate + ", blocks=" + blocks + "]";
    }

}