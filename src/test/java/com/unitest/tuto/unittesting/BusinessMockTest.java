package com.unitest.tuto.unittesting;


import com.unitest.tuto.unittesting.business.BusinessImpl;
import com.unitest.tuto.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BusinessMockTest {

    private BusinessImpl business;

    @BeforeEach
    private void setTestEnvironment() {
        business = new BusinessImpl();
    }

    @Test
    public void calculateSum_basic() {

        var dataServiceMock = mock(SomeDataService.class); // création du mock
        when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {1,2,3}); // mock les données
        business.setSomeDataService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_emptyArray() {

        var dataServiceMock = mock(SomeDataService.class); // création du mock
        when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {}); // mock les données
        business.setSomeDataService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        var dataServiceMock = mock(SomeDataService.class); // création du mock
        when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {5}); // mock les données
        business.setSomeDataService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;

        assertEquals(expectedResult, actualResult);
    }
}
