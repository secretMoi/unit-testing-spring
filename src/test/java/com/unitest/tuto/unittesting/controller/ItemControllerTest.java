package com.unitest.tuto.unittesting.controller;

import com.unitest.tuto.unittesting.business.ItemBusinessService;
import com.unitest.tuto.unittesting.controller.ItemController;
import com.unitest.tuto.unittesting.data.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    void dummyItem_basic() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

//        Assertions.assertEquals("Hello World", result.getResponse().getContentAsString());
    }

    @Test
    void itemFromBusinessService_basic() throws Exception {
        when(itemBusinessService.retrieveHardCodedItem()).thenReturn(
                new Item(2, "Item", 10, 10)
        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,name:Item,price:10,quantity:10}"))
                .andReturn();

//        Assertions.assertEquals("Hello World", result.getResponse().getContentAsString());
    }
}
