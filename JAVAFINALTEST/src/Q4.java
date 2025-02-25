import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q4 {
    static int[][] K;
    static int snode;
    static int n;
    static boolean answer;
    static boolean[]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\Q4_02.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = false;

        n = Integer.parseInt(st.nextToken());
        int edge= Integer.parseInt(st.nextToken());
        int frist= Integer.parseInt(st.nextToken());

        K = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                K[i][j]=0;
            }
            visited[i]=false;
        }
        for(int i=0; i<edge; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());
            K[start][end]=1;
        }
        for(int i=1; i<=n; i++){
            snode = i;
            graph(i);
            if(answer==true){
                System.out.println(answer);
                break;
            }
        }
        if(answer==false) System.out.println(answer);
    }
    static void graph(int node){
        if(visited[node]==true) return;
        else{
            visited[node]=true;
            if(K[node][snode]==1) answer = true;
            else{
                for(int i=0; i<n; i++){
                    if(K[node][i]==1) graph(i);
                }
            }
        }
    }
}
