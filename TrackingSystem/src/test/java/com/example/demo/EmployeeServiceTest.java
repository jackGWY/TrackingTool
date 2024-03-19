package com.example.demo;

import com.example.demo.Mapper.EmployeeMapper;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Test
    public void testList() {
        List<Employee> list = employeeService.getAll();
        for(Employee em : list) {
            System.out.println(em.toString());
        }
    }

    @Test
    public void testMapper() {
        List<Employee> list = employeeMapper.selectAll();
        for(Employee em : list) {
            System.out.println(em.toString());
        }
    }

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setEmpno(112);
        employee.setHiredate(new Date());
        employee.setJob("dev");
        employee.setEname("franco");
        employee.setSal(6000.0);
        employeeService.save(employee);
       // employeeMapper.insert(employee);
    }

    @Test
    public  void testSelectList() {
        int empno = 112;
        List<Employee> employees = employeeMapper.selectListByEmpno(empno);
        Gson gson = new Gson();
        String strGson = gson.toJson(employees);

        System.out.println(strGson);

        //将list集合反序列化
        Type type =new TypeToken<List<Employee>>(){
        }.getType();

        List<Employee> employeeRes =gson.fromJson(strGson,type);
        System.out.println(employeeRes.toString());

    }
}
