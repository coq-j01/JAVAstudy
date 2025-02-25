import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class mergesort {
    public static void mergesort(int[] arr, int[] temp, int s, int e) {
        if(s<e){
            int m = (s+e)/2;
            mergesort(arr,temp,s,m);
            mergesort(arr,temp,m+1,e);
            merge(arr,temp,s, m,e);
        }
    }
    public static void merge(int[] arr,int[] temp, int start, int m, int end) {
        int index = start;
        int l = start;
        int r = m+1;
        while(l<=m && r<=end){
            if(arr[l]<=arr[r]){
                temp[index] = arr[l];
                index++;
                l++;
            }
            else {
                temp[index] = arr[r];
                index++;
                r++;
            }
        }
        while(l <= m){
            temp[index] = arr[l];
            index++;
            l++;
        }
        while(r<=end){
            temp[index] = arr[r];
            index++;
            r++;
        }
        for(int i=start; i<=end; i++){
            arr[i] = temp[i];
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\merge_1000000.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int [] A = new int[N];
        int [] temp = new int[N];
        for(int i=0; i<N; i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        long t1 = System.currentTimeMillis();
        mergesort(A, temp,0, N - 1);
        for(int i=0; i<N; i++){
            bw.write(A[i]+" ");
        }
        System.out.println();
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
    }
}
