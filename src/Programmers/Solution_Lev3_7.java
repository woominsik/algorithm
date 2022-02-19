package Programmers;
// Arraylist를 사용하여 2차원 배열인 computer를 표현하였고 visited를 전역변수로 두어 dfs를 수행하며 수행된 num에 대해서 바로
// visited의 값을 바꾸어 표현하였다. 그리고 for문을 통해 visited가 거짓은 num을 찾을 경우 answer을 ++하여 풀었다
import java.util.*;
public class Solution_Lev3_7 {
    class Solution {
        ArrayList<Integer>[] list;
        HashSet<Integer>[] li;
        boolean [] visited;
        int answer=0;
        public int solution(int n, int[][] computers) {
            list = new ArrayList[n];
            li= new HashSet[n];
            visited=new boolean[n];
            for(int i=0;i<n;i++){
                int [] temp = computers[i];
                list[i]=new ArrayList<>();
                li[i]=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(i!=j){
                        if(temp[j]==1){
                            list[i].add(j);
                            li[i].add(j);
                        }
                    }
                }
            }
            // for(ArrayList<Integer> a : list)
            //     System.out.println(a);
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    dfs(i);
                    answer++;
                }

            }
            return answer;
        }
        void dfs(int num){
            visited[num]=true;
            for(int i=0;i<list[num].size();i++){
                int temp=list[num].get(i);
                if(!visited[temp]){
                    // System.out.println(temp);
                    dfs(temp);
                }
            }
        }
    }
}

