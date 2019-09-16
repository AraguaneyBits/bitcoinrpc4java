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
package com.araguaneybits.commons.http;

import java.io.IOException;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * The Class ApiHttpClientTest.
 *
 * @author jestevez
 */
public class ApiHttpClientTest extends Mockito {

    /** The server. */
    private static MockWebServer server;

    /**
     * Instantiates a new api http client test.
     */
    public ApiHttpClientTest() {
    }

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

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {

    }

    /**
     * Test post.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPost() throws Exception {

        MockResponse mockedResponse = new MockResponse();
        mockedResponse.setResponseCode(200);
        mockedResponse.setBody(
                "{\"access_token\":\"b8606c32-5df2-4d62-8c31-b98e7e7d5646\",\"token_type\":\"bearer\",\"refresh_token\":\"c0c38c00-cdf5-477c-8d3d-fec8616ad5ea\",\"expires_in\":43199,\"scope\":\" write read\"}");
        server.enqueue(mockedResponse);

        HttpUrl httpUrl = server.url("/oauth/token?grant_type=password");

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic aaa");
        headers.put("USER_IP", "0.0.0.0");

        ApiHttpClient apiHttpClient = new ApiHttpClient(httpUrl);
        ApiHttpResponse apiResponse = apiHttpClient.send(ApiHttpType.POST, headers, "username=predimania%40yopmail.com&password=12345678",
                ApiHttpMediaType.APPLICATION_FORM_URLENCODED);
        Assert.assertNotNull("Is not null", apiResponse);
        System.out.println(apiResponse);

    }

    /**
     * Test get.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGet() throws Exception {

        MockResponse mockedResponse = new MockResponse();
        mockedResponse.setResponseCode(200);
        mockedResponse.setBody("{}");
        server.enqueue(mockedResponse);

        HttpUrl httpUrl = server.url("/v1.0/customers/list");

        HashMap<String, String> headers = new HashMap<>();

        ApiHttpClient apiHttpClient = new ApiHttpClient(httpUrl);
        ApiHttpResponse apiResponse = apiHttpClient.send(ApiHttpType.GET, headers);

        Assert.assertNotNull("Is not null", apiResponse);
        System.out.println(apiResponse.getBody());

    }

    @Test
    public void testEnumHttpStatusCode() {
        for (EnumHttpStatusCode f : EnumHttpStatusCode.values()) {
            System.out.println(f);
        }
        Assert.assertNotNull("Is not null", EnumHttpStatusCode.HTTP_OK);
    }

}
