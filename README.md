<img src="resources/bitcoinrpc4java.png" alt="bitcoinrpc4java text" width="400" />

# bitcoinrpc4java

java client to connect to the bitcoin core with jsonrpc


It is a library that seeks to be a well-typed rpc client with full implementation. This is a basic example of its use:

```java
    public static void main(String[] args) {
        // initialize the gateway
        String rpcUser = "myuser";
        String rpcPassword = "mypass";
        String rpcHost = "localhost";
        String rpcPort = "8332";
        BtcRpcGateway btcRpcGateway = new BtcRpcGateway(rpcUser, rpcPassword, rpcHost, rpcPort);
        // wallet methods
        BtcRpcWalletMethods btcRpcWalletMethods = new BtcRpcWalletMethods(btcRpcGateway);
        BigDecimal balance = btcRpcWalletMethods.getBalance();
        System.out.println("The balance is " + balance);
    }
```


It has following dependencies:

- `OKHttp <https://github.com/square/okhttp/>`_ for HTTP connections
- `Jackson Core <https://github.com/FasterXML/jackson-core>`_ for fast JSON serialisation/deserialisation
