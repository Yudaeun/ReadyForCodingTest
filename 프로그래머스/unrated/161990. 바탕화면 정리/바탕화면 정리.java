import java.util.*;
class Solution {
    static int n,m;
    static char[][] wall;
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        n=wallpaper.length;
        m=wallpaper[0].length();
        wall=new char[n][m];
        int fastColY=9999999, fastRowX=9999999, slowColY=-1, slowRowX=-1;
                //열이 가장 빠른 애랑, 행이 가장 빠른 애를 찾는다.
                //열이 가장 느린 애랑, 행이 가장 느린 애를 찾는다.
                //시작점=빠른[행X,열Y] 끝점=느린[행X,열Y]
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                wall[i][j]=wallpaper[i].charAt(j);
                if(wall[i][j]=='#'){
                    if(fastColY>j)
                        fastColY=j;
                    if(fastRowX>i)
                        fastRowX=i;
                    if(slowColY<j)
                        slowColY=j;
                    if(slowRowX<i)
                        slowRowX=i;
                }
            }
        }
      
        return new int[]{fastRowX,fastColY,slowRowX+1,slowColY+1};
    }
}