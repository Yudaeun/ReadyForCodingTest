import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int m;
    public static boolean[] visit;
    public static int[][] graph;
    public static int answer=0;


    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        graph=new int[n+1][n+1];
        visit=new boolean[n+1];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            graph[a][b]=1;
            graph[b][a]=1;
        }

        for (int i=1;i<=n;i++){
            if (!visit[i]){
                dfs(0,i);
                answer++;
            }
        }

        System.out.println(answer);

    }

    public static void dfs(int depth,int start){
        if(depth == n){
            return;
        }

        visit[start]=true;
        for(int i=1;i<=n;i++){
            if (!visit[i] && graph[start][i]==1){
                dfs(depth+1,i);
            }
        }
    }
}
