import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int currentNum = arr[0];
        
        for (int i = 1; i < arr.length; i++){
            if (arr[i] != currentNum) {
                answer.add(currentNum);
                currentNum = arr[i];            
            }
        }
        answer.add(currentNum);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}