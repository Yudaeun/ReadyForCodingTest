import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        int num[][]=new int[n][3];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            num[i][0]=Integer.parseInt(st.nextToken());
            num[i][1]=Integer.parseInt(st.nextToken());
            num[i][2]=Integer.parseInt(st.nextToken());
        }
        int dp[]=new int[d+1];
        Arrays.sort(num,(o1,o2)->{return o1[1]-o2[1];});
        for(int i=0;i<d+1;i++){
            dp[i]=i;
        }
        for(int i=0;i<n;i++) {
            if (num[i][1] > d) continue;
                dp[num[i][1]] = Math.min(dp[num[i][1]], dp[num[i][0]]+num[i][2]);
            for(int j=1;j<d+1;j++){
                dp[j]=Math.min(dp[j-1]+1,dp[j]);
            }

        }

        System.out.println(dp[d]);
    }
}