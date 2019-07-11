package Practice;

public class CallByReference {
    public static void swap(Number number){
        int temp = number.x;
        number.x = number.y;
        number.y = temp;
    }


    public static void main(String[] args) {
        Number n = new Number();
        n.x = 20;
        n.y = 30;

        System.out.println("swap() 메소드 호출 전 : " + n.x + " , " + n.y);
        swap(n);
        System.out.println("swap() 메소드 호출 후 : " + n.x + " , " + n.y);
    }
    static class Number {
        public int x;
        public int y;
    }
}
