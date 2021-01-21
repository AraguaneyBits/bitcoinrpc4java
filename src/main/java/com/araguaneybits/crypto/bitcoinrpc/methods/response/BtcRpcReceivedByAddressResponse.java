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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class ReceivedByAddress.
 *
 * @author Jose Luis Estevez jose.estevez.prieto@gmail.com
 */
@Data
@NoArgsConstructor
public class BtcRpcReceivedByAddressResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3597136519765712835L;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The amount. */
    @JsonProperty("amount")
    private BigDecimal amount;

    /** The confirmations. */
    @JsonProperty("confirmations")
    private Long confirmations;

    /** The label. */
    @JsonProperty("label")
    private String label;

    /** The txids. */
    @JsonProperty("txids")
    private List<String> txids;

    /** The account. */
    @JsonProperty("account")
    private String account;

}
