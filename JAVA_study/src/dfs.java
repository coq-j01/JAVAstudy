import java.io.*;
import java.util.*;

public class dfs {
    static int N,M;
    static boolean[] visit;
    static int[][] list;
    static void dfsal(int node){
        visit[node] = true;
        for(int next=1; next<=N; next++){
            if(!visit[next] && list[node][next] == 1) dfsal(next);
            else if(!visit[next] && list[next][node] == 1) dfsal(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\dfs_04.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringWriter sw = new StringWriter();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        list = new int[N+1][N+1];
        M=0;
        String line;
        while((line = br.readLine()) != null){
            st = new StringTokenizer(line);
            int data = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            list[data][next]=1;
            M++;
        }
        br.close();
        int link=0;
        long t1 = System.currentTimeMillis();
        for(int node = 1; node<=N; node++){
            if(!visit[node]){
                dfsal(node);
                link++;
            }
        }
        System.out.println(link);
        System.out.print((System.currentTimeMillis()-t1)+"ms");
    }
}
