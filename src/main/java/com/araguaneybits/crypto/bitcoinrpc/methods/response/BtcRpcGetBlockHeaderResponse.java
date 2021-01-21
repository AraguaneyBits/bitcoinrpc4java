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
 * The Class BtcRpcGetBlockHeaderResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcGetBlockHeaderResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 592959046742824701L;

    /** The hash. */
    @JsonProperty("hash")
    private String hash;

    /** The confirmations. */
    @JsonProperty("confirmations")
    private Long confirmations;

    /** The height. */
    @JsonProperty("height")
    private Long height;

    /** The version. */
    @JsonProperty("version")
    private Long version;

    /** The version hex. */
    @JsonProperty("versionHex")
    private String versionHex;

    /** The merkleroot. */
    @JsonProperty("merkleroot")
    private String merkleroot;

    /** The time. */
    @JsonProperty("time")
    private Long time;

    /** The mediantime. */
    @JsonProperty("mediantime")
    private Long mediantime;

    /** The nonce. */
    @JsonProperty("nonce")
    private Long nonce;

    /** The bits. */
    @JsonProperty("bits")
    private String bits;

    /** The difficulty. */
    @JsonProperty("difficulty")
    private Double difficulty;

    /** The chainwork. */
    @JsonProperty("chainwork")
    private String chainwork;

    /** The n tx. */
    @JsonProperty("nTx")
    private Long nTx;

    /** The nextblockhash. */
    @JsonProperty("nextblockhash")
    private String nextblockhash;

}
