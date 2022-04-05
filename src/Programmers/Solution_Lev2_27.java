package Programmers;
/**
 *
 */

import java.util.*;

public class Solution_Lev2_27 {

    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int [prices.length];
            Stack<Integer>st=new Stack<>();
            for(int i=0;i<prices.length;i++){
                while(!st.isEmpty()&&prices[st.peek()]>prices[i]){
                    answer[st.peek()]=i-st.peek();
                    st.pop();
                }
                st.push(i);
            }
            while(!st.isEmpty()){
                answer[st.peek()]=prices.length-1-st.peek();
                st.pop();
            }
            return answer;
        }
    }
}
