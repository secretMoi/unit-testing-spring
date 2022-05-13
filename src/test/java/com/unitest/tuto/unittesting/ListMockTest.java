package com.unitest.tuto.unittesting;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ListMockTest {

    List<String> mock = mock(List.class);

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

    @Test
    void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("hey");

        assertEquals("hey", mock.get(0));
        assertEquals("hey", mock.get(1));
    }

    @Test
    void verificationBasics() {

        String value1 = mock.get(0);
        String value2 = mock.get(1);

        // verify, vérifie une valeur qui n'est pas retournée
        // verify().get() vérifie la méthode get() du mock
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    void argumentCapturing() {
        mock.add("string");

        // capteur d'argument pour un argument de type String
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(argumentCaptor.capture()); // verify().add() vérifie la méthode add() du mock

        assertEquals("string", argumentCaptor.getValue());
    }
}
