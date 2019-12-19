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
package com.araguaneybits.crypto.bitcoinrpc.methods.integration;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.MissingResourceException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ConfigurationIntegrationTest.
 *
 * @author jestevez
 */
public class ConfigurationIntegrationTest {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationIntegrationTest.class);

    /** The properties. */
    public static Properties properties = null;

    /**
     * Load config.
     */
    private static synchronized void loadConfig() {
        InputStream inputStream = null;
        try {
            if (properties == null) {
                properties = new Properties();
                inputStream = ConfigurationIntegrationTest.class.getClassLoader().getResourceAsStream("integrationtest.properties");
                properties.load(inputStream);
            }
        } catch (IOException e) {
            properties = null;
            LOG.error("Error in loadConfig {}", e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOG.error("Error in loadConfig {}", e.getMessage());
                }
            }
        }
    }

    /**
     * Check config load.
     */
    private static void checkConfigLoad() {
        if (properties == null) {
            loadConfig();
        }
    }

    /**
     * Gets the variable.
     *
     * @param key the key
     * @return the variable
     */
    public static String getVariable(String key) {
        try {
            checkConfigLoad();
            return properties.getProperty(key);
        } catch (MissingResourceException e) {
            LOG.error("Error al recuperar parámetros de configuración con key: {} Error {} ", key, e.getKey());
            return null;
        }
    }

    /**
     * Gets the variable number.
     *
     * @param key the key
     * @return the variable number
     */
    public static BigDecimal getVariableNumber(String key) {
        try {
            checkConfigLoad();
            return new BigDecimal(properties.getProperty(key));
        } catch (MissingResourceException e) {
            LOG.error("Error al recuperar parámetros de configuración con key: {} Error {} ", key, e.getKey());
            return BigDecimal.ZERO;
        }
    }
}
