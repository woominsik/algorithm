package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2156 {
    public static void main(String[] args) throws IOException {  //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n+1];
        int [] dp = new int [n+1];
        for(int i=1;i<=n;i++){
            int t = Integer.parseInt(br.readLine());
            arr[i] =t;

        }


        dp[1] = arr[1];
        if(n>1){
            dp[2] = arr[1]+arr[2];
        }


        for(int i=3;i<=n;i++){  // 전자는 현재 포도주를 마시지 않을 때, 후자 두개는 각 i-2를 마시고 현재 거 마신것, i-3과 i-1와 현재것 마신거
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }


        System.out.println(dp[n]);

    }
}
