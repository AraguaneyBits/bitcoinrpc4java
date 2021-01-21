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
 * The Class BtcRpcGetPeerInfoBytesRecvPerMsgResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcGetPeerInfoBytesRecvPerMsgResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5747540521026712996L;

    /** The addr. */
    @JsonProperty("addr")
    private Long addr;

    /** The block. */
    @JsonProperty("block")
    private Long block;

    /** The cmpctblock. */
    @JsonProperty("cmpctblock")
    private Long cmpctblock;

    /** The feefilter. */
    @JsonProperty("feefilter")
    private Long feefilter;

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

    /** The notfound. */
    @JsonProperty("notfound")
    private Long notfound;

    /** The blocktxn. */
    @JsonProperty("blocktxn")
    private Long blocktxn;

}
