package com.unitest.tuto.unittesting.business;

import com.unitest.tuto.unittesting.data.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {

    public Item retrieveHardCodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
