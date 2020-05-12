package com.yingxs.mp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yingxs.mp.beans.Employee;

/**
 * Mapper接口
 *
 * 基于MP 让Mapper接口继承BaseMapper接口即可
 * 泛型为当前Mapper接口所操作的实体类型
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
}
