import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[n+1];
        if(n>=2)
            dp[2]=1;
        if(n>=3)
            dp[3]=1;
        for (int i=4;i<n+1;i++){
            if(i-1>0) {
               dp[i] = dp[i-1];
                }
            if(i/2>0&&i%2==0){
                if(dp[i]!=0){
                    dp[i]=Math.min(dp[i],dp[i/2]);
                }else{
                dp[i]=dp[i/2];
            }
            }
            if(i/3>0&&i%3==0){
                if(dp[i]!=0){
                    dp[i]=Math.min(dp[i],dp[i/3])+1;
                    continue;
                }
                dp[i]=dp[i/3];
            }
            dp[i]+=1; //10->9->3->1

        }System.out.println(dp[n]);
    }
}