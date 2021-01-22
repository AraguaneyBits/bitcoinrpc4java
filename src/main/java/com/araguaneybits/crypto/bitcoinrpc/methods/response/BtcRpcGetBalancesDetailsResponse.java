/*
 * @(#)BtcRpcGetBalancesDetailsResponse 1.0 21/01/2021
 *
 * Copyright (c)2021 Soluciones Tricore C.A. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Soluciones Tricore C.A. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Soluciones Tricore C.A.
 */

package com.araguaneybits.crypto.bitcoinrpc.methods.response;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase <code>BtcRpcGetBalancesDetailsResponse</code>.
 *
 * @author jestevez
 * @version 1.0 21/01/2021
 */
@Data
@NoArgsConstructor
public class BtcRpcGetBalancesDetailsResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8238542756862156640L;

    /** The trusted. */
    @JsonProperty("trusted")
    private BigDecimal trusted;

    /** The untrusted pending. */
    @JsonProperty("untrusted_pending")
    private BigDecimal untrustedPending;

    /** The immature. */
    @JsonProperty("immature")
    private BigDecimal immature;

    /** The used. */
    @JsonProperty("used")
    private BigDecimal used;
}
