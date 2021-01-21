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

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BtcRpcGetPeerInfoResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
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

}
