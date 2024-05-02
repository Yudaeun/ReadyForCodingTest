import java.util.*;

class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited=new int[maps.length][maps[0].length];
        
        answer=bfs(maps,visited);
        
        return answer;
    }
    
    private int bfs(int[][] maps, int[][] visited){
        int x=0;
        int y=0;
        visited[x][y]=1;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        
        while(!q.isEmpty()){
            int[] current=q.poll();
            int cx=current[0];
            int cy=current[1];
            for (int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                if (0<=nx && nx<maps.length && 0<=ny && ny<maps[0].length){
                    if(maps[nx][ny]!=0 && visited[nx][ny]==0){
                        visited[nx][ny]=visited[cx][cy]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        if (visited[maps.length-1][maps[0].length-1]==0){
            return -1;
        }else{
            return visited[maps.length-1][maps[0].length-1];
        }
    }
}