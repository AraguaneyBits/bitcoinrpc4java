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

import java.math.BigInteger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcControlMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetMemoryInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetRpcInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcLoggingResponse;

/**
 * The Class BtcRpcControlMethodsIntegrationTest.
 *
 * @author jestevez
 */
// @Ignore
public class BtcRpcControlMethodsIntegrationTest extends AbstractBtcRpcMethodsIntegrationTest {

    /** The undertest. */
    private BtcRpcControlMethods undertest;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        undertest = new BtcRpcControlMethods(btcRpcGateway);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {

    }

    /**
     * Test getmemoryinfo.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetMemoryinfo() throws Exception {
        BtcRpcGetMemoryInfoResponse btcRpcGetMemoryInfoResponse = undertest.getMemoryInfo();
        Assert.assertNotNull("Is not null", btcRpcGetMemoryInfoResponse);
    }

    /**
     * Test getrpcinfo.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetrpcinfo() throws Exception {
        BtcRpcGetRpcInfoResponse BtcRpcGetRpcInfoResponse = undertest.getRpcInfo();
        Assert.assertNotNull("Is not null", BtcRpcGetRpcInfoResponse);
    }

    /**
     * Test help.
     *
     * @throws Exception the exception
     */
    @Test
    public void testHelp() throws Exception {
        undertest.help();
        String result = undertest.help();
        Assert.assertNotNull("Is not null", result);
    }

    /**
     * Test logging.
     *
     * @throws Exception the exception
     */
    @Test
    public void testLogging() throws Exception {
        BtcRpcLoggingResponse btcRpcLoggingResponse = undertest.logging();
        Assert.assertFalse("Tor is disabled", btcRpcLoggingResponse.getTor());
    }

    /**
     * Test stop.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testStop() throws Exception {
        String result = undertest.stop();
        Assert.assertNotNull("Is not null", result);
    }

    /**
     * Test uptime.
     *
     * @throws Exception the exception
     */
    @Test
    public void testUptime() throws Exception {
        BigInteger uptime = undertest.uptime();
        Assert.assertNotNull("Is not null", uptime);
    }

    /**
     * Test getzmqnotifications.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetzmqnotifications() throws Exception {
        undertest.getzmqnotifications();
        Assert.fail("Test method not implemented");
    }
}
