import java.io.*;
import java.util.*;

public class bipartitegraph {

    //제발 풀어보기,,,
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q48_01.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 노드 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수

        // 그래프 인접 리스트 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 각 노드의 색을 저장할 배열 (-1: 미방문, 0: 색1, 1: 색2)
        int[] colors = new int[V + 1];
        Arrays.fill(colors, -1);  // 색을 -1로 초기화하여 아직 방문하지 않음을 표시

        // 이분 그래프 판별 BFS
        boolean isBipartite = true;
        for (int start = 1; start <= V; start++) {
            if (colors[start] == -1) { // 방문하지 않은 노드만 검사
                if (!bfsCheck(graph, colors, start, bw)) {
                    isBipartite = false;
                    break;
                }
            }
        }

        // 결과 출력
        if (isBipartite) {
            bw.write("Yes\n");
        } else {
            bw.write("No\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // BFS를 사용한 이분 그래프 판별
    private static boolean bfsCheck(List<List<Integer>> graph, int[] colors, int start, BufferedWriter bw) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 0; // 시작 노드를 색 0으로 칠하기

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.get(current)) {
                if (colors[neighbor] == -1) { // 아직 방문하지 않은 노드
                    colors[neighbor] = 1 - colors[current]; // 현재 노드와 반대 색으로 칠하기
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[current]) {
                    // 인접한 노드가 같은 색이면 이분 그래프가 아님
                    // 해당 에러 출력
                    bw.write(current + "(" + colors[current] + ") -> " + neighbor + "(" + colors[neighbor] + ")\n");
                    return false; // 즉시 종료하고 오류 출력
                }
            }
        }
        return true;
    }
}