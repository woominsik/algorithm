package Programmers;

/**
 * 못풀었음
 * row-start값과 row-end값, col-start값과 col-end값을 선언한 후 queries에서 역순으로 시작하여 x,y값에 도달할 수 있는
 * n,m의 후보를 찾는 식으로 진행한다.
 * 원래 좌로 움직이어야 할것은 우로 바꾸고 rs값이 0보다 크면 step값을 더해주게 되고 re값에는 m-1과 re+step값중 최소값을 준다.
 * 우는 좌와 반대로 진행 re값이 m-1보다 작을 경우 step을 뺴주게 되고 rs값은 0과 rs-step중 큰 값을 준다.
 * 마찬가지로 상과 하도 진행한 후 col의 범위 ce-cs+1과 row의 범위 re-rs+1를 서로 곱하여 준다.
 */

public class Solution_Lev3_11 {
    class Solution {
        public long solution(int n, int m, int x, int y, int[][] queries) {
            long rs=x, re=x, cs=y, ce=y;
            // rs = row-start, re = row-end, cs = col_start, ce = col_end
            for(int i=queries.length-1 ; i>=0 ; i--) {
                int way=queries[i][0], step=queries[i][1];

                if(way==0) {
                    // 원래 좌로 -> 우로
                    if(cs>0) cs += step;
                    ce = Math.min(m-1, ce+step);

                } else if(way==1) {
                    // 원래 우로 -> 좌로
                    if(ce<m-1) ce -= step;
                    cs = Math.max(0, cs-step);

                } else if(way==2) {
                    // 원래 위로 -> 아래로
                    if(rs>0) rs += step;
                    re = Math.min(n-1, re+step);

                } else {
                    // 원래 아래로 -> 위로
                    if(re<n-1) re -= step;
                    rs = Math.max(0, rs-step);
                }
                // System.out.println(rs+" "+re+" "+cs+" "+ce);
                if(rs>=n || re<0 || cs>=m || ce<0) return 0;
            }
            return (re-rs+1)*(ce-cs+1);
        }
    }

}
