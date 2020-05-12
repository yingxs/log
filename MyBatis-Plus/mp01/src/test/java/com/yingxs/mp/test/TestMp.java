package com.yingxs.mp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TestMp {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");


    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ioc.getBean("dataSource",DataSource.class);
        System.out.println();
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }


}
