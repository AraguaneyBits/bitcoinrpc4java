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

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BtcRpcGetInfoResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcGetInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7815276594313502245L;

    /** The version. */
    private Long version;

    /** The protocolversion. */
    private Long protocolversion;

    /** The walletversion. */
    private Long walletversion;

    /** The balance. */
    private BigDecimal balance;

    /** The privatesend balance. */
    private BigDecimal privatesendBalance;

    /** The blocks. */
    private Long blocks;

    /** The timeoffset. */
    private Long timeoffset;

    /** The connections. */
    private Long connections;

    /** The proxy. */
    private String proxy;

    /** The difficulty. */
    private BigDecimal difficulty;

    /** The testnet. */
    private Boolean testnet;

    /** The keypoololdest. */
    private Long keypoololdest;

    /** The keypoolsize. */
    private Long keypoolsize;

    /** The unlocked until. */
    private Long unlockedUntil;

    /** The paytxfee. */
    private BigDecimal paytxfee;

    /** The relayfee. */
    private BigDecimal relayfee;

    /** The errors. */
    private String errors;

}
