package BaekJoon;


/**
 * TreeSet을 사용하여 진행하였다. 먼저 각 줄에 있는 숫자를 stringtokenizer을 통해 각각의 숫자를 받았다.
 * treeset이 비어있거나 해당 숫자들이 treeset의 최솟값과 비교하여 클 경우 ts안에 집어 넣어주고
 * ts의 크기가 N보다 클 경우 ts의 최솟값을 ts에서 빼는 식으로 진행하였다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Problem_2075 {
    static TreeSet<Integer> ts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ts = new TreeSet<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(ts.isEmpty()||temp>ts.first()){
                    ts.add(temp);
                }
                if(ts.size()>N){
                    ts.remove(Integer.valueOf(ts.first()));
                }
            }
        }
        System.out.println(ts.first());
    }
}
