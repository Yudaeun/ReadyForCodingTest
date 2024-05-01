import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            int firstMinNum=-1;
            int secondMinNum=-1;
            int scovilleScore=0;

            for(int i=0;i<scoville.length;i++){
                pq.add(scoville[i]);
            }

            while(!pq.isEmpty()){
                firstMinNum=pq.poll();
                if(firstMinNum>=K){
                    break;
                }else{
                    if(pq.size()<=0){
                        answer=-1;
                        break;
                    }
                    secondMinNum=pq.poll();
                    scovilleScore=firstMinNum+(secondMinNum*2);
                    pq.add(scovilleScore);
                    answer++;
                }
            }

            return answer;
        }
}