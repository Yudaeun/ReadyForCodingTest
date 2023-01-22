class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int denom=denom1*denom2;
        int numer=numer1*denom2+numer2*denom1;
        int maxNum=Math.max(denom,numer);
        
        for(int i=maxNum;i>0;i--){
            if(denom%i==0 && numer%i==0){
                answer[0]=numer/i;
                answer[1]=denom/i;
                break;
            }
        }
        return answer;
    }
}