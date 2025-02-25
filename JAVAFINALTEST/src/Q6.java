import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\Q6_01.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[100000];
        boolean answer = false;
        int max=0;
        int n = 0;
        int max2=0;
        while (st.hasMoreTokens()) {
            int k = Integer.parseInt(st.nextToken());
            if (num[k] >= 1) num[k]++;
            else num[k] = 1;
            max = Math.max(max,k);
            n++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int j=0; j<5; j++){
            for(int i=0;i<=max; i++){
                if(num[max2]<num[i]) max2=i;
            }
            queue.add(max2);
            num[max2]=0;
            max2=0;
        }
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
