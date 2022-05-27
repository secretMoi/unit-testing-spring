package com.unitest.tuto.unittesting.item.data;

import com.unitest.tuto.unittesting.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void testFindAll() {
        var items = itemRepository.findAll();

        assertEquals(3 , items.size());
    }
}
