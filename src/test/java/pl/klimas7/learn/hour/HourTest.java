package pl.klimas7.learn.hour;


import org.junit.Test;

public class HourTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNullArguments() {
        Hour hour = new Hour();

        hour.getMaxHour(null);
    }
}