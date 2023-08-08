import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        //다리의 길이만큼 큐를 0으로 초기화
        //큐에서 하나씩 빠질 때마다 1초씩 증가
        //현재 다리 위에 있는 데이터들의 총합이 weight를 초과하면 0을 스택에 추가
        //weight를 초과하지 않으면 대기 트럭열에서 데이터를 빼서 bridge 스택에 추가
        //처음에 트럭 대기열은 큐로 다시 담음
        Queue<Integer> bridge=new LinkedList<>();
        Queue<Integer> truck=new LinkedList<>();
        
        for(int i=0;i<bridge_length;i++){
            bridge.add(0);
        }
        
        for(int i=0;i<truck_weights.length;i++){
            truck.add(truck_weights[i]);
        }
        
        while(!bridge.isEmpty()){
            answer++;
            bridge.poll();
            if(truck.size()==0){
                continue;
            }
            if(sum(bridge)+truck.peek()>weight){
                bridge.add(0);
            }else {
                bridge.add(truck.poll());
            }
        }
        
        
        
        return answer;
    }
    private int sum(Queue<Integer> num){
        int sum=0;
        for(Integer n:num){
            sum+=n;
        }
        return sum;
    }
}