package Practice;

import java.util.Vector;

public class Prac_Vector {
    public static void main(String[] args) {
        Vector myVector = new Vector();

        //벡터에 저장
        myVector.addElement("하나");
        myVector.addElement("둘");
        myVector.addElement(new Integer(3)); // 랩퍼 클래스 (int -> Integer, boolean -> Boolean , double -> Double)
        myVector.addElement(new Boolean(true));
        myVector.addElement(new Double(5.5));

        //벡터 출력
        for (int i = 0; i < myVector.size(); i++) {
            System.out.println("myVector의 " + (i + 1) + "번째 원소 : " + myVector.elementAt(i));
        }
        System.out.println();

        System.out.println("myVector의 2번째 원소 제거");
        myVector.removeElementAt(1);
        System.out.println();

        System.out.println("myVector의 2번째 위치에 two 삽입");
        myVector.insertElementAt("two", 1);
        System.out.println();

        //벡터 출력
        for (int i = 0; i < myVector.size(); i++) {
            System.out.println("myVector의 " + (i + 1) + "번째 원소 : " + myVector.elementAt(i));
        }
    }
}
