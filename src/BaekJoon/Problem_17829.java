package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_17829 {
    static int [] [] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i=0;i<N;i++){
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int answer = divide(N,0,0);
        System.out.println(answer);
    }
    static int divide(int size, int x, int y){

        if(size == 2) {
            int arr[] = new int[4];
            int idx = 0;
            for(int r=y;r<y+2;r++) {
                for(int c=x;c<x+2;c++) {
                    arr[idx++] = board[r][c];
                }

            }

            Arrays.sort(arr);
            return arr[2];
        }
        else {
            int arr[] = new int[4];
            size = size/2;

            arr[0] = divide(size,x,y);
            arr[1] = divide(size,x+size,y);
            arr[2] = divide(size, x,y+size);
            arr[3] = divide(size,x+size,y+size);

            Arrays.sort(arr);
            return arr[2];

        }
    }
}
