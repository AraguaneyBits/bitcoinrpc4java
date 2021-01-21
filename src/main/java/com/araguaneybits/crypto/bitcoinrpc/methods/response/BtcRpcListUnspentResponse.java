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

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BtcRpcListUnspentResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcListUnspentResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4966544181016358093L;

    /** The txid. */
    @JsonProperty("txid")
    private String txid;

    /** The vout. */
    @JsonProperty("vout")
    private Long vout;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The label. */
    @JsonProperty("label")
    private String label;

    /** The script pub key. */
    @JsonProperty("scriptPubKey")
    private String scriptPubKey;

    /** The amount. */
    @JsonProperty("amount")
    private BigDecimal amount;

    /** The confirmations. */
    @JsonProperty("confirmations")
    private Long confirmations;

    /** The spendable. */
    @JsonProperty("spendable")
    private Boolean spendable;

    /** The solvable. */
    @JsonProperty("solvable")
    private Boolean solvable;

    /** The desc. */
    @JsonProperty("desc")
    private String desc;

    /** The safe. */
    @JsonProperty("safe")
    private Boolean safe;

    /** The redeem script. */
    @JsonProperty("redeemScript")
    private String redeemScript;

}
