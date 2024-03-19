package com.example.demo.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.demo.service.CheckParcelService;

import java.util.ArrayList;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ParcelController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ParcelControllerTest {
    @MockBean
    private CheckParcelService checkParcelService;

    @Autowired
    private ParcelController parcelController;

    /**
     * Method under test: {@link ParcelController#getParcesAvailiableByTime(Date)}
     */
    @Test
    public void testGetParcesAvailiableByTime() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/parcel/findGuestByTime");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("time", String.valueOf((Object) null));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(parcelController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link ParcelController#getParcleById(String)}
     */
    @Test
    public void testGetParcleById() throws Exception {
        when(checkParcelService.getParcelById((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/parcel/findById")
                .param("guestId", "foo");
        MockMvcBuilders.standaloneSetup(parcelController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"code\":0,\"msg\":\"success\",\"value\":[]}"));
    }

    /**
     * Method under test: {@link ParcelController#getParcleById(String)}
     */
    @Test
    public void testGetParcleById2() throws Exception {
        when(checkParcelService.getParcelById((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/parcel/findById")
                .param("guestId", null);
        MockMvcBuilders.standaloneSetup(parcelController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"code\":0,\"msg\":\"guestId is null\",\"value\":null}"));
    }
}

