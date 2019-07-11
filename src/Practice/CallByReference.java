package Practice;

public class CallByReference {
    public static void swap(Number number){
        int temp = number.x;
        number.x = number.y;
        number.y = temp;
    }


    public static void main(String[] args) {
        Number n = new Number(); // Number 클래스 생성
        n.x = 20;
        n.y = 30;

        System.out.println("swap() 메소드 호출 전 : " + n.x + " , " + n.y);
        swap(n); // Number형 객체 n 전달
        System.out.println("swap() 메소드 호출 후 : " + n.x + " , " + n.y);
    }
    static class Number {
        public int x;
        public int y;
    }
}
