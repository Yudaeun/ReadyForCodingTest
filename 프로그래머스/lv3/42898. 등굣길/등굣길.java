import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] num=new int[n+1][m+1];
        for(int i=0;i<puddles.length;i++){
            if(puddles[i].length==0) continue;
            num[puddles[i][1]][puddles[i][0]]=-1;         
        }
        for(int i=0;i<=m;i++){
            if(num[1][i]==-1) break;
            num[1][i]=1;
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(num[i][j]==-1||(num[i][j-1]==-1&&num[i-1][j]==-1)) continue;
                if(num[i][j-1]==-1){
                    num[i][j]=num[i-1][j]%1000000007;
                    continue;
                }
                if(num[i-1][j]==-1){
                    num[i][j]=num[i][j-1]%1000000007;
                    continue;
                }
                num[i][j]=(num[i][j-1]+num[i-1][j])%1000000007;
            }
        }
        
        return num[n][m];
    }
}