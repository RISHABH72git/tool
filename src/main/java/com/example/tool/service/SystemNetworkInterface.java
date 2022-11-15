package com.example.tool.service;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.net.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

@Service
public class SystemNetworkInterface {


    public String  getHostName() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        return inetAddress.getHostName();
    }
    public String  getHostAdd() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        return inetAddress.getHostAddress();
    }

    public  void getNetworkInterfaces() throws SocketException {
        Enumeration<NetworkInterface> interfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        while (interfaceEnumeration.hasMoreElements()){
            NetworkInterface networkInt = interfaceEnumeration.nextElement();
            System.out.println("Interface -" +networkInt.getName());
            System.out.println("Display name - " +networkInt.getDisplayName());
            System.out.println("Address -"+networkInt.getInetAddresses());
            System.out.println("List of Address - "+networkInt.getInterfaceAddresses());
            System.out.println("MTU - "+networkInt.getMTU());

            Enumeration<NetworkInterface> subInterface = networkInt.getSubInterfaces();
            for (NetworkInterface subIf : Collections.list(subInterface)) {
                System.out.print("\tSub Interface : "+subIf.getName());
                System.out.print("\tSub Interface Display name :"+subIf.getDisplayName());
            }
        }
    }

    public void  getInterfaceDetail() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaceEnumeration.hasMoreElements()) {
            NetworkInterface networkInterface = NetworkInterface.getByName(networkInterfaceEnumeration.nextElement().getName());
            System.out.println("Name :- "+networkInterface.getName());
            System.out.println("DisplayName :- "+networkInterface.getDisplayName());
            System.out.println("LoopBack :- "+networkInterface.isLoopback());
            System.out.println("Virtual :- "+networkInterface.isVirtual());
            System.out.println("MTU :- "+networkInterface.getMTU());
            System.out.println("Support Multicast :- " +networkInterface.supportsMulticast());
            byte[] mac = networkInterface.getHardwareAddress();
            if(mac != null) {
                System.out.print("Hardware Address : ");
                for (int k = 0; k < mac.length; k++)
                    System.out.format("%02X%s", mac[k], (k < mac.length - 1) ? "-" : "");
                System.out.println();
            }
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    public void createUrl() throws MalformedURLException {
        URL url = new URL("http://www.google.com");
        System.out.println("Protocol = " + url.getProtocol());
        System.out.println("Authority = " + url.getAuthority());
        System.out.println("Host = " + url.getHost());
        System.out.println("Port = " + url.getPort());
        System.out.println("Default port = " + url.getDefaultPort());
        System.out.println("Path = " + url.getPath());
        System.out.println("Query = " + url.getQuery());
        System.out.println("File = " + url.getFile());
        System.out.println("Ref = " + url.getRef());
    }

    public SystemNetworkInterface(){
    }
    public void getHostNamebyIp() throws UnknownHostException {
        byte[] localaddress = {(byte) 192, (byte) 168,(byte) 86,(byte) 1};
        for (int i =1 ; i < 255; i++) {
            localaddress[3]++;
            System.out.println(" Ip - "+ Arrays.toString(localaddress) +InetAddress.getByAddress(localaddress).getHostName());
        }u
    }
}
