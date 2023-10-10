package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author 류지원
 * 메모리 : 21832KB
 * 시간 : 212ms
 * 풀이방법 :
 * 대전제조건 : 1을 더한 횟수와 2을 더한 횟수가 같을 수 있다면 나무의 길이를 맞추는게 가능하다.
 *
 * 하위 전제조건 :
 * 대 전제조건이 성립되려면 2가지의 하위 전제조건이 성립되면 된다.
 * 1, 1을 더한 횟수와 2을 더한 횟수가 같아지게 만든다.
 * 2. 1번 조건을 해냈을 때, 남은 목표길이의 합이 3의 배수라면 대 전제조건에 성립된다.
 * 
 * 구현 방법 : 
 * 목표길이에서 홀수인 것을 찾은다음, 1을 더해야하는 횟수를 센다. 그 후, 2를 더해야 하는 횟수를 센다.
 * 2를 더해야 하는 횟수에서 1을 더해야하는 횟수를 뺐을때 0이상이어야 한다. 음수라면 목표나무길이를 만들지 못하는 것이다.
 * 2를 더해야 하는 횟수에서 1을 더해야하는 횟수를 뻈을때의 값을 3으로 나눴을 때, 값이 0이어야 한다. 그렇지 않다면 목표나무 길이를 만들지 못하는 것이다.
 */
public class BJ_19539_사과나무_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine()); int plus1=0, plus2=0;
        StringTokenizer ST=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int A=Integer.parseInt(ST.nextToken());
            if(A%2==1) plus1+=1;    // 1을 더해야 하는 횟수 세기
            plus2+=A/2;             // 2를 더해야 하는 횟수 세기
            System.out.println(plus1 + " " + plus2);
        }
        System.out.println((plus2>=plus1 && (plus2-plus1)%3==0)? "YES" : "NO");   // 나머지가 3의 배수인지 확인하기.
    }
}
