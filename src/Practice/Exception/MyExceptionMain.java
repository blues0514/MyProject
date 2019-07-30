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
            System.out.println("위치 -1");
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
            System.out.println("위치 -2");
        } finally {
            System.out.print("\n"); // 반드시 실행하는 부분
        }
    }

    public static int c(int i) throws MyException, MyOtherException {
        switch (i) {
            case 0:
                throw new MyException("너무 작은 값이 입력되었습니다.");
            case 1:
                throw new MySubException("입력된 값이 너무 작습니다.");
            case 99:
                throw new MyOtherException("너무 큰 값이 입력되었습니다.");
            default:
                return i * i;
        }
    }

    public static void main(String[] args) {
        int i;

        try {
            i = 4; //Integer.valueOf(args[0]).intValue(); // String형인 인수를 int형인 i로 변환
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("인수가 필요합니다.");
            System.out.println("(예) MyExceptionMain 4");
            return;
        } catch (NumberFormatException e) {
            System.out.println("인수가 정수이어야만 합니다.");
            System.out.println("(예) MyExceptionMain 4");
            return;
        } finally {
            System.out.println("언제나 출력되는 부분");
        }

        a(i);
    }
}
