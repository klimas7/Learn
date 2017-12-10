package pl.klimas7.learn.distance;


import org.junit.Assert;
import org.junit.Test;

public class DistanceTest {
    @Test
    public void testGetMin() {
        Distance distance = new Distance(new Integer[]{5,123,128,300,356,3});

        Integer max = distance.getMin();
        Assert.assertEquals(Integer.valueOf(2), max);
    }

    @Test
    public void testGetMin2() {
        Distance distance = new Distance(new Integer[]{1,1});

        Integer max = distance.getMin();
        Assert.assertEquals(Integer.valueOf(0), max);
    }
}