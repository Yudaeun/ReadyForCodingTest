class Solution {
    public int[] solution(int[] num_list) {
        int odd_num = 0;
        
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 != 0) {
                odd_num++;
            }
        }
        
        int answer[] = new int[2];
        answer[0] = num_list.length - odd_num;
        answer[1] = odd_num;
        
        return answer;
    }
}