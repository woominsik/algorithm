package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Problem_11286 {
    static TreeMap<Integer, ArrayList<Integer>> absNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        absNum = new TreeMap<>();
        for(int i=0;i<N;i++){
            int x=Integer.parseInt(br.readLine());
            if(x==0){
                if(absNum.isEmpty()){
                    System.out.println(0);
                    continue;
                }
                ArrayList<Integer> temp = absNum.firstEntry().getValue();
                int key = absNum.firstEntry().getKey();
                if(temp.isEmpty()){
                    System.out.println(0);
                    continue;
                }
                int minNum = Collections.min(temp);
                System.out.println(minNum);
                temp.remove(Integer.valueOf(minNum));
                if(temp.isEmpty()){
                    absNum.remove(Integer.valueOf(key));
                }
            }
            else{
                int abs = Math.abs(x);
                if(absNum.containsKey(abs)){
                    absNum.get(abs).add(x);
                }
                else{
                    ArrayList<Integer> temp= new ArrayList<>();
                    temp.add(x);
                    absNum.put(abs,temp);
                }
            }
        }
    }
}
