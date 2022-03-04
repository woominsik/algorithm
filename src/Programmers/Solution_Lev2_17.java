package Programmers;
/* **
    hashmap을 통해 아이디와 닉네임을 저장한 후 입력받은 record를 통해 result 배열을 만들어 낸다.
 */

import java.util.*;

public class Solution_Lev2_17 {

    class Solution {
        public String[] solution(String[] record) {
            String[] answer = {};
            ArrayList <String> ans = new ArrayList<String>();
            Map <String,String> Id=new HashMap<>();
            for(String s:record){
                String [] tmp =s.split(" ");
                if(!(tmp[0].equals("Leave"))){
                    Id.put(tmp[1],tmp[2]);
                }
            }

            for(String s:record){
                String [] tmp =s.split(" ");
                if(tmp[0].equals("Enter")){
                    ans.add(Id.get(tmp[1])+"님이 들어왔습니다.");
                }
                else if(tmp[0].equals("Leave")){
                    ans.add(Id.get(tmp[1])+"님이 나갔습니다.");
                }
            }

            answer=new String[ans.size()];
            int a=0;
            for(String s:ans){
                answer[a]=s;
                a++;
            }
            return answer;
        }
    }
}
