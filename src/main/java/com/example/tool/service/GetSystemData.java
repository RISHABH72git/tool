package com.example.tool.service;

public class GetSystemData {

    public void getOsDetail(){
        //show all properties
        System.out.println("Your all Properties ->" + System.getProperties());

        //show os name
        System.out.println("Your OS name ->" + System.getProperty("os.name"));

        //show os version
        System.out.println("Your OS version ->" + System.getProperty("os.version"));

        //show os architecture
        System.out.println("Your OS Architecture ->" + System.getProperty("os.arch"));

        //JRE version number
        System.out.println(System.getProperty("java.version"));

        //Installation directory for Java Runtime Environment (JRE)
        System.out.println(System.getProperty("java.home"));

        //User account name
        System.out.println(System.getProperty("user.name"));

    }
}
