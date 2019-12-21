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
 * The Class BtcRpcGetRpcInfoActiveCommandResponse.
 *
 * @author jestevez
 */
public class BtcRpcGetRpcInfoActiveCommandResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7549438709031197558L;

    /** The method. */
    @JsonProperty("method")
    private String method;

    /** The duration. */
    @JsonProperty("duration")
    private BigInteger duration;

    /**
     * Instantiates a new btc rpc get rpc info active command response.
     */
    public BtcRpcGetRpcInfoActiveCommandResponse() {
        super();
    }

    /**
     * Gets the method.
     *
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the method.
     *
     * @param method the new method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Gets the duration.
     *
     * @return the duration
     */
    public BigInteger getDuration() {
        return duration;
    }

    /**
     * Sets the duration.
     *
     * @param duration the new duration
     */
    public void setDuration(BigInteger duration) {
        this.duration = duration;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BtcRpcGetRpcInfoActiveCommandResponse [method=" + method + ", duration=" + duration + "]";
    }

}
