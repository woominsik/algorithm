package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Problem_2206 {
    static int N;
    static int M;
    static int [][] board;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static int answer = Integer.MAX_VALUE;
    static boolean [][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = temp[0];
        M = temp[1];

        board = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i=0;i<N;i++){
            board[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        visited[0][0][0]=true;
        answer = bfs(0,0);
        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(answer+1);
        }

    }
    static int bfs(int x,int y){
        Queue<Main.Node> q = new LinkedList<>();

        q.add(new Main.Node(0,0,0,0));

        while (!q.isEmpty()){
            Main.Node n = q.poll();



            if(n.x==M-1 && n.y==N-1){
                return n.move;
            }

            for(int i=0;i<4;i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx>=0 && nx<M && ny>=0 && ny<N && !visited[ny][nx][n.count]){
                    if(n.count==0){
                        if(board[ny][nx]==0){
                            visited[ny][nx][n.count] = true;
                            q.add(new Main.Node(nx,ny,n.move+1, n.count));
                        }
                        else{
                            visited[ny][nx][n.count+1] = true;
                            q.add(new Main.Node(nx,ny,n.move+1, n.count+1));
                        }
                    }
                    else{
                        if(board[ny][nx]==0){
                            visited[ny][nx][n.count] = true;
                            q.add(new Main.Node(nx,ny,n.move+1, n.count));
                        }
                    }
                }
            }
        }


        return answer;
    }

    static class Node{
        int x;
        int y;
        int move;
        int count;

        public Node(int x, int y, int move, int count) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.count = count;
        }
    }
}
