import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[6];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<6;i++) {
			int num=sc.nextInt();
			if(i==0)
				arr[i]=1-num;
			else if(i==1)
				arr[i]=1-num;
			else if(i==2)
				arr[i]=2-num;
			else if(i==3)
				arr[i]=2-num;
			else if(i==4)
				arr[i]=2-num;
			else if(i==5)
				arr[i]=8-num;
		}
		for(int num:arr)
			System.out.printf("%d ",num);
		
	}

}
