package Programmers;
// 처음에 풀때에는 가장 위쪽 칸들과 왼쪽 칸들에 puddle이 생길 것이라는 생각을 못해서 틀렸다.
// 다음으로는 바로 위값과 바로 전 값을 더하는 식으로 하였지만 계속 틀리게 되어
// 다음 방법과 같이 i가 0이 아닐 때는 바로 위값을 더하고 j가 0이 아닐떄는 바로 전 값을 더하게 하여 풀었다.


import java.util.ArrayList;

public class Solution_Lev3_5 {
    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[][] street = new int[n][m];

            // 웅덩이는 -1
            for (int[] puddle : puddles)
                street[puddle[1] - 1][puddle[0] - 1] = -1;

            street[0][0] = 1;

            for (int i = 0; i < n; i++) { // 시작점은 1로 저장
                for (int j = 0; j < m; j++) {

                    if(street[i][j] == -1) { // 웅덩이면 0으로 바꾸고 continue
                        street[i][j] = 0;
                        continue;
                    }

                    if(i != 0)
                        street[i][j] += street[i - 1][j] % 1000000007; // 숫자가 이 값을 초과할 수 있기 때문에 계산 과정에서 나머지 구하기

                    if(j != 0)
                        street[i][j] += street[i][j - 1] % 1000000007; // 왼쪽
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    System.out.print(street[i][j]+" ");
                }
                System.out.println();
            }
            return street[n - 1][m - 1] % 1000000007;
        }
    }
}

