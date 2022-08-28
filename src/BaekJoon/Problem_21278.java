package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_21278 {
    static int[][] board;
    static int N;
    static int M;
    static int [] ans;
    static int [] arr;
    static int answer =Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = temp[0];
        M = temp[1];

        ans = new int[2];
        board = new int[N+1][N+1];
        arr = new int [2];

        for(int i=1;i<=N;i++){
            Arrays.fill(board[i],100);
            board[i][i]=0;
        }

        for(int i=0;i<M;i++){
            temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            board[temp[0]][temp[1]] = 1;
            board[temp[1]][temp[0]] = 1;
        }

        floid();

        comb(1,0);
        System.out.println(ans[0]+" "+ans[1]+" "+answer*2);
    }

    static void comb(int idx, int cnt){
        if(cnt==2){
            compute();
            return;
        }

        for(int i=idx;i<=N;i++){
            arr[cnt] = i;
            comb(i+1,cnt+1);
        }
    }

    static void floid(){ // 플로이드 와샬 알고리즘 n^3이 가능해야함 n이 대략 500~600사이
        for(int k=1;k<=N;k++){ // 경유지
            for(int i=1;i<=N;i++){ // 시작점
                for(int j=1;j<=N;j++){ //도착점
                    if(board[i][k]+board[k][j]<board[i][j]){
                        board[i][j] = board[i][k]+board[k][j];
                    }
                }
            }
        }
    }

    static void compute(){ // bfs 에서 시간초과
        int all =0;
        for(int i=1;i<=N;i++){
            int [] dist = board[i];
            all+=Math.min(dist[arr[0]],dist[arr[1]]);
        }
        if(answer>all){
            answer = all;
            ans[0] = arr[0];
            ans[1] = arr[1];
        }
    }
}
