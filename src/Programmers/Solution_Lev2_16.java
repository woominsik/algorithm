package Programmers;
/* **
    입력받은 배열을 queue에 저장한 후 이를 정렬한다. 그리고 queue에서 하나씩 꺼내가면서 최댓값과 일치하지 않으면
    queue에 다시 집어넣는 식으로 진행하여 값을 구해낸다
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_Lev2_16 {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            int l = location;

            Queue<Integer> que = new LinkedList<Integer>();
            for(int i : priorities){
                que.add(i);
            }

            Arrays.sort(priorities);
            int size = priorities.length-1;



            while(!que.isEmpty()){
                Integer i = que.poll();
                if(i == priorities[size - answer]){
                    answer++;
                    l--;
                    if(l <0)
                        break;
                }else{
                    que.add(i);
                    l--;
                    if(l<0)
                        l=que.size()-1;
                }
            }

            return answer;
        }
    }
}
