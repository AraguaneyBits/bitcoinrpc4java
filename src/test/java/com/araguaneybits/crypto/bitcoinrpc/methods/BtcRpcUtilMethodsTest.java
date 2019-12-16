package com.araguaneybits.crypto.bitcoinrpc.methods;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.araguaneybits.crypto.bitcoinrpc.constants.EnumAddressType;
import com.araguaneybits.crypto.bitcoinrpc.constants.EnumEstimateMode;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcCreateMultiSigResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcEstimateSmartFeeResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetDescriptorInfoResponse;

//@Ignore
public class BtcRpcUtilMethodsTest extends AbstractBtcRpcMethodsTest {

    private BtcRpcUtilMethods undertest;

    @Before
    public void setUp() {
        undertest = new BtcRpcUtilMethods(btcRpcGateway);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testCreateMultiSig() throws Exception {

        enqueueMockedResponse(200,
                "{\"result\":{\"address\":\"2NGRTbZBLGV4tJ3y4Avz7sa2Dea9o93UaPH\",\"redeemScript\":\"522103789ed0bb717d88f7d321a368d905e7430207ebbd82bd342cf11ae157a7ace5fd2103dbc6764b8884a92e871274b87583e6d5c2a58819473e17e107ef3f6aa5a6162652ae\"},\"error\":null,\"id\":null}");

        BtcRpcCreateMultiSigResponse btcRpcCreateMultiSigResponse = undertest.createMultiSig(2L,
                new String[] { "03789ed0bb717d88f7d321a368d905e7430207ebbd82bd342cf11ae157a7ace5fd",
                        "03dbc6764b8884a92e871274b87583e6d5c2a58819473e17e107ef3f6aa5a61626" },
                EnumAddressType.LEGACY);
        Assert.assertEquals("Expected correct address", "2NGRTbZBLGV4tJ3y4Avz7sa2Dea9o93UaPH", btcRpcCreateMultiSigResponse.getAddress());
    }

    @Test
    public void testGetDescriptorInfo() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"descriptor\":\"wpkh([d34db33f/84'/0'/0']0279be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798)#n9g43y4k\",\"isrange\":false,\"issolvable\":true,\"hasprivatekeys\":false},\"error\":null,\"id\":null}");

        BtcRpcGetDescriptorInfoResponse btcRpGetDescriptorInfoResponse = undertest
                .getDescriptorInfo("wpkh([d34db33f/84h/0h/0h]0279be667ef9dcbbac55a06295Ce870b07029Bfcdb2dce28d959f2815b16f81798)");

        Assert.assertEquals("Expected Descriptor",
                "wpkh([d34db33f/84'/0'/0']0279be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798)#n9g43y4k",
                btcRpGetDescriptorInfoResponse.getDescriptor());

    }

    @Test
    public void testEstimateSmartFee() throws Exception {
        enqueueMockedResponse(200, "{\"result\":{ \"feerate\": 0.00021199, \"blocks\": 3 },\"error\":null,\"id\":null}");

        BtcRpcEstimateSmartFeeResponse btcRpcEstimateSmartFeeResponse = undertest.estimateSmartFee(3, EnumEstimateMode.CONSERVATIVE);
        Assert.assertEquals("Expected feerate", new BigDecimal("0.00021199"), btcRpcEstimateSmartFeeResponse.getFeerate());
    }

}
