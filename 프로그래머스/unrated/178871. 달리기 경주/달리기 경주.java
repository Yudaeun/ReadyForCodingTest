import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String,Integer> rankP=new HashMap<>();
        HashMap<Integer,String> rank=new HashMap<>();
        for(int i=0;i<players.length;i++){
            rankP.put(players[i],i);
            rank.put(i,players[i]);
        }
        for(int i=0;i<callings.length;i++){
            int num=rankP.get(callings[i]);
            String p=rank.get(num);
            String frontNum=rank.get(num-1);
            rankP.put(p,num-1);
            rankP.put(frontNum,num);
            rank.put(num,frontNum);
            rank.put(num-1,p);
        }
       for(Map.Entry<String,Integer> entry:rankP.entrySet()){
           answer[entry.getValue()]=entry.getKey();
       }
        return answer;
    }
}