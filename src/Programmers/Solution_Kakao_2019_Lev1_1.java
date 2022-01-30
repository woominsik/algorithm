package Programmers;
import java.util.*;
public class Solution_Kakao_2019_Lev1_1 {
    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int [N];
            Arrays.sort(stages);
            double [] fail =new double [N+1];
            double [] count =new double [N+1];
            ArrayList<Stage>al=new ArrayList<>();
            int a=0;
            for(int i: stages){
                fail[i-1]++;
            }
            count[0]=stages.length;
            for(int i=1;i<count.length;i++){
                count[i]=count[i-1]-fail[i-1];
            }
            for(int i=0;i<N;i++){
                if(count[i]<=0){
                    al.add(new Stage(i+1,0));
                }
                else
                    al.add(new Stage(i+1,fail[i]/count[i]));
            }
            Collections.sort(al,new Comparator<Stage>(){
                public int compare(Stage s1,Stage s2){
                    if(s1.fail>s2.fail){
                        return -1;
                    }
                    else if(s1.fail==s2.fail){
                        return s1.num-s2.num;
                    }
                    else{
                        return 1;
                    }
                }
            });
            for(int i=0;i<N;i++){
                answer[i]=al.get(i).num;
            }
            // System.out.println(al);
            return answer;
        }
        class Stage{
            int num;
            double fail;
            Stage(int num, double fail){
                this.num=num;
                this.fail=fail;
            }
            public String toString(){
                return num+" "+fail;
            }
        }
    }
}
