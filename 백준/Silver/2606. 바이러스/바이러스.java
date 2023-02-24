import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,answer;
    static boolean[] visited;
    static int[][] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        num=new int[n+1][n+1];
        visited=new boolean[n+1];
        StringTokenizer st;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            num[a][b]=num[b][a]=1;
        }
        dfs(1);
        System.out.println(answer-1);
    }
    public static void dfs(int start){
        visited[start]=true;
        answer++;
        for(int i=0;i<=n;i++){
            if(num[start][i]==1&&!visited[i]){
                dfs(i);}
        }
    }
}