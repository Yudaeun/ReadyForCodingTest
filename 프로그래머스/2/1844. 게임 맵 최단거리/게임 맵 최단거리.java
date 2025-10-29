import java.util.*;

class Solution {
    static int[][] visited;
    static int[] x = {-1, 1, 0, 0};
    static int[] y = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length];
        
        bfs(maps);
        
        answer = visited[maps.length - 1][maps[0].length - 1];
        
        if (answer == 0) {
            return -1;
        } else {
            return answer;
        }
    }
    
    private void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = 1;
        q.add(new int[]{0, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int dx = cx + x[i];
                int dy = cy + y[i];
                
                if (dx < 0 || dy < 0 || dx >= maps.length || dy >= maps[0].length) {
                    continue;
                }
                
                if (maps[dx][dy] == 1 && visited[dx][dy] == 0) {
                    visited[dx][dy] = visited[cx][cy] + 1;
                    q.add(new int[]{dx, dy});
                }
            }
        }
    }
}