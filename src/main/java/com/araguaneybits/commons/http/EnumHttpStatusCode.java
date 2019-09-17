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

/**
 * The Enum EnumHttpStatusCode.
 * 
 * @author jestevez
 */
public enum EnumHttpStatusCode {

    /** The http ok. */
    HTTP_OK(200),

    /** The http bad request. */
    HTTP_BAD_REQUEST(400),

    /** The http unauthorized. */
    HTTP_UNAUTHORIZED(401),

    /** The http forbidden. */
    HTTP_FORBIDDEN(403),

    /** The http not found. */
    HTTP_NOT_FOUND(404),

    /** The http bad method. */
    HTTP_BAD_METHOD(405),

    /** The http proxy authentication required. */
    HTTP_PROXY_AUTHENTICATION_REQUIRED(407),

    /** The http error conflict. */
    HTTP_ERROR_CONFLICT(409),

    /** The http internal server error. */
    HTTP_INTERNAL_SERVER_ERROR(500),

    /** The http service unavailable. */
    HTTP_SERVICE_UNAVAILABLE(503);

    /** The code. */
    private final int code;

    /**
     * Instantiates a new enum http status code.
     *
     * @param code the code
     */
    EnumHttpStatusCode(int code) {
        this.code = code;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }
}
