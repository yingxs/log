package com.yingxs.mp.beans;

import lombok.Data;

/**
 * JavaBean
 * 定义JavaBean时，成员变量所使用的类型
 *
 */
@Data
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

}
