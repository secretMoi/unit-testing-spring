package com.unitest.tuto.unittesting.item.service;

import com.unitest.tuto.unittesting.business.ItemBusinessService;
import com.unitest.tuto.unittesting.controller.ItemController;
import com.unitest.tuto.unittesting.data.Item;
import com.unitest.tuto.unittesting.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
 class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    void calculateSumUsingDataService_basic() {
        when(itemRepository.findAll()).thenReturn(
                List.of(
                        new Item(2, "Item", 10, 10, 0),
                        new Item(3, "Item3", 20, 20, 0)
                )
        );

        var items = itemBusinessService.retrieveAllItems();

        assertEquals(100, items.get(0).getValue());
        assertEquals(400, items.get(1).getValue());
    }
}
