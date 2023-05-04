import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Long> list=new ArrayList<>();
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        visited=new boolean[10];

        list.add((long)0);
        for(int i=1;i<=9;i++){
            dfs(i);
        }
        Collections.sort(list);

        if(n>=list.size()){
            System.out.println(-1);
        }else {
            System.out.println(list.get(n));
        }
    }
    static void dfs(long num){
        if(check(num)){
            list.add(num);
        }else{
            return;
        }
        for(int i=0;i<=9;i++) {
                dfs(num * 10 + i);
        }
    }
    static boolean check(long num){
        String s=String.valueOf(num);
        for(int i=1;i<s.length();i++){
            if(Integer.parseInt(String.valueOf(s.charAt(i)))>=
            Integer.parseInt(String.valueOf(s.charAt(i-1)))){
                return false;
            }
        }
        return true;
    }
}