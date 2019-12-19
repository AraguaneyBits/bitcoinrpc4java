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

import java.net.Authenticator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.araguaneybits.commons.constants.CommonsConstants;

/**
 * The Class ProxyUtils.
 * 
 * @author jestevez
 */
public final class ProxyUtils {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(ProxyUtils.class);

    /**
     * Instantiates a new proxy utils.
     */
    private ProxyUtils() {
        super();
    }

    /**
     * Connect internet. https://docs.oracle.com/javase/6/docs/technotes/guides/net/proxies.html
     *
     * @param proxyConfiguration the proxy configuration
     */
    public static void connectInternet(ProxyConfiguration proxyConfiguration) {
        if (proxyConfiguration != null && proxyConfiguration.isEnabled()) {
            LOG.debug("proxy option enabled host {} port {}", proxyConfiguration.getUrl(), proxyConfiguration.getPort());
            Authenticator.setDefault(new ProxyAuthenticator(proxyConfiguration.getUser(), proxyConfiguration.getPassword()));
            System.setProperty(CommonsConstants.HTTPS_PROXY_PORT_PROPERTY, proxyConfiguration.getUrl());
            System.setProperty(CommonsConstants.HTTPS_PROXY_HOST_PROPERTY, proxyConfiguration.getPort());
            System.setProperty(CommonsConstants.HTTP_NON_PROXY_HOST, proxyConfiguration.getExclusion());
        }
    }

}
