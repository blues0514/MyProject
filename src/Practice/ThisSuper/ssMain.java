package Practice.ThisSuper;

public class ssMain {
    public static void main(String[] args) {
        Super superclass = new Super();

        System.out.print("Super클래스의 print()메소드 :");
        superclass.print();

        Sub subclass = new Sub();

        System.out.print("Sub클래스의 print()메소드 :");
        subclass.print();

        System.out.println("Sub클래스에서 suepr,this로 호출");
        subclass.callSuperThis();
    }
}
