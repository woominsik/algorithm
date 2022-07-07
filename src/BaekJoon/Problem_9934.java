package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem_9934 {
    static int max;
    static Map<Integer, ArrayList<Integer>> map;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map= new HashMap<>();
        max=N;
        String [] temp = br.readLine().split(" ");
        int[] arr = new int[temp.length];
        int cnt=0;
        for(String s:temp){
            arr[cnt]=Integer.parseInt(s);
            cnt++;
        }
        recur(arr,1);
        for(int i=1;i<=N;i++){
            for(int n :map.get(i)){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }
    static void recur(int [] arr,int level){
        if(level ==max+1){
            return;
        }
        int mid = arr.length/2;
        if(map.containsKey(level)){
            map.get(level).add(arr[mid]);
        }
        else{
            ArrayList<Integer>temp = new ArrayList<>();
            temp.add(arr[mid]);
            map.put(level,temp);
        }
        recur(Arrays.copyOfRange(arr, 0,mid ),level+1);
        recur(Arrays.copyOfRange(arr, mid, arr.length),level+1);
    }
}
