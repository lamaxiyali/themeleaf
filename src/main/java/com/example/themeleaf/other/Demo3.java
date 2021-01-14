package com.example.themeleaf.other;

import com.example.themeleaf.service.RandomArray;
import org.hyperledger.fabric.gateway.*;
import org.hyperledger.fabric.gateway.impl.GatewayImpl;
import org.hyperledger.fabric.sdk.Peer;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Component
public class Demo3 {
    @Autowired
    RandomArray randomArray;
    private Gateway gateway;
    private Network network;
    private static final Path NETWORK_CONFIG_PATH = Paths.get("src", "main", "resources", "connection-lamaxiya.json");
    private static final Path credentialPath = Paths.get("src", "main","resources", "crypto-config",
            "peerOrganizations", "sence.maintenance1.com", "users", "User1@sence.maintenance1.com", "msp");
    public void testChain(){
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
            wallet.put("user",Identities.newX509Identity("Sence1MSP",certificate,privateKey));
            //根据connection-org1.json 获取Fabric网络连接对象
            GatewayImpl.Builder builder = (GatewayImpl.Builder) Gateway.createBuilder();
            builder.identity(wallet, "user").networkConfig(NETWORK_CONFIG_PATH);
            //连接网关
            gateway = builder.connect();
            System.out.println("-------------------invoke sacc on mychannel----------------------");
            Network network = gateway.getNetwork("mychannel");
//            Contract contract1 = network.getContract("sacc");
////            contract1.submitTransaction("set","sex","male");
//            result = contract1.evaluateTransaction("get","lama");
//            System.out.println(new String(result));
//            Contract contract3 = network.getContract("fff");
//            result = contract3.submitTransaction("BidStart1","task-1","ReadByTask_id");
//            System.out.println(new String(result));
//            Contract contract = network.getContract("attr");
//            String userid,taskid,ep,ad,at,pl,pa,bn,number,userid1;
//            taskid= "task-1";
//            userid = "user-";
//            long start, end;
//            start = System.currentTimeMillis();
//            for (int i = 451; i <501 ; i++) {
//                userid1 = userid + i;
//                List<Integer> list = new ArrayList<>();
//                list = randomArray.randNormal();
//                ep = "" + list.get(0);
//                ad = "" + list.get(1);
//                at = "" + list.get(2);
//                pl = "" + list.get(3);
//                pa = "" + list.get(4);
//                bn = "" + list.get(5);
//                number = "" + i;
////                contract.createTransaction("Set").setEndorsingPeers(network.getChannel().getPeers(EnumSet.of(Peer.PeerRole.ENDORSING_PEER))).submit(userid, taskid, ep, ad, at, pl, pa, bn, number);
//                contract.submitTransaction("Set",userid1, taskid, ep, ad, at, pl, pa, bn, number);
//            }
//            end = System.currentTimeMillis();
//            System.out.println("花费时间："+ (end-start)+"ms");
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
