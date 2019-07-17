package Practice.ThisSuper;

public class Sub extends Super {
    public void print() {
        System.out.println("서브클래스");
    }

    public void callSuperThis() {
        super.print(); // Super 클래스의 print() 메소드
        this.print(); // Sub 클래스의 print() 메소드
    }
}
