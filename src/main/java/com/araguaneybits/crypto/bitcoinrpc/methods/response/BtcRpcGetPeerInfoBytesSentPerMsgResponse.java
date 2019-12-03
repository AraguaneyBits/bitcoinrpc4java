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
 * The Class BtcRpcGetPeerInfoBytesSentPerMsgResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetPeerInfoBytesSentPerMsgResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8622819537912520393L;

    /** The addr. */
    @JsonProperty("addr")
    private Long addr;

    /** The feefilter. */
    @JsonProperty("feefilter")
    private Long feefilter;

    /** The getaddr. */
    @JsonProperty("getaddr")
    private Long getaddr;

    /** The getdata. */
    @JsonProperty("getdata")
    private Long getdata;

    /** The getheaders. */
    @JsonProperty("getheaders")
    private Long getheaders;

    /** The headers. */
    @JsonProperty("headers")
    private Long headers;

    /** The inv. */
    @JsonProperty("inv")
    private Long inv;

    /** The ping. */
    @JsonProperty("ping")
    private Long ping;

    /** The pong. */
    @JsonProperty("pong")
    private Long pong;

    /** The sendcmpct. */
    @JsonProperty("sendcmpct")
    private Long sendcmpct;

    /** The sendheaders. */
    @JsonProperty("sendheaders")
    private Long sendheaders;

    /** The tx. */
    @JsonProperty("tx")
    private Long tx;

    /** The verack. */
    @JsonProperty("verack")
    private Long verack;

    /** The version. */
    @JsonProperty("version")
    private Long version;

    /** The getblocktxn. */
    @JsonProperty("getblocktxn")
    private Long getblocktxn;

    /** The notfound. */
    @JsonProperty("notfound")
    private Long notfound;

    /**
     * Instantiates a new btc rpc get peer info bytes sent per msg response.
     */
    public BtcRpcGetPeerInfoBytesSentPerMsgResponse() {
        super();
    }

    /**
     * Gets the addr.
     *
     * @return the addr
     */
    public Long getAddr() {
        return addr;
    }

    /**
     * Sets the addr.
     *
     * @param addr the new addr
     */
    public void setAddr(Long addr) {
        this.addr = addr;
    }

    /**
     * Gets the feefilter.
     *
     * @return the feefilter
     */
    public Long getFeefilter() {
        return feefilter;
    }

    /**
     * Sets the feefilter.
     *
     * @param feefilter the new feefilter
     */
    public void setFeefilter(Long feefilter) {
        this.feefilter = feefilter;
    }

    /**
     * Gets the getaddr.
     *
     * @return the getaddr
     */
    public Long getGetaddr() {
        return getaddr;
    }

    /**
     * Sets the getaddr.
     *
     * @param getaddr the new getaddr
     */
    public void setGetaddr(Long getaddr) {
        this.getaddr = getaddr;
    }

    /**
     * Gets the getdata.
     *
     * @return the getdata
     */
    public Long getGetdata() {
        return getdata;
    }

    /**
     * Sets the getdata.
     *
     * @param getdata the new getdata
     */
    public void setGetdata(Long getdata) {
        this.getdata = getdata;
    }

    /**
     * Gets the getheaders.
     *
     * @return the getheaders
     */
    public Long getGetheaders() {
        return getheaders;
    }

    /**
     * Sets the getheaders.
     *
     * @param getheaders the new getheaders
     */
    public void setGetheaders(Long getheaders) {
        this.getheaders = getheaders;
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
     * Gets the inv.
     *
     * @return the inv
     */
    public Long getInv() {
        return inv;
    }

    /**
     * Sets the inv.
     *
     * @param inv the new inv
     */
    public void setInv(Long inv) {
        this.inv = inv;
    }

    /**
     * Gets the ping.
     *
     * @return the ping
     */
    public Long getPing() {
        return ping;
    }

    /**
     * Sets the ping.
     *
     * @param ping the new ping
     */
    public void setPing(Long ping) {
        this.ping = ping;
    }

    /**
     * Gets the pong.
     *
     * @return the pong
     */
    public Long getPong() {
        return pong;
    }

    /**
     * Sets the pong.
     *
     * @param pong the new pong
     */
    public void setPong(Long pong) {
        this.pong = pong;
    }

    /**
     * Gets the sendcmpct.
     *
     * @return the sendcmpct
     */
    public Long getSendcmpct() {
        return sendcmpct;
    }

    /**
     * Sets the sendcmpct.
     *
     * @param sendcmpct the new sendcmpct
     */
    public void setSendcmpct(Long sendcmpct) {
        this.sendcmpct = sendcmpct;
    }

    /**
     * Gets the sendheaders.
     *
     * @return the sendheaders
     */
    public Long getSendheaders() {
        return sendheaders;
    }

    /**
     * Sets the sendheaders.
     *
     * @param sendheaders the new sendheaders
     */
    public void setSendheaders(Long sendheaders) {
        this.sendheaders = sendheaders;
    }

    /**
     * Gets the tx.
     *
     * @return the tx
     */
    public Long getTx() {
        return tx;
    }

    /**
     * Sets the tx.
     *
     * @param tx the new tx
     */
    public void setTx(Long tx) {
        this.tx = tx;
    }

    /**
     * Gets the verack.
     *
     * @return the verack
     */
    public Long getVerack() {
        return verack;
    }

    /**
     * Sets the verack.
     *
     * @param verack the new verack
     */
    public void setVerack(Long verack) {
        this.verack = verack;
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
     * Gets the getblocktxn.
     *
     * @return the getblocktxn
     */
    public Long getGetblocktxn() {
        return getblocktxn;
    }

    /**
     * Sets the getblocktxn.
     *
     * @param getblocktxn the new getblocktxn
     */
    public void setGetblocktxn(Long getblocktxn) {
        this.getblocktxn = getblocktxn;
    }

    /**
     * Gets the notfound.
     *
     * @return the notfound
     */
    public Long getNotfound() {
        return notfound;
    }

    /**
     * Sets the notfound.
     *
     * @param notfound the new notfound
     */
    public void setNotfound(Long notfound) {
        this.notfound = notfound;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetPeerInfoBytesSentPerMsgResponse [addr=" + addr + ", feefilter=" + feefilter + ", getaddr=" + getaddr + ", getdata=" + getdata
                + ", getheaders=" + getheaders + ", headers=" + headers + ", inv=" + inv + ", ping=" + ping + ", pong=" + pong + ", sendcmpct="
                + sendcmpct + ", sendheaders=" + sendheaders + ", tx=" + tx + ", verack=" + verack + ", version=" + version + ", getblocktxn="
                + getblocktxn + ", notfound=" + notfound + "]";
    }

}
