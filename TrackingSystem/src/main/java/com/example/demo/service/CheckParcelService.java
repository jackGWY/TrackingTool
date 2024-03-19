package com.example.demo.service;

import com.example.demo.Mapper.ParcelMapper;
import com.example.demo.VO.CheckVO;
import com.example.demo.VO.ParcelVO;
import com.example.demo.entity.Guest;
import com.example.demo.entity.Parcel;

import com.example.demo.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CheckParcelService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ParcelMapper parcelMapper;


    @ApiOperation("get availiable parcels by id")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "guestId", required = true, value = "guest id to search info")

    })
    public List<ParcelVO> getParcelById(String guestId) {
        if(guestId == null) {
            logger.error("guest id is null");
        }
        List<Parcel>  parcels = parcelMapper.getParcelById(guestId);

        List<ParcelVO> parcelVOList = new ArrayList<>();
        for(Parcel parcel : parcels) {
            ParcelVO parcelVO = new ParcelVO();
            parcelVO.setId(parcel.getId());
            parcelVO.setName(parcel.getName());
            parcelVO.setGuestId(parcel.getGuestId());
            parcelVO.setGuestName(parcel.getGuestName());
            parcelVO.setStoragePlace(parcel.getStoragePlace());
        }

        return parcelVOList;
    }


    @ApiOperation("get availiable parcels by time")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "time", required = false, value = "date time to update"),
            @ApiImplicitParam(name = "guestId", required = true, value = "guest id to update info"),
            @ApiImplicitParam(name = "guestName", required = false, value = "guest name to update info")

    })
    public Result checkIn(String guestId, String guestName, Date time) {

        CheckVO checkVO = new CheckVO();
        checkVO.setTime(time);
        checkVO.setIsAvailable("available");
        checkVO.setGuestName(guestName);
        checkVO.setGuestId(guestId);

        try{
            parcelMapper.CheckIn(checkVO);
            return Result.success(0);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }


    @ApiOperation(" parcels checkout")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "time", required = false, value = "date time to search"),
            @ApiImplicitParam(name = "guestId", required = true, value = "guest id to search info"),
            @ApiImplicitParam(name = "guestName", required = false, value = "guest name to search info")

    })
    public Result checkOut(String guestId, String guestName, Date time) {
        CheckVO checkVO = new CheckVO();
        checkVO.setTime(time);
        checkVO.setIsAvailable("disAvailable");
        checkVO.setGuestName(guestName);
        checkVO.setGuestId(guestId);

        Result result = new Result<>();

        try{
            parcelMapper.CheckOut(guestId, time , "disavailiable");
            result =  Result.success(0);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Result.error(e.getMessage());
        }

        return result;
    }

    public List<Guest> getParcesAvailiableByTime(Date time) {

        List<Parcel> parcels = parcelMapper.getParcesAvailiable(time,"isAvailable");
        List<Guest> guests = new ArrayList<>();
        for(Parcel parcel : parcels) {
            Guest guest = new Guest();
            guest.setName(parcel.getGuestName());
            guest.setGuestId(parcel.getGuestId());
            guests.add(guest);
        }
        return guests;
    }

}
