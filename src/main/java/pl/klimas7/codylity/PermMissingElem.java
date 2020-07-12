package pl.klimas7.codylity;

import java.util.Arrays;

public class PermMissingElem {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] + 1 != A[i+1]) {
                return A[i] + 1;
            }
        }
        return A[0] != 1 ? 1 : A[A.length - 1] + 1;
    }
}
