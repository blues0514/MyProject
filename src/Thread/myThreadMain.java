package Thread;

public class myThreadMain {
    public static void main(String[] args) {
        myThread myThread1 = new myThread("T1");
        myThread1.start();

        myThread myThread2 = new myThread("T2");
        myThread2.start();
    }
}
