package com.slt.activiti.Configuration;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;

public class ProcessEngineTest {
    public static void main(String[] args) {
        //1、The easiest way to obtain a ProcessEngine, is to use the org.activiti.engine.ProcessEngines class:
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(defaultProcessEngine.getName());

        //2、The ProcessEngineConfiguration object can also be created programmatically using the configuration file.
        // It is also possible to use a different bean id (e.g. see line 3).
        ProcessEngineConfiguration processEngineConfigurationFromResourceDefault = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        System.out.println(processEngineConfigurationFromResourceDefault.getProcessEngineName());
    }
}
