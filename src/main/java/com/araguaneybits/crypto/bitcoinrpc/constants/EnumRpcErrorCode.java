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
 * The Enum EnumRpcErrorCode.
 *
 * @author jestevez
 */
public enum EnumRpcErrorCode {

    /** The rpc invalid request. */
    RPC_INVALID_REQUEST(-32600),

    /** The rpc method not found. */
    RPC_METHOD_NOT_FOUND(-32601),

    /** The rpc invalid params. */
    RPC_INVALID_PARAMS(-32602),

    /** The rpc internal error. */
    RPC_INTERNAL_ERROR(-32603),

    /** The rpc parse error. */
    RPC_PARSE_ERROR(-32700),

    /** The rpc misc error. */
    RPC_MISC_ERROR(-1),

    /** The rpc forbidden by safe mode. */
    RPC_FORBIDDEN_BY_SAFE_MODE(-2),

    /** The rpc type error. */
    RPC_TYPE_ERROR(-3),

    /** The rpc invalid address or key. */
    RPC_INVALID_ADDRESS_OR_KEY(-5),

    /** The rpc out of memory. */
    RPC_OUT_OF_MEMORY(-7),

    /** The rpc invalid parameter. */
    RPC_INVALID_PARAMETER(-8),

    /** The rpc database error. */
    RPC_DATABASE_ERROR(-20),

    /** The rpc deserialization error. */
    RPC_DESERIALIZATION_ERROR(-22),

    /** The rpc verify error. */
    RPC_VERIFY_ERROR(-25),

    /** The rpc verify rejected. */
    RPC_VERIFY_REJECTED(-26),

    /** The rpc verify already in chain. */
    RPC_VERIFY_ALREADY_IN_CHAIN(-27),

    /** The rpc in warmup. */
    RPC_IN_WARMUP(-28),

    /** The rpc client not connected. */
    RPC_CLIENT_NOT_CONNECTED(-9),

    /** The rpc client in initial download. */
    RPC_CLIENT_IN_INITIAL_DOWNLOAD(-10),

    /** The rpc client node already added. */
    RPC_CLIENT_NODE_ALREADY_ADDED(-23),

    /** The rpc client node not added. */
    RPC_CLIENT_NODE_NOT_ADDED(-24),

    /** The rpc client node not connected. */
    RPC_CLIENT_NODE_NOT_CONNECTED(-29),

    /** The rpc client invalid ip or subnet. */
    RPC_CLIENT_INVALID_IP_OR_SUBNET(-30),

    /** The rpc wallet error. */
    RPC_WALLET_ERROR(-4),

    /** The rpc wallet insufficient funds. */
    RPC_WALLET_INSUFFICIENT_FUNDS(-6),

    /** The rpc wallet invalid account name. */
    RPC_WALLET_INVALID_ACCOUNT_NAME(-11),

    /** The rpc wallet keypool ran out. */
    RPC_WALLET_KEYPOOL_RAN_OUT(-12),

    /** The rpc wallet unlock needed. */
    RPC_WALLET_UNLOCK_NEEDED(-13),

    /** The rpc wallet passphrase incorrect. */
    RPC_WALLET_PASSPHRASE_INCORRECT(-14),

    /** The rpc wallet wrong enc state. */
    RPC_WALLET_WRONG_ENC_STATE(-15),

    /** The rpc wallet encryption failed. */
    RPC_WALLET_ENCRYPTION_FAILED(-16),

    /** The rpc wallet already unlocked. */
    RPC_WALLET_ALREADY_UNLOCKED(-17);

    /** The code. */
    private final int code;

    /**
     * Instantiates a new enum rpc error code.
     *
     * @param code the code
     */
    EnumRpcErrorCode(Integer code) {
        this.code = code;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }
}
