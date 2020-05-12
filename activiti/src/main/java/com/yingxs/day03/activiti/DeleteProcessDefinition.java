package com.yingxs.day03.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * 删除已经部署的流程定义
 * 和流程定义的部署影响的表一样
 * `act_ge_bytearray`
 * `act_re_deployment`
 * `act_re_procdef`
 */
public class DeleteProcessDefinition {


    /**
     * 注意事项：
     *  1.正在执行的一套流程未完全审批结束的时候，此时如果要删除流程定义信息就会失败
     *  2.如果公司层面要强制删除，那么可以使用级联删除，repositoryService.deleteDeployment("1",true);
     *  那么就会先删除没有完成的流程，最后就可以删除流程定义信息
     * @param args
     */
    public static void main(String[] args) {
        // 1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.创建RepositaryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();


        // 3.执行删除流程定义 参数为流程部署的id
        repositoryService.deleteDeployment("1",true);

    }

}
