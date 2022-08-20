package BaekJoon;



import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int M;
    static int [][] board;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static int answer = Integer.MAX_VALUE;
    static boolean [][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = temp[0];
        M = temp[1];

        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            board[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0,0,1,0);
        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }

    }
    static void dfs(int x, int y, int k,int count){
        visited[y][x] = true;

        count +=1;
        if(x==M-1 && y==N-1){
            if(count<answer)
                answer = count;
        }

        if(k>0){
            for(int i=0;i<4;i++){
                int tx = x+dx[i];
                int ty = y+dy[i];
                if(tx>=0 && tx<M && ty>=0 && ty<N){
                    if(board[ty][tx]==1 && !visited[ty][tx]){
                        dfs(tx,ty,k-1,count);
                        visited[ty][tx] = false;
                    }
                }
            }
        }

        for(int i=0;i<4;i++){
            int tx = x+dx[i];
            int ty = y+dy[i];
            if(tx>=0 && tx<M && ty>=0 && ty<N){
                if(board[ty][tx]==0 && !visited[ty][tx]){
                    dfs(tx,ty,k,count);
                    visited[ty][tx] = false;
                }
            }
        }
    }
}

