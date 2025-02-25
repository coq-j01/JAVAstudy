import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binary {
    static int N;
    static int[] A;
    static int binarysearch(int target, int start, int end){
        int find =0;
        while(start<=end){
            int mid = (start+end)/2;
            if(A[mid]>target){
                end = mid-1;
            }
            else if(A[mid]<target){
                start = mid+1;
            }
            else{
                find=1;
                break;
            }
        }
        if(find==1) return 1;
        else return 0;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\binarysearch_02.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringWriter sw = new StringWriter();
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1);
        StringTokenizer st2;
        N = st1.countTokens();
        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(A);
        String line2 = br.readLine();
        st2 = new StringTokenizer(line2);
        int M = st2.countTokens();
        int target;
        long t1 = System.currentTimeMillis();
        for(int i=0; i<M; i++){
            target = Integer.parseInt(st2.nextToken());
            System.out.println(binarysearch(target,0,N-1));
        }
        br.close();
        System.out.print((System.currentTimeMillis()-t1)+"ms");
    }
}
