package com.example.tool;

import com.example.tool.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.util.Set;


@SpringBootApplication
@EnableWebMvc
public class ToolApplication{

    public static void main(String[] args) {
        SpringApplication.run(ToolApplication.class, args);
        CreateProcess createProcess = new CreateProcess();
        createProcess.runtimeAvaliable();
    }
}
