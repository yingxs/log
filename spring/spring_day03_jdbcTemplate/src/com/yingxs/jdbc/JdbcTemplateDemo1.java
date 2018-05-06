package com.yingxs.jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {
	
	
	
	
	
	
	
	
	//1.添加操作
	@Test
	public void add(){
		//1.1创建连接资源对象，设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3308/spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//1.2创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//1.3调用jdbcTemplate对象里面的方法实现操作
		//创建sql语句
		String sql="insert into user values(?,?)";
		int rows = jdbcTemplate.update(sql, "lucy","1");
		System.out.println(rows);
		
	}
	
	
	//2.修改操作
	@Test
	public void update(){
		//2.1创建连接资源对象，设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3308/spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//2.2创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//2.3调用jdbcTemplate对象里面的方法实现操作
		String sql="update user set password=? where username=?";
		
		int rows = jdbcTemplate.update(sql, "300","yingxs");
		System.out.println(rows);
		
	}
	
	//3.删除操作
	@Test
	public void delete(){
		//2.1创建连接资源对象，设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3308/spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//2.2创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//2.3调用jdbcTemplate对象里面的方法实现操作
		String sql="delete from user where username=?";
		
		int rows = jdbcTemplate.update(sql,"yingxs");
		System.out.println(rows);
		
	}
	
	
	

}
