package Programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 *
 */
import java.util.*;
public class Solution_Kakao_2020_Lev2 {
    class Solution {
        public int solution(String s) {
            int answer;
            if(s.length()==1){
                return 1;
            }
            ArrayList<Integer> arr=new ArrayList<>();
            for(int i=1;i<s.length();i++){
                arr.add(calc(s,i));
            }
            answer=Collections.min(arr);
            return answer;
        }
        int calc(String s,int len){
            Queue<String> queue=new LinkedList<>();
            String sb="";
            for(int j=0;j<s.length();j+=len){
                if(j+len>s.length()){
                    queue.add(s.substring(j));
                }
                else{
                    queue.add(s.substring(j,j+len));
                }
            }
            String check=queue.poll();
            int i=1;
            while(!(queue.isEmpty())){
                if(check.equals(queue.peek())){
                    i++;
                    queue.poll();
                }
                else{
                    if(i>1){
                        sb+=Integer.toString(i);
                    }
                    sb+=check;
                    i=1;
                    check=queue.poll();
                }
            }
            if(i!=0){
                if(i>1){
                    sb+=Integer.toString(i);
                }
                sb+=check;
            }
            return sb.length();
        }
    }
}
