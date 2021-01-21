/*
 * Copyright 2020 AraguaneyBits.com
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
import java.math.BigDecimal;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BtcRpcGetBlockStatsResponse.
 */
@Data

@NoArgsConstructor
public class BtcRpcGetBlockStatsResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1365648221180500145L;

    /** The avgfee. */
    @JsonProperty("avgfee")
    private BigDecimal avgfee;

    /** The avgfeerate. */
    @JsonProperty("avgfeerate")
    private BigDecimal avgfeerate;

    /** The avgtxsize. */
    @JsonProperty("avgtxsize")
    private BigDecimal avgtxsize;

    /** The blockhash. */
    @JsonProperty("blockhash")
    private String blockhash;

    /** The feerate percentiles. */
    @JsonProperty("feerate_percentiles")
    private BigDecimal[] feeratePercentiles;

    /** The height. */
    @JsonProperty("height")
    private Long height;

    /** The ins. */
    @JsonProperty("ins")
    private BigDecimal ins;

    /** The maxfee. */
    @JsonProperty("maxfee")
    private BigDecimal maxfee;

    /** The maxfeerate. */
    @JsonProperty("maxfeerate")
    private BigDecimal maxfeerate;

    /** The maxtxsize. */
    @JsonProperty("maxtxsize")
    private BigDecimal maxtxsize;

    /** The medianfee. */
    @JsonProperty("medianfee")
    private BigDecimal medianfee;

    /** The mediantime. */
    @JsonProperty("mediantime")
    private Long mediantime;

    /** The mediantxsize. */
    @JsonProperty("mediantxsize")
    private BigDecimal mediantxsize;

    /** The minfee. */
    @JsonProperty("minfee")
    private BigDecimal minfee;

    /** The minfeerate. */
    @JsonProperty("minfeerate")
    private BigDecimal minfeerate;

    /** The mintxsize. */
    @JsonProperty("mintxsize")
    private BigDecimal mintxsize;

    /** The outs. */
    @JsonProperty("outs")
    private Long outs;

    /** The subsidy. */
    @JsonProperty("subsidy")
    private BigInteger subsidy;

    /** The swtotal size. */
    @JsonProperty("swtotal_size")
    private BigDecimal swtotalSize;

    /** The swtotal weight. */
    @JsonProperty("swtotal_weight")
    private BigDecimal swtotalWeight;

    /** The swtxs. */
    @JsonProperty("swtxs")
    private BigDecimal swtxs;

    /** The time. */
    @JsonProperty("time")
    private Long time;

    /** The total out. */
    @JsonProperty("total_out")
    private Long totalOut;

    /** The total size. */
    @JsonProperty("total_size")
    private Long totalSize;

    /** The total weight. */
    @JsonProperty("total_weight")
    private Long totalWeight;

    /** The totalfee. */
    @JsonProperty("totalfee")
    private BigDecimal totalfee;

    /** The txs. */
    @JsonProperty("txs")
    private Long txs;

    /** The utxo increase. */
    @JsonProperty("utxo_increase")
    private Long utxoIncrease;

    /** The utxo size inc. */
    @JsonProperty("utxo_size_inc")
    private Long utxoSizeInc;

}
