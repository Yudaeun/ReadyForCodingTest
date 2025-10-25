import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        while (!pq.isEmpty()) {
            int sco1 = pq.poll();
            
            if (sco1 >= K) {
                return answer;
            }
            
            if (pq.isEmpty()) {
                return -1;
            }
            
            int sco2 = pq.poll();
            int newSco = sco1 + (sco2 * 2);
            pq.add(newSco);
            answer++;
            
            
            
        }
        
        
        return answer;
    }
}