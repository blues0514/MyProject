package Practice;

public class Prac_StringBuffer {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append('I'); // char
        sb.append("nternet "); // String
        sb.append(2002); // int
        sb.append(' ');
        sb.append(0.1); // double
        System.out.println(sb);
        //insert(위치,값)
        sb.insert(8, ", B"); //String
        sb.insert(11,'C'); // char
        System.out.println(sb);
    }
}
