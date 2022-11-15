package com.example.tool.service;

import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class GenerateSignature {

    public Map<String, byte[]> digitalSignatureAlgorithm(String Message) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, IOException, SignatureException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
        keyGen.initialize(1024, secureRandom);

        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
        dsa.initSign(privateKey);

        InputStream inputStream = new ByteArrayInputStream(Message.getBytes());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        byte[] buffer = new byte[1024];
        int len;
        while ((len= bufferedInputStream.read(buffer)) >= 0 ){
            dsa.update(buffer, 0 , len);
        }
        bufferedInputStream.close();

        byte[] realSig = dsa.sign();
        byte[] key = publicKey.getEncoded();
        Map<String, byte[]> result = new HashMap<>();
        result.put("Signature",realSig);
        result.put("PublicKey", key);
        result.put("Message", Message.getBytes());
        return result;
    }

}
