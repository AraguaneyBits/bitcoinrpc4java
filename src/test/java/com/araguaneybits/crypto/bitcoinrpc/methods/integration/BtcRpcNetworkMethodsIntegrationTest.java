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

import java.math.BigInteger;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.araguaneybits.crypto.bitcoinrpc.constants.EnumAddNodeType;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcNetworkMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetAddedNodeInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetNetTotalsResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetNodeAddressesResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetPeerInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListBannedResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcNetworkInfoResponse;

/**
 * The Class BtcRpcNetworkMethodsIntegrationTest.
 *
 * @author jestevez
 */
// @Ignore
public class BtcRpcNetworkMethodsIntegrationTest extends AbstractBtcRpcMethodsIntegrationTest {

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
    // @Test
    public void testAddNode() throws Exception {
        Boolean success = undertest.addNode("2.113.15.154:18333", EnumAddNodeType.ADD);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test clear banned.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testClearBanned() throws Exception {
        Boolean success = undertest.clearBanned();
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test disconnect node.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testDisconnectNode() throws Exception {
        Boolean success = undertest.disconnectNode("2.113.15.154:18333");
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test get added node info.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetAddedNodeInfo() throws Exception {
        List<BtcRpcGetAddedNodeInfoResponse> list = undertest.getAddedNodeInfo();
        Assert.assertNotNull("Is not null", list);
    }

    /**
     * Test get connection count.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetConnectionCount() throws Exception {
        BigInteger count = undertest.getConnectionCount();
        Assert.assertNotNull("Is not null", count);
    }

    /**
     * Test get net totals.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetNetTotals() throws Exception {
        BtcRpcGetNetTotalsResponse btcRpcGetNetTotalsResponse = undertest.getNetTotals();
        Assert.assertNotNull("Is not null", btcRpcGetNetTotalsResponse);
    }

    /**
     * Test get network info.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetNetworkInfo() throws Exception {
        BtcRpcNetworkInfoResponse btcRpcNetworkInfoResponse = undertest.getNetworkInfo();
        Assert.assertNotNull("Is not null", btcRpcNetworkInfoResponse);
    }

    /**
     * Test get node addresses.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetNodeAddresses() throws Exception {
        List<BtcRpcGetNodeAddressesResponse> list = undertest.getNodeAddresses();
        Assert.assertNotNull("Is not null", list);
    }

    /**
     * Test get peer info.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetPeerInfo() throws Exception {
        List<BtcRpcGetPeerInfoResponse> list = undertest.getPeerInfo();
        Assert.assertNotNull("Is not null", list);
    }

    /**
     * Test list banned.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testListBanned() throws Exception {
        List<BtcRpcListBannedResponse> list = undertest.listBanned();
        Assert.assertNotNull("Is not null", list);
    }

    /**
     * Test ping.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testPing() throws Exception {
        Boolean success = undertest.ping();
        Assert.assertTrue("Expected true", success);

        List<BtcRpcGetPeerInfoResponse> list = undertest.getPeerInfo();
        Assert.assertNotNull("Is not null", list);

        for (BtcRpcGetPeerInfoResponse btcRpcGetPeerInfoResponse : list) {
            btcRpcGetPeerInfoResponse.getPingtime();
            btcRpcGetPeerInfoResponse.getPingwait();

        }

    }

    /**
     * Test set ban.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSetBan() throws Exception {
        Boolean success = undertest.setBan("2.113.15.154", "remove", 30000L, false);
        Assert.assertTrue("Expected true", success);
    }

    /**
     * Test set network active.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testSetNetworkActive() throws Exception {
        Boolean success = undertest.setNetworkActive(true);
        Assert.assertTrue("Expected true", success);
    }
}
