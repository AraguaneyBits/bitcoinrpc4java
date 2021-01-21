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
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BtcRpcGetMiningInfoResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcGetMiningInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1498835821001164839L;

    /** The blocks. */
    @JsonProperty("blocks")
    private BigInteger blocks;

    /** The currentblockweight. */
    @JsonProperty("currentblockweight")
    private BigInteger currentblockweight;

    /** The currentblocktx. */
    @JsonProperty("currentblocktx")
    private BigInteger currentblocktx;

    /** The difficulty. */
    @JsonProperty("difficulty")
    private BigInteger difficulty;

    /** The networkhashps. */
    @JsonProperty("networkhashps")
    private BigDecimal networkhashps;

    /** The pooledtx. */
    @JsonProperty("pooledtx")
    private BigInteger pooledtx;

    /** The chain. */
    @JsonProperty("chain")
    private String chain;

    /** The warnings. */
    @JsonProperty("warnings")
    private String warnings;

}
