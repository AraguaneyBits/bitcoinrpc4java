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

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.constants.EnumAddressType;
import com.araguaneybits.crypto.bitcoinrpc.constants.EnumEstimateMode;
import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcUtilMethods;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcCreateMultiSigResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcEstimateSmartFeeResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetDescriptorInfoResponse;

/**
 * The Class BtcRpcUtilMethodsIntegrationTest.
 *
 * @author jestevez
 */
@Ignore
public class BtcRpcUtilMethodsIntegrationTest extends AbstractBtcRpcMethodsIntegrationTest {

    /** The undertest. */
    private BtcRpcUtilMethods undertest;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        undertest = new BtcRpcUtilMethods(btcRpcGateway);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {

    }

    /**
     * Test create multi sig.
     *
     * @throws Exception the exception
     */
    @Test
    public void testCreateMultiSig() throws Exception {
        BtcRpcCreateMultiSigResponse btcRpcCreateMultiSigResponse = undertest.createMultiSig(2L,
                new String[] { "03789ed0bb717d88f7d321a368d905e7430207ebbd82bd342cf11ae157a7ace5fd",
                        "03dbc6764b8884a92e871274b87583e6d5c2a58819473e17e107ef3f6aa5a61626" },
                EnumAddressType.LEGACY);
        Assert.assertEquals("Expected correct address", "2NGRTbZBLGV4tJ3y4Avz7sa2Dea9o93UaPH", btcRpcCreateMultiSigResponse.getAddress());
    }

    /**
     * Test derive addresses.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDeriveAddresses() throws Exception {
        List<String> address = undertest.deriveAddresses(
                "wpkh([d34db33f/84'/0'/0']0279be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798)#n9g43y4k", new Long[] { 0L, 2L });
        Assert.assertEquals("Expected correct address", "bcrt1qw508d6qejxtdg4y5r3zarvary0c5xw7kygt080", address.get(0));
    }

    /**
     * Test estimate raw fee.
     *
     * @throws Exception the exception
     */
    @Test
    public void testEstimateRawFee() throws Exception {
        undertest.estimateRawFee(6, 0.9);
    }

    /**
     * Test estimate smart fee.
     *
     * @throws Exception the exception
     */
    @Test
    public void testEstimateSmartFee() throws Exception {
        BtcRpcEstimateSmartFeeResponse btcRpcEstimateSmartFeeResponse = undertest.estimateSmartFee(3, EnumEstimateMode.CONSERVATIVE);
        // Assert.assertEquals("Expected feerate", new BigDecimal("0.00021199"), btcRpcEstimateSmartFeeResponse.getFeerate());
    }

    /**
     * Test get descriptor info.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetDescriptorInfo() throws Exception {
        BtcRpcGetDescriptorInfoResponse btcRpGetDescriptorInfoResponse = undertest
                .getDescriptorInfo("wpkh([d34db33f/84h/0h/0h]0279be667ef9dcbbac55a06295Ce870b07029Bfcdb2dce28d959f2815b16f81798)");

        Assert.assertEquals("Expected Descriptor",
                "wpkh([d34db33f/84'/0'/0']0279be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798)#n9g43y4k",
                btcRpGetDescriptorInfoResponse.getDescriptor());

    }

    /**
     * Test sign message with privkey.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSignMessageWithPrivkey() throws Exception {
        String signature = undertest.signMessageWithPrivkey("cVBNJ3dyZcfS3jSYJAxz9wnEbvxVY33dynVoNBv6Ey7HZDsuwYVF", "Hola Mundo");
        Assert.assertEquals("Expected signature", "IAuY+2NwqUpUZYrCfZskwXz+T2+F/I7W2XA5OFWRJaHeI2qOHztwjm3eZbuC7rRz0cCN46tBA326sYStRKSI4jI=",
                signature);
    }

    /**
     * Test validate address.
     *
     * @throws Exception the exception
     */
    @Test
    public void testValidateAddress() throws Exception {
        Boolean valid = undertest.validateAddress("n3LPqUzimPjuYuk2rVeL59R1sQrHuMvMwe");
        Assert.assertTrue("Is valid", valid);
    }

    /**
     * Test verifymessage.
     *
     * @throws Exception the exception
     */
    @Test
    public void testVerifymessage() throws Exception {
        Boolean isOk = undertest.verifymessage("n3LPqUzimPjuYuk2rVeL59R1sQrHuMvMwe",
                "IAuY+2NwqUpUZYrCfZskwXz+T2+F/I7W2XA5OFWRJaHeI2qOHztwjm3eZbuC7rRz0cCN46tBA326sYStRKSI4jI=", "Hola Mundo");
        Assert.assertTrue("Expected true", isOk);
    }

}
