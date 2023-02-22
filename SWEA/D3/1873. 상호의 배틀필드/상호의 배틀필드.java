import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static char[][] map;
    static int x,y,h,w;
    static char mod;
    static boolean shoot;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        for (int test=0;test<t;test++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            x=0;
            y=0;
            shoot=false;

            for (int i = 0; i <h;i++){
                String temp=br.readLine();
                for(int j=0;j<w;j++){
                    map[i][j]=temp.charAt(j);
                    if(map[i][j]=='>'||map[i][j]=='<'||map[i][j]=='^'||map[i][j]=='v'){
                        x=i;
                        y=j;

                        if(map[i][j]=='>')
                            mod='R';
                        else if(map[i][j]=='<')
                            mod='L';
                        else if(map[i][j]=='^')
                            mod='U';
                        else if(map[i][j]=='v')
                            mod='D';
                        map[i][j]='.';
                    }
                }
            }
            int n=Integer.parseInt(br.readLine());
            String temp=br.readLine();
            char[] word=new char[n];
            for(int i=0;i<n;i++){
                word[i]= (char) (temp.charAt(i));
                if(word[i]=='S')
                    shoot=true;
                else mod=word[i];
                move(x,y);
//                System.out.println(Arrays.deepToString(map)+mod+x+" "+y);
            }
            if(mod=='U') map[x][y]='^';
            else if(mod=='D') map[x][y]='v';
            else if(mod=='L') map[x][y]='<';
            else if(mod=='R') map[x][y]='>';
            System.out.printf("#%d ",test+1);
//            System.out.println(Arrays.deepToString(map));
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    System.out.printf("%c",map[i][j]);
                }System.out.println();
            }
        }
    }
    public static void move(int cx,int cy){
        if(shoot){
            x=cx;y=cy;
            if(mod=='U'){
                while(true){
                    if(cx-1<0) break;
                    if(map[cx-1][cy]=='.')
                        cx--;
                    else if(map[cx-1][cy]=='*'){
                        cx--;
                        map[cx][cy]='.';
                        break;
                    }
                    else if(map[cx-1][cy]=='#')
                        break;
                    else if(map[cx-1][cy]=='-') cx--;
                }
            }else if(mod=='D'){
                while(true){
                    if(cx+1>=h) break;
                    if(map[cx+1][cy]=='.')
                        cx++;
                    else if(map[cx+1][cy]=='*'){
                        cx++;
                        map[cx][cy]='.';
                        break;
                    }
                    else if(map[cx+1][cy]=='#')
                        break;
                    else if(map[cx+1][cy]=='-') cx++;
                }
            }else if(mod=='L'){
                while(true){
                    if(cy-1<0) break;
                    if(map[cx][cy-1]=='.')
                        cy--;
                    else if(map[cx][cy-1]=='*'){
                        cy--;
                        map[cx][cy]='.';
                        break;
                    }
                    else if(map[cx][cy-1]=='#')
                        break;
                    else if(map[cx][cy-1]=='-') cy--;
                }
            }else if(mod=='R'){
                while(true){
                    if(cy+1>=w) break;
                    if(map[cx][cy+1]=='.')
                        cy++;
                    else if(map[cx][cy+1]=='*'){
                        cy++;
                        map[cx][cy]='.';
                        break;
                    }
                    else if(map[cx][cy+1]=='#')
                        break;
                    else if(map[cx][cy+1]=='-') cy++;
                }
            }
            shoot=false;
        }
        else if(mod=='U'){
            if(cx-1>=0&& map[cx-1][cy]=='.'){
                x=cx-1;
            }
        }else if(mod=='D'){
            if(cx+1<h&&map[cx+1][cy]=='.'){
                x=cx+1;
            }
        }else if(mod=='L'){
            if(cy-1>=0&&map[cx][cy-1]=='.'){
                y=cy-1;
            }
        }else if(mod=='R'){
            if(cy+1<w&&map[cx][cy+1]=='.'){
                y=cy+1;
            }
        }
    }
}