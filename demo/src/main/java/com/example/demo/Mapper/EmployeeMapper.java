package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

//    default List<Employee> selectListByEmpno(int empno) {
//        return selectList(new LambdaQueryWrapper<Employee>()
//                .eq(Employee::getEmpno,empno)
//
//        );
//    }

    @Select("SELECT * FROM emp where empno = #{empno}")
    List<Employee> selectListByEmpno(@Param("empno") int empno);
}
