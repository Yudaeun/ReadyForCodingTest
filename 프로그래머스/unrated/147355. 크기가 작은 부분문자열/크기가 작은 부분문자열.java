import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for(int i=0;i<t.length()-p.length()+1;i++){
            String s=t.substring(i,i+p.length());
            if(Long.valueOf(s)<=Long.valueOf(p))
                answer++;
        }
        return answer;
    }
}