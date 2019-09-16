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
package com.araguaneybits.crypto.bitcoinrpc;

import java.io.Serializable;

/**
 * The Class RpcOutputMessage.
 *
 * @param <T> the generic type
 */
public class RpcOutputMessage<T extends Serializable> {

    /** The error. */
    private String error;

    /** The id. */
    private String id;

    /** The result. */
    private T result;

    /**
     * Instantiates a new rpc output message.
     */
    public RpcOutputMessage() {
        super();
    }

    /**
     * Gets the error.
     *
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error.
     *
     * @param error the new error
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the result.
     *
     * @return the result
     */
    public T getResult() {
        return result;
    }

    /**
     * Sets the result.
     *
     * @param result the new result
     */
    public void setResult(T result) {
        this.result = result;
    }

}
