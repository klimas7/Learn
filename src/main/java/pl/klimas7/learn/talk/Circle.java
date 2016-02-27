package pl.klimas7.learn.talk;

class Circle extends Shape {
    public Circle() {
        System.out.println("a circle");
    }

    @Override
    public String toString() {
        return "I'm a circle";
    }
}