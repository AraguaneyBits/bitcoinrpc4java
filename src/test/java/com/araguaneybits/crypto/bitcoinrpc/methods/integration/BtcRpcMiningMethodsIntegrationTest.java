/*
 * Creation : 12 sept. 2019
 */
package com.araguaneybits.crypto.bitcoinrpc.methods.integration;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.araguaneybits.crypto.bitcoinrpc.constants.EnumEstimateMode;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcMiningMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletToolsMethods;

//@Ignore
public class BtcRpcMiningMethodsIntegrationTest extends AbstractBtcRpcMethodsIntegrationTest {

    private BtcRpcMiningMethods undertest;
    private BtcRpcWalletMethods btcRpcWalletMethods;
    private BtcRpcWalletToolsMethods btcRpcWalletToolsMethods;

    @Before
    public void setUp() {
        undertest = new BtcRpcMiningMethods(btcRpcGateway);
        btcRpcWalletMethods = new BtcRpcWalletMethods(btcRpcGateway);
        btcRpcWalletToolsMethods = new BtcRpcWalletToolsMethods(btcRpcGateway);
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
        BigDecimal hashps = undertest.getnetworkhashps(120, -1);
        Assert.assertNotNull("Is not null", hashps);
    }

    // @Test
    public void testPrioritisetransaction() throws Exception {
        String address = btcRpcWalletMethods.getNewAddress();
        btcRpcWalletToolsMethods.walletPassphrase(PASSPHRASE, 30L);
        String txid = btcRpcWalletMethods.sendToAddress(address, new BigDecimal("0.11111111"), "prioritisetransaction-" + System.currentTimeMillis(),
                "", true, true, 3L, EnumEstimateMode.CONSERVATIVE);
        Boolean success = undertest.prioritisetransaction(txid, new BigInteger("10000"));
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
