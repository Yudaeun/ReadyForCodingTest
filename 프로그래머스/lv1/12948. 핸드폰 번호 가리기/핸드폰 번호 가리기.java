import java.util.*;

class Solution {
    public String solution(String phone_number) {
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<phone_number.length();i++){
            if(i>=phone_number.length()-4){
                sb.append(phone_number.charAt(i)-'0');
            }else{
            sb.append("*");
                }
            
                }
        return String.valueOf(sb);
    }
}