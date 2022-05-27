package com.unitest.tuto.unittesting.business;

import com.unitest.tuto.unittesting.data.SomeDataService;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Setter
public class BusinessImpl {

    private SomeDataService someDataService;

    public int calculateSum(int[] data) {
        // 1, 2, 3, 4 => 1 + 2 + 3 + 4
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService() {
        int[] data = someDataService.retrieveAllData();

        // 1, 2, 3, 4 => 1 + 2 + 3 + 4
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }
}
