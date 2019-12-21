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
 * The Class BtcRpcLoggingResponse.
 *
 * @author jestevez
 */
public class BtcRpcLoggingResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4890606655176178685L;

    /** The net. */
    @JsonProperty("net")
    private Boolean net;

    /** The tor. */
    @JsonProperty("tor")
    private Boolean tor;

    /** The mempool. */
    @JsonProperty("mempool")
    private Boolean mempool;

    /** The http. */
    @JsonProperty("http")
    private Boolean http;

    /** The bench. */
    @JsonProperty("bench")
    private Boolean bench;

    /** The zmq. */
    @JsonProperty("zmq")
    private Boolean zmq;

    /** The db. */
    @JsonProperty("db")
    private Boolean db;

    /** The rpc. */
    @JsonProperty("rpc")
    private Boolean rpc;

    /** The estimatefee. */
    @JsonProperty("estimatefee")
    private Boolean estimatefee;

    /** The addrman. */
    @JsonProperty("addrman")
    private Boolean addrman;

    /** The selectcoins. */
    @JsonProperty("selectcoins")
    private Boolean selectcoins;

    /** The reindex. */
    @JsonProperty("reindex")
    private Boolean reindex;

    /** The cmpctblock. */
    @JsonProperty("cmpctblock")
    private Boolean cmpctblock;

    /** The rand. */
    @JsonProperty("rand")
    private Boolean rand;

    /** The prune. */
    @JsonProperty("prune")
    private Boolean prune;

    /** The proxy. */
    @JsonProperty("proxy")
    private Boolean proxy;

    /** The mempoolrej. */
    @JsonProperty("mempoolrej")
    private Boolean mempoolrej;

    /** The libevent. */
    @JsonProperty("libevent")
    private Boolean libevent;

    /** The coindb. */
    @JsonProperty("coindb")
    private Boolean coindb;

    /** The qt. */
    @JsonProperty("qt")
    private Boolean qt;

    /** The leveldb. */
    @JsonProperty("leveldb")
    private Boolean leveldb;

    /**
     * Instantiates a new btc rpc logging response.
     */
    public BtcRpcLoggingResponse() {
        super();
    }

    /**
     * Gets the net.
     *
     * @return the net
     */
    public Boolean getNet() {
        return net;
    }

    /**
     * Sets the net.
     *
     * @param net the new net
     */
    public void setNet(Boolean net) {
        this.net = net;
    }

    /**
     * Gets the tor.
     *
     * @return the tor
     */
    public Boolean getTor() {
        return tor;
    }

    /**
     * Sets the tor.
     *
     * @param tor the new tor
     */
    public void setTor(Boolean tor) {
        this.tor = tor;
    }

    /**
     * Gets the mempool.
     *
     * @return the mempool
     */
    public Boolean getMempool() {
        return mempool;
    }

    /**
     * Sets the mempool.
     *
     * @param mempool the new mempool
     */
    public void setMempool(Boolean mempool) {
        this.mempool = mempool;
    }

    /**
     * Gets the http.
     *
     * @return the http
     */
    public Boolean getHttp() {
        return http;
    }

    /**
     * Sets the http.
     *
     * @param http the new http
     */
    public void setHttp(Boolean http) {
        this.http = http;
    }

    /**
     * Gets the bench.
     *
     * @return the bench
     */
    public Boolean getBench() {
        return bench;
    }

    /**
     * Sets the bench.
     *
     * @param bench the new bench
     */
    public void setBench(Boolean bench) {
        this.bench = bench;
    }

    /**
     * Gets the zmq.
     *
     * @return the zmq
     */
    public Boolean getZmq() {
        return zmq;
    }

    /**
     * Sets the zmq.
     *
     * @param zmq the new zmq
     */
    public void setZmq(Boolean zmq) {
        this.zmq = zmq;
    }

    /**
     * Gets the db.
     *
     * @return the db
     */
    public Boolean getDb() {
        return db;
    }

    /**
     * Sets the db.
     *
     * @param db the new db
     */
    public void setDb(Boolean db) {
        this.db = db;
    }

    /**
     * Gets the rpc.
     *
     * @return the rpc
     */
    public Boolean getRpc() {
        return rpc;
    }

    /**
     * Sets the rpc.
     *
     * @param rpc the new rpc
     */
    public void setRpc(Boolean rpc) {
        this.rpc = rpc;
    }

    /**
     * Gets the estimatefee.
     *
     * @return the estimatefee
     */
    public Boolean getEstimatefee() {
        return estimatefee;
    }

    /**
     * Sets the estimatefee.
     *
     * @param estimatefee the new estimatefee
     */
    public void setEstimatefee(Boolean estimatefee) {
        this.estimatefee = estimatefee;
    }

    /**
     * Gets the addrman.
     *
     * @return the addrman
     */
    public Boolean getAddrman() {
        return addrman;
    }

    /**
     * Sets the addrman.
     *
     * @param addrman the new addrman
     */
    public void setAddrman(Boolean addrman) {
        this.addrman = addrman;
    }

    /**
     * Gets the selectcoins.
     *
     * @return the selectcoins
     */
    public Boolean getSelectcoins() {
        return selectcoins;
    }

    /**
     * Sets the selectcoins.
     *
     * @param selectcoins the new selectcoins
     */
    public void setSelectcoins(Boolean selectcoins) {
        this.selectcoins = selectcoins;
    }

    /**
     * Gets the reindex.
     *
     * @return the reindex
     */
    public Boolean getReindex() {
        return reindex;
    }

    /**
     * Sets the reindex.
     *
     * @param reindex the new reindex
     */
    public void setReindex(Boolean reindex) {
        this.reindex = reindex;
    }

    /**
     * Gets the cmpctblock.
     *
     * @return the cmpctblock
     */
    public Boolean getCmpctblock() {
        return cmpctblock;
    }

    /**
     * Sets the cmpctblock.
     *
     * @param cmpctblock the new cmpctblock
     */
    public void setCmpctblock(Boolean cmpctblock) {
        this.cmpctblock = cmpctblock;
    }

    /**
     * Gets the rand.
     *
     * @return the rand
     */
    public Boolean getRand() {
        return rand;
    }

    /**
     * Sets the rand.
     *
     * @param rand the new rand
     */
    public void setRand(Boolean rand) {
        this.rand = rand;
    }

    /**
     * Gets the prune.
     *
     * @return the prune
     */
    public Boolean getPrune() {
        return prune;
    }

    /**
     * Sets the prune.
     *
     * @param prune the new prune
     */
    public void setPrune(Boolean prune) {
        this.prune = prune;
    }

    /**
     * Gets the proxy.
     *
     * @return the proxy
     */
    public Boolean getProxy() {
        return proxy;
    }

    /**
     * Sets the proxy.
     *
     * @param proxy the new proxy
     */
    public void setProxy(Boolean proxy) {
        this.proxy = proxy;
    }

    /**
     * Gets the mempoolrej.
     *
     * @return the mempoolrej
     */
    public Boolean getMempoolrej() {
        return mempoolrej;
    }

    /**
     * Sets the mempoolrej.
     *
     * @param mempoolrej the new mempoolrej
     */
    public void setMempoolrej(Boolean mempoolrej) {
        this.mempoolrej = mempoolrej;
    }

    /**
     * Gets the libevent.
     *
     * @return the libevent
     */
    public Boolean getLibevent() {
        return libevent;
    }

    /**
     * Sets the libevent.
     *
     * @param libevent the new libevent
     */
    public void setLibevent(Boolean libevent) {
        this.libevent = libevent;
    }

    /**
     * Gets the coindb.
     *
     * @return the coindb
     */
    public Boolean getCoindb() {
        return coindb;
    }

    /**
     * Sets the coindb.
     *
     * @param coindb the new coindb
     */
    public void setCoindb(Boolean coindb) {
        this.coindb = coindb;
    }

    /**
     * Gets the qt.
     *
     * @return the qt
     */
    public Boolean getQt() {
        return qt;
    }

    /**
     * Sets the qt.
     *
     * @param qt the new qt
     */
    public void setQt(Boolean qt) {
        this.qt = qt;
    }

    /**
     * Gets the leveldb.
     *
     * @return the leveldb
     */
    public Boolean getLeveldb() {
        return leveldb;
    }

    /**
     * Sets the leveldb.
     *
     * @param leveldb the new leveldb
     */
    public void setLeveldb(Boolean leveldb) {
        this.leveldb = leveldb;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcLoggingResponse [net=" + net + ", tor=" + tor + ", mempool=" + mempool + ", http=" + http + ", bench=" + bench + ", zmq=" + zmq
                + ", db=" + db + ", rpc=" + rpc + ", estimatefee=" + estimatefee + ", addrman=" + addrman + ", selectcoins=" + selectcoins
                + ", reindex=" + reindex + ", cmpctblock=" + cmpctblock + ", rand=" + rand + ", prune=" + prune + ", proxy=" + proxy + ", mempoolrej="
                + mempoolrej + ", libevent=" + libevent + ", coindb=" + coindb + ", qt=" + qt + ", leveldb=" + leveldb + "]";
    }

}
