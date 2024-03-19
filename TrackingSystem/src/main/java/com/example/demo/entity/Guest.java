package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("guest")
public class Guest {

    @TableField("id")
    private String guestId;

    @TableField("name")
    private String Name;

}
