package com.araguaneybits.crypto.bitcoinrpc.methods;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockHeaderResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockWithTxResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockchainInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetChainTipsResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetChainTxStatsResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetMempoolEntryResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetMempoolInfoResponse;

public class BtcRpcBlockchainMethodsTest extends AbstractBtcRpcMethodsTest {
    private BtcRpcBlockchainMethods undertest;

    @Before
    public void setUp() {
        undertest = new BtcRpcBlockchainMethods(btcRpcGateway);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetBestBlockHash() throws Exception {
        enqueueMockedResponse(200, "{\"result\":\"5abbfa1ab7105d6f39782cdbac470ace776b4c9247eb02f66d1265e732cc499f\",\"error\":null,\"id\":null}");
        String hash = undertest.getBestBlockHash();
        Assert.assertEquals("Expected equals", "5abbfa1ab7105d6f39782cdbac470ace776b4c9247eb02f66d1265e732cc499f", hash);
    }

    @Test
    public void testGetBlock() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":\"01000030c5405c044dab3268a4e9699116046203e9df6e32104e791631df1e02ec32011b4fa538a3e5800a0d69037f91434575da3d66cf5d7a86227d2d609ab4ccf831989c72715dffff7f200000000001020000000001010000000000000000000000000000000000000000000000000000000000000000ffffffff0502ca000101ffffffff0200f90295000000002321030b4404f370b5a5873a2d7634b097eb32d8897f3e0bd495bf1a9b78347c9181a2ac0000000000000000266a24aa21a9ede2f61c3f71d1defd3fa999dfa36953755c690689799962b48bebd836974e8cf90120000000000000000000000000000000000000000000000000000000000000000000000000\",\"error\":null,\"id\":null}");
        String blockhash = "5abbfa1ab7105d6f39782cdbac470ace776b4c9247eb02f66d1265e732cc499f";
        String hex = undertest.getBlock(blockhash);
        Assert.assertNotNull("Is not null", hex);

        enqueueMockedResponse(200,
                "{\"result\":{\"hash\":\"5abbfa1ab7105d6f39782cdbac470ace776b4c9247eb02f66d1265e732cc499f\",\"confirmations\":1,\"strippedsize\":228,\"size\":264,\"weight\":948,\"height\":202,\"version\":805306369,\"versionHex\":\"30000001\",\"merkleroot\":\"9831f8ccb49a602d7d22867a5dcf663dda754543917f03690d0a80e5a338a54f\",\"tx\":[\"9831f8ccb49a602d7d22867a5dcf663dda754543917f03690d0a80e5a338a54f\"],\"time\":1567715996,\"mediantime\":1567715995,\"nonce\":0,\"bits\":\"207fffff\",\"difficulty\":4.656542373906925e-10,\"chainwork\":\"0000000000000000000000000000000000000000000000000000000000000196\",\"nTx\":1,\"previousblockhash\":\"1b0132ec021edf3116794e10326edfe9036204169169e9a46832ab4d045c40c5\"},\"error\":null,\"id\":null}");
        BtcRpcGetBlockResponse btcRpcGetBlockResponse = undertest.getBlockObject(blockhash);
        Assert.assertEquals("Expected block", blockhash, btcRpcGetBlockResponse.getHash());

