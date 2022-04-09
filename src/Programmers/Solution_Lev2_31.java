package Programmers;
/**
 *
 */

import java.util.*;

public class Solution_Lev2_31 {
    class Solution {
        ArrayList<String> [] lists;
        ArrayList<String> wlist;
        public int[] solution(int n, String[] words) {
            int[] answer = new int [2];
            lists = new ArrayList[n];
            wlist=new ArrayList<>();
            for(int i=0;i<n;i++){
                lists[i]=new ArrayList<>();
            }
            for(int i=0;i<words.length;i++){
                String temp = words[i];
                if(!wlist.isEmpty()){
                    String before = wlist.get(wlist.size()-1);
                    if(before.charAt(before.length()-1)!=temp.charAt(0)){
                        answer[0]=i%n+1;
                        answer[1] = lists[i%n].size()+1;
                        break;
                    }
                }

                if(!wlist.contains(temp)){
                    wlist.add(temp);
                }
                else{
                    answer[0]=i%n+1;
                    answer[1] = lists[i%n].size()+1;
                    break;
                }
                lists[i%n].add(temp);
            }
            return answer;
        }
    }
}
