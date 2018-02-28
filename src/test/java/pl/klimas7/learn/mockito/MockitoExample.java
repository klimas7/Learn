package pl.klimas7.learn.mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;
import static org.mockito.internal.verification.VerificationModeFactory.atMost;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MockitoExample {

    private static  Logger logger = Logger.getLogger(MockitoExample.class.getName());
    @Mock
    SuperClazz superClazz;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Test
    public void exampleAnnotationMockTest() {
        when(superClazz.doSomething("hello")).thenReturn(true);
        boolean test = superClazz.doSomething("hello");
        assertTrue(test);
        verify(superClazz).doSomething("hello");
    }

    @Test
    public void simpleMock() {
        SuperClazz superClazz = mock(SuperClazz.class);
        when(superClazz.doSomething("test")).thenReturn(true);

        assertTrue(superClazz.doSomething("test"));
        assertFalse(superClazz.doSomething("xyz")); //Mockito return default value for boolean when method isn't explicite mock
    }

    @Test
    public void simpleMock2() {
        SuperClazz superClazz = mock(SuperClazz.class);
        when(superClazz.getId()).thenReturn(43);

        assertEquals(superClazz.getId(), 43);
    }

    // demonstrates the return of multiple values
    @Test
    public void testMoreThanOneReturnValue() {
        Iterator<String> iterable = mock(Iterator.class);
        when(iterable.next()).thenReturn("Hello").thenReturn("World");

        String result = iterable.next() + " " + iterable.next();
        assertEquals(result, "Hello World");
    }

    // this test demonstrates how to return values based on the input
    @Test
    public void testReturnValueDependentOnMethodParameter() {
        Comparable<String> comparable = mock(Comparable.class);

        when(comparable.compareTo("Hello")).thenReturn(1);
        when(comparable.compareTo("World")).thenReturn(2);

        assertEquals(1, comparable.compareTo("Hello"));
    }


    // this test demonstrates how to return values independent of the input value
    @Test
    public void testReturnValueInDependentOnMethodParameter() {
        Comparable<Integer> comparable = mock(Comparable.class);

        when(comparable.compareTo(anyInt())).thenReturn(-1);
        assertEquals(-1, comparable.compareTo(2));
    }

    // return a value based on the type of the provide parameter
    @Test
    public void testReturnValueInDependentOnMethodParameter2() {
        Comparable<SuperClazz> comparable = mock(Comparable.class);
        when(comparable.compareTo(isA(SuperClazz.class))).thenReturn(0);

        assertEquals(0,comparable.compareTo( new SuperClazz()));
    }


    @Test
    public void testThrowException() {
        SuperClazz superClazz = mock(SuperClazz.class);
        when(superClazz.doSomething("XXX")).thenThrow( new IllegalArgumentException("Bad argument"));

        try {
            superClazz.doSomething("XXX");
        } catch (IllegalArgumentException ex) {
            logger.info(ex.getMessage());
        }
    }


    @Test
    public void testSpy() {
        List<String> list = spy(new LinkedList<>());
        // throws IndexOutOfBoundsException (list is still empty)
        //when(list.get(0)).thenReturn("xyz");

        doReturn("xyz").when(list).get(0);
        assertEquals("xyz", list.get(0));
    }

    @Test
    public void testVerify() {
        SuperClazz superClazz = mock(SuperClazz.class);
        when(superClazz.getId()).thenReturn(42);

        superClazz.doSomething("xyz");
        superClazz.getId();
        superClazz.getId();
        superClazz.getId();
        superClazz.getId();
        superClazz.getId();


        verify(superClazz).doSomething(ArgumentMatchers.eq("xyz"));
        verify(superClazz, times(5)).getId();


        verify(superClazz, never()).fakeMethod();

        verify(superClazz, atLeastOnce()).doSomething("xyz");
        verify(superClazz, atLeast(2)).getId();
        verify(superClazz, times(5)).getId();
        verify(superClazz, atMost(3)).doSomething("xyz");
        // This let's you check that no other methods where called on this object.
        // You call it after you have verified the expected method calls.
        verifyNoMoreInteractions(superClazz);

    }
}
