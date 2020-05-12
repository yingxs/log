package com.yingxs.day03.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 全部流程的实例挂起与激活
 *
 * 操作流程定义为挂起状态，该流程定义下所有的流程实例都会全部暂停
 * 流程定义为挂起状态，该流程定义将不允许启动新的流程实例，同时该流程定义下所有的流程实例将全部挂起暂停执行
 */
public class SuspendProcessInstance {


    public static void main(String[] args) {
        // 1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.创建 RepositoryService 对象
        RepositoryService repositaryService = processEngine.getRepositoryService();

        // 3.查询流程定义对象
        ProcessDefinition processDefinition = repositaryService.createProcessDefinitionQuery()
                .processDefinitionKey("holiday")
                .singleResult();
        // 4.得到当前流程定义的实例是否都为暂停状态
        boolean suspended = processDefinition.isSuspended();

        // 流程定义Id
        String processDefinitionId = processDefinition.getId();
        // 5.判断
        if (suspended) {
            // 说明是暂停，可执行激活操作
            repositaryService.activateProcessDefinitionById(processDefinitionId,true,null);
            System.out.println("流程定义 " + processDefinitionId + " 激活");
        } else {
            // 说明是激活，可执行暂停操作
            repositaryService.suspendProcessDefinitionById(processDefinitionId,true,null);
            System.out.println("流程定义 " + processDefinitionId + " 挂起");

        }

    }

}
