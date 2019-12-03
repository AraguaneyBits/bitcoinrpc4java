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
 * The Class BtcRpcBlockchainInfoResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetBlockchainInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8256008445080805952L;

    /** The chain. */
    @JsonProperty("chain")
    private String chain;

    /** The blocks. */
    @JsonProperty("blocks")
    private Long blocks;

    /** The headers. */
    @JsonProperty("headers")
    private Long headers;

    /** The bestblockhash. */
    @JsonProperty("bestblockhash")
    private String bestblockhash;

    /** The difficulty. */
    @JsonProperty("difficulty")
    private Double difficulty;

    /** The mediantime. */
    @JsonProperty("mediantime")
    private Long mediantime;

    /** The verificationprogress. */
    @JsonProperty("verificationprogress")
    private Long verificationprogress;

    /** The initialblockdownload. */
    @JsonProperty("initialblockdownload")
    private Boolean initialblockdownload;

    /** The chainwork. */
    @JsonProperty("chainwork")
    private String chainwork;

    /** The size on disk. */
    @JsonProperty("size_on_disk")
    private Long sizeOnDisk;

    /** The pruned. */
    @JsonProperty("pruned")
    private Boolean pruned;

    /** The warnings. */
    @JsonProperty("warnings")
    private String warnings;

    /**
     * Instantiates a new btc rpc blockchain info response.
     */
    public BtcRpcGetBlockchainInfoResponse() {
        super();
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

    /**
     * Gets the headers.
     *
     * @return the headers
     */
    public Long getHeaders() {
        return headers;
    }

    /**
     * Sets the headers.
     *
     * @param headers the new headers
     */
    public void setHeaders(Long headers) {
        this.headers = headers;
    }

    /**
     * Gets the bestblockhash.
     *
     * @return the bestblockhash
     */
    public String getBestblockhash() {
        return bestblockhash;
    }

    /**
     * Sets the bestblockhash.
     *
     * @param bestblockhash the new bestblockhash
     */
    public void setBestblockhash(String bestblockhash) {
        this.bestblockhash = bestblockhash;
    }

    /**
     * Gets the difficulty.
     *
     * @return the difficulty
     */
    public Double getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty.
     *
     * @param difficulty the new difficulty
     */
    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Gets the mediantime.
     *
     * @return the mediantime
     */
    public Long getMediantime() {
        return mediantime;
    }

    /**
     * Sets the mediantime.
     *
     * @param mediantime the new mediantime
     */
    public void setMediantime(Long mediantime) {
        this.mediantime = mediantime;
    }

    /**
     * Gets the verificationprogress.
     *
     * @return the verificationprogress
     */
    public Long getVerificationprogress() {
        return verificationprogress;
    }

    /**
     * Sets the verificationprogress.
     *
     * @param verificationprogress the new verificationprogress
     */
    public void setVerificationprogress(Long verificationprogress) {
        this.verificationprogress = verificationprogress;
    }

    /**
     * Gets the initialblockdownload.
     *
     * @return the initialblockdownload
     */
    public Boolean getInitialblockdownload() {
        return initialblockdownload;
    }

    /**
     * Sets the initialblockdownload.
     *
     * @param initialblockdownload the new initialblockdownload
     */
    public void setInitialblockdownload(Boolean initialblockdownload) {
        this.initialblockdownload = initialblockdownload;
    }

    /**
     * Gets the chainwork.
     *
     * @return the chainwork
     */
    public String getChainwork() {
        return chainwork;
    }

    /**
     * Sets the chainwork.
     *
     * @param chainwork the new chainwork
     */
    public void setChainwork(String chainwork) {
        this.chainwork = chainwork;
    }

    /**
     * Gets the size on disk.
     *
     * @return the size on disk
     */
    public Long getSizeOnDisk() {
        return sizeOnDisk;
    }

    /**
     * Sets the size on disk.
     *
     * @param sizeOnDisk the new size on disk
     */
    public void setSizeOnDisk(Long sizeOnDisk) {
        this.sizeOnDisk = sizeOnDisk;
    }

    /**
     * Gets the pruned.
     *
     * @return the pruned
     */
    public Boolean getPruned() {
        return pruned;
    }

    /**
     * Sets the pruned.
     *
     * @param pruned the new pruned
     */
    public void setPruned(Boolean pruned) {
        this.pruned = pruned;
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

}