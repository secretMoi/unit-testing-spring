package com.unitest.tuto.unittesting.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@AllArgsConstructor
@Data
@Entity
public class Item {

    @Id
    private int id;
    private String name;
    private int price;
    private int quantity;

    @Transient // donnée non stockée dans la db
    private int value;

    public String toString() {
        return String.format("Item[%d, %s, %d, %d]", this.id, this.name, this.price, this.quantity);
    }
}
