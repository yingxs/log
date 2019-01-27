package com.yingxsx.test;

import com.yingxs.bean.Boss;
import com.yingxs.bean.Car;
import com.yingxs.config.MainConfigOfAutowired;
import com.yingxs.config.MainConfigOfLifeCycle;
import com.yingxs.dao.BookDao;
import com.yingxs.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class IOCTest_Autowired {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);


    @Test
    public void test01(){
        //1.创建IOC容器
       // printBeans(applicationContext);
        System.out.println("容器创建完成...");

        BookService bookService = applicationContext.getBean(BookService.class);

        System.out.println(bookService);

//        BookDao bookDao = applicationContext.getBean(BookDao.class);
//        System.out.println(bookDao);


        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);


        //关闭容器
        applicationContext.close();

    }


    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name : definitionNames){
            System.out.println(name);
        }
    }
}
