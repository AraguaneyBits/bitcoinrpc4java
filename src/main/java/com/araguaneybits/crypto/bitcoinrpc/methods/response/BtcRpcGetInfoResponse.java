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

/**
 * The Class BtcRpcGetInfoResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7815276594313502245L;

    /** The version. */
    private Long version;

    /** The protocolversion. */
    private Long protocolversion;

    /** The walletversion. */
    private Long walletversion;

    /** The balance. */
    private BigDecimal balance;

    /** The privatesend balance. */
    private BigDecimal privatesendBalance;

    /** The blocks. */
    private Long blocks;

    /** The timeoffset. */
    private Long timeoffset;

    /** The connections. */
    private Long connections;

    /** The proxy. */
    private String proxy;

    /** The difficulty. */
    private BigDecimal difficulty;

    /** The testnet. */
    private Boolean testnet;

    /** The keypoololdest. */
    private Long keypoololdest;

    /** The keypoolsize. */
    private Long keypoolsize;

    /** The unlocked until. */
    private Long unlockedUntil;

    /** The paytxfee. */
    private BigDecimal paytxfee;

    /** The relayfee. */
    private BigDecimal relayfee;

    /** The errors. */
    private String errors;

    /**
     * Instantiates a new btc rpc get info response.
     */
    public BtcRpcGetInfoResponse() {
        super();
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version the new version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * Gets the protocolversion.
     *
     * @return the protocolversion
     */
    public Long getProtocolversion() {
        return protocolversion;
    }

    /**
     * Sets the protocolversion.
     *
     * @param protocolversion the new protocolversion
     */
    public void setProtocolversion(Long protocolversion) {
        this.protocolversion = protocolversion;
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
     * Gets the privatesend balance.
     *
     * @return the privatesend balance
     */
    public BigDecimal getPrivatesendBalance() {
        return privatesendBalance;
    }

    /**
     * Sets the privatesend balance.
     *
     * @param privatesendBalance the new privatesend balance
     */
    public void setPrivatesendBalance(BigDecimal privatesendBalance) {
        this.privatesendBalance = privatesendBalance;
    }

    /**
     * Gets the blocks.
     *
     * @return the blocks
     */
    public Long getBlocks() {
        return blocks;
    }

    /**
     * Sets the blocks.
     *
     * @param blocks the new blocks
     */
    public void setBlocks(Long blocks) {
        this.blocks = blocks;
    }

    /**
     * Gets the timeoffset.
     *
     * @return the timeoffset
     */
    public Long getTimeoffset() {
        return timeoffset;
    }

    /**
     * Sets the timeoffset.
     *
     * @param timeoffset the new timeoffset
     */
    public void setTimeoffset(Long timeoffset) {
        this.timeoffset = timeoffset;
    }

    /**
     * Gets the connections.
     *
     * @return the connections
     */
    public Long getConnections() {
        return connections;
    }

    /**
     * Sets the connections.
     *
     * @param connections the new connections
     */
    public void setConnections(Long connections) {
        this.connections = connections;
    }

    /**
     * Gets the proxy.
     *
     * @return the proxy
     */
    public String getProxy() {
        return proxy;
    }

    /**
     * Sets the proxy.
     *
     * @param proxy the new proxy
     */
    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    /**
     * Gets the difficulty.
     *
     * @return the difficulty
     */
    public BigDecimal getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty.
     *
     * @param difficulty the new difficulty
     */
    public void setDifficulty(BigDecimal difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Gets the testnet.
     *
     * @return the testnet
     */
    public Boolean getTestnet() {
        return testnet;
    }

    /**
     * Sets the testnet.
     *
     * @param testnet the new testnet
     */
    public void setTestnet(Boolean testnet) {
        this.testnet = testnet;
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
     * Gets the relayfee.
     *
     * @return the relayfee
     */
    public BigDecimal getRelayfee() {
        return relayfee;
    }

    /**
     * Sets the relayfee.
     *
     * @param relayfee the new relayfee
     */
    public void setRelayfee(BigDecimal relayfee) {
        this.relayfee = relayfee;
    }

    /**
     * Gets the errors.
     *
     * @return the errors
     */
    public String getErrors() {
        return errors;
    }

    /**
     * Sets the errors.
     *
     * @param errors the new errors
     */
    public void setErrors(String errors) {
        this.errors = errors;
    }

}
