package Programmers;
/**
 * 먼저 people를 정렬 시킨다음 deque에 넣어준다. 그리고 앞에서 하나를 뽑고 고정한 다음 뒤에서 차례로 하나씩 뽑아
 * limit을 넘기는 지 확인한 후, 넘기지 않을 경우 depue에서 pop하여 세트로 뺸다.
 * 이 과정을 한번 할 떄마다 answer를 1씩 더해가며 answer을 구한다.
 */
import java.util.*;
public class Solution_Lev2_33 {
    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);
            Deque<Integer> deque=new ArrayDeque<Integer>();
            for(int i:people){
                deque.add(i);
            }
            while(!deque.isEmpty()){
                if(deque.peek()+deque.getLast()<=limit){
                    deque.pop();
                    deque.pollLast();
                    answer++;
                }
                else{
                    deque.pollLast();
                    answer++;
                }
            }

            return answer;
        }
    }
}
