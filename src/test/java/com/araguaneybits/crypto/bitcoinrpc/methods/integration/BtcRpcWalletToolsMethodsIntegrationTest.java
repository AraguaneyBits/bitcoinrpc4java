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

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.araguaneybits.crypto.bitcoinrpc.constants.EnumRpcErrorCode;
import com.araguaneybits.crypto.bitcoinrpc.exception.BtcRpcBaseException;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletToolsMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcCreateWalletResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetWalletInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListSinceBlockResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListSinceBlockTransactionResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcLoadWalletResponse;

/**
 * The Class BtcRpcWalletToolsMethodsIntegrationTest.
 *
 * @author jestevez
 */
public class BtcRpcWalletToolsMethodsIntegrationTest extends AbstractBtcRpcMethodsIntegrationTest {

    /** The undertest. */
    private BtcRpcWalletToolsMethods undertest;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        undertest = new BtcRpcWalletToolsMethods(btcRpcGateway);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {

    }

    /**
     * Test abort rescan.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testAbortRescan() throws Exception {
        Boolean success = undertest.abortRescan();
        Assert.assertFalse("Expected false", success);

        // TODO Implement success case
        // Long startHeight = 1_200_000L;
        // Long stopHeight = 1_200_001L;
        // undertest.rescanBlockchain(startHeight, stopHeight);
        //
        // Boolean isTrue = undertest.abortRescan();
        // Assert.assertTrue("Expected true", isTrue);
    }

    /**
     * Test backup wallet.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testBackupWallet() throws Exception {
        Boolean condition = true;
        // System.getProperty("java.io.tmpdir")+ File.separator
        String destination = "backup_wallet_" + System.currentTimeMillis() + ".dat";
        undertest.backupWallet(destination);
        Assert.assertTrue("Ok", condition);
    }

    /**
     * Test create wallet.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testCreateWallet() throws Exception {
        String walletName = "junit_wallet_2";
        Boolean disablePrivateKeys = false;
        Boolean blank = true;
        BtcRpcCreateWalletResponse btcRpcCreateWalletResponse = undertest.createWallet(walletName, disablePrivateKeys, blank);
        Assert.assertEquals("Expected walletName", walletName, btcRpcCreateWalletResponse.getName());
        // multi-wallet is required argument in btcRpcGateway
        // btcRpcGateway = new BtcRpcGateway(BITCOIN_RPC_USER, BITCOIN_RPC_PASS,
        // BITCOIN_RPC_HOST, BITCOIN_RPC_PORT, BITCOIN_RPC_PROTOCOL,
        // "/wallet/junit_wallet", proxyConfiguration);
    }

    /**
     * Test dump wallet.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testDumpWallet() throws Exception {
        Boolean condition = undertest.walletPassphrase(PASSPHRASE, 30L);
        Assert.assertTrue("Ok", condition);
        // String filename = System.getProperty("java.io.tmpdir") + "new_wallet_" +
        // System.currentTimeMillis() + ".dat";
        String filename = "/tmp/dumpwallet.dat";
        String fileNameConfirm = undertest.dumpWallet(filename);
        Assert.assertEquals("Expected equals", filename, fileNameConfirm);
    }

    /**
     * Test encrypt wallet.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testEncryptWallet() throws Exception {
        try {
            String passphrase = PASSPHRASE;
            Boolean success = undertest.encryptWallet(passphrase);
            Assert.assertTrue("Expected true", success);
        } catch (BtcRpcBaseException e) {
            Assert.assertEquals("Expected code -15", EnumRpcErrorCode.RPC_WALLET_WRONG_ENC_STATE.getCode(), e.getCode());
        }
    }

    /**
     * Test get wallet info.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetWalletInfo() throws Exception {
        BtcRpcGetWalletInfoResponse btcRpcGetWalletInfoResponse = undertest.getWalletInfo();
        Assert.assertTrue("Expected true", btcRpcGetWalletInfoResponse.getPrivateKeysEnabled());
    }

    /**
     * Test import wallet.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testImportWallet() throws Exception {
        Boolean condition = undertest.walletPassphrase(PASSPHRASE, 30L);
        Assert.assertTrue("Ok", condition);
        String filename = "/tmp/dumpwallet.dat";
        Boolean success = undertest.importWallet(filename);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test keypool refill.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testKeypoolRefill() throws Exception {
        Boolean condition = undertest.walletPassphrase(PASSPHRASE, 30L);
        Assert.assertTrue("Ok", condition);
        Long newsize = 2L;
        Boolean success = undertest.keypoolRefill(newsize);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test list since block.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testListSinceBlock() throws Exception {
        // String blockhash = null;
        // Long targetConfirmations = null;
        // Boolean includeWatchonly = null;
        // Boolean includeRemoved = null;
        // undertest.listSinceBlock(blockhash, targetConfirmations, includeWatchonly,
        // includeRemoved);
        // Assert.fail("Test method not implemented");

        BtcRpcListSinceBlockResponse btcRpcListSinceBlockResponse = undertest.listSinceBlock();
        Assert.assertNotNull("Is not null", btcRpcListSinceBlockResponse);

        List<BtcRpcListSinceBlockTransactionResponse> list = btcRpcListSinceBlockResponse.getTransactions();
        Assert.assertNotNull("Is not null", list);
    }

    /**
     * Test list wallets.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testListWallets() throws Exception {
        List<String> list = undertest.listWallets();
        Assert.assertNotNull("Is not null", list);
    }

    /**
     * Test list wallet dir.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testListWalletDir() throws Exception {
        List<String> list = undertest.listWalletDir();
        Assert.assertNotNull("Is not null", list);
    }

    /**
     * Test load wallet.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testLoadWallet() throws Exception {
        String name = "junit_wallet";
        BtcRpcLoadWalletResponse btcRpcLoadWalletResponse = undertest.loadWallet(name);
        Assert.assertEquals("Expected equals", name, btcRpcLoadWalletResponse.getName());
    }

    /**
     * Test rescan blockchain.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testRescanBlockchain() throws Exception {
        Long startHeight = 1_200_000L;
        Long stopHeight = 1_200_001L;
        Boolean success = undertest.rescanBlockchain(startHeight, stopHeight);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test set hd seed.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSetHdSeed() throws Exception {
        // Boolean condition = undertest.walletPassphrase(PASSPHRASE, 30L);
        // Assert.assertTrue("Ok", condition);
        Boolean newkeypool = true;
        String seed = "5KU3mLycXnrzqG97JzKdjeSQSQMgfJSWZCKoF5TPM2UY8E7c34u";
        undertest.setHdSeed(newkeypool, seed);
        Assert.fail("Test method not implemented");
    }

    /**
     * Test unload wallet.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testUnloadWallet() throws Exception {
        String walletName = "junit_wallet";
        undertest.unloadWallet(walletName);
        Assert.fail("Test method not implemented");
    }

    /**
     * Test wallet lock.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testWalletLock() throws Exception {
        Boolean success = undertest.walletLock();
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test wallet passphrase.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testWalletPassphrase() throws Exception {
        String passphrase = PASSPHRASE;
        Long timeout = 30L;
        Boolean success = undertest.walletPassphrase(passphrase, timeout);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test wallet passphrase change.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testWalletPassphraseChange() throws Exception {
        String oldpassphrase = PASSPHRASE;
        String newpassphrase = PASSPHRASE;
        Boolean success = undertest.walletPassphraseChange(oldpassphrase, newpassphrase);
        Assert.assertTrue("Expected true", success);
    }
}
