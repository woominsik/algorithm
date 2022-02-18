package Programmers;
// 처음에 풀때에는 무조건 위에서 부터 더해가면서 내려가야한다고 생각했으나 밑에서부터 더해가면서 올라가면서
// 두개의 자식중 큰 값을 더해가는 식으로 풀었다.

import java.util.*;
public class Solution_Lev3_6 {
    class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            if(triangle.length==1){
                return triangle[0][0];
            }

            for(int i=triangle.length-2;i>=0;i--){
                for(int j=0;j<triangle[i].length;j++){
                    triangle[i][j]=triangle[i][j]+Math.max(triangle[i+1][j],triangle[i+1][j+1]);
                }
            }
            answer=triangle[0][0];
            return answer;
        }
    }
}

