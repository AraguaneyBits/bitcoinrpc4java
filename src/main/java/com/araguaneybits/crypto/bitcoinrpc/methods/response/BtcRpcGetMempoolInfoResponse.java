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
 * The Class BtcRpcGetMempoolInfoResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcGetMempoolInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 652864959557283379L;

    /** The size. */
    @JsonProperty("size")
    private BigInteger size;

    /** The bytes. */
    @JsonProperty("bytes")
    private BigInteger bytes;

    /** The usage. */
    @JsonProperty("usage")
    private BigInteger usage;

    /** The maxmempool. */
    @JsonProperty("maxmempool")
    private BigInteger maxmempool;

    /** The mempoolminfee. */
    @JsonProperty("mempoolminfee")
    private BigDecimal mempoolminfee;

    /** The minrelaytxfee. */
    @JsonProperty("minrelaytxfee")
    private BigDecimal minrelaytxfee;

}
