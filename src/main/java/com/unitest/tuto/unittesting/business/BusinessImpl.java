package com.unitest.tuto.unittesting.business;

import com.unitest.tuto.unittesting.data.SomeDataService;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Setter
public class BusinessImpl {

    private SomeDataService someDataService;

    public int calculateSum(int[] data) {
        int sum = 0;

        for(int value : data) {
            sum += value;
        }

        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();

        for(int value : data) {
            sum += value;
        }

        return sum;
    }
}
