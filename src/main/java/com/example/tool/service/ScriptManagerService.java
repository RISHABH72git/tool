package com.example.tool.service;

import org.springframework.stereotype.Service;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

@Service
public class ScriptManagerService {

    public void showAllScriptEngine(){
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        List<ScriptEngineFactory> engineFactoryList = scriptEngineManager.getEngineFactories();
        engineFactoryList.forEach(scriptEngineFactory -> {
            System.out.println(scriptEngineFactory.getEngineName());
            //System.out.println(scriptEngineFactory.getLanguageName());
           // System.out.println(scriptEngineFactory.getLanguageVersion());
            //System.out.println(scriptEngineFactory.getEngineVersion());
            scriptEngineFactory.getNames().forEach(System.out::println);
            scriptEngineFactory.getExtensions().forEach(System.out::print);
            System.out.println("------------------------------------------------------------");
        });
    }

}
