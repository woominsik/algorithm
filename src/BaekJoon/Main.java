package BaekJoon;



import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int [] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i : nums){
            al.add(i);
        }

        Collections.sort(al);
        int answer = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                ArrayList<Integer> temp = new ArrayList<>(al);
                if(i!=j){
                    temp.remove(Integer.valueOf(nums[i]));
                    temp.remove(Integer.valueOf(nums[j]));
                    answer = Math.min(answer, compare(nums[i]+nums[j],temp));
                }
            }
        }
        System.out.println(answer);
    }
    static int compare(int s1,ArrayList<Integer> temp){
        System.out.println(s1);
        int t = Integer.MAX_VALUE;
        for(int i=1;i<temp.size();i++){
           t = Math.min(t, Math.abs(s1- (temp.get(i)+temp.get(i-1) )));
        }
        return t;
    }
}
