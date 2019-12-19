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
import java.util.Map;

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
