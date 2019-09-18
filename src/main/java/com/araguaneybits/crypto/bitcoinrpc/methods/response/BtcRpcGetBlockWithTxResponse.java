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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcGetBlockWithTxResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetBlockWithTxResponse extends AbstractBtcRpcGetBlockResponse {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2726855790245282652L;

    /** The tx. */
    @JsonProperty("tx")
    private List<BtcRpcGetBlockTxResponse> tx;

    /**
     * Instantiates a new btc rpc get block with tx response.
     */
    public BtcRpcGetBlockWithTxResponse() {
        super();
    }

    /**
     * Gets the tx.
     *
     * @return the tx
     */
    public List<BtcRpcGetBlockTxResponse> getTx() {
        return tx;
    }

    /**
     * Sets the tx.
     *
     * @param tx the new tx
     */
    public void setTx(List<BtcRpcGetBlockTxResponse> tx) {
        this.tx = tx;
    }
}
