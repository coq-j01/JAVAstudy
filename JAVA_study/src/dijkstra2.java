import java.io.*;
import java.util.*;

public class dijkstra2 {

    //다익스트라 58번
    //직접해보기

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int city, cost;

        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q58_02.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시 수, 노드개수
        int m = Integer.parseInt(st.nextToken()); // 도시 개수, 에지개수
        int k = Integer.parseInt(st.nextToken()); // 출발 노드

        // 그래프 초기화
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        long t1 = System.currentTimeMillis();

        // 도로 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }

        // K번째 최단 경로 저장
        PriorityQueue<Integer>[] distances = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            distances[i] = new PriorityQueue<>(k, Collections.reverseOrder());
        }

        // 다익스트라 알고리즘 변형
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        distances[1].offer(0);

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentCity = current.city;
            int currentCost = current.cost;

            for (Edge edge : graph.get(currentCity)) {
                int nextCity = edge.to;
                int newCost = currentCost + edge.weight;

                if (distances[nextCity].size() < k) {
                    distances[nextCity].offer(newCost);
                    pq.offer(new Node(nextCity, newCost));
                } else if (distances[nextCity].peek() > newCost) {
                    distances[nextCity].poll();
                    distances[nextCity].offer(newCost);
                    pq.offer(new Node(nextCity, newCost));
                }
            }
        }

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            if (distances[i].size() < k) {
                bw.write(i+": "+"-1\n");
            } else {
                bw.write(i+": "+distances[i].peek() + "\n");
            }
        }
        bw.flush();
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
        bw.close();
    }
}
