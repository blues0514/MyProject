package Practice;

public class CallByValue {
    static int a; // 전역변수 a,b
    static int b;

    public static void swap() {
        int temp = a;
        a = b; // 전연변수에 바로 저장
        b = temp;
    }

    public static void main(String[] args) {
        a = 10;
        b = 20;

        System.out.println("swap() 메소드 호출 전 : " + a + " , " + b);
        swap(); //인수 없이 바로 저장
        System.out.println("swap() 메소드 호출 후 : " + a + " , " + b);

    }
}
