package com.yingxs.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JavaBean
 * 定义JavaBean时，成员变量所使用的类型
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("tbl_employee")
public class Employee {

    /**
     * value 指定表中的主键的列名，如果实体属性名和别名一致，可以省略不指定
     * type  指定主键策略
     */
    //@TableId(type = IdType.AUTO)
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    // 写入数据库时 忽略该字段
    @TableField(exist = false)
    private Double salary;

}
