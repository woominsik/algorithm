package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Problem_1106 {
    static ArrayList<int []> cities;
    static int c;
    static HashSet<Integer> ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        c = temp[0];

        int n = temp[1];
        int[] dp = new int[c+101];

        Arrays.fill(dp, Integer.MAX_VALUE); // 배열 초기값으로 Integer.MAX_VALUE를 넣었다.
        cities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            dp[temp[1]]=Math.min(temp[0],dp[temp[1]]);
            cities.add(temp); // arrayList안에 각 배열 집어 넣기
        }
        for(int i=1;i<dp.length;i++){  // dp에 저장된 값을 하나씩 꺼낸다.
            if(dp[i]==Integer.MAX_VALUE) // 해당 값에 변화가 없었으면 continue;
                continue;
            for(int [] arr : cities){ // 있을 경우 cities에 저장된 각 증가 인구수와 돈을 꺼내서
                int mon = arr[0];
                int peo = arr[1];
                for(int k=1;i+peo*k<dp.length;k++){  // 해당 i+peo*k가 dp의 길이인 c+101(최대 도시수)를 넘기기 전까지 곱해서 각 자리에 값을 넣어준다.
                    dp[i+peo*k] = Math.min(dp[i+peo*k],dp[i]+mon*k);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=c;i<dp.length;i++){ // c부터 dp 크기 만큼 확인하여 가장 작은 값을 정답으로 한다.
            if(dp[i]<ans){
                ans = dp[i];
            }
        }

        System.out.println(ans);

    }
}
