package com.example.tool.service;

import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

@Service
public class VerifySignature {

    public Boolean verifyDigitalSignature(Map<String , byte[]> data) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, InvalidKeyException, IOException, SignatureException {
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(data.get("PublicKey"));
        KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
        PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
        Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
        sig.initVerify(pubKey);
        InputStream inputStream = new ByteArrayInputStream(data.get("Message"));
        BufferedInputStream bufin = new BufferedInputStream(inputStream);
        byte[] buffer = new byte[1024];
        int len;
        while (bufin.available() != 0) {
            len = bufin.read(buffer);
            sig.update(buffer, 0, len);
        };
        bufin.close();
        boolean verifies = sig.verify(data.get("Signature"));
        return verifies;
    }

}
