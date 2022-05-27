package com.unitest.tuto.unittesting.item;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws JSONException {
        var response = this.restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003}]", response, false);
    }
}
