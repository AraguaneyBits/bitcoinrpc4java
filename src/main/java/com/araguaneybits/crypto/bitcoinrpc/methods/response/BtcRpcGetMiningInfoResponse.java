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
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcGetMiningInfoResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetMiningInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1498835821001164839L;

    /** The blocks. */
    @JsonProperty("blocks")
    private BigInteger blocks;

    /** The currentblockweight. */
    @JsonProperty("currentblockweight")
    private BigInteger currentblockweight;

    /** The currentblocktx. */
    @JsonProperty("currentblocktx")
    private BigInteger currentblocktx;

    /** The difficulty. */
    @JsonProperty("difficulty")
    private BigInteger difficulty;

    /** The networkhashps. */
    @JsonProperty("networkhashps")
    private BigDecimal networkhashps;

    /** The pooledtx. */
    @JsonProperty("pooledtx")
    private BigInteger pooledtx;

    /** The chain. */
    @JsonProperty("chain")
    private String chain;

    /** The warnings. */
    @JsonProperty("warnings")
    private String warnings;

    /**
     * Instantiates a new btc rpc get mining info response.
     */
    public BtcRpcGetMiningInfoResponse() {
        super();
    }

    /**
     * Gets the blocks.
     *
     * @return the blocks
     */
    public BigInteger getBlocks() {
        return blocks;
    }

    /**
     * Sets the blocks.
     *
     * @param blocks the new blocks
     */
    public void setBlocks(BigInteger blocks) {
        this.blocks = blocks;
    }

    /**
     * Gets the currentblockweight.
     *
     * @return the currentblockweight
     */
    public BigInteger getCurrentblockweight() {
        return currentblockweight;
    }

    /**
     * Sets the currentblockweight.
     *
     * @param currentblockweight the new currentblockweight
     */
    public void setCurrentblockweight(BigInteger currentblockweight) {
        this.currentblockweight = currentblockweight;
    }

    /**
     * Gets the currentblocktx.
     *
     * @return the currentblocktx
     */
    public BigInteger getCurrentblocktx() {
        return currentblocktx;
    }

    /**
     * Sets the currentblocktx.
     *
     * @param currentblocktx the new currentblocktx
     */
    public void setCurrentblocktx(BigInteger currentblocktx) {
        this.currentblocktx = currentblocktx;
    }

    /**
     * Gets the difficulty.
     *
     * @return the difficulty
     */
    public BigInteger getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty.
     *
     * @param difficulty the new difficulty
     */
    public void setDifficulty(BigInteger difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Gets the networkhashps.
     *
     * @return the networkhashps
     */
    public BigDecimal getNetworkhashps() {
        return networkhashps;
    }

    /**
     * Sets the networkhashps.
     *
     * @param networkhashps the new networkhashps
     */
    public void setNetworkhashps(BigDecimal networkhashps) {
        this.networkhashps = networkhashps;
    }

    /**
     * Gets the pooledtx.
     *
     * @return the pooledtx
     */
    public BigInteger getPooledtx() {
        return pooledtx;
    }

    /**
     * Sets the pooledtx.
     *
     * @param pooledtx the new pooledtx
     */
    public void setPooledtx(BigInteger pooledtx) {
        this.pooledtx = pooledtx;
    }

    /**
     * Gets the chain.
     *
     * @return the chain
     */
    public String getChain() {
        return chain;
    }

    /**
     * Sets the chain.
     *
     * @param chain the new chain
     */
    public void setChain(String chain) {
        this.chain = chain;
    }

    /**
     * Gets the warnings.
     *
     * @return the warnings
     */
    public String getWarnings() {
        return warnings;
    }

    /**
     * Sets the warnings.
     *
     * @param warnings the new warnings
     */
    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetMiningInfoResponse [blocks=" + blocks + ", currentblockweight=" + currentblockweight + ", currentblocktx=" + currentblocktx
                + ", difficulty=" + difficulty + ", networkhashps=" + networkhashps + ", pooledtx=" + pooledtx + ", chain=" + chain + ", warnings="
                + warnings + "]";
    }

}
