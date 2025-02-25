import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

//직접 다시 해보기,,
public class graph {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q46_02.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringWriter sw = new StringWriter();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시

        // 도시 간 도로 정보 저장을 위한 인접 리스트 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 도로 정보 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        // 모든 도시의 최단 거리 배열 초기화 (거리 정보는 최대로 설정)
        int[] distances = new int[N + 1];
        Arrays.fill(distances, -1);
        distances[X] = 0; // 출발 도시는 거리 0

        // BFS를 위한 큐 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        long t1 = System.currentTimeMillis();
        while (!queue.isEmpty()) {
            int currentCity = queue.poll();

            for (int nextCity : graph.get(currentCity)) {
                // 방문하지 않은 도시에 대해 최단 거리 계산
                if (distances[nextCity] == -1) {
                    distances[nextCity] = distances[currentCity] + 1;
                    queue.add(nextCity);
                }
            }
        }

        // 각 도시의 최단 거리 출력
        for (int i = 1; i <= N; i++) {
            if (distances[i] != -1) {
                bw.write(i + "(" + distances[i] + ") ");
            }
        }
        bw.write("\n");

        // 거리 K인 도시 찾기
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (distances[i] == K) {
                result.add(i);
            }
        }

        // 결과 출력
        if (result.isEmpty()) {
            bw.write("-1\n");
        } else {
            Collections.sort(result);
            for (int city : result) {
                bw.write(city + "\n");
            }
        }

        bw.flush();
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
        bw.close();
        br.close();

    }
}
