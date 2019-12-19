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
package com.araguaneybits.crypto.bitcoinrpc.methods;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * The Class BtcRpcControlMethodsTest.
 *
 * @author jestevez
 */
@Ignore
public class BtcRpcControlMethodsTest extends AbstractBtcRpcMethodsTest {

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
    public void testGetmemoryinfo() throws Exception {
        undertest.getmemoryinfo();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test getrpcinfo.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetrpcinfo() throws Exception {
        undertest.getrpcinfo();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test help.
     *
     * @throws Exception the exception
     */
    @Test
    public void testHelp() throws Exception {
        undertest.help();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test logging.
     *
     * @throws Exception the exception
     */
    @Test
    public void testLogging() throws Exception {
        undertest.logging();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test stop.
     *
     * @throws Exception the exception
     */
    @Test
    public void testStop() throws Exception {
        undertest.stop();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test uptime.
     *
     * @throws Exception the exception
     */
    @Test
    public void testUptime() throws Exception {
        undertest.uptime();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test getzmqnotifications.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetzmqnotifications() throws Exception {
        undertest.getzmqnotifications();
        Assert.fail("Test method not implemented");
    }
}
