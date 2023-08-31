import java.util.*;

class Solution {
    public long solution(long n) {
        String str=String.valueOf(n);
        Integer[] arr=new Integer[str.length()];
        
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.valueOf(str.charAt(i)-'0');
        }
        
        Arrays.sort(arr,Collections.reverseOrder());
        
        String descNumStr=Arrays.toString(arr).replaceAll("[^0-9]","");    
        
        return Long.valueOf(descNumStr);
    }
}