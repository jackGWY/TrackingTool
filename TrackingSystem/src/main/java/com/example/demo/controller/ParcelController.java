package com.example.demo.controller;


import com.example.demo.VO.ParcelVO;

import com.example.demo.entity.Guest;
import com.example.demo.entity.Parcel;
import com.example.demo.service.CheckParcelService;
import com.example.demo.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/parcel")
@Api(value="parcel controller",tags={"get parcel, save parcel"})
public class ParcelController {

    @Autowired
    CheckParcelService checkParcelService;

    @GetMapping("/findById")
    @ApiOperation("get parcles by guest id")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "guestId", required = true, value = "guest id")
    })
    public Result getParcleById(String guestId) {

        if(guestId == null) {
            return Result.error("guestId is null");
        }

        List<ParcelVO> parcelVOS = checkParcelService.getParcelById(guestId);
        Result result = new Result<>();
        result.setMsg("success");
        result.setCode(0);

        result.setValue(parcelVOS);
        return result;

    }

    @GetMapping("/findGuestByTime")
    @ApiOperation("get availiable parcels by time")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "time", required = true, value = "date time to search"),

    })
    public Result getParcesAvailiableByTime(Date time) {

        if(time == null) {
            return Result.error("input time is null");
        }

        List<Guest> guests = checkParcelService.getParcesAvailiableByTime(time);


        Result result = new Result<>();
        result.setMsg("success");
        result.setCode(0);

        result.setValue(guests);
        return result;

    }


}
