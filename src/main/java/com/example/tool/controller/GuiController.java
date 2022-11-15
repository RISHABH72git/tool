package com.example.tool.controller;

import com.example.tool.service.CreateProcess;
import com.example.tool.service.GenerateSignature;
import com.example.tool.service.SystemNetworkInterface;
import com.example.tool.service.VerifySignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

@RestController
public class GuiController {

    @Autowired
    SystemNetworkInterface systemNetworkInterface;

    @Autowired
    CreateProcess createProcess;

    @Autowired
    GenerateSignature generateSignature;

    @Autowired
    VerifySignature verifySignature;

    @RequestMapping("/")
    public String getHostName(Model model) throws Exception {
        model.addAttribute("hostAdd", systemNetworkInterface.getHostAdd());
        model.addAttribute("hostName",systemNetworkInterface.getHostName());
        return "welcome";
    }

    @GetMapping("/digitalSignatureAlgorithm")
    public Map<String, byte[]> digitalSignatureAlgorithm(@RequestParam String Message) throws NoSuchAlgorithmException, IOException, SignatureException, NoSuchProviderException, InvalidKeyException {
       return generateSignature.digitalSignatureAlgorithm(Message);
    }

    @PostMapping("/verifyDigitalSignature")
    public Boolean verifyDigitalSignature(@RequestBody  Map<String , byte[]> data) throws NoSuchAlgorithmException, IOException, SignatureException, NoSuchProviderException, InvalidKeyException, InvalidKeySpecException {
        return verifySignature.verifyDigitalSignature(data);
    }

}
