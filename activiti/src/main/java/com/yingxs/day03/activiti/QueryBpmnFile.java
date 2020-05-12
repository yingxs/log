package com.yingxs.day03.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 需求：
 * 1.从Activiti的act_ge_bytearray表中读取资源文件
 * 2.将这两个资源文件保存到磁盘
 *
 * 用户想想查看这个流程具体有哪些流程要走
 */
public class QueryBpmnFile {

    public static void main(String[] args) throws IOException {
        // 1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.得到RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3.得到查询器：ProcessDefinitionQuery对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        // 4.设置查询条件 参数是流程定义的key
        processDefinitionQuery.processDefinitionKey("holiday");

        // 5.执行查询操作，查询出想要的流程定义
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();

        // 6.通过流程定义信息得到部署ID
        String deploymentId = processDefinition.getDeploymentId();

        // 7.通过repositoryService读取图片信息以及bpmn文件信息(输入流)
        // 参数1：部署ID，参数2：资源名称
        // processDefinition.getDiagramResourceName() 获取png图片资源的名称
        // processDefinition.getResourceName() 获取bpmn图片资源的名称
        InputStream pngIs = repositoryService.getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());
        InputStream bpmnIs = repositoryService.getResourceAsStream(deploymentId, processDefinition.getResourceName());

        // 8.构建出OutputStream流
        FileOutputStream pngOs = new FileOutputStream("D:\\" + processDefinition.getDiagramResourceName());
        FileOutputStream bpmnOs = new FileOutputStream("D:\\" + processDefinition.getResourceName());

        // 9.输入流和输出流的转换 common-io
        IOUtils.copy(pngIs,pngOs);
        IOUtils.copy(bpmnIs,bpmnOs);

        // 10.关闭流
        pngOs.close();
        bpmnOs.close();
        pngIs.close();
        bpmnIs.close();


    }





}
