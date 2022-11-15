package com.example.tool.service;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduledTask extends TimerTask {

    @Override
    public void run() {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        CreateProcess createProcess = new CreateProcess();
        createProcess.createNewThread();
        createProcess.showAllThreadInJvm();
        String jvmName = bean.getName();
        System.out.println("process id -> "+bean.getPid());
        System.out.println("Namejvm = " + jvmName);
        try {
            Runtime.getRuntime().exec("kill "+ bean.getPid());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
