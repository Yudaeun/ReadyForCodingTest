import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test=Integer.parseInt(br.readLine());
        for(int t=0;t<test;t++){
            st=new StringTokenizer(br.readLine());
            int l=Integer.parseInt(st.nextToken()); //막대의 길이
            int n=Integer.parseInt(st.nextToken()); //개미의 수
            int[] ant=new int[n];
            for(int i=0;i<n;i++){
                ant[i]=Integer.parseInt(br.readLine());
            }
            Arrays.sort(ant);
            int[] fastAnts=new int[n];
            int fastTime=0;
            for(int i=0;i<n;i++){
                fastAnts[i]=Math.min(l-ant[i],ant[i]);
                fastTime=Math.max(fastTime,fastAnts[i]);
            }
            int slowTime=Math.max(l-ant[0],ant[n-1]);

            System.out.printf("%d %d\n",fastTime,slowTime);

        }

    }
}