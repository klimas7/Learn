package pl.klimas7.codylity;

import org.junit.Assert;
import org.junit.Test;

public class OddOccurrencesInArrayTest {

    @Test
    public void oneElement() {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int solution = oddOccurrencesInArray.solution(new int[]{1});

        Assert.assertEquals(1, solution);
    }

    @Test
    public void threeElement() {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int solution = oddOccurrencesInArray.solution(new int[]{2,2, 1});

        Assert.assertEquals(1, solution);
    }

    @Test
    public void ex0() {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int solution = oddOccurrencesInArray.solution(new int[]{0, 3, 0, 3, 0, 7, 9, 0, 9});

        Assert.assertEquals(7, solution);
    }

    @Test
    public void ex1() {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int solution = oddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9});

        Assert.assertEquals(7, solution);
    }

    @Test
    public void ex2() {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int solution = oddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 9, 7, 7, 11});

        Assert.assertEquals(11, solution);
    }

    @Test
    public void ex3() {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int solution = oddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 9, 7, 7, 11, 12, 12, 12, 12});

        Assert.assertEquals(11, solution);
    }
}