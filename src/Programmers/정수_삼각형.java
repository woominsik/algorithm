package Programmers;
import java.util.*;
public class 정수_삼각형 {

    class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            for(int i=triangle.length-2;i>=0;i--){
                for(int j=0;j<triangle[i].length;j++){
                    triangle[i][j] += Math.max(triangle[i+1][j],triangle[i+1][j+1]);
                }
            }
            return triangle[0][0];
        }
    }

}
