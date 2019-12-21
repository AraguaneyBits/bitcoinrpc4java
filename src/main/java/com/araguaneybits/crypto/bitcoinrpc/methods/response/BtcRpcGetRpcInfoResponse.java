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
 * The Class BtcRpcGetRpcInfoResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetRpcInfoResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5726935219796250895L;

    /** The active commands. */
    @JsonProperty("active_commands")
    private List<BtcRpcGetRpcInfoActiveCommandResponse> activeCommands;

    /** The logpath. */
    @JsonProperty("logpath")
    private String logpath;

    /**
     * Instantiates a new btc rpc get rpc info response.
     */
    public BtcRpcGetRpcInfoResponse() {
        super();
    }

    /**
     * Gets the active commands.
     *
     * @return the active commands
     */
    public List<BtcRpcGetRpcInfoActiveCommandResponse> getActiveCommands() {
        return activeCommands;
    }

    /**
     * Sets the active commands.
     *
     * @param activeCommands the new active commands
     */
    public void setActiveCommands(List<BtcRpcGetRpcInfoActiveCommandResponse> activeCommands) {
        this.activeCommands = activeCommands;
    }

    /**
     * Gets the logpath.
     *
     * @return the logpath
     */
    public String getLogpath() {
        return logpath;
    }

    /**
     * Sets the logpath.
     *
     * @param logpath the new logpath
     */
    public void setLogpath(String logpath) {
        this.logpath = logpath;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetRpcInfoResponse [activeCommands=" + activeCommands + ", logpath=" + logpath + "]";
    }

}
