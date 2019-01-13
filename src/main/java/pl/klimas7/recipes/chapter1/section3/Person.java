package pl.klimas7.recipes.chapter1.section3;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person(Person person)
    {
        this.name = person.name;
    }

    public Person(String... names)
    {
        System.out.println("Varargs ctor, names=" + Arrays.toString(names));
        this.name = Arrays.asList(names).stream().collect(Collectors.joining(" "));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
