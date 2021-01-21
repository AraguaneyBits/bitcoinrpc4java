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
package com.araguaneybits.crypto.bitcoinrpc.methods.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BtcRpcSignRawTransactionWithWalletRequest.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcSignRawTransactionWithWalletRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3230966560244001797L;

    /** The txid. */
    @JsonProperty("txid")
    private String txid;

    /** The vout. */
    @JsonProperty("vout")
    private Long vout;

    /** The script pub key. */
    @JsonProperty("scriptPubKey")
    private String scriptPubKey;

    /** The redeem script. */
    @JsonProperty("redeemScript")
    private String redeemScript;

    /** The witness script. */
    @JsonProperty("witnessScript")
    private String witnessScript;

    /** The amount. */
    @JsonProperty("amount")
    private BigDecimal amount;

}
