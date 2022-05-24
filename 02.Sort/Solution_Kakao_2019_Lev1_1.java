package Programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 * 먼저 각 스테이지 번호와 실패율을 저장하는 클래스인 stage를 만들고 스테이지 실패한 사람 수를 저장하는 fail과
 * 도전하는 사람의 수를 저장하는 count를 만들어 놓는다.
 * stage함수에서 각 숫자들에서 1을 뺀값을 인덱스로 가지는 fail에 1을 각각 더해준다.
 * 그리고 count[0]에는 stage의 길이에 저장하고 1부터는 count[i-1]-fail[i-1]을 넣어준다.
 * 그리도 for문을 통해 stage를 만들어주고 al에 저장한다. 다음으로 fail로 내림 차순으로 정렬하여 스테이지의num을 return해준다.
 */

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
