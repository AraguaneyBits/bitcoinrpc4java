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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcGetWalletInfoResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetWalletInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1215738318491212483L;

    /** The walletname. */
    @JsonProperty("walletname")
    private String walletname;

    /** The walletversion. */
    @JsonProperty("walletversion")
    private Long walletversion;

    /** The balance. */
    @JsonProperty("balance")
    private BigDecimal balance;

    /** The unconfirmed balance. */
    @JsonProperty("unconfirmed_balance")
    private BigDecimal unconfirmedBalance;

    /** The immature balance. */
    @JsonProperty("immature_balance")
    private BigDecimal immatureBalance;

    /** The txcount. */
    @JsonProperty("txcount")
    private Long txcount;

    /** The keypoololdest. */
    @JsonProperty("keypoololdest")
    private Long keypoololdest;

    /** The keypoolsize. */
    @JsonProperty("keypoolsize")
    private Long keypoolsize;

    /** The keypoolsize hd internal. */
    @JsonProperty("keypoolsize_hd_internal")
    private Long keypoolsizeHdInternal;

    /** The unlocked until. */
    @JsonProperty("unlocked_until")
    private Long unlockedUntil;

    /** The paytxfee. */
    @JsonProperty("paytxfee")
    private BigDecimal paytxfee;

    /** The hdseedid. */
    @JsonProperty("hdseedid")
    private String hdseedid;

    /** The private keys enabled. */
    @JsonProperty("private_keys_enabled")
    private Boolean privateKeysEnabled;

    /**
     * Instantiates a new btc rpc get wallet info response.
     */
    public BtcRpcGetWalletInfoResponse() {
        super();
    }

    /**
     * Gets the walletname.
     *
     * @return the walletname
     */
    public String getWalletname() {
        return walletname;
    }

    /**
     * Sets the walletname.
     *
     * @param walletname the new walletname
     */
    public void setWalletname(String walletname) {
        this.walletname = walletname;
    }

    /**
     * Gets the walletversion.
     *
     * @return the walletversion
     */
    public Long getWalletversion() {
        return walletversion;
    }

    /**
     * Sets the walletversion.
     *
     * @param walletversion the new walletversion
     */
    public void setWalletversion(Long walletversion) {
        this.walletversion = walletversion;
    }

    /**
     * Gets the balance.
     *
     * @return the balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Sets the balance.
     *
     * @param balance the new balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Gets the unconfirmed balance.
     *
     * @return the unconfirmed balance
     */
    public BigDecimal getUnconfirmedBalance() {
        return unconfirmedBalance;
    }

    /**
     * Sets the unconfirmed balance.
     *
     * @param unconfirmedBalance the new unconfirmed balance
     */
    public void setUnconfirmedBalance(BigDecimal unconfirmedBalance) {
        this.unconfirmedBalance = unconfirmedBalance;
    }

    /**
     * Gets the immature balance.
     *
     * @return the immature balance
     */
    public BigDecimal getImmatureBalance() {
        return immatureBalance;
    }

    /**
     * Sets the immature balance.
     *
     * @param immatureBalance the new immature balance
     */
    public void setImmatureBalance(BigDecimal immatureBalance) {
        this.immatureBalance = immatureBalance;
    }

    /**
     * Gets the txcount.
     *
     * @return the txcount
     */
    public Long getTxcount() {
        return txcount;
    }

    /**
     * Sets the txcount.
     *
     * @param txcount the new txcount
     */
    public void setTxcount(Long txcount) {
        this.txcount = txcount;
    }

    /**
     * Gets the keypoololdest.
     *
     * @return the keypoololdest
     */
    public Long getKeypoololdest() {
        return keypoololdest;
    }

    /**
     * Sets the keypoololdest.
     *
     * @param keypoololdest the new keypoololdest
     */
    public void setKeypoololdest(Long keypoololdest) {
        this.keypoololdest = keypoololdest;
    }

    /**
     * Gets the keypoolsize.
     *
     * @return the keypoolsize
     */
    public Long getKeypoolsize() {
        return keypoolsize;
    }

    /**
     * Sets the keypoolsize.
     *
     * @param keypoolsize the new keypoolsize
     */
    public void setKeypoolsize(Long keypoolsize) {
        this.keypoolsize = keypoolsize;
    }

    /**
     * Gets the keypoolsize hd internal.
     *
     * @return the keypoolsize hd internal
     */
    public Long getKeypoolsizeHdInternal() {
        return keypoolsizeHdInternal;
    }

    /**
     * Sets the keypoolsize hd internal.
     *
     * @param keypoolsizeHdInternal the new keypoolsize hd internal
     */
    public void setKeypoolsizeHdInternal(Long keypoolsizeHdInternal) {
        this.keypoolsizeHdInternal = keypoolsizeHdInternal;
    }

    /**
     * Gets the unlocked until.
     *
     * @return the unlocked until
     */
    public Long getUnlockedUntil() {
        return unlockedUntil;
    }

    /**
     * Sets the unlocked until.
     *
     * @param unlockedUntil the new unlocked until
     */
    public void setUnlockedUntil(Long unlockedUntil) {
        this.unlockedUntil = unlockedUntil;
    }

    /**
     * Gets the paytxfee.
     *
     * @return the paytxfee
     */
    public BigDecimal getPaytxfee() {
        return paytxfee;
    }

    /**
     * Sets the paytxfee.
     *
     * @param paytxfee the new paytxfee
     */
    public void setPaytxfee(BigDecimal paytxfee) {
        this.paytxfee = paytxfee;
    }

    /**
     * Gets the hdseedid.
     *
     * @return the hdseedid
     */
    public String getHdseedid() {
        return hdseedid;
    }

    /**
     * Sets the hdseedid.
     *
     * @param hdseedid the new hdseedid
     */
    public void setHdseedid(String hdseedid) {
        this.hdseedid = hdseedid;
    }

    /**
     * Gets the private keys enabled.
     *
     * @return the private keys enabled
     */
    public Boolean getPrivateKeysEnabled() {
        return privateKeysEnabled;
    }

    /**
     * Sets the private keys enabled.
     *
     * @param privateKeysEnabled the new private keys enabled
     */
    public void setPrivateKeysEnabled(Boolean privateKeysEnabled) {
        this.privateKeysEnabled = privateKeysEnabled;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetWalletInfoResponse [walletname=" + walletname + ", walletversion=" + walletversion + ", balance=" + balance
                + ", unconfirmedBalance=" + unconfirmedBalance + ", immatureBalance=" + immatureBalance + ", txcount=" + txcount + ", keypoololdest="
                + keypoololdest + ", keypoolsize=" + keypoolsize + ", keypoolsizeHdInternal=" + keypoolsizeHdInternal + ", unlockedUntil="
                + unlockedUntil + ", paytxfee=" + paytxfee + ", hdseedid=" + hdseedid + ", privateKeysEnabled=" + privateKeysEnabled + "]";
    }

}