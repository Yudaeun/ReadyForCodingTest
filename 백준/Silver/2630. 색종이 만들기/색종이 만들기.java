import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] num;
    static int white,blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        num=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                num[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        white=0;
        blue=0;
        paper(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void paper(int x,int y,int size){
        if(check(x,y,size)!=-1){
            if(num[x][y]==1)
                blue++;
            else
                white++;
            return;
        }

        int newSize=size/2;
        paper(x,y,newSize);
        paper(x,y+newSize,newSize);
        paper(x+newSize,y,newSize);
        paper(x+newSize,y+newSize,newSize);
    }
    public static int check(int x,int y,int size){
        int temp=num[x][y];
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(temp!=num[i][j]) return -1;
            }
        }
        return temp;
    }
}