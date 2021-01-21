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
import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BtcRpcBlockTemplateResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcBlockTemplateResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3289951172304075510L;

    /** The capabilities. */
    @JsonProperty("capabilities")
    private List<String> capabilities;

    /** The version. */
    @JsonProperty("version")
    private BigInteger version;

    /** The rules. */
    @JsonProperty("rules")
    private List<Object> rules;

    /** The vbavailable. */
    @JsonProperty("vbavailable")
    private Object vbavailable;

    /** The vbrequired. */
    @JsonProperty("vbrequired")
    private BigInteger vbrequired;

    /** The previousblockhash. */
    @JsonProperty("previousblockhash")
    private String previousblockhash;

    /** The transactions. */
    @JsonProperty("transactions")
    private List<BtcRpcBlockTemplateTransactionResponse> transactions;

    /** The coinbaseaux. */
    @JsonProperty("coinbaseaux")
    private BtcRpcBlockTemplateCoinbaseAuxResponse coinbaseaux;

    /** The coinbasevalue. */
    @JsonProperty("coinbasevalue")
    private BigInteger coinbasevalue;

    /** The longpollid. */
    @JsonProperty("longpollid")
    private String longpollid;

    /** The target. */
    @JsonProperty("target")
    private String target;

    /** The mintime. */
    @JsonProperty("mintime")
    private BigInteger mintime;

    /** The mutable. */
    @JsonProperty("mutable")
    private List<String> mutable;

    /** The noncerange. */
    @JsonProperty("noncerange")
    private String noncerange;

    /** The sigoplimit. */
    @JsonProperty("sigoplimit")
    private BigInteger sigoplimit;

    /** The sizelimit. */
    @JsonProperty("sizelimit")
    private BigInteger sizelimit;

    /** The weightlimit. */
    @JsonProperty("weightlimit")
    private BigInteger weightlimit;

    /** The curtime. */
    @JsonProperty("curtime")
    private BigInteger curtime;

    /** The bits. */
    @JsonProperty("bits")
    private String bits;

    /** The height. */
    @JsonProperty("height")
    private BigInteger height;

    /** The default witness commitment. */
    @JsonProperty("default_witness_commitment")
    private String defaultWitnessCommitment;

}
