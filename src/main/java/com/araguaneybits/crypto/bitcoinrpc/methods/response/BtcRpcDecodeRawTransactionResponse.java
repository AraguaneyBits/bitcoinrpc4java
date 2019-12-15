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
 * The Class BtcRpcDecodeRawTransactionResponse.
 *
 * @author jestevez
 */
public class BtcRpcDecodeRawTransactionResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7137780319909282371L;

    /** The txid. */
    @JsonProperty("txid")
    private String txid;

    /** The hash. */
    @JsonProperty("hash")
    private String hash;

    /** The version. */
    @JsonProperty("version")
    private Long version;

    /** The size. */
    @JsonProperty("size")
    private Long size;

    /** The vsize. */
    @JsonProperty("vsize")
    private Long vsize;

    /** The weight. */
    @JsonProperty("weight")
    private Long weight;

    /** The locktime. */
    @JsonProperty("locktime")
    private Long locktime;

    /** The vin. */
    @JsonProperty("vin")
    private List<BtcRpcDecodePsbtVinResponse> vin;

    /** The vout. */
    @JsonProperty("vout")
    private List<BtcRpcDecodePsbtVoutResponse> vout;

    /** The hex. */
    @JsonProperty("hex")
    private String hex;

    /**
     * Instantiates a new btc rpc decode raw transaction response.
     */
    public BtcRpcDecodeRawTransactionResponse() {
        super();
    }

    /**
     * Gets the txid.
     *
     * @return the txid
     */
    public String getTxid() {
        return txid;
    }

    /**
     * Sets the txid.
     *
     * @param txid the new txid
     */
    public void setTxid(String txid) {
        this.txid = txid;
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
     * Gets the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version the new version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * Gets the size.
     *
     * @return the size
     */
    public Long getSize() {
        return size;
    }

    /**
     * Sets the size.
     *
     * @param size the new size
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * Gets the vsize.
     *
     * @return the vsize
     */
    public Long getVsize() {
        return vsize;
    }

    /**
     * Sets the vsize.
     *
     * @param vsize the new vsize
     */
    public void setVsize(Long vsize) {
        this.vsize = vsize;
    }

    /**
     * Gets the weight.
     *
     * @return the weight
     */
    public Long getWeight() {
        return weight;
    }

    /**
     * Sets the weight.
     *
     * @param weight the new weight
     */
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    /**
     * Gets the locktime.
     *
     * @return the locktime
     */
    public Long getLocktime() {
        return locktime;
    }

    /**
     * Sets the locktime.
     *
     * @param locktime the new locktime
     */
    public void setLocktime(Long locktime) {
        this.locktime = locktime;
    }

    /**
     * Gets the vin.
     *
     * @return the vin
     */
    public List<BtcRpcDecodePsbtVinResponse> getVin() {
        return vin;
    }

    /**
     * Sets the vin.
     *
     * @param vin the new vin
     */
    public void setVin(List<BtcRpcDecodePsbtVinResponse> vin) {
        this.vin = vin;
    }

    /**
     * Gets the vout.
     *
     * @return the vout
     */
    public List<BtcRpcDecodePsbtVoutResponse> getVout() {
        return vout;
    }

    /**
     * Sets the vout.
     *
     * @param vout the new vout
     */
    public void setVout(List<BtcRpcDecodePsbtVoutResponse> vout) {
        this.vout = vout;
    }

    /**
     * Gets the hex.
     *
     * @return the hex
     */
    public String getHex() {
        return hex;
    }

    /**
     * Sets the hex.
     *
     * @param hex the new hex
     */
    public void setHex(String hex) {
        this.hex = hex;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcDecodeRawTransactionResponse [txid=" + txid + ", hash=" + hash + ", version=" + version + ", size=" + size + ", vsize=" + vsize
                + ", weight=" + weight + ", locktime=" + locktime + ", vin=" + vin + ", vout=" + vout + "]";
    }

}
