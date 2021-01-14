package com.example.themeleaf.other;

import org.hyperledger.fabric.gateway.*;
import org.hyperledger.fabric.gateway.impl.GatewayImpl;
import org.springframework.stereotype.Component;

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
@Component
public class demo2 {
    private Gateway gateway;
    private Network network;
    private static final Path NETWORK_CONFIG_PATH = Paths.get("src", "main", "resources", "connection-lamaxiya.json");
    private static final Path credentialPath = Paths.get("src", "main","resources", "crypto-config",
            "peerOrganizations", "sence.maintenance1.com", "users", "User1@sence.maintenance1.com", "msp");

    public static void main( String[] args) {
        X509Certificate certificate = null;
        PrivateKey privateKey = null;
        Gateway gateway = null;
        byte[] result = null;
        try {
            //使用org1中的user1初始化一个网关wallet账户用于连接网络
            Wallet wallet = Wallets.newInMemoryWallet();
            Path certificatePath = credentialPath.resolve(Paths.get("signcerts", "User1@sence.maintenance1.com-cert.pem"));
            certificate = readX509Certificate(certificatePath);
            Path privateKeyPath = credentialPath.resolve(Paths.get("keystore", "priv_sk"));
            privateKey = getPrivateKey(privateKeyPath);
            wallet.put("user",Identities.newX509Identity("Sense1MSP",certificate,privateKey));
            //根据connection-org1.json 获取Fabric网络连接对象
            GatewayImpl.Builder builder = (GatewayImpl.Builder) Gateway.createBuilder();
            builder.identity(wallet, "user").networkConfig(NETWORK_CONFIG_PATH);
            //连接网关
            gateway = builder.connect();

            System.out.println("-------------------invoke sacc on mychannel----------------------");
            Network network = gateway.getNetwork("mychannel");
//            Contract contract1 = network.getContract("sacc");
//            contract1.submitTransaction("set","dd","linux");
//            result = contract1.evaluateTransaction("get","cc");
//            System.out.println(new String(result));
//            System.out.println("-------------------end invoke sacc on mychannel----------------------");
//            System.out.println("--------------------mychannel2-----------------------------------");
//            Network network1 = gateway.getNetwork("mychannel2");
//            Contract contract2 = network1.getContract("in");
//            result = contract2.evaluateTransaction("incode","sacc","mychannel","get","dd");
//            System.out.println(new String(result));
            //获取合约对象
//            System.out.println("----------------Marble Contract-----------------------");
//            Contract contract = network.getContract("marble");
//            result = contract.evaluateTransaction("readMarble","marble1");
//            System.out.println(new String(result));
//            result = contract.evaluateTransaction("queryMarblesByOwner","tom");
//            System.out.println(new String(result));
//            System.out.println("-----------------Marble Contract End-------------------");
//            System.out.println("-----------------attr_set contract----------------------");
//            Contract contract1 = network.getContract("marble");
//            String userid,taskid,ep,ad,at,pl,pa,bn,number;
//            for (int i = 1; i <=2 ; i++) {
//                userid = "user-" + i;
//                taskid = "task-" + i;
//                ep = "" + i;
//                ad = "" + i;
//                at = "" + i;
//                pl = "" + i;
//                pa = "" + i;
//                bn = "" + i;
//                number = "" + i;
//                contract1.submitTransaction("initMarble",userid, taskid, ep, ad, at, pl, pa, bn, number);
//                System.out.println("****************************************************************");
//            }
//            System.out.println("-----------------attr_set end---------------------------");
//            contract1.evaluateTransaction()
//            Contract contract2 = network.getContract("fabcar");
//            result = contract2.evaluateTransaction("QueryAllCars");
//            System.out.println(new String(result));
//            contract2.submitTransaction("CreateCar","CAR10","10","10","10","10");
//            System.out.println(new String(contract2.evaluateTransaction("QueryCar","CAR10")));
//            System.out.println("-------------------------sacc合约-----------------------");
//            Contract contract = network.getContract("sacc");
//            for (int i = 0; i <10 ; i++) {
//                byte[] result1 = contract.evaluateTransaction("get","a");
//                System.out.println(new String(result1));
//            }
//            contract.submitTransaction("set","b","88");
//            System.out.println(new String(contract.evaluateTransaction("get","b")));
//            System.out.println("--------------------------------invokeotherchaincode--------------------------------");
//            Contract contract3 = network.getContract("te");
//            byte[] re3 = contract3.submitTransaction("invokeOtherChaoncode3","fabcar","mychannel","QueryAllCars");
//            System.out.println(new String(re3));
//            contract3.submitTransaction("invokeOtherChaoncode3","sacc","mychannel","set","name","lamaxiya");
//            byte[] re4 = contract3.submitTransaction("invokeOtherChaoncode3","sacc","mychannel","get","name");
//            System.out.println(new String(re4));
//            System.out.println("----------------------------------invoke-end--------------------------------------");













//            System.out.println("----------------------------invoke--------------------------");
//            Contract contract1 = network.getContract("te");
//            contract1.submitTransaction("invokeOtherChaoncode", "mytest", "mychannel", "QueryCar", "CAR0");
//            System.out.println("-------------------------------end---------------------------");
//            System.out.println(new String(contract.evaluateTransaction("get","cc")));
//
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
