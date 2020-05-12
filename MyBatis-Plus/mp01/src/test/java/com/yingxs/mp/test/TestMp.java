package com.yingxs.mp.test;

import com.yingxs.mp.beans.Employee;
import com.yingxs.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TestMp {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");


    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);


    /**
     * 通用插入操作
     * @throws SQLException
     */
    @Test
    public void testCommonInsert(){
        Employee employee = new Employee(null,"mp","yingxs.com",1,22);
        System.out.println(employee);
        System.out.println(employeeMapper.insert(employee));
        System.out.println(employee);
    }


    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ioc.getBean("dataSource",DataSource.class);
        System.out.println();
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }


}
