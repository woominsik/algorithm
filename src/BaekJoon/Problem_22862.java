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
            while(end<N){ // end가 끝에 도달하면 반복문 탈출
                if(count>K){ // 홀수 개수가 K개 이상일 경우 while문 탈출
                    break;
                }
                if(nums[end]%2==1){ //end번째 수가 홀수면 count 증가
                    count++;
                }
                len = end-start+1-count; // end에서 start사이의 거리에서 count값 뻬줌
                if(len>answer){ //answer값 바꿔줌
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
