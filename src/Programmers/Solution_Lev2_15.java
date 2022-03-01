package Programmers;
/* **
    전달받은 문자열을 for문을 통해 stack에 한 문자씩 집어 넣고 stack 가장 상단에 위치한 단어들과 집어 넣을 문자가 일치할 경우
    그 문자를 넣지 않고 pop을 통해 가장 상단에 위치한 단어를 제거하는 식으로 나아간다.
 */
import java.util.*;

public class Solution_Lev2_15 {


    class Solution
    {
        public int solution(String s)
        {
            Stack<Character> st =new Stack<>();
            // st.push(s.charAt(0));
            for(int i=0;i<s.length();i++){
                char temp = s.charAt(i);
                if(st.isEmpty()){
                    st.push(temp);
                    continue;
                }
                if(st.peek()==temp){
                    st.pop();
                }
                else{
                    st.push(temp);
                }
            }
            if(st.isEmpty())
                return 1;
            else
                return 0;

        }
    }
}
