package jsonmain;

import org.hyperledger.fabric.gateway.*;
import org.hyperledger.fabric.gateway.impl.GatewayImpl;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class demo2 {
    private Gateway gateway;
    private Network network;
    private static final Path NETWORK_CONFIG_PATH = Paths.get( "src","jsonmain","connection.json");
    private static final Path credentialPath = Paths.get( "crypto-config",
            "peerOrganizations", "org1.example.com", "users", "User1@org1.example.com", "msp");

    public static void main( String[] args) {
        X509Certificate certificate = null;
        PrivateKey privateKey = null;
        Gateway gateway = null;
        byte[] result = null;
        try {
            //使用org1中的user1初始化一个网关wallet账户用于连接网络
            Wallet wallet = Wallets.newInMemoryWallet();
            Path certificatePath = credentialPath.resolve(Paths.get("signcerts", "User1@org1.example.com-cert.pem"));
            certificate = readX509Certificate(certificatePath);
            Path privateKeyPath = credentialPath.resolve(Paths.get("keystore", "priv_sk"));
            privateKey = getPrivateKey(privateKeyPath);
            wallet.put("user", Identities.newX509Identity("Org1MSP",certificate,privateKey));
            //根据connection-org1.json 获取Fabric网络连接对象
            GatewayImpl.Builder builder = (GatewayImpl.Builder) Gateway.createBuilder();
            builder.identity(wallet, "user").networkConfig(NETWORK_CONFIG_PATH);
            //连接网关
            gateway = builder.connect();
            //获取mychannel通道
            System.out.println("-------------------invoke sacc on mychannel----------------------");
            Network network = gateway.getNetwork("mychannel");
            Contract contract1 = network.getContract("sacc");
            result = contract1.evaluateTransaction("get","cc");
            System.out.println(new String(result));
            System.out.println("-------------------end invoke sacc on mychannel----------------------");
            //获取合约对象
//            System.out.println("----------------Marble Contract-----------------------");
//            Contract contract = network.getContract("marble");
//            result = contract.evaluateTransaction("readMarble","marble1");
//            System.out.println(new String(result));
//            result = contract.evaluateTransaction("queryMarblesByOwner","tom");
//            System.out.println(new String(result));
//            System.out.println("-----------------Marble Contract End-------------------");
//            System.out.println("-----------------attr_set contract----------------------");
//            Contract contract1 = network.getContract("attr_set");
//            String userid,taskid,ep,ad,at,pl,pa,bn;
//            for (int i = 1; i <=5 ; i++) {
//                userid = "user-" + i;
//                taskid = "task-" + i;
//                ep = "" + i;
//                ad = "" + i;
//                at = "" + i;
//                pl = "" + i;
//                pa = "" + i;
//                bn = "" + i;
//                contract1.submitTransaction("Set",userid, taskid, ep, ad, at, pl, pa, bn);
//                System.out.println("****************************************************************");
//            }
//            System.out.println("-----------------attr_set end---------------------------");












//            System.out.println(new String(result));
//            查询合约对象evaluateTransaction
//            byte[] queryAResultBefore = contract.evaluateTransaction("query","a");
//            System.out.println("交易前："+new String(queryAResultBefore, StandardCharsets.UTF_8));
//
//            // 创建并且提交交易
//            byte[] invokeResult = contract.createTransaction("init")
//                    .setEndorsingPeers(network.getChannel().getPeers(EnumSet.of(Peer.PeerRole.ENDORSING_PEER)))
//                    .submit("a","kc");
//            byte[] invokeResult1 = contract.createTransaction("query").submit("b");
//            System.out.println(new String(invokeResult1, StandardCharsets.UTF_8));
//
//            //查询合约对象evaluateTransaction
//            byte[] queryAResultAfter = contract.evaluateTransaction("query","a");
//            System.out.println("交易后："+new String(queryAResultAfter, StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static X509Certificate readX509Certificate(final Path certificatePath) throws IOException, CertificateException {
        try (Reader certificateReader = Files.newBufferedReader(certificatePath, StandardCharsets.UTF_8)) {
            return Identities.readX509Certificate(certificateReader);
        }
    }

    private static PrivateKey getPrivateKey(final Path privateKeyPath) throws IOException, InvalidKeyException {
        try (Reader privateKeyReader = Files.newBufferedReader(privateKeyPath, StandardCharsets.UTF_8)) {
            return Identities.readPrivateKey(privateKeyReader);
        }
    }
}
