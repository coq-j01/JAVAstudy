import java.io.*;
import java.util.StringTokenizer;

public class Q2 {
    static int[][] tree;
    static int sum;
    static int[] nodelist;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\Q2_03.txt"));
        StringTokenizer st;
        n = 2047;
        tree =new int[n+1][2];
        nodelist = new int[n+1];
        boolean answer = true;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            nodelist[no]=node;
            int left= Integer.parseInt(st.nextToken());
            int right= Integer.parseInt(st.nextToken());
            tree[no][0] = left;
            tree[no][1] = right;
        }
        for(int i=1; i<=n; i++){
            if(tree[i][0]==-1 && tree[i][1]==-1) continue;
            sum=0;
            sumtree(i);
            if(nodelist[i]!=sum-nodelist[i]){
                answer=false;
                break;
            }
        }
        System.out.println(answer);
    }
    static void sumtree(int now){
        if(now==-1) return;
        sum+=nodelist[now];
        sumtree(tree[now][0]);
        sumtree(tree[now][1]);
    }

}
