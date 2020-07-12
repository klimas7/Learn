package pl.klimas7.codylity.l5;

import java.util.stream.IntStream;

public class CountDiv {
    public int solution(int A, int B, int K) {
        int offsetForLeftRange = 0;
        if ( A % K == 0) { ++offsetForLeftRange; }

        return  (B/K) - (A /K) + offsetForLeftRange;
    }
}
