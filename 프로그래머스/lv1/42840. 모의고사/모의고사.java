import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        LinkedList<Integer> ansList=new LinkedList<>();
        int max=0;
        int[] cnt=new int[3];
        int[] one={1,2,3,4,5}; //5
        int[] two={2,1,2,3,2,4,2,5}; //8
        int[] three={3,3,1,1,2,2,4,4,5,5}; //10
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==one[i%5])
                cnt[0]++;
            if(answers[i]==two[i%8])
                cnt[1]++;
            if(answers[i]==three[i%10])
                cnt[2]++;
        }
        for(int i=0;i<3;i++){
            if (cnt[i]>max){
                max=cnt[i];
            }
        }
        
        for(int i=0;i<3;i++){
            if (max==cnt[i])
                ansList.add(i+1);
        }
        
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}