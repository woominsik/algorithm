package Programmers;
/**
 *
 */


import java.util.*;

public class Solution_Lev2_39 {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            Map<String,ArrayList<String>> map=new HashMap<>();
            for(String [] s:clothes){
                ArrayList<String> temp=new ArrayList<>();
                if(map.containsKey(s[1])){
                    temp=map.get(s[1]);
                    temp.add(s[0]);
                    map.put(s[1],temp);
                }
                else{
                    temp.add(s[0]);
                    map.put(s[1],temp);
                }
            }
            for(String key: map.keySet()){
                int size=map.get(key).size()+1;
                answer*=size;
            }
            answer-=1;
            return answer;
        }
    }
}
