package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.Mapper.ParcelMapper;
import com.example.demo.VO.CheckVO;
import com.example.demo.entity.Guest;
import com.example.demo.entity.Parcel;
import com.example.demo.utils.Result;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CheckParcelService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckParcelServiceTest {
    @Autowired
    private CheckParcelService checkParcelService;

    @MockBean
    private ParcelMapper parcelMapper;

    /**
     * Method under test: {@link CheckParcelService#getParcelById(String)}
     */
    @Test
    public void testGetParcelById() {
        when(parcelMapper.getParcelById((String) any())).thenReturn(new ArrayList<>());
        assertTrue(checkParcelService.getParcelById("42").isEmpty());
        verify(parcelMapper).getParcelById((String) any());
    }

    /**
     * Method under test: {@link CheckParcelService#getParcelById(String)}
     */
    @Test
    public void testGetParcelById2() {
        Parcel parcel = new Parcel();
        parcel.setCheckInTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        parcel.setCheckOutTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        parcel.setGuestId("42");
        parcel.setGuestName("Guest Name");
        parcel.setId("42");
        parcel.setIsAvailable("Is Available");
        parcel.setName("Name");
        parcel.setPickup_time(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        parcel.setStoragePlace("Storage Place");

        ArrayList<Parcel> parcelList = new ArrayList<>();
        parcelList.add(parcel);
        when(parcelMapper.getParcelById((String) any())).thenReturn(parcelList);
        assertTrue(checkParcelService.getParcelById("42").isEmpty());
        verify(parcelMapper).getParcelById((String) any());
    }

    /**
     * Method under test: {@link CheckParcelService#getParcelById(String)}
     */
    @Test
    public void testGetParcelById3() {
        when(parcelMapper.getParcelById((String) any())).thenReturn(new ArrayList<>());
        assertTrue(checkParcelService.getParcelById(null).isEmpty());
        verify(parcelMapper).getParcelById((String) any());
    }

    /**
     * Method under test: {@link CheckParcelService#checkIn(String, String, Date)}
     */
    @Test
    public void testCheckIn() {
        doNothing().when(parcelMapper).CheckIn((CheckVO) any());
        Result actualCheckInResult = checkParcelService.checkIn("42", "Guest Name",
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        assertEquals(0, actualCheckInResult.getCode());
        assertNull(actualCheckInResult.getValue());
        assertEquals("success", actualCheckInResult.getMsg());
        verify(parcelMapper).CheckIn((CheckVO) any());
    }

    /**
     * Method under test: {@link CheckParcelService#checkOut(String, String, Date)}
     */
    @Test
    public void testCheckOut() {
        doNothing().when(parcelMapper).CheckIn((CheckVO) any());
        Result actualCheckOutResult = checkParcelService.checkOut("42", "Guest Name",
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        assertEquals(0, actualCheckOutResult.getCode());
        assertNull(actualCheckOutResult.getValue());
        assertEquals("success", actualCheckOutResult.getMsg());
        verify(parcelMapper).CheckIn((CheckVO) any());
    }

    /**
     * Method under test: {@link CheckParcelService#getParcesAvailiableByTime(Date)}
     */
    @Test
    public void testGetParcesAvailiableByTime() {
        when(parcelMapper.getParcesAvailiable((Date) any(), (String) any())).thenReturn(new ArrayList<>());
        assertTrue(
                checkParcelService
                        .getParcesAvailiableByTime(
                                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                        .isEmpty());
        verify(parcelMapper).getParcesAvailiable((Date) any(), (String) any());
    }

    /**
     * Method under test: {@link CheckParcelService#getParcesAvailiableByTime(Date)}
     */
    @Test
    public void testGetParcesAvailiableByTime2() {
        Parcel parcel = new Parcel();
        parcel.setCheckInTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        parcel.setCheckOutTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        parcel.setGuestId("42");
        parcel.setGuestName("isAvailable");
        parcel.setId("42");
        parcel.setIsAvailable("isAvailable");
        parcel.setName("isAvailable");
        parcel.setPickup_time(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        parcel.setStoragePlace("isAvailable");

        ArrayList<Parcel> parcelList = new ArrayList<>();
        parcelList.add(parcel);
        when(parcelMapper.getParcesAvailiable((Date) any(), (String) any())).thenReturn(parcelList);
        List<Guest> actualParcesAvailiableByTime = checkParcelService.getParcesAvailiableByTime(
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        assertEquals(1, actualParcesAvailiableByTime.size());
        Guest getResult = actualParcesAvailiableByTime.get(0);
        assertEquals("42", getResult.getGuestId());
        assertEquals("isAvailable", getResult.getName());
        verify(parcelMapper).getParcesAvailiable((Date) any(), (String) any());
    }
}

