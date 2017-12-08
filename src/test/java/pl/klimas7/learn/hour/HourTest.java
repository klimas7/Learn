package pl.klimas7.learn.hour;


import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

public class HourTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullArguments() {
        Hour hour = new Hour();

        hour.getMaxHour(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotEnoughArguments() {
        Hour hour = new Hour();

        hour.getMaxHour(0, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongMajorHour() {
        Hour hour = new Hour();

        hour.getMaxHour(3, 4, 5, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongMajorMinut() {
        Hour hour = new Hour();

        hour.getMaxHour(2, 3, 6, 6);
    }

    @Test
    public void testGetMaxHourA() {
        Hour hour = new Hour();

        LocalTime maxHour = hour.getMaxHour(0, 0, 2, 3);

        Assert.assertEquals(LocalTime.of(23, 00), maxHour);
    }

    @Test
    public void testGetMaxHourB() {
        Hour hour = new Hour();

        LocalTime maxHour = hour.getMaxHour(9, 1, 5, 9);

        Assert.assertEquals(LocalTime.of(19, 59), maxHour);
    }

    @Test
    public void testGetMaxHourC() {
        Hour hour = new Hour();

        LocalTime maxHour = hour.getMaxHour(0, 0, 0, 0);

        Assert.assertEquals(LocalTime.of(0, 0), maxHour);
    }
}