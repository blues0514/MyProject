package Practice.Inheritance;

public class InheritanceMain {
    public static void main(String[] args) {
        Manager mng = new Manager("이준형", 50000000, "개발부"); // Manager 클래스의 객체를 생성, 이름, 월급, 부서를 인수로 전달

        mng.getInformation(); // Manger클래스의 getInformation()메소드 호출
    }
}
