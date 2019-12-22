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
 * The Class BtcRpcGetMempoolInfoResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetMempoolInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 652864959557283379L;

    /** The size. */
    @JsonProperty("size")
    private BigInteger size;

    /** The bytes. */
    @JsonProperty("bytes")
    private BigInteger bytes;

    /** The usage. */
    @JsonProperty("usage")
    private BigInteger usage;

    /** The maxmempool. */
    @JsonProperty("maxmempool")
    private BigInteger maxmempool;

    /** The mempoolminfee. */
    @JsonProperty("mempoolminfee")
    private BigDecimal mempoolminfee;

    /** The minrelaytxfee. */
    @JsonProperty("minrelaytxfee")
    private BigDecimal minrelaytxfee;

    /**
     * Instantiates a new btc rpc get mempool info response.
     */
    public BtcRpcGetMempoolInfoResponse() {
        super();
    }

    /**
     * Gets the size.
     *
     * @return the size
     */
    public BigInteger getSize() {
        return size;
    }

    /**
     * Sets the size.
     *
     * @param size the new size
     */
    public void setSize(BigInteger size) {
        this.size = size;
    }

    /**
     * Gets the bytes.
     *
     * @return the bytes
     */
    public BigInteger getBytes() {
        return bytes;
    }

    /**
     * Sets the bytes.
     *
     * @param bytes the new bytes
     */
    public void setBytes(BigInteger bytes) {
        this.bytes = bytes;
    }

    /**
     * Gets the usage.
     *
     * @return the usage
     */
    public BigInteger getUsage() {
        return usage;
    }

    /**
     * Sets the usage.
     *
     * @param usage the new usage
     */
    public void setUsage(BigInteger usage) {
        this.usage = usage;
    }

    /**
     * Gets the maxmempool.
     *
     * @return the maxmempool
     */
    public BigInteger getMaxmempool() {
        return maxmempool;
    }

    /**
     * Sets the maxmempool.
     *
     * @param maxmempool the new maxmempool
     */
    public void setMaxmempool(BigInteger maxmempool) {
        this.maxmempool = maxmempool;
    }

    /**
     * Gets the mempoolminfee.
     *
     * @return the mempoolminfee
     */
    public BigDecimal getMempoolminfee() {
        return mempoolminfee;
    }

    /**
     * Sets the mempoolminfee.
     *
     * @param mempoolminfee the new mempoolminfee
     */
    public void setMempoolminfee(BigDecimal mempoolminfee) {
        this.mempoolminfee = mempoolminfee;
    }

    /**
     * Gets the minrelaytxfee.
     *
     * @return the minrelaytxfee
     */
    public BigDecimal getMinrelaytxfee() {
        return minrelaytxfee;
    }

    /**
     * Sets the minrelaytxfee.
     *
     * @param minrelaytxfee the new minrelaytxfee
     */
    public void setMinrelaytxfee(BigDecimal minrelaytxfee) {
        this.minrelaytxfee = minrelaytxfee;
    }

}
