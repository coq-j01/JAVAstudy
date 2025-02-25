import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

public class binarytree {
    //이진트리
    static int[][] btree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\q70_02.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());


        btree = new int[26][2]; // 알파벳26, 왼쪽0, 오른쪽1
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            int node = a.charAt(0) -'A';
            if(Objects.equals(b, ".")){
                btree[node][0] = -1; //자식노드 없으면 -1저장
            }else btree[node][0] =b.charAt(0) -'A';
            if(Objects.equals(c, ".")){
                btree[node][1] = -1; //자식노드 없으면 -1저장
            }else btree[node][1] =c.charAt(0) -'A';
        }
        preOrder(0);//루트노드A
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }
    static void preOrder(int node){ //중간,왼쪽,오른쪽
        if(node==-1) return;
        else{
            System.out.print((char)(node+'A'));
            preOrder(btree[node][0]);
            preOrder(btree[node][1]);
        }
    }
    static void inOrder(int node){//왼쪽,중간,오른쪽
        if(node==-1) return;
        else{
            inOrder(btree[node][0]);
            System.out.print((char)(node+'A'));
            inOrder(btree[node][1]);
        }
    }
    static void postOrder(int node){//왼쪽,오른쪽,중간
        if(node==-1) return;
        else{
            postOrder(btree[node][0]);
            postOrder(btree[node][1]);
            System.out.print((char)(node+'A'));
        }
    }

}
