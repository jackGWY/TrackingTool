package com.example.demo.controller;


import com.example.demo.service.CheckParcelService;
import com.example.demo.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@RestController
@RequestMapping("/parcel")
@Api(value="check in /out controller",tags={"use check in /out"})
public class CheckInOutController {

    @Autowired
    CheckParcelService checkParcelService;


    @GetMapping("/checkin")
    @ApiOperation("get availiable parcels by time")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "time", required = false, value = "date time to search"),
            @ApiImplicitParam(name = "guestId", required = true, value = "guest id to search info"),
            @ApiImplicitParam(name = "guestName", required = false, value = "guest name to search info")

    })
    public Result checkIn( String guestId, String guestName, Date time) {

        if(guestId == null) {
            return Result.error("guest id should not null!");
        }

        return checkParcelService.checkIn(guestId,guestName,time);
    }

    @GetMapping("/checkout")
    @ApiOperation("get availiable parcels by time")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "time", required = false, value = "date time to update"),
            @ApiImplicitParam(name = "guestId", required = true, value = "guest id to update info"),
            @ApiImplicitParam(name = "guestName", required = false, value = "guest name to update info")

    })
    public Result checkOut( String guestId, String guestName, Date time) {

        if(guestId == null) {
            return Result.error("guest id should not null!");
        }

        return checkParcelService.checkOut(guestId,guestName,time);
    }



}
