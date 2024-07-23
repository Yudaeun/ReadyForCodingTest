import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st=new StringTokenizer(br.readLine());
       int d=Integer.parseInt(st.nextToken());
       int k=Integer.parseInt(st.nextToken());

        for (int i=1;i<=k;i++){
            for (int j=1;j<=k;j++){
                int res=i+j;
                int prev=j;
                int cur=-1;
                if(res>k){
                    continue;
                }
                if(res == k && d == 3){
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
                for (int n=4;n<=d;n++){
                    cur=prev;
                    prev=res;
                    res+=cur;
//                    if(res>k){
//                        break;
//                    }
                }
                if(res == k){
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
