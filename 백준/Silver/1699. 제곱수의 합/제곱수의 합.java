import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] dp=new int[n+1];
        dp[1]=1;
        int curSquareNum=1;
        int[] squareNumList=new int[n+2];

        for(int i=1;i<=squareNumList.length;i++){
            if ((int)Math.pow(i,2)>n){
                break;
            }
            squareNumList[i]=(int)Math.pow(i,2);
            dp[(int)Math.pow(i,2)]=1;
        }

        for(int i=1;i<=n;i++){
            if (i==squareNumList[curSquareNum+1]){
                curSquareNum++;
                dp[i]=1;
                continue;
            }
            else{
                dp[i]=1+dp[i-squareNumList[curSquareNum]];
                for(int j=1;j<=curSquareNum;j++){
                    dp[i]=Math.min(1+dp[i-squareNumList[j]],dp[i]);
                }
            }

        }

        System.out.println(dp[n]);
    }
}
