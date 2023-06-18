package com.example.demo.service;

import com.example.demo.Mapper.EmployeeMapper;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public void save(Employee employee) {
        try {
            employeeMapper.insert(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
