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

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * The Class AbstractBtcRpcMethodsTest.
 *
 * @author jestevez
 */
public abstract class AbstractBtcRpcMethodsTest {

    /** The server. */
    protected static MockWebServer server;

    /** The btc rpc gateway. */
    protected static BtcRpcGateway btcRpcGateway;

    /**
     * Sets the up class.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @BeforeClass
    public static void setUpClass() throws IOException {
        server = new MockWebServer();
        // Start the server.
        server.start();

        HttpUrl httpUrl = server.url("/");
        btcRpcGateway = new BtcRpcGateway(httpUrl, "dummy", "dummy");

    }

    /**
     * Enqueue mocked response.
     *
     * @param code the code
     * @param body the body
     */
    protected static void enqueueMockedResponse(int code, String body) {
        MockResponse mockedResponse = new MockResponse();
        mockedResponse.setResponseCode(code);
        mockedResponse.setBody(body);
        server.enqueue(mockedResponse);
    }

    /**
     * Tear down class.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @AfterClass
    public static void tearDownClass() throws IOException {
        // Shut down the server. Instances cannot be reused.
        server.shutdown();
    }
}
