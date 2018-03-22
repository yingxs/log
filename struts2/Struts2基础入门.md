### Struts2的Hello World
* 1.下载Struts的开发包
* 2.把struts2导包
* 3.编写JSP页面
    ```
    <body>
        <a href="hello.action">跳转到struts2的Action类</a>
    </body>
    ```
* 4.编写Struts2的Action类
    ```
    package com.yingxs.action;
    /**
     * Struts2的Action类
     * @author admin
     *
     */
    public class HelloAction {
    	
    	public String hello(){
    		System.out.println("进入Struts2的Action类");
    		return "success";
    	}
    }

    ```
* 5.配置Action类
    * 文件名：struts.xml
    * 位置：src目录
    ```
    <?xml version="1.0" encoding="UTF-8"?>
       <!DOCTYPE struts PUBLIC
    	"-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
    	"http://struts.apache.org/dtds/struts-2.5.dtd">
    	
    <struts>
    	<package name="base" extends="struts-default" namespace="/">
    		<action name="hello"  class="com.yingxs.action.HelloAction" method="hello">
    			<result name="success">/succ.jsp</result>
    		</action>
    	</package>
    	
    </struts>
    ```
* 6.在web.xml启动struts程序(重点)
    * web.xml 
    ```
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app version="2.5" 
    	xmlns="http://java.sun.com/xml/ns/javaee" 
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
    	http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
      <display-name></display-name>	
      
      <!-- 启动struts2的程序 -->
      <filter>
      	<filter-name>struts2</filter-name>
      	<filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
      </filter>
      <filter-mapping>
      	<filter-name>struts2</filter-name>
      	<url-pattern>/*</url-pattern>
      </filter-mapping>
      
      <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
      </welcome-file-list>
    </web-app>

    ```
* 6.部署测试