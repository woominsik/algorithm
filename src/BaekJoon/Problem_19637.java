package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_19637 {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = temp[0];
        M = temp[1];

        String [] names = new String[N];
        int [] nums = new int[N];
        for(int i=0;i<N;i++){
            String [] arr = br.readLine().split(" ");
            names[i] = arr[0];
            nums[i] = Integer.parseInt(arr[1]);
        }



        for(int i=0;i<M;i++){
            int num = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N-1;

            while(left<=right){
                int mid = (left+right)/2;

                if(num<=nums[mid]){
                    right =mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            sb.append(names[left]+"\n");
        }
        System.out.println(sb);

    }
}
