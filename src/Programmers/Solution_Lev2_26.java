package Programmers;
/**
 *  kakao 먼저 a~z까지 al에 넣은 다음 ka를 al에서 확인 후 없을 경우 넣어준다. 그다음 a로 넘어가서 유무확인 후 ak로 넘어가고
 *  ak를 확인한 후 al에 넣어준다. 그리고 ka가 al에 있음을 확인한 후 kao를 al에 넣어준다.
 *  k의 11, a의 1, ka의 27, o의 15를 array로 반납해준다.
 */
import java.util.*;
public class Solution_Lev2_26 {

    class Solution {
        public int[] solution(String msg) {
            int[] answer = {};
            ArrayList <Integer> ans=new ArrayList<>();
            ArrayList <String> al=new ArrayList<>();
            for(int i=0;i<26;i++){
                char a=65;
                a+=i;
                String temp=String.valueOf(a);
                al.add(temp);
            }
            Queue<String> queue=new LinkedList<>();
            for(int i=0;i<msg.length();i++){
                queue.add(Character.toString(msg.charAt(i)));
            }

            while(!queue.isEmpty()){
                String s=queue.poll();
                if(queue.peek()!=null){
                    s+=queue.peek();
                    while(al.contains(s)){
                        queue.poll();

                        if(queue.peek()!=null){
                            s+=queue.peek();

                        }
                        else{
                            break;
                        }


                    }
                }
                al.add(s);

                if(queue.peek()!=null){
                    s=s.substring(0,s.length()-1);
                }
                // System.out.println(s);
                // System.out.println(queue);

                ans.add(al.indexOf(s)+1);
                // System.out.println(ans);
            }
            answer=new int[ans.size()];
            int i=0;
            for(int t:ans){
                answer[i]=t;
                i++;
            }
            return answer;
        }
    }
}
