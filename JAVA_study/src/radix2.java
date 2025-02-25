import java.io.*;
import java.util.*;

public class radix2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\radix_10000000.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();  // StringWriter 대신 사용

        // 입력 값을 읽고 배열에 저장
        String line = br.readLine();
        String[] tokens = line.split(" ");
        int N = tokens.length;
        int[] A = new int[N];

        int maxVal = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tokens[i]);
            if (A[i] > maxVal) {
                maxVal = A[i];
            }
        }

        // 최대 자릿수 계산
        int maxDigits = (int) Math.log10(maxVal) + 1;

        // 기수 정렬에서 사용할 배열
        int[] count = new int[10];
        int[] buffer = new int[N];
        int exp = 1;  // 1의 자리부터 시작

        long t1 = System.currentTimeMillis();

        // 기수 정렬
        for (int i = 0; i < maxDigits; i++) {

            Arrays.fill(count, 0);

            for (int j = 0; j < N; j++) {
                int digit = (A[j] / exp) % 10;
                count[digit]++;
            }

            for (int j = 1; j < 10; j++) {
                count[j] += count[j - 1];
            }

            for (int j = N - 1; j >= 0; j--) {
                int digit = (A[j] / exp) % 10;
                buffer[--count[digit]] = A[j];
            }

            int[] temp = A;
            A = buffer;
            buffer = temp;

            exp *= 10;
        }

        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        System.out.println("시간: " + (System.currentTimeMillis() - t1) + " ms");

        br.close();
        bw.close();
    }
}

