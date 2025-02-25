import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class euclidean {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N;
        int M;
        int small;
        N = sc.nextInt();
        M = sc.nextInt();
        int mod;
        long t1 = System.currentTimeMillis();
        if(N>M) {
            small = M;
            mod = N % M;
        }
        else {
            small = N;
            mod = M % N;
        }
        while(mod!=0){
            if(mod>small) {
                mod = mod % small;
            }
            else {
                int tmp;
                tmp = small;
                small = mod;
                mod = tmp;
                mod = mod % small;
            }
        }

        System.out.println("최소 공배수 : "+ (N*M)/small );
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
    }
}
