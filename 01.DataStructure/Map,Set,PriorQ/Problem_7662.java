package BaekJoon;

/**
 * treeset을 활용하여 이중 우선순위 큐를 만들었다. 다만 treeset의 경우 삭제 시 같은 숫자가 여러개 반복해서
 * 들어갔더라도 한번에 모든 수를 지우기 때문에 각 수들의 개수를 count해줄 HashMap변수인 count를 만들어 진행하였다.
 * 만약 count에서 수의 개수를 찾은 후 1일 경우 ts에서도 삭제하고 1보다 클 경우 count에서만 값을 줄여주는 식으로 문제를 풀었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

public class Problem_7662 {
    static TreeSet<Integer> ts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int j=0;j<T;j++){
            ts= new TreeSet<>();
            HashMap<Integer, Integer> count = new HashMap<>();
            int k = Integer.parseInt(br.readLine());
            for(int i=0;i<k;i++){
                String [] temp = br.readLine().split(" ");
                int num = Integer.parseInt(temp[1]);

                if(temp[0].equals("I")){
                    ts.add(num);
                    count.put(num,count.getOrDefault(num,0)+1);
                }
                else{
                    if(ts.isEmpty()){
                        continue;
                    }
                    if(num==1){
                        int l =ts.last();
                        if(count.get(l)-1==0){
                            count.remove(Integer.valueOf(l));
                            ts.remove(Integer.valueOf(l));
                        }
                        else{
                            count.put(l,count.get(l)-1);
                        }
                    }
                    else{
                        int l =ts.first();
                        if(count.get(l)-1==0){
                            count.remove(Integer.valueOf(l));
                            ts.remove(Integer.valueOf(l));
                        }
                        else{
                            count.put(l,count.get(l)-1);
                        }
                    }
                }
            }
            if(ts.isEmpty()){
                System.out.println("EMPTY");
            }
            else{
                System.out.println(ts.last()+" "+ ts.first());
            }
        }

    }
}
