package Practice.Overriding;

public class Dog {
    String dog_name;
    int dog_age;

    public Dog(String name, int age) {
        dog_name = name;
        dog_age = age;
    }

    public void bite() { // 매개변수가 없는 bite()메소드
        System.out.println(dog_name + "가 아무도 물지 않았습니다.");
    }

    public void bite(String name) { //매개변수가 1개인 bite() 메소드
        System.out.println(dog_name + " 가 " + name + "를(을) 물었습니다.");
    }

    public void bark() { // 매개변수가 없는 bark() 메소드
        System.out.println("멍멍");
    }
}