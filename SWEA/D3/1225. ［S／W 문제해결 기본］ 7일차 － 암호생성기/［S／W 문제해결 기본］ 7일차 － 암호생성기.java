import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        for(int test = 1; test<11; test++){
            int n= sc.nextInt();
            ArrayDeque<Integer> q=new ArrayDeque<>();
            for(int i=0;i<8;i++){
                q.add(sc.nextInt());
            }
            int cnt=1;
            int temp=0;
            while(!q.isEmpty()){
                if(cnt>5)
                    cnt=1;
                if(q.peekLast()<=0){
                    q.pollLast();
                    q.addLast(0);
                    System.out.printf("#%d ",test);
                    for(int x:q){
                        System.out.printf("%d ",x);
                    }
                    break;
                }
                q.addLast(q.pollFirst()-cnt++);
            }System.out.println();
        }

    }
}