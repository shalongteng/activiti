package com.slt.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.transform.Source;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessEngineTest {

    //1、The easiest way to obtain a ProcessEngine, is to use the org.activiti.engine.ProcessEngines class:
    @Test
    public void createProcessEngineByDefault(){
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(defaultProcessEngine.getName());
    }
    //2、The ProcessEngineConfiguration object can also be created programmatically using the configuration file.
    // It is also possible to use a different bean id (e.g. see line 3).
    @Test
    public void createProcessEngineConfiguration(){
        ProcessEngineConfiguration processEngineConfigurationFromResourceDefault = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();

        System.out.println(processEngineConfigurationFromResourceDefault.getProcessEngineName());
        System.out.println(processEngineConfigurationFromResourceDefault.getDatabaseTablePrefix()+"888888888");
        System.out.println(processEngineConfigurationFromResourceDefault.getJdbcUrl());
        System.out.println(processEngineConfigurationFromResourceDefault.getDatabaseType());
        System.out.println(processEngineConfigurationFromResourceDefault.getJdbcMaxWaitTime());
    }
    @Test
    public void createProcessEngineConfiguration2(){
        ProcessEngineConfiguration processEngineConfigurationFromResource = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml","processEngineConfiguration");
        ProcessEngine processEngine = processEngineConfigurationFromResource
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
                .setJdbcUrl("jdbc:h2:mem:my-own-db;DB_CLOSE_DELAY=1000")
                .setAsyncExecutorEnabled(true)
                .setAsyncExecutorActivate(false)
                .buildProcessEngine();

        System.out.println(processEngineConfigurationFromResource.getProcessEngineName());
        System.out.println(processEngine.getName());
    }
}
