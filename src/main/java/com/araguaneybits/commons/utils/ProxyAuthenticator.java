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
import java.net.PasswordAuthentication;

/**
 * The Class ProxyAuthenticator.
 * 
 * @author jestevez
 */
public class ProxyAuthenticator extends Authenticator {

    /** The user. */
    private final String user;

    /** The password. */
    private final String password;

    /**
     * Instantiates a new proxy authenticator.
     *
     * @param user the user
     * @param password the password
     */
    public ProxyAuthenticator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.net.Authenticator#getPasswordAuthentication()
     */
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password.toCharArray());
    }

}
