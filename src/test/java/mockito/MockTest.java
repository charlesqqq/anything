package mockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTest {
    @Test
    public void createMockObject() {
        List mockedList = mock(List.class);
        assertTrue(mockedList instanceof List);

        ArrayList mockedArrayList = mock(ArrayList.class);
        assertTrue(mockedArrayList instanceof List);
        assertTrue(mockedArrayList instanceof ArrayList);
    }

    @Test
    public void configMockObject() {
        List<Integer> mockedList = mock(List.class);

        when(mockedList.add(1)).thenReturn(true);
        when(mockedList.size()).thenReturn(1);

        assertTrue(mockedList.add(1));
        assertFalse(mockedList.add(2));
        assertEquals(mockedList.size(), 1);

        Iterator<String> iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("Hello").thenReturn("Mockito");
        String result = iterator.next().concat(" ").concat(iterator.next());
        assertEquals("Hello Mockito", result);
    }

    @Test
    public void testSpy() {
        List<String> spy = Mockito.spy(new LinkedList<>());
        spy.add("one");
        spy.add("two");

        when(spy.size()).thenReturn(100);

        Assert.assertEquals(spy.get(0), "one");
        Assert.assertEquals(spy.get(1), "two");
        Assert.assertEquals(spy.size(), 100);
    }
}
