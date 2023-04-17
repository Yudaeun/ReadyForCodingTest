class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String alpha="abcdefghijklmnopqrstuwvxyz";
        
        for(int i=0;i<s.length();i++){
            int idx=0;
            int check=1;
            char temp=s.charAt(i);
            while(check<=index){
                idx++;

                if((char)(temp+idx)>'z'){
                    idx=0;
                    temp='a';
                }
                if(skip.indexOf((char)(temp+idx))<0){
                    check++;
                }
            }            
            answer+=(char)(temp+idx);
        }
        return answer;
    }
}