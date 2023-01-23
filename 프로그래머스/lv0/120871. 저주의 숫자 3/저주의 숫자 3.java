class Solution {
    public int solution(int n) {
        int answer = 0;
        int temp=0;
        int[] threeNum=new int[101];
        int i=0;
        
        while(true){
            if(i==100)
                break;
            temp++;
            if(temp%3==0 || (String.valueOf(temp)).contains("3")){
                continue;
            }
            else{
                threeNum[i]=temp;
                i++;
            }
        }
        return threeNum[n-1];
    }
}