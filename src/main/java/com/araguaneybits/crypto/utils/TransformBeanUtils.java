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
package com.araguaneybits.crypto.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class TransformBeanUtils.
 */
public final class TransformBeanUtils {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(TransformBeanUtils.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Instantiates a new transform bean utils.
     */
    private TransformBeanUtils() {
        super();
    }

    public ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    public static Object readValue(String string, TypeReference typeReference) {
        try {
            OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            OBJECT_MAPPER.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
            OBJECT_MAPPER.enable(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS);
            return OBJECT_MAPPER.readValue(string, typeReference);
        } catch (IOException e) {
            LOGGER.error("could not get a valid object with the json {} exception {}", string, e);
        }
        return null;
    }

    /**
     * Read value.
     *
     * @param <T> the generic type
     * @param string the string
     * @param toValueType the to value type
     * @return the t
     */
    public static <T> T readValue(String string, Class<T> toValueType) {
        try {
            OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            OBJECT_MAPPER.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
            OBJECT_MAPPER.enable(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS);
            return OBJECT_MAPPER.readValue(string, toValueType);
        } catch (IOException e) {
            LOGGER.error("could not get a valid object with the json {} exception {}", string, e);
        }
        return null;
    }

    /**
     * Write value as string.
     *
     * @param object the object
     * @return the string
     */
    public static String writeValueAsString(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (IOException e) {
            LOGGER.error("could not transform object {} to json exception {}", object, e);
        }

        return null;
    }

}
