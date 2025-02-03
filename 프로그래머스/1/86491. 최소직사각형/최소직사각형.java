import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxHeight = 0;
        int maxWeight = 0;
        
        // 긴 부분을 가로로 재배치
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            maxHeight = Math.max(maxHeight, sizes[i][0]);
            maxWeight = Math.max(maxWeight, sizes[i][1]);
        }
        
        return maxHeight * maxWeight;
    }
}