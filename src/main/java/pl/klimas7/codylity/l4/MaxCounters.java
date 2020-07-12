package pl.klimas7.codylity.l4;

import java.util.Arrays;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCount = 0, lastUpdate = 0, ci;
        for (int a : A) {
            ci = a - 1;
            if (a <= N) {
                counters[ci] = Math.max(counters[ci], lastUpdate) + 1;
                maxCount = Math.max(maxCount, counters[ci]);
            } else {
                lastUpdate = maxCount;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            counters[i] = Math.max(counters[i], lastUpdate);
        }

        return counters;
    }
}
