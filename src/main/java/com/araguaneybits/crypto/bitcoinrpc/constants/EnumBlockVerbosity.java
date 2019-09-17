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
 * The Enum EnumBlockVerbosity.
 * 
 * @author jestevez
 */
public enum EnumBlockVerbosity {

    /** The serialized hex encoded. */
    SERIALIZED_HEX_ENCODED(0),

    /** The object. */
    OBJECT(1),

    /** The object and transaction. */
    OBJECT_AND_TRANSACTION(2);

    /** The value. */
    private final int value;

    /**
     * Instantiates a new enum block verbosity.
     *
     * @param value the value
     */
    EnumBlockVerbosity(int value) {
        this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }
}
