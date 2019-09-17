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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

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

    /**
     * Test get client ip.
     */
    @Test
    public void testGetClientIp() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRemoteAddr()).thenReturn("1.1.1.1");
        String ip = HttpUtils.getClientIp(request);
        Assert.assertEquals("Is not equal", "1.1.1.1", ip);
        when(request.getHeader("X-FORWARDED-FOR")).thenReturn("0.0.0.0");
        String ip2 = HttpUtils.getClientIp(request);
        Assert.assertEquals("Is not equal", "0.0.0.0", ip2);
    }

    /**
     * Test request headers in map.
     */
    @Test
    public void testRequestHeadersInMap() {
        // define the headers you want to be returned
        Map<String, String> headers = new HashMap<>();
        headers.put("Http", "HTTP/1.1 200 OK");
        headers.put("Content-Type", "text/html");

        // create an Enumeration over the header keys
        Iterator<String> iterator = headers.keySet().iterator();
        Enumeration<String> headerNames = new Enumeration<String>() {
            @Override
            public boolean hasMoreElements() {
                return iterator.hasNext();
            }

            @Override
            public String nextElement() {
                return iterator.next();
            }
        };

        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeaderNames()).thenReturn(headerNames);

        System.out.println("demonstrate output of request.getHeaderNames()");
        while (headerNames.hasMoreElements()) {
            System.out.println("header name: " + headerNames.nextElement());
        }

        // mock the returned value of request.getHeader(String name)
        doAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                return headers.get((String) args[0]);
            }
        }).when(request).getHeader("Content-Type");

        System.out.println("demonstrate output of request.getHeader(String name)");
        String headerName = "Content-Type";
        System.out.printf("header name: [%s]   value: [%s]%n", headerName, request.getHeader(headerName));

        when(request.getHeader("Content-Type")).thenReturn("HTTP/1.1 200 OK");

        Map<String, String> maps = HttpUtils.getRequestHeadersInMap(request);
        Assert.assertNotNull("Is not null", maps);

        for (Map.Entry<String, String> entry : maps.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key " + key + " value " + value);
        }

    }

}
