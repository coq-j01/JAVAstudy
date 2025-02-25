import java.io.*;
import java.util.*;

class Edge{
    int v;//들어오는 정점
    int w;//나가는 정점
    int cost;

    public Edge(int v, int w, int cost){
        this.v =v;
        this.w =w;
        this.cost = cost;
    }
}
public class bellman {
    //벨만포드
    static final int INF = 100000000;
    static ArrayList<Edge> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q59_03.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수

        graph = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Edge(v, w, cost));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; // 시작 노드의 거리: 0

        // Bellman-Ford 알고리즘: 최단 거리 계산
        for (int i = 1; i < n; i++) { // 최대 n-1번 반복
            for (int j = 0; j < m; j++) { // 모든 간선 확인
                Edge edge = graph.get(j);
                if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }

        // 음수 사이클 확인
        boolean hasNegativeCycle = false;
        for (int j = 0; j < m; j++) {
            Edge edge = graph.get(j);
            if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
                hasNegativeCycle = true;
                break;
            }
        }

        // 결과 출력
        if (hasNegativeCycle) {
            System.out.println("Negative cycle detected");
        } else {
            for (int i = 2; i <= n; i++) { // 시작 노드는 제외하고 출력
                if (dist[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }
}


