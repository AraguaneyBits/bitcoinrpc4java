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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.constants.EnumAddressType;
import com.araguaneybits.crypto.bitcoinrpc.constants.EnumEstimateMode;
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
 * The Class BtcRpcWalletMethodsTest.
 *
 * @author jestevez
 */
public class BtcRpcWalletMethodsTest extends AbstractBtcRpcMethodsTest {

    /** The undertest. */
    private BtcRpcWalletMethods undertest;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        undertest = new BtcRpcWalletMethods(btcRpcGateway);
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
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        String txid = null;
        undertest.abandonTransaction(txid);
        Assert.fail("Test method not implemented");
    }

    /**
     * Test add multi sig address.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddMultiSigAddress() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"address\":\"2Mz9xyBuBVeT25Hs642ncEGcKduX3p6uuTH\",\"redeemScript\":\"522103bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d52103a0fdbc70f0e34110797be4a872291565796b2121c7b9abc831ec27d051e4aec252ae\"},\"error\":null,\"id\":null}");
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
    @Test
    public void testBumpfee() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"txid\":\"5d8133547267b5aa51aab162f075c1f6055dd167dcaf8941c3cb3ecdf421f4ab\",\"origfee\":0.00000438,\"fee\":0.00002628,\"errors\":[]},\"error\":null,\"id\":null}");

        String txid = "cbfd235445ecddabd9be94cdc1283163bf8a5e21079a9955f136473b691fda42";
        BtcRpcBumpFeeResponse btcRpcBumpFeeResponse = undertest.bumpFee(txid);

        Assert.assertNotEquals("Expected new txid", txid, btcRpcBumpFeeResponse.getTxid());
    }

    /**
     * Test dump privkey.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDumpPrivkey() throws Exception {
        enqueueMockedResponse(200, "{\"result\":\"cQPGyD6Nt4eXEESnxagZNkmuU6Vkd4MqqwXtUazNaqaQi8H1hMnh\",\"error\":null,\"id\":null}");

        String address = "2NBErWpiKj4R1kvvqp5pFLLrR4MZ3mJwGYX";
        String privateKey = undertest.dumpPrivkey(address);
        Assert.assertEquals("expected equals", "cQPGyD6Nt4eXEESnxagZNkmuU6Vkd4MqqwXtUazNaqaQi8H1hMnh", privateKey);
    }

    /**
     * Test get addresses by label.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetAddressesByLabel() throws Exception {
        enqueueMockedResponse(200, "{\"result\":{\"mwSdzaGFDBsa8qinqSkfdwNKf2S2dGH7LG\":{\"purpose\":\"receive\"}},\"error\":null,\"id\":null}");

        String label = "bb619c12-9653-45a8-808d-0dfa3179f924";
        String address = "mwSdzaGFDBsa8qinqSkfdwNKf2S2dGH7LG";
        BtcRpcGetAddressesByLabelResponse btcRpcGetAddressesByLabelResponse = undertest.getAddressesByLabel(label);
        Assert.assertEquals("expected address", address, btcRpcGetAddressesByLabelResponse.getAddress());

    }

    /**
     * Test get address info.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetAddressInfo() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"address\":\"2NCm9hYgFBBrwAMPUeXcaifi2VPwwxwogYq\",\"scriptPubKey\":\"a914d61349f0ab031e68c2c17956617404348685f11087\",\"ismine\":true,\"solvable\":true,\"desc\":\"sh(wpkh([9684e63a/0'/0'/22']02bbc3f14de5747800af47b5aac02b334a11cfaca16bc7e95c18525561b723e55d))#xua2sm9e\",\"iswatchonly\":false,\"isscript\":true,\"iswitness\":false,\"script\":\"witness_v0_keyhash\",\"hex\":\"00146afc3b2f7f59030a7e0bfe03b1e6640610689c69\",\"pubkey\":\"02bbc3f14de5747800af47b5aac02b334a11cfaca16bc7e95c18525561b723e55d\",\"embedded\":{\"isscript\":false,\"iswitness\":true,\"witness_version\":0,\"witness_program\":\"6afc3b2f7f59030a7e0bfe03b1e6640610689c69\",\"pubkey\":\"02bbc3f14de5747800af47b5aac02b334a11cfaca16bc7e95c18525561b723e55d\",\"address\":\"tb1qdt7rktmltyps5lstlcpmrenyqcgx38rf7tmml7\",\"scriptPubKey\":\"00146afc3b2f7f59030a7e0bfe03b1e6640610689c69\"},\"label\":\"\",\"ischange\":false,\"timestamp\":1565895310,\"hdkeypath\":\"m/0'/0'/22'\",\"hdseedid\":\"8c9e282b366f6f1c441d851300a96cdf42301109\",\"hdmasterfingerprint\":\"9684e63a\",\"labels\":[{\"name\":\"\",\"purpose\":\"receive\"}]},\"error\":null,\"id\":null}");

        String address = "2NCm9hYgFBBrwAMPUeXcaifi2VPwwxwogYq";
        BtcRpcGetAddressInfoResponse btcRpcGetAddressInfoResponse = undertest.getAddressInfo(address);
        Assert.assertEquals("expected address", address, btcRpcGetAddressInfoResponse.getAddress());

    }

    /**
     * Test get balance.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetBalance() throws Exception {
        enqueueMockedResponse(200, "{\"result\":5099.21616543,\"error\":null,\"id\":null}");

        BigDecimal balance = undertest.getBalance();
        Assert.assertEquals("Expected equals", new BigDecimal("5099.21616543"), balance);
    }

    /**
     * Test get new address.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetNewAddress() throws Exception {
        enqueueMockedResponse(200, "{\"result\":\"mpAdbzrHZa4yUzMhyBoaZUJt3rPFVFAzv2\",\"error\":null,\"id\":null}");

        String address = undertest.getNewAddress();
        Assert.assertEquals("Expected equals", "mpAdbzrHZa4yUzMhyBoaZUJt3rPFVFAzv2", address);
    }

    /**
     * Test get raw change address.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetRawChangeAddress() throws Exception {
        enqueueMockedResponse(200, "{\"result\":\"mwXpnsojNm8TwaCnYq6t6vFFPuGuDQ4h89\",\"error\":null,\"id\":null}");

        String address = undertest.getRawChangeAddress(EnumAddressType.LEGACY);
        Assert.assertEquals("Expected equals", "mwXpnsojNm8TwaCnYq6t6vFFPuGuDQ4h89", address);

    }

    /**
     * Test get received by address.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetReceivedByAddress() throws Exception {
        enqueueMockedResponse(200, "{\"result\":0.00000000,\"error\":null,\"id\":null}");

        String address = "mwXpnsojNm8TwaCnYq6t6vFFPuGuDQ4h89";
        Integer minconf = 1;
        BigDecimal balance = undertest.getReceivedByAddress(address, minconf);
        Assert.assertEquals("Expected equals", new BigDecimal("0.00000000"), balance);
    }

    /**
     * Test get received by label.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetReceivedByLabel() throws Exception {
        enqueueMockedResponse(200, "{\"result\":10.00000000,\"error\":null,\"id\":null}");

        String label = "bb619c12-9653-45a8-808d-0dfa3179f924";
        Integer minconf = 1;
        BigDecimal balance = undertest.getReceivedByLabel(label, minconf);
        Assert.assertEquals("Expected equals", new BigDecimal("10.00000000"), balance);
    }

    /**
     * Test get transaction.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetTransaction() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"amount\":-0.11107751,\"fee\":-0.00004200,\"confirmations\":0,\"trusted\":true,\"txid\":\"03146921f56264ac39bf1d49bc19f3a2827941c188e4c20c65cea3891359a614\",\"walletconflicts\":[\"06b8e38c4134694f764ba7bb94dca2aeada3a78186f6fd3c2f78f8ec872c97eb\"],\"time\":1568388312,\"timereceived\":1568388312,\"bip125-replaceable\":\"yes\",\"comment\":\"bumofee-1568388312180\",\"replaces_txid\":\"06b8e38c4134694f764ba7bb94dca2aeada3a78186f6fd3c2f78f8ec872c97eb\",\"details\":[{\"address\":\"mjsxSnf6SFsP9VSgyunXaLK6JuqU52hTds\",\"category\":\"send\",\"amount\":-0.11107751,\"vout\":1,\"fee\":-0.00004200,\"abandoned\":false}],\"hex\":\"020000000001011182adf5954819b89fa04bdabcc3c2c5a8054aad9ea1817deb9af5912ab20bc100000000171600147edfb7504c28bb9e682b5745baea6e5e82012982fdffffff021d2e5c290100000017a914ba233fb3876cd783674211618e6b4695b8e0098287a77da900000000001976a9142fd95d316d79f4a82afdc4cb688c4b709af3fa2288ac0247304402207f44e33037f7cee30d004caca00394827a519cfe977366b3197eea589235e58e022017e9da56fe176fbd57b9a787a1890bba6edfd8d4084f1cbe0f3da0817a0bf518012103e62085d0e8f0c2af18785ec68e5f08b2637a8cc6f82484d4ca2065982abddc0d00000000\"},\"error\":null,\"id\":null}");

        String txid = "03146921f56264ac39bf1d49bc19f3a2827941c188e4c20c65cea3891359a614";
        BtcRpcGetTransactionResponse btcRpcGetTransactionResponse = undertest.getTransaction(txid);
        Assert.assertEquals("expected txid", txid, btcRpcGetTransactionResponse.getTxid());
    }

    /**
     * Test get unconfirmed balance.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetUnconfirmedBalance() throws Exception {
        enqueueMockedResponse(200, "{\"result\":10.00000000,\"error\":null,\"id\":null}");

        BigDecimal balance = undertest.getUnconfirmedBalance();
        Assert.assertEquals("Expected equals", new BigDecimal("10.00000000"), balance);
    }

    /**
     * Test import address.
     *
     * @throws Exception the exception
     */
    @Test
    public void testImportAddress() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

        String address = "mohngWVDdMJN3QncP8Sz7WyD52RsTYqwpk";
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
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

        undertest.importmulti();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test import priv key.
     *
     * @throws Exception the exception
     */
    @Test
    public void testImportPrivKey() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

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
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

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
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

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
    @Test
    public void testListReceivedByAddress() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":[{\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"amount\":37.03741355,\"confirmations\":160588,\"label\":\"pk\",\"txids\":[\"d194a86df899efa2b56eafdd44236654b28f1df38f8b26dbe7270cca2e13ea00\",\"485048d0a92bd87e63f18a071cf69912566cb34c868d376dab60494ea74ded1b\",\"87a63014dd24eb6c3ebc3556e075c96fca1ffec0c10cb1ced51d11f6d98bb13a\",\"4c9564d7cbf02473e0d61e9eae816eafdfaee781055189dad45a8648173efc44\",\"2f81e01f58f69ca1bde06182c31d97442487879fb6eb9eedf2af4f6d78cc4948\",\"cd28c543d219768e44e22b5df4eefbbe60d497e235a8f80e2c76f251bf57a348\",\"2c75bfefa5bb138e8fec42382acfd952326d53767a335110a832401e53e14849\",\"02424a9e8447839b591b08dc8a9f260ce3f115554e78dd01d58422c2289b1f4e\",\"48ca542f098efa1e2753e93576da468b4f607b4c8e6206d1d1161e848158865b\",\"00c2b45ddb430da8559eb723295af3d050b08524243d4e2c231b3b5939036663\",\"6385555e5acdf6c5c1331611240df53acda5ff9e3aa6701d03355dda8e90276d\",\"17493c103fb57b54d73dc79129fa2ec1141ea1fd337c821d3134f43d60940472\",\"3928dddb6a57930bac61d7c4932b25f90c8b70bb76ecf80a81d8ed7595909981\",\"e65dff55c8003fb72d098f25c22011ff5602751ad6d69bfafad0b2e0379ddc82\",\"32c6c37bf1e4443c398ffc0771edd9887d18a73564c4bb164147612a3a631a83\",\"333f87e9d1fe375b697bed22c819df0b50afcb3ea4fda53da6c89ff736bd6c85\",\"07dcef2d013f5ce23468b7b7dbd7eda9124218adf0515c681149530dcca5f987\",\"0815e979630484bded3a2b3f05cbcd9dc50b4069f699df3412445ac8baf9d38e\",\"5828821273422d5957c953919ff2d5e0bc9bd141611c113aa4ee91de82088e90\",\"ec582d567e8d257e8f58980b01795080bac38574f150d7eb2391dfab06013e93\",\"9a51d0fe191c86c29985aec0c53801f3b9dffd00449ad8186f8186e6c18a429d\",\"7be8ccbf6c3182b87e9ce1ef81737b21e069701a2b8eec0bab14a75daf33569f\",\"3c761be212197f254946dbda19125f528a6f58db344fb4ce1571da600c8614ab\",\"286315130560be6804bfa3d9987be7b8b3430e36890d2df55ca16a92475591bd\",\"c338c06287d6dc908d1cfe76b7a832d3fe151e2e84d0c6d175329769514dcdcc\",\"86acb3074d3951d661104856a636aaeb2b57c8f6aa34f2c9eca5eb81e7e47ccf\",\"fd0faa3df86d6b2d14aaba89d244873831517b15812910c0ed32706689d3ddcf\",\"4849c58eb44609835d8037a134273fdc451672b33f61cb63f47d67f9c0b90ae0\",\"9c900f0d20a8f35e1157647819ef41661af3de33a08b67c0b949a4adccea3ff1\",\"ded5c024695eb9cd1d72a65109a951d9c4600c89213a9d21ed354ec04b6521f3\",\"e6698ffb8f00e02dda0aec743c55d14d3919803d0675b4e9eccce4112b9640f9\",\"0369772cab6b1236feed3434331a4f5cb5bb33c99478c4fd9146da1ea4f0e4f9\"]},{\"address\":\"2Mu8Szhs2hzicZuRLfwongbNGfdkWGAVa5c\",\"amount\":0.01000000,\"confirmations\":336,\"label\":\"\",\"txids\":[\"b1d13d9b381a1f313f0500670ce5be39d76609d6bc5918d0d4fd6afc177ce6d9\"]},{\"address\":\"2Mv81afTw7uFCxtokMM4ZTbuETCAaQPUSWQ\",\"amount\":1.60000000,\"confirmations\":2161,\"label\":\"\",\"txids\":[\"ff0f593a751f5cf60e665e2e2caeefa7b9aee594025af7398b852ba8664df329\",\"c3a893d7b97e6cb278a17150dfa298458ebdbdfb40f226305556e14c187801b3\"]},{\"address\":\"2MwMnSLgff7KpnpYWYmS2ee3ZcVfM7CUiCL\",\"amount\":0.11110855,\"confirmations\":333,\"label\":\"\",\"txids\":[\"0c91863a8cb26d5c00ea4ccf029ac3391f14188957f5e2957dbd0fecf195000e\"]},{\"address\":\"2MzxM6kH9SdvtqZAkjuDW1XTaRpVVZTtC5a\",\"amount\":2.00000000,\"confirmations\":43524,\"label\":\"\",\"txids\":[\"5177009e754fb1b32b925cbac99c70acc37af158f8f82a571e264089c674221d\"]},{\"address\":\"2N1GERwj3yhwbcRxSSJuiR9KtZTtWFhnWae\",\"amount\":0.00000935,\"confirmations\":335,\"label\":\"\",\"txids\":[\"70231421a7a65c61c8fd4a863f27f6c99f16ed42a7a52868a1a2ef4d20cc3f2a\"]},{\"address\":\"2N28ztuNRnTWxqqUJYocgrZ82Wqbakc4gNs\",\"amount\":0.01000000,\"confirmations\":338,\"label\":\"\",\"txids\":[\"6661dc54a1bd8c2e359192fdc4f3f0d5f74ea963629f731ef61f7a40c1260265\"]},{\"address\":\"2N38XzQzPMmgxroiawrFUBR5wqbXxzLfnb6\",\"amount\":0.01000000,\"confirmations\":338,\"label\":\"\",\"txids\":[\"fff2f68168a21d6a28f9597de8b3028e39187a8da63f70f1b6123edbae15d37e\"]},{\"address\":\"2N4SNF5xJ49D5AzhH9qkUUP3LYDvFTT3Bsx\",\"amount\":0.01000000,\"confirmations\":338,\"label\":\"\",\"txids\":[\"ef0e93a08a27dff35683d78891352835e735464701c84d7253268d24c71a2bb2\"]},{\"address\":\"2N4UN9iYAj4qcQHcafZ4VbqkSeVWjLg54rc\",\"amount\":0.11110855,\"confirmations\":1435,\"label\":\"\",\"txids\":[\"514705918497fbb4badda437bc771778b3034ed461680d1bfa1d53578629f157\"]},{\"address\":\"2N5FYdbHZUDfwMdodzQ4bsj8LMVT8rCsgUW\",\"amount\":1.00000000,\"confirmations\":37292,\"label\":\"\",\"txids\":[\"ab9553422fdda3db10516de7d3916509d01e98c8d2335cf4fdda2a03a7e30b54\"]},{\"address\":\"2N5kfro4cHwNiTS2rvm9zxsNsYAHDpNQ952\",\"amount\":0.50000000,\"confirmations\":43385,\"label\":\"\",\"txids\":[\"1861a5fd89a98543178003b64307dd34c955b5127c3e548be81222fedcb9447a\"]},{\"address\":\"2N61LE4YwdnwCMqgWhionRQPQXx2Xt1uNme\",\"amount\":0.11110673,\"confirmations\":334,\"label\":\"\",\"txids\":[\"5e1b2275381acbcd45ac348fec5b0ba2d41556938f4f905f8c4b541d177d2859\"]},{\"address\":\"2N7Dhn4MY57AEWtoEg6gifMRRDzsZh5z1RW\",\"amount\":0.00000935,\"confirmations\":319,\"label\":\"\",\"txids\":[\"9835e7ac93c2ab05114d0a70e4f30bd085a2c1c2d52e6b0128cebf5e2a1a73ee\"]},{\"address\":\"2N7t8koim4hbh7F9bHXpM2tbdFPKczeiYR6\",\"amount\":1.00000000,\"confirmations\":168659,\"label\":\"\",\"txids\":[\"f743bac8ddf241065cf9ef4f0cf4f50572ac467057b916c9dedf49ceff232770\"]},{\"address\":\"2N8bGAo57WEFtQF6NzDYh9PQ6PChe9vprqa\",\"amount\":6.00000000,\"confirmations\":37999,\"label\":\"\",\"txids\":[\"6424bb984e18d078b7becb1c6346f1b01dd344aba57b02d9c40933b9f40b574b\",\"afea17cc98178a7f43159be754f0ab3dea94e797665707423ae7404801cb525b\"]},{\"address\":\"2N8sE8yUdm3WPX6RnJ9cgfhhxZSz1KQYEGK\",\"amount\":5.00000000,\"confirmations\":37296,\"label\":\"\",\"txids\":[\"5115cae1985816327e9013e46ec96c02df6f0f3673396c1160a3b0ee9dbb29b0\"]},{\"address\":\"2N9vK18R8vhjLqRTyVL54ffPSwuRn8SadFY\",\"amount\":5.00000000,\"confirmations\":37119,\"label\":\"\",\"txids\":[\"e3b6d806818274fc01c708dd5fe573fe4cad98868e57127f4f700dca6f33b03b\"]},{\"address\":\"2N9zRkaXPsYRnxiMZSe4pYJDHgUf7ndnkgP\",\"amount\":0.01000000,\"confirmations\":338,\"label\":\"\",\"txids\":[\"83c5aac33091f8239f8ebd4dd3c954458b3300c572121fb977a058aa9d568b39\"]},{\"address\":\"2NBBWtjdpSyUWRJDxmp7y5BemPSu3VveAN9\",\"amount\":5.00000000,\"confirmations\":37297,\"label\":\"\",\"txids\":[\"b546215fe7af2c37f467d573d96eb29cb7a3cb42f7e1f0317626c2ea66355147\"]},{\"address\":\"2NCPqqaSgJ27wpFnS3tqKGtjjrM6W14cTGG\",\"amount\":1.00000000,\"confirmations\":164152,\"label\":\"\",\"txids\":[\"2c0720d4b1f162668926eef5969363fe50d03f2ab9bf9af9889a822096201dd6\"]},{\"address\":\"2NCw8wMTgKFfiHWvRjqEBabBPbfACT558x6\",\"amount\":0.75000000,\"confirmations\":43295,\"label\":\"\",\"txids\":[\"7e725b4ecb409e26067d3b2660d8e425f231f2427508c49f9e6399e77ed2039c\"]},{\"address\":\"2NDjYN1v9ePkaHRy7Fzd5yggQYkJKSXkqZu\",\"amount\":0.11110945,\"confirmations\":1436,\"label\":\"\",\"txids\":[\"4c33ec96212f14ddee807475de06a046b855ca2732ecc3cd278453b7a45b055f\"]},{\"address\":\"2NE3RGHBsEvLHH94pavUynKBnnTsf71Z3eG\",\"amount\":2.50000000,\"confirmations\":43494,\"label\":\"\",\"txids\":[\"04faf7f6d18834b07e2a68bb984c182f703dbd79750066d6051a9fc7f241b281\",\"6495185b0cd640bb4a93119e6e1e803e5a6f0084a8fe769b4b77b040c84a9bb3\"]},{\"address\":\"2NFd8rQN4Ac5wR7AJ33a9wdnYM8zCYk15Zo\",\"amount\":1.00000000,\"confirmations\":167265,\"label\":\"\",\"txids\":[\"e06881d6dcc38bf75d927cd86b10692351474bd6796f51291695f5aed7d8117d\"]},{\"address\":\"2NGHxirUdSngYkgR12wWiUWfKbjEre5pcvK\",\"amount\":0.50000000,\"confirmations\":2090,\"label\":\"\",\"txids\":[\"964edb30a0495826ac69c46dbe1ad16a876f20806f4ed464b63b540cebf0f499\"]}],\"error\":null,\"id\":null}");

        List<BtcRpcReceivedByAddressResponse> list = undertest.listReceivedByAddress();
        for (BtcRpcReceivedByAddressResponse btcRpcReceivedByAddressResponse : list) {
            System.out.println(btcRpcReceivedByAddressResponse);
        }
        BtcRpcReceivedByAddressResponse btcRpcReceivedByAddressResponse = list.get(0);
        Assert.assertEquals("Expected equals ", "mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B", btcRpcReceivedByAddressResponse.getAddress());
    }

    /**
     * Test list labels.
     *
     * @throws Exception the exception
     */
    @Test
    public void testListLabels() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":[\"\",\"5882b41f-2053-4810-adc4-9d83f1cf807c\",\"MultiSigAddress\",\"c24e9022-3636-4cec-a195-83d3ff6b94cc\",\"pk\"],\"error\":null,\"id\":null}");

        String purpose = null;
        List<String> list = undertest.listLabels(purpose);
        String label2 = list.get(1);
        Assert.assertEquals("Expected equals ", "5882b41f-2053-4810-adc4-9d83f1cf807c", label2);
    }

    /**
     * Test list lock unspent.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testListLockUnspent() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

        undertest.listLockUnspent();
        Assert.fail("Test method not implemented");
    }

    /**
     * Test list received by label.
     *
     * @throws Exception the exception
     */
    @Test
    public void testListReceivedByLabel() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":[{\"amount\":33.34445198,\"confirmations\":550,\"label\":\"\"},{\"amount\":37.03741355,\"confirmations\":160819,\"label\":\"pk\"}],\"error\":null,\"id\":null}");

        Long minconf = null;
        Boolean includeEmpty = null;
        Boolean includeWatchonly = null;
        List<BtcRpcListReceivedByLabelResponse> list = undertest.listReceivedByLabel(minconf, includeEmpty, includeWatchonly);
        BtcRpcListReceivedByLabelResponse btcRpcListReceivedByLabelResponse = list.get(1);

        Assert.assertEquals("Expected equals ", "pk", btcRpcListReceivedByLabelResponse.getLabel());

    }

    /**
     * Test list transactions.
     *
     * @throws Exception the exception
     */
    @Test
    public void testListTransactions() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":[{\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"category\":\"receive\",\"amount\":0.01000000,\"label\":\"pk\",\"vout\":1,\"confirmations\":161043,\"blockhash\":\"0000000000014ae540b0d98d4a6f46694d2dee57d770556f504921c56f715d42\",\"blockindex\":27,\"blocktime\":1546948702,\"txid\":\"48ca542f098efa1e2753e93576da468b4f607b4c8e6206d1d1161e848158865b\",\"walletconflicts\":[],\"time\":1575907225,\"timereceived\":1575912348,\"bip125-replaceable\":\"no\"},{\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"category\":\"receive\",\"amount\":0.01000000,\"label\":\"pk\",\"vout\":1,\"confirmations\":161043,\"blockhash\":\"0000000000014ae540b0d98d4a6f46694d2dee57d770556f504921c56f715d42\",\"blockindex\":28,\"blocktime\":1546948702,\"txid\":\"00c2b45ddb430da8559eb723295af3d050b08524243d4e2c231b3b5939036663\",\"walletconflicts\":[],\"time\":1575907225,\"timereceived\":1575912348,\"bip125-replaceable\":\"no\"},{\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"category\":\"receive\",\"amount\":0.01000000,\"label\":\"pk\",\"vout\":0,\"confirmations\":161043,\"blockhash\":\"0000000000014ae540b0d98d4a6f46694d2dee57d770556f504921c56f715d42\",\"blockindex\":29,\"blocktime\":1546948702,\"txid\":\"17493c103fb57b54d73dc79129fa2ec1141ea1fd337c821d3134f43d60940472\",\"walletconflicts\":[],\"time\":1575907225,\"timereceived\":1575912348,\"bip125-replaceable\":\"no\"},{\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"category\":\"receive\",\"amount\":0.01000000,\"label\":\"pk\",\"vout\":1,\"confirmations\":161043,\"blockhash\":\"0000000000014ae540b0d98d4a6f46694d2dee57d770556f504921c56f715d42\",\"blockindex\":31,\"blocktime\":1546948702,\"txid\":\"e65dff55c8003fb72d098f25c22011ff5602751ad6d69bfafad0b2e0379ddc82\",\"walletconflicts\":[],\"time\":1575907225,\"timereceived\":1575912348,\"bip125-replaceable\":\"no\"},{\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"category\":\"receive\",\"amount\":0.01000000,\"label\":\"pk\",\"vout\":1,\"confirmations\":161043,\"blockhash\":\"0000000000014ae540b0d98d4a6f46694d2dee57d770556f504921c56f715d42\",\"blockindex\":33,\"blocktime\":1546948702,\"txid\":\"333f87e9d1fe375b697bed22c819df0b50afcb3ea4fda53da6c89ff736bd6c85\",\"walletconflicts\":[],\"time\":1575907225,\"timereceived\":1575912348,\"bip125-replaceable\":\"no\"},{\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"category\":\"receive\",\"amount\":0.01000000,\"label\":\"pk\",\"vout\":1,\"confirmations\":161043,\"blockhash\":\"0000000000014ae540b0d98d4a6f46694d2dee57d770556f504921c56f715d42\",\"blockindex\":34,\"blocktime\":1546948702,\"txid\":\"9a51d0fe191c86c29985aec0c53801f3b9dffd00449ad8186f8186e6c18a429d\",\"walletconflicts\":[],\"time\":1575907225,\"timereceived\":1575912349,\"bip125-replaceable\":\"no\"},{\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"category\":\"receive\",\"amount\":0.01000000,\"label\":\"pk\",\"vout\":1,\"confirmations\":161043,\"blockhash\":\"0000000000014ae540b0d98d4a6f46694d2dee57d770556f504921c56f715d42\",\"blockindex\":35,\"blocktime\":1546948702,\"txid\":\"7be8ccbf6c3182b87e9ce1ef81737b21e069701a2b8eec0bab14a75daf33569f\",\"walletconflicts\":[],\"time\":1575907225,\"timereceived\":1575912349,\"bip125-replaceable\":\"no\"},{\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"category\":\"receive\",\"amount\":0.01000000,\"label\":\"pk\",\"vout\":1,\"confirmations\":161043,\"blockhash\":\"0000000000014ae540b0d98d4a6f46694d2dee57d770556f504921c56f715d42\",\"blockindex\":40,\"blocktime\":1546948702,\"txid\":\"4849c58eb44609835d8037a134273fdc451672b33f61cb63f47d67f9c0b90ae0\",\"walletconflicts\":[],\"time\":1575907225,\"timereceived\":1575912349,\"bip125-replaceable\":\"no\"},{\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"category\":\"receive\",\"amount\":0.01000000,\"label\":\"pk\",\"vout\":1,\"confirmations\":161025,\"blockhash\":\"00000000000000b4f98f2382f0b6c7b72a7943070cb9044837ceed516ea18da7\",\"blockindex\":5,\"blocktime\":1546957811,\"txid\":\"02424a9e8447839b591b08dc8a9f260ce3f115554e78dd01d58422c2289b1f4e\",\"walletconflicts\":[],\"time\":1575907225,\"timereceived\":1575912349,\"bip125-replaceable\":\"no\"},{\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"category\":\"receive\",\"amount\":0.16924478,\"label\":\"pk\",\"vout\":420,\"confirmations\":160820,\"blockhash\":\"0000000000000064c5191e721174cc86c02fd9f15348161e3e5ae2141c52611b\",\"blockindex\":46,\"blocktime\":1547057761,\"txid\":\"286315130560be6804bfa3d9987be7b8b3430e36890d2df55ca16a92475591bd\",\"walletconflicts\":[],\"time\":1575907225,\"timereceived\":1575912352,\"bip125-replaceable\":\"no\"}],\"error\":null,\"id\":null}");

        String dummy = null;
        Long count = null;
        Long skip = null;
        Boolean includeWatchonly = null;
        List<BtcRpcGetTransactionResponse> list = undertest.listTransactions(dummy, count, skip, includeWatchonly);
        BtcRpcGetTransactionResponse btcRpcGetTransactionResponse = list.get(0);
        Assert.assertEquals("Expected equals ", "mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B", btcRpcGetTransactionResponse.getAddress());

    }

    /**
     * Test list unspent.
     *
     * @throws Exception the exception
     */
    @Test
    public void testListUnspent() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":[{\"txid\":\"d194a86df899efa2b56eafdd44236654b28f1df38f8b26dbe7270cca2e13ea00\",\"vout\":1,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.01000000,\"confirmations\":161044,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"0c91863a8cb26d5c00ea4ccf029ac3391f14188957f5e2957dbd0fecf195000e\",\"vout\":0,\"address\":\"2NFykDHHBwLN1aCuAc3afAhptihuMosN2pV\",\"redeemScript\":\"00145e0e6373bf8a0e3009c65ada5bde1a369198bd7d\",\"scriptPubKey\":\"a914f95d77aa51aca539204a1d05c546a3cfbd92bed987\",\"amount\":0.00998795,\"confirmations\":566,\"spendable\":true,\"solvable\":true,\"desc\":\"sh(wpkh([9684e63a/0'/1'/38']02ac6727200a64d5811adea492d10706d8c1a7dcbcbd9a5ae2062fb079dd920f88))#z9y6f9y2\",\"safe\":true},{\"txid\":\"0c91863a8cb26d5c00ea4ccf029ac3391f14188957f5e2957dbd0fecf195000e\",\"vout\":1,\"address\":\"2MwMnSLgff7KpnpYWYmS2ee3ZcVfM7CUiCL\",\"label\":\"\",\"redeemScript\":\"00143e405390e486b3752922b0a3cb6d2b68f26e7c3d\",\"scriptPubKey\":\"a9142d1e160f5d0c9f087d9616516114b7f0f811dcf287\",\"amount\":0.11110855,\"confirmations\":566,\"spendable\":true,\"solvable\":true,\"desc\":\"sh(wpkh([9684e63a/0'/0'/17']029eebf40ab9295abdf8498e57acc04956d2042828afe95dbf0c32e7e794e6d15d))#sf4yvr2y\",\"safe\":true},{\"txid\":\"485048d0a92bd87e63f18a071cf69912566cb34c868d376dab60494ea74ded1b\",\"vout\":0,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.01000000,\"confirmations\":161044,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"83c5aac33091f8239f8ebd4dd3c954458b3300c572121fb977a058aa9d568b39\",\"vout\":0,\"address\":\"2MsJXuMzy3aok14ovudMADh7jUf7Gv9bH8c\",\"redeemScript\":\"0014fa6f4b2b80ed64e8be4bc47a050666d2a3070a91\",\"scriptPubKey\":\"a91400a033e452b01bb7b55951d119bc0a35a146c16687\",\"amount\":0.08999668,\"confirmations\":571,\"spendable\":true,\"solvable\":true,\"desc\":\"sh(wpkh([9684e63a/0'/1'/31']02c8095ba4e362e9e60de2eb9034a9eae2290be8c7f43578926c67e3bef2e1e648))#zpkhpxc6\",\"safe\":true},{\"txid\":\"4c9564d7cbf02473e0d61e9eae816eafdfaee781055189dad45a8648173efc44\",\"vout\":0,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.24038302,\"confirmations\":161044,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"cd28c543d219768e44e22b5df4eefbbe60d497e235a8f80e2c76f251bf57a348\",\"vout\":1,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.00100000,\"confirmations\":165878,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"02424a9e8447839b591b08dc8a9f260ce3f115554e78dd01d58422c2289b1f4e\",\"vout\":1,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.01000000,\"confirmations\":161026,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"48ca542f098efa1e2753e93576da468b4f607b4c8e6206d1d1161e848158865b\",\"vout\":1,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.01000000,\"confirmations\":161044,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"00c2b45ddb430da8559eb723295af3d050b08524243d4e2c231b3b5939036663\",\"vout\":1,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.01000000,\"confirmations\":161044,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"6661dc54a1bd8c2e359192fdc4f3f0d5f74ea963629f731ef61f7a40c1260265\",\"vout\":1,\"address\":\"2NFqc9FWKM5mtemFiapXAuQWYaEXWgxPGHo\",\"redeemScript\":\"001430e38385e25a6e422f61a2e627c601ce7013e65c\",\"scriptPubKey\":\"a914f7d367573e1397f03f672da9e3dcf49e0e5fef3487\",\"amount\":0.37888723,\"confirmations\":571,\"spendable\":true,\"solvable\":true,\"desc\":\"sh(wpkh([9684e63a/0'/1'/33']02108155cc29d2750c2c8bfb592572f5341c540d0569dc2dcf186e2bf26d6323f5))#lcwsaxd0\",\"safe\":true},{\"txid\":\"17493c103fb57b54d73dc79129fa2ec1141ea1fd337c821d3134f43d60940472\",\"vout\":0,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.01000000,\"confirmations\":161044,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"fff2f68168a21d6a28f9597de8b3028e39187a8da63f70f1b6123edbae15d37e\",\"vout\":0,\"address\":\"2NDtqgyGiRY3ckvbrCvkGckDSP3svmf1fFu\",\"redeemScript\":\"00140ce560d9170e478bb60e22bd9f002eee22dc258d\",\"scriptPubKey\":\"a914e27fb557fdce2666f2021d54bc82f294a3671c1187\",\"amount\":1.48999834,\"confirmations\":571,\"spendable\":true,\"solvable\":true,\"desc\":\"sh(wpkh([9684e63a/0'/1'/34']0388b1646551d57d3c268c26207618a6bce654602744d72375f49d2c56989b4cf3))#8nshwle2\",\"safe\":true},{\"txid\":\"e65dff55c8003fb72d098f25c22011ff5602751ad6d69bfafad0b2e0379ddc82\",\"vout\":1,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.01000000,\"confirmations\":161044,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"333f87e9d1fe375b697bed22c819df0b50afcb3ea4fda53da6c89ff736bd6c85\",\"vout\":1,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.01000000,\"confirmations\":161044,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"9a51d0fe191c86c29985aec0c53801f3b9dffd00449ad8186f8186e6c18a429d\",\"vout\":1,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.01000000,\"confirmations\":161044,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"7be8ccbf6c3182b87e9ce1ef81737b21e069701a2b8eec0bab14a75daf33569f\",\"vout\":1,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.01000000,\"confirmations\":161044,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"286315130560be6804bfa3d9987be7b8b3430e36890d2df55ca16a92475591bd\",\"vout\":420,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.16924478,\"confirmations\":160821,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"4849c58eb44609835d8037a134273fdc451672b33f61cb63f47d67f9c0b90ae0\",\"vout\":1,\"address\":\"mrbZfHK4MuJYEH98w7gENLsrfnY1e4Lq8B\",\"label\":\"pk\",\"scriptPubKey\":\"76a914798891cc01f9a748ced0a35091080f58a24b468f88ac\",\"amount\":0.01000000,\"confirmations\":161044,\"spendable\":true,\"solvable\":true,\"desc\":\"pkh([798891cc]03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5)#ka2n6svh\",\"safe\":true},{\"txid\":\"9835e7ac93c2ab05114d0a70e4f30bd085a2c1c2d52e6b0128cebf5e2a1a73ee\",\"vout\":0,\"address\":\"2N7Dhn4MY57AEWtoEg6gifMRRDzsZh5z1RW\",\"label\":\"\",\"redeemScript\":\"00143cd97c0193639f25784a487652cefa0da685348d\",\"scriptPubKey\":\"a91499482056929a2ae33f52f6d95118766b3fa9f1ca87\",\"amount\":0.00000935,\"confirmations\":552,\"spendable\":true,\"solvable\":true,\"desc\":\"sh(wpkh([9684e63a/0'/0'/25']02a2825d208f84a39e8743e47ca3bbad6bf86c51f46cf3bdf84776c01e2953b404))#5w3pse6v\",\"safe\":true},{\"txid\":\"9835e7ac93c2ab05114d0a70e4f30bd085a2c1c2d52e6b0128cebf5e2a1a73ee\",\"vout\":1,\"address\":\"2N1tPPC7DwcAENQcjWRY3Kj98gZgoLHdXqK\",\"redeemScript\":\"0014b70358715715053f37922c198a37fba6ded2717d\",\"scriptPubKey\":\"a9145ec83d484536ed548b8e21822f7907b884c0fffc87\",\"amount\":0.01997451,\"confirmations\":552,\"spendable\":true,\"solvable\":true,\"desc\":\"sh(wpkh([9684e63a/0'/1'/40']02041818a3ef65ab8972cf2a35491753ad0aa9cadaaa947acf637db152f0eb196c))#u7kdyxup\",\"safe\":true}],\"error\":null,\"id\":null}");

        Long minconf = null;
        Long maxconf = null;
        String[] addresses = null;
        Boolean includeUnsafe = null;
        Object queryOptions = null;
        List<BtcRpcListUnspentResponse> list = undertest.listUnspent(minconf, maxconf, addresses, includeUnsafe, queryOptions);
        BtcRpcListUnspentResponse btcRpcListUnspentResponse = list.get(0);
        Assert.assertEquals("Expected equals ", "d194a86df899efa2b56eafdd44236654b28f1df38f8b26dbe7270cca2e13ea00",
                btcRpcListUnspentResponse.getTxid());
    }

    /**
     * Test lock unspent.
     *
     * @throws Exception the exception
     */
    @Test
    public void testLockUnspent() throws Exception {
        enqueueMockedResponse(200, "{\"result\":true,\"error\":null,\"id\":null}");

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
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

        String txid = null;
        undertest.removePrunedFunds(txid);
        Assert.fail("Test method not implemented");
    }

    /**
     * Test sendmany.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSendmany() throws Exception {
        enqueueMockedResponse(200, "{\"result\":\"6552f15e6653886176cb23c7ffa74858c6a740446ec4350434d99977dcdbca1b\",\"error\":null,\"id\":null}");

        Map<String, String> amounts = new HashMap<>();
        amounts.put("2My2MBCXKrvPu43hgr1UV2piGyiQpbT1h3G", "0.01");
        amounts.put("2NEeoeA4awwPajW74Ux6sirD4UiG738BfSb", "0.01");

        Integer minconf = 1;
        String comment = "Send to many";
        String[] subtractFeeFrom = new String[] { "", "" };
        Boolean replaceable = true;
        Long confTarget = 1L;
        EnumEstimateMode enumEstimateMode = EnumEstimateMode.CONSERVATIVE;

        String tx = undertest.sendMany(amounts, minconf, comment, subtractFeeFrom, replaceable, confTarget, enumEstimateMode);
        Assert.assertEquals("expected tx", "6552f15e6653886176cb23c7ffa74858c6a740446ec4350434d99977dcdbca1b", tx);
    }

    /**
     * Test send to address.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSendToAddress() throws Exception {
        enqueueMockedResponse(200, "{\"result\":\"a6ce4e973594048ccf39bb8e17b42259d48c2271a5b90b13a5779e82faeec8e7\",\"error\":null,\"id\":null}");

        String toAddress = "";
        BigDecimal amount = new BigDecimal("0.010");
        String comment = "";
        String commentTo = "";
        Boolean subtractFeeFromAmount = false;
        Boolean replaceable = true;
        Long confTarget = 1L;

        String txid = undertest.sendToAddress(toAddress, amount, comment, commentTo, subtractFeeFromAmount, replaceable, confTarget,
                EnumEstimateMode.CONSERVATIVE);
        Assert.assertEquals("Expected new txid", "a6ce4e973594048ccf39bb8e17b42259d48c2271a5b90b13a5779e82faeec8e7", txid);

    }

    /**
     * Test set label.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSetLabel() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

        String address = "2N3mJLegYL6pBY6xua8vn1AYrD3sRBhUnGo";
        String label = "f9941e07-2678-422c-98f8-9bbf1c371159";
        Boolean success = undertest.setLabel(address, label);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test set tx fee.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSetTxFee() throws Exception {
        enqueueMockedResponse(200, "{\"result\":true,\"error\":null,\"id\":null}");

        BigDecimal amount = new BigDecimal("0.0001");
        Boolean success = undertest.setTxFee(amount);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test sign message.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSignMessage() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":\"H7NANw7IWe77vxyDzgoCSjFLtkzJpGrIlDscgLGfSyLQP5v7GrjR+jaBsuR4bnE8QKFaQuFDJeCO3tU8eryjVAM=\",\"error\":null,\"id\":null}");

        String address = "mvF6iPEZSDScewTuryy2hPAuzrXe6xRyQK";
        String message = "Hello World";

        String signature = undertest.signMessage(address, message);
        Assert.assertEquals("Expected signature", "H7NANw7IWe77vxyDzgoCSjFLtkzJpGrIlDscgLGfSyLQP5v7GrjR+jaBsuR4bnE8QKFaQuFDJeCO3tU8eryjVAM=",
                signature);
    }

    /**
     * Test sign raw transaction with wallet.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSignRawTransactionWithWallet() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"hex\":\"020000000001030e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c00000000171600145e0e6373bf8a0e3009c65ada5bde1a369198bd7dfdffffff0e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c01000000171600143e405390e486b3752922b0a3cb6d2b68f26e7c3dfdffffff1bcadbdc7799d9340435c46e4440a7c65848a7ffc723cb76618853665ef152650100000017160014d5162b19f8f8e1122771281dc4c469dcd88c9f35fdffffff0240420f000000000017a914d8a50276e56ad7540bbab27743850600e9a8c24f8740420f000000000017a914405509f823392abb7d688e6184c0e964d4a68af18702473044022017d04bbdabee61cdbb83203a00d0cfbeb015f1ccd63ad33efa25aad4cf82a71a02207c5027c083c6c6500af119c5577c16baeac5f48e8b8967a169c15b89dcf75dda012102ac6727200a64d5811adea492d10706d8c1a7dcbcbd9a5ae2062fb079dd920f880247304402204a9412001158a2c0844602fdf7dad6bef2142b5ef538ca41d21e1463f9699f7f02204192061886eab28dcf9b340e39e3870f5433ad365dc0b03cc3eda494738ea9870121029eebf40ab9295abdf8498e57acc04956d2042828afe95dbf0c32e7e794e6d15d0247304402204d908f775508f5770fee419f615a190770034a90a5f81c930c601472b0f8af9b022071572edc3ecb6c9e49b14724d3c97e245f5d1caef7451c4b74916b27480922a60121031dd200495e02af92c3252d9927b738a8267a638527a7cef07d7de577ea7289c800000000\",\"complete\":true},\"error\":null,\"id\":null}");
        String hexstring = "";
        String hex = undertest.signRawTransactionWithWallet(hexstring);
        Assert.assertEquals("expected equals",
                "020000000001030e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c00000000171600145e0e6373bf8a0e3009c65ada5bde1a369198bd7dfdffffff0e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c01000000171600143e405390e486b3752922b0a3cb6d2b68f26e7c3dfdffffff1bcadbdc7799d9340435c46e4440a7c65848a7ffc723cb76618853665ef152650100000017160014d5162b19f8f8e1122771281dc4c469dcd88c9f35fdffffff0240420f000000000017a914d8a50276e56ad7540bbab27743850600e9a8c24f8740420f000000000017a914405509f823392abb7d688e6184c0e964d4a68af18702473044022017d04bbdabee61cdbb83203a00d0cfbeb015f1ccd63ad33efa25aad4cf82a71a02207c5027c083c6c6500af119c5577c16baeac5f48e8b8967a169c15b89dcf75dda012102ac6727200a64d5811adea492d10706d8c1a7dcbcbd9a5ae2062fb079dd920f880247304402204a9412001158a2c0844602fdf7dad6bef2142b5ef538ca41d21e1463f9699f7f02204192061886eab28dcf9b340e39e3870f5433ad365dc0b03cc3eda494738ea9870121029eebf40ab9295abdf8498e57acc04956d2042828afe95dbf0c32e7e794e6d15d0247304402204d908f775508f5770fee419f615a190770034a90a5f81c930c601472b0f8af9b022071572edc3ecb6c9e49b14724d3c97e245f5d1caef7451c4b74916b27480922a60121031dd200495e02af92c3252d9927b738a8267a638527a7cef07d7de577ea7289c800000000",
                hex);
    }

    /**
     * Test walletcreatefundedpsbt.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testWalletcreatefundedpsbt() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

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
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

        undertest.walletprocesspsbt();
        Assert.fail("Test method not implemented");
    }
}
