package Practice.Thread;

public class myThread extends Thread {
    int num = 0;

    public myThread(String name) { // 쓰레드의 이름을 인수로 받는 생성자
        super(name);
    }

    public void run() {
        while (true) { // 무한 루프
            System.out.println(this.getName() + " : " + num);
            num++;

            try {
                sleep(1000); //1초
            } catch (InterruptedException e) {

            }
        }
    }
}
