package Practice.Thread;

public class myThread extends Thread {
    int num = 0;

    public myThread(String name) { // �������� �̸��� �μ��� �޴� ������
        super(name);
    }

    public void run() {
        while (true) { // ���� ����
            System.out.println(this.getName() + " : " + num);
            num++;

            try {
                sleep(1000); //1��
            } catch (InterruptedException e) {

            }
        }
    }
}
