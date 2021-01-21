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
 * The Class BtcRpcGetBlockTxResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcGetBlockTxResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -413757407410836330L;

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
    private List<BtcRpcGetBlockVinResponse> vin;

    /** The vout. */
    @JsonProperty("vout")
    private List<BtcRpcGetBlockVoutResponse> vout;

    /** The hex. */
    @JsonProperty("hex")
    private String hex;

}
