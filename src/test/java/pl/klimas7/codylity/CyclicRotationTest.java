package pl.klimas7.codylity;


import org.junit.Assert;
import org.junit.Test;

public class CyclicRotationTest {

    @Test
    public void ex1() {
        CyclicRotation cr = new CyclicRotation();

        int[] solution = cr.solution(new int[]{3, 8, 9, 7, 6}, 3);
        Assert.assertArrayEquals(new int[]{9, 7, 6, 3, 8}, solution);
    }

    @Test
    public void extreme_empty() {
        CyclicRotation cr = new CyclicRotation();

        int[] solution = cr.solution(new int[0], 3);

        Assert.assertArrayEquals(new int[]{}, solution);
    }

    @Test
    public void double_test() {
        CyclicRotation cr = new CyclicRotation();
        int[] solution = cr.solution(new int[]{5,-1000}, 1);
        Assert.assertArrayEquals(new int[]{-1000, 5},solution);
    }
}