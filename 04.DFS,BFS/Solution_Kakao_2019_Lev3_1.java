package Programmers;

// https://programmers.co.kr/learn/courses/30/lessons/64064
// 처음에는 일일이 비교해가면서 banned_id에 들어갈 것들을 구해 조합하는 식으로 풀으려 했으나 조합하는 부분에 막혔다.
// 그래서 각 banned_id마다 맞는 user_id를 찾아 dfs하는 식으로 조합을 진행하여 문제를 풀었다.

import java.util.*;
public class Solution_Kakao_2019_Lev3_1 {

    class Solution {
        boolean[] visited;
        String [] list;
        String [] banList;
        HashSet<String> hs;
        // int ans=0;
        public int solution(String[] user_id, String[] banned_id) {
            int answer = 0;
            visited=new boolean [user_id.length];
            list=user_id;
            hs=new HashSet<>();
            banList=banned_id;
            ArrayList<String> al=new ArrayList<>();
            dfs(0,al);
            // System.out.println(hs.size());
            return hs.size();
        }
        void dfs(int count,ArrayList<String> al){
            if(count==banList.length){
                Collections.sort(al);
                // System.out.println(makeString(al));
                hs.add(makeString(al));

                // System.out.println(al);
                return;
            }
            for(int i=0;i<list.length;i++){
                if(compare(list[i],banList[count])&&visited[i]==false&&!al.contains(list[i])){
                    visited[i]=true;
                    al.add(list[i]);
                    dfs(count+1,al);
                    visited[i]=false;
                    al.remove(list[i]);
                }
            }
        }
        boolean compare(String input, String s){
            if(input.length()!=s.length()){
                return false;
            }
            for(int i=0;i<input.length();i++){
                if(s.charAt(i)!=input.charAt(i)){
                    if(s.charAt(i)!='*'){
                        return false;
                    }
                }
            }
            return true;
        }
        String makeString(ArrayList<String> al){
            String s ="";
            for(String a:al){
                s+=a;
            }
            // System.out.println(s);
            return s;
        }
    }
}
