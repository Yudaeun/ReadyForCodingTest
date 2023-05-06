import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int a=1;int b=0;
        char first=s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(first==s.charAt(i)){
                a++;
            }else{
                b++;
                if(a==b){
                    answer++;
                    if(i==s.length()-1) continue;
                    first=s.charAt(i+1);
                    a=0;
                    b=0;
                }
            }
        }
        if(a!=b) answer++;
        return answer;
    }
}