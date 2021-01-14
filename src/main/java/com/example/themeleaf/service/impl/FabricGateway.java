package com.example.themeleaf.service.impl;

import org.hyperledger.fabric.gateway.*;
import org.hyperledger.fabric.gateway.impl.GatewayImpl;
import org.springframework.stereotype.Component;
import sun.text.normalizer.CharTrie;

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

/**
 * @author 32933
 */
//连接区块链配置信息
@Component
public class FabricGateway{
    public static Gateway gateway;
    private static final Path NETWORK_CONFIG_PATH = Paths.get("src", "main", "resources", "connection-lamaxiya.json");
    private static final Path CREDENTIAL_PATH = Paths.get("src", "main","resources", "crypto-config",
            "peerOrganizations", "sence.maintenance1.com", "users", "User1@sence.maintenance1.com", "msp");
    static {
        getGateway();
        System.out.println("Init the Gateway of Fabric");
    }
    public static  Gateway getGateway() {
        X509Certificate certificate = null;
        PrivateKey privateKey = null;
        byte[] result = null;
        try {
            //使用org1中的user1初始化一个网关wallet账户用于连接网络
            Wallet wallet = Wallets.newInMemoryWallet();
            Path certificatePath = CREDENTIAL_PATH.resolve(Paths.get("signcerts", "User1@sence.maintenance1.com-cert.pem"));
            certificate = readX509Certificate(certificatePath);
            Path privateKeyPath = CREDENTIAL_PATH.resolve(Paths.get("keystore", "priv_sk"));
            privateKey = getPrivateKey(privateKeyPath);
            wallet.put("user",Identities.newX509Identity("Sence1MSP",certificate,privateKey));
            //根据connection-org1.json 获取Fabric网络连接对象
            GatewayImpl.Builder builder = (GatewayImpl.Builder) Gateway.createBuilder();
            builder.identity(wallet, "user").networkConfig(NETWORK_CONFIG_PATH);
            //连接网关
            gateway = builder.connect();
            return gateway;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
