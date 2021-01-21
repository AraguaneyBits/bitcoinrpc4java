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
 * The Class BtcRpcGetWalletInfoResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcGetWalletInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1215738318491212483L;

    /** The walletname. */
    @JsonProperty("walletname")
    private String walletname;

    /** The walletversion. */
    @JsonProperty("walletversion")
    private Long walletversion;

    /** The balance. */
    @JsonProperty("balance")
    private BigDecimal balance;

    /** The unconfirmed balance. */
    @JsonProperty("unconfirmed_balance")
    private BigDecimal unconfirmedBalance;

    /** The immature balance. */
    @JsonProperty("immature_balance")
    private BigDecimal immatureBalance;

    /** The txcount. */
    @JsonProperty("txcount")
    private Long txcount;

    /** The keypoololdest. */
    @JsonProperty("keypoololdest")
    private Long keypoololdest;

    /** The keypoolsize. */
    @JsonProperty("keypoolsize")
    private Long keypoolsize;

    /** The keypoolsize hd internal. */
    @JsonProperty("keypoolsize_hd_internal")
    private Long keypoolsizeHdInternal;

    /** The unlocked until. */
    @JsonProperty("unlocked_until")
    private Long unlockedUntil;

    /** The paytxfee. */
    @JsonProperty("paytxfee")
    private BigDecimal paytxfee;

    /** The hdseedid. */
    @JsonProperty("hdseedid")
    private String hdseedid;

    /** The private keys enabled. */
    @JsonProperty("private_keys_enabled")
    private Boolean privateKeysEnabled;

}
