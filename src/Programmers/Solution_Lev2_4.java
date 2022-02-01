package Programmers;
// dungeons의 최대길이가 8이므로 dfs를 사용해도 문제가 없을거라 생각해 dfs를 사용하여 문제를 풀었다.

import java.util.*;
public class Solution_Lev2_4 {
    class Solution {
        boolean [] visited;
        ArrayList<Integer> al;
        int [][]board;
        public int solution(int k, int[][] dungeons) {
            int answer = -1;
            board=dungeons;
            al=new ArrayList<>();
            visited=new boolean[dungeons.length];
            Arrays.sort(dungeons,new Comparator<int[]>(){
                public int compare(int [] a1,int [] a2){
                    if(a1[0]==a2[0]){
                        return a1[1]-a2[1];
                    }
                    else{
                        return a2[0]-a1[0];
                    }
                }
            });
            // for(int [] p : dungeons){
            //     System.out.println(p[0]+" "+p[1]);
            // }
            dfs(k,0);
            // System.out.println(al);
            return Collections.max(al);
        }
        void dfs(int num,int count){
            if(num<=0){
                al.add(count);
                return;
            }
            for(int i=0;i<board.length;i++){
                if(visited[i]==false && board[i][0]<=num){
                    visited[i]=true;
                    // System.out.println(i);
                    dfs(num-board[i][1],count+1);
                    visited[i]=false;
                }
            }
            al.add(count);
            return;
        }
    }
}
