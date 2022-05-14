package Programmers;
/**
 * 이중포문을 통해 find함수를 실행 시켜준다. find함수에서는 교점을 찾고 교점이 정수임을 확인하고 intersection 이라는 set에
 * 넣어준다. 그리고 최대값과 최소값을 갱신시켜준다.
 * 그리고 answer을 .으로 초기화시켜준다. 그리고 각각의 star을 통해 .을 *로 바꿔준다.
 */

import java.util.*;

public class Solution_Lev2_35 {
    class Solution {
        Set<long[]> intersection;
        long minX=Long.MAX_VALUE,minY=Long.MAX_VALUE;
        long maxX=Long.MIN_VALUE, maxY=Long.MIN_VALUE;
        public String[] solution(int[][] line) {
            intersection = new HashSet<>();
            for(int i=0; i<line.length-1; i++){
                for(int j=i+1; j<line.length; j++){
                    find(line[i],line[j]);
                }
            }
            String[] answer = new String[(int) (maxY - minY) + 1];
            for(int i=0; i<answer.length; i++){
                answer[i] = ".".repeat((int)(maxX - minX) + 1);
            }
            for(long [] star : intersection){
                long x = star[0], y = star[1];
                answer[(int)(maxY-y)] = answer[(int)(maxY-y)].substring(0, (int)(x-minX)) + "*" + answer[(int)(maxY-y)].substring((int)(x-minX)+1);

            }
            return answer;
        }
        void find(int [] l1, int []l2){
            double x;
            double y;
            double A, B, C, D, E, F;
            A = l1[0]; B = l1[1]; E = l1[2];
            C = l2[0]; D = l2[1]; F = l2[2];
            x=(B*F - E*D)/(A*D-B*C);
            y=(E*C-A*F)/(A*D-B*C);
            boolean c1=true;
            if(Math.ceil(x)!=Math.floor(x))
                c1=false;
            if(Math.ceil(y)!=Math.floor(y))
                c1=false;
            long ix = (long) x, iy = (long) y;
            if(x == ix && y == iy){
                intersection.add(new long[] {ix, iy});
                minX = Math.min(minX, ix); maxX = Math.max(maxX, ix);
                minY = Math.min(minY, iy); maxY = Math.max(maxY, iy);
            }
        }
    }
}
