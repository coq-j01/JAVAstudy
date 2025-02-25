import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class greedymin { //괄호배치로 최소값만들기
    public static void main(String[] args) throws IOException {
        List<String> tokens = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chaeb\\Downloads\\greedy_min_01.txt"))){
            String expression = br.readLine();

            Pattern pattern = Pattern.compile("\\d+|[()\\+\\-]");
            Matcher matcher = pattern.matcher(expression);

            while(matcher.find()){
                String value = matcher.group();
                if(!value.equals(")")&& !value.equals("(")){
                    tokens.add(value);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        int sum[]=new int [tokens.size()];
        int m=0;
        sum[m]=0;
        int check=0;
        for(int i=0; i<tokens.size(); i++){
            /*System.out.println(tokens.get(i));*/
            if(Objects.equals(tokens.get(i), "-")){
                if(check==0){
                    System.out.print("- (");
                    check=1;
                }
                else System.out.print(") - (");
                m++;
                sum[m]=0;
            }
            else if (Objects.equals(tokens.get(i), "+")) {
                System.out.print(" + ");
            } else{
                int num = Integer.parseInt(tokens.get(i));
                sum[m] += num;
                System.out.print(num);
            }
            /*if(i==0) answer = Integer.parseInt(tokens.get(i));*/
        }
        int answer = sum[0];
        for(int i=1; i<=m; i++){
            answer-=sum[i];
        }
        System.out.println(") = "+answer);
    }
}
