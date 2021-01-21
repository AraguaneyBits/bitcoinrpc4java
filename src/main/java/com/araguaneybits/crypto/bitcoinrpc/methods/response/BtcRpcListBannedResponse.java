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

package com.araguaneybits.crypto.bitcoinrpc.methods.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BtcRpcListBannedResponse.
 *
 * @author jestevez
 */
@Data
@NoArgsConstructor
public class BtcRpcListBannedResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9151454840625654184L;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The banned until. */
    @JsonProperty("banned_until")
    private Long bannedUntil;

    /** The ban created. */
    @JsonProperty("ban_created")
    private Long banCreated;

    /** The ban reason. */
    @JsonProperty("ban_reason")
    private String banReason;

}
