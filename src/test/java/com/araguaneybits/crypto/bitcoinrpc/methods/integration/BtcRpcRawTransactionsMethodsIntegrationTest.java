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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.araguaneybits.crypto.bitcoinrpc.constants.EnumEstimateMode;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcRawTransactionsMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletToolsMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.request.BtcRpcCreateRawTransactionInputRequest;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcAnalyzePsbtResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcDecodePsbtResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcDecodeRawTransactionResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcDecodeScriptResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcFinalizePsbtResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcFundRawTransactionResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListUnspentResponse;

/**
 * The Class BtcRpcRawTransactionsMethodsIntegrationTest.
 *
 * @author jestevez
 */
// @Ignore
public class BtcRpcRawTransactionsMethodsIntegrationTest extends AbstractBtcRpcMethodsIntegrationTest {

    /** The undertest. */
    private BtcRpcRawTransactionsMethods undertest;

    /** The btc rpc wallet methods. */
    private BtcRpcWalletMethods btcRpcWalletMethods;

    /** The btc rpc wallet tools methods. */
    private BtcRpcWalletToolsMethods btcRpcWalletToolsMethods;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        undertest = new BtcRpcRawTransactionsMethods(btcRpcGateway);
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
     * Test analyze psbt.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testAnalyzePsbt() throws Exception {
        String psbt = createRawTransactionTool(0, 2, 2, new BigDecimal("0.002"), true);
        BtcRpcAnalyzePsbtResponse btcRpcAnalyzePsbtResponse = undertest.analyzePsbt(psbt);
        Assert.assertNotNull("Expected not null", btcRpcAnalyzePsbtResponse);
    }

    /**
     * Test combine psbt.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testCombinePsbt() throws Exception {
        String[] txs = null;
        undertest.combinePsbt(txs);
        Assert.fail("Test method not implemented");
    }

    /**
     * Test combine raw transaction.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testCombineRawTransaction() throws Exception {
        String rawTx1 = "";
        String rawTx2 = "";

        String[] hexstring = new String[] { rawTx1, rawTx2 };
        String sigHex = undertest.combineRawTransaction(hexstring);
        // Assert.assertNotNull("Is not null", sigHex);
        Assert.fail("Test method not implemented");
    }

    /**
     * Test convert to psbt.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testConvertToPsbt() throws Exception {
        String hexstring = createRawTransactionTool(0, 2, 2, new BigDecimal("0.002"), false);
        Boolean permitsigdata = true;
        Boolean iswitness = false;
        String psbt = undertest.convertToPsbt(hexstring, permitsigdata, iswitness);
        Assert.assertNotNull("Expected psbt", psbt);
    }

    /**
     * Test createpsbt.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testCreatepsbt() throws Exception {
        String hexstring = createRawTransactionTool(0, 2, 2, new BigDecimal("0.002"), true);
        Assert.assertNotNull("Expected hexstring", hexstring);
    }

    /**
     * Creates the raw transaction tool.
     *
     * @param startInputs the start inputs
     * @param maxInputs the max inputs
     * @param maxOutputs the max outputs
     * @param amount the amount
     * @param isPsbt the is psbt
     * @return the string
     */
    private String createRawTransactionTool(int startInputs, int maxInputs, int maxOutputs, BigDecimal amount, Boolean isPsbt) {
        Long minconf = null;
        Long maxconf = null;
        String[] addresses = null;
        Boolean includeUnsafe = null;
        Object queryOptions = null;
        List<BtcRpcListUnspentResponse> list = btcRpcWalletMethods.listUnspent(minconf, maxconf, addresses, includeUnsafe, queryOptions);

        List<BtcRpcCreateRawTransactionInputRequest> inputs = new ArrayList<>();

        BigDecimal sending = BigDecimal.ZERO;
        BigDecimal value = BigDecimal.ZERO;
        int i = 0;
        for (int index = startInputs; index < list.size(); index++) {
            BtcRpcListUnspentResponse btcRpcListUnspentResponse = list.get(index);
            BtcRpcCreateRawTransactionInputRequest btcRpcCreateRawTransactionInputRequest = new BtcRpcCreateRawTransactionInputRequest();
            btcRpcCreateRawTransactionInputRequest.setTxid(btcRpcListUnspentResponse.getTxid());
            btcRpcCreateRawTransactionInputRequest.setVout(btcRpcListUnspentResponse.getVout());

            value = value.add(btcRpcListUnspentResponse.getAmount());
            inputs.add(btcRpcCreateRawTransactionInputRequest);
            if (i == maxInputs) {
                break;
            }
            i++;
        }

        Map<String, String> outputs = new HashMap<>();
        for (int j = 0; j < maxOutputs; j++) {
            outputs.put(btcRpcWalletMethods.getNewAddress(), amount.toString());
            sending = sending.add(amount);
        }

        BigDecimal fee = new BigDecimal("0.00000500");
        BigDecimal change = value.subtract(sending).subtract(fee);
        outputs.put(btcRpcWalletMethods.getNewAddress(), change.toString());

        btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);

