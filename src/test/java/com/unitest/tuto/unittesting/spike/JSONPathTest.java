package com.unitest.tuto.unittesting.spike;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JSONPathTest {

    @Test
    void learning() {
        String response = "[\n" +
                "  {\n" +
                "    \"id\": 1, \"name\": \"a\", \"quantity\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2, \"name\": \"b\", \"quantity\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 3, \"name\": \"c\", \"quantity\": 3\n" +
                "  }\n" +
                "]";

        var context = JsonPath.parse(response);

        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1, 2, 3);
    }
}
