package pl.klimas7.learn.number;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PrimeTest {
    @Test
    public void testGetPrimes10() {
        Prime prime = new Prime();

        List<Integer> primes = prime.getPrimes(10);
        Assert.assertArrayEquals(primes.toArray(), new Integer[]{2, 3, 5, 7});
    }

    @Test
    public void testGetPrimes30() {
        Prime prime = new Prime();

        List<Integer> primes = prime.getPrimes(30);
        Assert.assertArrayEquals(primes.toArray(), new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29});
    }

    @Test
    public void testGetPrimes100() {
        Prime prime = new Prime();

        List<Integer> primes = prime.getPrimes(100);
        assertEquals(25, primes.size());
    }

    @Test
    public void testCountPrimesBetween() {
        Prime prime = new Prime();

        Long count = prime.countPrimesBetween(10, 30);
        assertEquals(Long.valueOf(6), count);
    }
}