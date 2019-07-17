package Practice.Overriding;

public class Snoopy extends Dog {

    public Snoopy() { // Dog 클래스의 생성자에게 이름과 나이를 전달
        super("스누피", 3);
    }

    public void bite(String name, int age) {
        System.out.println(dog_name + "를 문 " + name + "는 " + age + "살 입니다. (메소드 오버로딩)");
    }

    public void bark() {
        System.out.println("안녕하세요," + dog_name + "입니다. (메소드 오버라이딩)");
    }
}
