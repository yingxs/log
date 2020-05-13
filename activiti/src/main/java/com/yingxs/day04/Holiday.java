package com.yingxs.day04;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请假实体类
 */

@Data
public class Holiday implements Serializable {

    private Integer id;
    private String holidayName; // 申请人名字
    private Date beginDate; // 开始时间
    private Date endDate; // 结束日期
    private Float num ; // 请假天数
    private String reason; // 事由
    private String type;  //请假类型

}
