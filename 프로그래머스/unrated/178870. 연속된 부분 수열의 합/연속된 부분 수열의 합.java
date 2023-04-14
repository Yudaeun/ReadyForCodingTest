import java.util.*;
class Solution {

    public int[] solution(int[] sequence, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(sequence[0]);
        int[] answer=new int[2];
        int start=0;
        int end=0;
        int sum=sequence[0];
        int minLen=1000001;
        int qSize=1;
        while(end<sequence.length-1){
            if(sum==k){
                if(qSize<minLen){
                    minLen=qSize;
                    answer[0]=start;
                    answer[1]=end;
                }
                    sum-=sequence[start];
                    start++;
                    q.poll();
                    qSize--;
                
            }else if(sum>k){
                sum-=sequence[start];
                start++;
                q.poll();
                qSize--;
            }else{
                end++;
                q.add(sequence[end]);
                sum+=sequence[end];
                qSize++;
            }
        }
        System.out.println(start+" "+end);
        if(start<sequence.length-1){
            while(start<=sequence.length-1){
                if(sum==k){
                if(qSize<minLen){
                    minLen=qSize;
                    answer[0]=start;
                    answer[1]=end;
                }
                    sum-=sequence[start];
                    start++;
                    q.poll();
                    qSize--;
                
            }else{
                sum-=sequence[start];
                start++;
                q.poll();
                qSize--;
            }
            }
        }
        return answer;
    }
}