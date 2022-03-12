package Programmers;
/* **
    우선순위 큐를 사용하여 스코빌 지수가 오름차순으로 pQueue에 저장시킨다.
    그리고 두개의 수를 뽑아서 연산을 진행한 후  다시 pQueue에 집어넣고 answer++을 한 후
    만약 pQueue에서 peek한 값이 K보다 클 경우 while문을 종료하여 answer를 return해준다.
 */
import java.util.*;
public class Solution_Lev2_23 {

    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pQueue=new PriorityQueue<>();
            for(int i:scoville){
                pQueue.add(i);
            }
            while(pQueue.peek()<K){
                if(pQueue.size()<=1){
                    return -1;
                }
                else{
                    int a=pQueue.poll();
                    int b=pQueue.poll();
                    pQueue.add(a+b*2);
                }
                answer++;
            }


            return answer;
        }
    }
}
