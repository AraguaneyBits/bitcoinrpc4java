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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.araguaneybits.crypto.bitcoinrpc.RpcOutputMessage;
import com.araguaneybits.crypto.bitcoinrpc.constants.EnumAddNodeType;
import com.araguaneybits.crypto.bitcoinrpc.constants.RpcNetworkMethodsConstants;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetAddedNodeInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetNetTotalsResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetNodeAddressesResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetPeerInfoResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcListBannedResponse;
import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcNetworkInfoResponse;
import com.araguaneybits.crypto.utils.TransformBeanUtils;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * The Class BtcRpcNetworkMethods.
 * 
 * @author jestevez
 */
public class BtcRpcNetworkMethods extends BaseBtcRpcMethods {

    /**
     * Instantiates a new btc rpc network methods.
     *
     * @param btcRpcGateway the btc rpc gateway
     */
    public BtcRpcNetworkMethods(BtcRpcGateway btcRpcGateway) {
        super(btcRpcGateway);
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: 0.8.0
     * </p>
     * <p>
     * The addnode RPC attempts to add or remove a node from the addnode list, or to try a connection to a node once.
     * </p>
     * 
     * <pre>
     *     addnode "node" "add|remove|onetry"
     *     
     *     Attempts to add or remove a node from the addnode list.
     *     Or try a connection to a node once.
     *     Nodes added using addnode (or -connect) are protected from DoS disconnection and are not required to be
     *     full nodes/support SegWit as other outbound peers are (though such peers will not be synced from).
     *     
     *     Arguments:
     *     1. "node"     (string, required) The node (see getpeerinfo for nodes)
     *     2. "command"  (string, required) 'add' to add a node to the list, 'remove' to remove a node from the list, 'onetry' to try a connection to the node once
     *     
     *     Examples:
*       bitcoin-cli addnode "192.168.0.6:8333" "onetry"
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "addnode", "params": ["192.168.0.6:8333", "onetry"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param node the node
     * @param enumAddNodeType the enum add node type
     * @return the boolean
     */
    public Boolean addNode(String node, EnumAddNodeType enumAddNodeType) {
        callRpcMethod(RpcNetworkMethodsConstants.NETWORK_ADD_NODE, node, enumAddNodeType.getValue());
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: 0.12.0
     * </p>
     * <p>
     * The clearbanned RPC clears list of banned nodes.
     * </p>
     * 
     * <pre>
     *     clearbanned
     *     
     *     Clear all banned IPs.
     *     
     *     Examples:
*       bitcoin-cli clearbanned 
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "clearbanned", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the boolean
     */
    public Boolean clearBanned() {
        callRpcMethod(RpcNetworkMethodsConstants.NETWORK_CLEAR_BANNED);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: 0.12.0
     * </p>
     * <p>
     * The disconnectnode RPC immediately disconnects from a specified node.
     * </p>
     * 
     * <pre>
     *     disconnectnode "[address]" [nodeid]
     *     
     *     Immediately disconnects from the specified peer node.
     *     
     *     Strictly one out of 'address' and 'nodeid' can be provided to identify the node.
     *     
     *     To disconnect by nodeid, either set 'address' to the empty string, or call using the named 'nodeid' argument only.
     *     
     *     Arguments:
     *     1. "address"     (string, optional) The IP address/port of the node
     *     2. "nodeid"      (number, optional) The node ID (see getpeerinfo for node IDs)
     *     
     *     Examples:
*       bitcoin-cli disconnectnode "192.168.0.6:8333"
*       bitcoin-cli disconnectnode "" 1
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "disconnectnode", "params": ["192.168.0.6:8333"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "disconnectnode", "params": ["", 1] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param address the address
     * @return the boolean
     */
    public Boolean disconnectNode(String address) {
        callRpcMethod(RpcNetworkMethodsConstants.NETWORK_DISCONNECT_NODE, address);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: 0.8.0
     * </p>
     * <p>
     * The getaddednodeinfo RPC returns information about the given added node, or all added nodes (except onetry nodes). Only nodes which have been
     * manually added using the `addnode` RPC will have their information displayed.
     * </p>
     * 
     * <pre>
     *     getaddednodeinfo ( "node" )
     *     
     *     Returns information about the given added node, or all added nodes
     *     (note that onetry addnodes are not listed here)
     *     
     *     Arguments:
     *     1. "node"   (string, optional) If provided, return information about this specific node, otherwise all nodes are returned.
     *     
     *     Result:
     *     [
     *     {
     *     "addednode" : "192.168.0.201",   (string) The node IP address or name (as provided to addnode)
     *     "connected" : true|false,          (boolean) If connected
     *     "addresses" : [                    (list of objects) Only when connected = true
     *        {
     *          "address" : "192.168.0.201:8333",  (string) The bitcoin server IP and port we're connected to
     *          "connected" : "outbound"           (string) connection, inbound or outbound
     *        }
     *      ]
     *     }
     *     ,...
     *     ]
     *     
     *     Examples:
*       bitcoin-cli getaddednodeinfo "192.168.0.201"
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getaddednodeinfo", "params": ["192.168.0.201"] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the added node info
     */
    public List<BtcRpcGetAddedNodeInfoResponse> getAddedNodeInfo() {
        String json = callSimpleRpcMethod(RpcNetworkMethodsConstants.NETWORK_GET_ADDED_NODE_INFO);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<ArrayList<BtcRpcGetAddedNodeInfoResponse>>>() {
                });
        return (ArrayList<BtcRpcGetAddedNodeInfoResponse>) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: < 0.10.0
     * </p>
     * <p>
     * The getconnectioncount RPC returns the number of connections to other nodes.
     * </p>
     * 
     * <pre>
     *     getconnectioncount
     *     
     *     Returns the number of connections to other nodes.
     *     
     *     Result:
     *     n          (numeric) The connection count
     *     
     *     Examples:
*       bitcoin-cli getconnectioncount 
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getconnectioncount", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the connection count
     */
    public BigInteger getConnectionCount() {
        return (BigInteger) callRpcMethod(RpcNetworkMethodsConstants.NETWORK_GET_CONNECTION_COUNT);
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: < 0.12.0
     * </p>
     * <p>
     * The getnettotals RPC returns information about network traffic, including bytes in, bytes out, and the current time.
     * </p>
     * 
     * <pre>
     *     getnettotals
     *     
     *     Returns information about network traffic, including bytes in, bytes out,
     *     and current time.
     *     
     *     Result:
     *     {
     *     "totalbytesrecv": n,   (numeric) Total bytes received
     *     "totalbytessent": n,   (numeric) Total bytes sent
     *     "timemillis": t,       (numeric) Current UNIX time in milliseconds
     *     "uploadtarget":
     *     {
     *     "timeframe": n,                         (numeric) Length of the measuring timeframe in seconds
     *     "target": n,                            (numeric) Target in bytes
     *     "target_reached": true|false,           (boolean) True if target is reached
     *     "serve_historical_blocks": true|false,  (boolean) True if serving historical blocks
     *     "bytes_left_in_cycle": t,               (numeric) Bytes left in current time cycle
     *     "time_left_in_cycle": t                 (numeric) Seconds left in current time cycle
     *     }
     *     }
     *     
     *     Examples:
*       bitcoin-cli getnettotals 
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getnettotals", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the net totals
     */
    public BtcRpcGetNetTotalsResponse getNetTotals() {
        String json = callSimpleRpcMethod(RpcNetworkMethodsConstants.NETWORK_GET_NET_TOTALS);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcGetNetTotalsResponse>>() {
                });
        return (BtcRpcGetNetTotalsResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: 0.9.2.1
     * </p>
     * <p>
     * The getnetworkinfo RPC returns information about the node's connection to the network.
     * </p>
     * 
     * <pre>
     *     getnetworkinfo
     *     Returns an object containing various state info regarding P2P networking.
     *     
     *     Result:
     *     {
     *     "version": xxxxx,                      (numeric) the server version
     *     "subversion": "/Satoshi:x.x.x/",     (string) the server subversion string
     *     "protocolversion": xxxxx,              (numeric) the protocol version
     *     "localservices": "xxxxxxxxxxxxxxxx", (string) the services we offer to the network
     *     "localrelay": true|false,              (bool) true if transaction relay is requested from peers
     *     "timeoffset": xxxxx,                   (numeric) the time offset
     *     "connections": xxxxx,                  (numeric) the number of connections
     *     "networkactive": true|false,           (bool) whether p2p networking is enabled
     *     "networks": [                          (array) information per network
     *     {
     *     "name": "xxx",                     (string) network (ipv4, ipv6 or onion)
     *     "limited": true|false,               (boolean) is the network limited using -onlynet?
     *     "reachable": true|false,             (boolean) is the network reachable?
     *     "proxy": "host:port"               (string) the proxy that is used for this network, or empty if none
     *     "proxy_randomize_credentials": true|false,  (string) Whether randomized credentials are used
     *     }
     *     ,...
     *     ],
     *     "relayfee": x.xxxxxxxx,                (numeric) minimum relay fee for transactions in BTC/kB
     *     "incrementalfee": x.xxxxxxxx,          (numeric) minimum fee increment for mempool limiting or BIP 125 replacement in BTC/kB
     *     "localaddresses": [                    (array) list of local addresses
     *     {
     *     "address": "xxxx",                 (string) network address
     *     "port": xxx,                         (numeric) network port
     *     "score": xxx                         (numeric) relative score
     *     }
     *     ,...
     *     ]
     *     "warnings": "..."                    (string) any network and blockchain warnings
     *     }
     *     
     *     Examples:
*       bitcoin-cli getnetworkinfo 
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getnetworkinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the network info
     */
    public BtcRpcNetworkInfoResponse getNetworkInfo() {
        String json = callSimpleRpcMethod(RpcNetworkMethodsConstants.NETWORK_GET_NETWORK_INFO);

        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<BtcRpcNetworkInfoResponse>>() {
                });

        return (BtcRpcNetworkInfoResponse) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: 0.18.0
     * </p>
     * <p>
     * The getnodeaddresses RPC returns peer addresses known to this node. It may be used to find nodes to connect to without using a DNS seeder.
     * </p>
     * 
     * <pre>
     *     getnodeaddresses ( count )
     *     
     *     Return known addresses which can potentially be used to find new nodes in the network
     *     
     *     Arguments:
     *     1. count    (numeric, optional, default=1) How many addresses to return. Limited to the smaller of 2500 or 23% of all known addresses.
     *     
     *     Result:
     *     [
     *     {
     *     "time": ttt,                (numeric) Timestamp in seconds since epoch (Jan 1 1970 GMT) keeping track of when the node was last seen
     *     "services": n,              (numeric) The services offered
     *     "address": "host",          (string) The address of the node
     *     "port": n                   (numeric) The port of the node
     *     }
     *     ,....
     *     ]
     *     
     *     Examples:
*       bitcoin-cli getnodeaddresses 8
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getnodeaddresses", "params": [8] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the node addresses
     */
    public List<BtcRpcGetNodeAddressesResponse> getNodeAddresses() {
        String json = callSimpleRpcMethod(RpcNetworkMethodsConstants.NETWORK_GET_NODE_ADDRESSES);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<ArrayList<BtcRpcGetNodeAddressesResponse>>>() {
                });
        return (ArrayList<BtcRpcGetNodeAddressesResponse>) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: 0.7.0
     * </p>
     * <p>
     * The getpeerinfo RPC returns data about each connected network node.
     * </p>
     * 
     * <pre>
     *     getpeerinfo
     *     
     *     Returns data about each connected network node as a json array of objects.
     *     
     *     Result:
     *     [
     *     {
     *     "id": n,                   (numeric) Peer index
     *     "addr":"host:port",      (string) The IP address and port of the peer
     *     "addrbind":"ip:port",    (string) Bind address of the connection to the peer
     *     "addrlocal":"ip:port",   (string) Local address as reported by the peer
     *     "services":"xxxxxxxxxxxxxxxx",   (string) The services offered
     *     "relaytxes":true|false,    (boolean) Whether peer has asked us to relay transactions to it
     *     "lastsend": ttt,           (numeric) The time in seconds since epoch (Jan 1 1970 GMT) of the last send
     *     "lastrecv": ttt,           (numeric) The time in seconds since epoch (Jan 1 1970 GMT) of the last receive
     *     "bytessent": n,            (numeric) The total bytes sent
     *     "bytesrecv": n,            (numeric) The total bytes received
     *     "conntime": ttt,           (numeric) The connection time in seconds since epoch (Jan 1 1970 GMT)
     *     "timeoffset": ttt,         (numeric) The time offset in seconds
     *     "pingtime": n,             (numeric) ping time (if available)
     *     "minping": n,              (numeric) minimum observed ping time (if any at all)
     *     "pingwait": n,             (numeric) ping wait (if non-zero)
     *     "version": v,              (numeric) The peer version, such as 70001
     *     "subver": "/Satoshi:0.8.5/",  (string) The string version
     *     "inbound": true|false,     (boolean) Inbound (true) or Outbound (false)
     *     "addnode": true|false,     (boolean) Whether connection was due to addnode/-connect or if it was an automatic/inbound connection
     *     "startingheight": n,       (numeric) The starting height (block) of the peer
     *     "banscore": n,             (numeric) The ban score
     *     "synced_headers": n,       (numeric) The last header we have in common with this peer
     *     "synced_blocks": n,        (numeric) The last block we have in common with this peer
     *     "inflight": [
     *        n,                        (numeric) The heights of blocks we're currently asking from this peer
     *        ...
     *     ],
     *     "whitelisted": true|false, (boolean) Whether the peer is whitelisted
     *     "minfeefilter": n,         (numeric) The minimum fee rate for transactions this peer accepts
     *     "bytessent_per_msg": {
     *        "msg": n,               (numeric) The total bytes sent aggregated by message type
     *                                When a message type is not listed in this json object, the bytes sent are 0.
     *                                Only known message types can appear as keys in the object.
     *        ...
     *     },
     *     "bytesrecv_per_msg": {
     *        "msg": n,               (numeric) The total bytes received aggregated by message type
     *                                When a message type is not listed in this json object, the bytes received are 0.
     *                                Only known message types can appear as keys in the object and all bytes received of unknown message types are listed under '*other*'.
     *        ...
     *     }
     *     }
     *     ,...
     *     ]
     *     
     *     Examples:
*       bitcoin-cli getpeerinfo 
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getpeerinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the peer info
     */
    public List<BtcRpcGetPeerInfoResponse> getPeerInfo() {
        String json = callSimpleRpcMethod(RpcNetworkMethodsConstants.NETWORK_GET_PEER_INFO);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<ArrayList<BtcRpcGetPeerInfoResponse>>>() {
                });
        return (ArrayList<BtcRpcGetPeerInfoResponse>) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: 0.12.0
     * </p>
     * <p>
     * The listbanned RPC lists all banned IPs/Subnets.
     * </p>
     * 
     * <pre>
     *     listbanned
     *     
     *     List all banned IPs/Subnets.
     *     
     *     Examples:
*       bitcoin-cli listbanned 
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listbanned", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the list
     */
    public List<BtcRpcListBannedResponse> listBanned() {
        String json = callSimpleRpcMethod(RpcNetworkMethodsConstants.NETWORK_LIST_BANNED);
        RpcOutputMessage rpcOutputMessage = (RpcOutputMessage) TransformBeanUtils.readValue(json,
                new TypeReference<RpcOutputMessage<ArrayList<BtcRpcListBannedResponse>>>() {
                });
        return (ArrayList<BtcRpcListBannedResponse>) rpcOutputMessage.getResult();
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: 0.9.0
     * </p>
     * <p>
     * The ping RPC sends a P2P ping message to all connected nodes to measure ping time. Results are provided by the `getpeerinfo` RPC pingtime and
     * pingwait fields as decimal seconds. The P2P `ping` message is handled in a queue with all other commands, so it measures processing backlog,
     * not just network ping.
     * </p>
     * 
     * <pre>
     *     ping
     *     
     *     Requests that a ping be sent to all other nodes, to measure ping time.
     *     Results provided in getpeerinfo, pingtime and pingwait fields are decimal seconds.
     *     Ping command is handled in queue with all other commands, so it measures processing backlog, not just network ping.
     *     
     *     Examples:
*       bitcoin-cli ping 
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "ping", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @return the boolean
     */
    public Boolean ping() {
        callRpcMethod(RpcNetworkMethodsConstants.NETWORK_PING);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: 0.12.0
     * </p>
     * <p>
     * The setban RPC attempts add or remove a IP/Subnet from the banned list.
     * </p>
     * 
     * <pre>
     *     setban "subnet" "add|remove" (bantime) (absolute)
     *     
     *     Attempts to add or remove an IP/Subnet from the banned list.
     *     
     *     Arguments:
     *     1. "subnet"       (string, required) The IP/Subnet (see getpeerinfo for nodes IP) with an optional netmask (default is /32 = single IP)
     *     2. "command"      (string, required) 'add' to add an IP/Subnet to the list, 'remove' to remove an IP/Subnet from the list
     *     3. "bantime"      (numeric, optional) time in seconds how long (or until when if [absolute] is set) the IP is banned (0 or empty means using the default time of 24h which can also be overwritten by the -bantime startup argument)
     *     4. "absolute"     (boolean, optional) If set, the bantime must be an absolute timestamp in seconds since epoch (Jan 1 1970 GMT)
     *     
     *     Examples:
*       bitcoin-cli setban "192.168.0.6" "add" 86400
*       bitcoin-cli setban "192.168.0.0/24" "add"
*       curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "setban", "params": ["192.168.0.6", "add", 86400] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
     * </pre>
     *
     * @param subnet the subnet
     * @param command the command
     * @param bantime the bantime
     * @param absolute the absolute
     * @return the boolean
     */
    public Boolean setBan(String subnet, String command, Long bantime, Boolean absolute) {
        callRpcMethod(RpcNetworkMethodsConstants.NETWORK_SETBAN, subnet, command, bantime, absolute);
        return Boolean.TRUE;
    }

    /**
     * <p>
     * Call category: network
     * </p>
     * <p>
     * Available since: 0.14.0
     * </p>
     * <p>
     * The setnetworkactive RPC disables/enables all P2P network activity.
     * </p>
     * 
     * <pre>
     *     setnetworkactive true|false
     *     
     *     Disable/enable all p2p network activity.
     *     
     *     Arguments:
     *     1. "state"        (boolean, required) true to enable networking, false to disable
     * </pre>
     *
     * @param state the state
     * @return the boolean
     */
    public Boolean setNetworkActive(Boolean state) {
        return (Boolean) callRpcMethod(RpcNetworkMethodsConstants.NETWORK_SET_NETWORK_ACTIVE, state);
    }

}
