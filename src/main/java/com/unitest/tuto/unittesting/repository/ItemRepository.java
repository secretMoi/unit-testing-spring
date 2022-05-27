package com.unitest.tuto.unittesting.repository;

import com.unitest.tuto.unittesting.data.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {


}
