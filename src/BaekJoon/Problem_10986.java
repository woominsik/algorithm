package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10986 {
    public static void main(String[] args) throws IOException { // 좌표 압축을 진행하지 않았을 경우, 메모리 초과 발생
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int [] temp = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        int N = temp[0];
//        int M = temp[1];
//
//
//        long [] arr = Arrays.stream(br.readLine().split(" "))
//                .mapToLong(Long::parseLong)
//                .toArray();
//        long [] sum = new long[N];
//
//        sum[0] = arr[0];
//        for(int i=1;i<N;i++){
//            sum[i] = (arr[i]+sum[i-1])%M;
//        }
//
//        long [] count = new long[M];
//
//        for(long i : sum){
//            count[(int)i]++;
//        }
//
//        long answer = count[0];
//
//        for(int i=0;i<M;i++){
//            long n = count[i];
//            answer+=n*(n-1)/2;
//        }
//
//        System.out.println(answer);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sum = 0;
        int[] count = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % M;
            count[sum]++;
        }

        long ans = count[0];
        for (int i = 0; i < M; i++) {
            ans += (long) count[i] * (count[i] - 1) / 2;
        }
        System.out.println(ans);
    }
}
