package pl.klimas7.codylity;

import org.junit.Assert;
import org.junit.Test;

public class FrogJmpTest {
    @Test
    public void ex0() {
        FrogJmp fj = new FrogJmp();
        int jmp = fj.solution(10, 85, 30);
        Assert.assertEquals(3, jmp);
    }

    @Test
    public void ex1() {
        FrogJmp fj = new FrogJmp();
        int jmp = fj.solution(1, 1, 3);
        Assert.assertEquals(0, jmp);
    }
    @Test
    public void ex2() {
        FrogJmp fj = new FrogJmp();
        int jmp = fj.solution(1, 5, 2);
        Assert.assertEquals(2, jmp);
    }

    @Test
    public void small_extreme_jump() {
        FrogJmp fj = new FrogJmp();
        int jmp = fj.solution(1, 2, 10000);
        Assert.assertEquals(1, jmp);
    }
}