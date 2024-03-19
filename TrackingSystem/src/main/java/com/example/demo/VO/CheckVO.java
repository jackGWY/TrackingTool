package com.example.demo.VO;

import lombok.Data;

import java.util.Date;

@Data
public class CheckVO {

    private String guestId;

    private String guestName;

    private Date time;

    private String isAvailable;

    private String storagePlace;
}
