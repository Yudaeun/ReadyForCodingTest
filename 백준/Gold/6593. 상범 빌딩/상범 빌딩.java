import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int l,r,c;
    static char[][][] map;
    static int[][][] visited;
    static int[] dx={-1,1,0,0,0,0};
    static int[] dy={0,0,-1,1,0,0};
    static int[] dl={0,0,0,0,-1,1};
    static int[] start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken()); //층
            r = Integer.parseInt(st.nextToken()); //층의 행
            c = Integer.parseInt(st.nextToken()); //층의 열
            //#는 지나갈 수 없고 비어있으면 .
            if(l==0&&r==0&&c==0) break;

            map = new char[l][r][c];
            start=new int[3];
            for (int i = 0; i < l; i++) {
                for(int j=0;j<r;j++){
                    String str=br.readLine();
                    if(str.equals("")) str=br.readLine();
                    for(int k=0;k<c;k++){
                        char cur=str.charAt(k);
                        map[i][j][k]=cur;
                        if(map[i][j][k]=='S'){
                            start[0]=i; start[1]=j; start[2]=k;
                            map[i][j][k]='.';
                        }
                    }
                }
            }String str=br.readLine();
            visited=new int[l][r][c];
            int answer=bfs(start[0],start[1],start[2]);

            if(answer==-1){
                System.out.println("Trapped!");
            }else{
                System.out.printf("Escaped in %d minute(s).\n",answer);
            }

        }
    }

    private static boolean inRange(int nl, int nx, int ny){
        return 0<=nl && nl<l &&0<=nx&& nx<r && 0<=ny && ny<c;
    }

    private static int bfs(int l, int x, int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{l,x,y});
        while(!q.isEmpty()){
            int current[]=q.poll();
            int cl=current[0], cx=current[1], cy=current[2];
            for(int i=0;i<6;i++){
                int nl=cl+dl[i], nx=cx+dx[i], ny=cy+dy[i];
                if(inRange(nl,nx,ny)){
                    if(map[nl][nx][ny]=='.'&&visited[nl][nx][ny]==0){
                    visited[nl][nx][ny]=visited[cl][cx][cy]+1;
                    q.add(new int[]{nl,nx,ny});
                    }else if(map[nl][nx][ny]=='E'){
                        return visited[cl][cx][cy]+1;
                    }
                }
            }
        }
        return -1;
    }
}