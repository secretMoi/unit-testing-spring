package com.unitest.tuto.unittesting.business;

import com.unitest.tuto.unittesting.data.Item;
import com.unitest.tuto.unittesting.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemBusinessService {

    private final ItemRepository itemRepository;

    public List<Item> retrieveAllItems() {
        var items = itemRepository.findAll();

        for(var item: items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }

        return items;
    }

    public Item retrieveHardCodedItem() {
        return new Item(1, "Ball", 10, 100, 0);
    }
}
