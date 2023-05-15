import java.util.*;
class Solution {
    static int answer=0;
    static int n;
    static int[] num;
    public int solution(int[] numbers, int target) {
        n=numbers.length;
        num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=numbers[i];
        }
        
        dfs(0,target,0);
        return answer;
    }
    
    private void dfs(int depth,int target,int sum){
        if(depth==n){
            if(sum==target) answer++;
            return;
        }
        sum+=num[depth];
        dfs(depth+1,target,sum);
        sum-=num[depth]*2;
        dfs(depth+1,target,sum);
    }
    
}