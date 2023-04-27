import java.io.*;
import java.util.*;

public class Main {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][] num;
    static int[] check;
    static HashSet<String> list=new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num=new int[5][5];
        StringTokenizer st;
        for(int i=0;i<5;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                num[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                check=new int[6];
                check[0]=num[i][j];
                dfs(i,j,1);
            }
        }
        System.out.println(list.size());

    }

    static void dfs(int x,int y,int depth){
        if(depth==6){
            StringBuilder sb=new StringBuilder();
            for(int n:check){
                sb.append(String.valueOf(n));
            }
            String s=String.valueOf(sb);
            list.add(s);
            return;
        }
        for(int i=0;i<4;i++){
            int nx=x+dx[i],ny=y+dy[i];
            if(nx<0||ny<0||nx>=5||ny>=5) continue;
            check[depth]=num[nx][ny];
            dfs(nx,ny,depth+1);
        }
    }
}