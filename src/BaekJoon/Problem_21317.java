package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_21317 {
    public static void main(String[] args) throws IOException {  //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][]arr = new int [N-1][2];

        for(int i=0;i<N-1;i++){
            int [] temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            arr[i]=temp;
        }
        int K = Integer.parseInt(br.readLine());

        int [] dp = new int [N];

        if(N==1){
            System.out.println(dp[N-1]);
            return;
        }

        dp[1] = dp[0]+arr[0][0];

        for(int i=2;i<N;i++){ // 작은 점프와 큰 점프만을 사용하여 dp 값 구함
            dp[i] = Math.min(dp[i-1] + arr[i-1][0],dp[i-2]+arr[i-2][1]);
        }

        for(int i=N-1;i>=3;i--){ // 매우 큰 점프를 단 한번 사용하기 위해 for문을 거꾸로 돌려 구현
            dp[i] = Math.min(dp[i], dp[i-3]+K);
        }

        for(int i=3;i<N;i++){ // 중간에 매우 큰 점프를 사용할 수 있으므로 다시한번 1의 과정 진행
            dp[i] = Math.min(dp[i],Math.min(dp[i-1]+arr[i-1][0],dp[i-2]+arr[i-2][1]));
        }


        System.out.println(dp[N-1]);
    }
}
