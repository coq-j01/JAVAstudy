import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class primenum {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int N;
        int M;
        N = sc.nextInt();
        M = sc.nextInt();
        int[] A = new int[M + 1];
        int N2 = N;
        for (int i = 0; i < M + 1; i++) {
            A[i] = i;
        }
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < M + 1; i++) {
            if (A[i] <= 1) continue;
            else {
                if(A[i]>=N && A[i]<=M) {
                    bw.write(Integer.toString(A[i]));
                    bw.write("\n");
                }
                for (int j = A[i] * 2; j < M + 1; j+=A[i]) {
                    if (j % A[i] == 0) A[j] = 1;
                }
            }
        }
        bw.flush();
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
    }
}
