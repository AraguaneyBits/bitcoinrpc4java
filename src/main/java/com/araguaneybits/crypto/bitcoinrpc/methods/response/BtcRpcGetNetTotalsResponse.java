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
 */package com.araguaneybits.crypto.bitcoinrpc.methods.response;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcGetNetTotalsResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetNetTotalsResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3960268874461388415L;

    /** The totalbytesrecv. */
    @JsonProperty("totalbytesrecv")
    private BigInteger totalbytesrecv;

    /** The totalbytessent. */
    @JsonProperty("totalbytessent")
    private BigInteger totalbytessent;

    /** The timemillis. */
    @JsonProperty("timemillis")
    private BigInteger timemillis;

    /** The uploadtarget. */
    @JsonProperty("uploadtarget")
    private BtcRpcGetNetTotalsUploadTargetResponse uploadtarget;

    /**
     * Instantiates a new btc rpc get net totals response.
     */
    public BtcRpcGetNetTotalsResponse() {
        super();
    }

    /**
     * Gets the totalbytesrecv.
     *
     * @return the totalbytesrecv
     */
    public BigInteger getTotalbytesrecv() {
        return totalbytesrecv;
    }

    /**
     * Sets the totalbytesrecv.
     *
     * @param totalbytesrecv the new totalbytesrecv
     */
    public void setTotalbytesrecv(BigInteger totalbytesrecv) {
        this.totalbytesrecv = totalbytesrecv;
    }

    /**
     * Gets the totalbytessent.
     *
     * @return the totalbytessent
     */
    public BigInteger getTotalbytessent() {
        return totalbytessent;
    }

    /**
     * Sets the totalbytessent.
     *
     * @param totalbytessent the new totalbytessent
     */
    public void setTotalbytessent(BigInteger totalbytessent) {
        this.totalbytessent = totalbytessent;
    }

    /**
     * Gets the timemillis.
     *
     * @return the timemillis
     */
    public BigInteger getTimemillis() {
        return timemillis;
    }

    /**
     * Sets the timemillis.
     *
     * @param timemillis the new timemillis
     */
    public void setTimemillis(BigInteger timemillis) {
        this.timemillis = timemillis;
    }

    /**
     * Gets the uploadtarget.
     *
     * @return the uploadtarget
     */
    public BtcRpcGetNetTotalsUploadTargetResponse getUploadtarget() {
        return uploadtarget;
    }

    /**
     * Sets the uploadtarget.
     *
     * @param uploadtarget the new uploadtarget
     */
    public void setUploadtarget(BtcRpcGetNetTotalsUploadTargetResponse uploadtarget) {
        this.uploadtarget = uploadtarget;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetNetTotalsResponse [totalbytesrecv=" + totalbytesrecv + ", totalbytessent=" + totalbytessent + ", timemillis=" + timemillis
                + ", uploadtarget=" + uploadtarget + "]";
    }

}
