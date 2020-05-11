package com.yingxs.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * 测试类
 * 测试Activiti所需要的25张表的生成
 */
public class ActivitiTest {

    @Test
    public void testGenTable(){

        // 1.创建一个ProcessEngineConfiguration对象
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");

        // 2.创建一个ProcessEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();

        // 3.输出processEngine对象
        System.out.println(processEngine);
    }

    @Test
    public void testGenTable2(){
        /*
        条件：
            1.activiti的各项配置文件为默认，bean的名称默认

         */
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
    }




}
