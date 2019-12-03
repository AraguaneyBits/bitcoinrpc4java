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

public abstract class AbstractBtcRpcMethodsIntegrationTest {

    private static Boolean isActiveDaemon = Boolean.FALSE;
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractBtcRpcMethodsIntegrationTest.class);

    protected static String BITCOIN_RPC_USER;
    protected static String BITCOIN_RPC_PASS;
    protected static String BITCOIN_RPC_HOST;
    protected static String BITCOIN_RPC_PORT;
    protected static String BITCOIN_RPC_PROTOCOL;
    protected static String BITCOIN_HOME;
    protected static String BITCOIND;
    protected static String BITCOIN_CLI;
    protected static String PASSPHRASE;
    protected static Boolean USE_LOCAL_DAEMON = Boolean.FALSE;

    protected static Boolean PROXY_ENABLED = Boolean.FALSE;
    protected static String PROXY_EXCLUSION;
    protected static String PROXY_PASSWORD;
    protected static String PROXY_PORT;
    protected static String PROXY_URL;
    protected static String PROXY_USER;

    protected static BtcRpcGateway btcRpcGateway;

    static class BitcoinDaemon implements Runnable {
        private String parameter;

        public BitcoinDaemon(String parameter) {
            this.parameter = parameter;
        }

        public void run() {
            try {
                ExecuteNativeCommand.executeRuntimeCommand(BITCOIND + " " + parameter);
                isActiveDaemon = Boolean.TRUE;
            } catch (Exception e) {
                isActiveDaemon = Boolean.FALSE;
            }

        }
    }

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
    }

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

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Shut down the server.
        if (USE_LOCAL_DAEMON) {
            ExecuteNativeCommand.executeRuntimeCommand(BITCOIN_CLI + " -regtest stop");
        }

    }
}
