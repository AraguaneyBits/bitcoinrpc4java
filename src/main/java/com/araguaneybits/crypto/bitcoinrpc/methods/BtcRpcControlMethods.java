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
package com.araguaneybits.crypto.bitcoinrpc.methods;

import com.araguaneybits.crypto.bitcoinrpc.constants.RpcControlMethodsConstants;

/**
 * @author jestevez
 */
public class BtcRpcControlMethods extends BaseBtcRpcMethods {
    public BtcRpcControlMethods(BtcRpcGateway btcRpcGateway) {
        super(btcRpcGateway);
    }

    /**
     * <p>
     * Call category: control
     * </p>
     * <p>
     * Available since: 0.14.0
     * </p>
     * <p>
     * The getmemoryinfo RPC returns information about memory usage.
     * </p>
     * 
     * <pre>
    
    getmemoryinfo ("mode")
    Returns an object containing information about memory usage.
    Arguments:
    1. "mode" determines what kind of information is returned. This argument is optional, the default mode is "stats".
    - "stats" returns general statistics about memory usage in the daemon.
    - "mallocinfo" returns an XML string describing low-level heap state (only available if compiled with glibc 2.10+).
    
    Result (mode "stats"):
    {
    "locked": {               (json object) Information about locked memory manager
    "used": xxxxx,          (numeric) Number of bytes used
    "free": xxxxx,          (numeric) Number of bytes available in current arenas
    "total": xxxxxxx,       (numeric) Total number of bytes managed
    "locked": xxxxxx,       (numeric) Amount of bytes that succeeded locking. If this number is smaller than total, locking pages failed at some point and key data could be swapped to disk.
    "chunks_used": xxxxx,   (numeric) Number allocated chunks
    "chunks_free": xxxxx,   (numeric) Number unused chunks
    }
    }
    
    Result (mode "mallocinfo"):
    "..."
    
    Examples:
    > bitcoin-cli getmemoryinfo 
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getmemoryinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     */
    public Object getmemoryinfo() {
        // TODO Partially implemented method
        return callRpcMethod(RpcControlMethodsConstants.CONTROL_GET_MEMORY_INFO);
    }

    /**
     * <p>
     * Call category: control
     * </p>
     * <p>
     * Available since: 0.18.0
     * </p>
     * <p>
     * The getrpcinfo RPC returns runtime details of the RPC server. At the moment, it returns an array of the currently active commands and how long
     * they’ve been running.
     * </p>
     * 
     * <pre>
    getrpcinfo
    
    Returns details of the RPC server.
    
    Result:
    {
    "active_commands" (array) All active commands
    [
    {               (object) Information about an active command
    "method"       (string)  The name of the RPC command 
    "duration"     (numeric)  The running time in microseconds
    },...
    ]
    }
    
    Examples:
    > bitcoin-cli getrpcinfo 
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getrpcinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     */
    public Object getrpcinfo() {
        // TODO Partially implemented method
        return callRpcMethod(RpcControlMethodsConstants.CONTROL_GET_RPC_INFO);
    }

    /**
     * <p>
     * Call category: control
     * </p>
     * <p>
     * Available since: 0.1.0
     * </p>
     * <p>
     * The help RPC lists all available public RPC commands, or gets help for the specified RPC. Commands which are unavailable will not be listed,
     * such as wallet RPCs if wallet support is disabled.
     * </p>
     * 
     * <pre>
    help ( "command" )
    
    List all commands, or get help for a specified command.
    
    Arguments:
    1. "command"     (string, optional) The command to get help on
    
    Result:
    "text"     (string) The help text
     * </pre>
     */
    public Object help() {
        // TODO Partially implemented method
        return callRpcMethod(RpcControlMethodsConstants.CONTROL_HELP);
    }

    /**
     * <p>
     * Call category: control
     * </p>
     * <p>
     * Available since: 0.10.0
     * </p>
     * <p>
     * The logging RPC gets and sets the logging configuration.
     * </p>
     * 
     * <pre>
    logging (   )
    Gets and sets the logging configuration.
    When called without an argument, returns the list of categories with status that are currently being debug logged or not.
    When called with arguments, adds or removes categories from debug logging and return the lists above.
    The arguments are evaluated in order "include", "exclude".
    If an item is both included and excluded, it will thus end up being excluded.
    The valid logging categories are: net, tor, mempool, http, bench, zmq, db, rpc, estimatefee, addrman, selectcoins, reindex, cmpctblock, rand, prune, proxy, mempoolrej, libevent, coindb, qt, leveldb
    In addition, the following are available as category names with special meanings:
    - "all",  "1" : represent all logging categories.
    - "none", "0" : even if other logging categories are specified, ignore all of them.
    
    Arguments:
    1. "include"        (array of strings, optional) A json array of categories to add debug logging
     [
       "category"   (string) the valid logging category
       ,...
     ]
    2. "exclude"        (array of strings, optional) A json array of categories to remove debug logging
     [
       "category"   (string) the valid logging category
       ,...
     ]
    
    Result:
    {                   (json object where keys are the logging categories, and values indicates its status
    "category": 0|1,  (numeric) if being debug logged or not. 0:inactive, 1:active
    ...
    }
    
    Examples:
    > bitcoin-cli logging "[\"all\"]" "[\"http\"]"
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "logging", "params": [["all"], "[libevent]"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     */
    public Object logging() {
        // TODO Partially implemented method
        return callRpcMethod(RpcControlMethodsConstants.CONTROL_LOGGING);
    }

    /**
     * <p>
     * Call category: control
     * </p>
     * <p>
     * Available since: 0.1.0
     * </p>
     * <p>
     * The stop RPC safely shuts down the Bitcoin Core server.
     * </p>
     * 
     * <pre>
    stop
    
    Stop Bitcoin server.
     * </pre>
     */
    public Object stop() {
        // TODO Partially implemented method
        return callRpcMethod(RpcControlMethodsConstants.CONTROL_STOP);
    }

    /**
     * <p>
     * Call category: control
     * </p>
     * <p>
     * Available since: 0.15.0
     * </p>
     * <p>
     * The uptime RPC returns the total uptime of the server in seconds.
     * </p>
     * 
     * <pre>
    uptime
    
    Returns the total uptime of the server.
    
    Result:
    ttt        (numeric) The number of seconds that the server has been running
    
    Examples:
    > bitcoin-cli uptime 
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "uptime", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     */
    public Object uptime() {
        // TODO Partially implemented method
        return callRpcMethod(RpcControlMethodsConstants.CONTROL_UPTIME);
    }

    /**
     * <p>
     * Call category: zmq
     * </p>
     * <p>
     * Available since: 0.17.0
     * </p>
     * <p>
     * The getzmqnotifications RPC returns information about the active ZeroMQ notifications.
     * </p>
     * 
     * <pre>
    getzmqnotifications
    
    Returns information about the active ZeroMQ notifications.
    
    Result:
    [
    {                        (json object)
    "type": "pubhashtx",   (string) Type of notification
    "address": "..."       (string) Address of the publisher
    },
    ...
    ]
    
    Examples:
    > bitcoin-cli getzmqnotifications 
    > curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getzmqnotifications", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     */
    public Object getzmqnotifications() {
        // TODO Partially implemented method
        return callRpcMethod(RpcControlMethodsConstants.ZMQ_GET_ZMQ_NOTIFICATIONS);
    }

}
