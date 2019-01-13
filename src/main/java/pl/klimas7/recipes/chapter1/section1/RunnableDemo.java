package pl.klimas7.recipes.chapter1.section1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class RunnableDemo {
    public static void main(String[] args) {
        threadExample();
        fileFilterExample();
    }

    private static void fileFilterExample() {
        File directory = new File("./src/main/java/pl/klimas7/recipes/chapter1");

        String[] names = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        System.out.println(Arrays.asList(names));

        names = directory.list(((dir, name) -> name.endsWith(".java")));
        System.out.println(Arrays.asList(names));

        //Type set explicite
        names = directory.list(((File dir, String name) -> name.endsWith(".java")));
        System.out.println(Arrays.asList(names));

        //Block lambda
        names = directory.list(((File dir, String name) -> {
            return  name.endsWith(".java");
        }));

        System.out.println(Arrays.asList(names));
    }

    private static void threadExample() {
        //Basic method
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Implement interface in anonymous class");
            }
        }).start();

        new Thread(() -> System.out.println("Lambda in thread constructor")).start();

        Runnable lambda = () -> System.out.println("Lambda implements run method");
        new Thread(lambda).start();
    }
}
