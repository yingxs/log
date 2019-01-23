package com.yingxs;

import com.yingxs.bean.Person;
import com.yingxs.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person)applicationContext.getBean("person");
//        System.out.println(person);

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person)applicationContext.getBean(Person.class);
        System.out.println(person);


        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType ) {
            System.out.println(name);
        }


    }
    
    
}
