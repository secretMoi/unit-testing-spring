package com.unitest.tuto.unittesting.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Item {

    private int id;
    private String name;
    private int price;
    private int quantity;

    public String toString() {
        return String.format("Item[%d, %s, %d, %d]", this.id, this.name, this.price, this.quantity);
    }
}
