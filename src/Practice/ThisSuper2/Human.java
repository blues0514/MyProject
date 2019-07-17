package Practice.ThisSuper2;

public class Human extends Animal {
    public Human() {
        this("인간", 0);
    }

    public Human(String name, int age) {
        super(name, age);
    }
}
