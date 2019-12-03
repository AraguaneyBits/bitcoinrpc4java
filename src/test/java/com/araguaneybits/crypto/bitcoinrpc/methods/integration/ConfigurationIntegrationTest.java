/*
 * Creation : 3 dic. 2019
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
 * @author jestevez
 */
public class ConfigurationIntegrationTest {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationIntegrationTest.class);

    public static Properties properties = null;

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

    private static void checkConfigLoad() {
        if (properties == null) {
            loadConfig();
        }
    }

    public static String getVariable(String key) {
        try {
            checkConfigLoad();
            return properties.getProperty(key);
        } catch (MissingResourceException e) {
            LOG.error("Error al recuperar parámetros de configuración con key: {} Error {} ", key, e.getKey());
            return null;
        }
    }

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
