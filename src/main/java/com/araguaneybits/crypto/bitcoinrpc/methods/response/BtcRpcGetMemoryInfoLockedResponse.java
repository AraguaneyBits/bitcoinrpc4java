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
 * The Class BtcRpcGetMemoryInfoLockedResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetMemoryInfoLockedResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5512528388943668470L;

    /** The used. */
    @JsonProperty("used")
    private BigInteger used;

    /** The free. */
    @JsonProperty("free")
    private BigInteger free;

    /** The total. */
    @JsonProperty("total")
    private BigInteger total;

    /** The locked. */
    @JsonProperty("locked")
    private BigInteger locked;

    /** The chunks used. */
    @JsonProperty("chunks_used")
    private BigInteger chunksUsed;

    /** The chunks free. */
    @JsonProperty("chunks_free")
    private BigInteger chunksFree;

    /**
     * Instantiates a new btc rpc get memory info locked response.
     */
    public BtcRpcGetMemoryInfoLockedResponse() {
        super();
    }

    /**
     * Gets the used.
     *
     * @return the used
     */
    public BigInteger getUsed() {
        return used;
    }

    /**
     * Sets the used.
     *
     * @param used the new used
     */
    public void setUsed(BigInteger used) {
        this.used = used;
    }

    /**
     * Gets the free.
     *
     * @return the free
     */
    public BigInteger getFree() {
        return free;
    }

    /**
     * Sets the free.
     *
     * @param free the new free
     */
    public void setFree(BigInteger free) {
        this.free = free;
    }

    /**
     * Gets the total.
     *
     * @return the total
     */
    public BigInteger getTotal() {
        return total;
    }

    /**
     * Sets the total.
     *
     * @param total the new total
     */
    public void setTotal(BigInteger total) {
        this.total = total;
    }

    /**
     * Gets the locked.
     *
     * @return the locked
     */
    public BigInteger getLocked() {
        return locked;
    }

    /**
     * Sets the locked.
     *
     * @param locked the new locked
     */
    public void setLocked(BigInteger locked) {
        this.locked = locked;
    }

    /**
     * Gets the chunks used.
     *
     * @return the chunks used
     */
    public BigInteger getChunksUsed() {
        return chunksUsed;
    }

    /**
     * Sets the chunks used.
     *
     * @param chunksUsed the new chunks used
     */
    public void setChunksUsed(BigInteger chunksUsed) {
        this.chunksUsed = chunksUsed;
    }

    /**
     * Gets the chunks free.
     *
     * @return the chunks free
     */
    public BigInteger getChunksFree() {
        return chunksFree;
    }

    /**
     * Sets the chunks free.
     *
     * @param chunksFree the new chunks free
     */
    public void setChunksFree(BigInteger chunksFree) {
        this.chunksFree = chunksFree;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetMemoryInfoLockedResponse [used=" + used + ", free=" + free + ", total=" + total + ", locked=" + locked + ", chunksUsed="
                + chunksUsed + ", chunksFree=" + chunksFree + "]";
    }

}
