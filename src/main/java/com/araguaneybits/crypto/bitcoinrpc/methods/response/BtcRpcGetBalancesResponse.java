/*
 * @(#)BtcRpcGetBalancesResponse 1.0 21/01/2021
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

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase <code>BtcRpcGetBalancesResponse</code>.
 *
 * @author jestevez
 * @version 1.0 21/01/2021
 */
@Data
@NoArgsConstructor
public class BtcRpcGetBalancesResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -143738737676575196L;

    /** The mine. */
    @JsonProperty("mine")
    private BtcRpcGetBalancesDetailsResponse mine;

    /** The watchonly. */
    @JsonProperty("watchonly")
    private BtcRpcGetBalancesDetailsResponse watchonly;
}
