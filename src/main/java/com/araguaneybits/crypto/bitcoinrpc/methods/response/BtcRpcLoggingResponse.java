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

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BtcRpcLoggingResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
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

}
