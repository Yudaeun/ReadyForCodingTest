import java.io.*;
import java.util.*;

public class Main {
    static int n,m,ans;
    static int num[][];
    static boolean visited[][];
    static boolean resultVisited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        num=new int[n][m];
        resultVisited=new boolean[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                num[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!resultVisited[i][j]){
                    bfs(i,j,num[i][j]);
                }
            }
        }
        System.out.println(ans);

    }
    public static void bfs(int x,int y,int target){
        int[] dx={-1,1,0,0,-1,-1,1,1};
        int[] dy={0,0,-1,1,-1,1,-1,1};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        visited=new boolean[n][m];
        visited[x][y]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int cx=cur[0];
            int cy=cur[1];
            for(int i=0;i<8;i++){
                int nx=dx[i]+cx;
                int ny=dy[i]+cy;
                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(num[nx][ny]>target){
                    return;
                }
                if(num[nx][ny]==target&&!visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j])
                    resultVisited[i][j]=true;
            }
        }
        ans++;
    }
}