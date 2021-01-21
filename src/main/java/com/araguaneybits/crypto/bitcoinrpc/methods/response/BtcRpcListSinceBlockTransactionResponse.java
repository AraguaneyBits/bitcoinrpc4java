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
 * The Class BtcRpcListSinceBlockTransactionResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcListSinceBlockTransactionResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -697353182390561970L;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The category. */
    @JsonProperty("category")
    private String category;

    /** The amount. */
    @JsonProperty("amount")
    private Double amount;

    /** The vout. */
    @JsonProperty("vout")
    private Integer vout;

    /** The fee. */
    @JsonProperty("fee")
    private Double fee;

    /** The confirmations. */
    @JsonProperty("confirmations")
    private Integer confirmations;

    /** The blockhash. */
    @JsonProperty("blockhash")
    private String blockhash;

    /** The blockindex. */
    @JsonProperty("blockindex")
    private Integer blockindex;

    /** The blocktime. */
    @JsonProperty("blocktime")
    private Integer blocktime;

    /** The txid. */
    @JsonProperty("txid")
    private String txid;

    /** The walletconflicts. */
    @JsonProperty("walletconflicts")
    private List<Object> walletconflicts;

    /** The time. */
    @JsonProperty("time")
    private Integer time;

    /** The timereceived. */
    @JsonProperty("timereceived")
    private Integer timereceived;

    /** The bip 125 replaceable. */
    @JsonProperty("bip125-replaceable")
    private String bip125Replaceable;

    /** The comment. */
    @JsonProperty("comment")
    private String comment;

    /** The to. */
    @JsonProperty("to")
    private String to;

    /** The abandoned. */
    @JsonProperty("abandoned")
    private Boolean abandoned;

    /** The label. */
    @JsonProperty("label")
    private String label;

}
