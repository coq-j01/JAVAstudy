import java.io.*;
import java.util.StringTokenizer;

public class greedy {
    //동전 개수의 최솟값 구하기(1초)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\greedy_coins_03.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringWriter sw = new StringWriter();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        /*System.out.println(N+"/"+K);*/
        int A[] = new int[N];
        for(int i=0; i<N; i++){
            A[i]= Integer.parseInt(br.readLine());
        }
        int coins=0;
        long t1 = System.currentTimeMillis();
        for(int i=N-1; i>=0; i--){
            if(A[i]<=K){
                int coin = (K/A[i]);
                coins+= coin;
                System.out.println(A[i]+"*"+coin);
                K = K % A[i];
            }
            if(K==0) break;
        }
        System.out.println(coins);
        System.out.print((System.currentTimeMillis()-t1)+"ms");
    }
}
