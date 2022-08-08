package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_22862 { //품
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int []temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = temp[0];
        int K = temp[1];

        int [] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int start = 0;
        int end = 0;
        int count =0;
        int len=0;
        int answer = Integer.MIN_VALUE;

        for(start=0;start<N;start++){
            while(end<N){
                if(count>K){
                    break;
                }
                if(nums[end]%2==1){
                    count++;
                }
                len = end-start+1-count;
                if(len>answer){
                    answer = len;
                }
                end++;
            }
            if(nums[start]%2==1){
                count--;
            }
        }
        System.out.println(answer);
    }
}