        Long locktime = 1000L;
        Boolean replaceable = false;
        String rawTx = null;

        if (isPsbt) {
            rawTx = undertest.createPsbt(inputs, outputs, locktime, replaceable);
        } else {
            rawTx = undertest.createRawTransaction(inputs, outputs, locktime, replaceable);
        }

        Assert.assertNotNull("Is not null", rawTx);
        return rawTx;
    }

    /**
     * Test create raw transaction.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testCreateRawTransaction() throws Exception {
        String rawTx = createRawTransactionTool(0, 2, 2, new BigDecimal("0.001"), false);
        Assert.assertNotNull("Is not null", rawTx);
    }

    /**
     * Test decode psbt.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testDecodePsbt() throws Exception {
        String psbt = "cHNidP8BAMUCAAAAAwDqEy7KDCfn2yaLj/Mdj7JUZiNE3a9utaLvmfhtqJTRAQAAAAD9////DgCV8ewPvX2V4vVXiRgUHznDmgLPTOoAXG2yjDqGkQwAAAAAAP3///8OAJXx7A+9fZXi9VeJGBQfOcOaAs9M6gBcbbKMOoaRDAEAAAAA/f///wJADQMAAAAAABepFM3/LG9AKDFoMu5gkE5cwa/oAxvPh0ANAwAAAAAAF6kUaC0uzdTRbxPi447gY1tBZCEBXGiHAAAAAAAAAAAAAA==";
        BtcRpcDecodePsbtResponse btcRpcDecodePsbtResponse = undertest.decodePsbt(psbt);
        Assert.assertEquals("Expected equals", "032e734457e3ddabef166d2d22795b8a221566be6c8040c24f0aa86f06712180",
                btcRpcDecodePsbtResponse.getTx().getTxid());
    }

    /**
     * Test decode raw transaction.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testDecodeRawTransaction() throws Exception {
        String hexstring = "02000000030e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c0000000000fdffffff0e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c0100000000fdffffff1bcadbdc7799d9340435c46e4440a7c65848a7ffc723cb76618853665ef152650100000000fdffffff0240420f000000000017a9147c1f3a5f66371ae4c739b87893b6eeb44e62705e8740420f000000000017a914c3295dc26a6594f0ed2498356ad6bc5fab5284138700000000";
        Boolean iswitness = false;
        BtcRpcDecodeRawTransactionResponse btcRpcDecodeRawTransactionResponse = undertest.decodeRawTransaction(hexstring, iswitness);
        Assert.assertEquals("Expected equals", "a8539fb17c154a0283e18af1b839ac2712720f58ab68cbc5ae179d17568c2453",
                btcRpcDecodeRawTransactionResponse.getTxid());
    }

    /**
     * Test decode script.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testDecodeScript() throws Exception {
        String hexstring = "02000000000102ee731a2a5ebfce28016b2ed5c2c1a285d00bf3e4700a4d1105abc293ace735980100000017160014b70358715715053f37922c198a37fba6ded2717dfdffffff48a357bf51f2762c0ef8a835e297d460befbeef45d2be2448e7619d243c528cd010000006a4730440220790c02a6dcb772e85cde6cb9e6ee6d8e627a911322fd20d9b42ce41dd23c1cab02203d1552997405731608856e5d2471802cc68aea193c6ea2941c89fd4b0b47ad23012103bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5fdffffff0240420f000000000017a914dc78ebea77167883abc76874094278e38eab17b087b2bd10000000000017a914c76c5adaf4d86875da869fef462f116f38d1e4b087024730440220196a4767fcb1822bdeeab751f8cc0a93f753da6bf6efd65d1b5cc95398a650d60220324cb15361995ea59139fac847999c1e712ddfc86bdf236b1dfc0f4b3084667c012102041818a3ef65ab8972cf2a35491753ad0aa9cadaaa947acf637db152f0eb196c00389b1800";
        BtcRpcDecodeScriptResponse btcRpcDecodeScriptResponse = undertest.decodeScript(hexstring);
        Assert.assertEquals("Expected equals", "2MsL6cE7YeQ9SyZaq5g5cSKcxAdAzw4kxwt", btcRpcDecodeScriptResponse.getP2sh());
    }

    /**
     * Test finalize psbt.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testFinalizePsbt() throws Exception {
        String psbt = "cHNidP8BAMUCAAAAAwDqEy7KDCfn2yaLj/Mdj7JUZiNE3a9utaLvmfhtqJTRAQAAAAD9////DgCV8ewPvX2V4vVXiRgUHznDmgLPTOoAXG2yjDqGkQwAAAAAAP3///8OAJXx7A+9fZXi9VeJGBQfOcOaAs9M6gBcbbKMOoaRDAEAAAAA/f///wJADQMAAAAAABepFM3/LG9AKDFoMu5gkE5cwa/oAxvPh0ANAwAAAAAAF6kUaC0uzdTRbxPi447gY1tBZCEBXGiHAAAAAAAAAAAAAA==";
        Boolean extract = true;
        BtcRpcFinalizePsbtResponse btcRpcFinalizePsbtResponse = undertest.finalizePsbt(psbt, extract);
        Assert.assertEquals("Expected equals", psbt, btcRpcFinalizePsbtResponse.getPsbt());
    }

    /**
     * Test fund raw transaction.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testFundRawTransaction() throws Exception {
        String rawTx = createRawTransactionTool(0, 2, 2, new BigDecimal("0.001"), false);
        BtcRpcFundRawTransactionResponse btcRpcFundRawTransactionResponse = undertest.fundRawTransaction(rawTx);
        Assert.assertNotNull("Is not null", btcRpcFundRawTransactionResponse);
    }

    /**
     * Test get raw transaction.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetRawTransaction() throws Exception {
        String toAddress = btcRpcWalletMethods.getNewAddress();
        BigDecimal amount = new BigDecimal("0.010");
        String comment = "";
        String commentTo = "";
        Boolean subtractFeeFromAmount = false;
        Boolean replaceable = true;
        Long confTarget = 1L;
        btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);

        String txid = btcRpcWalletMethods.sendToAddress(toAddress, amount, comment, commentTo, subtractFeeFromAmount, replaceable, confTarget,
                EnumEstimateMode.CONSERVATIVE);
        Assert.assertNotNull("Expected new txid", txid);

        Boolean verbose = true;
        String blockhash = "";
        BtcRpcDecodeRawTransactionResponse btcRpcDecodeRawTransactionResponse = undertest.getRawTransaction(txid, verbose, blockhash);
        Assert.assertNotNull("Is not null", btcRpcDecodeRawTransactionResponse);
    }

    /**
     * Test joinpsbts.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testJoinpsbts() throws Exception {
        String hex1 = "";

        String hex2 = "";

        String[] txs = new String[] { hex1, hex2 };
        undertest.joinPsbts(txs);
        Assert.fail("Test method not implemented");
    }

    /**
     * Test send raw transaction.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSendRawTransaction() throws Exception {
        String rawTx = createRawTransactionTool(0, 2, 2, new BigDecimal("0.001"), false);

        String tx = undertest.sendRawTransaction(rawTx, new BigDecimal("0.00003000"));
        Assert.assertNotNull("Is not null", tx);
    }

    /**
     * Test signrawtransactionwithkey.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSignrawtransactionwithkey() throws Exception {
        undertest.signrawtransactionwithkey();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test testmempoolaccept.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testTestmempoolaccept() throws Exception {
        undertest.testmempoolaccept();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test utxoupdatepsbt.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testUtxoupdatepsbt() throws Exception {
        undertest.utxoupdatepsbt();
        Assert.fail("Test method not implemented");
    }
}
