import java.util.*;

class Solution {
    static public boolean[] visited;
    static public int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    private void dfs(String cur, String target, String[] words, int depth) {
        if (depth >= words.length) {
            return;
        }
        if (target.equals(cur)) {
            answer = depth;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            if (canChange(words[i], cur)) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean canChange(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}