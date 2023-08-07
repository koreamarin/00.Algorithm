import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException {


        // 테케 둘째줄, 원본 암호문
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<5;i++) list.add(i);
        // 테케 넷째줄, 명령어


        list.add(2, 20);

        for(int i=0; i<6; i++) System.out.println(list.get(i));
    }
}
