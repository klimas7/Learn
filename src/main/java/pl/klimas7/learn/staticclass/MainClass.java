package pl.klimas7.learn.staticclass;

public class MainClass {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.test();
        Parent.Child child =  new Parent.Child();
        child.test();

        Parent.Child child2 =  new Parent.Child();
        child2.test();


    }
}
