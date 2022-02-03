package Programmers;
import java.util.*;
public class Solution_Kakao_2020_Lev3_1 {

    class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = false;

            for(int q=0;q<4;q++){
                int [][]temp=spin(key);
                int [][] padded = padding(temp,lock.length-1);
                int num=padded.length-lock.length+1;
                for(int i=0;i<num;i++){
                    for(int j=0;j<num;j++){
                        boolean flag = true;
                        for(int a=0;a<lock.length;a++){
                            for(int b=0;b<lock.length;b++){
                                if(lock[a][b] == padded[i + a][j + b]) flag = false;
                            }
                        }
                        if(flag) return true;
                    }
                }
                key=temp;
            }
            return false;
        }
        int [][] spin(int [][] key){
            int [][] spined=new int[key.length][key[0].length];
            for(int i=0;i<key.length;i++){
                for(int j=0;j<key[i].length;j++){
                    spined[i][j]=key[j][key.length-i-1];
                }
            }
            return spined;
        }
        int[][] padding(int[][] arr, int size) {
            int[][] result = new int[arr.length + size * 2][arr[0].length + size * 2];

            for(int r = 0 ; r < arr.length ; ++r) {
                for(int c = 0 ; c < arr[0].length ; ++c) {
                    result[r + size][c + size] = arr[r][c];
                }
            }

            return result;
        }
    }
}