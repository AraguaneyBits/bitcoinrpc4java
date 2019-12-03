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
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcGetAddedNodeInfoResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetAddedNodeInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1268958962522924603L;

    /** The addednode. */
    @JsonProperty("addednode")
    private String addednode;

    /** The connected. */
    @JsonProperty("connected")
    private Boolean connected;

    /** The addresses. */
    @JsonProperty("addresses")
    private List<BtcRpcGetAddedNodeInfoAddressResponse> addresses;

    /**
     * Instantiates a new btc rpc get added node info response.
     */
    public BtcRpcGetAddedNodeInfoResponse() {
        super();
    }

    /**
     * Gets the addednode.
     *
     * @return the addednode
     */
    public String getAddednode() {
        return addednode;
    }

    /**
     * Sets the addednode.
     *
     * @param addednode the new addednode
     */
    public void setAddednode(String addednode) {
        this.addednode = addednode;
    }

    /**
     * Gets the connected.
     *
     * @return the connected
     */
    public Boolean getConnected() {
        return connected;
    }

    /**
     * Sets the connected.
     *
     * @param connected the new connected
     */
    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    /**
     * Gets the addresses.
     *
     * @return the addresses
     */
    public List<BtcRpcGetAddedNodeInfoAddressResponse> getAddresses() {
        return addresses;
    }

    /**
     * Sets the addresses.
     *
     * @param addresses the new addresses
     */
    public void setAddresses(List<BtcRpcGetAddedNodeInfoAddressResponse> addresses) {
        this.addresses = addresses;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetAddedNodeInfoResponse [addednode=" + addednode + ", connected=" + connected + ", addresses=" + addresses + "]";
    }

}
