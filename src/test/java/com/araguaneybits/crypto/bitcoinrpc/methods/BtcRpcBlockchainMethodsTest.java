package com.araguaneybits.crypto.bitcoinrpc.methods;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetBlockWithTxResponse;

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

}
