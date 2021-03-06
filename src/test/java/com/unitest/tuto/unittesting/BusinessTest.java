package com.unitest.tuto.unittesting;


import com.unitest.tuto.unittesting.business.BusinessImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BusinessTest {

    @Autowired
    private BusinessImpl business;

    @Test
    public void calculateSum_basic() {
        int actualResult = business.calculateSum(new int [] {1,2,3});
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_emptyArray() {
        int actualResult = business.calculateSum(new int [] {});
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        int actualResult = business.calculateSum(new int [] {5});
        int expectedResult = 5;

        assertEquals(expectedResult, actualResult);
    }
}
