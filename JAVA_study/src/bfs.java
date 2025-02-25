import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.*;

public class bfs {
    static int N,start;
    static boolean[] dfsvisit;
    static boolean[] bfsvisit;
    static int[][] dfslist;
    static int[][] bfslist;
    static Queue<Integer> dfsqueue = new LinkedList<Integer>();
    static Queue<Integer> bfsqueue = new LinkedList<Integer>();
    static void dfsal(int node){
        dfsvisit[node] = true;
        dfsqueue.add(node);
        for(int next=1; next<=N; next++){
            if(!dfsvisit[next] && dfslist[node][next] == 1) dfsal(next);
        }
    }

    static void bfsal(int node){
        bfsvisit[node] = true;
        bfsqueue.add(node);
        while(!bfsqueue.isEmpty()){
            int num = bfsqueue.poll();
            System.out.print(num);
            for(int next=1; next<=N; next++){
                if(!bfsvisit[next] && bfslist[num][next] == 1) {
                    bfsvisit[next] = true;
                    bfsqueue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\bfs_04.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringWriter sw = new StringWriter();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        //System.out.println(N);
        start = Integer.parseInt(st.nextToken());
        dfsvisit = new boolean[N+1];
        dfslist = new int[N+1][N+1];
        bfsvisit = new boolean[N+1];
        bfslist = new int[N+1][N+1];
        String line;
        while((line = br.readLine()) != null){
            st = new StringTokenizer(line);
            int data = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            dfslist[data][next] = 1;
            dfslist[next][data] = 1;
            bfslist[data][next] = 1;
            bfslist[next][data] = 1;
        }
        br.close();
        long t1 = System.currentTimeMillis();
        dfsal(start);
        while(!dfsqueue.isEmpty()) System.out.print(dfsqueue.poll());
        System.out.println();
        bfsal(start);
        System.out.println();
        System.out.print((System.currentTimeMillis()-t1)+"ms");
    }
}
