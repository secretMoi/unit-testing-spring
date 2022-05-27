package com.unitest.tuto.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;

class HamcrestMatcherTest {

    @Test
    void learning() {
        var numbers = Arrays.asList(12, 15, 45);

        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(12, 45));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(100)));

        assertThat("", isEmptyString());
        assertThat("abcde", containsString("cd"));
        assertThat("abcde", startsWith("ab"));
    }
}
