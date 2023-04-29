import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> c1=new LinkedList<>();
        Queue<String> c2=new LinkedList<>();
        int flag=0;
        
        for(String c:cards1)
            c1.add(c);
        for(String c:cards2)
            c2.add(c);
        
        for(String g:goal){
            if(!c1.isEmpty()){
                if(c1.peek().equals(g)){
                    c1.poll();
                    continue;
                }
            }
            if(!c2.isEmpty()){
                if(c2.peek().equals(g)){
                    c2.poll();
                    continue;
                }
            }
            flag=1;
            break;
        }
        if(flag==0)
            answer="Yes";
        else
            answer="No";
        
        return answer;
    }
}