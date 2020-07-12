package pl.klimas7.codylity;

import java.util.Arrays;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i += 2) {
            if (A[i] != A[i+1]) {
                return A[i];
            }

        }
        return A[A.length - 1];
    }
}
