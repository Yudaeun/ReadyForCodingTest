import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int n,m,answer;
    static int map[][];
    static int visited[];
    static ArrayList<int[]> chicken=new ArrayList<>();
    static ArrayList<int[]> home=new ArrayList<>();
    static Stack<int[]> choose=new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //치킨집의 좌표와 집의 좌표를 모두 리스트에 저장해둠
        //dfs 돌면서 만약 깊이가 m이 되면 멈추고 dfs돌면서 저장한 치킨집좌표를 꺼내며
        //2중 루프 돌면서 가장 가까운 집까지의 거리를 계산한다
        //3중 루프를 다 돌고 나면 치킨 거리를 비교 갱신 후 return
        //치킨집을 고르는건... 백트래킹으로
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==2)
                    chicken.add(new int[]{i,j});
                else if(map[i][j]==1)
                    home.add(new int[]{i,j});
            }
        }
        answer=Integer.MAX_VALUE;
        visited=new int[chicken.size()];
        dfs(0,0);
        System.out.println(answer);
    }
    static void dfs(int depth,int start){
        //도시의 치킨 거리는 모든 집의 치킨 거리의 합...
        //치킨 집에서 가장 가까운 집을 구하는 게 아니라 모든 집에서 가장 가까운 치킨집 거리를 더하는 거였다..
        if(depth==m){
            int sumDist=0;
            for(int x=0;x<n;x++){
                for(int y=0;y<n;y++){
                    if(map[x][y]==1){
                        int minDist=Integer.MAX_VALUE;
                        for(int i=0;i<choose.size();i++){
                            int cx=choose.get(i)[0];
                            int cy=choose.get(i)[1];
                            minDist=Math.min(minDist,(Math.abs(cx-x)+Math.abs(cy-y)));
                        }
                        sumDist+=minDist;
                    }
                }
            }
            answer=Math.min(answer,sumDist);
            return ;
        }
        for(int i=start;i<chicken.size();i++){
            if(visited[i]==0){
                visited[i]=1;
                choose.push(new int[]{chicken.get(i)[0],chicken.get(i)[1]});
                dfs(depth+1,i);
                visited[i]=0;
                choose.pop();
            }
        }
    }
}