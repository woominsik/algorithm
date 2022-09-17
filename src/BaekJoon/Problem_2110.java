package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_2110 {
    static int N;
    static int C;
    static int[] homes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N=temp[0];
        C=temp[1];
        homes = new int[N];

        for(int i=0;i<N;i++){
            homes[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        Arrays.sort(homes);

        int left = 1;
        int dist = 0;
        int right = homes[N-1]-homes[0];

        while(left<=right){
            int mid = (left+right)/2;
            int start = homes[0];
            int cnt =1;

            for(int i=1;i<N;i++){
                dist = homes[i]-start;
                if(mid<=dist){
                    cnt++;
                    start = homes[i];
                }
            }

            if(cnt>=C){
                answer = mid;
                left= mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
}
