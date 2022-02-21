package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem_15649 {
    static boolean []visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String [] temp = s.split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);


        for(int i=0;i<n;i++){
            ArrayList<Integer> al =new ArrayList<>();
            visited = new boolean[n];
            dfs(m,n,0,i+1,al);
        }
    }
    static void dfs(int m, int n, int count, int now, ArrayList<Integer> al){
        visited[now-1]=true;
        al.add(now);
//        System.out.println(al);
        if(al.size() ==m){
            for(int i:al){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++){
            if(visited[i-1]==false){
                dfs(m,n,count+1,i,al);
                al.remove(al.size()-1);
                visited[i-1]=false;
            }
        }
    }
}
