package com.araguaneybits.crypto.bitcoinrpc.methods.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcGetBlockVinResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetBlockVinResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5647409151779931473L;

    /** The coinbase. */
    @JsonProperty("coinbase")
    private String coinbase;

    /** The sequence. */
    @JsonProperty("sequence")
    private Long sequence;

    /**
     * Instantiates a new btc rpc get block vin response.
     */
    public BtcRpcGetBlockVinResponse() {
        super();
    }

    /**
     * Gets the coinbase.
     *
     * @return the coinbase
     */
    public String getCoinbase() {
        return coinbase;
    }

    /**
     * Sets the coinbase.
     *
     * @param coinbase the new coinbase
     */
    public void setCoinbase(String coinbase) {
        this.coinbase = coinbase;
    }

    /**
     * Gets the sequence.
     *
     * @return the sequence
     */
    public Long getSequence() {
        return sequence;
    }

    /**
     * Sets the sequence.
     *
     * @param sequence the new sequence
     */
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

}
