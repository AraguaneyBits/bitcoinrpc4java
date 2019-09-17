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

/**
 * The Class ProxyConfiguration.
 * 
 * @author jestevez
 */
public class ProxyConfiguration {

    /** The enabled. */
    private boolean enabled;

    /** The url. */
    private String url;

    /** The port. */
    private String port;

    /** The user. */
    private String user;

    /** The password. */
    private String password;

    /** The exclusion. */
    private String exclusion;

    /**
     * Instantiates a new proxy configuration.
     */
    public ProxyConfiguration() {
        super();
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     *
     * @param url the new url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the port.
     *
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * Sets the port.
     *
     * @param port the new port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the user.
     *
     * @param user the new user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the exclusion.
     *
     * @return the exclusion
     */
    public String getExclusion() {
        return exclusion;
    }

    /**
     * Sets the exclusion.
     *
     * @param exclusion the new exclusion
     */
    public void setExclusion(String exclusion) {
        this.exclusion = exclusion;
    }

    /**
     * Checks if is enabled.
     *
     * @return true, if is enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the enabled.
     *
     * @param enabled the new enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
