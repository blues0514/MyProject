package Practice.AccessAuthority;

public class AccessMain {
    public static void main(String[] args) {
        D d = new D();
        E e = new E();
        F f = new F();

        d.a = 500; // 외부클래스에서 접근가능
        //e.b = 500; private는 외부 클래스에서 접근 불가능
        //f.c = 500; protected는 외부 클래스에서 접근 불가능

        d.method_A(); // 외부 클래스에서 접근 가능
        //e.method_B(); // private는 외부 클래스에서 접근 불가능
        //f.method_C(); // protected는 외부 클래스에서 접근 불가능

        d.method_D(); // 외부 클래스에서 접근 가능
        e.method_E(); // 외부 클래스에서 접근 가능
        f.method_F(); // 외부 클래스에서 접근 가능

        System.out.println("a = " + d.a); //외부 클래스에서 접근 가능
        // System.out.println("b = " + e.b); // private는 외부 클래스에서 접근 불가능
        // System.out.println("c = " + f.c); // protected는 외부 클래스에서 접근 불가능

    }
}
