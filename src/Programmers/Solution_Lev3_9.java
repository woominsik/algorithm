package Programmers;
// enroll의 이름과 부모의 이름을 묶은 Map과 enroll의 이름과 index을 묶은 Map을 둔다.
// 그리고 seller로 for문을 돌려 셀러의 profit과 부모에게 줄돈 을 바로 계산한뒤 answer에 저장하고
// 셀러의 부모를 찾는 while문을 돌려 부모를 찾는다.
// 찾은 부모의 profit을 앞서 계산 해놓은 값으로 더해준다.
// 그리고 for문을 계속해서 돌려 seller에 값을 저장하고 수수료를 부모에게 저장하는 식으로 진행한다.

import java.util.*;

public class Solution_Lev3_9 {


    class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];

            Map<String, String> parentMap = new HashMap<>();
            Map<String, Integer> memberIndexMap = new HashMap<>();
            for(int i=0; i < enroll.length; i++){
                parentMap.put(enroll[i], referral[i]);
                memberIndexMap.put(enroll[i], i);
            }

            for(int i=0; i<seller.length; i++){

                String now = seller[i];
                int profit = 100 * amount[i];

                while(!now.equals("-")){
                    int profitForParent = profit / 10;
                    int nowProfit = profit - profitForParent;

                    answer[memberIndexMap.get(now)] += nowProfit;

                    now = parentMap.get(now);
                    profit /= 10;

                    if (profit < 1) {
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
