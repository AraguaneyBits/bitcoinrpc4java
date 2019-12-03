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
 * The Class BtcRpcNetworkInfoResponse.
 *
 * @author jestevez
 */
public class BtcRpcNetworkInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4697658300612769251L;

    /** The version. */
    @JsonProperty("version")
    private Long version;

    /** The subversion. */
    @JsonProperty("subversion")
    private String subversion;

    /** The protocolversion. */
    @JsonProperty("protocolversion")
    private Long protocolversion;

    /** The localservices. */
    @JsonProperty("localservices")
    private String localservices;

    /** The localrelay. */
    @JsonProperty("localrelay")
    private Boolean localrelay;

    /** The timeoffset. */
    @JsonProperty("timeoffset")
    private Long timeoffset;

    /** The networkactive. */
    @JsonProperty("networkactive")
    private Boolean networkactive;

    /** The connections. */
    @JsonProperty("connections")
    private Long connections;

    /** The networks. */
    @JsonProperty("networks")
    private List<BtcRpcNetworkInfoNetworkResponse> networks;

    /** The relayfee. */
    @JsonProperty("relayfee")
    private Double relayfee;

    /** The incrementalfee. */
    @JsonProperty("incrementalfee")
    private Double incrementalfee;

    /** The localaddresses. */
    @JsonProperty("localaddresses")
    private List<Object> localaddresses;

    /** The warnings. */
    @JsonProperty("warnings")
    private String warnings;

    /**
     * Instantiates a new btc rpc network info response.
     */
    public BtcRpcNetworkInfoResponse() {
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
     * Gets the subversion.
     *
     * @return the subversion
     */
    public String getSubversion() {
        return subversion;
    }

    /**
     * Sets the subversion.
     *
     * @param subversion the new subversion
     */
    public void setSubversion(String subversion) {
        this.subversion = subversion;
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
     * Gets the localservices.
     *
     * @return the localservices
     */
    public String getLocalservices() {
        return localservices;
    }

    /**
     * Sets the localservices.
     *
     * @param localservices the new localservices
     */
    public void setLocalservices(String localservices) {
        this.localservices = localservices;
    }

    /**
     * Gets the localrelay.
     *
     * @return the localrelay
     */
    public Boolean getLocalrelay() {
        return localrelay;
    }

    /**
     * Sets the localrelay.
     *
     * @param localrelay the new localrelay
     */
    public void setLocalrelay(Boolean localrelay) {
        this.localrelay = localrelay;
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
     * Gets the networkactive.
     *
     * @return the networkactive
     */
    public Boolean getNetworkactive() {
        return networkactive;
    }

    /**
     * Sets the networkactive.
     *
     * @param networkactive the new networkactive
     */
    public void setNetworkactive(Boolean networkactive) {
        this.networkactive = networkactive;
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
     * Gets the networks.
     *
     * @return the networks
     */
    public List<BtcRpcNetworkInfoNetworkResponse> getNetworks() {
        return networks;
    }

    /**
     * Sets the networks.
     *
     * @param networks the new networks
     */
    public void setNetworks(List<BtcRpcNetworkInfoNetworkResponse> networks) {
        this.networks = networks;
    }

    /**
     * Gets the relayfee.
     *
     * @return the relayfee
     */
    public Double getRelayfee() {
        return relayfee;
    }

    /**
     * Sets the relayfee.
     *
     * @param relayfee the new relayfee
     */
    public void setRelayfee(Double relayfee) {
        this.relayfee = relayfee;
    }

    /**
     * Gets the incrementalfee.
     *
     * @return the incrementalfee
     */
    public Double getIncrementalfee() {
        return incrementalfee;
    }

    /**
     * Sets the incrementalfee.
     *
     * @param incrementalfee the new incrementalfee
     */
    public void setIncrementalfee(Double incrementalfee) {
        this.incrementalfee = incrementalfee;
    }

    /**
     * Gets the localaddresses.
     *
     * @return the localaddresses
     */
    public List<Object> getLocaladdresses() {
        return localaddresses;
    }

    /**
     * Sets the localaddresses.
     *
     * @param localaddresses the new localaddresses
     */
    public void setLocaladdresses(List<Object> localaddresses) {
        this.localaddresses = localaddresses;
    }

    /**
     * Gets the warnings.
     *
     * @return the warnings
     */
    public String getWarnings() {
        return warnings;
    }

    /**
     * Sets the warnings.
     *
     * @param warnings the new warnings
     */
    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcNetworkInfoResponse [version=" + version + ", subversion=" + subversion + ", protocolversion=" + protocolversion
                + ", localservices=" + localservices + ", localrelay=" + localrelay + ", timeoffset=" + timeoffset + ", networkactive="
                + networkactive + ", connections=" + connections + ", networks=" + networks + ", relayfee=" + relayfee + ", incrementalfee="
                + incrementalfee + ", localaddresses=" + localaddresses + ", warnings=" + warnings + "]";
    }

}