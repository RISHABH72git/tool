package com.example.tool.service;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DiskDrive {

    public void getAllDriveName(){
        File[] rootDrive = File.listRoots();
        for(File sysDrive : rootDrive){
            System.out.println("Drive : " + sysDrive);
        }
    }

    public void getAllDirName(){
        File directory = new File("/");
        File[] dir = directory.listFiles();
        long freeSpace = directory.getFreeSpace();
        System.out.println(freeSpace);
        long totalSpace = directory.getTotalSpace();
        System.out.println(totalSpace);
        long usableSpace = directory.getUsableSpace();
        System.out.println(usableSpace);
        for (File folder : dir){
            System.out.println(folder);
        }
    }

    public void getFullPath(){
        String dir = "invite.ics";
        Path path = Paths.get(dir);
        System.out.println(path.toAbsolutePath());
    }

}
