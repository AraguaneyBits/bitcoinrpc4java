/*
 * Creation : 12 sept. 2019
 */
package com.araguaneybits.crypto.bitcoinrpc.methods.integration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcControlMethods;

@Ignore
public class BtcRpcControlMethodsIntegrationTest extends AbstractBtcRpcMethodsIntegrationTest {

    private BtcRpcControlMethods undertest;

    @Before
    public void setUp() {
        undertest = new BtcRpcControlMethods(btcRpcGateway);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetmemoryinfo() throws Exception {
        undertest.getmemoryinfo();
        Assert.fail("Test method not implemented");
    }

    @Test
    public void testGetrpcinfo() throws Exception {
        undertest.getrpcinfo();
        Assert.fail("Test method not implemented");
    }

    @Test
    public void testHelp() throws Exception {
        undertest.help();
        Assert.fail("Test method not implemented");
    }

    @Test
    public void testLogging() throws Exception {
        undertest.logging();
        Assert.fail("Test method not implemented");
    }

    @Test
    public void testStop() throws Exception {
        undertest.stop();
        Assert.fail("Test method not implemented");
    }

    @Test
    public void testUptime() throws Exception {
        undertest.uptime();
        Assert.fail("Test method not implemented");
    }

    @Test
    public void testGetzmqnotifications() throws Exception {
        undertest.getzmqnotifications();
        Assert.fail("Test method not implemented");
    }
}
