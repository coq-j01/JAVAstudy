import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class greedymeeting {
    static class Node {
        public int start;
        public int end;

        Node(int start , int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\greedy_meetings_01.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringWriter sw = new StringWriter();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[N];
        int meeting=1;
        int start;
        int end;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(start,end);
        }
        Arrays.stream(nodes).toArray();
        long t1 = System.currentTimeMillis();
        start = nodes[0].start;
        end = nodes[0].end;
        System.out.println("Meeting: "+start+" - "+end);
        for(int i=1; i<N; i++){
            start = nodes[i].start;
            if(end<start){
                meeting++;
                end = nodes[i].end;
                System.out.println("Meeting: "+start+" - "+end);
            }
        }
        System.out.println(meeting);
        System.out.print((System.currentTimeMillis()-t1)+"ms");
    }
}
