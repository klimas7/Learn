package pl.klimas7.codylity.l4;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MissingInteger {
    public int solution(int[] A) {
        HashSet<Integer> hset = new HashSet<Integer>();

        for (int value : A) {
            hset.add(value);
        }

        int num = 1;
        while (hset.contains(num)) {
            num++;
        }

        return num;
    }

    public int solution1(int[] A) {
        Set<Integer> aSet = new TreeSet();
        for (int a : A) {
            aSet.add(a);
        }

        for (int i = 1; i <= A.length; i++) {
            if (!aSet.contains(i)) {
                return i;
            }
        }

        if (aSet.size() == A.length) {
            return A.length + 1;
        }

        return 1;
    }
}
