package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Problem_1931 {
    static ArrayList<int []> timeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        timeList = new ArrayList<>();
        for(int i=0;i<N;i++){
            int [] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            timeList.add(arr);
        }
        Collections.sort(timeList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                else
                    return o1[1]-o2[1];
            }
        });
        int end=0;
        int cnt =0;
        for(int i=0;i< timeList.size();i++){
            if(timeList.get(i)[0]>=end){
                cnt++;
                end = timeList.get(i)[1];
            }
        }

        System.out.println(cnt);

    }
}
