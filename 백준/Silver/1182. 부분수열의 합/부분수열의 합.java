import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
		static int n,s;
		static int r;
		static int answer;
		static boolean[] visited;
		static int[] num;
    	 public static void main(String[] args) throws IOException {
    		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		 StringTokenizer st;
    		 st=new StringTokenizer(br.readLine());
    		 n=Integer.parseInt(st.nextToken());
    		 s=Integer.parseInt(st.nextToken());
    		 num=new int[n];
    		 st=new StringTokenizer(br.readLine());
    		 for(int i=0;i<n;i++) {
    			 num[i]=Integer.parseInt(st.nextToken());
    		 }
    		 for(int i=1;i<n+1;i++) {
    			 visited=new boolean[n];
    			 comb(0,i);
    		 }
    		System.out.println(answer);
    			
    		
    		 
    }
    	 public static void comb(int cnt,int start) {
    		 if(start==0) {
    			 int sum=0;
    			 for(int i=0;i<n;i++) {
    				 if(visited[i]) {
    					 sum+=num[i];
    				 }
    			 }
    			 if(sum==s) {
    				 answer++;
    			 }
    			 return;
    		 }
    		 if(cnt==n)
    			 return;
    		 
    		 visited[cnt]=true;
    		 comb(cnt+1,start-1);
    		 visited[cnt]=false;
    		 comb(cnt+1,start);
    	 }
    	 }