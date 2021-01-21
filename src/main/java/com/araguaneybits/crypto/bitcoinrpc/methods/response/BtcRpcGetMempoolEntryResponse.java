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
 * The Class BtcRpcGetMempoolEntryResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcGetMempoolEntryResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4247293936687144242L;

    /** The fees. */
    @JsonProperty("fees")
    private BtcRpcGetMempoolEntryFeesResponse fees;

    /** The size. */
    @JsonProperty("size")
    private Long size;

    /** The fee. */
    @JsonProperty("fee")
    private BigDecimal fee;

    /** The modifiedfee. */
    @JsonProperty("modifiedfee")
    private BigDecimal modifiedfee;

    /** The time. */
    @JsonProperty("time")
    private Long time;

    /** The height. */
    @JsonProperty("height")
    private Long height;

    /** The descendantcount. */
    @JsonProperty("descendantcount")
    private Long descendantcount;

    /** The descendantsize. */
    @JsonProperty("descendantsize")
    private Long descendantsize;

    /** The descendantfees. */
    @JsonProperty("descendantfees")
    private Long descendantfees;

    /** The ancestorcount. */
    @JsonProperty("ancestorcount")
    private Long ancestorcount;

    /** The ancestorsize. */
    @JsonProperty("ancestorsize")
    private Long ancestorsize;

    /** The ancestorfees. */
    @JsonProperty("ancestorfees")
    private Long ancestorfees;

    /** The wtxid. */
    @JsonProperty("wtxid")
    private String wtxid;

    /** The depends. */
    @JsonProperty("depends")
    private List<String> depends;

    /** The spentby. */
    @JsonProperty("spentby")
    private List<String> spentby;

    /** The bip 125 replaceable. */
    @JsonProperty("bip125-replaceable")
    private Boolean bip125Replaceable;

}
