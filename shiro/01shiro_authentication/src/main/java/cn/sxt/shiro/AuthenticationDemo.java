package cn.sxt.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * 	完成用户认证功能
 * @author admin
 *
 */
public class AuthenticationDemo {

	public static void main(String[] args) {
		
		//1.创建SecurityManager工厂 读取相应的配置文件
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		
		//2.通过securtyManager工程获取SecurityManager的实例
		SecurityManager securityManager = factory.getInstance();
		
		//3.将securityManager对象设置到运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		
		//4.通过SecurityUtils获取Subject
		Subject subject = SecurityUtils.getSubject();
		
		
		//5.加入登录的用户名和密码是zhangsan 和1111，这个地方的zhangsan和1111表示用户登录时输入的信息
		//而shiro.ini文件中信息相当于数据库中存放的用户信息
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","1111");
		//6.进行用户身份验证
		subject.login(token);
		//7.是否通过
		if(subject.isAuthenticated()) {
			System.out.println("登录成功");
		}else {
			System.out.println("用户名或密码不正确");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
	}
	
}
