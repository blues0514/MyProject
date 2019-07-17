package Practice.Overriding;

public class DogMain {
    public static void main(String[] args) {
        Dog yourDog = new Dog("돌돌이", 4);

        yourDog.bark();
        yourDog.bite("우체부");

        Snoopy myDog = new Snoopy();

        myDog.bark(); // 메소드 오버라이딩
        myDog.bite("낸시", 9); // 메소드 오버로딩
    }
}
