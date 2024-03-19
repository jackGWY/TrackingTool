package com.example.demo.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class ParcelVO {

    private String name;

    private String id;

    private String guestName;

    private String guestId;

    private String isAvailable;

    private String storagePlace;
}
