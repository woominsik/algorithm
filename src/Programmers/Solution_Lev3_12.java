package Programmers;
import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 * 오름차순으로 정렬되는 우선순위 큐 pq와 내림차순으로 정렬되는 우선순위 큐 pqr을 선언한 후
 * 모든 수를 모두 집어 넣어준다. 그리고 명령을 입력받은 후 i일 경우 두 우선순위 큐에 모두 값을 넣어주고
 * D 1일경우 pqr에서 poll을 해주고 D -1일 경우 pq에서 값을 poll읗 해준 후 pqr과 pq를 retainAll을 하여 진행한다.
 * 그리고 모든 명령이 끝난후 pq의 사이즈를 확인하여 0일경우 0,0을 return 해주고 1일 경우 0과 queue에 남은 값을 return한다
 * 그 이외의 경우 pq에서 한 값, pqr에서 한 값을 빼서 return해준다.
 */

public class Solution_Lev3_12 {
    public static void main(String[] args) {

        class Solution {
            public int[] solution(String[] operations) {
                int[] answer = new int [2];
                PriorityQueue <Integer> pq=new PriorityQueue<Integer>();
                PriorityQueue <Integer> pqR=new PriorityQueue<Integer>(Collections.reverseOrder());
                ArrayList<Integer> al=new ArrayList<>();
                for(String s:operations){
                    String[] temp=s.split(" ");
                    if(temp[0].equals("I")){
                        pq.offer(Integer.parseInt(temp[1]));
                        pqR.offer(Integer.parseInt(temp[1]));
                    }
                    else{
                        if(pq.size()==0||pqR.size()==0){
                            continue;
                        }
                        if(temp[1].equals("1")){
                            pqR.poll();
                            // System.out.println(pqR.poll());

                        }
                        else{
                            pq.poll();
                            // System.out.println("d -1 "+pq.poll());
                        }
                    }

                    pq.retainAll(pqR);
                    pqR.retainAll(pq);
                }

                // System.out.println(pq);
                // System.out.println(pqR);
                if(pq.size()==0){
                    answer[1]=0;
                    answer[0]=0;
                }
                else if(pq.size()==1){
                    answer[0]=pq.poll();
                    answer[1]=0;
                }
                else{
                    answer[1]=pq.poll();
                    answer[0]=pqR.poll();
                }


                return answer;
            }
        }
    }
}
