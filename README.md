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
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

It has following dependencies:

- `OKHttp <https://github.com/square/okhttp/>`_ for HTTP connections
- `Jackson Core <https://github.com/FasterXML/jackson-core>`_ for fast JSON serialisation/deserialisation
