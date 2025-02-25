import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q3 {
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\Q3_01.txt"));
        StringTokenizer st;
        tree = new int[7][2];
        int n=7;
        for(int i=0; i<7; i++){
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int left= Integer.parseInt(st.nextToken());
            int right= Integer.parseInt(st.nextToken());
            tree[no][0] = left;
            tree[no][1] = right;
        }
        System.out.println(1);
        leftprint(tree[1][0]);
    }
    static void leftprint(int now){
        if(now==-1) return;
        System.out.println(now);
        leftprint(tree[now][0]);
        print(tree[now][1]);
    }
    static void print(int now) {
        if(now==-1) return;
        if(tree[now][0]==-1) {
            System.out.println(now);
            print(tree[now][1]);
        }
        else if(tree[now][1]==-1){
            System.out.println(now);
            leftprint(tree[now][0]);
        }
    }
}
