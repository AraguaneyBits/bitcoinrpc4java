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
package com.araguaneybits.crypto.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.RpcOutputMessage;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetTransactionResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author jestevez
 */
public class TransformBeanUtilsTest {

    static class Person {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

    }

    @Test
    public void testWriteValueAsString() {
        Person person = new Person();
        person.setAge(54);
        person.setName("Brad Pitt");
        String json = TransformBeanUtils.writeValueAsString(person);
        Assert.assertEquals("Expected this json", "{\"name\":\"Brad Pitt\",\"age\":54}", json);
    }

    @Test
    public void testReadValue() {
        String json = "{\"name\":\"Brad Pitt\",\"age\":54}";
        Person person = TransformBeanUtils.readValue(json, Person.class);
        Assert.assertEquals("Expected person", "Brad Pitt", person.getName());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testReadGeneric() throws Exception {
        String json = "{\"result\":[{\"address\":\"mi5vpRYydDtCJoVcwhtttTpdAoakYHYbXt\",\"category\":\"immature\",\"amount\":25.00000000,\"vout\":0,\"confirmations\":4,\"generated\":true,\"blockhash\":\"5705992a29313434676ed36cbe793922cf6211c433b43b69ac2d1748cf736fc7\",\"blockindex\":0,\"blocktime\":1567715996,\"txid\":\"46c30fbe1f38c6579133efb4811cdd9ebbed333a329b267666ec92ed8066af2f\",\"walletconflicts\":[],\"time\":1567715980,\"timereceived\":1567715980,\"bip125-replaceable\":\"no\"},{\"address\":\"mi5vpRYydDtCJoVcwhtttTpdAoakYHYbXt\",\"category\":\"immature\",\"amount\":25.00000000,\"vout\":0,\"confirmations\":3,\"generated\":true,\"blockhash\":\"6c060a1dd37fa027fa9271e7eb3bf8e86c3125ccacd7a4584745bb75ddfc01bb\",\"blockindex\":0,\"blocktime\":1567715996,\"txid\":\"6e7f85c24a9af98c39d52053961c7069bd03b5fbdce338800071576f7fe1dbdc\",\"walletconflicts\":[],\"time\":1567715980,\"timereceived\":1567715980,\"bip125-replaceable\":\"no\"},{\"address\":\"mi5vpRYydDtCJoVcwhtttTpdAoakYHYbXt\",\"category\":\"immature\",\"amount\":25.00000000,\"vout\":0,\"confirmations\":2,\"generated\":true,\"blockhash\":\"1b0132ec021edf3116794e10326edfe9036204169169e9a46832ab4d045c40c5\",\"blockindex\":0,\"blocktime\":1567715996,\"txid\":\"3f637756cfa8a94c5243e91474ea4b1411aaa22e87cd0d6bf3f02cfd64bebbac\",\"walletconflicts\":[],\"time\":1567715980,\"timereceived\":1567715980,\"bip125-replaceable\":\"no\"},{\"address\":\"mi5vpRYydDtCJoVcwhtttTpdAoakYHYbXt\",\"category\":\"immature\",\"amount\":25.00000000,\"vout\":0,\"confirmations\":1,\"generated\":true,\"blockhash\":\"5abbfa1ab7105d6f39782cdbac470ace776b4c9247eb02f66d1265e732cc499f\",\"blockindex\":0,\"blocktime\":1567715996,\"txid\":\"9831f8ccb49a602d7d22867a5dcf663dda754543917f03690d0a80e5a338a54f\",\"walletconflicts\":[],\"time\":1567715980,\"timereceived\":1567715980,\"bip125-replaceable\":\"no\"},{\"address\":\"2MvPDWyfuy7yuGFGkippYzg4RjWMxxwci8t\",\"category\":\"receive\",\"amount\":1.00000000,\"label\":\"\",\"vout\":1,\"confirmations\":0,\"trusted\":true,\"txid\":\"520e3546d632755b4ba4e905b98f79d80d66684f5624e571eac93aee59825434\",\"walletconflicts\":[],\"time\":1567716940,\"timereceived\":1567716940,\"bip125-replaceable\":\"yes\"},{\"address\":\"2MvPDWyfuy7yuGFGkippYzg4RjWMxxwci8t\",\"category\":\"send\",\"amount\":-1.00000000,\"label\":\"\",\"vout\":1,\"fee\":-0.00003740,\"confirmations\":0,\"trusted\":true,\"txid\":\"520e3546d632755b4ba4e905b98f79d80d66684f5624e571eac93aee59825434\",\"walletconflicts\":[],\"time\":1567716940,\"timereceived\":1567716940,\"bip125-replaceable\":\"yes\",\"abandoned\":false},{\"address\":\"2NGEB3LnGyUSUsYF3oQNVZhDifW23p1tQbY\",\"category\":\"receive\",\"amount\":1.11111111,\"label\":\"\",\"vout\":0,\"confirmations\":0,\"trusted\":true,\"txid\":\"8b6ae65013cda73d292cbffc1bf03c62ff4236b6f301a3645f9acc3e686ae713\",\"walletconflicts\":[],\"time\":1567833670,\"timereceived\":1567833670,\"bip125-replaceable\":\"no\",\"comment\":\"send address\"},{\"address\":\"2NGEB3LnGyUSUsYF3oQNVZhDifW23p1tQbY\",\"category\":\"send\",\"amount\":-1.11111111,\"label\":\"\",\"vout\":0,\"fee\":-0.00003740,\"confirmations\":0,\"trusted\":true,\"txid\":\"8b6ae65013cda73d292cbffc1bf03c62ff4236b6f301a3645f9acc3e686ae713\",\"walletconflicts\":[],\"time\":1567833670,\"timereceived\":1567833670,\"bip125-replaceable\":\"no\",\"comment\":\"send address\",\"abandoned\":false},{\"address\":\"2MvzEQgD9DHp8u4Uj7tjc61rbz7fdzzaCAN\",\"category\":\"receive\",\"amount\":0.11111111,\"label\":\"\",\"vout\":0,\"confirmations\":0,\"trusted\":true,\"txid\":\"b2494d71606605d1f5ab639b63992a62aa2d8b9385533d15ec62992a8f3ced40\",\"walletconflicts\":[],\"time\":1567840425,\"timereceived\":1567840425,\"bip125-replaceable\":\"no\",\"comment\":\"send address\"},{\"address\":\"2MvzEQgD9DHp8u4Uj7tjc61rbz7fdzzaCAN\",\"category\":\"send\",\"amount\":-0.11111111,\"label\":\"\",\"vout\":0,\"fee\":-0.00003740,\"confirmations\":0,\"trusted\":true,\"txid\":\"b2494d71606605d1f5ab639b63992a62aa2d8b9385533d15ec62992a8f3ced40\",\"walletconflicts\":[],\"time\":1567840425,\"timereceived\":1567840425,\"bip125-replaceable\":\"no\",\"comment\":\"send address\",\"abandoned\":false}],\"error\":null,\"id\":null}\n"
                + "";

        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<ArrayList<BtcRpcGetTransactionResponse>>>() {
                });

        System.out.println(rpcOutputMessage);
        Assert.assertNotNull("Expected no null", rpcOutputMessage);

        List<BtcRpcGetTransactionResponse> list = (ArrayList<BtcRpcGetTransactionResponse>) rpcOutputMessage.getResult();
        for (BtcRpcGetTransactionResponse transaction : list) {
            System.out.println(transaction);
        }
    }

}
