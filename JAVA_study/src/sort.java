import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sort {
    //bubblesort
    /*public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N=5;
        int [] A = new int[N];
        for(int i=0; i<N; i++){
            A[i]=sc.nextInt();
        }
        long t1 = System.currentTimeMillis();
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1-i; j++){
                if(A[j]>A[j+1]){
                    int a = A[j];
                    A[j] = A[j+1];
                    A[j+1] = a;
                }
            }
        }
        for(int i=0; i<N; i++){
            System.out.println(A[i]);
        }
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
    }*/
    //selectionsort
    /*public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine();
        int N = str.length();
        int [] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(str.substring(i,i+1));
        }
        long t1 = System.currentTimeMillis();
        for(int i=0; i<N-1; i++){
            int max = A[i];
            for(int j=i+1; j<N; j++){
                if(A[j]>max){
                    max = A[j];
                    A[j] = A[i];
                    A[i] = max;
                }
            }
        }
        for(int i=0; i<N; i++){
            System.out.println(A[i]);
        }
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
    }*/
    //insertionsort
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\insertion_1000.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int [] A = new int[N];
        int [] S = new int[N];
        for(int i=0; i<N; i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        long t1 = System.currentTimeMillis();
        for(int i=1; i<N; i++){
            int a = A[i];
            int j;
            for(j=i-1; j>=0; j--){
                if(a<A[j]) A[j+1] = A[j];
                else    break;
            }
            A[j+1] =a;
        }
        for(int i=0; i<N; i++){
            if(i==0) S[i]=A[i];
            else S[i] = S[i-1] +A[i];
        }
        int sum=0;
        for(int i=0; i<N; i++){
            sum+=S[i];
        }
        System.out.println(sum);
       *//* System.out.print("시간: "+(System.currentTimeMillis()-t1));*//*
    }*/
    //quicksort
    public static void quickSort(int[] arr, int low, int high,int K) {
        if (low < high) {
            int pi = partition(arr, low, high);

            if(pi == K) {
                System.out.println((K+1)+"번째로 큰 수: "+arr[K]);
                return;
            }
            else if(pi>K) quickSort(arr, low, pi - 1,K);
            else quickSort(arr, pi + 1, high,K);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\quick_5000000.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int K = sc.nextInt();
        int [] A = new int[N];
        for(int i=0; i<N; i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N - 1,K-1);
    }
}
