import java.util.*;
	class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        HashSet<String> hs=new HashSet<>();
        ArrayList<String> pbList=new ArrayList<>();

        for (int i=0;i<phone_book.length;i++){
//				hs.add(phone_book[i]);
            pbList.add(phone_book[i]);
        }

        Collections.sort(pbList);

        for(int i=1;i<pbList.size();i++){
            if (pbList.get(i).length()<pbList.get(i-1).length())
                continue;

            if (pbList.get(i).substring(0,pbList.get(i-1).length()).equals(pbList.get(i-1))){
                answer=false;
                break;
            }
        }

        return answer;
    }
}

