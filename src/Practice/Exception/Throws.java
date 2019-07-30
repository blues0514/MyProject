package Practice.Exception;

public class Throws {
    public int divide(int x, int y) throws ArithmeticException { // 예외 발생 가능성을 선언
        int result;

        try {
            result = x / y;
        } catch (ArithmeticException e) {
            throw (e); // 예외 발생
        }
        return result;
    }

    public static void main(String[] args) {
        Throws x = new Throws();

        for (int i = 5; i >= 0; i--) {
            int divide_100 = x.divide(100, i);
            System.out.println("100을 " + i + "로 나누면 : " + divide_100);
        }
    }
}
