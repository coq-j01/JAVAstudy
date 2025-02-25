import java.io.*;
import java.util.StringTokenizer;

public class unionfind {
    // 부모 배열
    static int[] parent;
    // 랭크 배열 (트리의 높이를 관리)
    static int[] rank;

    // find 연산: 경로 압축 기법
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // 경로 압축
        }
        return parent[x];
    }

    // union 연산: 유니온 바이 랭크 기법
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // 랭크가 낮은 트리를 높은 트리에 붙인다.
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;  // 랭크 증가
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q50_02.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 첫 번째 줄: n과 m
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long t1 = System.currentTimeMillis();

        // 부모 배열 초기화
        parent = new int[n + 1];
        rank = new int[n + 1];

        // 각 원소의 부모를 자기 자신으로 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // 쿼리 처리
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (t == 0) {
                // a와 b를 같은 집합으로 합침
                union(a, b);
            } else if (t == 1) {
                // a와 b가 같은 집합에 속하는지 확인
                if (find(a) == find(b)) {
                    System.out.println(t + " " + a + " " + b + " : Yes");
                } else {
                    System.out.println(t + " " + a + " " + b + " : No");
                }
            }
        }
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
        br.close();
    }
}
