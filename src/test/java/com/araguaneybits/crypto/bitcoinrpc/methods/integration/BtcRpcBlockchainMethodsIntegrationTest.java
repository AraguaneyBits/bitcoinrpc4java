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
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcBlockchainMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockHeaderResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockWithTxResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockchainInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetChainTipsResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetChainTxStatsResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetMempoolEntryResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetMempoolInfoResponse;

/**
 * The Class BtcRpcBlockchainMethodsIntegrationTest.
 *
 * @author jestevez
 */
@Ignore
public class BtcRpcBlockchainMethodsIntegrationTest extends AbstractBtcRpcMethodsIntegrationTest {

    /** The undertest. */
    private BtcRpcBlockchainMethods undertest;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        undertest = new BtcRpcBlockchainMethods(btcRpcGateway);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {

    }

    /**
     * Test get best block hash.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetBestBlockHash() throws Exception {
        String hash = undertest.getBestBlockHash();
        Assert.assertNotNull("Is not null", hash);
    }

    /**
     * Test get block.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetBlock() throws Exception {
        String blockhash = "00000000000001dff89d2ea594ce664cd675de5f8eb3762f0364dcf0e0095378";
        String hex = undertest.getBlock(blockhash);
        Assert.assertNotNull("Is not null", hex);

        BtcRpcGetBlockResponse btcRpcGetBlockResponse = undertest.getBlockObject(blockhash);
        Assert.assertEquals("Expected block", blockhash, btcRpcGetBlockResponse.getHash());

        BtcRpcGetBlockWithTxResponse blockWithTxResponse = undertest.getBlockObjectWithTx(blockhash);
        Assert.assertNotNull("Is not null", blockWithTxResponse.getTx());
    }

    /**
     * Test get blockchain info.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetBlockchainInfo() throws Exception {
        BtcRpcGetBlockchainInfoResponse btcRpcBlockchainInfoResponse = undertest.getBlockchainInfo();
        Assert.assertNotNull("Is not null", btcRpcBlockchainInfoResponse);
    }

    /**
     * Test get block count.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetBlockCount() throws Exception {
        BigInteger blocks = undertest.getBlockCount();
        Assert.assertNotNull("Is not null", blocks);
    }

    /**
     * Test get block hash.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetBlockHash() throws Exception {
        String hash = undertest.getBlockHash(0L);
        Assert.assertEquals("Expected equals", "000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943", hash);
    }

    /**
     * Test get block header.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetBlockHeader() throws Exception {
        String hex = undertest.getBlockHeaderHex("000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943");
        Assert.assertNotNull("Is not null", hex);
        BtcRpcGetBlockHeaderResponse btcRpcGetBlockHeaderResponse = undertest
                .getBlockHeader("000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943");
        Assert.assertNotNull("Is not null", btcRpcGetBlockHeaderResponse);
    }

    /**
     * Test get block stats.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetBlockStats() throws Exception {
        // TODO pending
        // {"result":null,"error":{"code":-8,"message":"One or more of the selected stats requires -txindex enabled"},"id":null}
        undertest.getBlockStats(500000L, (new String[] { "minfeerate", "avgfeerate" }));
    }

    /**
     * Test get chain tips.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetChainTips() throws Exception {
        List<BtcRpcGetChainTipsResponse> list = undertest.getChainTips();
        Assert.assertNotNull("Is not null", list);
    }

    /**
     * Test get chain tx stats.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetChainTxStats() throws Exception {
        BtcRpcGetChainTxStatsResponse btcRpcGetChainTxStatsResponse = undertest.getChainTxStats();
        Assert.assertNotNull("Is not null", btcRpcGetChainTxStatsResponse);
    }

    /**
     * Test get difficulty.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetDifficulty() throws Exception {
        BigDecimal difficulty = undertest.getDifficulty();
        Assert.assertNotNull("Is not null", difficulty);
    }

    /**
     * Test get mempool ancestors.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetMempoolAncestors() throws Exception {
        List<BtcRpcGetMempoolEntryResponse> list = undertest.getMempoolAncestors("03146921f56264ac39bf1d49bc19f3a2827941c188e4c20c65cea3891359a614",
                true);
        Assert.assertNotNull("Is not null", list);
    }

    /**
     * Test get mempool descendants.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetMempoolDescendants() throws Exception {
        List<BtcRpcGetMempoolEntryResponse> list = undertest.getMempoolDescendants("03146921f56264ac39bf1d49bc19f3a2827941c188e4c20c65cea3891359a614",
                true);
        Assert.assertNotNull("Is not null", list);
    }

    /**
     * Test get mempool entry.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetMempoolEntry() throws Exception {

        BtcRpcGetMempoolEntryResponse btcRpcGetMempoolEntryResponse = undertest
                .getMempoolEntry("c540e514dba8266452a30c8c01d39ce734866145539398c31c60d5454c178c89");
        Assert.assertNotNull("Is not null", btcRpcGetMempoolEntryResponse);
    }

    /**
     * Test get mempool info.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetMempoolInfo() throws Exception {
        BtcRpcGetMempoolInfoResponse btcRpcGetMempoolInfoResponse = undertest.getMempoolInfo();
        Assert.assertNotNull("Is not null", btcRpcGetMempoolInfoResponse);
    }

    /**
     * Test get raw mempool.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetRawMempool() throws Exception {
        undertest.getRawMempool();
        undertest.getRawMempoolVerbose();
    }

    /**
     * Test get tx out.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetTxOut() throws Exception {
        undertest.getTxOut("5115cae1985816327e9013e46ec96c02df6f0f3673396c1160a3b0ee9dbb29b0", Long.valueOf(0), true);
    }

    /**
     * Test get tx out proof.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetTxOutProof() throws Exception {
        String data = undertest.getTxOutProof(new String[] { "38b5b894962b20534497dfc536814ebdcd0bfd9dab68bc4ca4d04a09cd6fbc98" },
                "000000000000016711b50488910601f524f5379bcda214d18f8913f2ffe51062");
        Assert.assertNotNull("Is not null", data);
    }

    /**
     * Test get tx out set info.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetTxOutSetInfo() throws Exception {
        Object data = undertest.getTxOutSetInfo();
        Assert.assertNotNull("Is not null", data);
    }

    /**
     * Test precious block.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPreciousBlock() throws Exception {
        Object data = undertest.preciousBlock("000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943");
        Assert.assertNotNull("Is not null", data);
    }

    /**
     * Test prune blockchain.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPruneBlockchain() throws Exception {
        Object data = undertest.pruneBlockchain(500000L);
        Assert.assertNotNull("Is not null", data);
    }

    /**
     * Test save mempool.
     */
    @Test
    public void testSaveMempool() {
        Boolean ok = undertest.saveMempool();
        Assert.assertTrue("Is not save", ok);
    }

    /**
     * Test scan tx out set.
     */
    @Test
    public void testScanTxOutSet() {
        Object data = undertest.scanTxOutSet();
        Assert.assertNotNull("Is not null", data);
    }

    /**
     * Test verify chain.
     */
    @Test
    public void testVerifyChain() {
        Object data = undertest.verifyChain(0, 0);
        Assert.assertNotNull("Is not null", data);
    }

    /**
     * Test verify tx out proof.
     */
    @Test
    public void testVerifyTxOutProof() {
        String data = undertest.getTxOutProof(new String[] { "38b5b894962b20534497dfc536814ebdcd0bfd9dab68bc4ca4d04a09cd6fbc98" },
                "000000000000016711b50488910601f524f5379bcda214d18f8913f2ffe51062");
        Object data2 = undertest.verifyTxOutProof(data);
        Assert.assertNotNull("Is not null", data2);
    }

}
