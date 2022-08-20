package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_1600 {

    static int [] horseDx = {2,2,-2,-2,1,1,-1,-1};
    static int [] horseDy = {1,-1,1,-1,2,-2,2,-2};
    static int [][] board;
    static boolean [][] visited;
    static int W;
    static int H;

    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        W = temp[0];
        H = temp[1];

        board = new int[H][W];

        for(int i=0;i<H;i++){
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        visited = new boolean[H][W];
        dfs(0,0,K,0);
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(answer-1);
        }


    }
    static void dfs(int x, int y, int k,int count){
        visited[y][x] = true;
        count +=1;
        if(count>answer){
            return;
        }
//        System.out.println(x+" "+y+" "+count);

        if(x==W-1&&y==H-1){
            if(count<answer)
                answer = count;
        }

        if(k>0){
            for(int i=0;i<8;i++){
                int tx=x+horseDx[i];
                int ty = y+horseDy[i];

                if(tx>=0 && tx<W && ty>=0 && ty<H){
                    if(board[ty][tx]==0&&!visited[ty][tx]){
                        dfs(tx,ty,k-1,count);
                        visited[ty][tx]=false;
                    }
                }
            }
        }
        for(int i=0;i<4;i++){
            int tx=x+dx[i];
            int ty = y+dy[i];

            if(tx>=0 && tx<W && ty>=0 && ty<H) {
                if(board[ty][tx]==0&&!visited[ty][tx]){
                    dfs(tx,ty,k,count);
                    visited[ty][tx]=false;
                }

            }
        }
    }
}
