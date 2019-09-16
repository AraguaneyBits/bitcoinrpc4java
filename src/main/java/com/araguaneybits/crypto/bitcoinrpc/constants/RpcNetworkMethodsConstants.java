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
 * The Class RpcNetworkMethodsConstants.
 *
 * @author jestevez
 */
public final class RpcNetworkMethodsConstants {

    /** The Constant NETWORK_ADD_NODE. */
    public static final String NETWORK_ADD_NODE = "addnode";

    /** The Constant NETWORK_CLEAR_BANNED. */
    public static final String NETWORK_CLEAR_BANNED = "clearbanned";

    /** The Constant NETWORK_DISCONNECT_NODE. */
    public static final String NETWORK_DISCONNECT_NODE = "disconnectnode";

    /** The Constant NETWORK_GET_ADDED_NODE_INFO. */
    public static final String NETWORK_GET_ADDED_NODE_INFO = "getaddednodeinfo";

    /** The Constant NETWORK_GET_CONNECTION_COUNT. */
    public static final String NETWORK_GET_CONNECTION_COUNT = "getconnectioncount";

    /** The Constant NETWORK_GET_NET_TOTALS. */
    public static final String NETWORK_GET_NET_TOTALS = "getnettotals";

    /** The Constant NETWORK_GET_NETWORK_INFO. */
    public static final String NETWORK_GET_NETWORK_INFO = "getnetworkinfo";

    /** The Constant NETWORK_GET_NODE_ADDRESSES. */
    public static final String NETWORK_GET_NODE_ADDRESSES = "getnodeaddresses";

    /** The Constant NETWORK_GET_PEER_INFO. */
    public static final String NETWORK_GET_PEER_INFO = "getpeerinfo";

    /** The Constant NETWORK_LIST_BANNED. */
    public static final String NETWORK_LIST_BANNED = "listbanned";

    /** The Constant NETWORK_PING. */
    public static final String NETWORK_PING = "ping";

    /** The Constant NETWORK_SETBAN. */
    public static final String NETWORK_SETBAN = "setban";

    /** The Constant NETWORK_SET_NETWORK_ACTIVE. */
    public static final String NETWORK_SET_NETWORK_ACTIVE = "setnetworkactive";

    /**
     * Instantiates a new rpc network methods constants.
     */
    private RpcNetworkMethodsConstants() {
        throw new AssertionError();
    }
}
