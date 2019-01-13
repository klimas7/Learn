package pl.klimas7.learn.staticclass;

import java.util.ArrayList;
import java.util.List;

public class Parent {

    public void test() {
        System.out.println("In Parent");
    }

    public static class Child {
        private List<String> temp = new ArrayList<>();

        public void test() {
            temp.add("xyz");
            System.out.println(temp.size());
        }
    }
}
