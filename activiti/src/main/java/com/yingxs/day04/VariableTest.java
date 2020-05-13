package com.yingxs.day04;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;


/**
 * 流程变量的测试
 */
public class VariableTest {
    static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    static String key = "myProcess_1";

    public static void main(String[] args) {
        // 流程定义部署
        //deployment();

        // 启动流程实例
//        start();

        // zhangsan完成任务
//        complate_zhangsan("lisi");
        complate_zhangsan("wangwu");
        complate_zhangsan("zhaoliu");

//        complate();


    }

    private static void complate() {

        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(key)
                .taskAssignee("zhangsan")
                .singleResult();


        if (task != null) {
            taskService.complete(task.getId());
            System.out.println(task.getName());
            System.out.println("zhangsan"+"任务执行完毕");
        }

//        int a = 1/0;

        Task task2 = taskService.createTaskQuery()
                .processDefinitionKey(key)
                .taskAssignee("lisi")
                .singleResult();

        if (task2 != null) {
            taskService.complete(task2.getId());
            System.out.println(task2.getName());
            System.out.println("lisi"+"任务执行完毕");
        }

    }
    private static void complate_zhangsan(String name) {

        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(key)
                .taskAssignee(name)
                .singleResult();

        if (task != null) {
            taskService.complete(task.getId());
            System.out.println(task.getName());
            System.out.println(name+"任务执行完毕");
        }

    }

    private static void start(){
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 根据流程定义的key 启动流程实例

        HashMap<String, Object> map = new HashMap<>();

        Holiday holiday = new Holiday();
        holiday.setNum(5F);

        map.put("holiday",holiday);

        // 启动流程实例，并设置流程变量的值
        /**
         * `act_ru_variable`
         * `act_ge_bytearray`
         */
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, map);

        // 实例信息
        System.out.println(processInstance.getName());
        System.out.println(processInstance.getProcessDefinitionId());


    }








    private static void deployment() {

        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3.部署
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday4.bpmn")
                .addClasspathResource("diagram/holiday4.png")
                .name("请假流程-流程变量")
                .deploy();

        System.out.println(deploy.getId());
        System.out.println(deploy.getName());

    }


}
