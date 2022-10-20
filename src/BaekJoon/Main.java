package BaekJoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = temp[0];
        int K = temp[1];
        int answer = 0;

        int [] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int [] sum = new int[N];
        sum[0] = arr[0];

        for(int i=1;i<N;i++){
            sum[i] = arr[i]+sum[i-1];
//            if(sum[i]==0){
//                answer++;
//            }
        }
//        System.out.println(answer);
        for (int i : arr) {
            if(i==K){
                answer++;
            }
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i : sum){
            map.put(i,map.getOrDefault(i,0)+1);
        }

//        System.out.println(map);

        for(int i : map.keySet()){
            int n = map.get(i);
            int m = i-K;
            if(map.containsKey(m)){
                if(i==m){
                    answer += n*(n-1);
                }
                else{
                    answer += n*map.get(m);
                }

            }
        }

        System.out.println(answer);


    }
}