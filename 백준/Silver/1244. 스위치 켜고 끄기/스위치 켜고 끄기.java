import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] swit=new int[n+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            swit[i]=Integer.parseInt(st.nextToken());
        }
        int studentNum=Integer.parseInt(br.readLine());
        int[][] student=new int[studentNum][2];
        for(int i=0;i<studentNum;i++){
            StringTokenizer s=new StringTokenizer(br.readLine());
            student[i][0]=Integer.parseInt(s.nextToken());
            student[i][1]=Integer.parseInt(s.nextToken());
        }
       
        for(int i=0;i<studentNum;i++){
            if (student[i][0]==1){ //남학생이라면
            	
                for (int j=student[i][1];j<n+1;j+=student[i][1]){
                    swit[j]=(swit[j]==0)?1:0;

                }
                
            }else{ //여학생이라면
                int post=student[i][1]-1;
                int back=student[i][1]+1;
                swit[student[i][1]]=(swit[student[i][1]])==0?1:0;
                while(post!=0&&back!=swit.length){
                    if(post<=0||back>swit.length)
                        break;
                    if (swit[post]==swit[back]){
                        swit[post]=(swit[post]==0)?1:0;
                        swit[back]=(swit[back]==0)?1:0;
                        post--;
                        back++;
                    }
                    else
                        break;
                }
                

            }
        }
        for(int i=1;i<n+1;i++){
            System.out.printf("%d ",swit[i]);
            if(i%20==0)
                System.out.println();
        }
    }
}