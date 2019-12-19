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

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

/**
 * The Class BtcRpcMiningMethodsTest.
 *
 * @author jestevez
 */
// @Ignore
public class BtcRpcMiningMethodsTest extends AbstractBtcRpcMethodsTest {

    /** The undertest. */
    private BtcRpcMiningMethods undertest;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        undertest = new BtcRpcMiningMethods(btcRpcGateway);

    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {

    }

    /**
     * Test getblocktemplate.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetblocktemplate() throws Exception {
        undertest.getblocktemplate();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test getmininginfo.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetmininginfo() throws Exception {
        undertest.getmininginfo();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test getnetworkhashps.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetnetworkhashps() throws Exception {
        enqueueMockedResponse(200, "{\"result\":37757629937695.34,\"error\":null,\"id\":null}");
        BigDecimal hashps = undertest.getnetworkhashps(120, -1);
        Assert.assertEquals("Expected equals37757629937695.34", new BigDecimal("37757629937695.34"), hashps);
    }

    /**
     * Test prioritisetransaction.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testPrioritisetransaction() throws Exception {
        enqueueMockedResponse(200, "{\"result\":true,\"error\":null,\"id\":null}");
        Boolean success = undertest.prioritisetransaction("", new BigInteger("10000"));
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test submitblock.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSubmitblock() throws Exception {
        undertest.submitblock("");
        Assert.fail("Test method not implemented");
    }

    /**
     * Test submitheader.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSubmitheader() throws Exception {
        undertest.submitheader();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test generatetoaddress.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGeneratetoaddress() throws Exception {
        undertest.generatetoaddress();
        Assert.fail("Test method not implemented");
    }
}
