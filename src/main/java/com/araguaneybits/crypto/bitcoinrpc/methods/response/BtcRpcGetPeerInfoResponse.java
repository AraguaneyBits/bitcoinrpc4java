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
 * The Class BtcRpcGetPeerInfoResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetPeerInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7807446820834517691L;

    /** The id. */
    @JsonProperty("id")
    private Long id;

    /** The addr. */
    @JsonProperty("addr")
    private String addr;

    /** The addrlocal. */
    @JsonProperty("addrlocal")
    private String addrlocal;

    /** The addrbind. */
    @JsonProperty("addrbind")
    private String addrbind;

    /** The services. */
    @JsonProperty("services")
    private String services;

    /** The relaytxes. */
    @JsonProperty("relaytxes")
    private Boolean relaytxes;

    /** The lastsend. */
    @JsonProperty("lastsend")
    private Long lastsend;

    /** The lastrecv. */
    @JsonProperty("lastrecv")
    private Long lastrecv;

    /** The bytessent. */
    @JsonProperty("bytessent")
    private Long bytessent;

    /** The bytesrecv. */
    @JsonProperty("bytesrecv")
    private Long bytesrecv;

    /** The conntime. */
    @JsonProperty("conntime")
    private Long conntime;

    /** The timeoffset. */
    @JsonProperty("timeoffset")
    private Long timeoffset;

    /** The pingtime. */
    @JsonProperty("pingtime")
    private Double pingtime;

    /** The pingwait. */
    @JsonProperty("pingwait")
    private Double pingwait;

    /** The minping. */
    @JsonProperty("minping")
    private Double minping;

    /** The version. */
    @JsonProperty("version")
    private Long version;

    /** The subver. */
    @JsonProperty("subver")
    private String subver;

    /** The inbound. */
    @JsonProperty("inbound")
    private Boolean inbound;

    /** The addnode. */
    @JsonProperty("addnode")
    private Boolean addnode;

    /** The startingheight. */
    @JsonProperty("startingheight")
    private Long startingheight;

    /** The banscore. */
    @JsonProperty("banscore")
    private Long banscore;

    /** The synced headers. */
    @JsonProperty("synced_headers")
    private Long syncedHeaders;

    /** The synced blocks. */
    @JsonProperty("synced_blocks")
    private Long syncedBlocks;

    /** The inflight. */
    @JsonProperty("inflight")
    private List<Object> inflight;

    /** The whitelisted. */
    @JsonProperty("whitelisted")
    private Boolean whitelisted;

    /** The minfeefilter. */
    @JsonProperty("minfeefilter")
    private Double minfeefilter;

    /** The bytessent per msg. */
    @JsonProperty("bytessent_per_msg")
    private BtcRpcGetPeerInfoBytesSentPerMsgResponse bytessentPerMsg;

    /** The bytesrecv per msg. */
    @JsonProperty("bytesrecv_per_msg")
    private BtcRpcGetPeerInfoBytesRecvPerMsgResponse bytesrecvPerMsg;

    /**
     * Instantiates a new btc rpc get peer info response.
     */
    public BtcRpcGetPeerInfoResponse() {
        super();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the addr.
     *
     * @return the addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * Sets the addr.
     *
     * @param addr the new addr
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * Gets the addrlocal.
     *
     * @return the addrlocal
     */
    public String getAddrlocal() {
        return addrlocal;
    }

    /**
     * Sets the addrlocal.
     *
     * @param addrlocal the new addrlocal
     */
    public void setAddrlocal(String addrlocal) {
        this.addrlocal = addrlocal;
    }

    /**
     * Gets the addrbind.
     *
     * @return the addrbind
     */
    public String getAddrbind() {
        return addrbind;
    }

    /**
     * Sets the addrbind.
     *
     * @param addrbind the new addrbind
     */
    public void setAddrbind(String addrbind) {
        this.addrbind = addrbind;
    }

    /**
     * Gets the services.
     *
     * @return the services
     */
    public String getServices() {
        return services;
    }

    /**
     * Sets the services.
     *
     * @param services the new services
     */
    public void setServices(String services) {
        this.services = services;
    }

    /**
     * Gets the relaytxes.
     *
     * @return the relaytxes
     */
    public Boolean getRelaytxes() {
        return relaytxes;
    }

    /**
     * Sets the relaytxes.
     *
     * @param relaytxes the new relaytxes
     */
    public void setRelaytxes(Boolean relaytxes) {
        this.relaytxes = relaytxes;
    }

    /**
     * Gets the lastsend.
     *
     * @return the lastsend
     */
    public Long getLastsend() {
        return lastsend;
    }

    /**
     * Sets the lastsend.
     *
     * @param lastsend the new lastsend
     */
    public void setLastsend(Long lastsend) {
        this.lastsend = lastsend;
    }

    /**
     * Gets the lastrecv.
     *
     * @return the lastrecv
     */
    public Long getLastrecv() {
        return lastrecv;
    }

    /**
     * Sets the lastrecv.
     *
     * @param lastrecv the new lastrecv
     */
    public void setLastrecv(Long lastrecv) {
        this.lastrecv = lastrecv;
    }

    /**
     * Gets the bytessent.
     *
     * @return the bytessent
     */
    public Long getBytessent() {
        return bytessent;
    }

    /**
     * Sets the bytessent.
     *
     * @param bytessent the new bytessent
     */
    public void setBytessent(Long bytessent) {
        this.bytessent = bytessent;
    }

    /**
     * Gets the bytesrecv.
     *
     * @return the bytesrecv
     */
    public Long getBytesrecv() {
        return bytesrecv;
    }

    /**
     * Sets the bytesrecv.
     *
     * @param bytesrecv the new bytesrecv
     */
    public void setBytesrecv(Long bytesrecv) {
        this.bytesrecv = bytesrecv;
    }

    /**
     * Gets the conntime.
     *
     * @return the conntime
     */
    public Long getConntime() {
        return conntime;
    }

    /**
     * Sets the conntime.
     *
     * @param conntime the new conntime
     */
    public void setConntime(Long conntime) {
        this.conntime = conntime;
    }

    /**
     * Gets the timeoffset.
     *
     * @return the timeoffset
     */
    public Long getTimeoffset() {
        return timeoffset;
    }

    /**
     * Sets the timeoffset.
     *
     * @param timeoffset the new timeoffset
     */
    public void setTimeoffset(Long timeoffset) {
        this.timeoffset = timeoffset;
    }

    /**
     * Gets the pingtime.
     *
     * @return the pingtime
     */
    public Double getPingtime() {
        return pingtime;
    }

    /**
     * Sets the pingtime.
     *
     * @param pingtime the new pingtime
     */
    public void setPingtime(Double pingtime) {
        this.pingtime = pingtime;
    }

    /**
     * Gets the minping.
     *
     * @return the minping
     */
    public Double getMinping() {
        return minping;
    }

    /**
     * Sets the minping.
     *
     * @param minping the new minping
     */
    public void setMinping(Double minping) {
        this.minping = minping;
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
     * Gets the subver.
     *
     * @return the subver
     */
    public String getSubver() {
        return subver;
    }

    /**
     * Sets the subver.
     *
     * @param subver the new subver
     */
    public void setSubver(String subver) {
        this.subver = subver;
    }

    /**
     * Gets the inbound.
     *
     * @return the inbound
     */
    public Boolean getInbound() {
        return inbound;
    }

    /**
     * Sets the inbound.
     *
     * @param inbound the new inbound
     */
    public void setInbound(Boolean inbound) {
        this.inbound = inbound;
    }

    /**
     * Gets the addnode.
     *
     * @return the addnode
     */
    public Boolean getAddnode() {
        return addnode;
    }

    /**
     * Sets the addnode.
     *
     * @param addnode the new addnode
     */
    public void setAddnode(Boolean addnode) {
        this.addnode = addnode;
    }

    /**
     * Gets the startingheight.
     *
     * @return the startingheight
     */
    public Long getStartingheight() {
        return startingheight;
    }

    /**
     * Sets the startingheight.
     *
     * @param startingheight the new startingheight
     */
    public void setStartingheight(Long startingheight) {
        this.startingheight = startingheight;
    }

    /**
     * Gets the banscore.
     *
     * @return the banscore
     */
    public Long getBanscore() {
        return banscore;
    }

    /**
     * Sets the banscore.
     *
     * @param banscore the new banscore
     */
    public void setBanscore(Long banscore) {
        this.banscore = banscore;
    }

    /**
     * Gets the synced headers.
     *
     * @return the synced headers
     */
    public Long getSyncedHeaders() {
        return syncedHeaders;
    }

    /**
     * Sets the synced headers.
     *
     * @param syncedHeaders the new synced headers
     */
    public void setSyncedHeaders(Long syncedHeaders) {
        this.syncedHeaders = syncedHeaders;
    }

    /**
     * Gets the synced blocks.
     *
     * @return the synced blocks
     */
    public Long getSyncedBlocks() {
        return syncedBlocks;
    }

    /**
     * Sets the synced blocks.
     *
     * @param syncedBlocks the new synced blocks
     */
    public void setSyncedBlocks(Long syncedBlocks) {
        this.syncedBlocks = syncedBlocks;
    }

    /**
     * Gets the inflight.
     *
     * @return the inflight
     */
    public List<Object> getInflight() {
        return inflight;
    }

    /**
     * Sets the inflight.
     *
     * @param inflight the new inflight
     */
    public void setInflight(List<Object> inflight) {
        this.inflight = inflight;
    }

    /**
     * Gets the whitelisted.
     *
     * @return the whitelisted
     */
    public Boolean getWhitelisted() {
        return whitelisted;
    }

    /**
     * Sets the whitelisted.
     *
     * @param whitelisted the new whitelisted
     */
    public void setWhitelisted(Boolean whitelisted) {
        this.whitelisted = whitelisted;
    }

    /**
     * Gets the minfeefilter.
     *
     * @return the minfeefilter
     */
    public Double getMinfeefilter() {
        return minfeefilter;
    }

    /**
     * Sets the minfeefilter.
     *
     * @param minfeefilter the new minfeefilter
     */
    public void setMinfeefilter(Double minfeefilter) {
        this.minfeefilter = minfeefilter;
    }

    /**
     * Gets the bytessent per msg.
     *
     * @return the bytessent per msg
     */
    public BtcRpcGetPeerInfoBytesSentPerMsgResponse getBytessentPerMsg() {
        return bytessentPerMsg;
    }

    /**
     * Sets the bytessent per msg.
     *
     * @param bytessentPerMsg the new bytessent per msg
     */
    public void setBytessentPerMsg(BtcRpcGetPeerInfoBytesSentPerMsgResponse bytessentPerMsg) {
        this.bytessentPerMsg = bytessentPerMsg;
    }

    /**
     * Gets the bytesrecv per msg.
     *
     * @return the bytesrecv per msg
     */
    public BtcRpcGetPeerInfoBytesRecvPerMsgResponse getBytesrecvPerMsg() {
        return bytesrecvPerMsg;
    }

    /**
     * Sets the bytesrecv per msg.
     *
     * @param bytesrecvPerMsg the new bytesrecv per msg
     */
    public void setBytesrecvPerMsg(BtcRpcGetPeerInfoBytesRecvPerMsgResponse bytesrecvPerMsg) {
        this.bytesrecvPerMsg = bytesrecvPerMsg;
    }

    /**
     * Gets the pingwait.
     *
     * @return the pingwait
     */
    public Double getPingwait() {
        return pingwait;
    }

    /**
     * Sets the pingwait.
     *
     * @param pingwait the new pingwait
     */
    public void setPingwait(Double pingwait) {
        this.pingwait = pingwait;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetPeerInfoResponse [id=" + id + ", addr=" + addr + ", addrlocal=" + addrlocal + ", addrbind=" + addrbind + ", services="
                + services + ", relaytxes=" + relaytxes + ", lastsend=" + lastsend + ", lastrecv=" + lastrecv + ", bytessent=" + bytessent
                + ", bytesrecv=" + bytesrecv + ", conntime=" + conntime + ", timeoffset=" + timeoffset + ", pingtime=" + pingtime + ", pingwait="
                + pingwait + ", minping=" + minping + ", version=" + version + ", subver=" + subver + ", inbound=" + inbound + ", addnode=" + addnode
                + ", startingheight=" + startingheight + ", banscore=" + banscore + ", syncedHeaders=" + syncedHeaders + ", syncedBlocks="
                + syncedBlocks + ", inflight=" + inflight + ", whitelisted=" + whitelisted + ", minfeefilter=" + minfeefilter + ", bytessentPerMsg="
                + bytessentPerMsg + ", bytesrecvPerMsg=" + bytesrecvPerMsg + "]";
    }

}
