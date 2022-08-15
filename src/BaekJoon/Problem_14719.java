package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem_14719 {
    static int [] arr;
    static int H;
    static int W;
    static int answer;
    static ArrayList<int []> al;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        H = temp[0];
        W = temp[1];

        answer = 0;

        arr = new int [W];

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i=0;i<H;i++){ // 기준 높이가 0부터 점점 증가함
            int [] tArr = new int [W];
            for(int j=0;j<W;j++){ // 0부터 W까지의 너비를 for문을 돌려 해당 자리의 높이가 i보다 작거나 같을 경우 0, 클 경우 1
                if(arr[j]>i){
                    tArr[j] = 1;
                }
                else{
                    tArr[j] = 0;
                }
            }
            // 연산 코드;
            compute(tArr);  // 10010010 와 같이 해당 배열에서 1사이에 있는 0의 개수를 세어서 answer에 저장한다.
        }
        System.out.println(answer);
    }

    static void compute(int[] arr){
        int count = 0;
        boolean check = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){   // 처음으로 1을 만난다면 check를 true로 바꿔 0 count를 증가시키기 시작
                check = true;
            }
            else{
                if(check)  // check값이 true임을 확인하고 count를 증가함
                    count++;
            }
        }
        int min=0;
        for(int i= arr.length-1;i>=0;i--){
            if(arr[i]==1){  // 뒤에서 부터 다시 확인하여 1만나기전에 나온 0의 개수를 세어 빼준다.
                break;
            }
            else{
                min++;
            }
        }
        if(count-min<=0){ // 뺀 값이 0보다 작거나 같을 경우 더하지 않고 해당 함수 종료료            return;
        }
        answer+=count-min;
    }
}
