package Practice.Abstract;

public class HourlyWorker extends Employee {
    int pay_per_hour = 2000;
    int work_hour = 8;

    public HourlyWorker(String name) {
        super(name);
    }

    public int income() { // ����Ŭ������ �߻� �޼ҵ� ����
        return work_hour * pay_per_hour;
    }
}
