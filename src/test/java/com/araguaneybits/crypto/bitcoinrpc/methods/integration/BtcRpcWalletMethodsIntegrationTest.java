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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;

import com.araguaneybits.crypto.bitcoinrpc.constants.EnumAddressType;
import com.araguaneybits.crypto.bitcoinrpc.constants.EnumEstimateMode;
import com.araguaneybits.crypto.bitcoinrpc.constants.EnumRpcErrorCode;
import com.araguaneybits.crypto.bitcoinrpc.exception.BtcRpcBaseException;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcRawTransactionsMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletToolsMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.request.BtcRpcCreateRawTransactionInputRequest;
import com.araguaneybits.crypto.bitcoinrpc.methods.request.BtcRpcLockUnspentRequest;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcAddMultiSigAddressResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcBumpFeeResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetAddressInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetAddressesByLabelResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetTransactionResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListReceivedByLabelResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListUnspentResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcReceivedByAddressResponse;

/**
 * The Class BtcRpcWalletMethodsIntegrationTest.
 *
 * @author jestevez
 */
@Ignore
public class BtcRpcWalletMethodsIntegrationTest extends AbstractBtcRpcMethodsIntegrationTest {

    /** The undertest. */
    private BtcRpcWalletMethods undertest;

    /** The btc rpc wallet tools methods. */
    private BtcRpcWalletToolsMethods btcRpcWalletToolsMethods;

    /** The btc rpc raw transactions methods. */
    private BtcRpcRawTransactionsMethods btcRpcRawTransactionsMethods;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        undertest = new BtcRpcWalletMethods(btcRpcGateway);
        btcRpcWalletToolsMethods = new BtcRpcWalletToolsMethods(btcRpcGateway);
        btcRpcRawTransactionsMethods = new BtcRpcRawTransactionsMethods(btcRpcGateway);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {

    }

