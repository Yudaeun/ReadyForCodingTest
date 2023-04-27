import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int idx=0;
        ArrayList<String> s=new ArrayList<>();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='-'){
                s.add(str.substring(idx,i));
                idx=i;
            }
        }s.add(str.substring(idx,str.length()));

        int answer=0;
        for(String a:s){
            if(a.charAt(0)!='-'){
                answer+=sum(0,a);
                continue;
            }
            answer-=sum(1,a);
        }
        System.out.println(answer);
    }
    static private int sum(int check,String a){
        int temp=0;
        int idx=check;
        for(int i=check;i<a.length();i++){
            if(a.charAt(i)=='+'){
                temp+=Integer.parseInt(a.substring(idx,i));
                idx=i;
            }
        }
        temp+=Integer.parseInt(a.substring(idx,a.length()));
        return temp;
    }
}