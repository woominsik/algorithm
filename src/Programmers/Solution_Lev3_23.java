package Programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42890
 * dfs를 통해 풀었다.
 * for문을 통해 dfs의 시작점을 정해준 후 func2함수를 통해 dfs를 돌려 주었다
 * func2함수 안에서 al arrayList를 check함수를 통해 유일성과 최소성을 확인하고
 * check함수에서 유일성과 최소성을 통과하면 ans arraulist에 넣고 ans의 사이즈를 return하여 문제를 풀었다.
 */

import java.util.*;

public class Solution_Lev3_23 {
    class Solution {
        String [][] rel;
        ArrayList<String> ans;
        public int solution(String[][] relation) {
            int answer = 0;
            rel = relation;
            ans = new ArrayList<>();
            for(int i=0;i<relation[0].length;i++){
                ArrayList<Integer> al = new ArrayList<>();
                func2(i,al);
            }
            // System.out.println("ans: "+ans);
            return ans.size();
        }

        void func2(int startIdx, ArrayList<Integer> al){
            al.add(startIdx);
            // System.out.println("al: "+al);
            String cs = check(al);
            if(!cs.equals("-1")){
                ans.add(cs);
                return ;
            }
            for(int i=startIdx;i<rel[0].length;i++){
                if(!al.contains(i)){
                    func2(i,al);
                    al.remove(Integer.valueOf(i));
                }
            }
        }

        String check(ArrayList<Integer> colIdx){
            HashSet<String> set = new HashSet<>();
            ArrayList<String> delete = new ArrayList<>();


            String s="";
            for(int i=0;i<rel.length;i++){
                String temp = "";
                for(int j:colIdx){
                    temp+=rel[i][j];
                }
                set.add(temp);
            }

            // System.out.println(set);
            if(rel.length!=set.size()){
                return "-1";
            }
            else{
                for(int i=0;i<ans.size();i++){
                    String temp = ans.get(i);
                    boolean tb = true;
                    for(int idx : colIdx){
                        if(!temp.contains(Integer.toString(idx)))
                            tb = false;
                    }
                    if(tb==true){
                        if(temp.length()<colIdx.size()){
                            return "-1";
                        }
                        else{
                            delete.add(temp);
                            // System.out.println("delete추가 :"+delete);
                        }
                    }
                }
                ans.removeAll(delete);
                for(int i : colIdx){
                    s+=i;
                }
                return s;
            }
        }
    }
}
