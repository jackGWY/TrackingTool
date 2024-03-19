package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("storage")
public class StoragePlace {

    @TableField("locker_name")
    private String lockerName;

    @TableField("locker_id")
    private String lockerId;
}
