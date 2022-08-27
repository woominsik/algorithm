package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_14500 {
    static int [][] board;
    static int N;
    static int M;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static int answer=0;
    static int[][][] exception = {
            {{-1,0},{1,0},{0,1}},
            {{-1,0},{1,0},{0,-1}},
            {{0,-1},{0,1},{1,0}},
            {{0,-1},{0,1},{-1,0}}
    };
    static boolean [][]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = temp[0];
        M = temp[1];

        board = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){

                dfs(j,i,0,0,visited);
                checkException(j,i);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y, int depth, int sum, boolean[][]visited) {

        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<M && ny>=0 && ny<N){
                if(!visited[ny][nx]){
                    visited[ny][nx] = true;
                    dfs(nx, ny, depth + 1, sum + board[ny][nx],visited);
                    visited[ny][nx] = false;
                }
            }
        }

    }
    static void checkException(int x, int y){ // ㅗ ㅜ 모양 처리
        for(int[][] t : exception){
            int sum = board[y][x];
            boolean check = true;
            for(int [] a : t){
                int nx = x+a[0];
                int ny = y+a[1];

                if(nx>=0 && nx<M && ny>=0 && ny<N){
                    sum+=board[ny][nx];
                }
                else{
                    check=false;
                }
                if(!check)
                    break;
            }
            answer = Math.max(answer, sum);
        }
    }
}
