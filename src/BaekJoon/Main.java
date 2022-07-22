package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import java.util.*;
import java.io.*;
import java.util.Arrays;


public class Main { // 1106번
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
//        for(int i : dp){
//            i = Integer.MAX_VALUE;
//        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        cities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            dp[temp[1]]=Math.min(temp[0],dp[temp[1]]);
            cities.add(temp);
        }
        for(int i=1;i<dp.length;i++){
            if(dp[i]==Integer.MAX_VALUE)
                continue;
            for(int [] arr : cities){
                int mon = arr[0];
                int peo = arr[1];
                for(int k=1;i+peo*k<dp.length;k++){
                    dp[i+peo*k] = Math.min(dp[i+peo*k],dp[i]+mon*k);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=c;i<dp.length;i++){
            if(dp[i]<ans){
                ans = dp[i];
            }
        }

        System.out.println(ans);

    }
}


