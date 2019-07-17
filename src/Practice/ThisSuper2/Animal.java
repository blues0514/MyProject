package Practice.ThisSuper2;

public class Animal {
    String name;
    int age;

    public Animal() {
        this("동물", 0);
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println("이름 : " + name);
        System.out.println("나이 :  " + age);
    }
}
