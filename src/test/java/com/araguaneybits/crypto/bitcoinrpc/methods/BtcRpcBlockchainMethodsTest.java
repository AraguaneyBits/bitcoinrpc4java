package com.araguaneybits.crypto.bitcoinrpc.methods;

import java.math.BigInteger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockHeaderResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockWithTxResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockchainInfoResponse;

public class BtcRpcBlockchainMethodsTest extends AbstractBtcRpcMethodsTest {
    private BtcRpcBlockchainMethods undertest;

    @Before
    public void setUp() {
        undertest = new BtcRpcBlockchainMethods(btcRpcGateway);
    }

    @After
    public void tearDown() {

    }

    // @Test
    public void testGetBestBlockHash() throws Exception {
        enqueueMockedResponse(200, "{\"result\":\"5abbfa1ab7105d6f39782cdbac470ace776b4c9247eb02f66d1265e732cc499f\",\"error\":null,\"id\":null}");
        String hash = undertest.getBestBlockHash();
        Assert.assertEquals("Expected equals", "5abbfa1ab7105d6f39782cdbac470ace776b4c9247eb02f66d1265e732cc499f", hash);
    }

    // @Test
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

    // @Test
    public void testGetBlockchainInfo() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"chain\":\"regtest\",\"blocks\":202,\"headers\":202,\"bestblockhash\":\"5abbfa1ab7105d6f39782cdbac470ace776b4c9247eb02f66d1265e732cc499f\",\"difficulty\":4.656542373906925e-10,\"mediantime\":1567715995,\"verificationprogress\":1,\"initialblockdownload\":true,\"chainwork\":\"0000000000000000000000000000000000000000000000000000000000000196\",\"size_on_disk\":63376,\"pruned\":false,\"softforks\":[{\"id\":\"bip34\",\"version\":2,\"reject\":{\"status\":false}},{\"id\":\"bip66\",\"version\":3,\"reject\":{\"status\":false}},{\"id\":\"bip65\",\"version\":4,\"reject\":{\"status\":false}}],\"bip9_softforks\":{\"csv\":{\"status\":\"started\",\"bit\":0,\"startTime\":0,\"timeout\":9223372036854775807,\"since\":144,\"statistics\":{\"period\":144,\"threshold\":108,\"elapsed\":59,\"count\":59,\"possible\":true}},\"segwit\":{\"status\":\"active\",\"startTime\":-1,\"timeout\":9223372036854775807,\"since\":0}},\"warnings\":\"\"},\"error\":null,\"id\":null}");
        BtcRpcGetBlockchainInfoResponse btcRpcBlockchainInfoResponse = undertest.getBlockchainInfo();
        Assert.assertNotNull("Is not null", btcRpcBlockchainInfoResponse);
    }

    // @Test
    public void testGetBlockCount() throws Exception {
        enqueueMockedResponse(200, "{\"result\":202,\"error\":null,\"id\":null}");
        BigInteger blocks = undertest.getBlockCount();
        Assert.assertEquals("Expected 202", new BigInteger("202"), blocks);

    }

    // @Test
    public void testGetBlockHash() throws Exception {
        enqueueMockedResponse(200, "{\"result\":\"0f9188f13cb7b2c71f2a335e3a4fc328bf5beb436012afca590b1a11466e2206\",\"error\":null,\"id\":null}");
        String hash = undertest.getBlockHash(0L);
        Assert.assertEquals("Expected equals", "0f9188f13cb7b2c71f2a335e3a4fc328bf5beb436012afca590b1a11466e2206", hash);

    }

    // @Test
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

}
