package BaekJoon;

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