        enqueueMockedResponse(200,
                "  {\"result\":{\"hash\":\"5abbfa1ab7105d6f39782cdbac470ace776b4c9247eb02f66d1265e732cc499f\",\"confirmations\":1,\"strippedsize\":228,\"size\":264,\"weight\":948,\"height\":202,\"version\":805306369,\"versionHex\":\"30000001\",\"merkleroot\":\"9831f8ccb49a602d7d22867a5dcf663dda754543917f03690d0a80e5a338a54f\",\"tx\":[{\"txid\":\"9831f8ccb49a602d7d22867a5dcf663dda754543917f03690d0a80e5a338a54f\",\"hash\":\"9e87dc5a8f1c412f307686042fed339d410bfac4454bcca75a3d781eb9f16a06\",\"version\":2,\"size\":183,\"vsize\":156,\"weight\":624,\"locktime\":0,\"vin\":[{\"coinbase\":\"02ca000101\",\"sequence\":4294967295}],\"vout\":[{\"value\":25.00000000,\"n\":0,\"scriptPubKey\":{\"asm\":\"030b4404f370b5a5873a2d7634b097eb32d8897f3e0bd495bf1a9b78347c9181a2 OP_CHECKSIG\",\"hex\":\"21030b4404f370b5a5873a2d7634b097eb32d8897f3e0bd495bf1a9b78347c9181a2ac\",\"reqSigs\":1,\"type\":\"pubkey\",\"addresses\":[\"mi5vpRYydDtCJoVcwhtttTpdAoakYHYbXt\"]}},{\"value\":0.00000000,\"n\":1,\"scriptPubKey\":{\"asm\":\"OP_RETURN aa21a9ede2f61c3f71d1defd3fa999dfa36953755c690689799962b48bebd836974e8cf9\",\"hex\":\"6a24aa21a9ede2f61c3f71d1defd3fa999dfa36953755c690689799962b48bebd836974e8cf9\",\"type\":\"nulldata\"}}],\"hex\":\"020000000001010000000000000000000000000000000000000000000000000000000000000000ffffffff0502ca000101ffffffff0200f90295000000002321030b4404f370b5a5873a2d7634b097eb32d8897f3e0bd495bf1a9b78347c9181a2ac0000000000000000266a24aa21a9ede2f61c3f71d1defd3fa999dfa36953755c690689799962b48bebd836974e8cf90120000000000000000000000000000000000000000000000000000000000000000000000000\"}],\"time\":1567715996,\"mediantime\":1567715995,\"nonce\":0,\"bits\":\"207fffff\",\"difficulty\":4.656542373906925e-10,\"chainwork\":\"0000000000000000000000000000000000000000000000000000000000000196\",\"nTx\":1,\"previousblockhash\":\"1b0132ec021edf3116794e10326edfe9036204169169e9a46832ab4d045c40c5\"},\"error\":null,\"id\":null}");

