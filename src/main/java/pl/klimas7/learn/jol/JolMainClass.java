package pl.klimas7.learn.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

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
    }
}
