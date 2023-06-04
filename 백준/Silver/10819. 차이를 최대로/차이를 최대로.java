import java.io.*;
import java.util.*;

public class Main {
    static int[] num,value;
    static boolean[] visited;
    static int ans,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        visited=new boolean[n];
        num=new int[n];
        value=new int[n];
        ans=Integer.MIN_VALUE;
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(ans);
        }
        public static void perm(int depth){
            if(depth==n){
                ans=Math.max(ans,check());
                return;
            }

            for(int i=0;i<n;i++){
                if(!visited[i]){
                    visited[i]=true;
                    value[depth]=num[i];
                    perm(depth+1);
                    visited[i]=false;
                }
            }
        }
        public static int check(){
            int sum=0;
            for(int i=0;i<n-1;i++){
                sum+=Math.abs(value[i]-value[i+1]);
            }
            return sum;
        }
    }
