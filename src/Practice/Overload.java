package Practice;

public class Overload {

    public static int max(int x, int y) { // int형 인수 2개를 받는 메소
        if(x>y) { return x; }
        else { return y; }
    }

    public static double max(double x, double y) { // 메소드 오버로딩 -> max이름으로 같은 메소드, double형 인수 2개를 받음
        if(x>y) { return x; }
        else { return y; }
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(max(a,b)); // int형 인수 2개를 받는 max 메소드 호출

        double c = 10.5;
        double d = 20.5;
        System.out.println(max(c,d)); // double형 인수 2개를 받는 max 메소드 호출
    }

}
