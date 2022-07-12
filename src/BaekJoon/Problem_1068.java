package BaekJoon;

/**
 * 먼저 각 노드들의 자식들을 저장할 HashSet배열인 alSet을 선언하고 각 노드들의 부모가 저장된 arr을 사용하였다.
 * 먼저 alSet에 arr을 for문을 돌려 바로 밑에 자식들을 저장하고 for문을 통해 리프노드들을 찾았다.
 * 해당 리프노드들에서 dfs를 돌려 상위 노드에게 자신의 모든 자식들을 넘겨주는 식으로 진행하였다.
 * 그리고 모든 alSet을 최신화한 후 for문을 통해 deleted이거나 deleted의 자식임을 확인하고 각 Set에서 삭제한다.
 * 그리고 해당 set의 크기가 0일 경우 answer에 값을 더해 풀었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Problem_1068 {
    static Map<Integer, Integer> map; //num이랑 총 자식 수
    static HashSet<Integer>[] alSet; // 자식을 담은 배열
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        alSet = new HashSet[N];
        for(int i=0;i<N;i++){
            alSet[i]=new HashSet<>();
        }
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for(int i=0;i<N;i++){
            if(arr[i]!=-1)
                alSet[arr[i]].add(i);
        }
        for(int i=0;i<N;i++){
            if(alSet[i].size()==0){
                dfs(i);
            }
        }

        int deleted = Integer.parseInt(br.readLine());
        int answer=0;
        for(int i=0;i<N;i++){
            if(i!=deleted&&!alSet[deleted].contains(i)){
                alSet[i].remove(deleted);
                alSet[i].removeAll(alSet[deleted]);
                if(alSet[i].size()==0){
//                    System.out.println(i+" "+alSet[i]);
                    answer++;
                }
            }

        }
        System.out.println(answer);
    }
    static void dfs(int i){
        if(arr[i]==-1){
            return;
        }
        else{
            alSet[arr[i]].addAll(alSet[i]);
            dfs(arr[i]);
        }
    }
}
