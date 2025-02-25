import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class trie {
    static tnode rootnode = new tnode(); //루트노드 생성
    //트라이
    public static void main(String[] args) throws IOException {
        String[] find  = {"baekjoon","codeplus","codeminus","startlink","starlink","sundaycoding","codingsh","codinghs","sondaycoding","startrink","icerink"};
        int answer=0; //찾은 문자열 개수

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //집합 S의 문자열 개수
        sc.nextLine(); //남아있는 개행 문자 소비

        int M = find.length; //검사할 문자열 개수

        long t1 = System.currentTimeMillis();

        int n =N;
        while(n--!=0){ //트라이 자료구조 구축하기
            String text = sc.nextLine();
            insert(text);

        }

        tnode node;
        //문자열 검색
        for(int i=0; i<M; i++){
            if(search(find[i])) answer++;
        }

        System.out.println(answer);
        System.out.println(System.currentTimeMillis()-t1+"ms");
    }
    static void insert(String word){
        tnode node = rootnode;
        for (char c : word.toCharArray()){
            //c가 자식노드에 존재하지 않으면 새 노드 만들기
            node = node.chiledNode.computeIfAbsent(c,key -> new tnode());
        }
        node.endOfword = true;
    }
    static boolean search(String word){
        tnode node = rootnode;
        for (char c : word.toCharArray()){
            //문자열의 각 단어에 매핑된 노드가 존재하면 가져오고 아니면 null
            node = node.chiledNode.getOrDefault(c,null);
            if(node==null) return false;
        }
        return node.endOfword;
    }
}
class tnode{
    //자식노드
    Map<Character,tnode> chiledNode = new HashMap<Character,tnode>();
    //단어의 끝인지 아닌지 체크
    boolean endOfword = false;
}
