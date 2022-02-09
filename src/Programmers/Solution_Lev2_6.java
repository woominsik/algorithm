package Programmers;
import java.util.*;
public class Solution_Lev2_6 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            int []days=new int[progresses.length];
            Queue<Integer> queue=new LinkedList<>();
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i=0;i<progresses.length;i++){
                int tmp=progresses[i];
                int day=0;
                while(tmp<100){
                    tmp+=speeds[i];
                    day++;
                }
                days[i]=day;
            }
            for(int i : days){
                queue.add(i);
            }
            System.out.println(queue);
            while(!(queue.isEmpty())){
                int n=1;
                int tmp=queue.poll();
                for(int i=0;i<queue.size();){
                    if(queue.peek()<=tmp){
                        queue.poll();
                        n++;
                    }
                    else{
                        break;
                    }
                }
                ans.add(n);
            }
            answer=new int[ans.size()];
            int a=0;
            for (int i:ans){
                answer[a]=i;
                a++;
            }
            return answer;
        }
    }
}
