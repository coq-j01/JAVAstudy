import java.io.*;
import java.util.*;

public class dijkstra { //다익스트라
    static class Edge implements Comparable<Edge> {
        int node, weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight; // 가중치를 기준으로 정렬
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q56_02.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 노드개수
        int E = Integer.parseInt(st.nextToken()); // 에지개수

        st = new StringTokenizer(br.readLine());
        int K =Integer.parseInt(st.nextToken()); // 출발 노드

        // 그래프 초기화
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) { // 1부터 V까지 사용
            graph.add(new ArrayList<>());
        }

        // 에지 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        long t1 = System.currentTimeMillis();
        // 다익스트라 알고리즘 실행
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(K, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.node;
            int currentWeight = current.weight;

            if (currentWeight > dist[currentNode]) continue;

            for (Edge edge : graph.get(currentNode)) {
                int nextNode = edge.node;
                int newDist = currentWeight + edge.weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new Edge(nextNode, newDist));
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                bw.write("INF");
            } else {
                bw.write(dist[i] + " ");
            }
        }
        bw.flush();
        System.out.println();
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
        bw.close();
    }
}
