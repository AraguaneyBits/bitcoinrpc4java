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
 * The Class BtcRpcGetAddressInfoResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetAddressInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1323043737066775520L;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The script pub key. */
    @JsonProperty("scriptPubKey")
    private String scriptPubKey;

    /** The ismine. */
    @JsonProperty("ismine")
    private Boolean ismine;

    /** The solvable. */
    @JsonProperty("solvable")
    private Boolean solvable;

    /** The desc. */
    @JsonProperty("desc")
    private String desc;

    /** The iswatchonly. */
    @JsonProperty("iswatchonly")
    private Boolean iswatchonly;

    /** The isscript. */
    @JsonProperty("isscript")
    private Boolean isscript;

    /** The iswitness. */
    @JsonProperty("iswitness")
    private Boolean iswitness;

    /** The script. */
    @JsonProperty("script")
    private String script;

    /** The hex. */
    @JsonProperty("hex")
    private String hex;

    /** The pubkey. */
    @JsonProperty("pubkey")
    private String pubkey;

    /** The embedded. */
    @JsonProperty("embedded")
    private BtcRpcGetAddressInfoEmbeddedResponse embedded;

    /** The label. */
    @JsonProperty("label")
    private String label;

    /** The ischange. */
    @JsonProperty("ischange")
    private Boolean ischange;

    /** The timestamp. */
    @JsonProperty("timestamp")
    private Long timestamp;

    /** The hdkeypath. */
    @JsonProperty("hdkeypath")
    private String hdkeypath;

    /** The hdseedid. */
    @JsonProperty("hdseedid")
    private String hdseedid;

    /** The hdmasterfingerprint. */
    @JsonProperty("hdmasterfingerprint")
    private String hdmasterfingerprint;

    /** The labels. */
    @JsonProperty("labels")
    private List<BtcRpcGetAddressInfoLabelResponse> labels;

    /**
     * Instantiates a new btc rpc get address info response.
     */
    public BtcRpcGetAddressInfoResponse() {
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
     * Gets the script pub key.
     *
     * @return the script pub key
     */
    public String getScriptPubKey() {
        return scriptPubKey;
    }

    /**
     * Sets the script pub key.
     *
     * @param scriptPubKey the new script pub key
     */
    public void setScriptPubKey(String scriptPubKey) {
        this.scriptPubKey = scriptPubKey;
    }

    /**
     * Gets the ismine.
     *
     * @return the ismine
     */
    public Boolean getIsmine() {
        return ismine;
    }

    /**
     * Sets the ismine.
     *
     * @param ismine the new ismine
     */
    public void setIsmine(Boolean ismine) {
        this.ismine = ismine;
    }

    /**
     * Gets the solvable.
     *
     * @return the solvable
     */
    public Boolean getSolvable() {
        return solvable;
    }

    /**
     * Sets the solvable.
     *
     * @param solvable the new solvable
     */
    public void setSolvable(Boolean solvable) {
        this.solvable = solvable;
    }

    /**
     * Gets the desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the desc.
     *
     * @param desc the new desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Gets the iswatchonly.
     *
     * @return the iswatchonly
     */
    public Boolean getIswatchonly() {
        return iswatchonly;
    }

    /**
     * Sets the iswatchonly.
     *
     * @param iswatchonly the new iswatchonly
     */
    public void setIswatchonly(Boolean iswatchonly) {
        this.iswatchonly = iswatchonly;
    }

    /**
     * Gets the isscript.
     *
     * @return the isscript
     */
    public Boolean getIsscript() {
        return isscript;
    }

    /**
     * Sets the isscript.
     *
     * @param isscript the new isscript
     */
    public void setIsscript(Boolean isscript) {
        this.isscript = isscript;
    }

    /**
     * Gets the iswitness.
     *
     * @return the iswitness
     */
    public Boolean getIswitness() {
        return iswitness;
    }

    /**
     * Sets the iswitness.
     *
     * @param iswitness the new iswitness
     */
    public void setIswitness(Boolean iswitness) {
        this.iswitness = iswitness;
    }

    /**
     * Gets the script.
     *
     * @return the script
     */
    public String getScript() {
        return script;
    }

    /**
     * Sets the script.
     *
     * @param script the new script
     */
    public void setScript(String script) {
        this.script = script;
    }

    /**
     * Gets the hex.
     *
     * @return the hex
     */
    public String getHex() {
        return hex;
    }

    /**
     * Sets the hex.
     *
     * @param hex the new hex
     */
    public void setHex(String hex) {
        this.hex = hex;
    }

    /**
     * Gets the pubkey.
     *
     * @return the pubkey
     */
    public String getPubkey() {
        return pubkey;
    }

    /**
     * Sets the pubkey.
     *
     * @param pubkey the new pubkey
     */
    public void setPubkey(String pubkey) {
        this.pubkey = pubkey;
    }

    /**
     * Gets the embedded.
     *
     * @return the embedded
     */
    public BtcRpcGetAddressInfoEmbeddedResponse getEmbedded() {
        return embedded;
    }

    /**
     * Sets the embedded.
     *
     * @param embedded the new embedded
     */
    public void setEmbedded(BtcRpcGetAddressInfoEmbeddedResponse embedded) {
        this.embedded = embedded;
    }

    /**
     * Gets the label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label.
     *
     * @param label the new label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets the ischange.
     *
     * @return the ischange
     */
    public Boolean getIschange() {
        return ischange;
    }

    /**
     * Sets the ischange.
     *
     * @param ischange the new ischange
     */
    public void setIschange(Boolean ischange) {
        this.ischange = ischange;
    }

    /**
     * Gets the timestamp.
     *
     * @return the timestamp
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp.
     *
     * @param timestamp the new timestamp
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets the hdkeypath.
     *
     * @return the hdkeypath
     */
    public String getHdkeypath() {
        return hdkeypath;
    }

    /**
     * Sets the hdkeypath.
     *
     * @param hdkeypath the new hdkeypath
     */
    public void setHdkeypath(String hdkeypath) {
        this.hdkeypath = hdkeypath;
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
     * Gets the hdmasterfingerprint.
     *
     * @return the hdmasterfingerprint
     */
    public String getHdmasterfingerprint() {
        return hdmasterfingerprint;
    }

    /**
     * Sets the hdmasterfingerprint.
     *
     * @param hdmasterfingerprint the new hdmasterfingerprint
     */
    public void setHdmasterfingerprint(String hdmasterfingerprint) {
        this.hdmasterfingerprint = hdmasterfingerprint;
    }

    /**
     * Gets the labels.
     *
     * @return the labels
     */
    public List<BtcRpcGetAddressInfoLabelResponse> getLabels() {
        return labels;
    }

    /**
     * Sets the labels.
     *
     * @param labels the new labels
     */
    public void setLabels(List<BtcRpcGetAddressInfoLabelResponse> labels) {
        this.labels = labels;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetAddressInfoResponse [address=" + address + ", scriptPubKey=" + scriptPubKey + ", ismine=" + ismine + ", solvable=" + solvable
                + ", desc=" + desc + ", iswatchonly=" + iswatchonly + ", isscript=" + isscript + ", iswitness=" + iswitness + ", script=" + script
                + ", hex=" + hex + ", pubkey=" + pubkey + ", embedded=" + embedded + ", label=" + label + ", ischange=" + ischange + ", timestamp="
                + timestamp + ", hdkeypath=" + hdkeypath + ", hdseedid=" + hdseedid + ", hdmasterfingerprint=" + hdmasterfingerprint + ", labels="
                + labels + "]";
    }

}
