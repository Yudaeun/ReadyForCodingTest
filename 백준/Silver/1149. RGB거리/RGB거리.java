import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //n번집은 n-1번집과 색이 같지 않아야 한다.
        //n-1이 빨강-> 초, 파
        //n-1이 초록->빨, 파
        //n-1이 파랑->빨, 초
        //그냥 하나하나 다 확인하면서 칠해보고 마지막에 나오는 애를...
        //한 집마다 전부 다 확인하면서 min값을 갱신하면 될듯 그리고 마지막에 min값 출력하고

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map=new int[n][3];
        for (int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1;i<n;i++){
            for (int j=0;j<3;j++){
                if (j==0){ //RED
                    //choose the GREEN or BLUE of n-1 home color
                    map[i][j]+=Math.min(map[i-1][1],map[i-1][2]);
                }else if(j==1){ //GREEN
                    map[i][j]+=Math.min(map[i-1][0],map[i-1][2]);
                }else{ //BLUE
                    map[i][j]+=Math.min(map[i-1][0],map[i-1][1]);
                }
            }
        }
        int answer=Integer.MAX_VALUE;
        for (int i=0;i<3;i++){
            answer=Math.min(answer,map[n-1][i]);
        }
        System.out.println(answer);


    }
}