    /**
     * Test abandon transaction.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testAbandonTransaction() throws Exception {
        // String toAddress = undertest.getNewAddress();
        //
        // Boolean condition = btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);
        // Assert.assertTrue("Ok", condition);
        //
        // BigDecimal amount = new BigDecimal("0.00001101");
        // String comment = "";
        // String commentTo = "";
        // Boolean subtractFeeFromAmount = true;
        // Boolean replaceable = true;
        // Long confTarget = 10L;
        // String txid = undertest.sendToAddress(toAddress, amount, comment, commentTo, subtractFeeFromAmount, replaceable, confTarget,
        // EnumEstimateMode.ECONOMICAL);
        // Assert.assertNotNull("Expected new txid", txid);
        //
        // undertest.abandonTransaction(txid);

        try {
            undertest.abandonTransaction("6661dc54a1bd8c2e359192fdc4f3f0d5f74ea963629f731ef61f7a40c1260265");
            Assert.fail("Expected exception");
        } catch (BtcRpcBaseException e) {
            Assert.assertEquals("Expected code -5", EnumRpcErrorCode.RPC_INVALID_ADDRESS_OR_KEY.getCode(), e.getCode());
        }
    }

    /**
     * Test add multi sig address.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testAddMultiSigAddress() throws Exception {
        Long nrequired = 2L;
        String[] keys = new String[] { "03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5",
                "03a0fdbc70f0e34110797be4a872291565796b2121c7b9abc831ec27d051e4aec2" };
        String label = "MultiSigAddress";
        BtcRpcAddMultiSigAddressResponse btcRpcAddMultiSigAddressResponse = undertest.addMultiSigAddress(nrequired, keys, label,
                EnumAddressType.LEGACY);
        Assert.assertEquals("Expected MultiSigAddress", "2Mz9xyBuBVeT25Hs642ncEGcKduX3p6uuTH", btcRpcAddMultiSigAddressResponse.getAddress());
    }

    /**
     * Test bumpfee.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testBumpfee() throws Exception {
        btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);

        String toAddress = undertest.getNewAddress();
        String txid = undertest.sendToAddress(toAddress, new BigDecimal("0.11111111"), "bumpfee-" + System.currentTimeMillis(), "", true, true, 3L,
                EnumEstimateMode.CONSERVATIVE);

        BtcRpcBumpFeeResponse btcRpcBumpFeeResponse = undertest.bumpFee(txid);

        Assert.assertNotEquals("Expected new txid", txid, btcRpcBumpFeeResponse.getTxid());
    }

    /**
     * Test dump privkey.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testDumpPrivkey() throws Exception {
        String address = undertest.getNewAddress();
        btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);
        String privkey = undertest.dumpPrivkey(address);
        Assert.assertNotNull("Expected not null", privkey);
    }

    /**
     * Test get addresses by label.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetAddressesByLabel() throws Exception {
        String label = UUID.randomUUID().toString();
        String address = undertest.getNewAddress(label, EnumAddressType.LEGACY);

        BtcRpcGetAddressesByLabelResponse btcRpcGetAddressesByLabelResponse = undertest.getAddressesByLabel(label);
        Assert.assertEquals("expected address", address, btcRpcGetAddressesByLabelResponse.getAddress());
    }

    /**
     * Test get address info.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetAddressInfo() throws Exception {
        String address = undertest.getNewAddress();
        BtcRpcGetAddressInfoResponse btcRpcGetAddressInfoResponse = undertest.getAddressInfo(address);
        Assert.assertEquals("expected address", address, btcRpcGetAddressInfoResponse.getAddress());
    }

    /**
     * Test get balance.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetBalance() throws Exception {
        BigDecimal balance = undertest.getBalance();
        Assert.assertNotNull("Is not null", balance);
    }

    /**
     * Test get new address.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetNewAddress() throws Exception {
        String address = undertest.getNewAddress();
        Assert.assertNotNull("Is not null", address);
    }

    /**
     * Test get raw change address.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetRawChangeAddress() throws Exception {
        String address = undertest.getRawChangeAddress(EnumAddressType.LEGACY);
        Assert.assertNotNull("Is not null", address);
    }

    /**
     * Test get received by address.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetReceivedByAddress() throws Exception {
        String address = undertest.getNewAddress();
        Integer minconf = 1;
        BigDecimal balance = undertest.getReceivedByAddress(address, minconf);
        Assert.assertNotNull("Is not null", balance);
    }

    /**
     * Test get received by label.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetReceivedByLabel() throws Exception {
        String label = "bb619c12-9653-45a8-808d-0dfa3179f924";
        Integer minconf = 1;
        BigDecimal balance = undertest.getReceivedByLabel(label, minconf);
        Assert.assertNotNull("Is not null", balance);
    }

    /**
     * Test get transaction.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetTransaction() throws Exception {
        String toAddress = undertest.getNewAddress();

        Boolean condition = btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);
        Assert.assertTrue("Ok", condition);

        BigDecimal amount = new BigDecimal("0.00001101");
        String comment = "";
        String commentTo = "";
        Boolean subtractFeeFromAmount = true;
        Boolean replaceable = true;
        Long confTarget = 10L;
        String txid = undertest.sendToAddress(toAddress, amount, comment, commentTo, subtractFeeFromAmount, replaceable, confTarget,
                EnumEstimateMode.ECONOMICAL);
        Assert.assertNotNull("Expected new txid", txid);

        BtcRpcGetTransactionResponse btcRpcGetTransactionResponse = undertest.getTransaction(txid);
        Assert.assertEquals("expected txid", txid, btcRpcGetTransactionResponse.getTxid());
    }

    /**
     * Test get unconfirmed balance.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetUnconfirmedBalance() throws Exception {
        BigDecimal balance = undertest.getUnconfirmedBalance();
        Assert.assertNotNull("Is not null", balance);
    }

    /**
     * Test import address.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testImportAddress() throws Exception {
        String address = "mhfs2qAB5DZd6ri8DU9rNxENasNM2pXTdY";
        String label = "";
        Boolean rescan = false;
        Boolean p2sh = false;
        Boolean success = undertest.importAddress(address, label, rescan, p2sh);

        Assert.assertTrue("Expected success", success);
    }

    /**
     * Test importmulti.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testImportmulti() throws Exception {
        undertest.importmulti();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test import priv key.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testImportPrivKey() throws Exception {
        btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);

        String privkey = "cW1eVuRBUpfHkvkcRGhXu46dmWN9aG8UxMUfAGWA6awtYpkUMTy5";
        String label = "pk";
        Boolean rescan = true;
        Boolean success = undertest.importPrivKey(privkey, label, rescan);
        Assert.assertTrue("Expected success", success);
    }

    /**
     * Test import pruned funds.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testImportPrunedFunds() throws Exception {
        String rawtransaction = null;
        String txoutproof = null;
        undertest.importPrunedFunds(rawtransaction, txoutproof);
        Assert.fail("Test method not implemented");
    }

    /**
     * Test import pubkey.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testImportPubkey() throws Exception {
        String pubkey = null;
        String label = null;
        Boolean rescan = null;
        undertest.importPubkey(pubkey, label, rescan);
        Assert.fail("Test method not implemented");
    }

    /**
     * Test list received by address.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testListReceivedByAddress() throws Exception {
        List<BtcRpcReceivedByAddressResponse> list = undertest.listReceivedByAddress();
        Assert.assertNotNull("expected list", list);
    }

    /**
     * Test list labels.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testListLabels() throws Exception {
        String purpose = null;
        List<String> list = undertest.listLabels(purpose);
        Assert.assertNotNull("expected list", list);
    }

    /**
     * Test list lock unspent.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testListLockUnspent() throws Exception {
        undertest.listLockUnspent();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test list received by label.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testListReceivedByLabel() throws Exception {
        Long minconf = null;
        Boolean includeEmpty = null;
        Boolean includeWatchonly = null;
        List<BtcRpcListReceivedByLabelResponse> list = undertest.listReceivedByLabel(minconf, includeEmpty, includeWatchonly);
        Assert.assertNotNull("expected list", list);
    }

    /**
     * Test list transactions.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testListTransactions() throws Exception {
        String dummy = null;
        Long count = null;
        Long skip = null;
        Boolean includeWatchonly = null;
        List<BtcRpcGetTransactionResponse> list = undertest.listTransactions(dummy, count, skip, includeWatchonly);
        Assert.assertNotNull("expected list", list);
    }

    /**
     * Test list unspent.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testListUnspent() throws Exception {
        Long minconf = null;
        Long maxconf = null;
        String[] addresses = null;
        Boolean includeUnsafe = null;
        Object queryOptions = null;
        List<BtcRpcListUnspentResponse> list = undertest.listUnspent(minconf, maxconf, addresses, includeUnsafe, queryOptions);
        Assert.assertNotNull("expected list", list);
    }

    /**
     * Test lock unspent.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testLockUnspent() throws Exception {
        Boolean unlock = false;
        BtcRpcLockUnspentRequest btcRpcLockUnspentRequest = new BtcRpcLockUnspentRequest();
        btcRpcLockUnspentRequest.setTxid("d194a86df899efa2b56eafdd44236654b28f1df38f8b26dbe7270cca2e13ea00");
        btcRpcLockUnspentRequest.setVout(1L);

        List<BtcRpcLockUnspentRequest> transactions = new ArrayList<>();
        transactions.add(btcRpcLockUnspentRequest);
        Boolean isLock = undertest.lockUnspent(unlock, transactions);
        Assert.assertTrue("Expected true", isLock);
    }

    /**
     * Test remove pruned funds.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testRemovePrunedFunds() throws Exception {
        String txid = null;
        undertest.removePrunedFunds(txid);
        Assert.fail("Test method not implemented");
    }

    /**
     * Test sendmany.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSendmany() throws Exception {
        Map<String, String> amounts = new HashMap<>();
        amounts.put(undertest.getNewAddress(), "0.01");
        amounts.put(undertest.getNewAddress(), "0.01");

        Integer minconf = 1;
        String comment = "Send to many";
        String[] subtractFeeFrom = new String[] { "", "" };
        Boolean replaceable = true;
        Long confTarget = 1L;
        EnumEstimateMode enumEstimateMode = EnumEstimateMode.CONSERVATIVE;

        btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);
        String tx = undertest.sendMany(amounts, minconf, comment, subtractFeeFrom, replaceable, confTarget, enumEstimateMode);
        Assert.assertNotNull("expected tx", tx);
    }

    /**
     * Test send to address.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSendToAddress() throws Exception {
        String toAddress = undertest.getNewAddress();
        BigDecimal amount = new BigDecimal("0.010");
        String comment = "";
        String commentTo = "";
        Boolean subtractFeeFromAmount = false;
        Boolean replaceable = true;
        Long confTarget = 1L;
        btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);

        String txid = undertest.sendToAddress(toAddress, amount, comment, commentTo, subtractFeeFromAmount, replaceable, confTarget,
                EnumEstimateMode.CONSERVATIVE);
        Assert.assertNotNull("Expected new txid", txid);
    }

    /**
     * Test set label.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSetLabel() throws Exception {
        String address = undertest.getNewAddress();
        String label = UUID.randomUUID().toString();
        Boolean success = undertest.setLabel(address, label);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test set tx fee.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSetTxFee() throws Exception {
        BigDecimal amount = new BigDecimal("0.0001");
        Boolean success = undertest.setTxFee(amount);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test sign message.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSignMessage() throws Exception {
        String address = undertest.getNewAddress("", EnumAddressType.LEGACY);
        String message = "Hello World";

        btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);

        String signature = undertest.signMessage(address, message);
        Assert.assertNotNull("Expected not null", signature);
    }

    /**
     * Test sign raw transaction with wallet.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSignRawTransactionWithWallet() throws Exception {
        Long minconf = null;
        Long maxconf = null;
        String[] addresses = null;
        Boolean includeUnsafe = null;
        Object queryOptions = null;
        List<BtcRpcListUnspentResponse> list = undertest.listUnspent(minconf, maxconf, addresses, includeUnsafe, queryOptions);

        List<BtcRpcCreateRawTransactionInputRequest> inputs = new ArrayList<>();
        int i = 0;
        for (BtcRpcListUnspentResponse btcRpcListUnspentResponse : list) {
            BtcRpcCreateRawTransactionInputRequest btcRpcCreateRawTransactionInputRequest = new BtcRpcCreateRawTransactionInputRequest();
            btcRpcCreateRawTransactionInputRequest.setTxid(btcRpcListUnspentResponse.getTxid());
            btcRpcCreateRawTransactionInputRequest.setVout(btcRpcListUnspentResponse.getVout());
            inputs.add(btcRpcCreateRawTransactionInputRequest);
            if (i == 2) {
                break;
            }
            i++;
        }

        Map<String, String> outputs = new HashMap<>();
        outputs.put(undertest.getNewAddress(), "0.01");
        outputs.put(undertest.getNewAddress(), "0.01");

        Long locktime = 0L;
        Boolean replaceable = true;

        btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);

        String rawTx = btcRpcRawTransactionsMethods.createRawTransaction(inputs, outputs, locktime, replaceable);

        String hex = undertest.signRawTransactionWithWallet(rawTx);
        Assert.assertNotNull("Is not null", hex);
    }

    /**
     * Test walletcreatefundedpsbt.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testWalletcreatefundedpsbt() throws Exception {
        undertest.walletcreatefundedpsbt();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test walletprocesspsbt.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testWalletprocesspsbt() throws Exception {
        undertest.walletprocesspsbt();
        Assert.fail("Test method not implemented");
    }
}
