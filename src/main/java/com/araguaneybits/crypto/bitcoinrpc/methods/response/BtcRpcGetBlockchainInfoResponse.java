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
 * The Class BtcRpcBlockchainInfoResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcGetBlockchainInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8256008445080805952L;

    /** The chain. */
    @JsonProperty("chain")
    private String chain;

    /** The blocks. */
    @JsonProperty("blocks")
    private Long blocks;

    /** The headers. */
    @JsonProperty("headers")
    private Long headers;

    /** The bestblockhash. */
    @JsonProperty("bestblockhash")
    private String bestblockhash;

    /** The difficulty. */
    @JsonProperty("difficulty")
    private Double difficulty;

    /** The mediantime. */
    @JsonProperty("mediantime")
    private Long mediantime;

    /** The verificationprogress. */
    @JsonProperty("verificationprogress")
    private Long verificationprogress;

    /** The initialblockdownload. */
    @JsonProperty("initialblockdownload")
    private Boolean initialblockdownload;

    /** The chainwork. */
    @JsonProperty("chainwork")
    private String chainwork;

    /** The size on disk. */
    @JsonProperty("size_on_disk")
    private Long sizeOnDisk;

    /** The pruned. */
    @JsonProperty("pruned")
    private Boolean pruned;

    /** The warnings. */
    @JsonProperty("warnings")
    private String warnings;

}
