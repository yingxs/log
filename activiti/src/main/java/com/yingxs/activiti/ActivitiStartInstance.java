package com.yingxs.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 启动流程实例
 * 前提是已经万和城那个流程定义的部署工作
 *
 *  * act_re_deployment   部署信息
 *  * act_re_procdef      流程定义的一些信息
 *  * act_ge_bytearray    流程定义的bpmn以及png文件
 *
 *  启动影响了：
 * `act_hi_actinst`         已完成的活动信息
 * `act_hi_identitylink`    参与者信息
 * `act_hi_procinst`        流程实例
 * `act_hi_taskinst`        任务实例
 * `act_ru_execution`       执行表
 * `act_ru_identitylink`    参与者信息
 * `act_ru_task`            任务表
 */
public class ActivitiStartInstance {

    public static void main(String[] args) {
        // 1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.得到RunService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 3.创建流程实例 流程定义的key需要知道
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday");

        // 4.输出实例相关信息
        System.out.println("流程部署的Id："+processInstance.getDeploymentId()); // null
        System.out.println("流程定义的Id："+processInstance.getProcessDefinitionId()); // holiday:1:4
        System.out.println("流程实例的Id："+processInstance.getId()); // 2501
        System.out.println("活动Id："+processInstance.getActivityId()); // null

    }

}
