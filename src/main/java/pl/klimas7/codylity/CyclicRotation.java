package pl.klimas7.codylity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        List<Integer> integers = Arrays.stream(A).boxed().collect(Collectors.toList());
        Collections.rotate(integers, K);
        return integers.stream().mapToInt(i->i).toArray();
    }
}
