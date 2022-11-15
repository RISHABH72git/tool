package com.example.tool.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class CreateProcess {

    public void createOneProcess() throws Exception {

        ProcessBuilder processBuilder1 = new ProcessBuilder("firefox");
        Process process1 = processBuilder1.start();

        System.out.println(process1.pid());
        System.out.println(process1.info());
        System.out.println("waiting");
        Thread.sleep(10000);


        process1.destroy();
        System.out.println("destroy");
    }

    public  void printAllProcesses() throws Exception {
        // -e - show all processes including processes of other users
        // -o command - restrict the output to just the process name
        Process process = Runtime.getRuntime().exec("ps -e -o command");
        BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;
        String allProcess = "";
        while ((line = r.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void aptUpdate() throws IOException {
        Process process = Runtime.getRuntime().exec(" apt update");
        BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;
        while ((line = r.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void runtimeAvaliable(){
        int jvmProcessor = Runtime.getRuntime().availableProcessors();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        long cores = Runtime.getRuntime().totalMemory();
        System.out.println(cores);
        System.out.println(Runtime.version());
        System.out.println(jvmProcessor);
        System.out.println(freeMemory);
        System.out.println(maxMemory);
    }
    public void showAllThreadInJvm(){
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        threadSet.forEach(thread -> {
            System.out.println(thread.getName());
            System.out.println(thread.getId());
            System.out.println(thread.getThreadGroup());
        });
        System.out.println("------------------------------------------------------------------");
        System.out.println(threadSet.size());
    }

    public void createNewThread(){
        Thread thread = new Thread();
        thread.setName("my own thread");
        thread.start();
        System.out.println(thread.getName());
        System.out.println(thread.getId());
        System.out.println(thread.getThreadGroup());
    }

    public void showAllEnvAndSystemProperties(){
        System.getenv().forEach((s, s2) -> System.out.println(s +  "----------------" +s2));
        Set<String> stringSet = System.getProperties().stringPropertyNames();
        stringSet.forEach(s -> {
            System.out.println(s + "--------->"+System.getProperty(s));
        });
    }
}

