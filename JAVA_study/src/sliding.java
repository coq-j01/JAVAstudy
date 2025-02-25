import java.io.*;
import java.nio.Buffer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sliding {
    static class Node {
        public int value;
        public int index;

        Node(int index, int value) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\SlidingWindow_5000000.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = 5000000;
        /*String filepath = "C:\\Users\\chaeb\\Downloads\\SlidingWindow_100.txt"; //텍스트 파일 절대경로
        String num = readNumbers(filepath);
        num = num.replaceAll(" ","");
        int N = num.length();*/
        /*int[] A = new int[N];
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }*/
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        Deque<Node> mydeque = new LinkedList<>();
        int index=1;
        mydeque.addFirst(new Node(index,Integer.parseInt(st.nextToken())));
        bw.write(mydeque.getFirst().value+" ");
        for(index =2; index <= N; index++){
            if(mydeque.isEmpty()) break;
            int now =Integer.parseInt(st.nextToken());
                for (int k = 0; k < 3; k++) {
                    if(now < mydeque.getLast().value) {
                        mydeque.removeLast();
                    }
                   if(mydeque.isEmpty() || mydeque.getFirst() == mydeque.getLast()) break;
                }
                mydeque.addLast(new Node(index, now));
                if (index - L >= mydeque.getFirst().index) mydeque.removeFirst();
                bw.write(mydeque.getFirst().value+" ");
            }
        System.out.println();
        System.out.print(System.currentTimeMillis()-t1);
    }
}