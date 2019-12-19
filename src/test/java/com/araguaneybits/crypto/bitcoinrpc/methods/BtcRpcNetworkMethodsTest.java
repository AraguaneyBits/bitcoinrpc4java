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

import java.math.BigInteger;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.constants.EnumAddNodeType;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetAddedNodeInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetNetTotalsResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetNodeAddressesResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetPeerInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListBannedResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcNetworkInfoResponse;

/**
 * The Class BtcRpcNetworkMethodsTest.
 *
 * @author jestevez
 */
// @Ignore
public class BtcRpcNetworkMethodsTest extends AbstractBtcRpcMethodsTest {

    /** The undertest. */
    private BtcRpcNetworkMethods undertest;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        undertest = new BtcRpcNetworkMethods(btcRpcGateway);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {

    }

    /**
     * Test add node.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddNode() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        Boolean success = undertest.addNode("192.186.184.128", EnumAddNodeType.ADD);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test clear banned.
     *
     * @throws Exception the exception
     */
    @Test
    public void testClearBanned() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        Boolean success = undertest.clearBanned();
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test disconnect node.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDisconnectNode() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        Boolean success = undertest.disconnectNode("192.186.184.128:1883");
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test get added node info.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetAddedNodeInfo() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":[{\"addednode\":\"2.113.15.154:18333\",\"connected\":true,\"addresses\":[{\"address\":\"2.113.15.154:18333\",\"connected\":\"outbound\"}]}],\"error\":null,\"id\":null}");
        List<BtcRpcGetAddedNodeInfoResponse> list = undertest.getAddedNodeInfo();
        Assert.assertNotNull("Is not null", list);

        BtcRpcGetAddedNodeInfoResponse btcRpcGetPeerInfoResponse = list.get(0);
        Assert.assertEquals("Is not equals", "2.113.15.154:18333", btcRpcGetPeerInfoResponse.getAddednode());
    }

    /**
     * Test get connection count.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetConnectionCount() throws Exception {
        enqueueMockedResponse(200, "{\"result\":9,\"error\":null,\"id\":null}");

        BigInteger count = undertest.getConnectionCount();
        Assert.assertEquals("Is not equals", new BigInteger("9"), count);
    }

    /**
     * Test get net totals.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetNetTotals() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"totalbytesrecv\":117054200,\"totalbytessent\":26963394,\"timemillis\":1575301041000,\"uploadtarget\":{\"timeframe\":86400,\"target\":0,\"target_reached\":false,\"serve_historical_blocks\":true,\"bytes_left_in_cycle\":0,\"time_left_in_cycle\":0}},\"error\":null,\"id\":null}");
        BtcRpcGetNetTotalsResponse btcRpcGetNetTotalsResponse = undertest.getNetTotals();
        Assert.assertNotNull("Is not null", btcRpcGetNetTotalsResponse);
        Assert.assertEquals("Is not equals", new BigInteger("26963394"), btcRpcGetNetTotalsResponse.getTotalbytessent());
    }

    /**
     * Test get network info.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetNetworkInfo() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"version\":180100,\"subversion\":\"/Satoshi:0.18.1/\",\"protocolversion\":70015,\"localservices\":\"000000000000040d\",\"localrelay\":true,\"timeoffset\":0,\"networkactive\":true,\"connections\":9,\"networks\":[{\"name\":\"ipv4\",\"limited\":false,\"reachable\":true,\"proxy\":\"\",\"proxy_randomize_credentials\":false},{\"name\":\"ipv6\",\"limited\":false,\"reachable\":true,\"proxy\":\"\",\"proxy_randomize_credentials\":false},{\"name\":\"onion\",\"limited\":true,\"reachable\":false,\"proxy\":\"\",\"proxy_randomize_credentials\":false}],\"relayfee\":0.00001000,\"incrementalfee\":0.00001000,\"localaddresses\":[],\"warnings\":\"Warning: unknown new rules activated (versionbit 28)\"},\"error\":null,\"id\":null}");
        BtcRpcNetworkInfoResponse btcRpcNetworkInfoResponse = undertest.getNetworkInfo();
        Assert.assertNotNull("Is not null", btcRpcNetworkInfoResponse);

        Assert.assertEquals("Is not equals", "/Satoshi:0.18.1/", btcRpcNetworkInfoResponse.getSubversion());

    }

    /**
     * Test get node addresses.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetNodeAddresses() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":[{\"time\":1573143734,\"services\":1037,\"address\":\"84.242.164.239\",\"port\":18333}],\"error\":null,\"id\":null}\n");
        List<BtcRpcGetNodeAddressesResponse> list = undertest.getNodeAddresses();
        Assert.assertNotNull("Is not null", list);
        BtcRpcGetNodeAddressesResponse btcRpcGetNodeAddressesResponse = list.get(0);
        Assert.assertEquals("Is not equals", "84.242.164.239", btcRpcGetNodeAddressesResponse.getAddress());
    }

    /**
     * Test get peer info.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetPeerInfo() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":[{\"id\":75,\"addr\":\"2.113.15.154:18333\",\"addrlocal\":\"81.203.235.96:45116\",\"addrbind\":\"192.168.0.163:45116\",\"services\":\"000000000000040d\",\"relaytxes\":true,\"lastsend\":1575297091,\"lastrecv\":1575297095,\"bytessent\":44880,\"bytesrecv\":541833,\"conntime\":1575292902,\"timeoffset\":-9,\"pingtime\":0.047354,\"minping\":0.043501,\"version\":70015,\"subver\":\"/Satoshi:0.17.1/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610826,\"banscore\":0,\"synced_headers\":1610831,\"synced_blocks\":1610831,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00001000,\"bytessent_per_msg\":{\"addr\":110,\"feefilter\":32,\"getaddr\":24,\"getdata\":12350,\"getheaders\":1085,\"headers\":25,\"inv\":26268,\"ping\":1120,\"pong\":1120,\"sendcmpct\":99,\"sendheaders\":24,\"tx\":2473,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30137,\"block\":409812,\"cmpctblock\":7747,\"feefilter\":32,\"getdata\":488,\"getheaders\":1085,\"headers\":106,\"inv\":18544,\"ping\":1120,\"pong\":1120,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":71402,\"verack\":24,\"version\":126}},{\"id\":78,\"addr\":\"104.218.150.185:18333\",\"addrlocal\":\"81.203.235.96:44722\",\"addrbind\":\"192.168.0.163:44722\",\"services\":\"0000000000000409\",\"relaytxes\":true,\"lastsend\":1575297093,\"lastrecv\":1575297082,\"bytessent\":41935,\"bytesrecv\":79269,\"conntime\":1575292979,\"timeoffset\":-5,\"pingtime\":0.120481,\"minping\":0.114661,\"version\":70015,\"subver\":\"/Satoshi:0.19.0/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610826,\"banscore\":0,\"synced_headers\":1610831,\"synced_blocks\":1610831,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00001000,\"bytessent_per_msg\":{\"addr\":165,\"feefilter\":32,\"getaddr\":24,\"getdata\":4895,\"getheaders\":1085,\"headers\":212,\"inv\":32032,\"ping\":1120,\"pong\":1120,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":1010,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30192,\"feefilter\":32,\"getdata\":183,\"getheaders\":1085,\"headers\":636,\"inv\":15423,\"ping\":1120,\"pong\":1120,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":29238,\"verack\":24,\"version\":126}},{\"id\":82,\"addr\":\"138.68.105.48:18333\",\"addrlocal\":\"81.203.235.96:49620\",\"addrbind\":\"192.168.0.163:49620\",\"services\":\"000000000000040d\",\"relaytxes\":true,\"lastsend\":1575297098,\"lastrecv\":1575297098,\"bytessent\":40389,\"bytesrecv\":121192,\"conntime\":1575293023,\"timeoffset\":-1,\"pingtime\":0.045578,\"minping\":0.041698,\"version\":70015,\"subver\":\"/Satoshi:0.17.1/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610826,\"banscore\":0,\"synced_headers\":1610831,\"synced_blocks\":1610831,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00001000,\"bytessent_per_msg\":{\"addr\":110,\"feefilter\":32,\"getaddr\":24,\"getdata\":9370,\"getheaders\":1085,\"headers\":106,\"inv\":26262,\"ping\":1088,\"pong\":1088,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":984,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30192,\"cmpctblock\":3997,\"feefilter\":32,\"getdata\":183,\"getheaders\":1085,\"headers\":636,\"inv\":20716,\"ping\":1088,\"pong\":1088,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":61935,\"verack\":24,\"version\":126}},{\"id\":83,\"addr\":\"52.221.229.70:18333\",\"addrlocal\":\"81.203.235.96:38264\",\"addrbind\":\"192.168.0.163:38264\",\"services\":\"000000000000040c\",\"relaytxes\":true,\"lastsend\":1575297098,\"lastrecv\":1575297098,\"bytessent\":56515,\"bytesrecv\":82147,\"conntime\":1575293024,\"timeoffset\":-1,\"pingtime\":0.191671,\"minping\":0.185626,\"version\":70015,\"subver\":\"/Satoshi:0.18.0/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610826,\"banscore\":0,\"synced_headers\":1610831,\"synced_blocks\":1610831,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00000000,\"bytessent_per_msg\":{\"addr\":165,\"feefilter\":32,\"getaddr\":24,\"getdata\":5198,\"getheaders\":1085,\"headers\":318,\"inv\":31694,\"ping\":1088,\"pong\":1088,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":15583,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30082,\"getdata\":2595,\"getheaders\":1085,\"headers\":636,\"inv\":16077,\"notfound\":61,\"ping\":1088,\"pong\":1088,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":29195,\"verack\":24,\"version\":126}},{\"id\":85,\"addr\":\"142.245.72.12:18333\",\"addrlocal\":\"81.203.235.96:41278\",\"addrbind\":\"192.168.0.163:41278\",\"services\":\"000000000000040d\",\"relaytxes\":true,\"lastsend\":1575297090,\"lastrecv\":1575297093,\"bytessent\":40118,\"bytesrecv\":81533,\"conntime\":1575293091,\"timeoffset\":8,\"pingtime\":0.133556,\"minping\":0.129455,\"version\":70015,\"subver\":\"/Satoshi:0.18.0/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610826,\"banscore\":0,\"synced_headers\":1610831,\"synced_blocks\":1610831,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00001000,\"bytessent_per_msg\":{\"addr\":55,\"feefilter\":32,\"getaddr\":24,\"getdata\":5123,\"getheaders\":1085,\"headers\":318,\"inv\":27244,\"ping\":1088,\"pong\":1088,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":3821,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30137,\"feefilter\":32,\"getdata\":732,\"getheaders\":1085,\"headers\":636,\"inv\":17402,\"ping\":1088,\"pong\":1088,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":29093,\"verack\":24,\"version\":126}},{\"id\":90,\"addr\":\"47.98.224.31:18333\",\"addrlocal\":\"81.203.235.96:37552\",\"addrbind\":\"192.168.0.163:37552\",\"services\":\"000000000000040d\",\"relaytxes\":true,\"lastsend\":1575297098,\"lastrecv\":1575297098,\"bytessent\":42407,\"bytesrecv\":156944,\"conntime\":1575293176,\"timeoffset\":0,\"pingtime\":0.312863,\"minping\":0.309009,\"version\":70015,\"subver\":\"/Satoshi:0.18.0/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610826,\"banscore\":0,\"synced_headers\":1610831,\"synced_blocks\":1610831,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00001000,\"bytessent_per_msg\":{\"addr\":55,\"feefilter\":32,\"getaddr\":24,\"getblocktxn\":191,\"getdata\":4993,\"getheaders\":1085,\"headers\":212,\"inv\":30066,\"notfound\":61,\"ping\":1024,\"pong\":1024,\"sendcmpct\":99,\"sendheaders\":24,\"tx\":3367,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30082,\"blocktxn\":66663,\"cmpctblock\":7747,\"feefilter\":32,\"getdata\":682,\"getheaders\":1085,\"headers\":212,\"inv\":20425,\"ping\":1024,\"pong\":1024,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":27728,\"verack\":24,\"version\":126}},{\"id\":95,\"addr\":\"120.79.243.120:18333\",\"addrlocal\":\"81.203.235.96:44794\",\"addrbind\":\"192.168.0.163:44794\",\"services\":\"000000000000000d\",\"relaytxes\":true,\"lastsend\":1575297097,\"lastrecv\":1575297079,\"bytessent\":27449,\"bytesrecv\":63560,\"conntime\":1575294554,\"timeoffset\":-2,\"pingtime\":1.29086,\"minping\":0.337029,\"version\":70015,\"subver\":\"/Satoshi:0.13.2/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610828,\"banscore\":0,\"synced_headers\":1610830,\"synced_blocks\":1610830,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00000000,\"bytessent_per_msg\":{\"addr\":55,\"feefilter\":32,\"getaddr\":24,\"getdata\":3152,\"getheaders\":1085,\"headers\":424,\"inv\":20145,\"ping\":704,\"pong\":704,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":884,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30082,\"getdata\":158,\"getheaders\":1085,\"headers\":318,\"inv\":13847,\"ping\":704,\"pong\":704,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":16422,\"verack\":24,\"version\":126}},{\"id\":98,\"addr\":\"169.50.138.172:18333\",\"addrlocal\":\"81.203.235.96:40730\",\"addrbind\":\"192.168.0.163:40730\",\"services\":\"000000000000040d\",\"relaytxes\":true,\"lastsend\":1575297093,\"lastrecv\":1575297093,\"bytessent\":28508,\"bytesrecv\":81303,\"conntime\":1575294604,\"timeoffset\":-1,\"pingtime\":0.049207,\"minping\":0.044553,\"version\":70015,\"subver\":\"/Satoshi:0.18.1/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610828,\"banscore\":0,\"synced_headers\":1610831,\"synced_blocks\":1610831,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00001000,\"bytessent_per_msg\":{\"addr\":110,\"feefilter\":32,\"getaddr\":24,\"getdata\":6035,\"getheaders\":1085,\"headers\":106,\"inv\":18299,\"ping\":672,\"pong\":672,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":1233,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30082,\"feefilter\":32,\"getdata\":244,\"getheaders\":1085,\"headers\":424,\"inv\":13559,\"ping\":672,\"pong\":672,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":34293,\"verack\":24,\"version\":126}}],\"error\":null,\"id\":null}");
        List<BtcRpcGetPeerInfoResponse> list = undertest.getPeerInfo();
        Assert.assertNotNull("Is not null", list);

        BtcRpcGetPeerInfoResponse btcRpcGetPeerInfoResponse = list.get(0);
        Assert.assertEquals("Is not equals", "2.113.15.154:18333", btcRpcGetPeerInfoResponse.getAddr());
        // for (BtcRpcGetPeerInfoResponse btcRpcGetPeerInfoResponse : list) {
        // System.out.println(btcRpcGetPeerInfoResponse.getId());
        // }
    }

    /**
     * Test list banned.
     *
     * @throws Exception the exception
     */
    @Test
    public void testListBanned() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":[{\"address\":\"2.113.15.154/32\",\"banned_until\":1575333574,\"ban_created\":1575303574,\"ban_reason\":\"manually added\"}],\"error\":null,\"id\":null}");
        List<BtcRpcListBannedResponse> list = undertest.listBanned();
        Assert.assertNotNull("Is not null", list);

        BtcRpcListBannedResponse btcRpcListBannedResponse = list.get(0);
        Assert.assertEquals("Is not equals", "2.113.15.154/32", btcRpcListBannedResponse.getAddress());
    }

    /**
     * Test ping.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPing() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        Boolean success = undertest.ping();
        Assert.assertTrue("Expected true", success);

        enqueueMockedResponse(200,
                "{\"result\":[{\"id\":78,\"addr\":\"104.218.150.185:18333\",\"addrlocal\":\"81.203.235.96:44722\",\"addrbind\":\"192.168.0.163:44722\",\"services\":\"0000000000000409\",\"relaytxes\":true,\"lastsend\":1575304629,\"lastrecv\":1575304630,\"bytessent\":105159,\"bytesrecv\":130049,\"conntime\":1575292979,\"timeoffset\":-5,\"pingtime\":0.12593,\"minping\":0.114661,\"version\":70015,\"subver\":\"/Satoshi:0.19.0/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610826,\"banscore\":0,\"synced_headers\":1610840,\"synced_blocks\":1610840,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00001000,\"bytessent_per_msg\":{\"addr\":220,\"feefilter\":32,\"getaddr\":24,\"getdata\":8599,\"getheaders\":1085,\"headers\":742,\"inv\":85884,\"ping\":3168,\"pong\":3136,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":2029,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30247,\"feefilter\":32,\"getdata\":427,\"getheaders\":1085,\"headers\":1484,\"inv\":40529,\"ping\":3136,\"pong\":3168,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":49701,\"verack\":24,\"version\":126}},{\"id\":82,\"addr\":\"138.68.105.48:18333\",\"addrlocal\":\"81.203.235.96:49620\",\"addrbind\":\"192.168.0.163:49620\",\"services\":\"000000000000040d\",\"relaytxes\":true,\"lastsend\":1575304629,\"lastrecv\":1575304629,\"bytessent\":104329,\"bytesrecv\":257285,\"conntime\":1575293023,\"timeoffset\":-1,\"pingtime\":0.047377,\"minping\":0.040245,\"version\":70015,\"subver\":\"/Satoshi:0.17.1/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610826,\"banscore\":0,\"synced_headers\":1610840,\"synced_blocks\":1610840,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00001000,\"bytessent_per_msg\":{\"addr\":220,\"feefilter\":32,\"getaddr\":24,\"getdata\":25544,\"getheaders\":1085,\"headers\":106,\"inv\":69518,\"ping\":3168,\"pong\":3104,\"sendcmpct\":99,\"sendheaders\":24,\"tx\":1255,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30247,\"cmpctblock\":13954,\"feefilter\":32,\"getdata\":244,\"getheaders\":1085,\"headers\":1060,\"inv\":54562,\"notfound\":61,\"ping\":3104,\"pong\":3168,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":149528,\"verack\":24,\"version\":126}},{\"id\":83,\"addr\":\"52.221.229.70:18333\",\"addrlocal\":\"81.203.235.96:38264\",\"addrbind\":\"192.168.0.163:38264\",\"services\":\"000000000000040c\",\"relaytxes\":true,\"lastsend\":1575304629,\"lastrecv\":1575304630,\"bytessent\":159085,\"bytesrecv\":143642,\"conntime\":1575293024,\"timeoffset\":-1,\"pingtime\":0.186867,\"minping\":0.185626,\"version\":70015,\"subver\":\"/Satoshi:0.18.0/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610826,\"banscore\":0,\"synced_headers\":1610840,\"synced_blocks\":1610840,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00000000,\"bytessent_per_msg\":{\"addr\":165,\"feefilter\":32,\"getaddr\":24,\"getdata\":9653,\"getheaders\":1085,\"headers\":742,\"inv\":88040,\"ping\":3136,\"pong\":3104,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":52864,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30082,\"getdata\":9282,\"getheaders\":1085,\"headers\":1590,\"inv\":38841,\"notfound\":61,\"ping\":3104,\"pong\":3136,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":56221,\"verack\":24,\"version\":126}},{\"id\":85,\"addr\":\"142.245.72.12:18333\",\"addrlocal\":\"81.203.235.96:41278\",\"addrbind\":\"192.168.0.163:41278\",\"services\":\"000000000000040d\",\"relaytxes\":true,\"lastsend\":1575304629,\"lastrecv\":1575304630,\"bytessent\":119515,\"bytesrecv\":161057,\"conntime\":1575293091,\"timeoffset\":8,\"pingtime\":0.129371,\"minping\":0.129085,\"version\":70015,\"subver\":\"/Satoshi:0.18.0/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610826,\"banscore\":0,\"synced_headers\":1610840,\"synced_blocks\":1610840,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00001000,\"bytessent_per_msg\":{\"addr\":55,\"feefilter\":32,\"getaddr\":24,\"getdata\":13152,\"getheaders\":1085,\"headers\":848,\"inv\":79107,\"notfound\":61,\"ping\":3136,\"pong\":3104,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":18671,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30192,\"feefilter\":32,\"getdata\":3108,\"getheaders\":1085,\"headers\":1590,\"inv\":44009,\"ping\":3104,\"pong\":3136,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":74561,\"verack\":24,\"version\":126}},{\"id\":90,\"addr\":\"47.98.224.31:18333\",\"addrlocal\":\"81.203.235.96:37552\",\"addrbind\":\"192.168.0.163:37552\",\"services\":\"000000000000040d\",\"relaytxes\":true,\"lastsend\":1575304629,\"lastrecv\":1575304622,\"bytessent\":117448,\"bytesrecv\":255875,\"conntime\":1575293176,\"timeoffset\":0,\"pingtime\":0.313759,\"minping\":0.309009,\"pingwait\":0.236469,\"version\":70015,\"subver\":\"/Satoshi:0.18.0/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610826,\"banscore\":0,\"synced_headers\":1610840,\"synced_blocks\":1610840,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00001000,\"bytessent_per_msg\":{\"addr\":165,\"feefilter\":32,\"getaddr\":24,\"getblocktxn\":191,\"getdata\":12542,\"getheaders\":1085,\"headers\":742,\"inv\":82798,\"notfound\":366,\"ping\":3040,\"pong\":3008,\"sendcmpct\":99,\"sendheaders\":24,\"tx\":13182,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30082,\"blocktxn\":66663,\"cmpctblock\":18834,\"feefilter\":32,\"getdata\":2706,\"getheaders\":1085,\"headers\":212,\"inv\":56251,\"ping\":3008,\"pong\":3008,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":73754,\"verack\":24,\"version\":126}},{\"id\":95,\"addr\":\"120.79.243.120:18333\",\"addrlocal\":\"81.203.235.96:44794\",\"addrbind\":\"192.168.0.163:44794\",\"services\":\"000000000000000d\",\"relaytxes\":true,\"lastsend\":1575304629,\"lastrecv\":1575304628,\"bytessent\":96833,\"bytesrecv\":146144,\"conntime\":1575294554,\"timeoffset\":-2,\"pingtime\":0.675458,\"minping\":0.336529,\"pingwait\":0.236328,\"version\":70015,\"subver\":\"/Satoshi:0.13.2/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610828,\"banscore\":0,\"synced_headers\":1610840,\"synced_blocks\":1610840,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00000000,\"bytessent_per_msg\":{\"addr\":55,\"feefilter\":32,\"getaddr\":24,\"getdata\":10479,\"getheaders\":2170,\"headers\":1378,\"inv\":72195,\"ping\":2752,\"pong\":2688,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":4820,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30137,\"getdata\":840,\"getheaders\":1085,\"headers\":1116,\"inv\":45042,\"ping\":2688,\"pong\":2720,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":62276,\"verack\":24,\"version\":126}},{\"id\":98,\"addr\":\"169.50.138.172:18333\",\"addrlocal\":\"81.203.235.96:40730\",\"addrbind\":\"192.168.0.163:40730\",\"services\":\"000000000000040d\",\"relaytxes\":true,\"lastsend\":1575304629,\"lastrecv\":1575304630,\"bytessent\":92035,\"bytesrecv\":197822,\"conntime\":1575294604,\"timeoffset\":-1,\"pingtime\":0.047988,\"minping\":0.0442,\"version\":70015,\"subver\":\"/Satoshi:0.18.1/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610828,\"banscore\":0,\"synced_headers\":1610840,\"synced_blocks\":1610840,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00001000,\"bytessent_per_msg\":{\"addr\":165,\"feefilter\":32,\"getaddr\":24,\"getdata\":18807,\"getheaders\":1085,\"headers\":106,\"inv\":61818,\"notfound\":61,\"ping\":2720,\"pong\":2688,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":4289,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30082,\"feefilter\":32,\"getdata\":732,\"getheaders\":1085,\"headers\":1378,\"inv\":48128,\"notfound\":61,\"ping\":2688,\"pong\":2720,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":110676,\"verack\":24,\"version\":126}},{\"id\":101,\"addr\":\"142.44.167.235:18333\",\"addrlocal\":\"81.203.235.96:54146\",\"addrbind\":\"192.168.0.163:54146\",\"services\":\"0000000000000009\",\"relaytxes\":true,\"lastsend\":1575304629,\"lastrecv\":1575304630,\"bytessent\":49878,\"bytesrecv\":159730,\"conntime\":1575298975,\"timeoffset\":-1,\"pingtime\":0.112004,\"minping\":0.108228,\"version\":70015,\"subver\":\"/bcoin:v1.0.2/\",\"inbound\":false,\"addnode\":false,\"startingheight\":1610834,\"banscore\":0,\"synced_headers\":1610840,\"synced_blocks\":1610840,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00000000,\"bytessent_per_msg\":{\"addr\":55,\"feefilter\":32,\"getaddr\":24,\"getdata\":12683,\"getheaders\":1085,\"inv\":25862,\"ping\":1568,\"pong\":6016,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":2313,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30082,\"getblocks\":5425,\"getdata\":366,\"headers\":742,\"inv\":36508,\"ping\":6016,\"pong\":1568,\"sendcmpct\":33,\"tx\":78842,\"verack\":24,\"version\":124}},{\"id\":105,\"addr\":\"2.113.15.154:18333\",\"addrlocal\":\"81.203.235.96:46838\",\"addrbind\":\"192.168.0.163:46838\",\"services\":\"000000000000040d\",\"relaytxes\":true,\"lastsend\":1575304629,\"lastrecv\":1575304629,\"bytessent\":9500,\"bytesrecv\":40784,\"conntime\":1575303576,\"timeoffset\":-1,\"pingtime\":0.048398,\"minping\":0.04723,\"version\":70015,\"subver\":\"/Satoshi:0.17.1/\",\"inbound\":false,\"addnode\":true,\"startingheight\":1610839,\"banscore\":0,\"synced_headers\":1610840,\"synced_blocks\":1610840,\"inflight\":[],\"whitelisted\":false,\"minfeefilter\":0.00001000,\"bytessent_per_msg\":{\"addr\":55,\"feefilter\":32,\"getaddr\":24,\"getdata\":1023,\"getheaders\":1085,\"headers\":106,\"inv\":6295,\"ping\":352,\"pong\":288,\"sendcmpct\":66,\"sendheaders\":24,\"verack\":24,\"version\":126},\"bytesrecv_per_msg\":{\"addr\":30137,\"feefilter\":32,\"getheaders\":1085,\"headers\":212,\"inv\":3116,\"ping\":288,\"pong\":352,\"sendcmpct\":66,\"sendheaders\":24,\"tx\":5322,\"verack\":24,\"version\":126}}],\"error\":null,\"id\":null}");
        List<BtcRpcGetPeerInfoResponse> list = undertest.getPeerInfo();
        Assert.assertNotNull("Is not null", list);

        BtcRpcGetPeerInfoResponse btcRpcGetPeerInfoResponse = list.get(4);

        Assert.assertEquals("Is not equals", Double.valueOf("0.236469"), btcRpcGetPeerInfoResponse.getPingwait());
        Assert.assertEquals("Is not equals", Double.valueOf("0.313759"), btcRpcGetPeerInfoResponse.getPingtime());

    }

    /**
     * Test set ban.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSetBan() throws Exception {
        enqueueMockedResponse(200, "{\"result\":null,\"error\":null,\"id\":null}");
        Boolean success = undertest.setBan("2.113.15.154", "add", 30000L, false);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test set network active.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSetNetworkActive() throws Exception {
        enqueueMockedResponse(200, "{\"result\":true,\"error\":null,\"id\":null}");
        Boolean success = undertest.setNetworkActive(true);
        Assert.assertTrue("Expected true", success);
    }
}
