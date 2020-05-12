package com.yingxs.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * 流程定义的部署
 * activiti影响的表有哪些？
 * act_re_deployment   部署信息
 * act_re_procdef      流程定义的一些信息
 * act_ge_bytearray    流程定义的bpmn以及png文件
 */
public class ActivitiDeployment {

    // 流程定义的部署  zip包方式 有时流程制作出来要上传到服务器，zip文件更便于上传
    /*public static void main(String[] args) {
        // 1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.得到相关的Service实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3.转换出ZipInputStream流对象
        InputStream is = ActivitiDeployment.class.getClassLoader().getResourceAsStream("diagram/holidayBPMN.zip");

        // 4.将InputStream转换为ZipInputStream流
        ZipInputStream zipInputStream = new ZipInputStream(is);

        Deployment deployment = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请假申请单流程")
                .deploy();

        // 5.输出部署的一些信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());

    }*/

    // 流程定义的部署
    public static void main(String[] args) {
        // 1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.得到相关的Service实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3.进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday2.bpmn")
                .addClasspathResource("diagram/holiday2.png")
                .name("请假申请单流程")
                .deploy();

        // 4.输出部署的一些信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());

    }

}
