package com.yingxs.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
	//注入jdbcTemplate
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//扣除
	public void lessMoney(){
		String sql = "update account set salary=salary-? where username=?";
		jdbcTemplate.update(sql, 1000,"小王");
	}
	
	//增加
	public void moreMoney(){
		String sql = "update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql, 1000,"小马");
	}
	
	
	

}
