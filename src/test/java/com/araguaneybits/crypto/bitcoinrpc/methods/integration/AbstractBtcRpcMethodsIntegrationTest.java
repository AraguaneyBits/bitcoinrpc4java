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

import static org.awaitility.Awaitility.await;

import java.util.concurrent.Callable;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.araguaneybits.commons.io.ExecuteNativeCommand;
import com.araguaneybits.commons.utils.ProxyConfiguration;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcGateway;

/**
 * The Class AbstractBtcRpcMethodsIntegrationTest.
 *
 * @author jestevez
 */
public abstract class AbstractBtcRpcMethodsIntegrationTest {

    /** The is active daemon. */
    private static Boolean isActiveDaemon = Boolean.FALSE;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractBtcRpcMethodsIntegrationTest.class);

    /** The bitcoin rpc user. */
    protected static String BITCOIN_RPC_USER;

    /** The bitcoin rpc pass. */
    protected static String BITCOIN_RPC_PASS;

    /** The bitcoin rpc host. */
    protected static String BITCOIN_RPC_HOST;

    /** The bitcoin rpc port. */
    protected static String BITCOIN_RPC_PORT;

    /** The bitcoin rpc protocol. */
    protected static String BITCOIN_RPC_PROTOCOL;

    /** The bitcoin home. */
    protected static String BITCOIN_HOME;

    /** The bitcoind. */
    protected static String BITCOIND;

    /** The bitcoin cli. */
    protected static String BITCOIN_CLI;

    /** The passphrase. */
    protected static String PASSPHRASE;

    /** The use local daemon. */
    protected static Boolean USE_LOCAL_DAEMON = Boolean.FALSE;

    /** The proxy enabled. */
    protected static Boolean PROXY_ENABLED = Boolean.FALSE;

    /** The proxy exclusion. */
    protected static String PROXY_EXCLUSION;

    /** The proxy password. */
    protected static String PROXY_PASSWORD;

    /** The proxy port. */
    protected static String PROXY_PORT;

    /** The proxy url. */
    protected static String PROXY_URL;

    /** The proxy user. */
    protected static String PROXY_USER;

    /** The btc rpc gateway. */
    protected static BtcRpcGateway btcRpcGateway;

    /**
     * The Class BitcoinDaemon.
     */
    static class BitcoinDaemon implements Runnable {

        /** The parameter. */
        private String parameter;

        /**
         * Instantiates a new bitcoin daemon.
         *
         * @param parameter the parameter
         */
        public BitcoinDaemon(String parameter) {
            this.parameter = parameter;
        }

        /**
         * {@inheritDoc}
         * 
         * @see java.lang.Runnable#run()
         */
        public void run() {
            try {
                ExecuteNativeCommand.executeRuntimeCommand(BITCOIND + " " + parameter);
                isActiveDaemon = Boolean.TRUE;
            } catch (Exception e) {
                isActiveDaemon = Boolean.FALSE;
            }

        }
    }

    /**
     * Checks if is ready.
     *
     * @return the callable
     */
    protected static Callable<Boolean> isReady() {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                try {
                    initializeRpcGateway();
                } catch (Exception e) {
                    LOGGER.error("Failed is not yet available", e);
                }
                LOGGER.info("isActiveDaemon=[{}]", isActiveDaemon);
                return isActiveDaemon;
            }
        };
    }

    /**
     * Initialize rpc gateway.
     */
    private static void initializeRpcGateway() {
        ProxyConfiguration proxyConfiguration = new ProxyConfiguration();
        proxyConfiguration.setEnabled(PROXY_ENABLED);
        proxyConfiguration.setExclusion(PROXY_EXCLUSION);
        proxyConfiguration.setPassword(PROXY_PASSWORD);
        proxyConfiguration.setPort(PROXY_PORT);
        proxyConfiguration.setUrl(PROXY_URL);
        proxyConfiguration.setUser(PROXY_USER);
        btcRpcGateway = new BtcRpcGateway(BITCOIN_RPC_USER, BITCOIN_RPC_PASS, BITCOIN_RPC_HOST, BITCOIN_RPC_PORT, BITCOIN_RPC_PROTOCOL,
                proxyConfiguration);

        // btcRpcGateway = new BtcRpcGateway(BITCOIN_RPC_USER, BITCOIN_RPC_PASS, BITCOIN_RPC_HOST, BITCOIN_RPC_PORT, BITCOIN_RPC_PROTOCOL,
        // "/wallet/junit_wallet", proxyConfiguration);
    }

    /**
     * Sets the up class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        BITCOIN_RPC_USER = ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.rpc.user");
        BITCOIN_RPC_PASS = ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.rpc.pass");
        BITCOIN_RPC_HOST = ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.rpc.host");
        BITCOIN_RPC_PORT = ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.rpc.port");
        BITCOIN_RPC_PROTOCOL = ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.rpc.protocol");
        BITCOIN_HOME = ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.daemon.home");
        BITCOIND = BITCOIN_HOME + "bitcoind";
        BITCOIN_CLI = BITCOIN_HOME + "bitcoin-cli";
        PASSPHRASE = ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.wallet.pass");
        USE_LOCAL_DAEMON = "true".equals(ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.daemon.enable"));

        PROXY_ENABLED = "true".equals(ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.proxy.enabled"));
        PROXY_EXCLUSION = ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.proxy.exclusion");
        PROXY_PASSWORD = ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.proxy.pass");
        PROXY_PORT = ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.proxy.port");
        PROXY_URL = ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.proxy.url");
        PROXY_USER = ConfigurationIntegrationTest.getVariable("bitcoinrpc4j.it.proxy.user");

        if (USE_LOCAL_DAEMON) {
            // start rpc regtest
            Runnable r = new BitcoinDaemon("-regtest -deprecatedrpc=generate");
            Thread t = new Thread(r);
            t.start();
            await().until(isReady());
        } else {
            initializeRpcGateway();
        }

    }

    /**
     * Tear down class.
     *
     * @throws Exception the exception
     */
    @AfterClass
    public static void tearDownClass() throws Exception {
        // Shut down the server.
        if (USE_LOCAL_DAEMON) {
            ExecuteNativeCommand.executeRuntimeCommand(BITCOIN_CLI + " -regtest stop");
        }

    }
}
