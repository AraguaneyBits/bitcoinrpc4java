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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.araguaneybits.commons.constants.CommonsConstants;

import okhttp3.Credentials;

/**
 * The Class HttpUtils.
 *
 * @author jestevez
 */
public final class HttpUtils {

    /**
     * Instantiates a new http utils.
     */
    private HttpUtils() {
        super();
    }

    /**
     * Url encode UTF 8.
     *
     * @param s the s
     * @return the string
     */
    public static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    /**
     * Url encode UTF 8.
     *
     * @param map the map
     * @return the string
     */
    public static String urlEncodeUTF8(Map<?, ?> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s", urlEncodeUTF8(entry.getKey().toString()), urlEncodeUTF8(entry.getValue().toString())));
        }
        return sb.toString();
    }

    /**
     * Gets the request headers in map.
     *
     * @param request the request
     * @return the request headers in map
     */
    public static Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {

        Map<String, String> result = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            result.put(key, value);
        }

        return result;
    }

    /**
     * Gets the client ip.
     *
     * @param request the request
     * @return the client ip
     */
    public static String getClientIp(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        String remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if (remoteAddr == null || CommonsConstants.EMPTY_STRING.equals(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }

        return remoteAddr;
    }

    /**
     * To basic authorization.
     *
     * @param user the user
     * @param password the password
     * @return the string
     */
    public static String toBasicAuthorization(String user, String password) {
        return Credentials.basic(user, password);
    }
}
