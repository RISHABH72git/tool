package com.example.tool.service;

import java.io.File;
import java.util.LinkedList;

public class LinkedListFile {

    public void firstLinkedListCreate(){
        File myObj = new File("sample.txt");
        File myOb = new File("simple.txt");
        File myO = new File("ple.txt");
        LinkedList<File> list = new LinkedList<File>();
        list.add(myObj);
        list.add(myO);
        list.add(myOb);
        for (File fileLinkedList : list){
            System.out.println(fileLinkedList.getPath());
            System.out.println(fileLinkedList.getAbsolutePath());
        }
    }

}
