import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class greedycard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\greedy_cards_02.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringWriter sw = new StringWriter();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long t1 = System.currentTimeMillis();
        for(int i=0; i<N; i++){
             pq.add(Integer.parseInt(br.readLine()));
        }
        int allsum=0;

        while(pq.size()>1){
            int n1 = pq.poll();
            int n2 = pq.poll();
            int sum = n1+n2;
            System.out.println(n1+" + "+n2+" = "+sum);
            allsum+=sum;
            pq.add(sum);
        }
        System.out.println(allsum);
        System.out.print((System.currentTimeMillis()-t1)+"ms");
    }
}
