package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int [][] board;
    static int N;
    static boolean visited[];
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        board = new int[N][N];

        for(int i=0;i<N;i++){
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0;i<N;i++){
            visited = new boolean[N];
            visited[i] = true;
            dfs(i,i,1,0);
        }

        System.out.println(answer);
    }
    static void dfs(int start,int now, int cnt, int sum){
        if(cnt==N){
            if(board[now][start]==0){
                return;
            }
            sum+=board[now][start];
            if(sum<answer){
                answer = sum;
            }
        }

        for(int i=0;i<N;i++){
            if(!visited[i] && board[now][i]!=0){
                visited[i]=true;
                dfs(start,i,cnt+1,sum+board[now][i]);
                visited[i]=false;
            }
        }
    }
}