        BtcRpcGetBlockWithTxResponse blockWithTxResponse = undertest.getBlockObjectWithTx(blockhash);
        Assert.assertNotNull("Is not null", blockWithTxResponse.getTx());
        Assert.assertEquals("Expected block", "9e87dc5a8f1c412f307686042fed339d410bfac4454bcca75a3d781eb9f16a06",
                blockWithTxResponse.getTx().get(0).getHash());

    }

    @Test
    public void testGetBlockchainInfo() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"chain\":\"regtest\",\"blocks\":202,\"headers\":202,\"bestblockhash\":\"5abbfa1ab7105d6f39782cdbac470ace776b4c9247eb02f66d1265e732cc499f\",\"difficulty\":4.656542373906925e-10,\"mediantime\":1567715995,\"verificationprogress\":1,\"initialblockdownload\":true,\"chainwork\":\"0000000000000000000000000000000000000000000000000000000000000196\",\"size_on_disk\":63376,\"pruned\":false,\"softforks\":[{\"id\":\"bip34\",\"version\":2,\"reject\":{\"status\":false}},{\"id\":\"bip66\",\"version\":3,\"reject\":{\"status\":false}},{\"id\":\"bip65\",\"version\":4,\"reject\":{\"status\":false}}],\"bip9_softforks\":{\"csv\":{\"status\":\"started\",\"bit\":0,\"startTime\":0,\"timeout\":9223372036854775807,\"since\":144,\"statistics\":{\"period\":144,\"threshold\":108,\"elapsed\":59,\"count\":59,\"possible\":true}},\"segwit\":{\"status\":\"active\",\"startTime\":-1,\"timeout\":9223372036854775807,\"since\":0}},\"warnings\":\"\"},\"error\":null,\"id\":null}");
        BtcRpcGetBlockchainInfoResponse btcRpcBlockchainInfoResponse = undertest.getBlockchainInfo();
        Assert.assertNotNull("Is not null", btcRpcBlockchainInfoResponse);
    }

    @Test
    public void testGetBlockCount() throws Exception {
        enqueueMockedResponse(200, "{\"result\":202,\"error\":null,\"id\":null}");
        BigInteger blocks = undertest.getBlockCount();
        Assert.assertEquals("Expected 202", new BigInteger("202"), blocks);

    }

    @Test
    public void testGetBlockHash() throws Exception {
        enqueueMockedResponse(200, "{\"result\":\"0f9188f13cb7b2c71f2a335e3a4fc328bf5beb436012afca590b1a11466e2206\",\"error\":null,\"id\":null}");
        String hash = undertest.getBlockHash(0L);
        Assert.assertEquals("Expected equals", "0f9188f13cb7b2c71f2a335e3a4fc328bf5beb436012afca590b1a11466e2206", hash);

    }

    @Test
    public void testGetBlockHeader() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":\"0100000000000000000000000000000000000000000000000000000000000000000000003ba3edfd7a7b12b27ac72c3e67768f617fc81bc3888a51323a9fb8aa4b1e5e4adae5494dffff7f2002000000\",\"error\":null,\"id\":null}");
        String hex = undertest.getBlockHeaderHex("0f9188f13cb7b2c71f2a335e3a4fc328bf5beb436012afca590b1a11466e2206");
        Assert.assertNotNull("Is not null", hex);

        enqueueMockedResponse(200,
                "{\"result\":{\"hash\":\"0f9188f13cb7b2c71f2a335e3a4fc328bf5beb436012afca590b1a11466e2206\",\"confirmations\":203,\"height\":0,\"version\":1,\"versionHex\":\"00000001\",\"merkleroot\":\"4a5e1e4baab89f3a32518a88c31bc87f618f76673e2cc77ab2127b7afdeda33b\",\"time\":1296688602,\"mediantime\":1296688602,\"nonce\":2,\"bits\":\"207fffff\",\"difficulty\":4.656542373906925e-10,\"chainwork\":\"0000000000000000000000000000000000000000000000000000000000000002\",\"nTx\":1,\"nextblockhash\":\"64412c1fa9a996527463a0bedbe5972ed14a1813b5f0edb8e48eb863cf143647\"},\"error\":null,\"id\":null}");
        BtcRpcGetBlockHeaderResponse btcRpcGetBlockHeaderResponse = undertest
                .getBlockHeader("0f9188f13cb7b2c71f2a335e3a4fc328bf5beb436012afca590b1a11466e2206");
        Assert.assertNotNull("Is not null", btcRpcGetBlockHeaderResponse);
    }

    // @Test
    public void testGetBlockStats() throws Exception {
        // TODO pending
        // {"result":null,"error":{"code":-8,"message":"One or more of the selected stats requires -txindex enabled"},"id":null}
        // undertest.getBlockStats("0f9188f13cb7b2c71f2a335e3a4fc328bf5beb436012afca590b1a11466e2206");
    }

    @Test
    public void testGetChainTips() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":[{\"height\":202,\"hash\":\"5abbfa1ab7105d6f39782cdbac470ace776b4c9247eb02f66d1265e732cc499f\",\"branchlen\":0,\"status\":\"active\"}],\"error\":null,\"id\":null}");
        List<BtcRpcGetChainTipsResponse> list = undertest.getChainTips();
        Assert.assertNotNull("Is not null", list);
    }

    @Test
    public void testGetChainTxStats() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"time\":1567715996,\"txcount\":203,\"window_final_block_hash\":\"5abbfa1ab7105d6f39782cdbac470ace776b4c9247eb02f66d1265e732cc499f\",\"window_block_count\":201,\"window_tx_count\":201,\"window_interval\":4092,\"txrate\":0.04912023460410557},\"error\":null,\"id\":null}");
        BtcRpcGetChainTxStatsResponse btcRpcGetChainTxStatsResponse = undertest.getChainTxStats();
        Assert.assertEquals("Expected equals", Long.valueOf(203), btcRpcGetChainTxStatsResponse.getTxcount());
    }

    @Test
    public void testGetDifficulty() throws Exception {
        enqueueMockedResponse(200, "{\"result\":4.656542373906925e-10,\"error\":null,\"id\":null}");
        BigDecimal difficulty = undertest.getDifficulty();
        Assert.assertEquals("Expected equals", new BigDecimal("4.656542373906925e-10"), difficulty);
    }

    @Test
    public void testGetMempoolAncestors() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"c10bb22a91f59aeb7d81a19ead4a05a8c5c2c3bcda4ba09fb8194895f5ad8211\":{\"fees\":{\"base\":0.00003780,\"modified\":0.00003780,\"ancestor\":0.00003780,\"descendant\":0.00007980},\"size\":189,\"fee\":0.00003780,\"modifiedfee\":0.00003780,\"time\":1568918380,\"height\":202,\"descendantcount\":2,\"descendantsize\":357,\"descendantfees\":7980,\"ancestorcount\":1,\"ancestorsize\":189,\"ancestorfees\":3780,\"wtxid\":\"c10bb22a91f59aeb7d81a19ead4a05a8c5c2c3bcda4ba09fb8194895f5ad8211\",\"depends\":[],\"spentby\":[\"03146921f56264ac39bf1d49bc19f3a2827941c188e4c20c65cea3891359a614\"],\"bip125-replaceable\":true}},\"error\":null,\"id\":null}");
        List<BtcRpcGetMempoolEntryResponse> list = undertest.getMempoolAncestors("03146921f56264ac39bf1d49bc19f3a2827941c188e4c20c65cea3891359a614",
                true);
        BtcRpcGetMempoolEntryResponse btcRpcGetMempoolEntryResponse = list.get(0);
        Assert.assertNotNull("Is not null", btcRpcGetMempoolEntryResponse);
        Assert.assertEquals("Expected equals", Long.valueOf(189), btcRpcGetMempoolEntryResponse.getSize());
    }

    @Test
    public void testGetMempoolDescendants() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"c10bb22a91f59aeb7d81a19ead4a05a8c5c2c3bcda4ba09fb8194895f5ad8211\":{\"fees\":{\"base\":0.00003780,\"modified\":0.00003780,\"ancestor\":0.00003780,\"descendant\":0.00007980},\"size\":189,\"fee\":0.00003780,\"modifiedfee\":0.00003780,\"time\":1568918380,\"height\":202,\"descendantcount\":2,\"descendantsize\":357,\"descendantfees\":7980,\"ancestorcount\":1,\"ancestorsize\":189,\"ancestorfees\":3780,\"wtxid\":\"c10bb22a91f59aeb7d81a19ead4a05a8c5c2c3bcda4ba09fb8194895f5ad8211\",\"depends\":[],\"spentby\":[\"03146921f56264ac39bf1d49bc19f3a2827941c188e4c20c65cea3891359a614\"],\"bip125-replaceable\":true}},\"error\":null,\"id\":null}");

        List<BtcRpcGetMempoolEntryResponse> list = undertest.getMempoolDescendants("39c08704d6f21557a67baaf345ab396a59871718e03870a3a6482166d3dd9893",
                true);
        BtcRpcGetMempoolEntryResponse btcRpcGetMempoolEntryResponse = list.get(0);
        Assert.assertEquals("Expected equals", Long.valueOf(189), btcRpcGetMempoolEntryResponse.getSize());
    }

    @Test
    public void testGetMempoolEntry() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"fees\":{\"base\":0.00000210,\"modified\":0.00000210,\"ancestor\":0.00000872,\"descendant\":0.00000210},\"size\":210,\"fee\":0.00000210,\"modifiedfee\":0.00000210,\"time\":1569056519,\"height\":1579202,\"descendantcount\":1,\"descendantsize\":210,\"descendantfees\":210,\"ancestorcount\":5,\"ancestorsize\":872,\"ancestorfees\":872,\"wtxid\":\"46e02a3ce5af03cfd2a2e2946938e55f13b2d38a68e0c90143ce57d1241d074d\",\"depends\":[\"50b5d096784d1e33683b1c01f77be8494695ae4ef86d3fbb4fc6d1cea1211dee\",\"ff14e33fec33b875bc49e2da3aca702e2422a3d54cf801fddc45ec3d5d8c5d8e\"],\"spentby\":[]},\"error\":null,\"id\":null}");
        BtcRpcGetMempoolEntryResponse btcRpcGetMempoolEntryResponse = undertest
                .getMempoolEntry("1fe082d18fabe42179b24a5cf6e4d7db67a8fcf3054270bf1cd4391ba3e05aba");
        Assert.assertEquals("Expected equals", Long.valueOf(210), btcRpcGetMempoolEntryResponse.getSize());
    }

    @Test
    public void testGetMempoolInfo() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"size\":240,\"bytes\":52253,\"usage\":234328,\"maxmempool\":300000000,\"mempoolminfee\":0.00001000,\"minrelaytxfee\":0.00001000},\"error\":null,\"id\":null}");

        BtcRpcGetMempoolInfoResponse btcRpcGetMempoolInfoResponse = undertest.getMempoolInfo();
        Assert.assertEquals("Expected equals", new BigInteger("240"), btcRpcGetMempoolInfoResponse.getSize());
    }

    @Test
    public void testGetRawMempool() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":[\"71f1a0ad301658c3be4633397c01a559eddcff93b5857904c2068747b38e605e\",\"9c1864ff683225ac84d6eaf9dc068d858f40a889f56c2757945e52701ce8549b\",\"358dc22df52263b94140fcd2706d8c5553196d5b49f53993d21b517b054a1199\",\"9fc749dd0c433175711e6b3d22a38357739fe3d6066133512fdecad7fe80c6bd\",\"0b9bc3e3d9cc5c06ccd919fbc58926f119976a23b78d48f3347e0afd8c836782\",\"948e94112fcdb5bcdcd81e327a009b3f5b467d5349b6fc4e8f940c6cf7267fda\",\"7f778c80968209821f4459292559c8bc74681d77ecbef03328630c63c22850fd\",\"ebb0be4dc92bc757e178c328b7336b18fc606a9fc652b627dae91841e2640f6d\",\"1f4ac3c6d729bb78ed413272407d4abae643ee7eb922a9b1847f12ecc2a67039\",\"35f0fdafba573b1f76a8b13692e084823945928246291b3b4c3000b0dcd508a6\",\"665cb3e4e83a26adb221002a9c0c49b71efb9a4b737465e630f28b19d71c50f3\",\"7a39ab1fa3e64ed249ac1b2a6d73419f6e93c54e40774202d9b8d725b0f446c6\",\"b0d275510c067d9e85fe328b977638699a35fb9410325635ebd0ae730c035e4e\",\"e989ead0fa12455cb8b3151be5aa970271cdc176256392e59ed032d63f6fde45\"],\"error\":null,\"id\":null}");
        List<String> list = undertest.getRawMempool();
        String tx = list.get(0);
        Assert.assertEquals("Expected equals", "71f1a0ad301658c3be4633397c01a559eddcff93b5857904c2068747b38e605e", tx);

        enqueueMockedResponse(200,
                "{\"result\":{\"358dc22df52263b94140fcd2706d8c5553196d5b49f53993d21b517b054a1199\":{\"fees\":{\"base\":0.00005140,\"modified\":0.00005140,\"ancestor\":0.00005140,\"descendant\":0.00005140},\"size\":256,\"fee\":0.00005140,\"modifiedfee\":0.00005140,\"time\":1569058342,\"height\":1579205,\"descendantcount\":1,\"descendantsize\":256,\"descendantfees\":5140,\"ancestorcount\":1,\"ancestorsize\":256,\"ancestorfees\":5140,\"wtxid\":\"c9eaac04207545b872beefe3cb76ba20f276ffcb56fecc59e6d1c5be007f2997\",\"depends\":[],\"spentby\":[]},\"71f1a0ad301658c3be4633397c01a559eddcff93b5857904c2068747b38e605e\":{\"fees\":{\"base\":0.00043810,\"modified\":0.00043810,\"ancestor\":0.00043810,\"descendant\":0.00043810},\"size\":336,\"fee\":0.00043810,\"modifiedfee\":0.00043810,\"time\":1569058360,\"height\":1579205,\"descendantcount\":1,\"descendantsize\":336,\"descendantfees\":43810,\"ancestorcount\":1,\"ancestorsize\":336,\"ancestorfees\":43810,\"wtxid\":\"bd806f93f64f9c9af2001ccaaf50458a3f2391112ff843fc35ea114852854bb2\",\"depends\":[],\"spentby\":[]},\"9c1864ff683225ac84d6eaf9dc068d858f40a889f56c2757945e52701ce8549b\":{\"fees\":{\"base\":0.00025830,\"modified\":0.00025830,\"ancestor\":0.00025830,\"descendant\":0.00025830},\"size\":860,\"fee\":0.00025830,\"modifiedfee\":0.00025830,\"time\":1569058378,\"height\":1579206,\"descendantcount\":1,\"descendantsize\":860,\"descendantfees\":25830,\"ancestorcount\":1,\"ancestorsize\":860,\"ancestorfees\":25830,\"wtxid\":\"0ffa96152052acadca17da9fb82e386d799406777aaeb7ea62db75adc9217790\",\"depends\":[],\"spentby\":[]},\"9fc749dd0c433175711e6b3d22a38357739fe3d6066133512fdecad7fe80c6bd\":{\"fees\":{\"base\":0.00031200,\"modified\":0.00031200,\"ancestor\":0.00031200,\"descendant\":0.00031200},\"size\":1580,\"fee\":0.00031200,\"modifiedfee\":0.00031200,\"time\":1569058391,\"height\":1579206,\"descendantcount\":1,\"descendantsize\":1580,\"descendantfees\":31200,\"ancestorcount\":1,\"ancestorsize\":1580,\"ancestorfees\":31200,\"wtxid\":\"9fc749dd0c433175711e6b3d22a38357739fe3d6066133512fdecad7fe80c6bd\",\"depends\":[],\"spentby\":[]},\"e989ead0fa12455cb8b3151be5aa970271cdc176256392e59ed032d63f6fde45\":{\"fees\":{\"base\":0.00000168,\"modified\":0.00000168,\"ancestor\":0.00000168,\"descendant\":0.00000168},\"size\":168,\"fee\":0.00000168,\"modifiedfee\":0.00000168,\"time\":1569058395,\"height\":1579206,\"descendantcount\":1,\"descendantsize\":168,\"descendantfees\":168,\"ancestorcount\":1,\"ancestorsize\":168,\"ancestorfees\":168,\"wtxid\":\"ed709cf93a5b062edb620b0011952813848503777a26560dd259de35e994ec35\",\"depends\":[],\"spentby\":[]},\"0b9bc3e3d9cc5c06ccd919fbc58926f119976a23b78d48f3347e0afd8c836782\":{\"fees\":{\"base\":0.00000501,\"modified\":0.00000501,\"ancestor\":0.00000501,\"descendant\":0.00000501},\"size\":168,\"fee\":0.00000501,\"modifiedfee\":0.00000501,\"time\":1569058405,\"height\":1579206,\"descendantcount\":1,\"descendantsize\":168,\"descendantfees\":501,\"ancestorcount\":1,\"ancestorsize\":168,\"ancestorfees\":501,\"wtxid\":\"578fcf46a8c6a9bf41d58b4ed37adf22d168f2c9d37c47101a9fb13f4b9127fa\",\"depends\":[],\"spentby\":[]},\"7a39ab1fa3e64ed249ac1b2a6d73419f6e93c54e40774202d9b8d725b0f446c6\":{\"fees\":{\"base\":0.00000258,\"modified\":0.00000258,\"ancestor\":0.00000258,\"descendant\":0.00000258},\"size\":258,\"fee\":0.00000258,\"modifiedfee\":0.00000258,\"time\":1569058405,\"height\":1579206,\"descendantcount\":1,\"descendantsize\":258,\"descendantfees\":258,\"ancestorcount\":1,\"ancestorsize\":258,\"ancestorfees\":258,\"wtxid\":\"dd0bb536a2671ff93eb18743425379e45c9e30f8d3f530f3c6c48d6b6f255bdc\",\"depends\":[],\"spentby\":[]},\"b0d275510c067d9e85fe328b977638699a35fb9410325635ebd0ae730c035e4e\":{\"fees\":{\"base\":0.00000145,\"modified\":0.00000145,\"ancestor\":0.00000145,\"descendant\":0.00000145},\"size\":145,\"fee\":0.00000145,\"modifiedfee\":0.00000145,\"time\":1569058412,\"height\":1579206,\"descendantcount\":1,\"descendantsize\":145,\"descendantfees\":145,\"ancestorcount\":1,\"ancestorsize\":145,\"ancestorfees\":145,\"wtxid\":\"4ea5b0130615de4e2d04c21da714bc81766996a207dcc6f29c59783aee7d602d\",\"depends\":[],\"spentby\":[]},\"1f4ac3c6d729bb78ed413272407d4abae643ee7eb922a9b1847f12ecc2a67039\":{\"fees\":{\"base\":0.00000346,\"modified\":0.00000346,\"ancestor\":0.00000346,\"descendant\":0.00000346},\"size\":342,\"fee\":0.00000346,\"modifiedfee\":0.00000346,\"time\":1569058426,\"height\":1579206,\"descendantcount\":1,\"descendantsize\":342,\"descendantfees\":346,\"ancestorcount\":1,\"ancestorsize\":342,\"ancestorfees\":346,\"wtxid\":\"35716d32b30ea9d4151d22075ea5c185b085bd08f683b2b51e0925efa1cab71d\",\"depends\":[],\"spentby\":[]},\"665cb3e4e83a26adb221002a9c0c49b71efb9a4b737465e630f28b19d71c50f3\":{\"fees\":{\"base\":0.00013273,\"modified\":0.00013273,\"ancestor\":0.00013273,\"descendant\":0.00013273},\"size\":13222,\"fee\":0.00013273,\"modifiedfee\":0.00013273,\"time\":1569058434,\"height\":1579206,\"descendantcount\":1,\"descendantsize\":13222,\"descendantfees\":13273,\"ancestorcount\":1,\"ancestorsize\":13222,\"ancestorfees\":13273,\"wtxid\":\"687621202b60bd82cb49aedc57751a027bf101e9946a23af50d92be9cdfd48f7\",\"depends\":[],\"spentby\":[]},\"35f0fdafba573b1f76a8b13692e084823945928246291b3b4c3000b0dcd508a6\":{\"fees\":{\"base\":0.00000347,\"modified\":0.00000347,\"ancestor\":0.00000347,\"descendant\":0.00000347},\"size\":343,\"fee\":0.00000347,\"modifiedfee\":0.00000347,\"time\":1569058438,\"height\":1579206,\"descendantcount\":1,\"descendantsize\":343,\"descendantfees\":347,\"ancestorcount\":1,\"ancestorsize\":343,\"ancestorfees\":347,\"wtxid\":\"b861c7e961ce393d11cfea8a456b9b48043a76fbb4c55dc80e15958d83ee7e8f\",\"depends\":[],\"spentby\":[]},\"7f778c80968209821f4459292559c8bc74681d77ecbef03328630c63c22850fd\":{\"fees\":{\"base\":0.00000347,\"modified\":0.00000347,\"ancestor\":0.00000347,\"descendant\":0.00000347},\"size\":342,\"fee\":0.00000347,\"modifiedfee\":0.00000347,\"time\":1569058442,\"height\":1579206,\"descendantcount\":1,\"descendantsize\":342,\"descendantfees\":347,\"ancestorcount\":1,\"ancestorsize\":342,\"ancestorfees\":347,\"wtxid\":\"a75695540d66e5a4558e4e29b35d0e8727ad6080b711fa44ad7d73df76d9e138\",\"depends\":[],\"spentby\":[]},\"948e94112fcdb5bcdcd81e327a009b3f5b467d5349b6fc4e8f940c6cf7267fda\":{\"fees\":{\"base\":0.00000350,\"modified\":0.00000350,\"ancestor\":0.00000350,\"descendant\":0.00000350},\"size\":344,\"fee\":0.00000350,\"modifiedfee\":0.00000350,\"time\":1569058446,\"height\":1579206,\"descendantcount\":1,\"descendantsize\":344,\"descendantfees\":350,\"ancestorcount\":1,\"ancestorsize\":344,\"ancestorfees\":350,\"wtxid\":\"28b0479d436b9b5e1624b15bb291738e7a4c27e5bfb5eacfe9bce59a333603cc\",\"depends\":[],\"spentby\":[]},\"ebb0be4dc92bc757e178c328b7336b18fc606a9fc652b627dae91841e2640f6d\":{\"fees\":{\"base\":0.00000348,\"modified\":0.00000348,\"ancestor\":0.00000348,\"descendant\":0.00000348},\"size\":343,\"fee\":0.00000348,\"modifiedfee\":0.00000348,\"time\":1569058470,\"height\":1579206,\"descendantcount\":1,\"descendantsize\":343,\"descendantfees\":348,\"ancestorcount\":1,\"ancestorsize\":343,\"ancestorfees\":348,\"wtxid\":\"9b7a28f7726c9bb784ac719efbe67053373fe90ef9cc17564170483ee4e51ed8\",\"depends\":[],\"spentby\":[]}},\"error\":null,\"id\":null}");
        List<BtcRpcGetMempoolEntryResponse> listMempoolEntries = undertest.getRawMempoolVerbose();
        BtcRpcGetMempoolEntryResponse btcRpcGetMempoolEntryResponse = listMempoolEntries.get(0);
        Assert.assertEquals("Expected equals", "c9eaac04207545b872beefe3cb76ba20f276ffcb56fecc59e6d1c5be007f2997",
                btcRpcGetMempoolEntryResponse.getWtxid());

    }

    // @Test
    public void testGetTxOut() throws Exception {
        enqueueMockedResponse(200, "");
        // undertest.getTxOut("38cb6001694d856bbd61751a3ae2568a4e2d1edb32f43b405b84298e211a3b20", Long.valueOf(0), true);

    }

    @Test
    public void testGetTxOutProof() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":\"000080209b366b6244d21a7005c2f72d37471923565dac0198c7584472f6fd4900000000db68d8bc275b3ec5c1d2bd5af9706ede5ae28223e2604fab6145df4dc5e3d3d51344875d7492021a30f9b1d0770000000882a6a18d3438fe7e43e521cbc7d2a0ff18b78318f0c97b6226f6ec6a49ee5ecc98bc6fcd094ad0a44cbc68ab9dfd0bcdbd4e8136c5df974453202b9694b8b5387348320b969d0ca744b66f7133760206817969088baec6fdccced2d8112058b6600a292b883a15a27779218065b20dad9573af90e005c1e517abfd8e345ff9ad26c574c1482f72d89bd8ca40434a08e240b5876e76c1fa363ca602528b4ab57e09e50869fb7880471e668a012d064b39c7110a62b907efd431be30bf3a80c962843b1160bee90ab5c8a47932cc966a0c94457a4459b011cc66e08ce57c7e53736c10169c881c7eef6e26ece16ee51c30658a64d793f47ea6e6fdaae394185fe9027f01\",\"error\":null,\"id\":null}");
        String data = undertest.getTxOutProof(new String[] { "38b5b894962b20534497dfc536814ebdcd0bfd9dab68bc4ca4d04a09cd6fbc98" },
                "000000000000016711b50488910601f524f5379bcda214d18f8913f2ffe51062");
        Assert.assertEquals("Expected equals",
                "000080209b366b6244d21a7005c2f72d37471923565dac0198c7584472f6fd4900000000db68d8bc275b3ec5c1d2bd5af9706ede5ae28223e2604fab6145df4dc5e3d3d51344875d7492021a30f9b1d0770000000882a6a18d3438fe7e43e521cbc7d2a0ff18b78318f0c97b6226f6ec6a49ee5ecc98bc6fcd094ad0a44cbc68ab9dfd0bcdbd4e8136c5df974453202b9694b8b5387348320b969d0ca744b66f7133760206817969088baec6fdccced2d8112058b6600a292b883a15a27779218065b20dad9573af90e005c1e517abfd8e345ff9ad26c574c1482f72d89bd8ca40434a08e240b5876e76c1fa363ca602528b4ab57e09e50869fb7880471e668a012d064b39c7110a62b907efd431be30bf3a80c962843b1160bee90ab5c8a47932cc966a0c94457a4459b011cc66e08ce57c7e53736c10169c881c7eef6e26ece16ee51c30658a64d793f47ea6e6fdaae394185fe9027f01",
                data);
    }

}
