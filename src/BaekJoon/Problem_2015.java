package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Problem_2015 {
    static int [] sum;
    static int answer;
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = temp[0];
        K = temp[1];
        answer = 0;

        int [] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        sum = new int[arr.length+1];
        sum[1] = arr[0];
        for(int i=1;i<arr.length;i++){
            sum[i+1] = arr[i]+sum[i];
        }

        solve();
//        for(int i=1;i<sum.length;i++){
//            for(int j=0;j<=i;j++){
//                if(sum[i]-sum[j]==K && i!=j){
//                    answer++;
//                }
//            }
//        }
        System.out.println(answer);
    }
    public static void solve() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=1; i<=N; i++){
            answer+=map.getOrDefault(sum[i]-K, 0);
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }
    }
}
