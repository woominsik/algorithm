package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem_20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = temp[0];
        int K = temp[1];

        int [] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<Integer, Integer> map = new HashMap<>();

        int answer = 0;
        int count =0;
        int start=0;
        int end =0;

        for(int i :nums){
            map.put(i,0);
        }

        for(start = 0;start<N;start++){
            while(end<N&&map.get(nums[end])<K){
                map.put(nums[end],map.get(nums[end])+1);
                count++;
                end++;
            }
            if(end == N)
                end = end-1;
            if(map.get(nums[end])==K){
                answer = answer<count ? count:answer;
            }
            map.put(nums[start],map.get(nums[start])-1);
            count -=1;
        }

        System.out.println(answer);
    }






//    public static void main(String[] args) throws Exception {
//        int [] arr;
//        int [] cnt;
//        Map<Integer, Integer> map = new HashMap<>();
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        arr = new int[n];
//        cnt = new int[100001];
//        st = new StringTokenizer(br.readLine());
//        for(int i=0;i<n;i++)
//            arr[i] = Integer.parseInt(st.nextToken());
//        int l =0, r= 0;
//        int ans = 0 ;
//        while(l<=r)
//        {
//            if(r<=n-1 &&cnt[arr[r]] <k)
//            {
//                cnt[arr[r]]++;
//                r++;
//
//            }
//            else if(cnt[arr[r]] == k)
//            {
//                cnt[arr[l]]--;
//                l++;
//            }
//
//            ans = Math.max(ans, r - l);
//            if(r == n)
//                break;
//        }
//        System.out.println(ans);
//    }
}
