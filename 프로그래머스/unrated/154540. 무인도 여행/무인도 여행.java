import java.util.*;

class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int n,m;
    static int[][] visited;
    static char[][] map;
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> answer=new ArrayList<>();
        n=maps.length;
        m=maps[0].length();
        map=new char[n][m];
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                map[i][j]=maps[i].charAt(j);
            }
        }
        
        visited=new int[n][m];
        int idx=0;
        
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(map[i][j]=='X') continue;
                if(visited[i][j]==0&& map[i][j] - '0' > 0){
                    answer.add(bfs(i,j));
                    System.out.println(map[i][j]-'0');
                }
            }
        }
        if (answer.size()==0){
            return new int[] {-1};
        }else{
        int[] ans=new int[answer.size()];
        for (int i=0;i<answer.size();i++){
            ans[i]=answer.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }
    }
    private static int bfs(int x,int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y]=1;
        int cnt=(map[x][y]-'0');
        while (!q.isEmpty()){
            int[] current=q.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                if (nx<0||ny<0||nx>=n||ny>=m) continue;
                if(visited[nx][ny]==0&& map[nx][ny] !='X'){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny]=1;
                    cnt+=(map[nx][ny]-'0');
                }
            }        
        }
        return cnt;
    }
}