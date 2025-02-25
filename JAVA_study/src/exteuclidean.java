import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
//수정하기
public class exteuclidean {
    static int x0=1;
    static int y0=0;
    static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A;
        int B;
        int C;
        int small;
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        int mod=0;
        long t1 = System.currentTimeMillis();
        if(B==0){
            small = A;
        }
        else if(A==0){
            small = B;
        }
        else if(A>B) {
            small = B;
            mod = A % B;
            st.add(A/B);
        }
        else {
            small = A;
            mod = B % A;
            st.add(B/A);
        }
        while(mod!=0){
            if(mod>small) {
                st.add(mod/small);
                mod = mod % small;
            }
            else {
                int tmp;
                tmp = small;
                small = mod;
                mod = tmp;
                st.add(mod/small);
                mod = mod % small;
            }
        }
        if(C%small!=0) System.out.println("-1");
        else {
            while(!st.isEmpty()){
               int x = y0;
               int y = x0-y0*st.pop();
               x0=x;
               y0=y;
            }
            x0 = x0*(C/small);
            y0 = y0*(C/small);
            System.out.println("x : "+x0+" y : "+y0);
        }
        System.out.print("시간: "+(System.currentTimeMillis()-t1));
    }
}
