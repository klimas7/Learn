package pl.klimas7.learn.formattogenericprogr;

import java.math.BigInteger;

/**
 * Created by bklimas on 15.11.16.
 */
public class Multiple {
    /**
     *  1a = a
     *  (n + 1)a = na + a
     */
    public int multiple0(int n, int a) {
        if (n == 1) return a;
        return multiple0(n - 1, a) + a;
    }

    public int multiple1(int n, int a) {
        if (n == 1) return a;
        int answer = multiple1(half(n), a + a);
        if (odd(n)) answer = answer + a;
        return answer;
    }

    public int accumulationMultiple0(int r, int n, int a) {
        if (n == 1) return r + a;
        if (odd(n)) {
            return accumulationMultiple0(r + a, half(n), a + a);
        }
        else {
            return accumulationMultiple0(r, half(n), a + a);
        }
    }

    public int accumulationMultiple1(int r, int n, int a) {
        if (n == 1) return r + a;
        if (odd(n)) {
            r = r + a;
        }
        return accumulationMultiple1(r, half(n), a + a);
    }

    public int accumulationMultiple2(int r, int n, int a) {
        if (odd(n)) {
            r = r + a;
            if (n == 1) return r;
        }
        return accumulationMultiple2(r, half(n), a + a);
    }


    private boolean odd(int n) {
        return (n & 0x1) == 1;
    }

    private int half(int n) {
        return n >> 1;
    }
}
