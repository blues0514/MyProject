package Practice;

import java.util.Vector;

public class Prac_Vector {
    public static void main(String[] args) {
        Vector myVector = new Vector();

        //���Ϳ� ����
        myVector.addElement("�ϳ�");
        myVector.addElement("��");
        myVector.addElement(new Integer(3)); // ���� Ŭ���� (int -> Integer, boolean -> Boolean , double -> Double)
        myVector.addElement(new Boolean(true));
        myVector.addElement(new Double(5.5));

        //���� ���
        for (int i = 0; i < myVector.size(); i++) {
            System.out.println("myVector�� " + (i + 1) + "��° ���� : " + myVector.elementAt(i));
        }
        System.out.println();

        System.out.println("myVector�� 2��° ���� ����");
        myVector.removeElementAt(1);
        System.out.println();

        System.out.println("myVector�� 2��° ��ġ�� two ����");
        myVector.insertElementAt("two", 1);
        System.out.println();

        //���� ���
        for (int i = 0; i < myVector.size(); i++) {
            System.out.println("myVector�� " + (i + 1) + "��° ���� : " + myVector.elementAt(i));
        }
    }
}
