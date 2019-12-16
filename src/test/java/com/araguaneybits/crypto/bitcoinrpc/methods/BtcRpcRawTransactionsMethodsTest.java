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

import com.araguaneybits.crypto.bitcoinrpc.methods.request.BtcRpcCreateRawTransactionInputRequest;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcAnalyzePsbtResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcDecodePsbtResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcDecodeRawTransactionResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcDecodeScriptResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcFinalizePsbtResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcFundRawTransactionResponse;

//@Ignore
public class BtcRpcRawTransactionsMethodsTest extends AbstractBtcRpcMethodsTest {

    private BtcRpcRawTransactionsMethods undertest;

    @Before
    public void setUp() {
        undertest = new BtcRpcRawTransactionsMethods(btcRpcGateway);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testAnalyzePsbt() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"inputs\":[{\"has_utxo\":false,\"is_final\":false,\"next\":\"updater\"},{\"has_utxo\":false,\"is_final\":false,\"next\":\"updater\"},{\"has_utxo\":false,\"is_final\":false,\"next\":\"updater\"}],\"next\":\"updater\"},\"error\":null,\"id\":null}");
        String psbt = "cHNidP8BAMUCAAAAAwDqEy7KDCfn2yaLj/Mdj7JUZiNE3a9utaLvmfhtqJTRAQAAAAD9////DgCV8ewPvX2V4vVXiRgUHznDmgLPTOoAXG2yjDqGkQwBAAAAAP3///8bytvcd5nZNAQ1xG5EQKfGWEin/8cjy3ZhiFNmXvFSZQEAAAAA/f///wJADQMAAAAAABepFGvKTBiI9z8JaZ77Ob43v/h1N2x1h0ANAwAAAAAAF6kUo3sxFf4BBmGTuiGNFRS120DVRAiHAAAAAAAAAAAAAA==";
        BtcRpcAnalyzePsbtResponse btcRpcAnalyzePsbtResponse = undertest.analyzePsbt(psbt);
        Assert.assertEquals("expected equals", "updater", btcRpcAnalyzePsbtResponse.getNext());
    }

    // @Test
    public void testCombinePsbt() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        String[] txs = null;
        undertest.combinePsbt(txs);
        Assert.fail("Test method not implemented");
    }

    // @Test
    public void testCombineRawTransaction() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        String[] hexstring = null;
        undertest.combineRawTransaction(hexstring);
        Assert.fail("Test method not implemented");
    }

    @Test
    public void testConvertToPsbt() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":\"cHNidP8BAMUCAAAAAwDqEy7KDCfn2yaLj/Mdj7JUZiNE3a9utaLvmfhtqJTRAQAAAAD9////DgCV8ewPvX2V4vVXiRgUHznDmgLPTOoAXG2yjDqGkQwAAAAAAP3///8OAJXx7A+9fZXi9VeJGBQfOcOaAs9M6gBcbbKMOoaRDAEAAAAA/f///wJADQMAAAAAABepFGS/LlKygEkxGkECDL1pOmTu/+Sth0ANAwAAAAAAF6kUGyoC0gleYEFoXasAGrNBJ2RXhNeHAAAAAAAAAAAAAA==\",\"error\":null,\"id\":null}");
        String hexstring = "020000000300ea132eca0c27e7db268b8ff31d8fb254662344ddaf6eb5a2ef99f86da894d10100000000fdffffff0e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c0000000000fdffffff0e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c0100000000fdffffff02400d03000000000017a91464bf2e52b28049311a41020cbd693a64eeffe4ad87400d03000000000017a9141b2a02d2095e6041685dab001ab34127645784d78700000000";
        Boolean permitsigdata = true;
        Boolean iswitness = false;
        String psbt = undertest.convertToPsbt(hexstring, permitsigdata, iswitness);
        Assert.assertEquals("Expected equals",
                "cHNidP8BAMUCAAAAAwDqEy7KDCfn2yaLj/Mdj7JUZiNE3a9utaLvmfhtqJTRAQAAAAD9////DgCV8ewPvX2V4vVXiRgUHznDmgLPTOoAXG2yjDqGkQwAAAAAAP3///8OAJXx7A+9fZXi9VeJGBQfOcOaAs9M6gBcbbKMOoaRDAEAAAAA/f///wJADQMAAAAAABepFGS/LlKygEkxGkECDL1pOmTu/+Sth0ANAwAAAAAAF6kUGyoC0gleYEFoXasAGrNBJ2RXhNeHAAAAAAAAAAAAAA==",
                psbt);
    }

    @Test
    public void testCreatePsbt() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":\"cHNidP8BAMUCAAAAAwDqEy7KDCfn2yaLj/Mdj7JUZiNE3a9utaLvmfhtqJTRAQAAAAD9////DgCV8ewPvX2V4vVXiRgUHznDmgLPTOoAXG2yjDqGkQwAAAAAAP3///8OAJXx7A+9fZXi9VeJGBQfOcOaAs9M6gBcbbKMOoaRDAEAAAAA/f///wJADQMAAAAAABepFM3/LG9AKDFoMu5gkE5cwa/oAxvPh0ANAwAAAAAAF6kUaC0uzdTRbxPi447gY1tBZCEBXGiHAAAAAAAAAAAAAA==\",\"error\":null,\"id\":null}");

        List<BtcRpcCreateRawTransactionInputRequest> inputs = new ArrayList<>();

        BtcRpcCreateRawTransactionInputRequest input1 = new BtcRpcCreateRawTransactionInputRequest();
        input1.setTxid("d194a86df899efa2b56eafdd44236654b28f1df38f8b26dbe7270cca2e13ea00");
        input1.setVout(1L);

        BtcRpcCreateRawTransactionInputRequest input2 = new BtcRpcCreateRawTransactionInputRequest();
        input2.setTxid("0c91863a8cb26d5c00ea4ccf029ac3391f14188957f5e2957dbd0fecf195000e");
        input2.setVout(0L);

        BtcRpcCreateRawTransactionInputRequest input3 = new BtcRpcCreateRawTransactionInputRequest();
        input3.setTxid("0c91863a8cb26d5c00ea4ccf029ac3391f14188957f5e2957dbd0fecf195000e");
        input3.setVout(1L);

        inputs.add(input1);
        inputs.add(input2);
        inputs.add(input3);

        Map<String, String> outputs = new HashMap<>();
        outputs.put("2NC2SCNz1c2bc4bikU6uWmNpo7sVrJiG8Wi", "0.002");
        outputs.put("2N2k4PbJcPuDKeTfxDSnBVqTv2PBTBB3bmo", "0.002");

        Long locktime = 0L;
        Boolean replaceable = true;

        String psbt = undertest.createPsbt(inputs, outputs, locktime, replaceable);

        Assert.assertEquals("Expected equals",
                "cHNidP8BAMUCAAAAAwDqEy7KDCfn2yaLj/Mdj7JUZiNE3a9utaLvmfhtqJTRAQAAAAD9////DgCV8ewPvX2V4vVXiRgUHznDmgLPTOoAXG2yjDqGkQwAAAAAAP3///8OAJXx7A+9fZXi9VeJGBQfOcOaAs9M6gBcbbKMOoaRDAEAAAAA/f///wJADQMAAAAAABepFM3/LG9AKDFoMu5gkE5cwa/oAxvPh0ANAwAAAAAAF6kUaC0uzdTRbxPi447gY1tBZCEBXGiHAAAAAAAAAAAAAA==",
                psbt);
    }

    @Test
    public void testCreateRawTransaction() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":\"02000000030e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c0000000000fdffffff0e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c0100000000fdffffff1bcadbdc7799d9340435c46e4440a7c65848a7ffc723cb76618853665ef152650100000000fdffffff0240420f000000000017a9147c1f3a5f66371ae4c739b87893b6eeb44e62705e8740420f000000000017a914c3295dc26a6594f0ed2498356ad6bc5fab5284138700000000\",\"error\":null,\"id\":null}");

        List<BtcRpcCreateRawTransactionInputRequest> inputs = new ArrayList<>();

        BtcRpcCreateRawTransactionInputRequest input1 = new BtcRpcCreateRawTransactionInputRequest();
        input1.setTxid("0c91863a8cb26d5c00ea4ccf029ac3391f14188957f5e2957dbd0fecf195000e");
        input1.setVout(0L);

        BtcRpcCreateRawTransactionInputRequest input2 = new BtcRpcCreateRawTransactionInputRequest();
        input2.setTxid("0c91863a8cb26d5c00ea4ccf029ac3391f14188957f5e2957dbd0fecf195000e");
        input2.setVout(1L);

        BtcRpcCreateRawTransactionInputRequest input3 = new BtcRpcCreateRawTransactionInputRequest();
        input3.setTxid("6552f15e6653886176cb23c7ffa74858c6a740446ec4350434d99977dcdbca1b");
        input3.setVout(1L);

        inputs.add(input1);
        inputs.add(input2);
        inputs.add(input3);

        Map<String, String> outputs = new HashMap<>();
        outputs.put("2N4ZXBqBydcCur6YFYgMGM4g9nXm8QnGgJq", "0.01");
        outputs.put("2NB39JsJmoePraPG2Fsq2US2gTSvXBWd2ji", "0.01");

        Long locktime = 0L;
        Boolean replaceable = true;

        String rawTx = undertest.createRawTransaction(inputs, outputs, locktime, replaceable);

        Assert.assertEquals("Expected equals",
                "02000000030e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c0000000000fdffffff0e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c0100000000fdffffff1bcadbdc7799d9340435c46e4440a7c65848a7ffc723cb76618853665ef152650100000000fdffffff0240420f000000000017a9147c1f3a5f66371ae4c739b87893b6eeb44e62705e8740420f000000000017a914c3295dc26a6594f0ed2498356ad6bc5fab5284138700000000",
                rawTx);

    }

    @Test
    public void testDecodePsbt() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"tx\":{\"txid\":\"032e734457e3ddabef166d2d22795b8a221566be6c8040c24f0aa86f06712180\",\"hash\":\"032e734457e3ddabef166d2d22795b8a221566be6c8040c24f0aa86f06712180\",\"version\":2,\"size\":197,\"vsize\":197,\"weight\":788,\"locktime\":0,\"vin\":[{\"txid\":\"d194a86df899efa2b56eafdd44236654b28f1df38f8b26dbe7270cca2e13ea00\",\"vout\":1,\"scriptSig\":{\"asm\":\"\",\"hex\":\"\"},\"sequence\":4294967293},{\"txid\":\"0c91863a8cb26d5c00ea4ccf029ac3391f14188957f5e2957dbd0fecf195000e\",\"vout\":0,\"scriptSig\":{\"asm\":\"\",\"hex\":\"\"},\"sequence\":4294967293},{\"txid\":\"0c91863a8cb26d5c00ea4ccf029ac3391f14188957f5e2957dbd0fecf195000e\",\"vout\":1,\"scriptSig\":{\"asm\":\"\",\"hex\":\"\"},\"sequence\":4294967293}],\"vout\":[{\"value\":0.00200000,\"n\":0,\"scriptPubKey\":{\"asm\":\"OP_HASH160 cdff2c6f4028316832ee60904e5cc1afe8031bcf OP_EQUAL\",\"hex\":\"a914cdff2c6f4028316832ee60904e5cc1afe8031bcf87\",\"reqSigs\":1,\"type\":\"scripthash\",\"addresses\":[\"2NC2SCNz1c2bc4bikU6uWmNpo7sVrJiG8Wi\"]}},{\"value\":0.00200000,\"n\":1,\"scriptPubKey\":{\"asm\":\"OP_HASH160 682d2ecdd4d16f13e2e38ee0635b416421015c68 OP_EQUAL\",\"hex\":\"a914682d2ecdd4d16f13e2e38ee0635b416421015c6887\",\"reqSigs\":1,\"type\":\"scripthash\",\"addresses\":[\"2N2k4PbJcPuDKeTfxDSnBVqTv2PBTBB3bmo\"]}}]},\"unknown\":{},\"inputs\":[{},{},{}],\"outputs\":[{},{}]},\"error\":null,\"id\":null}");
        String psbt = "cHNidP8BAMUCAAAAAwDqEy7KDCfn2yaLj/Mdj7JUZiNE3a9utaLvmfhtqJTRAQAAAAD9////DgCV8ewPvX2V4vVXiRgUHznDmgLPTOoAXG2yjDqGkQwAAAAAAP3///8OAJXx7A+9fZXi9VeJGBQfOcOaAs9M6gBcbbKMOoaRDAEAAAAA/f///wJADQMAAAAAABepFM3/LG9AKDFoMu5gkE5cwa/oAxvPh0ANAwAAAAAAF6kUaC0uzdTRbxPi447gY1tBZCEBXGiHAAAAAAAAAAAAAA==";
        BtcRpcDecodePsbtResponse btcRpcDecodePsbtResponse = undertest.decodePsbt(psbt);

        Assert.assertEquals("Expected equals", "032e734457e3ddabef166d2d22795b8a221566be6c8040c24f0aa86f06712180",
                btcRpcDecodePsbtResponse.getTx().getTxid());
    }

    @Test
    public void testDecodeRawTransaction() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"txid\":\"a8539fb17c154a0283e18af1b839ac2712720f58ab68cbc5ae179d17568c2453\",\"hash\":\"a8539fb17c154a0283e18af1b839ac2712720f58ab68cbc5ae179d17568c2453\",\"version\":2,\"size\":197,\"vsize\":197,\"weight\":788,\"locktime\":0,\"vin\":[{\"txid\":\"0c91863a8cb26d5c00ea4ccf029ac3391f14188957f5e2957dbd0fecf195000e\",\"vout\":0,\"scriptSig\":{\"asm\":\"\",\"hex\":\"\"},\"sequence\":4294967293},{\"txid\":\"0c91863a8cb26d5c00ea4ccf029ac3391f14188957f5e2957dbd0fecf195000e\",\"vout\":1,\"scriptSig\":{\"asm\":\"\",\"hex\":\"\"},\"sequence\":4294967293},{\"txid\":\"6552f15e6653886176cb23c7ffa74858c6a740446ec4350434d99977dcdbca1b\",\"vout\":1,\"scriptSig\":{\"asm\":\"\",\"hex\":\"\"},\"sequence\":4294967293}],\"vout\":[{\"value\":0.01000000,\"n\":0,\"scriptPubKey\":{\"asm\":\"OP_HASH160 7c1f3a5f66371ae4c739b87893b6eeb44e62705e OP_EQUAL\",\"hex\":\"a9147c1f3a5f66371ae4c739b87893b6eeb44e62705e87\",\"reqSigs\":1,\"type\":\"scripthash\",\"addresses\":[\"2N4ZXBqBydcCur6YFYgMGM4g9nXm8QnGgJq\"]}},{\"value\":0.01000000,\"n\":1,\"scriptPubKey\":{\"asm\":\"OP_HASH160 c3295dc26a6594f0ed2498356ad6bc5fab528413 OP_EQUAL\",\"hex\":\"a914c3295dc26a6594f0ed2498356ad6bc5fab52841387\",\"reqSigs\":1,\"type\":\"scripthash\",\"addresses\":[\"2NB39JsJmoePraPG2Fsq2US2gTSvXBWd2ji\"]}}]},\"error\":null,\"id\":null}");
        String hexstring = "02000000030e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c0000000000fdffffff0e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c0100000000fdffffff1bcadbdc7799d9340435c46e4440a7c65848a7ffc723cb76618853665ef152650100000000fdffffff0240420f000000000017a9147c1f3a5f66371ae4c739b87893b6eeb44e62705e8740420f000000000017a914c3295dc26a6594f0ed2498356ad6bc5fab5284138700000000";
        Boolean iswitness = false;
        BtcRpcDecodeRawTransactionResponse btcRpcDecodeRawTransactionResponse = undertest.decodeRawTransaction(hexstring, iswitness);
        Assert.assertEquals("Expected equals", "a8539fb17c154a0283e18af1b839ac2712720f58ab68cbc5ae179d17568c2453",
                btcRpcDecodeRawTransactionResponse.getTxid());
    }

    @Test
    public void testDecodeScript() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"asm\":\"0 0 0 2 OP_UNKNOWN OP_IFDUP 2a5ebfce28016b2ed5c2c1a285d00bf3e4700a4d1105abc293ac OP_UNKNOWN 980100000017160014b70358715715053f37922c198a37fba6ded2717dfdffffff48a357bf51f2762c0ef8a835e297d460befbeef4 13 e2448e7619d243c528cd010000006a4730440220790c02a6dcb772e85cde6cb9e6ee6d8e627a911322fd20 OP_UNKNOWN OP_NOP5 e41dd23c1cab02203d1552997405731608856e5d2471802cc68aea193c6ea2941c89fd4b0b47ad23012103be OP_CHECKSIGVERIFY a55742993a OP_CHECKSIG 7db466a051a962eab7fc609c635017e4e35e8feff7d5fdff OP_INVALIDOPCODE OP_INVALIDOPCODE 16960 000000000017a914dc78ebea771678 OP_INVERT OP_CODESEPARATOR OP_UNKNOWN OP_ENDIF OP_DEPTH 4278e38eab17b087b2 OP_UNKNOWN 000000000017a914c76c5adaf4d86875 OP_UNKNOWN OP_XOR OP_LESSTHAN OP_UNKNOWN 2f116f38d1e4b087024730440220196a4767fcb1822bdeeab751f8cc0a93f753da6bf6efd65d1b5cc95398a650d60220324cb15361995ea59139fac847999c1e712ddfc86bdf 6b1dfc0f4b3084667c012102041818a3ef65ab8972cf2a35491753ad0aa9cadaaa947a OP_UNKNOWN OP_IF OP_TUCK OP_CHECKLOCKTIMEVERIFY 2 OP_UNKNOWN OP_UNKNOWN [error]\",\"type\":\"nonstandard\",\"p2sh\":\"2MsL6cE7YeQ9SyZaq5g5cSKcxAdAzw4kxwt\",\"segwit\":{\"asm\":\"0 f1ee97c23067ebbd296e09d06a98eac895439c68b382333405927b31bc5bf9eb\",\"hex\":\"0020f1ee97c23067ebbd296e09d06a98eac895439c68b382333405927b31bc5bf9eb\",\"reqSigs\":1,\"type\":\"witness_v0_scripthash\",\"addresses\":[\"tb1q78hf0s3svl4m62twp8gx4x82ez2588rgkwprxdq9jfanr0zml84sr89m4j\"],\"p2sh-segwit\":\"2N1SwXBwuxg5bDo5RMNwDLrSRwCvB9iKmBD\"}},\"error\":null,\"id\":null}");
        String hexstring = "02000000000102ee731a2a5ebfce28016b2ed5c2c1a285d00bf3e4700a4d1105abc293ace735980100000017160014b70358715715053f37922c198a37fba6ded2717dfdffffff48a357bf51f2762c0ef8a835e297d460befbeef45d2be2448e7619d243c528cd010000006a4730440220790c02a6dcb772e85cde6cb9e6ee6d8e627a911322fd20d9b42ce41dd23c1cab02203d1552997405731608856e5d2471802cc68aea193c6ea2941c89fd4b0b47ad23012103bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5fdffffff0240420f000000000017a914dc78ebea77167883abc76874094278e38eab17b087b2bd10000000000017a914c76c5adaf4d86875da869fef462f116f38d1e4b087024730440220196a4767fcb1822bdeeab751f8cc0a93f753da6bf6efd65d1b5cc95398a650d60220324cb15361995ea59139fac847999c1e712ddfc86bdf236b1dfc0f4b3084667c012102041818a3ef65ab8972cf2a35491753ad0aa9cadaaa947acf637db152f0eb196c00389b1800";

        BtcRpcDecodeScriptResponse btcRpcDecodeScriptResponse = undertest.decodeScript(hexstring);
        Assert.assertEquals("Expected equals", "2MsL6cE7YeQ9SyZaq5g5cSKcxAdAzw4kxwt", btcRpcDecodeScriptResponse.getP2sh());
    }

    @Test
    public void testFinalizePsbt() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"psbt\":\"cHNidP8BAMUCAAAAAwDqEy7KDCfn2yaLj/Mdj7JUZiNE3a9utaLvmfhtqJTRAQAAAAD9////DgCV8ewPvX2V4vVXiRgUHznDmgLPTOoAXG2yjDqGkQwAAAAAAP3///8OAJXx7A+9fZXi9VeJGBQfOcOaAs9M6gBcbbKMOoaRDAEAAAAA/f///wJADQMAAAAAABepFM3/LG9AKDFoMu5gkE5cwa/oAxvPh0ANAwAAAAAAF6kUaC0uzdTRbxPi447gY1tBZCEBXGiHAAAAAAAAAAAAAA==\",\"complete\":false},\"error\":null,\"id\":null}");
        String psbt = "cHNidP8BAMUCAAAAAwDqEy7KDCfn2yaLj/Mdj7JUZiNE3a9utaLvmfhtqJTRAQAAAAD9////DgCV8ewPvX2V4vVXiRgUHznDmgLPTOoAXG2yjDqGkQwAAAAAAP3///8OAJXx7A+9fZXi9VeJGBQfOcOaAs9M6gBcbbKMOoaRDAEAAAAA/f///wJADQMAAAAAABepFM3/LG9AKDFoMu5gkE5cwa/oAxvPh0ANAwAAAAAAF6kUaC0uzdTRbxPi447gY1tBZCEBXGiHAAAAAAAAAAAAAA==";
        Boolean extract = true;
        BtcRpcFinalizePsbtResponse btcRpcFinalizePsbtResponse = undertest.finalizePsbt(psbt, extract);
        Assert.assertEquals("Expected equals", psbt, btcRpcFinalizePsbtResponse.getPsbt());
    }

    @Test
    public void testFundRawTransaction() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"hex\":\"020000000300ea132eca0c27e7db268b8ff31d8fb254662344ddaf6eb5a2ef99f86da894d10100000000fdffffff0e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c0100000000fdffffff1bcadbdc7799d9340435c46e4440a7c65848a7ffc723cb76618853665ef152650100000000fdffffff0353ffc4000000000017a9145d81431396efa17e56ab612aa261fbcb6e7fca8d87a08601000000000017a914d7bbcf3284c93297c6eca88ab308a32abe0b69aa87a08601000000000017a914fcd05d723407fef10eed968d570c6df559236d0c8700000000\",\"fee\":0.00000436,\"changepos\":0},\"error\":null,\"id\":null}");

        String rawtransactionhex = "020000000300ea132eca0c27e7db268b8ff31d8fb254662344ddaf6eb5a2ef99f86da894d10100000000fdffffff0e0095f1ec0fbd7d95e2f5578918141f39c39a02cf4cea005c6db28c3a86910c0100000000fdffffff1bcadbdc7799d9340435c46e4440a7c65848a7ffc723cb76618853665ef152650100000000fdffffff02a08601000000000017a914d7bbcf3284c93297c6eca88ab308a32abe0b69aa87a08601000000000017a914fcd05d723407fef10eed968d570c6df559236d0c8700000000";
        BtcRpcFundRawTransactionResponse btcRpcFundRawTransactionResponse = undertest.fundRawTransaction(rawtransactionhex);
        Assert.assertEquals("Expected equals", new BigDecimal("0.00000436"), btcRpcFundRawTransactionResponse.getFee());
    }

    @Test
    public void testGetrawtransaction() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"txid\":\"8d25af933635dc8eb330e3217b9f61e83095042cc3579b7046e74ca77621b05a\",\"hash\":\"32ef0bc2e832cd0bb9731c72b3495a488b759714f69d9754980c29742c9e9c6e\",\"version\":2,\"size\":395,\"vsize\":313,\"weight\":1250,\"locktime\":1612600,\"vin\":[{\"txid\":\"9835e7ac93c2ab05114d0a70e4f30bd085a2c1c2d52e6b0128cebf5e2a1a73ee\",\"vout\":1,\"scriptSig\":{\"asm\":\"0014b70358715715053f37922c198a37fba6ded2717d\",\"hex\":\"160014b70358715715053f37922c198a37fba6ded2717d\"},\"txinwitness\":[\"30440220196a4767fcb1822bdeeab751f8cc0a93f753da6bf6efd65d1b5cc95398a650d60220324cb15361995ea59139fac847999c1e712ddfc86bdf236b1dfc0f4b3084667c01\",\"02041818a3ef65ab8972cf2a35491753ad0aa9cadaaa947acf637db152f0eb196c\"],\"sequence\":4294967293},{\"txid\":\"cd28c543d219768e44e22b5df4eefbbe60d497e235a8f80e2c76f251bf57a348\",\"vout\":1,\"scriptSig\":{\"asm\":\"30440220790c02a6dcb772e85cde6cb9e6ee6d8e627a911322fd20d9b42ce41dd23c1cab02203d1552997405731608856e5d2471802cc68aea193c6ea2941c89fd4b0b47ad23[ALL] 03bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5\",\"hex\":\"4730440220790c02a6dcb772e85cde6cb9e6ee6d8e627a911322fd20d9b42ce41dd23c1cab02203d1552997405731608856e5d2471802cc68aea193c6ea2941c89fd4b0b47ad23012103bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5\"},\"sequence\":4294967293}],\"vout\":[{\"value\":0.01000000,\"n\":0,\"scriptPubKey\":{\"asm\":\"OP_HASH160 dc78ebea77167883abc76874094278e38eab17b0 OP_EQUAL\",\"hex\":\"a914dc78ebea77167883abc76874094278e38eab17b087\",\"reqSigs\":1,\"type\":\"scripthash\",\"addresses\":[\"2NDLyWGCvaTxgcvm3dKf3qh1A687CMX6z5X\"]}},{\"value\":0.01097138,\"n\":1,\"scriptPubKey\":{\"asm\":\"OP_HASH160 c76c5adaf4d86875da869fef462f116f38d1e4b0 OP_EQUAL\",\"hex\":\"a914c76c5adaf4d86875da869fef462f116f38d1e4b087\",\"reqSigs\":1,\"type\":\"scripthash\",\"addresses\":[\"2NBRgG67GfeYFKq9UgMCH37yAFGHBvcJBTK\"]}}],\"hex\":\"02000000000102ee731a2a5ebfce28016b2ed5c2c1a285d00bf3e4700a4d1105abc293ace735980100000017160014b70358715715053f37922c198a37fba6ded2717dfdffffff48a357bf51f2762c0ef8a835e297d460befbeef45d2be2448e7619d243c528cd010000006a4730440220790c02a6dcb772e85cde6cb9e6ee6d8e627a911322fd20d9b42ce41dd23c1cab02203d1552997405731608856e5d2471802cc68aea193c6ea2941c89fd4b0b47ad23012103bead05a55742993aac187db466a051a962eab7fc609c635017e4e35e8feff7d5fdffffff0240420f000000000017a914dc78ebea77167883abc76874094278e38eab17b087b2bd10000000000017a914c76c5adaf4d86875da869fef462f116f38d1e4b087024730440220196a4767fcb1822bdeeab751f8cc0a93f753da6bf6efd65d1b5cc95398a650d60220324cb15361995ea59139fac847999c1e712ddfc86bdf236b1dfc0f4b3084667c012102041818a3ef65ab8972cf2a35491753ad0aa9cadaaa947acf637db152f0eb196c00389b1800\"},\"error\":null,\"id\":null}");
        String txid = "8d25af933635dc8eb330e3217b9f61e83095042cc3579b7046e74ca77621b05a";
        Boolean verbose = true;
        String blockhash = null;
        BtcRpcDecodeRawTransactionResponse btcRpcDecodeRawTransactionResponse = undertest.getRawTransaction(txid, verbose, blockhash);
        Assert.assertEquals("Expected equals", "8d25af933635dc8eb330e3217b9f61e83095042cc3579b7046e74ca77621b05a",
                btcRpcDecodeRawTransactionResponse.getTxid());
    }

    // @Test
    public void testJoinPsbts() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");

        String[] txs = new String[] { "", "" };
        undertest.joinPsbts(txs);
        Assert.fail("Test method not implemented");
    }

    // @Test
    public void testSendRawTransaction() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        String tx = undertest.sendRawTransaction("", new BigDecimal(""));
        Assert.assertEquals("Expected equals", "", tx);
    }

    // @Test
    public void testSignrawtransactionwithkey() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        undertest.signrawtransactionwithkey();
        Assert.fail("Test method not implemented");
    }

    // @Test
    public void testTestmempoolaccept() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        undertest.testmempoolaccept();
        Assert.fail("Test method not implemented");
    }

    // @Test
    public void testUtxoupdatepsbt() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        undertest.utxoupdatepsbt();
        Assert.fail("Test method not implemented");
    }
}
