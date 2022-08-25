package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem_2961 {
    static ArrayList<int []> ingredient;
    static int answer;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ingredient = new ArrayList<>();

        answer = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int [] temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            ingredient.add(temp);
        }

        comb(0,0,1,0);
        System.out.println(answer);
    }
    static void comb(int cnt, int bitter, int sour, int check){

        if(cnt==N){
            if(check==0){
                return;
            }
            answer = Math.min(answer,Math.abs(bitter-sour));
            return;
        }

        int [] temp = ingredient.get(cnt);
        comb(cnt+1,bitter+temp[1], sour*temp[0],check+1);
        comb(cnt+1,bitter,sour,check);
    }
}
