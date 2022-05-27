package com.unitest.tuto.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class HamcrestMatcherTest {

    @Test
    void learning() {
        var numbers = Arrays.asList(12, 15, 45);

//        assertThat(numbers, hasSize(3));
        assertThat(numbers)
                .hasSize(3)
                .contains(12, 45)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100)
                .noneMatch(x -> x < 10);

        assertThat("").isEmpty();
        assertThat("abcde")
                .contains("cd")
                .startsWith("ab")
                .endsWith("de");


//        assertThat(numbers, hasItems(12, 45));
//        assertThat(numbers, everyItem(greaterThan(10)));
//        assertThat(numbers, everyItem(lessThan(100)));
//
//        assertThat("", isEmptyString());
//        assertThat("abcde", containsString("cd"));
//        assertThat("abcde", startsWith("ab"));
    }
}
