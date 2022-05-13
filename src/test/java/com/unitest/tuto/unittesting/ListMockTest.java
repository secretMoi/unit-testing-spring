package com.unitest.tuto.unittesting;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListMockTest {

    List mock = mock(List.class);

    @Test
    void size_basic() {
        when(mock.size()).thenReturn(5);

        assertEquals(5, mock.size());
    }

    @Test
    void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);

        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    void returnWithParameters() {
        when(mock.get(0)).thenReturn("hey");

        assertEquals("hey", mock.get(0));
        assertNull(mock.get(1));
    }
}
