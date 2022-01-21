package Programmers;

public class Solution_Kakao_2022_Lev3_1 {
    // 틀렸음 누적합을 사용하여 해결 -> 그냥 해결할 경우 효율성에서 틀림
// 누적합 = 범위연산시 사용
    class Solution {
        public int solution(int[][] board, int[][] skill) {
            int answer = 0;
            int n = board.length;
            int m = board[0].length;
            int [][] prefix_arr = new int[n+1][m+1];

            for(int [] row : skill)
            {
                int type = row[0];
                int degree = type == 1 ? -row[5] : row[5];
                int r1 = row[1];
                int c1 = row[2];
                int r2 = row[3];
                int c2 = row[4];

                for(int i = r1; i <= r2; ++i)
                {
                    prefix_arr[i][c1] += degree;
                    prefix_arr[i][c2+1] -= degree;
                }
            }
            for(int i = 0; i < n; ++i)
            {
                for(int j = 0; j < m; ++j)
                {
                    if(j != 0) prefix_arr[i][j] += prefix_arr[i][j-1];
                    board[i][j] += prefix_arr[i][j];
                    if(board[i][j] > 0) answer++;
                }
            }

            return answer;
        }
    }
// import java.util.*;
// class Solution {
//     int [][] b;
//     ArrayList<ArrayList<Integer>> al;
//     public int solution(int[][] board, int[][] skill) {
//         int answer = 0;
//         b=board;
//         al=new ArrayList<>();
//         for(int i=0;i<board.length;i++){
//             ArrayList<Integer> temp =new ArrayList<>();
//             for(int j=0;j<board[i].length;j++){
//                 temp.add(board[i][j]);
//             }
//             al.add(temp);
//         }
//         for(int [] i : skill){
//             if(i[0]==1){
//                 attack(i[1],i[2],i[3],i[4],i[5]);
//             }
//             else if(i[0]==2){
//                 heal(i[1],i[2],i[3],i[4],i[5]);
//             }
//         }
//         for(int i=0;i<board.length;i++){
//             for(int j=0;j<board[i].length;j++){
//                 if(al.get(i).get(j)>0)
//                     answer++;
//             }
//         }
//         return answer;
//     }
//     void attack(int r1,int c1 , int r2,int c2,int degree){
//         for(int i=r1;i<=r2;i++){
//             for(int j=c1;j<=c2;j++){
//                 // b[i][j]-=degree;
//                 al.get(i).get(j)-=degree;
//             }
//         }
//     }
//     void heal(int r1,int c1 , int r2,int c2,int degree){
//         for(int i=r1;i<=r2;i++){
//             for(int j=c1;j<=c2;j++){
//                 // b[i][j]+=degree;
//                 ArrayList<Integer> temp = al.get(i);
//                 temp.get(j)+=degree;
//             }
//         }
//     }
// }
}
