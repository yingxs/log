package com.yingxs.day04;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;

import java.util.HashMap;

/**
 * 启动流程实例 动态设置assignee
 */
public class AssigneUEL {

    public static void main(String[] args) {
        // 1得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.得到RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 3.设置assignee的取值，用户可以在界面上设置流程的执行人
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("assignee0","zhangsan2");
        map.put("assignee1","lisi2");
        map.put("assignee2","wangwu2");

        // 4.启动流程实例，同时还要设置流程定义的assignee值
        runtimeService.startProcessInstanceByKey("holiday2",map);

        System.out.println(processEngine.getName());

    }

}
