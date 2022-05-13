package com.unitest.tuto.unittesting;


import com.unitest.tuto.unittesting.business.BusinessImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusinessTest {

    @Test
    public void calculateSum_basic() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int [] {1,2,3});
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_emptyArray() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int [] {});
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int [] {5});
        int expectedResult = 5;

        assertEquals(expectedResult, actualResult);
    }
}
