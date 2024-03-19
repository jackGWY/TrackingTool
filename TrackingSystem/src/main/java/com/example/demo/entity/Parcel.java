package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.utils.TimeZoneConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("parcel")

@ApiModel(description= "Parcel entity")
public class Parcel {

    @TableField("name")

    @ApiModelProperty(value = "parcel name")
    private String name;

    @TableField("id")
    @ApiModelProperty(value = "parcel id")

    private String id;


    @TableField("guest_name")
    @ApiModelProperty(value = "parcel related to guest name")

    private String guestName;


    @TableField("guest_id")
    @ApiModelProperty(value = "parcel related to guest id")
    private String guestId;


    @TableField("is_available")
    @ApiModelProperty(value = "parcel is availiable, store in locker--> abailiable")
    private String isAvailable;

    @TableField("storage_place")
    @ApiModelProperty(value = "palce where parcel is stored")
    private String storagePlace;

    @JsonFormat(locale = "zh", timezone = TimeZoneConstant.ASIA_SHANGHAI, pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("checkin_time")
    @ApiModelProperty(value = "palce checkin_time")
    private Date CheckInTime;


    @JsonFormat(locale = "zh", timezone = TimeZoneConstant.ASIA_SHANGHAI, pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("checkout_time")
    @ApiModelProperty(value = "palce checkout_time")

    private Date CheckOutTime;

    @JsonFormat(locale = "zh", timezone = TimeZoneConstant.ASIA_SHANGHAI, pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("pickup_time")
    @ApiModelProperty(value = "palce pickup time")

    private Date pickup_time;


}
