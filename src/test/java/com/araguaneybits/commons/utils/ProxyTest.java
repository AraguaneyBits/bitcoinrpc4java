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
package com.araguaneybits.commons.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class ProxyTest.
 *
 * @author jestevez
 */
public class ProxyTest {

    /**
     * Sets the up class.
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     * Tear down class.
     */
    @AfterClass
    public static void tearDownClass() {
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
     * Test proxy.
     *
     * @throws MalformedURLException the malformed URL exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testProxy() throws MalformedURLException, IOException {
        ProxyConfiguration proxyConfiguration = new ProxyConfiguration();
        proxyConfiguration.setEnabled(true);
        proxyConfiguration.setExclusion("");
        proxyConfiguration.setPassword("");
        proxyConfiguration.setPort("");
        proxyConfiguration.setUrl("");
        proxyConfiguration.setUser("");

        ProxyUtils.connectInternet(proxyConfiguration);
        HttpURLConnection connection = (HttpURLConnection) new URL("https://stackoverflow.com").openConnection();
        connection.setDoOutput(true);
        Assert.assertEquals("Expected response 200", 200, connection.getResponseCode());
        System.out.println(connection.getResponseCode());
    }
}
