package com.yingxs.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 查询当前用户的任务列表
 */
public class ActivitiTaskQuery {
    public static void main(String[] args) {
        // 1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.得到TaskService对象
        TaskService taskService = processEngine.getTaskService();
        // 3.根据流程定义的key负责人assign实现当前用户人物列表查询
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("zhangsan")
                .list();

        // 4.人物列表的展示
        for (Task task : taskList ) {
            System.out.println("流程实例ID: " + task.getProcessInstanceId());
            System.out.println("任务ID:     " + task.getId());
            System.out.println("任务负责人： "+task.getAssignee());
            System.out.println("任务负名称： "+task.getName());
        }

    }
}
