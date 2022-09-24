package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_2630 {
    static int [] [] board;
    static int [] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        ans = new int[2];

        for(int i=0;i<N;i++){
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        divide(N,0,0);

        for(int i:ans){
            System.out.println(i);
        }
    }
    static void divide(int n, int y, int x) {
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++)
                if (board[i][j] != board[y][x]) {
                    divide(n / 2, y, x);
                    divide(n / 2, y + n / 2, x);
                    divide(n / 2, y, x + n / 2);
                    divide(n / 2, y + n / 2, x + n / 2);

                    return;
                }
        }

        ans[board[y][x]]++;
    }
}
