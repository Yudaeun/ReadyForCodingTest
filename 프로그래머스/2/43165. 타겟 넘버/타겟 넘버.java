import java.util.*;

class Solution {
    static int answer=0;
    static int idx=0;
    
    public int solution(int[] numbers, int target) {
        idx=numbers.length;
        
        dfs(0,0,target,numbers);
        
        return answer;
    }
    
    public void dfs(int curNum, int curIdx, int target, int[] numbers){
        if (curNum==target && curIdx==idx){
            answer++;
            return;
        }
        if (curIdx==idx){
            return;
        }
        
        dfs(curNum-numbers[curIdx], curIdx+1, target, numbers);
        dfs(curNum+numbers[curIdx], curIdx+1, target, numbers);
    }
}
