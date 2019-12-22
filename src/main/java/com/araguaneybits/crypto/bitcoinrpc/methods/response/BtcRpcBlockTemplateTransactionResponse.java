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
import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jestevez
 */
public class BtcRpcBlockTemplateTransactionResponse implements Serializable {

    private static final long serialVersionUID = 9008400018378120287L;
    @JsonProperty("data")
    private String data;
    @JsonProperty("txid")
    private String txid;
    @JsonProperty("hash")
    private String hash;
    @JsonProperty("depends")
    private List<Object> depends;
    @JsonProperty("fee")
    private BigInteger fee;
    @JsonProperty("sigops")
    private BigInteger sigops;
    @JsonProperty("weight")
    private BigInteger weight;

    public BtcRpcBlockTemplateTransactionResponse() {
        super();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public List<Object> getDepends() {
        return depends;
    }

    public void setDepends(List<Object> depends) {
        this.depends = depends;
    }

    public BigInteger getFee() {
        return fee;
    }

    public void setFee(BigInteger fee) {
        this.fee = fee;
    }

    public BigInteger getSigops() {
        return sigops;
    }

    public void setSigops(BigInteger sigops) {
        this.sigops = sigops;
    }

    public BigInteger getWeight() {
        return weight;
    }

    public void setWeight(BigInteger weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "BtcRpcBlockTemplateTransactionResponse [data=" + data + ", txid=" + txid + ", hash=" + hash + ", depends=" + depends + ", fee=" + fee
                + ", sigops=" + sigops + ", weight=" + weight + "]";
    }

}
