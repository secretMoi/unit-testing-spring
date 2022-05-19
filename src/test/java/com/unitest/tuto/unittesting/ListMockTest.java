package com.unitest.tuto.unittesting;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
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

    @Test
    void multipleArgumentsCapturing() {
        mock.add("string");
        mock.add("string2");

        // capteur d'argument pour un argument de type String
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(argumentCaptor.capture()); // verify().add() vérifie la méthode add() du mock + times(2) car 2 appels à add()

        List<String> allValues = argumentCaptor.getAllValues();
        assertEquals("string", allValues.get(0));
        assertEquals("string2", allValues.get(1));
    }

    @Test
    public void mocking() {
        var arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0
        System.out.println(arrayListMock.add("Test")); // false
        System.out.println(arrayListMock.add("Test2")); // false
        System.out.println(arrayListMock.size()); // 0

        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); // 5
    }

    /*
    Spy retient l'état de la liste par rapport au mock
     */
    @Test
    public void spying() {
        var arrayListSpy = spy(ArrayList.class);
        System.out.println(arrayListSpy.add("Test0")); // true
        System.out.println(arrayListSpy.get(0)); // Test0
        System.out.println(arrayListSpy.size()); // 1
        System.out.println(arrayListSpy.add("Test")); // true
        System.out.println(arrayListSpy.add("Test2")); // true
        System.out.println(arrayListSpy.size()); // 3

        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5

        verify(arrayListSpy).add("Test2");
    }
}
