package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        List<Long> al = new ArrayList<>();
        al.add(arr[0]);
        boolean check=false;
        Long cnt=1L;
        while(true){
            cnt++;
            al=compute(al);
            if(al.contains(arr[1])){
                break;
            }
            al = al.stream()   // arr[1]보다 작은 값들 모두 제거
                    .filter(t->t<arr[1])
                    .collect(Collectors.toList());

            if(al.size()==0){
                check=true;
                break;
            }
        }
        if(check)
            System.out.println(-1);
        else
            System.out.println(cnt);
    }
    static ArrayList<Long> compute(List<Long>al){ // 연산
        ArrayList<Long> temp = new ArrayList<>();
        for(Long i : al){
            temp.add(i*2);
            temp.add(i*10+1);
        }
        return temp;
    }
}
