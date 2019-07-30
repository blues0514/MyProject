package Practice.Exception;

public class MyExceptionMain {
    public static void a(int i) {
        try {
            b(i);
        } catch (MyException e) {
            if (e instanceof MySubException) {
                System.out.print("MySubException : ");
            } else {
                System.out.print("MyException : ");
            }
            System.out.println(e.getMessage());
            System.out.println("��ġ -1");
        }
    }

    public static void b(int i) throws MyException {
        int result;
        try {
            System.out.println("i = " + i);
            result = c(i);
            System.out.println("c(i) = " + result);
        } catch (MyOtherException e) {
            System.out.println("MyOtherException : " + e.getMessage());
            System.out.println("��ġ -2");
        } finally {
            System.out.print("\n"); // �ݵ�� �����ϴ� �κ�
        }
    }

    public static int c(int i) throws MyException, MyOtherException {
        switch (i) {
            case 0:
                throw new MyException("�ʹ� ���� ���� �ԷµǾ����ϴ�.");
            case 1:
                throw new MySubException("�Էµ� ���� �ʹ� �۽��ϴ�.");
            case 99:
                throw new MyOtherException("�ʹ� ū ���� �ԷµǾ����ϴ�.");
            default:
                return i * i;
        }
    }

    public static void main(String[] args) {
        int i;

        try {
            i = 4; //Integer.valueOf(args[0]).intValue(); // String���� �μ��� int���� i�� ��ȯ
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("�μ��� �ʿ��մϴ�.");
            System.out.println("(��) MyExceptionMain 4");
            return;
        } catch (NumberFormatException e) {
            System.out.println("�μ��� �����̾�߸� �մϴ�.");
            System.out.println("(��) MyExceptionMain 4");
            return;
        } finally {
            System.out.println("������ ��µǴ� �κ�");
        }

        a(i);
    }
}
