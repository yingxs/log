package com.yingxs.day03.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 单个流程的实例挂起与激活
 * 当流程实例已经处于挂起状态，如果此时执行该流程
 * 会抛出ActivitiException异常：Cannot complete a suspended task
 *
 */
public class SuspendProcessInstance2 {

    // 单个流程的实例挂起与激活
    /*
    public static void main(String[] args) {
        // 1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.创建 RepositoryService 对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 3.查询流程实例对象
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId("2501")
                .singleResult();
        // 4.得到当前流程定义的实例是否都为暂停状态
        boolean suspended = processInstance.isSuspended();

        // 流程实例Id
        String processInstanceId = processInstance.getId();
        // 5.判断
        if (suspended) {
            // 说明是暂停，可执行激活操作
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("流程实例 " + processInstanceId + " 激活");
        } else {
            // 说明是激活，可执行暂停操作
            runtimeService.suspendProcessInstanceById(processInstanceId);
            System.out.println("流程实例 " + processInstanceId + " 挂起");

        }

    }*/


    /**
     * 当流程实例已经处于挂起状态，如果此时执行该流程
     *会抛出ActivitiException异常：Cannot complete a suspended task
     * @param args
     */
    public static void main(String[] args) {
        // 1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.得到TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3.查询当前用户任务
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("zhangsan")
                .singleResult();


        // 4.处理任务
        taskService.complete(task.getId());

        // 5.输出任务Id
        System.out.println(task.getId());

    }

}
