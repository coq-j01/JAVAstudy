import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class radix {
    static Queue<Integer>[] queue = new LinkedList[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\radix_10000000.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringWriter sw = new StringWriter();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int [] A = new int[N];
        int max = 0;
        for(int i=0; i<N; i++){
            A[i]=Integer.parseInt(st.nextToken());
            max= Math.max(max,(int)Math.log10(A[i])+1);
        }
        for (int k = 0; k < 10; k++) {
            queue[k] = new LinkedList<>();
        }
        long t1 = System.currentTimeMillis();
        int n =1;
        for(int i=0; i<max; i++){
            n= n*10;
            for(int j=0; j<N; j++){
                int a = (A[j]%n)/(n/10);
                queue[a].add(A[j]);
            }
            int index=0;
            for(int k=0; k<10; k++){
                while(!queue[k].isEmpty()){
                    A[index++] = queue[k].poll();
                }
            }
        }
        for(int i=0; i<N; i++){
           sw.write(A[i]+"\n");
        }
        System.out.println(sw.toString());
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
        sw.flush();
        sw.close();
    }
}
