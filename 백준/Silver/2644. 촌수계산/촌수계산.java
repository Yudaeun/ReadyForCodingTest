import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int m;
    public static boolean[] visited;
    public static int[][] graph;
    public static int answer=-1;
    public static int first,second;

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        first=Integer.parseInt(st.nextToken());
        second=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(br.readLine());
        graph=new int[n+1][n+1];
        visited=new boolean[n+1];

        for(int i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph[a][b]=1;
            graph[b][a]=1;
        }

        dfs(0,first,second);

        System.out.println(answer);
    }

    public static void dfs(int depth,int start,int target){
        if (start == target){
            answer=depth;
        }

        if (depth == n){
            return;
        }

        visited[start]=true;

        for(int i=1;i<=n;i++){
            if(!visited[i] && (graph[start][i]==1 || graph[i][start]==1)){
                visited[i]=true;
                dfs(depth+1,i,target);
//                visited[i]=false;
            }
        }
    }
}