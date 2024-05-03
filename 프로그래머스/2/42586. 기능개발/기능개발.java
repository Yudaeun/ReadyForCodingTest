import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer=new ArrayList<>();
        int[] date=new int[progresses.length];
        
        // progresses 루프를 돌면서 (100-progresses[i])/speeds[i]에 대한 값을 배열에 넣음
        // 만약 나머지 계산했을 때 0보다 크면 +1 해줌
        // 다시 루프 돌면서 현재 숫자보다 큰 게 나오면 멈추고 현재 숫자 갱신한 뒤에 리스트에 cnt 넣음
        
        for(int i=0;i<progresses.length;i++){
            date[i]=(100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]>0){
                date[i]++;
            }
        }
        
        int curNum=date[0];
        int curCnt=1;
        for(int i=1;i<date.length;i++){
            if(curNum<date[i]){
                curNum=date[i];
                answer.add(curCnt);
                curCnt=1;
            }else{
                curCnt++;
            }
        }
        answer.add(curCnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}