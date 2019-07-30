package Practice.Abstract;

public class AbstractMain {
    public static void main(String[] args) {
        HourlyWorker employee1 = new HourlyWorker("김경미");
        employee1.getInformation();

        WeeklyWorker employee2 = new WeeklyWorker("유선미");
        employee2.getInformation();

        MonthlyWorker employee3 = new MonthlyWorker("이준형");
        employee3.getInformation();
    }
}
