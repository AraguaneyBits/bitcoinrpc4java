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
 * The Class BtcRpcNetworkInfoNetworkResponse.
 *
 * @author jestevez
 */
public class BtcRpcNetworkInfoNetworkResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3071273537157357718L;

    /** The name. */
    @JsonProperty("name")
    private String name;

    /** The limited. */
    @JsonProperty("limited")
    private Boolean limited;

    /** The reachable. */
    @JsonProperty("reachable")
    private Boolean reachable;

    /** The proxy. */
    @JsonProperty("proxy")
    private String proxy;

    /** The proxy randomize credentials. */
    @JsonProperty("proxy_randomize_credentials")
    private Boolean proxyRandomizeCredentials;

    /**
     * Instantiates a new btc rpc network info network response.
     */
    public BtcRpcNetworkInfoNetworkResponse() {
        super();
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the limited.
     *
     * @return the limited
     */
    public Boolean getLimited() {
        return limited;
    }

    /**
     * Sets the limited.
     *
     * @param limited the new limited
     */
    public void setLimited(Boolean limited) {
        this.limited = limited;
    }

    /**
     * Gets the reachable.
     *
     * @return the reachable
     */
    public Boolean getReachable() {
        return reachable;
    }

    /**
     * Sets the reachable.
     *
     * @param reachable the new reachable
     */
    public void setReachable(Boolean reachable) {
        this.reachable = reachable;
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
     * Gets the proxy randomize credentials.
     *
     * @return the proxy randomize credentials
     */
    public Boolean getProxyRandomizeCredentials() {
        return proxyRandomizeCredentials;
    }

    /**
     * Sets the proxy randomize credentials.
     *
     * @param proxyRandomizeCredentials the new proxy randomize credentials
     */
    public void setProxyRandomizeCredentials(Boolean proxyRandomizeCredentials) {
        this.proxyRandomizeCredentials = proxyRandomizeCredentials;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcNetworkInfoNetworkResponse [name=" + name + ", limited=" + limited + ", reachable=" + reachable + ", proxy=" + proxy
                + ", proxyRandomizeCredentials=" + proxyRandomizeCredentials + "]";
    }

}
