package BaekJoon;

/**
 * 각 나무들의 이름과 해당 이름이 나온 빈도 수를 저장할 treecnt를 만들어 진행하였다.
 * while문을 통해 나무 이름들을 받고 해당 나무 이름을 받을때마다 cnt를 증가시켜 전체 총 나무 개수를 저장하였다.
 * 그리고 keySet을 빼와 ArrayList로 변환한 후 정렬하여 사전순으로 정렬되게 하였다.
 * 그 후 treecnt를 통해 각 나무종의 빈도수를 계산하여 출력시켜주었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_4358{
    static Map<String, Integer> treeCnt;
    public static void main(String[] args) throws IOException {
        treeCnt = new HashMap<>();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while(true){
            String temp = br.readLine();
            if(temp==null||temp.equals("")){
                break;
            }
            cnt++;
            treeCnt.put(temp,treeCnt.getOrDefault(temp,0)+1);
        }
        ArrayList<String> temp = new ArrayList<>(treeCnt.keySet());
        Collections.sort(temp);

        for(String s:temp){
            int num = treeCnt.get(s);
            System.out.print(s+" ");
            System.out.printf("%.4f\n",(double)num/cnt*100);
        }
    }
}