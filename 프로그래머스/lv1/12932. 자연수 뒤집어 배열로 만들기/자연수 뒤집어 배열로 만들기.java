class Solution {
    public int[] solution(long n) {
        String str=Long.toString(n);
        int[] answer = new int[str.length()];
        
        for(int i=0;i<str.length();i++){
            answer[str.length()-i-1]=Integer.valueOf(str.charAt(i)-'0');
        }
        
        
        
        return answer;
    }
}