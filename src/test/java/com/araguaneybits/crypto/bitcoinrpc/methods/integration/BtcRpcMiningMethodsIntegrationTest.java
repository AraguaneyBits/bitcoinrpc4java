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

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;

import com.araguaneybits.crypto.bitcoinrpc.constants.EnumEstimateMode;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcMiningMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletToolsMethods;

/**
 * The Class BtcRpcMiningMethodsIntegrationTest.
 *
 * @author jestevez
 */
@Ignore
public class BtcRpcMiningMethodsIntegrationTest extends AbstractBtcRpcMethodsIntegrationTest {

    /** The undertest. */
    private BtcRpcMiningMethods undertest;

    /** The btc rpc wallet methods. */
    private BtcRpcWalletMethods btcRpcWalletMethods;

    /** The btc rpc wallet tools methods. */
    private BtcRpcWalletToolsMethods btcRpcWalletToolsMethods;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        undertest = new BtcRpcMiningMethods(btcRpcGateway);
        btcRpcWalletMethods = new BtcRpcWalletMethods(btcRpcGateway);
        btcRpcWalletToolsMethods = new BtcRpcWalletToolsMethods(btcRpcGateway);
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
        BigDecimal hashps = undertest.getnetworkhashps(120, -1);
        Assert.assertNotNull("Is not null", hashps);
    }

    /**
     * Test prioritisetransaction.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testPrioritisetransaction() throws Exception {
        String address = btcRpcWalletMethods.getNewAddress();
        btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);
        String txid = btcRpcWalletMethods.sendToAddress(address, new BigDecimal("0.11111111"), "prioritisetransaction-" + System.currentTimeMillis(),
                "", true, true, 3L, EnumEstimateMode.CONSERVATIVE);
        Boolean success = undertest.prioritisetransaction(txid, new BigInteger("10000"));
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
