import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        ArrayList<Integer> answer=new ArrayList<>();
        int sec=0;
        boolean flag=false;
        
        for (int i=0;i<prices.length;i++){
            sec=0;
            flag=false;
            for(int j=i+1;j<prices.length;j++){
                sec++;
                if(prices[j]<prices[i]){
                    answer.add(sec);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                answer.add(sec);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}