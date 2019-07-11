package Practice;

public class Prac_Static {
    public static void main(String[] args) {
        MyClass[] mc = new MyClass[10];

        for(int i = 0 ; i<10 ; i++) {
            mc[i] = new MyClass();
            System.out.println("MyClass의 Instance의 수 :  " + mc[i].getObj_num() + "개");
        }
    }
}

    class MyClass {
        static int obj_num = 0;

        public MyClass() {
            obj_num++;
        }

        public static int getObj_num() {
            return obj_num;
        }
    }

