import java.io.*;
import java.util.*;

public class tree {
    //트리 67번
    static boolean[] visited;
    static int[] answer;
    static List<List<Integer>> treelist = new ArrayList<>();
    static void dfs(int node){
        visited[node]=true;
        List<Integer> next = treelist.get(node);
        for(int i=0; i<next.size(); i++){
            int n = next.get(i);
            if(visited[n]) continue;
            answer[n]=node;
            dfs(n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q67_03.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1]; //방문 기록 저장
        answer = new int[N+1];//부모 노드 저장

        for (int i = 0; i <= N; i++) {
            treelist.add(new ArrayList<>());
            visited[i]=false;
            answer[i]=0;
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            treelist.get(start).add(end);
            treelist.get(end).add(start);
        }
        dfs(1);
        for(int i=2; i<N+1; i++){
            System.out.println(i+" : "+answer[i]);
        }
    }
}
