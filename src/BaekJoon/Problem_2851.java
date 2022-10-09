package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] arr = new int[10];

        arr[0] = Integer.parseInt(br.readLine());
        for(int i=1;i<10;i++){
            arr[i] = Integer.parseInt(br.readLine())+arr[i-1];
        }
        int ans = 0;
        int num = Integer.MAX_VALUE;
        for (int i : arr) {
            if(num>=Math.abs(100-i)){
                ans = i;
                num = Math.abs(100-i);
            }
        }

        System.out.println(ans);
    }
}
