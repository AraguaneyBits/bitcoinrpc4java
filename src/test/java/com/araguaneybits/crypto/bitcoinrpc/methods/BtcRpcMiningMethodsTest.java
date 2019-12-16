/*
 * Creation : 12 sept. 2019
 */
package com.araguaneybits.crypto.bitcoinrpc.methods;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

//@Ignore
public class BtcRpcMiningMethodsTest extends AbstractBtcRpcMethodsTest {

    private BtcRpcMiningMethods undertest;

    @Before
    public void setUp() {
        undertest = new BtcRpcMiningMethods(btcRpcGateway);

    }

    @After
    public void tearDown() {

    }

    // @Test
    public void testGetblocktemplate() throws Exception {
        undertest.getblocktemplate();
        Assert.fail("Test method not implemented");
    }

    // @Test
    public void testGetmininginfo() throws Exception {
        undertest.getmininginfo();
        Assert.fail("Test method not implemented");
    }

    // @Test
    public void testGetnetworkhashps() throws Exception {
        enqueueMockedResponse(200, "{\"result\":37757629937695.34,\"error\":null,\"id\":null}");
        BigDecimal hashps = undertest.getnetworkhashps(120, -1);
        Assert.assertEquals("Expected equals37757629937695.34", new BigDecimal("37757629937695.34"), hashps);
    }

    // @Test
    public void testPrioritisetransaction() throws Exception {
        enqueueMockedResponse(200, "{\"result\":true,\"error\":null,\"id\":null}");
        Boolean success = undertest.prioritisetransaction("", new BigInteger("10000"));
        Assert.assertTrue("Expected true", success);
    }

    // @Test
    public void testSubmitblock() throws Exception {
        undertest.submitblock("");
        Assert.fail("Test method not implemented");
    }

    // @Test
    public void testSubmitheader() throws Exception {
        undertest.submitheader();
        Assert.fail("Test method not implemented");
    }

    // @Test
    public void testGeneratetoaddress() throws Exception {
        undertest.generatetoaddress();
        Assert.fail("Test method not implemented");
    }
}
