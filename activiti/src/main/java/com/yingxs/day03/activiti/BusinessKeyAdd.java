package com.yingxs.day03.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;

/**
 * 启动流程实例，添加进businessKey
 *
 * 本质：act_ru_execution表中的businessKey字段存入业务标识
 */
public class BusinessKeyAdd {


    public static void main(String[] args) {
        // 1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.创建RepositaryService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 3.启动流程实例；同时制定业务标识 businessKey 它本身就是请假单的id
        // 参数1：流程定义的key  参数2：businessKey
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday", "1001");

        // 4.输出processInstance相关属性
        System.out.println(processInstance.getBusinessKey());


    }

}
