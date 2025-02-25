import java.io.*;
import java.util.*;

public class topologysort {
    //위상정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q53_03.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생의 개수/노드
        int M = Integer.parseInt(st.nextToken()); // 비교의 개수/간선

        int[] K = new int[N+1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            K[i]=0;
        }
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            K[B]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(K[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int poll = queue.poll();
            System.out.print(poll+" ");
            List<Integer> A = graph.get(poll);
            for(int i=0; i<A.size(); i++){
                K[A.get(i)]--;
                if(K[A.get(i)]==0) queue.add(A.get(i));
            }
        }
        System.out.println();
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
    }
}
