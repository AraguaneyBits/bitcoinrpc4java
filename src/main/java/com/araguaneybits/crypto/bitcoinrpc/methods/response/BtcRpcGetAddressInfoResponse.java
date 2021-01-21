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
 * The Class BtcRpcGetAddressInfoResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcGetAddressInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1323043737066775520L;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The script pub key. */
    @JsonProperty("scriptPubKey")
    private String scriptPubKey;

    /** The ismine. */
    @JsonProperty("ismine")
    private Boolean ismine;

    /** The solvable. */
    @JsonProperty("solvable")
    private Boolean solvable;

    /** The desc. */
    @JsonProperty("desc")
    private String desc;

    /** The iswatchonly. */
    @JsonProperty("iswatchonly")
    private Boolean iswatchonly;

    /** The isscript. */
    @JsonProperty("isscript")
    private Boolean isscript;

    /** The iswitness. */
    @JsonProperty("iswitness")
    private Boolean iswitness;

    /** The script. */
    @JsonProperty("script")
    private String script;

    /** The hex. */
    @JsonProperty("hex")
    private String hex;

    /** The pubkey. */
    @JsonProperty("pubkey")
    private String pubkey;

    /** The embedded. */
    @JsonProperty("embedded")
    private BtcRpcGetAddressInfoEmbeddedResponse embedded;

    /** The label. */
    @JsonProperty("label")
    private String label;

    /** The ischange. */
    @JsonProperty("ischange")
    private Boolean ischange;

    /** The timestamp. */
    @JsonProperty("timestamp")
    private Long timestamp;

    /** The hdkeypath. */
    @JsonProperty("hdkeypath")
    private String hdkeypath;

    /** The hdseedid. */
    @JsonProperty("hdseedid")
    private String hdseedid;

    /** The hdmasterfingerprint. */
    @JsonProperty("hdmasterfingerprint")
    private String hdmasterfingerprint;

    /** The labels. */
    @JsonProperty("labels")
    private List<BtcRpcGetAddressInfoLabelResponse> labels;

}
