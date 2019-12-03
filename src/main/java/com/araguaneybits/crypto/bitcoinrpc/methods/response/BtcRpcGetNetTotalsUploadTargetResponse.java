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
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcGetNetTotalsUploadTargetResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetNetTotalsUploadTargetResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5055704267192905202L;

    /** The timeframe. */
    @JsonProperty("timeframe")
    private BigInteger timeframe;

    /** The target. */
    @JsonProperty("target")
    private BigInteger target;

    /** The target reached. */
    @JsonProperty("target_reached")
    private Boolean targetReached;

    /** The serve historical blocks. */
    @JsonProperty("serve_historical_blocks")
    private Boolean serveHistoricalBlocks;

    /** The bytes left in cycle. */
    @JsonProperty("bytes_left_in_cycle")
    private BigInteger bytesLeftInCycle;

    /** The time left in cycle. */
    @JsonProperty("time_left_in_cycle")
    private BigInteger timeLeftInCycle;

    /**
     * Instantiates a new btc rpc get net totals upload target response.
     */
    public BtcRpcGetNetTotalsUploadTargetResponse() {
        super();
    }

    /**
     * Gets the timeframe.
     *
     * @return the timeframe
     */
    public BigInteger getTimeframe() {
        return timeframe;
    }

    /**
     * Sets the timeframe.
     *
     * @param timeframe the new timeframe
     */
    public void setTimeframe(BigInteger timeframe) {
        this.timeframe = timeframe;
    }

    /**
     * Gets the target.
     *
     * @return the target
     */
    public BigInteger getTarget() {
        return target;
    }

    /**
     * Sets the target.
     *
     * @param target the new target
     */
    public void setTarget(BigInteger target) {
        this.target = target;
    }

    /**
     * Gets the target reached.
     *
     * @return the target reached
     */
    public Boolean getTargetReached() {
        return targetReached;
    }

    /**
     * Sets the target reached.
     *
     * @param targetReached the new target reached
     */
    public void setTargetReached(Boolean targetReached) {
        this.targetReached = targetReached;
    }

    /**
     * Gets the serve historical blocks.
     *
     * @return the serve historical blocks
     */
    public Boolean getServeHistoricalBlocks() {
        return serveHistoricalBlocks;
    }

    /**
     * Sets the serve historical blocks.
     *
     * @param serveHistoricalBlocks the new serve historical blocks
     */
    public void setServeHistoricalBlocks(Boolean serveHistoricalBlocks) {
        this.serveHistoricalBlocks = serveHistoricalBlocks;
    }

    /**
     * Gets the bytes left in cycle.
     *
     * @return the bytes left in cycle
     */
    public BigInteger getBytesLeftInCycle() {
        return bytesLeftInCycle;
    }

    /**
     * Sets the bytes left in cycle.
     *
     * @param bytesLeftInCycle the new bytes left in cycle
     */
    public void setBytesLeftInCycle(BigInteger bytesLeftInCycle) {
        this.bytesLeftInCycle = bytesLeftInCycle;
    }

    /**
     * Gets the time left in cycle.
     *
     * @return the time left in cycle
     */
    public BigInteger getTimeLeftInCycle() {
        return timeLeftInCycle;
    }

    /**
     * Sets the time left in cycle.
     *
     * @param timeLeftInCycle the new time left in cycle
     */
    public void setTimeLeftInCycle(BigInteger timeLeftInCycle) {
        this.timeLeftInCycle = timeLeftInCycle;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetNetTotalsUploadTargetResponse [timeframe=" + timeframe + ", target=" + target + ", targetReached=" + targetReached
                + ", serveHistoricalBlocks=" + serveHistoricalBlocks + ", bytesLeftInCycle=" + bytesLeftInCycle + ", timeLeftInCycle="
                + timeLeftInCycle + "]";
    }

}
