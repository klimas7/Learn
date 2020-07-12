package pl.sii.puzzles.devoxx2019;

public class Twisted {
    private final String name;
    Twisted(String name) {
        this.name = name;
    }
    private String name() {
        return name;
    }
    private void reproduce() {
        new Twisted("reproduce") {
            void printName() {
                System.out.println(name());
            }
        }.printName();
    }
    public static void main(String[] args) {
        System.out.println(12345 + 5432l);
        new Twisted("main").reproduce();
    }
}