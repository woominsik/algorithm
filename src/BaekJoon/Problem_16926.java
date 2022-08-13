package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_16926 {
    static Queue<Integer>[] alArr;
    static int N;
    static int M;
    static int R;
    static int [][] nums;
    static int [][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = temp[0];
        M = temp[1];
        R = temp[2];

        nums= new int[N][M];
        ans = new int[N][M];

        for(int i=0;i<N;i++){
            nums[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int setNum = (Math.min(N,M)+1)/2; // 틀의 개수
        alArr = new LinkedList[setNum];

        for(int i=0;i<setNum;i++){
            alArr[i]= new LinkedList<>();
            div(i);
        }

        for(int i=0;i<setNum;i++){
            rotate(i);
        }

        for(int i=0;i<setNum;i++){
            assemble(i);
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

    }

    static void div(int lev){ // lev : 해당 틀이 밖에서 몇번째인지
        for(int i=lev;i<=M-lev-1;i++){ // 틀에서 가장 위 가로줄을 더함
            alArr[lev].add(nums[lev][i]);
        }

        for(int i=lev+1;i<N-lev-1;i++){ //  가장 오른쪽 세로줄을 넣어줌
            alArr[lev].add(nums[i][M-lev-1]);
        }

        for(int i=M-lev-1;i>lev;i--){ // 틀에서 가장 아래 가로줄을 더함
            alArr[lev].add(nums[N-lev-1][i]);
        }

        for(int i=N-lev-1;i>lev;i--){ //  가장 왼쪽 세로줄을 넣어줌
            alArr[lev].add(nums[i][lev]);
        }
    }

    static void rotate(int lev){
        for(int i=0;i<R;i++){
            int num = alArr[lev].poll();
            alArr[lev].add(num);
        }
    }

    static void assemble(int lev){
        for(int i=lev;i<=M-lev-1;i++){ // 틀에서 가장 위 가로줄을 더함
            ans[lev][i] = alArr[lev].poll();
        }

        for(int i=lev+1;i<N-lev-1;i++){ //  가장 오른쪽 세로줄을 넣어줌
            ans[i][M-lev-1] = alArr[lev].poll();
        }

        for(int i=M-lev-1;i>lev;i--){ // 틀에서 가장 아래 가로줄을 더함
            ans[N-lev-1][i] = alArr[lev].poll();
        }

        for(int i=N-lev-1;i>lev;i--){ //  가장 왼쪽 세로줄을 넣어줌
            ans[i][lev] = alArr[lev].poll();
        }
    }
}
