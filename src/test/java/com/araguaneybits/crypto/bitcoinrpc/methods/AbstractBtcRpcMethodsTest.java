package com.araguaneybits.crypto.bitcoinrpc.methods;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public abstract class AbstractBtcRpcMethodsTest {

    protected static MockWebServer server;
    protected static BtcRpcGateway btcRpcGateway;

    @BeforeClass
    public static void setUpClass() throws IOException {
        server = new MockWebServer();
        // Start the server.
        server.start();

        HttpUrl httpUrl = server.url("/");
        btcRpcGateway = new BtcRpcGateway(httpUrl, "dummy", "dummy");

    }

    protected static void enqueueMockedResponse(int code, String body) {
        MockResponse mockedResponse = new MockResponse();
        mockedResponse.setResponseCode(code);
        mockedResponse.setBody(body);
        server.enqueue(mockedResponse);
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
        // Shut down the server. Instances cannot be reused.
        server.shutdown();
    }
}
