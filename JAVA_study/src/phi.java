import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class phi {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int result = N;
        int[]P=new int[N+1];
        for (int i = 0; i <=N; i++) {
            P[i] = i;
        }
        long t1 = System.currentTimeMillis();
        for(int i=2; i<= N; i++){
            if(P[i]==i){
                for(int k=i; k<=N; k+=i) {
                    P[k]=P[k]-P[k]/i;
                }
            }
        }
        System.out.println(P[N]);
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
    }
}
