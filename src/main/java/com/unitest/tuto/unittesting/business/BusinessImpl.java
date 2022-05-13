package com.unitest.tuto.unittesting.business;

import com.unitest.tuto.unittesting.data.SomeDataService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BusinessImpl {

    private final SomeDataService someDataService;

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
