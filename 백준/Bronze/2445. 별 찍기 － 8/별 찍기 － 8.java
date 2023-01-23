import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		
		for(int i=0;i<num;i++) {
			for(int j=0;j<=i;j++) {
				System.out.printf("*");
			}
			for(int j=0;j<2*(num-(i+1));j++) {
				System.out.printf(" ");
			}
			for(int j=0;j<=i;j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		for(int i=1;i<num;i++) {
			for(int j=0;j<num-i;j++) {
				System.out.printf("*");
			}
			for(int j=0;j<2*i;j++) {
				System.out.printf(" ");
			}
			for(int j=0;j<num-i;j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}

}
