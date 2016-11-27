package pl.klimas7.learn.formattogenericprogr;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

/**
 * Created by bklimas on 15.11.16.
 */
public class MultipleTest {
    @Test
    public void testMultiple0() throws Exception {
        Multiple multiple = new Multiple();
        assertEquals(1234*12345, multiple.multiple0(1234, 12345));
    }

    @Test
    public void testMultiple1() throws Exception {
        Multiple multiple = new Multiple();
        assertEquals(12345*12345, multiple.multiple1(12345, 12345));
    }

    @Test
    public void testAccumulationMultiple0()
    {
        Multiple multiple = new Multiple();
        int a = 12345689;
        assertEquals(a * a, multiple.accumulationMultiple0(0, a, a));
    }

    @Test
    public void testAccumulationMultiple1()
    {
        Multiple multiple = new Multiple();
        int a = 12345689;
        assertEquals(a * a, multiple.accumulationMultiple1(0, a, a));
    }

    @Test
    public void testAccumulationMultiple2()
    {
        Multiple multiple = new Multiple();
        int a = 12345689;
        assertEquals(a * a, multiple.accumulationMultiple2(0, a, a));
    }
}