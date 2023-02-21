import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int r=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        int[][] num=new int[r+1][c+1];
        for(int i=1;i<r+1;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<c+1;j++){
                num[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<r+1;i++){
            for(int j=1;j<c+1;j++){
                num[i][j]+=num[i][j-1];
            }
        }
        int bright=0;
//        System.out.println(Arrays.deepToString(num));
        for(int i=0;i<q;i++){
            bright=0;
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            for(int j=x1;j<=x2;j++){
                bright+=(num[j][y2]-num[j][y1-1]);
            }
            System.out.println((int)(bright/((y2-y1+1)*(x2-x1+1))));

        }

    }
}