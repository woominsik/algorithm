package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

public class Problem_2580 {
    static int[][] board;
    static Map<int[], ArrayList<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
//        arral = new LinkedList<>();

        for(int i=0;i<9;i++){
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    map.put(new int[]{j,i}, new ArrayList(Arrays.asList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
                }
            }
        }

//        while(!map.isEmpty()){
//            int [] temp = arral.poll();
//
//            if(check(temp[0],temp[1])==0){
//                arral.add(temp);
//            }
//        }
    }

    static void checkHorizontal(int x, int y){
        ArrayList<Integer> al = map.get(new int[]{x,y});

        for(int k=0;k<9;k++){
            al.remove(Integer.valueOf(board[y][k]));
        }
    }

    static void checkVertical(int x,int y){

        ArrayList<Integer> al = map.get(new int[]{x,y});

        for(int k=0;k<9;k++){
            al.remove(Integer.valueOf(board[k][x]));
        }

    }

    static void checkRect(int x, int y){
        int sx = (x/3)*3;
        int sy = (y/3)*3;

        ArrayList<Integer> al = map.get(new int[]{x,y});

        for(int i=sy;i<sy+3;i++){
            for(int j=sx;j<sx+3;j++){
                al.remove(Integer.valueOf(board[i][j]));
            }
        }
    }
}
