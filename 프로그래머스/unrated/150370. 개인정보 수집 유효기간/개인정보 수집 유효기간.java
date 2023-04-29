import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list=new ArrayList<>();
        String[] tem=today.split("\\.");
        int[] newToday=new int[3];
        
        for(int i=0;i<3;i++){
            newToday[i]=Integer.valueOf(tem[i]);
        }
        HashMap<String,Integer> term=new HashMap<>();
        String[][] pri=new String[privacies.length][2];
        
        for(int i=0;i<terms.length;i++){
            String t[]=terms[i].split(" ");
            term.put(t[0],Integer.valueOf(t[1]));
        }
        
        for(int i=0;i<privacies.length;i++){
            pri[i]=privacies[i].split(" ");
        }
        
        for(int i=0;i<privacies.length;i++){
            String temp[]=pri[i][0].split("\\.");
            int date[]=new int[3];
            int oriDate[]=new int[3];
            
            for(int j=0;j<3;j++){
                date[j]=Integer.valueOf(temp[j]);
                oriDate[j]=Integer.valueOf(temp[j]);
            }
            
            int limitDate=term.get(pri[i][1]);
            for(int j=0;j<limitDate;j++){
                date[2]+=28;
                if(date[2]>28){
                    date[2]-=28;
                    date[1]+=1;
                }
                if(date[1]>12){
                    date[1]-=12;
                    date[0]+=1;
                }
            }
            date[2]-=1;

            if(newToday[0]>date[0]){
                list.add(i+1);
                continue;
            }if(newToday[0]==date[0]&&newToday[1]>date[1]){
                list.add(i+1);
                continue;
            }if(newToday[0]==date[0]&&newToday[1]==date[1]&&newToday[2]>date[2])
                list.add(i+1);
        }
        int[] answer=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        Arrays.sort(answer);
        
        
        return answer;
    }
}