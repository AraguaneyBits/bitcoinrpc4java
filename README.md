<img src="resources/bitcoinrpc4java.png" alt="bitcoinrpc4java text" width="800" />


bitcoinrpc4java is a java client to connect to the bitcoin core with jsonrpc


It is a library that seeks to be a well-typed rpc client with full implementation. This is a basic example of its use:

```java
    import java.math.BigDecimal;
    import com.araguaneybits.crypto.bitcoinrpc.constants.EnumEstimateMode;
    import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcGateway;
    import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletMethods;
    import com.araguaneybits.crypto.bitcoinrpc.methods.BtcRpcWalletToolsMethods;
    import com.araguaneybits.crypto.bitcoinrpc.methods.response.BtcRpcGetTransactionResponse;

    public static void main(String[] args) {
        // initialize the gateway
        String rpcUser = "myuser";
        String rpcPassword = "mypass";
        String rpcHost = "localhost";
        String rpcPort = "8332";
        String protocol = "https";
        String passphrase = "mywalletpass";
        
        // Initialize bitcoin rpc connections
        BtcRpcGateway btcRpcGateway = new BtcRpcGateway(rpcUser, rpcPassword, rpcHost, rpcPort, protocol);
        // Instance the Wallet Method
        BtcRpcWalletMethods btcRpcWalletMethods = new BtcRpcWalletMethods(btcRpcGateway);
        // Instance the Wallet Tools Method
        BtcRpcWalletToolsMethods btcRpcWalletToolsMethods = new BtcRpcWalletToolsMethods(btcRpcGateway);

        // Get balance
        BigDecimal balance = btcRpcWalletMethods.getBalance();
        System.out.println("The balance is " + balance);

        // Get new Address
        String toAddress = btcRpcWalletMethods.getNewAddress();
        System.out.println("New address is " + toAddress);

        // Unlocked the wallet
        Boolean unlocked = btcRpcWalletToolsMethods.walletPassphrase(passphrase, 30L);
        System.out.println("The wallet is unlocked " + unlocked);

        // Create new transaction
        BigDecimal amount = new BigDecimal("0.010");
        String comment = "";
        String commentTo = "";
        Boolean subtractFeeFromAmount = false;
        Boolean replaceable = true;
        Long confTarget = 1L;
        String txid = btcRpcWalletMethods.sendToAddress(toAddress, amount, comment, commentTo, subtractFeeFromAmount, replaceable, confTarget,
                EnumEstimateMode.CONSERVATIVE);
        System.out.println("New txid is " + txid);

        // Locked the wallet
        Boolean locked = btcRpcWalletToolsMethods.walletLock();
        System.out.println("The wallet is locked " + locked);

        // Get the generated transaction
        BtcRpcGetTransactionResponse btcRpcGetTransactionResponse = btcRpcWalletMethods.getTransaction(txid);
        System.out.println("BtcRpcGetTransactionResponse is " + btcRpcGetTransactionResponse);
    
    }
```

If your project uses Maven for its build, you can depend on bitcoinrpc4java by adding the following snippet to your pom.xml file in the:

```xml
<dependency>
  <groupId>com.araguaneybits.bitcoinrpc</groupId>
  <artifactId>araguaneybits-bitcoinrpc4java</artifactId>
  <version>1.0.0.RELEASE</version>
</dependency>
```

It has following dependencies:

- `OKHttp <https://github.com/square/okhttp/>`_ for HTTP connections
- `Jackson Core <https://github.com/FasterXML/jackson-core>`_ for fast JSON serialisation/deserialisation
- `Lombok <https://projectlombok.org/>`_ library that allows us to define POJO classes using a set of straightforward, but powerful annotations



#### Blockchain
Meethod                            | Supported                    |Version
-----------------------------------|------------------------------|----------------------
getbestblockhash                   | OK                           | 1.0.0
getblock                           | OK                           | 1.0.0
getblockchaininfo                  | OK                           | 1.0.0
getblockcount                      | OK                           | 1.0.0
getblockfilter                     | NO                           |
getblockhash                       | OK                           | 1.0.0
getblockheader                     | OK                           | 1.0.0
getblockstats                      | OK                           | 1.0.0
getchaintips                       | OK                           | 1.0.0
getchaintxstats                    | OK                           | 1.0.0
getdifficulty                      | OK                           | 1.0.0
getmempoolancestors                | OK                           | 1.0.0
getmempooldescendants              | OK                           | 1.0.0
getmempoolentry                    | OK                           | 1.0.0
getmempoolinfo                     | OK                           | 1.0.0
getrawmempool                      | OK                           | 1.0.0
gettxout                           | NO                           |
gettxoutproof                      | NO                           |
gettxoutsetinfo                    | NO                           |
preciousblock                      | NO                           |
pruneblockchain                    | NO                           |
savemempool                        | OK                           | 1.0.0
scantxoutset                       | NO                           |
verifychain                        | NO                           |
verifytxoutproof                   | NO                           |


#### Control
Meethod                            | Supported                    |Version
-----------------------------------|------------------------------|----------------------
getmemoryinfo                      | OK                           | 1.0.0
getrpcinfo                         | OK                           | 1.0.0
help                               | OK                           | 1.0.0
logging                            | OK                           | 1.0.0
stop                               | OK                           | 1.0.0
uptime                             | OK                           | 1.0.0


#### Generating
Meethod                            | Supported                    |Version
-----------------------------------|------------------------------|----------------------
generatetoaddress                  | NO                           |
generatetodescriptor               | NO                           |

