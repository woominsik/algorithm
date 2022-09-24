package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_9663 {
    static int N;
    static int[] visited;
    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){ //첫번째 줄에서 시작점 선택
            visited = new int[N];
            dfs(0,i);
        }

        System.out.println(answer);
    }

    static void dfs(int count, int now){
        visited[count]=now; // count는 줄의 수, now는 열 넘버 저장됨

        if(count==N-1){
            answer++;
            return;
        }

        for(int i=0;i<N;i++){
            if(check(i,count)){
                dfs(count+1, i);
            }
        }
        return;
    }

    static boolean check(int i, int count){
        for(int k=0;k<=count;k++){
            if(visited[k]==i){
                return false;
            }

            if((count+1-k)==Math.abs(i-visited[k])){
                return false;
            }
        }
        return true;
    }
}
