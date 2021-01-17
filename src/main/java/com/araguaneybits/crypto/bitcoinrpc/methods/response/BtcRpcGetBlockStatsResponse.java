/*
 * Copyright 2020 AraguaneyBits.com
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
import java.math.BigInteger;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtcRpcGetBlockStatsResponse implements Serializable {

    private static final long serialVersionUID = 1365648221180500145L;

    @JsonProperty("avgfee")
    private BigDecimal avgfee;
    @JsonProperty("avgfeerate")
    private BigDecimal avgfeerate;
    @JsonProperty("avgtxsize")
    private BigDecimal avgtxsize;
    @JsonProperty("blockhash")
    private String blockhash;
    @JsonProperty("feerate_percentiles")
    private BigDecimal[] feeratePercentiles;
    @JsonProperty("height")
    private Long height;
    @JsonProperty("ins")
    private BigDecimal ins;
    @JsonProperty("maxfee")
    private BigDecimal maxfee;
    @JsonProperty("maxfeerate")
    private BigDecimal maxfeerate;
    @JsonProperty("maxtxsize")
    private BigDecimal maxtxsize;
    @JsonProperty("medianfee")
    private BigDecimal medianfee;
    @JsonProperty("mediantime")
    private Long mediantime;
    @JsonProperty("mediantxsize")
    private BigDecimal mediantxsize;
    @JsonProperty("minfee")
    private BigDecimal minfee;
    @JsonProperty("minfeerate")
    private BigDecimal minfeerate;
    @JsonProperty("mintxsize")
    private BigDecimal mintxsize;
    @JsonProperty("outs")
    private Long outs;
    @JsonProperty("subsidy")
    private BigInteger subsidy;
    @JsonProperty("swtotal_size")
    private BigDecimal swtotalSize;
    @JsonProperty("swtotal_weight")
    private BigDecimal swtotalWeight;
    @JsonProperty("swtxs")
    private BigDecimal swtxs;
    @JsonProperty("time")
    private Long time;
    @JsonProperty("total_out")
    private Long totalOut;
    @JsonProperty("total_size")
    private Long totalSize;
    @JsonProperty("total_weight")
    private Long totalWeight;
    @JsonProperty("totalfee")
    private BigDecimal totalfee;
    @JsonProperty("txs")
    private Long txs;
    @JsonProperty("utxo_increase")
    private Long utxoIncrease;
    @JsonProperty("utxo_size_inc")
    private Long utxoSizeInc;

    public BtcRpcGetBlockStatsResponse() {
        super();
    }

    public BigDecimal getAvgfee() {
        return avgfee;
    }

    public void setAvgfee(BigDecimal avgfee) {
        this.avgfee = avgfee;
    }

    public BigDecimal getAvgfeerate() {
        return avgfeerate;
    }

    public void setAvgfeerate(BigDecimal avgfeerate) {
        this.avgfeerate = avgfeerate;
    }

    public BigDecimal getAvgtxsize() {
        return avgtxsize;
    }

    public void setAvgtxsize(BigDecimal avgtxsize) {
        this.avgtxsize = avgtxsize;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public BigDecimal[] getFeeratePercentiles() {
        return feeratePercentiles;
    }

    public void setFeeratePercentiles(BigDecimal[] feeratePercentiles) {
        this.feeratePercentiles = feeratePercentiles;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public BigDecimal getIns() {
        return ins;
    }

    public void setIns(BigDecimal ins) {
        this.ins = ins;
    }

    public BigDecimal getMaxfee() {
        return maxfee;
    }

    public void setMaxfee(BigDecimal maxfee) {
        this.maxfee = maxfee;
    }

    public BigDecimal getMaxfeerate() {
        return maxfeerate;
    }

    public void setMaxfeerate(BigDecimal maxfeerate) {
        this.maxfeerate = maxfeerate;
    }

    public BigDecimal getMaxtxsize() {
        return maxtxsize;
    }

    public void setMaxtxsize(BigDecimal maxtxsize) {
        this.maxtxsize = maxtxsize;
    }

    public BigDecimal getMedianfee() {
        return medianfee;
    }

    public void setMedianfee(BigDecimal medianfee) {
        this.medianfee = medianfee;
    }

    public Long getMediantime() {
        return mediantime;
    }

    public void setMediantime(Long mediantime) {
        this.mediantime = mediantime;
    }

    public BigDecimal getMediantxsize() {
        return mediantxsize;
    }

    public void setMediantxsize(BigDecimal mediantxsize) {
        this.mediantxsize = mediantxsize;
    }

    public BigDecimal getMinfee() {
        return minfee;
    }

    public void setMinfee(BigDecimal minfee) {
        this.minfee = minfee;
    }

    public BigDecimal getMinfeerate() {
        return minfeerate;
    }

    public void setMinfeerate(BigDecimal minfeerate) {
        this.minfeerate = minfeerate;
    }

    public BigDecimal getMintxsize() {
        return mintxsize;
    }

    public void setMintxsize(BigDecimal mintxsize) {
        this.mintxsize = mintxsize;
    }

    public Long getOuts() {
        return outs;
    }

    public void setOuts(Long outs) {
        this.outs = outs;
    }

    public BigInteger getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(BigInteger subsidy) {
        this.subsidy = subsidy;
    }

    public BigDecimal getSwtotalSize() {
        return swtotalSize;
    }

    public void setSwtotalSize(BigDecimal swtotalSize) {
        this.swtotalSize = swtotalSize;
    }

    public BigDecimal getSwtotalWeight() {
        return swtotalWeight;
    }

    public void setSwtotalWeight(BigDecimal swtotalWeight) {
        this.swtotalWeight = swtotalWeight;
    }

    public BigDecimal getSwtxs() {
        return swtxs;
    }

    public void setSwtxs(BigDecimal swtxs) {
        this.swtxs = swtxs;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getTotalOut() {
        return totalOut;
    }

    public void setTotalOut(Long totalOut) {
        this.totalOut = totalOut;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Long getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Long totalWeight) {
        this.totalWeight = totalWeight;
    }

    public BigDecimal getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(BigDecimal totalfee) {
        this.totalfee = totalfee;
    }

    public Long getTxs() {
        return txs;
    }

    public void setTxs(Long txs) {
        this.txs = txs;
    }

    public Long getUtxoIncrease() {
        return utxoIncrease;
    }

    public void setUtxoIncrease(Long utxoIncrease) {
        this.utxoIncrease = utxoIncrease;
    }

    public Long getUtxoSizeInc() {
        return utxoSizeInc;
    }

    public void setUtxoSizeInc(Long utxoSizeInc) {
        this.utxoSizeInc = utxoSizeInc;
    }

    @Override
    public String toString() {
        return "BtcRpcGetBlockStatsResponse [avgfee=" + avgfee + ", avgfeerate=" + avgfeerate + ", avgtxsize=" + avgtxsize + ", blockhash="
                + blockhash + ", feeratePercentiles=" + Arrays.toString(feeratePercentiles) + ", height=" + height + ", ins=" + ins + ", maxfee="
                + maxfee + ", maxfeerate=" + maxfeerate + ", maxtxsize=" + maxtxsize + ", medianfee=" + medianfee + ", mediantime=" + mediantime
                + ", mediantxsize=" + mediantxsize + ", minfee=" + minfee + ", minfeerate=" + minfeerate + ", mintxsize=" + mintxsize + ", outs="
                + outs + ", subsidy=" + subsidy + ", swtotalSize=" + swtotalSize + ", swtotalWeight=" + swtotalWeight + ", swtxs=" + swtxs + ", time="
                + time + ", totalOut=" + totalOut + ", totalSize=" + totalSize + ", totalWeight=" + totalWeight + ", totalfee=" + totalfee + ", txs="
                + txs + ", utxoIncrease=" + utxoIncrease + ", utxoSizeInc=" + utxoSizeInc + "]";
    }

}
