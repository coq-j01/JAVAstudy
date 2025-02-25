import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class minimumspanning {
    //이해하기ㅜㅠ
    static class Edge implements Comparable<Edge> {
        int v;
        int w;
        int weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        // 우선 순위 큐 활용
        @Override
        public int compareTo(Edge e) {
            return weight - e.weight;
        }

        static int[] parent;

        static void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                if (rootA > rootB) {
                    parent[rootA] = rootB;
                } else {
                    parent[rootB] = rootA;
                }
            }
        }

        static int find(int num) {
            if (parent[num] == num) return num;
            return parent[num] = find(parent[num]); // 경로 압축
        }

        //최소신장트리
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q64_02.txt"));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 노드 수
            int m = Integer.parseInt(st.nextToken()); // 간선 수

            parent = new int[n + 1];
            PriorityQueue<Edge> queue = new PriorityQueue<>();

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                queue.offer(new Edge(v, w, cost));
            }
            int weight = 0;
            while (!queue.isEmpty()) {
                Edge edge = queue.poll();
                if (find(edge.v) != find(edge.w)) {
                    union(edge.v, edge.w);
                    weight += edge.weight;
                }
            }
            System.out.println(weight);
        }
    }
}
