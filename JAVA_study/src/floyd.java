import java.io.*;
import java.util.*;

public class floyd {
    //플로이드-워셜
    static ArrayList<Edge> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q61_01.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드 수 / 도시 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수 / 노선 개수
        int[][] distance = new int[n+1][n+1];

        graph = new ArrayList<>();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) distance[i][j]=0;
                else distance[i][j]= bellman.INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(distance[start][end]!=bellman.INF) distance[start][end] = Math.min(distance[start][end],cost);
            else distance[start][end] = cost;
        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    distance[i][j] = Math.min(distance[i][j],distance[i][k]+distance[k][j]);
                }
            }
        }
        for(int i=1; i<=n; i++) {
            System.out.print(i+": ");
            for (int j = 1; j <= n; j++) {
                if(distance[i][j]==bellman.INF) System.out.print("-1 ");
                else System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }
    }
}
