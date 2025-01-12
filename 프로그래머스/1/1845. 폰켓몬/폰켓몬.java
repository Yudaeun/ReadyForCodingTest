import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        
        for (int i=0;i<nums.length;i++){
            numSet.add(nums[i]);
        }
        
        return nums.length/2 >= numSet.size() ? numSet.size() : nums.length/2;
    }
}