package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.utils.TimeZoneConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("room")
public class Room {

    @TableField("Room_num")
    private String RoomNum;

    @TableField("Room_name")
    private String RoomName;

    @JsonFormat(locale = "zh", timezone = TimeZoneConstant.ASIA_SHANGHAI, pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("checkin_time")
    private Date CheckInTime;


    @JsonFormat(locale = "zh", timezone = TimeZoneConstant.ASIA_SHANGHAI, pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("checkout_time")
    private Date CheckOutTime;

    @TableField("guest_name")
    private String guestName;

    @TableField("is_available")
    private String isAvailable;
}
