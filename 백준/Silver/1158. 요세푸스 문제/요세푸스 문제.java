import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        int cnt=1;
        List<Integer> answer=new ArrayList<>();

        while (!q.isEmpty()){
            if(cnt==k){
                cnt=1;
                answer.add(q.pollFirst());
                continue;
            }
            q.add(q.pollFirst());
            cnt++;
        }
        System.out.print("<");
        for(int i=0;i<answer.size()-1;i++){
            System.out.printf("%d, ",answer.get(i));
        }System.out.printf("%d>",answer.get(answer.size()-1));
    }
}