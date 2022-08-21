package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_1600 {

    static int K, W, H;
    static int[][] board;
    static int min = Integer.MAX_VALUE;
    static int[] horseDx = {-2, -2, -1, -1, 1, 1, 2, 2}; //말이 이동할 수 있는 8방향
    static int[] horseDy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dx = {0, 1, 0 ,-1}; // 원숭이가 이동할 수 있는 4방향
    static int[] dy = {1, 0, -1, 0};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        W = temp[0];
        H = temp[1];

        board = new int[H][W];
        for(int i = 0; i < H; i++) {
            board [i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        visited = new boolean[H][W][K + 1];

        visited[0][0][K] = true;
        min = bfs(0, 0);

        if(min == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(min);
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0, K));

        while(!q.isEmpty()) {
            Node current = q.poll();
            if(current.x == H - 1 && current.y == W - 1) return current.count;

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny][current.k] && board[nx][ny] == 0) {
                    visited[nx][ny][current.k] = true;
                    q.offer(new Node(nx, ny, current.count + 1, current.k));
                }
            }

            if(current.k > 0) {
                for(int i = 0; i < 8; i++) {
                    int nx = current.x + horseDx[i];
                    int ny = current.y + horseDy[i];
                    if(nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny][current.k - 1] && board[nx][ny] == 0) {
                        visited[nx][ny][current.k - 1] = true;
                        q.offer(new Node(nx, ny, current.count + 1, current.k - 1));
                    }
                }
            }
        }
        return min;
    }

    public static class Node {
        int x;
        int y;
        int count;
        int k;

        public Node(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }
}
