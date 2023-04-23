import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int i=0;i<targets.length;i++){
            String target=targets[i];
            int push=0;
            for(int j=0;j<target.length();j++){
                int temp=9999999;
                for(int k=0;k<keymap.length;k++){
                    int keyTemp=keymap[k].indexOf(target.charAt(j));
                    if(keyTemp>=0){
                        temp=Math.min(temp,keyTemp+1);
                    }
                }
                if(temp==9999999){
                    push=0;
                    break;
                }
                push+=temp; //targets의 문자열 중 존재하지 않는 key가 있으면 안됨
            }
            answer[i]=(push==0)?-1:push;
        }
        return answer;
    }
}