#### Mining
Meethod                            | Supported                    |Version
-----------------------------------|------------------------------|----------------------
getblocktemplate                   | OK                           | 1.0.0
getmininginfo                      | OK                           | 1.0.0
getnetworkhashps                   | OK                           | 1.0.0
prioritisetransaction              | OK                           | 1.0.0
submitblock                        | NO                           |
submitheader                       | NO                           |

#### Network
Meethod                            | Supported                    |Version
-----------------------------------|------------------------------|----------------------
addnode                            | OK                           | 1.0.0
clearbanned                        | OK                           | 1.0.0
disconnectnode                     | OK                           | 1.0.0
getaddednodeinfo                   | OK                           | 1.0.0
getconnectioncount                 | OK                           | 1.0.0
getnettotals                       | OK                           | 1.0.0
getnetworkinfo                     | OK                           | 1.0.0
getnodeaddresses                   | OK                           | 1.0.0
getpeerinfo                        | OK                           | 1.0.0
listbanned                         | OK                           | 1.0.0
ping                               | OK                           | 1.0.0
setban                             | OK                           | 1.0.0
setnetworkactive                   | OK                           | 1.0.0

#### Rawtransactions
Meethod                            | Supported                    |Version
-----------------------------------|------------------------------|----------------------
analyzepsbt                        | OK                           | 1.0.0
combinepsbt                        | OK                           | 1.0.0
combinerawtransaction              | OK                           | 1.0.0
converttopsbt                      | OK                           | 1.0.0
createpsbt                         | OK                           | 1.0.0
createrawtransaction               | OK                           | 1.0.0
decodepsbt                         | OK                           | 1.0.0
decoderawtransaction               | OK                           | 1.0.0
decodescript                       | OK                           | 1.0.0
finalizepsbt                       | OK                           | 1.0.0
fundrawtransaction                 | OK                           | 1.0.0
getrawtransaction                  | OK                           | 1.0.0
joinpsbts                          | NO                           |
sendrawtransaction                 | OK                           | 1.0.0
signrawtransactionwithkey          | NO                           |
testmempoolaccept                  | NO                           |
utxoupdatepsbt                     | NO                           |

#### Util
Meethod                            | Supported                    |Version
-----------------------------------|------------------------------|----------------------
createmultisig                     | OK                           | 1.0.0
deriveaddresses                    | OK                           | 1.0.0
estimatesmartfee                   | NO                           |
getdescriptorinfo                  | OK                           | 1.0.0
signmessagewithprivkey             | OK                           | 1.0.0
validateaddress                    | OK                           | 1.0.0
verifymessage                      | OK                           | 1.0.0

#### Wallet
Meethod                            | Supported                    |Version
-----------------------------------|------------------------------|----------------------
abandontransaction                 | NO                           |
abortrescan                        | OK                           | 1.0.0
addmultisigaddress                 | OK                           | 1.0.0
backupwallet                       | OK                           | 1.0.0
bumpfee                            | OK                           | 1.0.0
createwallet                       | OK                           | 1.0.0
dumpprivkey                        | OK                           | 1.0.0
dumpwallet                         | OK                           | 1.0.0
encryptwallet                      | OK                           | 1.0.0
getaddressesbylabel                | OK                           | 1.0.0
getaddressinfo                     | OK                           | 1.0.0
getbalance                         | OK                           | 1.0.0
getbalances                        | OK                           | 1.0.0
getnewaddress                      | OK                           | 1.0.0
getrawchangeaddress                | OK                           | 1.0.0
getreceivedbyaddress               | OK                           | 1.0.0
getreceivedbylabel                 | OK                           | 1.0.0
gettransaction                     | OK                           | 1.0.0
getunconfirmedbalance              | OK                           | 1.0.0
getwalletinfo                      | OK                           | 1.0.0
importaddress                      | OK                           | 1.0.0
importmulti                        | NO                           |
importprivkey                      | OK                           | 1.0.0
importprunedfunds                  | NO                           |
importpubkey                       | NO                           |
importwallet                       | OK                           | 1.0.0
keypoolrefill                      | OK                           | 1.0.0
listaddressgroupings               | NO                           |
listlabels                         | OK                           | 1.0.0
listlockunspent                    | NO                           |
listreceivedbyaddress              | OK                           | 1.0.0
listreceivedbylabel                | OK                           | 1.0.0
listsinceblock                     | OK                           | 1.0.0
listtransactions                   | OK                           | 1.0.0
listunspent                        | OK                           | 1.0.0
listwalletdir                      | OK                           | 1.0.0
listwallets                        | OK                           | 1.0.0
loadwallet                         | OK                           | 1.0.0
lockunspent                        | OK                           | 1.0.0
removeprunedfunds                  | NO                           |
rescanblockchain                   | OK                           | 1.0.0
sendmany                           | OK                           | 1.0.0
sendtoaddress                      | OK                           | 1.0.0
sethdseed                          | NO                           |
setlabel                           | OK                           | 1.0.0
settxfee                           | OK                           | 1.0.0
setwalletflag                      | NO                           |
signmessage                        | OK                           | 1.0.0
signrawtransactionwithwallet       | NO                           |
unloadwallet                       | NO                           |
walletcreatefundedpsbt             | NO                           |
walletlock                         | OK                           | 1.0.0
walletpassphrase                   | OK                           | 1.0.0
walletpassphrasechange             | OK                           | 1.0.0
walletprocesspsbt                  | NO                           |

#### Zmq
Meethod                            | Supported                    |Version
-----------------------------------|------------------------------|----------------------
getzmqnotifications                | NO                           |
