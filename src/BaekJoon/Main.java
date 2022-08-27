package BaekJoon;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static int [][] board;
    static int N;
    static ArrayList<int[]> chics;
    static ArrayList<int[]> homes;
    static int M;
    static ArrayList<int[]> result;
    static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = temp[0];
        M = temp[1];
        result = new ArrayList<>();
        board = new int [N][N];
        chics = new ArrayList<>();
        homes = new ArrayList<>();
        for(int i=0;i<N;i++){
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]==1){
                    homes.add(new int[] {i,j});
                } else if (board[i][j]==2) {
                    chics.add(new int []{i,j});
                }
            }
        }
        comb(0);

        System.out.println(answer);

    }
    static void comb(int idx){
        if(result.size() == M){
            compute();
            return;
        }

        for(int i=idx;i< chics.size();i++){
            result.add(chics.get(i));
            comb(i+1);
            result.remove(chics.get(i));
        }
    }
    static void compute(){
        int chicDist =0;
        for(int [] t : homes){
            int tmp = Integer.MAX_VALUE;
            for(int[] res : result){
                tmp = Math.min(Math.abs(t[0]-res[0])+Math.abs(t[1]-res[1]),tmp);
            }
            chicDist+=tmp;
        }
        answer = Math.min(chicDist,answer);
    }
}

