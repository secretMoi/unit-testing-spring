package com.unitest.tuto.unittesting;


import com.unitest.tuto.unittesting.business.BusinessImpl;
import com.unitest.tuto.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class BusinessMockTest {

    @InjectMocks
    private BusinessImpl business;

    @Mock
    private SomeDataService dataServiceMock = mock(SomeDataService.class); // création du mock

    @Test
    void calculateSum_basic() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {1,2,3}); // mock les données
        business.setSomeDataService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_emptyArray() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {}); // mock les données
        business.setSomeDataService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_oneValue() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {5}); // mock les données
        business.setSomeDataService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;

        assertEquals(expectedResult, actualResult);
    }
}
