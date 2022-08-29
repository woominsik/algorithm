package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_16439 {
    static int [][] board;
    static int [] res;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = temp[0];
        int M = temp[1];

        res = new int[3];
        board = new int[N][M];

        for(int i=0;i<N;i++){
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        comb(0,0);

        System.out.println(answer);
    }
    static void comb(int cnt, int idx){
        if(cnt==3){
            compute();
            return;
        }
        for(int i=idx;i<board[0].length;i++){
            res[cnt]=i;
            comb(cnt+1,idx+1);
        }
    }

    static void compute(){
        int sum = 0;
        for(int j=0;j<board.length;j++){
            sum += Math.max(board[j][res[0]],Math.max(board[j][res[1]], board[j][res[2]]));
        }
        answer = Math.max(answer, sum);
    }
}
