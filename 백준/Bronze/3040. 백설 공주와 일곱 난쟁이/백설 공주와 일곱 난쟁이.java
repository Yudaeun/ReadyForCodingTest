import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
		
    	 public static void main(String[] args) throws IOException {
    		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		 int[] num=new int[9];
    		 int sum=0;
    		 for(int i=0;i<9;i++) {
    			 num[i]=Integer.parseInt(br.readLine());
    			 sum+=num[i];
    		 }
    		 for(int i=0;i<9;i++) {
    			 for(int j=0;j<9;j++) {
    				 if(i==j) continue;
    				 sum=sum-num[i]-num[j];
    				 if (sum==100) {
    					for(int k=0;k<9;k++) {
    						if(k==i||k==j) continue;
    						System.out.println(num[k]);
    						
    					}return;
    				 }else {
    					 sum+=num[i]+num[j];
    				 }
    			 }
    		 }
    				
    		 
    }
    	
    	
    	 }