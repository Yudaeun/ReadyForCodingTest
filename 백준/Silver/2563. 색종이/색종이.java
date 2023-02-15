import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
		
    	 public static void main(String[] args) throws IOException {
    		 Scanner sc =new Scanner(System.in);
    		 int n=sc.nextInt();
    		 int[][] arr=new int[101][101];
    		 int cnt=0;
    		 for(int i=0;i<n;i++) {
    			 int x=sc.nextInt();
    			 int y=sc.nextInt();
    			 
    			 for(int j=x;j<x+10;j++) {
    				 for(int k=y;k<y+10;k++) {
    					 if(arr[j][k]==0) {
    						 arr[j][k]=1;
    						 cnt++;}
    			 }
    				 }
    		 }
    		 System.out.println(cnt);
    		 
    }
    	 }