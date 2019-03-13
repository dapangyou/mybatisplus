package com.hujia.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hujia.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {
    //insert(Employee employee)
    // <insert useGeneratedKeys = true keyProperties = >

    //mybatis的批量更新的demo 将表中的age字段更新为3,4,5
    int batchUpdate(@Param("list")List<Employee> list);

    //mybatis的批量查询
    List<Employee> selectEmployeeByIds(@Param("ids")List<Integer> ids);
}
