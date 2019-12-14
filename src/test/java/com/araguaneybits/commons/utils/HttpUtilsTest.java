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

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * The Class HttpUtilsTest.
 *
 * @author jestevez
 */
public class HttpUtilsTest extends Mockito {

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
     * Test url encode UTF 8.
     */
    @Test
    public void testUrlEncodeUTF8() {
        Map<String, String> maps = new HashMap<>();
        maps.put("name", "Ñoño");
        maps.put("phone", "(123)-10020304");

        String queryString = HttpUtils.urlEncodeUTF8(maps);
        System.out.println(queryString);
        String expected = "phone=%28123%29-10020304&name=%C3%91o%C3%B1o";
        Assert.assertEquals("Is not equal", expected, queryString);

    }

}
