package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem_2606 {
    static ArrayList<Integer>[] alArr;
    static ArrayList<Integer> coms;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        alArr = new ArrayList[N+1];
        coms = new ArrayList<>();

        for(int i=1;i<=N;i++){
            alArr[i]= new ArrayList<>();
        }

        for(int i=0;i<C;i++){
            int [] temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            alArr[temp[0]].add(temp[1]);
            alArr[temp[1]].add(temp[0]);
        }
        visited = new boolean[N+1];

        dfs(1);

        System.out.println(coms.size());
    }

    static void dfs(int node){
        visited[node]=true;
        for(int i=0;i< alArr[node].size();i++){
            int num = alArr[node].get(i);
            if(!visited[num]){
                coms.add(num);
                dfs(num);
            }
        }
    }
}
