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
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.methods.request.BtcRpcBlockTemplateRequest;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcBlockTemplateResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetMiningInfoResponse;

/**
 * The Class BtcRpcMiningMethodsTest.
 *
 * @author jestevez
 */
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
    @Test
    public void testGetBlockTemplate() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"capabilities\":[\"proposal\"],\"version\":536870912,\"rules\":[],\"vbavailable\":{},\"vbrequired\":0,\"previousblockhash\":\"0000000000000547b5ba75722890d1f3612258f0d7252b791b2f7be9575b3cff\",\"transactions\":[{\"data\":\"01000000000101593509c142c1d6c88d3723cf5784faff878b3647c41df14e1afd3f57cc534dff0000000000ffffffff020000000000000000536a4c50000222eb0002359b9bf62146b0696d0ae2bc63de245bf2376250a44d3214b8a0c2ae3cabb89b615402b56de87ed27606e823e9ac5dff7b770405f5e11fbf67f64f75662be062df035a8aa8c6f56dba30ac1d1f0000000000160014d30ef4ca84f78f6a3303dd747f95b2e3fdefcae402473044022023de95cece55a3d33e5d50f1bdd24a76ec3b533499a5a0ad0ac221df0b602faf02200df19806719ba8b66885628d5f3a58e3d8eb49a6c0d8d1237b00447ad628dbe40121036900c2cf065f76327b3e22c361dcad49f3d63f6271744c15dc9df3ded6082d7000000000\",\"txid\":\"b9d21d17764b73544853ef769c768d810016af983cce4a3838f701961394b571\",\"hash\":\"8700987b884cb21620becf5e54fc599a2689500330185a8cf01e149554d4caf4\",\"depends\":[],\"fee\":282,\"sigops\":1,\"weight\":805},{\"data\":\"0100000000010174977d6dadd7a9ed87a630b98eebe7c2f69b23dcdb63c7006d56a9de48e79d180000000000ffffffff0226fa470000000000160014e35fae1018f022cbd80654a88a14c355445fb5710000000000000000536a4c50000222eb0002359b9bf62146b0696d0ae2bc63de245bf2376250a44d3214b8a0c2ae3cabb89b615402b56de87ed27606e823e9ac5dff7b770405f5e11fbf67f64f75662be062df035a8aa8c6f56dba3002483045022100c972731e2cb248da32c2a46dde6a4d0bcf49cce833f5c90bd34b9c95f0f5402802203ea7d1eda751074d6ee073fd64c49c99842e77b2f668d5fd2769a7a7bfcdacdb012102eb2a1810b3899d6e29e67da2b757b9ce861100e95fd400b2e44e838f1e9b9a9e00000000\",\"txid\":\"894f4c3352707d78e78385c0d3856f3f744d382650ef895c805774a69c5bbb87\",\"hash\":\"bba619def71b142ef250defe4005641bc056fed61f6abeb451cbca27bfa3ef96\",\"depends\":[],\"fee\":282,\"sigops\":1,\"weight\":806},{\"data\":\"010000000117b0b42159c997af0000c7e239d1671e3706fa2507e77af9a72929b60e70f2b9000000006a473044022035c2c580373a355b239085ed2b1bd12b6655dbb4220bc87504b9bc8906995235022055499f5fb0cd74464d9b36c04bd1ab3eccc228ce5d9ecf8ab166a2b7d0506a02012102077dfc05e86caea348f92ac60d9f415ae1614b67838ae277150f9d2913cbcf0cffffffff020000000000000000536a4c50000222eb0002359b9bf62146b0696d0ae2bc63de245bf2376250a44d3214b8a0c2ae3cabb89b615402b56de87ed27606e823e9ac5dff7b770405f5e11fbf67f627de9305ad5bc9212a4ce706aebc749794770d00000000001976a914d34ca0d8702a8ae8ea7987dd09ce34fe33ad844788ac00000000\",\"txid\":\"a0331cfeb06b90f9f8bc76290796c3caf863c5c907ce59cd15e88f4af575e070\",\"hash\":\"a0331cfeb06b90f9f8bc76290796c3caf863c5c907ce59cd15e88f4af575e070\",\"depends\":[],\"fee\":285,\"sigops\":4,\"weight\":1132},{\"data\":\"02000000000101056b3778485e32d73f396fce59ec89c780ddee7d631273c668b06e52e86f9c45170000001716001466fcd4031683ce3426e9afa9fd26d4f86a4942b7feffffff18a08f3e000000000017a914e4827d37aea3d5e95654699ae1464336dc7e2f9287a08f3e000000000017a9140b6de5735af02a9db31a4bf63ca2d3c0388e2e3587a08f3e000000000017a9149af0ea693340f38c93118d74f80c38dbecb0a4dc87a08f3e000000000017a914b4b93aca8c6c1b77cead0e38fc4aa5843d477ee387a08f3e000000000017a91415b208443656e57a4aa17cb7102dcfc9aebbd55287401640000000000017a9148a08adddc282fce1c932c8d97fe001c0d1384a2c87401640000000000017a9148c47abfbaa14192032ace186b17a5c741bd4b56087401640000000000017a914348a69313f757f46e549d90f63b991b1f96bca4287a08f3e000000000017a91406b52daf41d556bc0dc6a069203f45b4b58e321d87a08f3e000000000017a914b6ed3aaf30d227300943fd32ac28c34c352ab6ff87401640000000000017a914c6f585286aeb00caab2ca1e03d7a3cdeaf2fc02487401640000000000017a9149256171dd1daec5e1db3b7c5a5a0a059f2dd149087401640000000000017a914988766a98fd3e28299752fd1e7685fc0965f61dd8751a5726aab00000017a91436385f2c6adeac73cc3536bea251839441be419887401640000000000017a91417ddd07d4122e58cda44265aa303c6833d1687f287401640000000000017a91416685feb262b633d46af1536cecb7f7c39132be887401640000000000017a91442f3fdaa8aee7be775883247d8bee11bc6a87b1a87401640000000000017a914da99690484b72299cf1f8c5970538c473e37618a87401640000000000017a9148ff45b216cda5f60310526d76f647ebb7fe635bc87e09c41000000000017a914102438a06791553c01774c041c61cc2db099dcf687e09c41000000000017a914d8ed8a145ce0fccbe847650abcb5d2a1d0516dc887e09c41000000000017a914508628c5c7dd3c752989e03828f768682158fbc787e09c41000000000017a9140719af0e0cfb8c8f3cfe7634e8f2503daa428b5b87e09c41000000000017a914b5ed644cb29594a1715de4efb7acb566e1e140dc8702473044022012403231ad3960924adc18c7dbafec4326f9f288074f222c102ac4dd66dd09cc022021638473d6f72624b23ff247b43138493df179d148f1417ce6b04aae61d8e99c012103e72963af0c1b2566d5ae1b645ebde776c4ff56e3d5cca04a8b123feac3b5bdc0b8ee1800\",\"txid\":\"3bccab21fd414f48d07193c87e84e2763e2a32a6daed33efd8dc3c773a82167c\",\"hash\":\"64fabf69db9a363169e8712f8aea1e81a7f2a028dc2ddd3120f8f690b1c8d59e\",\"depends\":[],\"fee\":870,\"sigops\":1,\"weight\":3477}],\"coinbaseaux\":{\"flags\":\"\"},\"coinbasevalue\":39064219,\"longpollid\":\"0000000000000547b5ba75722890d1f3612258f0d7252b791b2f7be9575b3cff15319\",\"target\":\"0000000000000ffff00000000000000000000000000000000000000000000000\",\"mintime\":1577023796,\"mutable\":[\"time\",\"transactions\",\"prevblock\"],\"noncerange\":\"00000000ffffffff\",\"sigoplimit\":80000,\"sizelimit\":4000000,\"weightlimit\":4000000,\"curtime\":1577024468,\"bits\":\"1a0ffff0\",\"height\":1633977,\"default_witness_commitment\":\"6a24aa21a9ed5dcf45a2099b4ca8c94ee543ba266a8f13f82e2e5b2eb818cc4f3e0a3f9b9bdd\"},\"error\":null,\"id\":null}");

        BtcRpcBlockTemplateRequest btcRpcBlockTemplateRequest = new BtcRpcBlockTemplateRequest();
        btcRpcBlockTemplateRequest.setMode("template");
        btcRpcBlockTemplateRequest.setRules(new String[] { "segwit" });
        BtcRpcBlockTemplateResponse btcRpcBlockTemplateResponse = undertest.getBlockTemplate(btcRpcBlockTemplateRequest);

        Assert.assertNotNull("Is not null", btcRpcBlockTemplateResponse);
        Assert.assertEquals("Expected equals", new BigInteger("536870912"), btcRpcBlockTemplateResponse.getVersion());
    }

    /**
     * Test getmininginfo.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetMiningInfo() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"blocks\":1633988,\"currentblockweight\":6649,\"currentblocktx\":3,\"difficulty\":1048576,\"networkhashps\":29926363682789.68,\"pooledtx\":3,\"chain\":\"test\",\"warnings\":\"Warning: unknown new rules activated (versionbit 28)\"},\"error\":null,\"id\":null}");
        BtcRpcGetMiningInfoResponse btcRpcGetMiningInfoResponse = undertest.getMiningInfo();
        Assert.assertNotNull("Is not null", btcRpcGetMiningInfoResponse);

        Assert.assertEquals("Expected equals", new BigInteger("1633988"), btcRpcGetMiningInfoResponse.getBlocks());
    }

    /**
     * Test getnetworkhashps.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetNetworkHashPs() throws Exception {
        enqueueMockedResponse(200, "{\"result\":37757629937695.34,\"error\":null,\"id\":null}");
        BigInteger nblocks = new BigInteger("120");
        BigInteger height = new BigInteger("-1");

        BigDecimal hashps = undertest.getNetworkHashPs(nblocks, height);
        Assert.assertNotNull("Is not null", hashps);
        Assert.assertEquals("Expected equals ", new BigDecimal("37757629937695.34"), hashps);
    }

    /**
     * Test prioritisetransaction.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPrioritiseTransaction() throws Exception {
        enqueueMockedResponse(200, "{\"result\":true,\"error\":null,\"id\":null}");
        Boolean success = undertest.prioritiseTransaction("5a918346ce68fe77ef2ec0e3f4f4d8bf443ef34452b4a3cda2c3a850350e64ec",
                new BigInteger("10000"));
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test submitblock.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSubmitBlock() throws Exception {
        undertest.submitBlock("");
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
    public void testGeneratetoaddress() throws Exception {
        BigInteger nblocks = new BigInteger("0");
        String address = "";
        BigInteger maxtries = new BigInteger("0");
        undertest.generateToAddress(nblocks, address, maxtries);
        Assert.fail("Test method not implemented");
    }
}
