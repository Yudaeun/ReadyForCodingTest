import java.util.*;

class Solution {
    static int answer=-1;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited=new boolean[dungeons.length];
        int[] numbers=new int[dungeons.length];
        
        dfs(k,0,visited,numbers,dungeons.length,dungeons);
        
        return answer;
    }
    
    private void dfs(int k, int depth, boolean[] visited, int[] numbers, int endCnt,int[][] dungeons){
        if(depth==endCnt){
            int cnt=0;
            for(int i=0;i<numbers.length;i++){
                if(dungeons[numbers[i]][0]<=k){
                    k-=dungeons[numbers[i]][1];
                    cnt++;
                }
                if (k<0){
                    answer=Math.max(answer,cnt);
                    break;
                }answer=Math.max(answer,cnt);
            }
            return;
        }
        
        for(int i=0;i<endCnt;i++){
            if(!visited[i]){
                visited[i]=true;
                numbers[depth]=i;
                dfs(k,depth+1,visited,numbers,endCnt,dungeons);
                visited[i]=false;
            }
        }
    }
}