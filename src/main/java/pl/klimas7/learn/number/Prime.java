package pl.klimas7.learn.number;

import java.util.ArrayList;
import java.util.List;

public class Prime {

    public Prime() {
    }

    public List<Integer> getPrimes(Integer maxNumber) {
        List<Integer> primes = new ArrayList<>();

        boolean[] sieve = new boolean[maxNumber + 1];
        sieve[0] = sieve[1] = true;
        int currentPrime = 2;
        primes.add(currentPrime);

        boolean endSieve = false;
        do {
            for (int i = currentPrime + currentPrime; i <= maxNumber; ) {
                sieve[i] = true;
                i += currentPrime;
            }
            for (int i = currentPrime + 1; i <= maxNumber; i++) {
                if (!sieve[i]) {
                    currentPrime = i;
                    primes.add(currentPrime);
                    break;
                }
                if (i == maxNumber) {
                    endSieve = true;
                    break;
                }
            }
        } while (!endSieve);

        return primes;
    }

    public Long countPrimesBetween(Integer begin, Integer end) {
        List<Integer> primes = getPrimes(end);
        return primes.stream().filter(i -> i >= begin).count();
    }
}
