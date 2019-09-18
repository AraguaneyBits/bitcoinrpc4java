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
 * The Class BtcRpcGetChainTxStatsResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetChainTxStatsResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1771972953533624672L;

    /** The time. */
    @JsonProperty("time")
    private Long time;

    /** The txcount. */
    @JsonProperty("txcount")
    private Long txcount;

    /** The window final block hash. */
    @JsonProperty("window_final_block_hash")
    private String windowFinalBlockHash;

    /** The window block count. */
    @JsonProperty("window_block_count")
    private Long windowBlockCount;

    /** The window tx count. */
    @JsonProperty("window_tx_count")
    private Long windowTxCount;

    /** The window interval. */
    @JsonProperty("window_interval")
    private Long windowInterval;

    /** The txrate. */
    @JsonProperty("txrate")
    private BigDecimal txrate;

    /**
     * Instantiates a new btc rpc get chain tx stats response.
     */
    public BtcRpcGetChainTxStatsResponse() {
        super();
    }

    /**
     * Gets the time.
     *
     * @return the time
     */
    public Long getTime() {
        return time;
    }

    /**
     * Sets the time.
     *
     * @param time the new time
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * Gets the txcount.
     *
     * @return the txcount
     */
    public Long getTxcount() {
        return txcount;
    }

    /**
     * Sets the txcount.
     *
     * @param txcount the new txcount
     */
    public void setTxcount(Long txcount) {
        this.txcount = txcount;
    }

    /**
     * Gets the window final block hash.
     *
     * @return the window final block hash
     */
    public String getWindowFinalBlockHash() {
        return windowFinalBlockHash;
    }

    /**
     * Sets the window final block hash.
     *
     * @param windowFinalBlockHash the new window final block hash
     */
    public void setWindowFinalBlockHash(String windowFinalBlockHash) {
        this.windowFinalBlockHash = windowFinalBlockHash;
    }

    /**
     * Gets the window block count.
     *
     * @return the window block count
     */
    public Long getWindowBlockCount() {
        return windowBlockCount;
    }

    /**
     * Sets the window block count.
     *
     * @param windowBlockCount the new window block count
     */
    public void setWindowBlockCount(Long windowBlockCount) {
        this.windowBlockCount = windowBlockCount;
    }

    /**
     * Gets the window tx count.
     *
     * @return the window tx count
     */
    public Long getWindowTxCount() {
        return windowTxCount;
    }

    /**
     * Sets the window tx count.
     *
     * @param windowTxCount the new window tx count
     */
    public void setWindowTxCount(Long windowTxCount) {
        this.windowTxCount = windowTxCount;
    }

    /**
     * Gets the window interval.
     *
     * @return the window interval
     */
    public Long getWindowInterval() {
        return windowInterval;
    }

    /**
     * Sets the window interval.
     *
     * @param windowInterval the new window interval
     */
    public void setWindowInterval(Long windowInterval) {
        this.windowInterval = windowInterval;
    }

    /**
     * Gets the txrate.
     *
     * @return the txrate
     */
    public BigDecimal getTxrate() {
        return txrate;
    }

    /**
     * Sets the txrate.
     *
     * @param txrate the new txrate
     */
    public void setTxrate(BigDecimal txrate) {
        this.txrate = txrate;
    }

}
