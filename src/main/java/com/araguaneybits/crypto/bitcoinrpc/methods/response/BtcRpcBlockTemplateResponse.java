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
 * The Class BtcRpcBlockTemplateResponse.
 *
 * @author jestevez
 */
public class BtcRpcBlockTemplateResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3289951172304075510L;

    /** The capabilities. */
    @JsonProperty("capabilities")
    private List<String> capabilities;

    /** The version. */
    @JsonProperty("version")
    private BigInteger version;

    /** The rules. */
    @JsonProperty("rules")
    private List<Object> rules;

    /** The vbavailable. */
    @JsonProperty("vbavailable")
    private Object vbavailable;

    /** The vbrequired. */
    @JsonProperty("vbrequired")
    private BigInteger vbrequired;

    /** The previousblockhash. */
    @JsonProperty("previousblockhash")
    private String previousblockhash;

    /** The transactions. */
    @JsonProperty("transactions")
    private List<BtcRpcBlockTemplateTransactionResponse> transactions;

    /** The coinbaseaux. */
    @JsonProperty("coinbaseaux")
    private BtcRpcBlockTemplateCoinbaseAuxResponse coinbaseaux;

    /** The coinbasevalue. */
    @JsonProperty("coinbasevalue")
    private BigInteger coinbasevalue;

    /** The longpollid. */
    @JsonProperty("longpollid")
    private String longpollid;

    /** The target. */
    @JsonProperty("target")
    private String target;

    /** The mintime. */
    @JsonProperty("mintime")
    private BigInteger mintime;

    /** The mutable. */
    @JsonProperty("mutable")
    private List<String> mutable;

    /** The noncerange. */
    @JsonProperty("noncerange")
    private String noncerange;

    /** The sigoplimit. */
    @JsonProperty("sigoplimit")
    private BigInteger sigoplimit;

    /** The sizelimit. */
    @JsonProperty("sizelimit")
    private BigInteger sizelimit;

    /** The weightlimit. */
    @JsonProperty("weightlimit")
    private BigInteger weightlimit;

    /** The curtime. */
    @JsonProperty("curtime")
    private BigInteger curtime;

    /** The bits. */
    @JsonProperty("bits")
    private String bits;

    /** The height. */
    @JsonProperty("height")
    private BigInteger height;

    /** The default witness commitment. */
    @JsonProperty("default_witness_commitment")
    private String defaultWitnessCommitment;

    /**
     * Instantiates a new btc rpc block template response.
     */
    public BtcRpcBlockTemplateResponse() {
        super();
    }

    /**
     * Gets the capabilities.
     *
     * @return the capabilities
     */
    public List<String> getCapabilities() {
        return capabilities;
    }

    /**
     * Sets the capabilities.
     *
     * @param capabilities the new capabilities
     */
    public void setCapabilities(List<String> capabilities) {
        this.capabilities = capabilities;
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public BigInteger getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version the new version
     */
    public void setVersion(BigInteger version) {
        this.version = version;
    }

    /**
     * Gets the rules.
     *
     * @return the rules
     */
    public List<Object> getRules() {
        return rules;
    }

    /**
     * Sets the rules.
     *
     * @param rules the new rules
     */
    public void setRules(List<Object> rules) {
        this.rules = rules;
    }

    /**
     * Gets the vbavailable.
     *
     * @return the vbavailable
     */
    public Object getVbavailable() {
        return vbavailable;
    }

    /**
     * Sets the vbavailable.
     *
     * @param vbavailable the new vbavailable
     */
    public void setVbavailable(Object vbavailable) {
        this.vbavailable = vbavailable;
    }

    /**
     * Gets the vbrequired.
     *
     * @return the vbrequired
     */
    public BigInteger getVbrequired() {
        return vbrequired;
    }

    /**
     * Sets the vbrequired.
     *
     * @param vbrequired the new vbrequired
     */
    public void setVbrequired(BigInteger vbrequired) {
        this.vbrequired = vbrequired;
    }

    /**
     * Gets the previousblockhash.
     *
     * @return the previousblockhash
     */
    public String getPreviousblockhash() {
        return previousblockhash;
    }

    /**
     * Sets the previousblockhash.
     *
     * @param previousblockhash the new previousblockhash
     */
    public void setPreviousblockhash(String previousblockhash) {
        this.previousblockhash = previousblockhash;
    }

    /**
     * Gets the transactions.
     *
     * @return the transactions
     */
    public List<BtcRpcBlockTemplateTransactionResponse> getTransactions() {
        return transactions;
    }

    /**
     * Sets the transactions.
     *
     * @param transactions the new transactions
     */
    public void setTransactions(List<BtcRpcBlockTemplateTransactionResponse> transactions) {
        this.transactions = transactions;
    }

    /**
     * Gets the coinbaseaux.
     *
     * @return the coinbaseaux
     */
    public BtcRpcBlockTemplateCoinbaseAuxResponse getCoinbaseaux() {
        return coinbaseaux;
    }

    /**
     * Sets the coinbaseaux.
     *
     * @param coinbaseaux the new coinbaseaux
     */
    public void setCoinbaseaux(BtcRpcBlockTemplateCoinbaseAuxResponse coinbaseaux) {
        this.coinbaseaux = coinbaseaux;
    }

    /**
     * Gets the coinbasevalue.
     *
     * @return the coinbasevalue
     */
    public BigInteger getCoinbasevalue() {
        return coinbasevalue;
    }

    /**
     * Sets the coinbasevalue.
     *
     * @param coinbasevalue the new coinbasevalue
     */
    public void setCoinbasevalue(BigInteger coinbasevalue) {
        this.coinbasevalue = coinbasevalue;
    }

    /**
     * Gets the longpollid.
     *
     * @return the longpollid
     */
    public String getLongpollid() {
        return longpollid;
    }

    /**
     * Sets the longpollid.
     *
     * @param longpollid the new longpollid
     */
    public void setLongpollid(String longpollid) {
        this.longpollid = longpollid;
    }

    /**
     * Gets the target.
     *
     * @return the target
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the target.
     *
     * @param target the new target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Gets the mintime.
     *
     * @return the mintime
     */
    public BigInteger getMintime() {
        return mintime;
    }

    /**
     * Sets the mintime.
     *
     * @param mintime the new mintime
     */
    public void setMintime(BigInteger mintime) {
        this.mintime = mintime;
    }

    /**
     * Gets the mutable.
     *
     * @return the mutable
     */
    public List<String> getMutable() {
        return mutable;
    }

    /**
     * Sets the mutable.
     *
     * @param mutable the new mutable
     */
    public void setMutable(List<String> mutable) {
        this.mutable = mutable;
    }

    /**
     * Gets the noncerange.
     *
     * @return the noncerange
     */
    public String getNoncerange() {
        return noncerange;
    }

    /**
     * Sets the noncerange.
     *
     * @param noncerange the new noncerange
     */
    public void setNoncerange(String noncerange) {
        this.noncerange = noncerange;
    }

    /**
     * Gets the sigoplimit.
     *
     * @return the sigoplimit
     */
    public BigInteger getSigoplimit() {
        return sigoplimit;
    }

    /**
     * Sets the sigoplimit.
     *
     * @param sigoplimit the new sigoplimit
     */
    public void setSigoplimit(BigInteger sigoplimit) {
        this.sigoplimit = sigoplimit;
    }

    /**
     * Gets the sizelimit.
     *
     * @return the sizelimit
     */
    public BigInteger getSizelimit() {
        return sizelimit;
    }

    /**
     * Sets the sizelimit.
     *
     * @param sizelimit the new sizelimit
     */
    public void setSizelimit(BigInteger sizelimit) {
        this.sizelimit = sizelimit;
    }

    /**
     * Gets the weightlimit.
     *
     * @return the weightlimit
     */
    public BigInteger getWeightlimit() {
        return weightlimit;
    }

    /**
     * Sets the weightlimit.
     *
     * @param weightlimit the new weightlimit
     */
    public void setWeightlimit(BigInteger weightlimit) {
        this.weightlimit = weightlimit;
    }

    /**
     * Gets the curtime.
     *
     * @return the curtime
     */
    public BigInteger getCurtime() {
        return curtime;
    }

    /**
     * Sets the curtime.
     *
     * @param curtime the new curtime
     */
    public void setCurtime(BigInteger curtime) {
        this.curtime = curtime;
    }

    /**
     * Gets the bits.
     *
     * @return the bits
     */
    public String getBits() {
        return bits;
    }

    /**
     * Sets the bits.
     *
     * @param bits the new bits
     */
    public void setBits(String bits) {
        this.bits = bits;
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public BigInteger getHeight() {
        return height;
    }

    /**
     * Sets the height.
     *
     * @param height the new height
     */
    public void setHeight(BigInteger height) {
        this.height = height;
    }

    /**
     * Gets the default witness commitment.
     *
     * @return the default witness commitment
     */
    public String getDefaultWitnessCommitment() {
        return defaultWitnessCommitment;
    }

    /**
     * Sets the default witness commitment.
     *
     * @param defaultWitnessCommitment the new default witness commitment
     */
    public void setDefaultWitnessCommitment(String defaultWitnessCommitment) {
        this.defaultWitnessCommitment = defaultWitnessCommitment;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcBlockTemplateResponse [capabilities=" + capabilities + ", version=" + version + ", rules=" + rules + ", vbavailable="
                + vbavailable + ", vbrequired=" + vbrequired + ", previousblockhash=" + previousblockhash + ", transactions=" + transactions
                + ", coinbaseaux=" + coinbaseaux + ", coinbasevalue=" + coinbasevalue + ", longpollid=" + longpollid + ", target=" + target
                + ", mintime=" + mintime + ", mutable=" + mutable + ", noncerange=" + noncerange + ", sigoplimit=" + sigoplimit + ", sizelimit="
                + sizelimit + ", weightlimit=" + weightlimit + ", curtime=" + curtime + ", bits=" + bits + ", height=" + height
                + ", defaultWitnessCommitment=" + defaultWitnessCommitment + "]";
    }

}
