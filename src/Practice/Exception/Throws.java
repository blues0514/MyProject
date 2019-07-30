package Practice.Exception;

public class Throws {
    public int divide(int x, int y) throws ArithmeticException { // ���� �߻� ���ɼ��� ����
        int result;

        try {
            result = x / y;
        } catch (ArithmeticException e) {
            throw (e); // ���� �߻�
        }
        return result;
    }

    public static void main(String[] args) {
        Throws x = new Throws();

        for (int i = 5; i >= 0; i--) {
            int divide_100 = x.divide(100, i);
            System.out.println("100�� " + i + "�� ������ : " + divide_100);
        }
    }
}
