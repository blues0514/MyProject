package Practice.ThisSuper2;

public class ssMain2 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.print();

        Human human = new Human();
        human.print();

        Boy boy = new Boy();
        boy.print();

        System.out.println();

        Animal tiger = new Animal("호랑이", 8);
        tiger.print();

        Human mary = new Human("성마리", 20);
        mary.print();

        Boy smin = new Boy("백승민", 14);
        smin.print();
    }
}
