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
package com.araguaneybits.crypto.bitcoinrpc.constants;

/**
 * The Class RpcControlMethodsConstants.
 *
 * @author jestevez
 */
public final class RpcControlMethodsConstants {

    /** The Constant CONTROL_GET_MEMORY_INFO. */
    public static final String CONTROL_GET_MEMORY_INFO = "getmemoryinfo";

    /** The Constant CONTROL_GET_RPC_INFO. */
    public static final String CONTROL_GET_RPC_INFO = "getrpcinfo";

    /** The Constant CONTROL_HELP. */
    public static final String CONTROL_HELP = "help";

    /** The Constant CONTROL_LOGGING. */
    public static final String CONTROL_LOGGING = "logging";

    /** The Constant CONTROL_STOP. */
    public static final String CONTROL_STOP = "stop";

    /** The Constant CONTROL_UPTIME. */
    public static final String CONTROL_UPTIME = "uptime";

    /** The Constant ZMQ_GET_ZMQ_NOTIFICATIONS. */
    public static final String ZMQ_GET_ZMQ_NOTIFICATIONS = "getzmqnotifications";

    /**
     * Instantiates a new rpc control methods constants.
     */
    private RpcControlMethodsConstants() {
        throw new AssertionError();
    }
}
