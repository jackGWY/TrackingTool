package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.demo.VO.CheckVO;
import com.example.demo.entity.Parcel;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface ParcelMapper extends BaseMapper<Parcel> {


    @Select("SELECT * FROM parcel where guest_id = #{guestId}")
    List<Parcel> getParcelById(@Param("guestId") String guestId);



    @Insert("INSERT INTO parcel(name, id , checkin_time) VALUES (#{guestId},#{guestName},#{time}) ")
    void CheckIn(CheckVO checkVO);

    @Update("UPDATE parcel SET is_available = #{isAvailable}, checkout_time = #{time}  WHERE id = #{guestId}")
    void CheckOut(@Param("guestId")String guestId, @Param("time")Date time, String isAvailable );

    @Select("SELECT * FROM parcel WHERE is_available = #{isAvailable} AND checkout_time > #{time} and checkin_time < #{time} ")
    List<Parcel> getParcesAvailiable (@Param("time")Date time, @Param("isAvailable") String isAvailable);
}
