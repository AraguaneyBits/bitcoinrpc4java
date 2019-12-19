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

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcCreateWalletResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetWalletInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListSinceBlockResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListSinceBlockTransactionResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcLoadWalletResponse;

/**
 * The Class BtcRpcWalletToolsMethodsTest.
 *
 * @author jestevez
 */
public class BtcRpcWalletToolsMethodsTest extends AbstractBtcRpcMethodsTest {

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
    @Test
    public void testAbortRescan() throws Exception {
        enqueueMockedResponse(200, "{\"result\":true,\"error\":null,\"id\":null}");
        Boolean success = undertest.abortRescan();
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test backup wallet.
     *
     * @throws Exception the exception
     */
    @Test
    public void testBackupWallet() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        String destination = "my_wallet.bk";
        Boolean success = undertest.backupWallet(destination);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test create wallet.
     *
     * @throws Exception the exception
     */
    @Test
    public void testCreateWallet() throws Exception {
        enqueueMockedResponse(200, "{\"result\":{\"name\":\"junit_wallet\",\"warning\":\"\"},\"error\":null,\"id\":null}");
        String walletName = "junit_wallet";
        Boolean disablePrivateKeys = false;
        Boolean blank = true;
        BtcRpcCreateWalletResponse btcRpcCreateWalletResponse = undertest.createWallet(walletName, disablePrivateKeys, blank);
        Assert.assertNotNull("Is not null", btcRpcCreateWalletResponse);
        Assert.assertEquals("Expected equals", "junit_wallet", btcRpcCreateWalletResponse.getName());
    }

    /**
     * Test dump wallet.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDumpWallet() throws Exception {
        enqueueMockedResponse(200, "{\"result\":{\"filename\":\"/tmp/dumpwallet.dat\"},\"error\":null,\"id\":null}");
        String filename = "/tmp/dumpwallet.dat";
        String fileNameConfirm = undertest.dumpWallet(filename);
        Assert.assertEquals("Expected equals", filename, fileNameConfirm);
    }

    /**
     * Test encrypt wallet.
     *
     * @throws Exception the exception
     */
    @Test
    public void testEncryptWallet() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        String passphrase = "***";
        Boolean success = undertest.encryptWallet(passphrase);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test get wallet info.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetWalletInfo() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"walletname\":\"\",\"walletversion\":169900,\"balance\":5099.21616543,\"unconfirmed_balance\":0.00000000,\"immature_balance\":3675.00000000,\"txcount\":401,\"keypoololdest\":1567840385,\"keypoolsize\":998,\"keypoolsize_hd_internal\":999,\"unlocked_until\":0,\"paytxfee\":0.00000000,\"hdseedid\":\"4060400d8923486ef31b521e9f340cfed66c4722\",\"private_keys_enabled\":true},\"error\":null,\"id\":null}");
        BtcRpcGetWalletInfoResponse btcRpcGetWalletInfoResponse = undertest.getWalletInfo();
        Assert.assertTrue("Expected true", btcRpcGetWalletInfoResponse.getPrivateKeysEnabled());
    }

    /**
     * Test import wallet.
     *
     * @throws Exception the exception
     */
    @Test
    public void testImportWallet() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        String filename = "/tmp/dumpwallet.dat";
        Boolean success = undertest.importWallet(filename);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test keypool refill.
     *
     * @throws Exception the exception
     */
    @Test
    public void testKeypoolRefill() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

        Long newsize = 2L;
        Boolean success = undertest.keypoolRefill(newsize);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test list wallets.
     *
     * @throws Exception the exception
     */
    @Test
    public void testListWallets() throws Exception {
        enqueueMockedResponse(200, "{\"result\":[\"\",\"junit_wallet\"],\"error\":null,\"id\":null}");
        List<String> list = undertest.listWallets();
        Assert.assertNotNull("Is not null", list);
        Assert.assertEquals("Expected two", 2, list.size());
        String one = list.get(0);
        Assert.assertEquals("Expected equals", "", one);
        String two = list.get(1);
        Assert.assertEquals("Expected equals", "junit_wallet", two);
    }

    /**
     * Test list since block.
     *
     * @throws Exception the exception
     */
    @Test
    public void testListSinceBlock() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"transactions\":[{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.11040000,\"vout\":0,\"fee\":-0.00009961,\"confirmations\":36483,\"blockhash\":\"000000002e799bef525197b6aafed5839d0384f075626d9c3efc33dcaaebbeec\",\"blockindex\":46,\"blocktime\":1565902989,\"txid\":\"a8806059d0d555beacfdcf53a13f6c31ad9fd97fad61541780dcb16733fa1705\",\"walletconflicts\":[],\"time\":1565902956,\"timereceived\":1565902956,\"bip125-replaceable\":\"no\",\"comment\":\"withdraw-114\",\"to\":\"Araguaneybits\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.62970256,\"vout\":1,\"fee\":-0.00006640,\"confirmations\":36421,\"blockhash\":\"00000000c9c61a5fadad84e6a896c5b009efb3ba4fd76af877cb05e438464d74\",\"blockindex\":69,\"blocktime\":1565954871,\"txid\":\"aa856e6b748da6fc94a37d1c4f8d4f00cd489f476ddafa543577b70e629f7e0e\",\"walletconflicts\":[],\"time\":1565953656,\"timereceived\":1565953656,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.62970256,\"vout\":1,\"fee\":-0.00000166,\"confirmations\":36274,\"blockhash\":\"00000000d258fc7a1386708d0acdd5a37425e53a5153b20ed56aa0c92178d3d7\",\"blockindex\":30,\"blocktime\":1566073639,\"txid\":\"6114392fe6062578f774e604100be3bd1cb555005026ff91453d3c87cf71bb12\",\"walletconflicts\":[],\"time\":1566072941,\"timereceived\":1566072941,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.10040000,\"vout\":1,\"fee\":-0.00009961,\"confirmations\":36481,\"blockhash\":\"00000000c2fcc605d9b73b7303770c5a2854e7dcae3d53bb47ce1a2e22f8e305\",\"blockindex\":36,\"blocktime\":1565905403,\"txid\":\"11238bae0ff8334ac921fbe0163f607c412e8cea0cd5e0c070c26af71a600613\",\"walletconflicts\":[],\"time\":1565905160,\"timereceived\":1565905160,\"bip125-replaceable\":\"no\",\"comment\":\"withdraw-120\",\"to\":\"Araguaneybits\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.02000000,\"vout\":1,\"fee\":-0.00006640,\"confirmations\":36474,\"blockhash\":\"0000000082d8889311932f257c9c20bf23b13dea6c65c6835a7dbd38837b34c9\",\"blockindex\":35,\"blocktime\":1565912482,\"txid\":\"f0d1e5a4b5da27d326a83a17ef50845ef2bb1fd5d6c68185eeb134a62510a51a\",\"walletconflicts\":[],\"time\":1565911474,\"timereceived\":1565911474,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2MzxM6kH9SdvtqZAkjuDW1XTaRpVVZTtC5a\",\"category\":\"receive\",\"amount\":2.00000000,\"label\":\"\",\"vout\":1,\"confirmations\":42506,\"blockhash\":\"00000000000994530b1c53f31029f3b66ff330738885ff2262c4a00018b0b3fa\",\"blockindex\":84,\"blocktime\":1562948626,\"txid\":\"5177009e754fb1b32b925cbac99c70acc37af158f8f82a571e264089c674221d\",\"walletconflicts\":[],\"time\":1562948503,\"timereceived\":1562948503,\"bip125-replaceable\":\"no\"},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.33339999,\"vout\":1,\"fee\":-0.00006640,\"confirmations\":36476,\"blockhash\":\"0000000000000176584c2ece75eaa52715586de910ddb851e27499badd436052\",\"blockindex\":12,\"blocktime\":1565910063,\"txid\":\"a6d3f04df4bc91c81d71a270aa068eec3ecf86393d1b4e2e0545b6ac4f732b1e\",\"walletconflicts\":[],\"time\":1565909923,\"timereceived\":1565909923,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.30760000,\"vout\":1,\"fee\":-0.00009961,\"confirmations\":36482,\"blockhash\":\"000000002e1c63630e0bb29eec116633f991661b256b39364b3892f2070fa7ef\",\"blockindex\":30,\"blocktime\":1565904199,\"txid\":\"272ff4c0633342cce0d7bd877437d1ec168644375af5e6a2bfa628d15aa1e129\",\"walletconflicts\":[],\"time\":1565903860,\"timereceived\":1565903860,\"bip125-replaceable\":\"no\",\"comment\":\"withdraw-119\",\"to\":\"Araguaneybits\",\"abandoned\":false},{\"address\":\"2Mv81afTw7uFCxtokMM4ZTbuETCAaQPUSWQ\",\"category\":\"receive\",\"amount\":0.10000000,\"label\":\"\",\"vout\":0,\"confirmations\":1187,\"blockhash\":\"00000000000000e4c010ce388bb4635568817d8dd3e851a2dfa2853cf4ec3d6c\",\"blockindex\":152,\"blocktime\":1574885489,\"txid\":\"ff0f593a751f5cf60e665e2e2caeefa7b9aee594025af7398b852ba8664df329\",\"walletconflicts\":[],\"time\":1574885440,\"timereceived\":1574885440,\"bip125-replaceable\":\"no\"},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.11140000,\"vout\":1,\"fee\":-0.00006640,\"confirmations\":36476,\"blockhash\":\"0000000000000176584c2ece75eaa52715586de910ddb851e27499badd436052\",\"blockindex\":13,\"blocktime\":1565910063,\"txid\":\"65634e9c4fb5b5c7550dd191378b60339972addc82bef7465fdd71a5bc598b30\",\"walletconflicts\":[],\"time\":1565909925,\"timereceived\":1565909925,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.10040000,\"vout\":1,\"fee\":-0.00009961,\"confirmations\":36481,\"blockhash\":\"00000000c2fcc605d9b73b7303770c5a2854e7dcae3d53bb47ce1a2e22f8e305\",\"blockindex\":40,\"blocktime\":1565905403,\"txid\":\"00c4973ee799413b71ca81fc5c9f353ea4aba1883f1acc36564cff5d2a3c0f3b\",\"walletconflicts\":[],\"time\":1565904587,\"timereceived\":1565904587,\"bip125-replaceable\":\"no\",\"comment\":\"withdraw-120\",\"to\":\"Araguaneybits\",\"abandoned\":false},{\"address\":\"2N9vK18R8vhjLqRTyVL54ffPSwuRn8SadFY\",\"category\":\"receive\",\"amount\":5.00000000,\"label\":\"\",\"vout\":0,\"confirmations\":36101,\"blockhash\":\"000000000000e2f0f9d1f5c292f91be3f141e5b9bab806baa00a30cb37384b24\",\"blockindex\":100,\"blocktime\":1566234080,\"txid\":\"e3b6d806818274fc01c708dd5fe573fe4cad98868e57127f4f700dca6f33b03b\",\"walletconflicts\":[],\"time\":1566233829,\"timereceived\":1566233829,\"bip125-replaceable\":\"no\"},{\"address\":\"2NBBWtjdpSyUWRJDxmp7y5BemPSu3VveAN9\",\"category\":\"receive\",\"amount\":5.00000000,\"label\":\"\",\"vout\":1,\"confirmations\":36279,\"blockhash\":\"00000000803bc811c470b3641655d2055afff757e3f9b0caf0a19754b70469c0\",\"blockindex\":55,\"blocktime\":1566070285,\"txid\":\"b546215fe7af2c37f467d573d96eb29cb7a3cb42f7e1f0317626c2ea66355147\",\"walletconflicts\":[],\"time\":1566069642,\"timereceived\":1566069642,\"bip125-replaceable\":\"no\"},{\"address\":\"2N8bGAo57WEFtQF6NzDYh9PQ6PChe9vprqa\",\"category\":\"receive\",\"amount\":5.00000000,\"label\":\"\",\"vout\":0,\"confirmations\":36986,\"blockhash\":\"000000000000029364d4e19d93007e098b5ceb3e9954d3ce3fce0b0ac70349e4\",\"blockindex\":496,\"blocktime\":1565713113,\"txid\":\"6424bb984e18d078b7becb1c6346f1b01dd344aba57b02d9c40933b9f40b574b\",\"walletconflicts\":[],\"time\":1565710891,\"timereceived\":1565710891,\"bip125-replaceable\":\"no\"},{\"address\":\"2N5FYdbHZUDfwMdodzQ4bsj8LMVT8rCsgUW\",\"category\":\"receive\",\"amount\":1.00000000,\"label\":\"\",\"vout\":0,\"confirmations\":36274,\"blockhash\":\"00000000d258fc7a1386708d0acdd5a37425e53a5153b20ed56aa0c92178d3d7\",\"blockindex\":29,\"blocktime\":1566073639,\"txid\":\"ab9553422fdda3db10516de7d3916509d01e98c8d2335cf4fdda2a03a7e30b54\",\"walletconflicts\":[],\"time\":1566072726,\"timereceived\":1566072726,\"bip125-replaceable\":\"no\"},{\"address\":\"2N4UN9iYAj4qcQHcafZ4VbqkSeVWjLg54rc\",\"category\":\"send\",\"amount\":-0.11110855,\"label\":\"\",\"vout\":0,\"fee\":-0.00000256,\"confirmations\":417,\"blockhash\":\"000000000000012a3448806fa3c0897ef1e01e146a3fccd2523e662d93e69fc7\",\"blockindex\":253,\"blocktime\":1575295840,\"txid\":\"514705918497fbb4badda437bc771778b3034ed461680d1bfa1d53578629f157\",\"walletconflicts\":[],\"time\":1575294850,\"timereceived\":1575294850,\"bip125-replaceable\":\"no\",\"comment\":\"prioritisetransaction-1575294850298\",\"abandoned\":false},{\"address\":\"2N4UN9iYAj4qcQHcafZ4VbqkSeVWjLg54rc\",\"category\":\"receive\",\"amount\":0.11110855,\"label\":\"\",\"vout\":0,\"confirmations\":417,\"blockhash\":\"000000000000012a3448806fa3c0897ef1e01e146a3fccd2523e662d93e69fc7\",\"blockindex\":253,\"blocktime\":1575295840,\"txid\":\"514705918497fbb4badda437bc771778b3034ed461680d1bfa1d53578629f157\",\"walletconflicts\":[],\"time\":1575294850,\"timereceived\":1575294850,\"bip125-replaceable\":\"no\",\"comment\":\"prioritisetransaction-1575294850298\"},{\"address\":\"2N8bGAo57WEFtQF6NzDYh9PQ6PChe9vprqa\",\"category\":\"receive\",\"amount\":1.00000000,\"label\":\"\",\"vout\":1,\"confirmations\":36981,\"blockhash\":\"00000000b62b2cf45420f0b2acc132711d920c8adb6fbe342e7f7fca016a194c\",\"blockindex\":7,\"blocktime\":1565715213,\"txid\":\"afea17cc98178a7f43159be754f0ab3dea94e797665707423ae7404801cb525b\",\"walletconflicts\":[],\"time\":1565713929,\"timereceived\":1565713929,\"bip125-replaceable\":\"no\"},{\"address\":\"2NDjYN1v9ePkaHRy7Fzd5yggQYkJKSXkqZu\",\"category\":\"send\",\"amount\":-0.11110945,\"label\":\"\",\"vout\":0,\"fee\":-0.00000166,\"confirmations\":418,\"blockhash\":\"00000000000002bf2b9851b8855442d174d89aeae2b85b70945f04b8ac386edf\",\"blockindex\":55,\"blocktime\":1575294745,\"txid\":\"4c33ec96212f14ddee807475de06a046b855ca2732ecc3cd278453b7a45b055f\",\"walletconflicts\":[],\"time\":1575294643,\"timereceived\":1575294643,\"bip125-replaceable\":\"no\",\"comment\":\"prioritisetransaction-1575294642470\",\"abandoned\":false},{\"address\":\"2NDjYN1v9ePkaHRy7Fzd5yggQYkJKSXkqZu\",\"category\":\"receive\",\"amount\":0.11110945,\"label\":\"\",\"vout\":0,\"confirmations\":418,\"blockhash\":\"00000000000002bf2b9851b8855442d174d89aeae2b85b70945f04b8ac386edf\",\"blockindex\":55,\"blocktime\":1575294745,\"txid\":\"4c33ec96212f14ddee807475de06a046b855ca2732ecc3cd278453b7a45b055f\",\"walletconflicts\":[],\"time\":1575294643,\"timereceived\":1575294643,\"bip125-replaceable\":\"no\",\"comment\":\"prioritisetransaction-1575294642470\"},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.01040000,\"vout\":1,\"fee\":-0.00009961,\"confirmations\":36482,\"blockhash\":\"000000002e1c63630e0bb29eec116633f991661b256b39364b3892f2070fa7ef\",\"blockindex\":35,\"blocktime\":1565904199,\"txid\":\"0bc4cf82bc938ec0615522f37ef395c92ff539de0896ec4db979999a2b0f9469\",\"walletconflicts\":[],\"time\":1565903597,\"timereceived\":1565903597,\"bip125-replaceable\":\"no\",\"comment\":\"withdraw-117\",\"to\":\"Araguaneybits\",\"abandoned\":false},{\"address\":\"2N7t8koim4hbh7F9bHXpM2tbdFPKczeiYR6\",\"category\":\"receive\",\"amount\":1.00000000,\"label\":\"\",\"vout\":1,\"confirmations\":167641,\"blockhash\":\"000000000014b81fa600563e09cceba7cb960b69c8598fb5e0a88c251df4638e\",\"blockindex\":20,\"blocktime\":1542306756,\"txid\":\"f743bac8ddf241065cf9ef4f0cf4f50572ac467057b916c9dedf49ceff232770\",\"walletconflicts\":[],\"time\":1542305678,\"timereceived\":1542305678,\"bip125-replaceable\":\"no\"},{\"address\":\"2Msp7G6jBsUC2gE9AFTxK3tm7JN79sYE6wT\",\"category\":\"send\",\"amount\":-1.50000000,\"vout\":0,\"fee\":-0.00000166,\"confirmations\":36274,\"blockhash\":\"00000000d258fc7a1386708d0acdd5a37425e53a5153b20ed56aa0c92178d3d7\",\"blockindex\":34,\"blocktime\":1566073639,\"txid\":\"bf1c5f9534f202d5941bd985f8e4c10bfd046ecd1489b01ba7b9bd0ea4b9fe70\",\"walletconflicts\":[],\"time\":1566073531,\"timereceived\":1566073531,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2Msp7G6jBsUC2gE9AFTxK3tm7JN79sYE6wT\",\"category\":\"send\",\"amount\":-1.00000000,\"vout\":0,\"fee\":-0.00000166,\"confirmations\":36274,\"blockhash\":\"00000000d258fc7a1386708d0acdd5a37425e53a5153b20ed56aa0c92178d3d7\",\"blockindex\":35,\"blocktime\":1566073639,\"txid\":\"7baf58c078ef499bd0c264931473b1e8ce715cd67e721b86026b41e69ad7357a\",\"walletconflicts\":[],\"time\":1566073534,\"timereceived\":1566073534,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2N5kfro4cHwNiTS2rvm9zxsNsYAHDpNQ952\",\"category\":\"receive\",\"amount\":0.50000000,\"label\":\"\",\"vout\":0,\"confirmations\":42367,\"blockhash\":\"0000000060d67878e78ede22c2b98221f71f23a3cfcbfbeba8d166d31f524943\",\"blockindex\":113,\"blocktime\":1563052938,\"txid\":\"1861a5fd89a98543178003b64307dd34c955b5127c3e548be81222fedcb9447a\",\"walletconflicts\":[],\"time\":1563052557,\"timereceived\":1563052557,\"bip125-replaceable\":\"no\"},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.02040000,\"vout\":0,\"fee\":-0.00009961,\"confirmations\":36482,\"blockhash\":\"000000002e1c63630e0bb29eec116633f991661b256b39364b3892f2070fa7ef\",\"blockindex\":37,\"blocktime\":1565904199,\"txid\":\"e5fc0b5afb1d0254a143be09755fece9795a1856db1174a74c3afb2dc5a3a77c\",\"walletconflicts\":[],\"time\":1565903594,\"timereceived\":1565903594,\"bip125-replaceable\":\"no\",\"comment\":\"withdraw-118\",\"to\":\"Araguaneybits\",\"abandoned\":false},{\"address\":\"2NFd8rQN4Ac5wR7AJ33a9wdnYM8zCYk15Zo\",\"category\":\"receive\",\"amount\":1.00000000,\"label\":\"\",\"vout\":1,\"confirmations\":166247,\"blockhash\":\"0000000000000055002d3b50c452c0ffefe104ce3c273e34ecb8e9246b24484b\",\"blockindex\":5,\"blocktime\":1543072290,\"txid\":\"e06881d6dcc38bf75d927cd86b10692351474bd6796f51291695f5aed7d8117d\",\"walletconflicts\":[],\"time\":1543072123,\"timereceived\":1543072123,\"bip125-replaceable\":\"no\"},{\"address\":\"my9bAnczHE6ivXhXDtm2BwZMo1XCJ1Fsgp\",\"category\":\"send\",\"amount\":-2.99993020,\"vout\":0,\"fee\":-0.00006980,\"confirmations\":42683,\"blockhash\":\"00000000000002ed67c4388a69fe22a341d4249c18289e79636d69a0195ddc2e\",\"blockindex\":418,\"blocktime\":1562864330,\"txid\":\"8c4e3b6e6dc4415b36293c3d2db959036de75657eabb4e464d1c1352cbcce47e\",\"walletconflicts\":[],\"time\":1562862904,\"timereceived\":1562862904,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.13039999,\"vout\":1,\"fee\":-0.00009961,\"confirmations\":36485,\"blockhash\":\"00000000f67901b628ee3ba59b4f57cd95bfbb8e909b4bf0e6b46ae31c3404a0\",\"blockindex\":44,\"blocktime\":1565900576,\"txid\":\"30474ade7ba501befed89b242939083200f5d67fd81e2eee9705c270c4b18680\",\"walletconflicts\":[],\"time\":1565900108,\"timereceived\":1565900108,\"bip125-replaceable\":\"no\",\"comment\":\"withdraw-116\",\"to\":\"Araguaneybits\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.13199999,\"vout\":1,\"fee\":-0.00006640,\"confirmations\":36424,\"blockhash\":\"000000006b9ab5424184ec0768f4c56d61bb2b958a1e86f1b5e7697a1cf9b334\",\"blockindex\":126,\"blocktime\":1565951491,\"txid\":\"4f4f9dd734caa7d498719fb1dcee637702d8f3e365d4ddf2fb8b3722bb96a681\",\"walletconflicts\":[],\"time\":1565950571,\"timereceived\":1565950571,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2NE3RGHBsEvLHH94pavUynKBnnTsf71Z3eG\",\"category\":\"receive\",\"amount\":1.50000000,\"label\":\"\",\"vout\":1,\"confirmations\":42476,\"blockhash\":\"000000000006687f9372ae35248803cbd6bb58159f415b6de302ce24dda19d53\",\"blockindex\":102,\"blocktime\":1562970361,\"txid\":\"04faf7f6d18834b07e2a68bb984c182f703dbd79750066d6051a9fc7f241b281\",\"walletconflicts\":[],\"time\":1562969796,\"timereceived\":1562969796,\"bip125-replaceable\":\"no\"},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.10040000,\"vout\":1,\"fee\":-0.00006640,\"confirmations\":36477,\"blockhash\":\"0000000050bb051d943a5353ecae290820c43d36a1fdc3d847a5d2c441884fff\",\"blockindex\":19,\"blocktime\":1565909224,\"txid\":\"74c37d15d3ae35fef7c81b869bda0aeec20d1dd1e35cf9661c86ead2ca3d3185\",\"walletconflicts\":[],\"time\":1565908569,\"timereceived\":1565908569,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2N5ZGvLmEgyqSbhYuytvmKohxF37cMyiEct\",\"category\":\"send\",\"amount\":-15.79512813,\"vout\":0,\"fee\":-0.00000769,\"confirmations\":1187,\"blockhash\":\"00000000000000e4c010ce388bb4635568817d8dd3e851a2dfa2853cf4ec3d6c\",\"blockindex\":182,\"blocktime\":1574885489,\"txid\":\"657e47408268cc7d646a1b563f6462bb46fd1b81e8f39c22605883f9d9b0ae85\",\"walletconflicts\":[],\"time\":1574884873,\"timereceived\":1574884873,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2NGHxirUdSngYkgR12wWiUWfKbjEre5pcvK\",\"category\":\"receive\",\"amount\":0.50000000,\"label\":\"\",\"vout\":1,\"confirmations\":1072,\"blockhash\":\"00000000b63bcd66d1e074f8058cc7e30e360d15a9c1445aa5d2de600ab0de3f\",\"blockindex\":70,\"blocktime\":1574967475,\"txid\":\"964edb30a0495826ac69c46dbe1ad16a876f20806f4ed464b63b540cebf0f499\",\"walletconflicts\":[],\"time\":1574966770,\"timereceived\":1574966770,\"bip125-replaceable\":\"no\"},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.30760000,\"vout\":1,\"fee\":-0.00006640,\"confirmations\":36477,\"blockhash\":\"0000000050bb051d943a5353ecae290820c43d36a1fdc3d847a5d2c441884fff\",\"blockindex\":20,\"blocktime\":1565909224,\"txid\":\"d2737639b525a3a80c3c035ee3ae76959ae1b040e8f236f706f0a2a4cb801c9a\",\"walletconflicts\":[],\"time\":1565908741,\"timereceived\":1565908741,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2NCw8wMTgKFfiHWvRjqEBabBPbfACT558x6\",\"category\":\"receive\",\"amount\":0.75000000,\"label\":\"\",\"vout\":0,\"confirmations\":42277,\"blockhash\":\"0000000000000298d6c342979bcb583dcabdd0ab7d82a31362ecd04c1aeef5df\",\"blockindex\":120,\"blocktime\":1563119269,\"txid\":\"7e725b4ecb409e26067d3b2660d8e425f231f2427508c49f9e6399e77ed2039c\",\"walletconflicts\":[],\"time\":1563118547,\"timereceived\":1563118547,\"bip125-replaceable\":\"no\"},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.12240000,\"vout\":1,\"fee\":-0.00006640,\"confirmations\":36476,\"blockhash\":\"0000000000000176584c2ece75eaa52715586de910ddb851e27499badd436052\",\"blockindex\":14,\"blocktime\":1565910063,\"txid\":\"1bf6ac91c7ea30a47292ba0755962954ffb42018c30dc983e922cdb7e65810ae\",\"walletconflicts\":[],\"time\":1565909920,\"timereceived\":1565909920,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.10000000,\"vout\":0,\"fee\":-0.00006640,\"confirmations\":36474,\"blockhash\":\"0000000082d8889311932f257c9c20bf23b13dea6c65c6835a7dbd38837b34c9\",\"blockindex\":36,\"blocktime\":1565912482,\"txid\":\"41c38584f26cea5f1ed48359a8d633b59cac6e6c45f3b114f0ffc5e268655fae\",\"walletconflicts\":[],\"time\":1565911469,\"timereceived\":1565911469,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2N8sE8yUdm3WPX6RnJ9cgfhhxZSz1KQYEGK\",\"category\":\"receive\",\"amount\":5.00000000,\"label\":\"\",\"vout\":0,\"confirmations\":36278,\"blockhash\":\"000000000000c15417869f21c799e7fd5d80801c3e9abe2a385a56085ba7f018\",\"blockindex\":45,\"blocktime\":1566071504,\"txid\":\"5115cae1985816327e9013e46ec96c02df6f0f3673396c1160a3b0ee9dbb29b0\",\"walletconflicts\":[],\"time\":1566070735,\"timereceived\":1566070735,\"bip125-replaceable\":\"no\"},{\"address\":\"2Mv81afTw7uFCxtokMM4ZTbuETCAaQPUSWQ\",\"category\":\"receive\",\"amount\":1.50000000,\"label\":\"\",\"vout\":0,\"confirmations\":1143,\"blockhash\":\"00000000077d3861a7e2e251bba4086a30a43e1d1baaa9f5a708727935b96194\",\"blockindex\":11,\"blocktime\":1574921696,\"txid\":\"c3a893d7b97e6cb278a17150dfa298458ebdbdfb40f226305556e14c187801b3\",\"walletconflicts\":[],\"time\":1574921605,\"timereceived\":1574921605,\"bip125-replaceable\":\"no\"},{\"address\":\"2NE3RGHBsEvLHH94pavUynKBnnTsf71Z3eG\",\"category\":\"receive\",\"amount\":1.00000000,\"label\":\"\",\"vout\":0,\"confirmations\":42476,\"blockhash\":\"000000000006687f9372ae35248803cbd6bb58159f415b6de302ce24dda19d53\",\"blockindex\":106,\"blocktime\":1562970361,\"txid\":\"6495185b0cd640bb4a93119e6e1e803e5a6f0084a8fe769b4b77b040c84a9bb3\",\"walletconflicts\":[],\"time\":1562969784,\"timereceived\":1562969784,\"bip125-replaceable\":\"no\"},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.30040000,\"vout\":0,\"fee\":-0.00008317,\"confirmations\":36487,\"blockhash\":\"00000000000001a9ec9864173bd867de1d6ec5aa35866a15e5d47ab9138b6f63\",\"blockindex\":62,\"blocktime\":1565898151,\"txid\":\"93be2a1b56dc7c065db276d1ec480d1c5294c218c00116dc4edd62988ee200c0\",\"walletconflicts\":[],\"time\":1565895726,\"timereceived\":1565895726,\"bip125-replaceable\":\"no\",\"comment\":\"withdraw-113\",\"to\":\"Araguaneybits\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.10040000,\"vout\":0,\"fee\":-0.00009961,\"confirmations\":36481,\"blockhash\":\"00000000c2fcc605d9b73b7303770c5a2854e7dcae3d53bb47ce1a2e22f8e305\",\"blockindex\":43,\"blocktime\":1565905403,\"txid\":\"07e3086346cf5b80263286d1359444dd34bd1435a4d99c1aa44081b43bc1d4cb\",\"walletconflicts\":[],\"time\":1565905017,\"timereceived\":1565905017,\"bip125-replaceable\":\"no\",\"comment\":\"withdraw-120\",\"to\":\"Araguaneybits\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.10040000,\"vout\":0,\"fee\":-0.00006640,\"confirmations\":36477,\"blockhash\":\"0000000050bb051d943a5353ecae290820c43d36a1fdc3d847a5d2c441884fff\",\"blockindex\":21,\"blocktime\":1565909224,\"txid\":\"7f1e4ee0e4fa09452d5a932b088c56eedbf34ceb286cfde788abe377c1f5edce\",\"walletconflicts\":[],\"time\":1565908737,\"timereceived\":1565908737,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2MtdCfMpY5o5J19EWuUo7axuZJE8r6RbAMD\",\"category\":\"send\",\"amount\":-1.00000000,\"vout\":1,\"fee\":-0.00000256,\"confirmations\":36100,\"blockhash\":\"000000000000000414b08845e490490f5b81637172d470675bdec658ceebabcd\",\"blockindex\":146,\"blocktime\":1566235125,\"txid\":\"4858d880613c8db3e7f921680423c07fc2704cd1a8d3740ce79c599cf75962cf\",\"walletconflicts\":[],\"time\":1566234328,\"timereceived\":1566234328,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2NCPqqaSgJ27wpFnS3tqKGtjjrM6W14cTGG\",\"category\":\"receive\",\"amount\":1.00000000,\"label\":\"\",\"vout\":0,\"confirmations\":163134,\"blockhash\":\"00000000000207baf72a6ff09538e366ec4e4c6053ea89afdc1ecb5510f65246\",\"blockindex\":23,\"blocktime\":1545005092,\"txid\":\"2c0720d4b1f162668926eef5969363fe50d03f2ab9bf9af9889a822096201dd6\",\"walletconflicts\":[],\"time\":1545004015,\"timereceived\":1545004015,\"bip125-replaceable\":\"no\"},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.44440000,\"vout\":0,\"fee\":-0.00010240,\"confirmations\":36476,\"blockhash\":\"0000000000000176584c2ece75eaa52715586de910ddb851e27499badd436052\",\"blockindex\":15,\"blocktime\":1565910063,\"txid\":\"f3bd2b3dea58af6dc51a51d6bcaa0439b9cc501a9a6bdbddf0918043116a87d6\",\"walletconflicts\":[],\"time\":1565909917,\"timereceived\":1565909917,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.12040000,\"vout\":0,\"fee\":-0.00009961,\"confirmations\":36483,\"blockhash\":\"000000002e799bef525197b6aafed5839d0384f075626d9c3efc33dcaaebbeec\",\"blockindex\":52,\"blocktime\":1565902989,\"txid\":\"2357b1645454879e6c2806566ce3917c0aaf67b0ccca75da490c7e5651fa9ad9\",\"walletconflicts\":[],\"time\":1565902953,\"timereceived\":1565902953,\"bip125-replaceable\":\"no\",\"comment\":\"withdraw-115\",\"to\":\"Araguaneybits\",\"abandoned\":false},{\"address\":\"2Msp7G6jBsUC2gE9AFTxK3tm7JN79sYE6wT\",\"category\":\"send\",\"amount\":-2.00000000,\"vout\":1,\"fee\":-0.00000166,\"confirmations\":36274,\"blockhash\":\"00000000d258fc7a1386708d0acdd5a37425e53a5153b20ed56aa0c92178d3d7\",\"blockindex\":40,\"blocktime\":1566073639,\"txid\":\"ac44934ce4a079082f77d7e9adc9a2a65914c186db6bcf0c967013d6b1b520db\",\"walletconflicts\":[],\"time\":1566073526,\"timereceived\":1566073526,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2N83W9jw6biuJKDQSpXzsEDvAfNv7bjU4Wu\",\"category\":\"send\",\"amount\":-0.12040000,\"vout\":0,\"fee\":-0.00009961,\"confirmations\":36483,\"blockhash\":\"000000002e799bef525197b6aafed5839d0384f075626d9c3efc33dcaaebbeec\",\"blockindex\":53,\"blocktime\":1565902989,\"txid\":\"4a277bc191ad8d88e58356427847d015a3614bfc07424a1ffcbe02ee3f45f5dc\",\"walletconflicts\":[],\"time\":1565902854,\"timereceived\":1565902854,\"bip125-replaceable\":\"no\",\"comment\":\"withdraw-115\",\"to\":\"Araguaneybits\",\"abandoned\":false},{\"address\":\"2Msp7G6jBsUC2gE9AFTxK3tm7JN79sYE6wT\",\"category\":\"send\",\"amount\":-1.00000000,\"vout\":0,\"fee\":-0.00000256,\"confirmations\":36270,\"blockhash\":\"00000000f1a298b9de4ea00525de8d2ec193ce9014df5df949bd094e98519044\",\"blockindex\":80,\"blocktime\":1566076508,\"txid\":\"b104167efbd9af60dc67be51bb1c2578c596afe8fa0eab2178d9fd715e5a21e5\",\"walletconflicts\":[],\"time\":1566075027,\"timereceived\":1566075027,\"bip125-replaceable\":\"no\",\"abandoned\":false},{\"address\":\"2Msp7G6jBsUC2gE9AFTxK3tm7JN79sYE6wT\",\"category\":\"send\",\"amount\":-1.00000000,\"vout\":0,\"fee\":-0.00000166,\"confirmations\":36274,\"blockhash\":\"00000000d258fc7a1386708d0acdd5a37425e53a5153b20ed56aa0c92178d3d7\",\"blockindex\":41,\"blocktime\":1566073639,\"txid\":\"f9349e59eede6052bc0f9f256e5bd9a1f01b3353d1d4a1620a7fddc9843701e6\",\"walletconflicts\":[],\"time\":1566072945,\"timereceived\":1566072945,\"bip125-replaceable\":\"no\",\"abandoned\":false}],\"removed\":[],\"lastblock\":\"000000000000007dc47f9c83b2cd4d0167205aa3fe57c2828aabe868d2e1e68b\"},\"error\":null,\"id\":null}");

        BtcRpcListSinceBlockResponse btcRpcListSinceBlockResponse = undertest.listSinceBlock();
        Assert.assertNotNull("Is not null", btcRpcListSinceBlockResponse);

        List<BtcRpcListSinceBlockTransactionResponse> list = btcRpcListSinceBlockResponse.getTransactions();
        Assert.assertNotNull("Is not null", list);
    }

    /**
     * Test list wallet dir.
     *
     * @throws Exception the exception
     */
    @Test
    public void testListWalletDir() throws Exception {
        enqueueMockedResponse(200, "{\"result\":{\"wallets\":[{\"name\":\"junit_wallet\"},{\"name\":\"\"}]},\"error\":null,\"id\":null}");
        List<String> list = undertest.listWalletDir();
        Assert.assertNotNull("Is not null", list);
        Assert.assertEquals("Expected two", 2, list.size());
    }

    /**
     * Test load wallet.
     *
     * @throws Exception the exception
     */
    @Test
    public void testLoadWallet() throws Exception {
        enqueueMockedResponse(200, "{\"result\":{\"name\":\"junit_wallet\",\"warning\":\"\"},\"error\":null,\"id\":null}");

        String filename = "junit_wallet";
        BtcRpcLoadWalletResponse btcRpcLoadWalletResponse = undertest.loadWallet(filename);
        Assert.assertEquals("Expected equals", filename, btcRpcLoadWalletResponse.getName());

    }

    /**
     * Test rescan blockchain.
     *
     * @throws Exception the exception
     */
    @Test
    public void testRescanBlockchain() throws Exception {
        enqueueMockedResponse(200, "{\"result\":{\"start_height\":1200000,\"stop_height\":1200001},\"error\":null,\"id\":null}");
        Long startHeight = 1_200_000L;
        Long stopHeight = 1_200_001L;
        Boolean success = undertest.rescanBlockchain(startHeight, stopHeight);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test sethdseed.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSethdseed() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

        Boolean newkeypool = null;
        String seed = null;
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
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

        String walletName = null;
        undertest.unloadWallet(walletName);
        Assert.fail("Test method not implemented");
    }

    /**
     * Test wallet lock.
     *
     * @throws Exception the exception
     */
    @Test
    public void testWalletLock() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        Boolean success = undertest.walletLock();
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test wallet passphrase.
     *
     * @throws Exception the exception
     */
    @Test
    public void testWalletPassphrase() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

        String passphrase = null;
        Long timeout = null;
        Boolean success = undertest.walletPassphrase(passphrase, timeout);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test wallet passphrase change.
     *
     * @throws Exception the exception
     */
    @Test
    public void testWalletPassphraseChange() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

        String oldpassphrase = "oldpassphrase";
        String newpassphrase = "newpassphrase";
        Boolean success = undertest.walletPassphraseChange(oldpassphrase, newpassphrase);
        Assert.assertTrue("Expected true", success);
    }
}
