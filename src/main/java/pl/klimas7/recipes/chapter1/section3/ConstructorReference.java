package pl.klimas7.recipes.chapter1.section3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ConstructorReference {
    public static List<String> names = Arrays.asList("Grace Hopper", "Ada Lovelance", "Uncle Bob", "Barbara Liskov");

    public static void main(String[] args) {

        basicExample();
        copyConstructorUsing();
        multiParameterConstructor();
        arrays();
    }

    private static void arrays() {
        Person[] persons = names.stream()
                .map(Person::new)
                .toArray(Person[]::new);

        System.out.println(persons);

    }

    private static void multiParameterConstructor() {
        names.stream()
                .map(name -> name.split(" "))
                .map(Person::new)
                .collect(Collectors.toList());
    }

    private static void copyConstructorUsing() {
        Person before = new Person("Grace Hopper");

        List<Person> persons = Stream.of(before).collect(Collectors.toList());
        Person after = persons.get(0);

        assertTrue(before == after);
        before.setName("Grace Murray Hopper");
        assertEquals("Grace Murray Hopper", after.getName());


        persons = Stream.of(before)
                .map(Person::new)
                .collect(Collectors.toList());

        after = persons.get(0);
        assertFalse(before == after);
        assertEquals(before, after);

        before.setName("Dr Grace Murray Hopper");
        assertFalse(before.equals(after));


    }

    private static void basicExample() {
        List<Person> persons = names.stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());

        List<Person> persons2 = names.stream()
                .map(Person::new)
                .collect(Collectors.toList());

        List<String> names2 = persons.stream()
                .map(person -> person.getName())
                .collect(Collectors.toList());

        List<String> names3 = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }
}
