import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //brown+yello한 숫자에서 시작해서 1씩 줄여 나가면서
        // sum/num한 값과 현재 num 사이의 차이를 계산해서
        //차이가 가장 적은 값 두 개가 답이 된다.
        //yellow의 수도 고려해야 한다.
        //가로*2+(세로-2)*2==brown
        int sum=brown+yellow;
        int min=Integer.MAX_VALUE;
        int garo=0;int sero=0;
        
        for (int num=sum;num>0;num--){
            int sub=sum/num;
            if(sub*num==sum){
                if(sub>num){
                    sero=num;
                    garo=sub;
                }else{
                    sero=sub;
                    garo=num;
                }
                if (min>Math.abs(sub-num)&&((garo*2+(sero-2)*2)==brown)){
                    min=Math.abs(sub-num);
                    answer[0]=garo;
                    answer[1]=sero;
                    
                }
            }
        }
        
        return answer;
    }
}