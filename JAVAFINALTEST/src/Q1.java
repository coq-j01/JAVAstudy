import java.io.IOException;
import java.util.function.IntFunction;

public class Q1 {
    public static void main(String[] args) throws IOException {
        int N = 100000000;
        int count=0;
        int A[] = new int[200000000];
        for(int i=2; i<A.length; i++){
            A[i]=i;
        }
        for(int i=2; i<Math.sqrt(A.length); i++){
            if(A[i]==0) continue;
            for(int j=i+i; j<A.length; j=j+i){
                A[j]=0;
            }
        }
        for(int i=N; i<A.length; i++) {
            if (A[i] != 0) count++;
            if (count == 50000000) System.out.println(A[i]);
        }
    }
}
