package com.araguaneybits.crypto.bitcoinrpc.methods.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BtcRpcGetBlockVinResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcGetBlockVinResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5647409151779931473L;

    /** The coinbase. */
    @JsonProperty("coinbase")
    private String coinbase;

    /** The sequence. */
    @JsonProperty("sequence")
    private Long sequence;

}
