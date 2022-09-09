package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_22871 {
    static int N;
    static int[] stones;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stones = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i=0;i<N-1;i++){
            int left = i;
            int right = N-1;
            int res;
            while(left<right){
                int mid = (left + right) / 2;
                res = (mid-left) * (1+Math.abs(stones[mid]-stones[left]));

            }
        }


    }
}
