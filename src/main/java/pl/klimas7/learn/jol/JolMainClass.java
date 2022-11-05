package pl.klimas7.learn.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.LinkedList;
import java.util.List;

public class JolMainClass {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(Course.class).toPrintable());
        System.out.println(ClassLayout.parseClass(Professor.class).toPrintable());

        String ds = "Data Structures";
        Course course = new Course(ds);

        System.out.println("The shallow size is: " + VM.current().sizeOf(course));

        System.out.println(ClassLayout.parseInstance(ds).toPrintable());
        System.out.println(ClassLayout.parseInstance(course).toPrintable());

        System.out.println(GraphLayout.parseInstance(course).toFootprint());

        System.out.println(GraphLayout.parseInstance(course).totalSize());


        System.out.println("===========");
        List<Integer> aList = new LinkedList<>();
        for (int i = 0; i < 1024; i++) {
            aList.add(i);
        }

        System.out.println("The shallow size is: " + VM.current().sizeOf(aList));
        System.out.println(ClassLayout.parseInstance(aList).toPrintable());
        System.out.println(GraphLayout.parseInstance(aList).toFootprint());

        System.out.println(GraphLayout.parseInstance(aList).totalSize());
    }
}
