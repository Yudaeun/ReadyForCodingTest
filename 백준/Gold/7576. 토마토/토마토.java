import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<int[]> q;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int answer,m,n;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        q=new LinkedList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }
        answer=0;
        bfs();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0){
                    System.out.println(-1);
                    System.exit(0);
                }
                answer=Math.max(answer,map[i][j]);

            }
        }
        System.out.println(answer-1);


    }
    public static void bfs(){

        while (!q.isEmpty()){
            int[] current=q.poll();
            int cx=current[0];
            int cy=current[1];
            for (int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                if (nx<0||nx>=n||ny<0||ny>=m) continue;
                if(map[nx][ny]==0){
                    q.add(new int[]{nx,ny});
                    map[nx][ny]=map[cx][cy]+1;
                }
            }
        }
    }
}