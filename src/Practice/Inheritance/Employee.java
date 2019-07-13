package Practice.Inheritance;

public class Employee {
    String name;
    int salary;

    public Employee(String n, int s) { // 생성자가 이름과 월급을 인수로 받음
        // 이름과 월급을 저장
        name = n;
        salary = s;
    }

    public void getInformation() {
        System.out.println("이름 : " + name + ", 연봉 : " + salary);
    }
}
