package com.yingxs.config;

import com.yingxs.bean.Car;
import com.yingxs.bean.Color;
import com.yingxs.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"com.yingxs.service","com.yingxs.dao","com.yingxs.controller","com.yingxs.bean"})
public class MainConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }


    /**
     * @Bean标注的方法创建的对象的时候，方法参数的值从容器中获取
     * @param car
     * @return
     */
    @Bean
    public Color color(Car car){
        Color color = new Color();
        return new Color();
    }

}
