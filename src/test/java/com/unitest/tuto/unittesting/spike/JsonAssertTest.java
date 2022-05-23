package com.unitest.tuto.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1,             \"name\":\"Ball\",\"price\":10,\"quantity\":100}";

        JSONAssert.assertEquals(expectedResponse, actualResponse, true); // pas strict sur les espaces mais si toutes les données sont bien remplies
    }

    @Test
    void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,             \"name\":\"Ball\",\"price\":10}";

        JSONAssert.assertEquals(expectedResponse, actualResponse, false); // pas strict sur les espaces mais si toutes les données sont bien remplies
    }

    @Test
    void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1,name:\"Ball\",price:10}";

        JSONAssert.assertEquals(expectedResponse, actualResponse, false); // pas strict sur les espaces mais si toutes les données sont bien remplies
    }
}
