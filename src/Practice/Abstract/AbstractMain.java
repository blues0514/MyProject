package Practice.Abstract;

public class AbstractMain {
    public static void main(String[] args) {
        HourlyWorker employee1 = new HourlyWorker("����");
        employee1.getInformation();

        WeeklyWorker employee2 = new WeeklyWorker("������");
        employee2.getInformation();

        MonthlyWorker employee3 = new MonthlyWorker("������");
        employee3.getInformation();
    }
}
