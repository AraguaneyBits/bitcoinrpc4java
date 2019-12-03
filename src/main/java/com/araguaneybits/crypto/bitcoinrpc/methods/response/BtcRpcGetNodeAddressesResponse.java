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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class BtcRpcGetNodeAddressesResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetNodeAddressesResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3971192512683488794L;

    /** The time. */
    @JsonProperty("time")
    private BigInteger time;

    /** The services. */
    @JsonProperty("services")
    private BigInteger services;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The port. */
    @JsonProperty("port")
    private BigInteger port;

    /**
     * Instantiates a new btc rpc get node addresses response.
     */
    public BtcRpcGetNodeAddressesResponse() {
        super();
    }

    /**
     * Gets the time.
     *
     * @return the time
     */
    public BigInteger getTime() {
        return time;
    }

    /**
     * Sets the time.
     *
     * @param time the new time
     */
    public void setTime(BigInteger time) {
        this.time = time;
    }

    /**
     * Gets the services.
     *
     * @return the services
     */
    public BigInteger getServices() {
        return services;
    }

    /**
     * Sets the services.
     *
     * @param services the new services
     */
    public void setServices(BigInteger services) {
        this.services = services;
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
     * Gets the port.
     *
     * @return the port
     */
    public BigInteger getPort() {
        return port;
    }

    /**
     * Sets the port.
     *
     * @param port the new port
     */
    public void setPort(BigInteger port) {
        this.port = port;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetNodeAddressesResponse [time=" + time + ", services=" + services + ", address=" + address + ", port=" + port + "]";
    }

}
