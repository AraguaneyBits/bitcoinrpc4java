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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcListBannedResponse.
 *
 * @author jestevez
 */
public class BtcRpcListBannedResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9151454840625654184L;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The banned until. */
    @JsonProperty("banned_until")
    private Long bannedUntil;

    /** The ban created. */
    @JsonProperty("ban_created")
    private Long banCreated;

    /** The ban reason. */
    @JsonProperty("ban_reason")
    private String banReason;

    /**
     * Instantiates a new btc rpc list banned response.
     */
    public BtcRpcListBannedResponse() {
        super();
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the banned until.
     *
     * @return the banned until
     */
    public Long getBannedUntil() {
        return bannedUntil;
    }

    /**
     * Sets the banned until.
     *
     * @param bannedUntil the new banned until
     */
    public void setBannedUntil(Long bannedUntil) {
        this.bannedUntil = bannedUntil;
    }

    /**
     * Gets the ban created.
     *
     * @return the ban created
     */
    public Long getBanCreated() {
        return banCreated;
    }

    /**
     * Sets the ban created.
     *
     * @param banCreated the new ban created
     */
    public void setBanCreated(Long banCreated) {
        this.banCreated = banCreated;
    }

    /**
     * Gets the ban reason.
     *
     * @return the ban reason
     */
    public String getBanReason() {
        return banReason;
    }

    /**
     * Sets the ban reason.
     *
     * @param banReason the new ban reason
     */
    public void setBanReason(String banReason) {
        this.banReason = banReason;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcListBannedResponse [address=" + address + ", bannedUntil=" + bannedUntil + ", banCreated=" + banCreated + ", banReason="
                + banReason + "]";
    }

}
