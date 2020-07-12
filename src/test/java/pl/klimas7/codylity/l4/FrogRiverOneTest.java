package pl.klimas7.codylity.l4;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrogRiverOneTest {
    @Test
    public void ex0() {
        FrogRiverOne fro = new FrogRiverOne();
        int solution = fro.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
        assertEquals(6, solution);
    }

    @Test
    public void simple() {
        FrogRiverOne fro = new FrogRiverOne();
        int solution = fro.solution(2, new int[]{2, 2, 2, 2, 2});
        assertEquals(-1, solution);
    }

    @Test
    public void simple2() {
        FrogRiverOne fro = new FrogRiverOne();
        int solution = fro.solution(3, new int[]{1, 3, 1, 3, 2, 1, 3});
        assertEquals(4, solution);
    }

    @Test
    public void single() {
        FrogRiverOne fro = new FrogRiverOne();
        int solution = fro.solution(1, new int[]{1});
        assertEquals(0, solution);
    }

}