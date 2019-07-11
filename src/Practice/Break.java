package Practice;

public class Break {
    public static void main(String[] args) {
        int i,j;

        i = 10;
        OUT_WHILE: while(true) { // 조건이 true -> 무한 루프, OUT_WHILE : -> 이름표 역할
            j=0;
            while(true) { // 무한 루프
                System.out.print("*");
                j++;
                if(j>=i) break; // j값이 i값보다 크거나 같으면 탈출(break)
            }
            System.out.println();
            i--;
            if(i<=0) break OUT_WHILE; // i 값이 0보다 작거나 같으면 break
        }
    }
}
