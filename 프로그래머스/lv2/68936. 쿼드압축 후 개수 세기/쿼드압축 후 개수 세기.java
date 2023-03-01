class Solution {
    static int one;
    static int zero;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        one=0;
        zero=0;
        quard(arr.length,arr,0,0);
        answer[0]=zero;
        answer[1]=one;
        return answer;
    }
    public void quard(int size,int[][] arr,int x,int y){
        if(check(arr,size,x,y)){
            if(arr[x][y]==0)
                zero++;
            else one++;
            return;
        }
        int newSize=size/2;
        quard(newSize,arr,x,y);
        quard(newSize,arr,x+newSize,y+newSize);
        quard(newSize,arr,x+newSize,y);
        quard(newSize,arr,x,y+newSize);
    }
    public boolean check(int[][] arr,int size,int x,int y){
        int temp=arr[x][y];
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(temp!=arr[i][j])
                    return false;
            }
        }
        return true;
    }
}