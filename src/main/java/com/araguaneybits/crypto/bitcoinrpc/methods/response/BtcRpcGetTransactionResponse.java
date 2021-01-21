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
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BtcRpcGetTransactionResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcGetTransactionResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1306890086251744110L;

    /** The amount. */
    @JsonProperty("amount")
    private BigDecimal amount;

    /** The fee. */
    @JsonProperty("fee")
    private BigDecimal fee;

    /** The confirmations. */
    @JsonProperty("confirmations")
    private Long confirmations;

    /** The trusted. */
    @JsonProperty("trusted")
    private Boolean trusted;

    /** The txid. */
    @JsonProperty("txid")
    private String txid;

    /** The walletconflicts. */
    @JsonProperty("walletconflicts")
    private List<String> walletconflicts;

    /** The time. */
    @JsonProperty("time")
    private Long time;

    /** The timereceived. */
    @JsonProperty("timereceived")
    private Long timereceived;

    /** The bip 125 replaceable. */
    @JsonProperty("bip125-replaceable")
    private String bip125Replaceable;

    /** The details. */
    @JsonProperty("details")
    private List<BtcRpcGetTransactionDetailResponse> details;

    /** The hex. */
    @JsonProperty("hex")
    private String hex;

    /** The comment. */
    @JsonProperty("comment")
    private String comment;

    /** The replaces txid. */
    @JsonProperty("replaces_txid")
    private String replacesTxid;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The category. */
    @JsonProperty("category")
    private String category;

    /** The label. */
    @JsonProperty("label")
    private String label;

    /** The vout. */
    @JsonProperty("vout")
    private Long vout;

    /** The blockhash. */
    @JsonProperty("blockhash")
    private String blockhash;

    /** The blockindex. */
    @JsonProperty("blockindex")
    private Long blockindex;

    /** The blocktime. */
    @JsonProperty("blocktime")
    private Long blocktime;

}
