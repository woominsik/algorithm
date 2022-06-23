package Programmers;
/**
 *  https://programmers.co.kr/learn/courses/30/lessons/42587
 *  프린트 우선순위와 순서를 각각 따로 저장하여 진행하였다
 *  while문을 통해 우선순위가 높은 프린트와 그 순서를 빼주고 아닐 경우 뒤에 다시 넣어주는 식으로 진행하였다.
 *
 */
import java.util.*;

public class Solution_Lev2_43 {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<Integer> que = new LinkedList<>();
            Queue<Integer> order = new LinkedList<>();
            for(int i=0;i<priorities.length;i++){
                que.add(priorities[i]);
                order.add(i);
            }
            while(!que.isEmpty()){
                // System.out.println("q "+que);
                // System.out.println("o "+order);
                int max = Collections.max(que);
                if(que.peek()==max){
                    answer++;
                    if(order.peek()==location){
                        break;
                    }
                    que.poll();
                    order.poll();
                }
                else{
                    que.add(que.poll());
                    order.add(order.poll());
                }

            }
            return answer;
        }
    }

}
