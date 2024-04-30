import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> num=new ArrayList<>();
        int curNum=-1;
        
        for(int i=0;i<arr.length;i++){
            if(curNum==arr[i]){
                continue;
            }else{
                num.add(arr[i]);
                curNum=arr[i];
            }
        }
        if(curNum!=arr[arr.length-1]){
                num.add(arr[arr.length-1]);
                
            }

        return num.stream().mapToInt(Integer::intValue).toArray();
    }
}