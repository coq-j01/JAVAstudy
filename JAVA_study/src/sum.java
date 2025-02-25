import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int [] A = new int[N];
        int [] S = new int[N];
        int i;
        int j;
        for (int k = 0; k < N; k++) {
            A[k]=sc.nextInt();
            if(k==0) S[k]=A[k];
            else
                S[k]=S[k-1]+A[k];
        }
        for(int k=0;k<M;k++){
            i = sc.nextInt();
            j = sc.nextInt();
            if(i==1) System.out.println(S[j-1]);
            else System.out.println(S[j-1]-S[i-2]);
        }
    }
}