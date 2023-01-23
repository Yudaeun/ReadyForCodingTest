class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int checkAdd=0;
        for(int i=1;i<3;i++){
            if(i==1)
                checkAdd=common[i]-common[i-1];
            else{
                if(checkAdd==common[i]-common[i-1])
                    answer=common[common.length-1]+checkAdd;
                else{
                    for(int j=0;j<common.length;j++){
                        if(common[i-1]!=0 && common[i]!=0){
                            answer=common[common.length-1]*(common[i]/common[i-1]);
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}