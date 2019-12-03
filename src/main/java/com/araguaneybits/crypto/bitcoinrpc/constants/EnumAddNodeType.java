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
package com.araguaneybits.crypto.bitcoinrpc.constants;

/**
 * The Enum EnumAddNodeType.
 *
 * @author jestevez
 */
public enum EnumAddNodeType {

    /** The add. */
    ADD("add"),
    /** The remove. */
    REMOVE("remove"),
    /** The onetry. */
    ONETRY("onetry");

    /** The value. */
    private final String value;

    /**
     * Instantiates a new enum add node type.
     *
     * @param value the value
     */
    EnumAddNodeType(String value) {
        this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
