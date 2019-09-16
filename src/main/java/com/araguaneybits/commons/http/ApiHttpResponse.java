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
package com.araguaneybits.commons.http;

import java.io.Serializable;

/**
 * The Class ApiHttpResponse.
 *
 * @author jestevez
 */
public class ApiHttpResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5757376358255387481L;

    /** The body. */
    private String body;

    /** The code. */
    private int code;

    /**
     * Instantiates a new api http response.
     */
    public ApiHttpResponse() {
        super();
    }

    /**
     * Gets the body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body.
     *
     * @param body the new body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ApiHttpResponse [body=" + body + ", code=" + code + "]";
    }

}
