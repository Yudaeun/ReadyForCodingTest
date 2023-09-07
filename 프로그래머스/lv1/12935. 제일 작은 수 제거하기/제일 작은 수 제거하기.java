import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length==1){
            return new int[] {-1};
        }else{
            List<Integer> list=new ArrayList<>();
            int min=Integer.MAX_VALUE;
            int minIdx=0;
            
            for(int i=0;i<arr.length;i++){
                if(min>arr[i]){
                    min=arr[i];
                    minIdx=i;
                }
            }
            
            for(int i=0;i<arr.length;i++){
                if(i==minIdx){
                    continue;
                }else{
                    list.add(arr[i]);
                }
            }
    
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        }
    }
}