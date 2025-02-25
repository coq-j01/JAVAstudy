import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class tree2 {
    //트리 리프노드 개수 구하기
    static int[] parent;
    static boolean[] visited;
    static int del;
    static int leaf;
    static List<List<Integer>> treelist = new ArrayList<>();
    static void dfs(int node){
        visited[node]=true;
        List<Integer> next = treelist.get(node);
        if(next.size()<=0) leaf++;
        else{
            for(int i=0; i<next.size(); i++){
                int n = next.get(i);
                if(n==del) break;
                else{
                    if(visited[n]) continue;
                    dfs(n);
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q68_03.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        parent = new int[N];//부모 노드 저장
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            treelist.add(new ArrayList<>());
            visited[i]=false;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int p = Integer.parseInt(st.nextToken());
            if(p==-1) parent[i]=0;
            else{
                parent[i]=p;
                treelist.get(p).add(i);
            }
        }
        st = new StringTokenizer(br.readLine());
        del = Integer.parseInt(st.nextToken());
        leaf=0;
        if(del!=0) dfs(0);
        System.out.println(leaf);
    }
}
