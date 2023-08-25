import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] check=new boolean[n+1];
        
        for(int i=2;i<=n;i++){
        boolean checkValue=true; //true=소수이다 false=소수 아니다
            if(check[i]==false){
                for(int j=2;j<2/i;j++){
                    if(i%j==0){
                        checkValue=false;
                        break;
                    }
            }
                if(checkValue){
                    answer++;
                    // System.out.println(i+"-0");
                    int cnt=2;
                    for(int j=i;j<=n;j=i*cnt++){
                        // System.out.println(j);
                        check[j]=true;
                    }
                    }
            }
        }
        
        return answer;
    }
}