package pl.klimas7.codylity;

import org.junit.Test;

import static org.junit.Assert.*;

public class TapeEquilibriumTest {

    @Test
    public void ex0() {
        TapeEquilibrium te = new TapeEquilibrium();
        int solution = te.solution(new int[]{3, 1, 2, 4, 3});
        assertEquals(1, solution);
    }
    @Test
    public void double1() {
        TapeEquilibrium te = new TapeEquilibrium();
        int solution = te.solution(new int[]{-1000,1000});
        assertEquals(2000, solution);
    }
}