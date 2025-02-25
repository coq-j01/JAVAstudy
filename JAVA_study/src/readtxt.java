import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readtxt {
    public static String readNumbers(String filepath){
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            line = br.readLine();
            if(line != null){
                return line;
            }
            return "";
        }
        catch(IOException e){
            e.printStackTrace();
            return "";
        }
    }
    public static void main(String[] args){
        String filepath = "C:\\Users\\chaeb\\Downloads\\SlidingWindow_12.txt"; //텍스트 파일 절대경로
        String numbers = readNumbers(filepath);
        System.out.print(numbers);
    }
}
