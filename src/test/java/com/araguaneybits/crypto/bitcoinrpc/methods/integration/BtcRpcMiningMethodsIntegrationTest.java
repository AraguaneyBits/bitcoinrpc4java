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
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.constants.EnumEstimateMode;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcMiningMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletToolsMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.request.BtcRpcBlockTemplateRequest;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcBlockTemplateResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetMiningInfoResponse;

/**
 * The Class BtcRpcMiningMethodsIntegrationTest.
 *
 * @author jestevez
 */
// @Ignore
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
    @Test
    public void testGetBlockTemplate() throws Exception {
        BtcRpcBlockTemplateRequest btcRpcBlockTemplateRequest = new BtcRpcBlockTemplateRequest();
        btcRpcBlockTemplateRequest.setMode("template");
        btcRpcBlockTemplateRequest.setRules(new String[] { "segwit" });
        BtcRpcBlockTemplateResponse btcRpcBlockTemplateResponse = undertest.getBlockTemplate(btcRpcBlockTemplateRequest);

        Assert.assertNotNull("Is not null", btcRpcBlockTemplateResponse);
    }

    /**
     * Test getmininginfo.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetMiningInfo() throws Exception {
        BtcRpcGetMiningInfoResponse btcRpcGetMiningInfoResponse = undertest.getMiningInfo();

        Assert.assertNotNull("Is not null", btcRpcGetMiningInfoResponse);
    }

    /**
     * Test getnetworkhashps.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetNetworkHashPs() throws Exception {
        BigInteger nblocks = new BigInteger("120");
        BigInteger height = new BigInteger("-1");

        BigDecimal hashps = undertest.getNetworkHashPs(nblocks, height);
        Assert.assertNotNull("Is not null", hashps);
    }

    /**
     * Test prioritisetransaction.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPrioritiseTransaction() throws Exception {
        String address = btcRpcWalletMethods.getNewAddress();
        btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);
        String txid = btcRpcWalletMethods.sendToAddress(address, new BigDecimal("0.11111111"), "prioritisetransaction-" + System.currentTimeMillis(),
                "", true, true, 3L, EnumEstimateMode.CONSERVATIVE);
        Boolean success = undertest.prioritiseTransaction(txid, new BigInteger("10000"));
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test submitblock.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSubmitBlock() throws Exception {
        // genesisi 0x000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943
        // CreateGenesisBlock(1296688602, 414098458, 0x1d00ffff, 1, 50 * COIN);
        /**
         * <pre>
        version:     01000000
        prev block:  0000000000000000000000000000000000000000000000000000000000000000 
        merkle root: 3BA3EDFD7A7B12B27AC72C3E67768F617FC81BC3888A51323A9FB8AA4B1E5E4A
        timestamp:   29AB5F49
        bits:        FFFF001D
        nonce        1DAC2B7C
        num txs:     01
        tx1:         01000000010000000000000000000000000000000000000000000000000000000000000000FFFFFFFF4D04FFFF001D0104455468652054696D65732030332F4A616E2F32303039204368616E63656C6C6F72206F6E206272696E6B206F66207365636F6E64206261696C6F757420666F722062616E6B73FFFFFFFF0100F2052A01000000434104678AFDB0FE5548271967F1A67130B7105CD6A828E03909A67962E0EA1F61DEB649F6BC3F4CEF38C4F35504E51EC112DE5C384DF7BA0B8D578A4C702B6BF11D5FAC00000000
         * </pre>
         */
        undertest.submitBlock(
                "0100000000000000000000000000000000000000000000000000000000000000000000003BA3EDFD7A7B12B27AC72C3E67768F617FC81BC3888A51323A9FB8AA4B1E5E4A29AB5F49FFFF001D1DAC2B7C0101000000010000000000000000000000000000000000000000000000000000000000000000FFFFFFFF4D04FFFF001D0104455468652054696D65732030332F4A616E2F32303039204368616E63656C6C6F72206F6E206272696E6B206F66207365636F6E64206261696C6F757420666F722062616E6B73FFFFFFFF0100F2052A01000000434104678AFDB0FE5548271967F1A67130B7105CD6A828E03909A67962E0EA1F61DEB649F6BC3F4CEF38C4F35504E51EC112DE5C384DF7BA0B8D578A4C702B6BF11D5FAC00000000");
        Assert.fail("Test method not implemented");
    }

    /**
     * Test submitheader.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSubmitHeader() throws Exception {
        undertest.submitHeader("");
        Assert.fail("Test method not implemented");
    }

    /**
     * Test generatetoaddress.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGenerateToAddress() throws Exception {
        BigInteger nblocks = new BigInteger("0");
        String address = "";
        BigInteger maxtries = new BigInteger("0");
        undertest.generateToAddress(nblocks, address, maxtries);
        Assert.fail("Test method not implemented");
    }
}
