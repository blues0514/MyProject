package Practice.Inheritance;

public class Manager extends Employee { // 상속
    String department;

    public Manager(String n, int s, String d) { // 생성자
        super(n,s); // Employee 클래스의 생성자에게 이름과 월급 전달
                    // super() 메소드는 수퍼클래스의 생성자에게 인수를 전달하는 명령어
        department = d; // 부서 저장
    }

    public void getInformation() {
        System.out.println("이름 : " + name + ", 부서 : " + department + ", 연봉 : " + salary);
    }
}
