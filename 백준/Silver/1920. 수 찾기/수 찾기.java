import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arrN=new int[n];
		for(int i=0;i<n;i++) {
			arrN[i]=sc.nextInt();
		}
		int m=sc.nextInt();
		int[] arrM=new int[m];
		for(int i=0;i<m;i++)
			arrM[i]=sc.nextInt();
		
		Arrays.sort(arrN);
		
		for(int i=0;i<m;i++) {
			int start=0;
			int end=n-1;
			int mid=0;
			int target=arrM[i];
			int flag=0;
		while(start<=end) {
			mid=(start+end)/2;
			
			if(arrN[mid]==target) {
				System.out.println(1);
				flag=1;
				break;
			}
			else if(arrN[mid]>target) {
				end=mid-1;
			}else {
				start=mid+1;
			}	
		}
		if(flag==0)
			System.out.println(0);
		}
	}

}
