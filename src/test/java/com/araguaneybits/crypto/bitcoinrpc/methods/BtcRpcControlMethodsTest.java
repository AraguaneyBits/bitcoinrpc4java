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

import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetMemoryInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetRpcInfoActiveCommandResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetRpcInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcLoggingResponse;

/**
 * The Class BtcRpcControlMethodsTest.
 *
 * @author jestevez
 */
public class BtcRpcControlMethodsTest extends AbstractBtcRpcMethodsTest {

    /** The undertest. */
    private BtcRpcControlMethods undertest;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        undertest = new BtcRpcControlMethods(btcRpcGateway);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {

    }

    /**
     * Test getmemoryinfo.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetMemoryInfo() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"locked\":{\"used\":80,\"free\":65456,\"total\":65536,\"locked\":65536,\"chunks_used\":1,\"chunks_free\":1}},\"error\":null,\"id\":null}");
        BtcRpcGetMemoryInfoResponse btcRpcGetMemoryInfoResponse = undertest.getMemoryInfo();
        Assert.assertNotNull("Is not null", btcRpcGetMemoryInfoResponse);
        Assert.assertNotNull("Is not null", btcRpcGetMemoryInfoResponse.getLocked());
        Assert.assertEquals("Expected equals", new BigInteger("65456"), btcRpcGetMemoryInfoResponse.getLocked().getFree());
    }

    /**
     * Test getrpcinfo.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetRpcInfo() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"active_commands\":[{\"method\":\"getrpcinfo\",\"duration\":30}],\"logpath\":\"/home/pi/.bitcoin/testnet3/debug.log\"},\"error\":null,\"id\":null}");
        BtcRpcGetRpcInfoResponse BtcRpcGetRpcInfoResponse = undertest.getRpcInfo();
        Assert.assertNotNull("Is not null", BtcRpcGetRpcInfoResponse);
        List<BtcRpcGetRpcInfoActiveCommandResponse> list = BtcRpcGetRpcInfoResponse.getActiveCommands();
        BtcRpcGetRpcInfoActiveCommandResponse btcRpcGetRpcInfoActiveCommandResponse = list.get(0);

        Assert.assertEquals("Expected equals", "getrpcinfo", btcRpcGetRpcInfoActiveCommandResponse.getMethod());
    }

    /**
     * Test help.
     *
     * @throws Exception the exception
     */
    @Test
    public void testHelp() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":\"== Blockchain ==\\ngetbestblockhash\\ngetblock \\\"blockhash\\\" ( verbosity )\\ngetblockchaininfo\\ngetblockcount\\ngetblockfilter \\\"blockhash\\\" ( \\\"filtertype\\\" )\\ngetblockhash height\\ngetblockheader \\\"blockhash\\\" ( verbose )\\ngetblockstats hash_or_height ( stats )\\ngetchaintips\\ngetchaintxstats ( nblocks \\\"blockhash\\\" )\\ngetdifficulty\\ngetmempoolancestors \\\"txid\\\" ( verbose )\\ngetmempooldescendants \\\"txid\\\" ( verbose )\\ngetmempoolentry \\\"txid\\\"\\ngetmempoolinfo\\ngetrawmempool ( verbose )\\ngettxout \\\"txid\\\" n ( include_mempool )\\ngettxoutproof [\\\"txid\\\",...] ( \\\"blockhash\\\" )\\ngettxoutsetinfo\\npreciousblock \\\"blockhash\\\"\\npruneblockchain height\\nsavemempool\\nscantxoutset \\\"action\\\" [scanobjects,...]\\nverifychain ( checklevel nblocks )\\nverifytxoutproof \\\"proof\\\"\\n\\n== Control ==\\ngetmemoryinfo ( \\\"mode\\\" )\\ngetrpcinfo\\nhelp ( \\\"command\\\" )\\nlogging ( [\\\"include_category\\\",...] [\\\"exclude_category\\\",...] )\\nstop\\nuptime\\n\\n== Generating ==\\ngeneratetoaddress nblocks \\\"address\\\" ( maxtries )\\n\\n== Mining ==\\ngetblocktemplate ( \\\"template_request\\\" )\\ngetmininginfo\\ngetnetworkhashps ( nblocks height )\\nprioritisetransaction \\\"txid\\\" ( dummy ) fee_delta\\nsubmitblock \\\"hexdata\\\" ( \\\"dummy\\\" )\\nsubmitheader \\\"hexdata\\\"\\n\\n== Network ==\\naddnode \\\"node\\\" \\\"command\\\"\\nclearbanned\\ndisconnectnode ( \\\"address\\\" nodeid )\\ngetaddednodeinfo ( \\\"node\\\" )\\ngetconnectioncount\\ngetnettotals\\ngetnetworkinfo\\ngetnodeaddresses ( count )\\ngetpeerinfo\\nlistbanned\\nping\\nsetban \\\"subnet\\\" \\\"command\\\" ( bantime absolute )\\nsetnetworkactive state\\n\\n== Rawtransactions ==\\nanalyzepsbt \\\"psbt\\\"\\ncombinepsbt [\\\"psbt\\\",...]\\ncombinerawtransaction [\\\"hexstring\\\",...]\\nconverttopsbt \\\"hexstring\\\" ( permitsigdata iswitness )\\ncreatepsbt [{\\\"txid\\\":\\\"hex\\\",\\\"vout\\\":n,\\\"sequence\\\":n},...] [{\\\"address\\\":amount},{\\\"data\\\":\\\"hex\\\"},...] ( locktime replaceable )\\ncreaterawtransaction [{\\\"txid\\\":\\\"hex\\\",\\\"vout\\\":n,\\\"sequence\\\":n},...] [{\\\"address\\\":amount},{\\\"data\\\":\\\"hex\\\"},...] ( locktime replaceable )\\ndecodepsbt \\\"psbt\\\"\\ndecoderawtransaction \\\"hexstring\\\" ( iswitness )\\ndecodescript \\\"hexstring\\\"\\nfinalizepsbt \\\"psbt\\\" ( extract )\\nfundrawtransaction \\\"hexstring\\\" ( options iswitness )\\ngetrawtransaction \\\"txid\\\" ( verbose \\\"blockhash\\\" )\\njoinpsbts [\\\"psbt\\\",...]\\nsendrawtransaction \\\"hexstring\\\" ( maxfeerate )\\nsignrawtransactionwithkey \\\"hexstring\\\" [\\\"privatekey\\\",...] ( [{\\\"txid\\\":\\\"hex\\\",\\\"vout\\\":n,\\\"scriptPubKey\\\":\\\"hex\\\",\\\"redeemScript\\\":\\\"hex\\\",\\\"witnessScript\\\":\\\"hex\\\",\\\"amount\\\":amount},...] \\\"sighashtype\\\" )\\ntestmempoolaccept [\\\"rawtx\\\",...] ( maxfeerate )\\nutxoupdatepsbt \\\"psbt\\\" ( [\\\"\\\",{\\\"desc\\\":\\\"str\\\",\\\"range\\\":n or [n,n]},...] )\\n\\n== Util ==\\ncreatemultisig nrequired [\\\"key\\\",...] ( \\\"address_type\\\" )\\nderiveaddresses \\\"descriptor\\\" ( range )\\nestimatesmartfee conf_target ( \\\"estimate_mode\\\" )\\ngetdescriptorinfo \\\"descriptor\\\"\\nsignmessagewithprivkey \\\"privkey\\\" \\\"message\\\"\\nvalidateaddress \\\"address\\\"\\nverifymessage \\\"address\\\" \\\"signature\\\" \\\"message\\\"\\n\\n== Wallet ==\\nabandontransaction \\\"txid\\\"\\nabortrescan\\naddmultisigaddress nrequired [\\\"key\\\",...] ( \\\"label\\\" \\\"address_type\\\" )\\nbackupwallet \\\"destination\\\"\\nbumpfee \\\"txid\\\" ( options )\\ncreatewallet \\\"wallet_name\\\" ( disable_private_keys blank \\\"passphrase\\\" avoid_reuse )\\ndumpprivkey \\\"address\\\"\\ndumpwallet \\\"filename\\\"\\nencryptwallet \\\"passphrase\\\"\\ngetaddressesbylabel \\\"label\\\"\\ngetaddressinfo \\\"address\\\"\\ngetbalance ( \\\"dummy\\\" minconf include_watchonly avoid_reuse )\\ngetbalances\\ngetnewaddress ( \\\"label\\\" \\\"address_type\\\" )\\ngetrawchangeaddress ( \\\"address_type\\\" )\\ngetreceivedbyaddress \\\"address\\\" ( minconf )\\ngetreceivedbylabel \\\"label\\\" ( minconf )\\ngettransaction \\\"txid\\\" ( include_watchonly verbose )\\ngetunconfirmedbalance\\ngetwalletinfo\\nimportaddress \\\"address\\\" ( \\\"label\\\" rescan p2sh )\\nimportmulti \\\"requests\\\" ( \\\"options\\\" )\\nimportprivkey \\\"privkey\\\" ( \\\"label\\\" rescan )\\nimportprunedfunds \\\"rawtransaction\\\" \\\"txoutproof\\\"\\nimportpubkey \\\"pubkey\\\" ( \\\"label\\\" rescan )\\nimportwallet \\\"filename\\\"\\nkeypoolrefill ( newsize )\\nlistaddressgroupings\\nlistlabels ( \\\"purpose\\\" )\\nlistlockunspent\\nlistreceivedbyaddress ( minconf include_empty include_watchonly \\\"address_filter\\\" )\\nlistreceivedbylabel ( minconf include_empty include_watchonly )\\nlistsinceblock ( \\\"blockhash\\\" target_confirmations include_watchonly include_removed )\\nlisttransactions ( \\\"label\\\" count skip include_watchonly )\\nlistunspent ( minconf maxconf [\\\"address\\\",...] include_unsafe query_options )\\nlistwalletdir\\nlistwallets\\nloadwallet \\\"filename\\\"\\nlockunspent unlock ( [{\\\"txid\\\":\\\"hex\\\",\\\"vout\\\":n},...] )\\nremoveprunedfunds \\\"txid\\\"\\nrescanblockchain ( start_height stop_height )\\nsendmany \\\"\\\" {\\\"address\\\":amount} ( minconf \\\"comment\\\" [\\\"address\\\",...] replaceable conf_target \\\"estimate_mode\\\" )\\nsendtoaddress \\\"address\\\" amount ( \\\"comment\\\" \\\"comment_to\\\" subtractfeefromamount replaceable conf_target \\\"estimate_mode\\\" avoid_reuse )\\nsethdseed ( newkeypool \\\"seed\\\" )\\nsetlabel \\\"address\\\" \\\"label\\\"\\nsettxfee amount\\nsetwalletflag \\\"flag\\\" ( value )\\nsignmessage \\\"address\\\" \\\"message\\\"\\nsignrawtransactionwithwallet \\\"hexstring\\\" ( [{\\\"txid\\\":\\\"hex\\\",\\\"vout\\\":n,\\\"scriptPubKey\\\":\\\"hex\\\",\\\"redeemScript\\\":\\\"hex\\\",\\\"witnessScript\\\":\\\"hex\\\",\\\"amount\\\":amount},...] \\\"sighashtype\\\" )\\nunloadwallet ( \\\"wallet_name\\\" )\\nwalletcreatefundedpsbt [{\\\"txid\\\":\\\"hex\\\",\\\"vout\\\":n,\\\"sequence\\\":n},...] [{\\\"address\\\":amount},{\\\"data\\\":\\\"hex\\\"},...] ( locktime options bip32derivs )\\nwalletlock\\nwalletpassphrase \\\"passphrase\\\" timeout\\nwalletpassphrasechange \\\"oldpassphrase\\\" \\\"newpassphrase\\\"\\nwalletprocesspsbt \\\"psbt\\\" ( sign \\\"sighashtype\\\" bip32derivs )\\n\\n== Zmq ==\\ngetzmqnotifications\",\"error\":null,\"id\":null}");
        String result = undertest.help();
        Assert.assertNotNull("Is not null", result);
    }

    /**
     * Test logging.
     *
     * @throws Exception the exception
     */
    @Test
    public void testLogging() throws Exception {
        enqueueMockedResponse(200,
                "{\"result\":{\"net\":false,\"tor\":false,\"mempool\":false,\"http\":false,\"bench\":false,\"zmq\":false,\"db\":false,\"rpc\":false,\"estimatefee\":false,\"addrman\":false,\"selectcoins\":false,\"reindex\":false,\"cmpctblock\":false,\"rand\":false,\"prune\":false,\"proxy\":false,\"mempoolrej\":false,\"libevent\":false,\"coindb\":false,\"qt\":false,\"leveldb\":false},\"error\":null,\"id\":null}");
        BtcRpcLoggingResponse btcRpcLoggingResponse = undertest.logging();
        Assert.assertFalse("Tor is disabled", btcRpcLoggingResponse.getTor());

    }

    /**
     * Test stop.
     *
     * @throws Exception the exception
     */
    @Test
    public void testStop() throws Exception {
        enqueueMockedResponse(200, "{\"result\":\"Bitcoin Core stopping\",\"error\":null,\"id\":null}");
        String result = undertest.stop();
        Assert.assertEquals("expected result", "Bitcoin Core stopping", result);

    }

    /**
     * Test uptime.
     *
     * @throws Exception the exception
     */
    @Test
    public void testUptime() throws Exception {
        enqueueMockedResponse(200, "{\"result\":97,\"error\":null,\"id\":null}");
        BigInteger uptime = undertest.uptime();
        Assert.assertEquals("expected equals", new BigInteger("97"), uptime);
    }

    /**
     * Test getzmqnotifications.
     *
     * @throws Exception the exception
     */
    // @Test
    public void testGetzMqNotifications() throws Exception {
        enqueueMockedResponse(200, "");
        undertest.getzmqnotifications();
        Assert.fail("Test method not implemented");
    }
}
