package pl.klimas7.learn.project44;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LinkedListSize {
    public static void main(String[] args) {
        var map = new HashMap<String, String>();
        map.put("1", "x");
        map.put("2", "x");
        map.put("3", "x");
        map.put("4", "x");
        map.put("5", "x");
        map.put("6", "x");
        map.put("7", "x");
        map.put("8", "x");
        map.put("9", "x");
        map.put("10", "x");
        map.put("11", "x");
        map.put("12", "x");
        System.out.println(map.get("12"));
//        map.put("13", "x");
//        map.put("14", "x");

        map.forEach((k, v) -> System.out.println(k + " " + v));

        List<Integer> aList = new LinkedList<>();
        for (int i = 0; i < 1024; i++) {
            aList.add(i);
        }
        System.out.println("ccc");
    }
}
