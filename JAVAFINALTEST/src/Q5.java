import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\Q5_02.txt"));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] num = new int[100];
        int n=0;
        boolean answer=false;
        while(st.hasMoreTokens()){
           num[n] = Integer.parseInt(st.nextToken());
           n++;
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(num[i]-num[j]==m || num[j]-num[i]==m){
                    System.out.println("("+num[i]+","+num[j]+")");
                    answer=true;
                }
            }
        }
        if(!answer) System.out.println(answer);
    }
}
