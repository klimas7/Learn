package pl.klimas7.codylity;

import org.junit.Assert;
import org.junit.Test;

public class PermMissingElemTest  {
    @Test
    public void ex0() {
        PermMissingElem permMissingElem = new PermMissingElem();
        int solution = permMissingElem.solution(new int[]{2, 3, 1, 5});
        Assert.assertEquals(4, solution);
    }

    @Test
    public void empty() {
        PermMissingElem permMissingElem = new PermMissingElem();
        int solution = permMissingElem.solution(new int[]{});
        Assert.assertEquals(1, solution);
    }

    @Test
    public void single1() {
        PermMissingElem permMissingElem = new PermMissingElem();
        int solution = permMissingElem.solution(new int[]{1});
        Assert.assertEquals(2, solution);
    }

    @Test
    public void single2() {
        PermMissingElem permMissingElem = new PermMissingElem();
        int solution = permMissingElem.solution(new int[]{2});
        Assert.assertEquals(1, solution);
    }

    @Test
    public void ex1() {
        PermMissingElem permMissingElem = new PermMissingElem();
        int solution = permMissingElem.solution(new int[]{2, 3, 1, 4});
        Assert.assertEquals(5, solution);
    }
}