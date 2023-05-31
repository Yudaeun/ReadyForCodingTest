import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        String start="ABCDEF";
        for(int test=0;test<t;test++){
            String s=br.readLine();
            int idx=0;
            if (start.indexOf(s.charAt(0))>=0) {
                if(s.charAt(0)=='A'){
                    idx=0;
                }else{
                    idx=1;
                }
            }
            char flag='A';

            if(flag=='A'){
                    while(s.charAt(idx)=='A'){
                        idx++;
                    }
                    flag='F';
            }if(flag=='F'){
                    while(s.charAt(idx)=='F'){
                        idx++;
                    }
                    flag='C';
            }if(flag=='C'){
                while(idx<s.length()&&s.charAt(idx)=='C'){
                    idx++;
                }
            }
            if((idx==s.length()-1&&start.indexOf(s.charAt(s.length()-1))>=0)||idx==s.length()){
                    System.out.println("Infected!");
            }else{
                System.out.println("Good");
            }
            }
        }
    }