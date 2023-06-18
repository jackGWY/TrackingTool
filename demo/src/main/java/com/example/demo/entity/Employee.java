package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.utils.TimeZoneConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("emp")
public class Employee implements Serializable {
    @TableField("empno")
    private Integer empno;

    @TableField("ename")
    private String ename;

    @TableField("job")
    private String job;

    @JsonFormat(locale = "zh", timezone = TimeZoneConstant.ASIA_SHANGHAI, pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("hiredate")
    private Date hiredate;

    @TableField("sal")
    private Double sal;

}
