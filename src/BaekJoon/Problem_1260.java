package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1260 {
    static ArrayList<Integer>[] alArr;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = temp[0];
        int M = temp[1];
        int V= temp[2];

        alArr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1;i<=N;i++){
            alArr[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            int [] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            alArr[input[0]].add(input[1]);
            alArr[input[1]].add(input[0]);
        }

        for(int i=1;i<=N;i++){
            Collections.sort(alArr[i]);
        }

        dfs(V);

        visited = new boolean[N+1];
        System.out.println();
        bfs(V);
    }
    static void dfs(int node){
        System.out.print(node+" ");
        visited[node]=true;
        for(int i=0;i< alArr[node].size();i++){
            int num = alArr[node].get(i);
            if(!visited[num]){
                dfs(num);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node+" ");
            for(int i=0;i< alArr[node].size();i++){
                int num = alArr[node].get(i);
                if(!visited[num]){
                    q.add(num);
                    visited[num] = true;
                }
            }
        }
    }
}
