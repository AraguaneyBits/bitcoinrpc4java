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
 * The Class BtcRpcNetworkInfoResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcNetworkInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4697658300612769251L;

    /** The version. */
    @JsonProperty("version")
    private Long version;

    /** The subversion. */
    @JsonProperty("subversion")
    private String subversion;

    /** The protocolversion. */
    @JsonProperty("protocolversion")
    private Long protocolversion;

    /** The localservices. */
    @JsonProperty("localservices")
    private String localservices;

    /** The localrelay. */
    @JsonProperty("localrelay")
    private Boolean localrelay;

    /** The timeoffset. */
    @JsonProperty("timeoffset")
    private Long timeoffset;

    /** The networkactive. */
    @JsonProperty("networkactive")
    private Boolean networkactive;

    /** The connections. */
    @JsonProperty("connections")
    private Long connections;

    /** The networks. */
    @JsonProperty("networks")
    private List<BtcRpcNetworkInfoNetworkResponse> networks;

    /** The relayfee. */
    @JsonProperty("relayfee")
    private Double relayfee;

    /** The incrementalfee. */
    @JsonProperty("incrementalfee")
    private Double incrementalfee;

    /** The localaddresses. */
    @JsonProperty("localaddresses")
    private List<Object> localaddresses;

    /** The warnings. */
    @JsonProperty("warnings")
    private String warnings;

}
