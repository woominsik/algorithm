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
            {{-1,0},{1,0},{0,1}}, // ㅜ
            {{-1,0},{1,0},{0,-1}}, // ㅗ
            {{0,-1},{0,1},{1,0}}, // ㅏ
            {{0,-1},{0,1},{-1,0}} // ㅓ
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
            for (int j=0;j<M;j++){ // 시작점을 고르기 위한 이중 포문

                dfs(j,i,0,0,visited);
                checkException(j,i);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y, int depth, int sum, boolean[][]visited) {
            // x,y를 활용하여 dfs를 진행하여 ㅗ ㅜ ㅏ ㅓ를 제외한 테트로미노 처리를 해줌
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
    static void checkException(int x, int y){ // ㅗ ㅜ ㅏ ㅓ 모양 처리
        for(int[][] t : exception){ // 각 ㅗ, ㅜ, ㅏ, ㅓ를 처리하는 코드
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
