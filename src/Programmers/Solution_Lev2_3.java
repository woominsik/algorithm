package Programmers;
// 처음에는 dfs를 활용하여 풀려하였으나 land의 최대길이가 100,000으로 시간 초과가 발생하여 실패하였고
// dp를 사용하여 i-1일때의 land값중 최댓값을 더해가며 dp를 진행하였다.


import java.util.*;
public class Solution_Lev2_3 {

    class Solution {
        int [][]board;
        int solution(int[][] land) {
            int answer = 0;
            board=land;

            for(int i=1;i<land.length;i++){
                land[i][0]+=Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
                land[i][1]+=Math.max(land[i-1][0],Math.max(land[i-1][2],land[i-1][3]));
                land[i][2]+=Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][3]));
                land[i][3]+=Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][2]));
            }
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            // System.out.println("Hello Java");
            for(int i=0;i<4;i++){
                answer=Math.max(answer,land[land.length-1][i]);
            }
            return answer;
        }
    }



// class Solution {
//     HashSet <Integer> scores;
//     int max;
//     int [][] board;
//     int solution(int[][] land) {
//         int answer = 0;
//         max=land.length;
//         board=land;
//         scores=new HashSet<>();

//         // visited=new boolean[land[i].length];
//         for(int i=0;i<land[0].length;i++){
//             dfs(0,land[0][i],i);
//         }
//         // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//         System.out.println(scores);
//         return answer;
//     }
//     void dfs(int depth,int score,int none){
//         if(depth==max-1){
//             scores.add(score);
//             return;
//         }
//         for(int i=0;i<board[depth].length;i++){
//             if(i!=none){
//                 dfs(depth+1,score+board[depth][i],i);
//             }
//         }
//     }
// }
}
