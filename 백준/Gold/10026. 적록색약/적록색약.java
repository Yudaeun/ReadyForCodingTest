import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n,answer1,answer2;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static boolean[][] visited;
    static char [][] map1; //적록색약o
    static char [][] map2; //적록색약x

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map1=new char[n][n];
        map2=new char[n][n];
        for(int i=0;i<n;i++){
            String temp=br.readLine();
            for(int j=0;j<n;j++){
                map1[i][j]=(char)temp.charAt(j);
                map2[i][j]=(char)temp.charAt(j);
                if(map2[i][j]=='G'){
                    map2[i][j]='R';
                }
            }
        }
        visited=new boolean[n][n];

        for(int i=0;i<n;i++){//적록색약o
            for(int j=0;j<n;j++){
                if((visited[i][j]==false)){
                    bfs(i,j,map1[i][j],map1);
                    answer1++;
                }
            }
        }
        visited=new boolean[n][n];
        for(int i=0;i<n;i++){//적록색약x
            for(int j=0;j<n;j++){
                if((visited[i][j]==false)){
                    bfs(i,j,map2[i][j],map2);
                    answer2++;
                }
            }
        }
        System.out.printf("%d %d",answer1,answer2);

    }
    public static void bfs(int x,int y,char flag,char[][] map){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        while (!q.isEmpty()){
            int[] current=q.poll();
            int cx=current[0];
            int cy=current[1];
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                if (nx<0||nx>=n||ny<0||ny>=n) continue;
                if (flag=='R'&&map[nx][ny]=='R'&&visited[nx][ny]==false){
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }else if(flag=='B'&&map[nx][ny]=='B'&&visited[nx][ny]==false){
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }else if(flag=='G'&&map[nx][ny]=='G'&&visited[nx][ny]==false){
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}