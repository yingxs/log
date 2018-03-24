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


### Struts2配置文件的加载
> struts2的初始化过程中(在核心过滤器调用init方法的时候，加载6个配置文件)

* 1.default.prperties 常量文件
* 2.struts-default.xml  struts2的核心配置(拦截器等)
* 3.struts-plugin.xml   struts的核心配置文件(包含在插件包里)
* 4.struts.xml          开发者自己编写的struts的配置文件
* 5.struts.properties   struts2的配置文件(少见)
* 6.web.xml             web应用的描述文件

以上6个配置文件的顺序就是加载顺序


### struts.xml配置文件详解
* package 标签：包，用于管理不同的Action
    * name 属性：包名，不同的package必须使用不同的name
    * extends属性：继承，我们的包可以继承struts-default包，继承之后会继承父包的所有特性
    * namespace属性：名称空间，区分不同的package(包)的访问路径
* action标签：配置动作类
    * name 属性;动作类的名称，用于访问动作类的路径
    * class属性：动作类的限定名，用于struts2找到类，默认值：ActionSupport
    * method 属性：动作类的执行方法，用于执行类中方法，默认值：execute
*  result标签：视图，用于跳转页面
    * name:视图名称，用于和动作类的方法返回值进行匹配  
    * typr:视图类型，如何跳转(转发，重定向)默认值，dispatcher(转发)

### struts2常量文件
```
struts.action.extension = action,,
//这是struts2得到访问后缀配置
```

### struts2修改常量值
#### 修改struts.xml
```
<struts>
	<!-- 修改常量配置 -->
	<constant name="struts.action.extension" value="do"></constant>

	<package name="base" extends="struts-default" namespace="/">
		<action name="hello"  class="com.yingxs.action.HelloAction" method="hello">
			<result name="success">/succ.jsp</result>
		</action>
	</package>
</struts>

```
#### 修改web.xml
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
  	<!-- 修改struts2常量配置 -->
  	<init-param>
  		<param-name>struts.action.extension</param-name>
  		<param-value>html,,</param-value>
  	</init-param>
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



### Action动作类的三种写法
#### 1.不实现接口和继承类
```
package com.yingxs.action;
/**
 * 第一种写法：不实现任何接口和类
 * @author admin
 *
 */
public class Demo1Action {

	public String hello(){
		System.out.println("第一种写法：不实现接口和类");
		return "success";
	}
}

```
#### 2.实现Action接口
```
package com.yingxs.action;

import com.opensymphony.xwork2.Action;

/**
 * Action的第二种写法：实现Action接口
 * 好处:
 * 		1.提供默认的excute方法，让Action类更加规范
 * 		2.提供了5个开发中常用的视图变量
 * 	
 * @author admin
 *
 */
public class Demo2Action implements Action {
	
	@Override
	public String execute() throws Exception {
		System.out.println("Action的第二种写法：实现Action接口");
		return SUCCESS;
	}

	
	
}

```
#### 3.继承ActionSupper类
```
package com.yingxs.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action的第三种写法：继承ActionSupport类
 * 好处:
 * 		1.有了Action接口的所有好处
 * 		2.还拥有其他功能接口
 * 	
 * @author admin
 *
 */
public class Demo3Action extends ActionSupport {
	
	@Override
	public String execute() throws Exception {

		System.out.println("Action的第三种写法：继承ActionSupport类");
		return SUCCESS;
	}
	
	
}

```
### Action的三种访问方式
#### 传统的访问方式
```
<?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE struts PUBLIC
	"-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
	"http://struts.apache.org/dtds/struts-2.5.dtd">
	
<struts>

	<!-- 方式一：传统访问方式 -->
	<package name="base" extends="struts-default" namespace="/demo1">
		<action name="save" class="com.yingxs.action.Demo1Action" method="save">
			<result>/succ.jsp</result>
		</action>
		<action name="update" class="com.yingxs.action.Demo1Action" method="update">
			<result>/succ.jsp</result>
		</action>
	</package>
</struts>
```
#### 通配符的访问方式
```

<!-- 方式二：通配符的访问方式 -->
<package name="demo2" extends="struts-default" namespace="/demo2">
	<action name="demo2_*" class="com.yingxs.action.Demo2Action" method="{1}">
		<result>/succ.jsp</result>
	</action>
</package>
	
```
#### 动态方法调用方式
```
<!-- 开启动态方法调用的配置 -->
	<constant name="struts.enable.DynamicMethodInvocation" value="true"></constant>
	
	<!-- 方式三：动态方法调用的访问方式 -->
	<package name="demo3" extends="struts-default" namespace="/demo3">
	<!-- 用户访问路径
		demo3/demo3!save.action
		demo3/demo3!update.action
	 -->
		<action name="demo3" class="com.yingxs.action.Demo2Action">
			<result>/succ.jsp</result>
		</action>
	</package>
```

