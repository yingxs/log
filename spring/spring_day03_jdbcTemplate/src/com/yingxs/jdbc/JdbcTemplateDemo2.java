package com.yingxs.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcTemplateDemo2 {
	
	
	
	
	//JDBC实现
	@Test
	public void testJDBC(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/spring_day03","root","123456");
			//编写sql语句
			String sql = "select * from user where username=?";
			//预编译sql
			psmt = conn.prepareStatement(sql);
			//设置参数值
			psmt.setString(1, "lucy");
			//执行sql
			rs = psmt.executeQuery();
			//遍历结果集
			while(rs.next()){
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				
				System.out.println(user);
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	//1.查询返回对象
	@Test
	public void testObject(){
		//1.1创建连接资源对象，设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3308/spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//1.2创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//创建sql语句
		String sql="select * from user where username=?";
		//1.3调用jdbcTemplate对象里面的方法得到记录数
		//第二个参数是接口RowMapper
		User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(),"mary");
		System.out.println(user);
		
		
	}
	
	//1.查询返回list对象
	@Test
	public void testList(){
		//1.1创建连接资源对象，设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3308/spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//1.2创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//创建sql语句
		String sql="select * from user";

		//第二个参数是接口RowMapper
		List<User> list = jdbcTemplate.query(sql, new MyRowMapper());
		
		System.out.println(list);
		
		
	}
	

	

}


class MyRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		//1.从结果集得到数据
		String username = rs.getString("username");
		String password = rs.getString("password");
		
		//2.将得到的数据封装到对象里面
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		return user;
	}
	
}