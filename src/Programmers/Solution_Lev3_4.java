package Programmers;
// a[]의 전체 합산이 0인지 확인한다. 전체 합이 0이 아니면 -1을 리턴한다.
// edge를 이용해 ArrayList<>[]를 만들어준다. matrix로 하기에는 a의 갯수가 너무 많다.
// visited[]배열과 dfs를 통해 leaf vertex까지 쭉 들어갔다가 차례차례 올라온다.
// 부모 vertex는 자식 vertex의 value를 받아 자신의 value에 더하고,
// 모든 vertex는 자신의 value의 절댓값을 answer에 합산하게 된다.


import java.util.*;
public class Solution_Lev3_4 {

class Solution {

        long answer;
        boolean[] visited;
        long[] long_a;
        ArrayList<Integer>[] children;

        public long solution(int[] a, int[][] edges) {
            answer = 0;
            visited = new boolean[a.length];
            children = new ArrayList[a.length];
            long_a = new long[a.length];

            long sum = 0;
            for(int i = 0; i < a.length; i++){
                sum += a[i];
                children[i] = new ArrayList<>();
                long_a[i] = a[i];
            }

            if(sum != 0) return -1;

            for(int i = 0 ; i < edges.length; i++){
                children[edges[i][0]].add(edges[i][1]);
                children[edges[i][1]].add(edges[i][0]);
            }

            dfs(0);

            return answer;
        }

        public long dfs(int v){
            visited[v] = true;

            for(int i = 0; i < children[v].size(); i++){
                int next = children[v].get(i);
                if(!visited[next]){
                    long_a[v] += dfs(next);
                }
            }

            this.answer += Math.abs(long_a[v]);

            return long_a[v];
        }

    }
}

