import java.io.*;
import java.util.*;

public class Main {
    static int n,m,h;
    static int visited[][][];
    static int map[][][];
    static Queue<int[]> q=new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken()); //y
        n=Integer.parseInt(st.nextToken()); //x
        h=Integer.parseInt(st.nextToken());//h
        map=new int[h][n][m];

        visited=new int[h][n][m];
        for(int k=0;k<h;k++) {
            for (int i = 0; i < n; i++) {
                st=new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[k][i][j]=Integer.parseInt(st.nextToken());
                    if(map[k][i][j]==1) {
                        q.add(new int[]{k, i, j});
                        visited[k][i][j]=1;
                    }
                }
            }
        }
        bfs();
        int answer=isValid();
        System.out.println(answer);
        }

    static void bfs(){
        int[] dx={-1,1,0,0,0,0};
        int[] dy={0,0,-1,1,0,0};
        int[] dh={0,0,0,0,-1,1};
        while(!q.isEmpty()){
            int[] current=q.poll();
            int cx=current[1];
            int cy=current[2];
            int ch=current[0];
            for(int i=0;i<6;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                int nh=ch+dh[i];
                if(inRange(nh,nx,ny)){
                    if(visited[nh][nx][ny]==0 && map[nh][nx][ny]==0){
                        visited[nh][nx][ny]=visited[ch][cx][cy]+1;
                        q.add(new int[]{nh,nx,ny});
                    }
                }
            }
        }
    }
    static boolean inRange(int he,int x, int y){
        return 0<=he&&he<h&&0<=x&&x<n&&0<=y&&y<m;
    }
    static int isValid(){
        int maxNum=0;
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(visited[i][j][k]==0&&map[i][j][k]!=-1&&map[i][j][k]!=1)
                        return -1;
                    maxNum=Math.max(maxNum,visited[i][j][k]);
                }
            }
        }
        return maxNum-1;
    }
}