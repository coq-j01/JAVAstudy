import java.io.*;
import java.util.*;

public class topologysort2 {
    //위상정렬 문제2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q54_02.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 건물 종류 수/노드 수

        int[] K = new int[N+1];
        int[] time = new int[N+1];
        int[] result = new int[N+1];
        List<List<Integer>> A = new ArrayList<>();//인접리스트
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
            K[i]=0;
            time[i]=0;
        }
        long t1 = System.currentTimeMillis();
        for (int i = 1; i <=N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int tk = Integer.parseInt(st.nextToken());
            while(tk != -1){
                A.get(tk).add(i);
                K[i]++;
                tk = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(K[i]==0) queue.add(i);
            result[i] = time[i];
        }
        while(!queue.isEmpty()){
            int poll = queue.poll();
            List<Integer> list = A.get(poll);
            for(int i=0; i<list.size(); i++){
                result[list.get(i)]= Math.max(result[list.get(i)], result[poll] + time[list.get(i)]);//이해하기,,
                K[list.get(i)]--;
                if(K[list.get(i)]==0) queue.add(list.get(i));
            }
        }
        for(int i=1; i<=N; i++){
            System.out.println(result[i]);
        }
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
    }
}
