package pl.klimas7.codylity.l4;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxCountersTest {
    @Test
    public void ex1() {
        MaxCounters mc = new MaxCounters();
        int[] solution = mc.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, solution);
    }
}