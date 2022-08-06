package BaekJoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException{
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
}
