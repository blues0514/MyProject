package Practice.Abstract;

public class WeeklyWorker extends Employee {
    int pay_per_hour = 2000;
    int work_hour = 8;
    int work_week = 1;

    public WeeklyWorker(String name) {
        super(name);
    }

    public int income() {
        return (work_hour * pay_per_hour) * (work_week * 5);
    }
}
