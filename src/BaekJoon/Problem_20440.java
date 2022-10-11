package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Problem_20440 {
    public static void main(String[] args) throws IOException { // 좌표 압축을 진행하지 않았을 경우, 메모리 초과 발생
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] sarr = new int[N];
        int [] earr = new int [N];
        int [][] arr = new int[2*N][2];
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int count = 0;
        int count2 =0;
        for(int i=0;i<N;i++){
            int [] temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            sarr[count] = temp[0];
            earr[count] = temp[1];
            count++;

            arr[count2][0] = temp[0]; arr[count2][1]++; count2++;
            arr[count2][0] = temp[1]; arr[count2][1]--; count2++;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }
                else{
                    return o1[1]-o2[1];
                }

            }
        });

        for (int i = 1; i < arr.length; i++) {
            arr[i][1] += arr[i-1][1];
        }


        for (int[] ints : arr) {
            map.put(ints[0],ints[1]);
//            System.out.println(ints[1]+" "+ints[0]);
        }

        int [] check = new int[map.size()]; //idx 저장
        int [] tArr = new int[map.size()]; // 값 저장

        int cnt = 0;
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            check[cnt] = m.getKey();
            tArr[cnt] = m.getValue();

            cnt++;
        }


        int maxNum = 0;
        int start=0;
        int len=0;
        int end=0;
        boolean c = false;
        count =0;
        for(int i=0;i<tArr.length;i++){

            if(tArr[i]>maxNum){
                start = i;
                maxNum=tArr[i];
                count=0;
                c=true;
            }
            if(tArr[i]==maxNum){
                count++;
            }
            else{
                if(c){
                    len = count;
                }
                c = false;
                count = 0;
            }
        }

        System.out.println(maxNum);
        System.out.println(check[start]+" "+check[start+len]);
    }
}
