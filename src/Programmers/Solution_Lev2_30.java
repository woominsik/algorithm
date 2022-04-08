package Programmers;
/**
 * 이중 포문을 통해 각각 두개의 수식을 getIntersection에 넘겨주고 getIntersection에서 각 식을 통헤 교점을 구하고 정수임을 확인한 후 정수일 경우
 * intersection이라는 set에 넣고 최소값과 최대값을 refresh해준다. 그리고 x와 y의 최소값과 최대값을 통해 .을 찍은 후 intersection에 저장되어있는 교점의 좌표를 가져와
 * .대신 *을 넣어 별을 찍어준다.
 */

import java.util.*;

public class Solution_Lev2_30 {
    class Solution {
        static Set<long[]> intersection;
        static long xMin, xMax, yMin, yMax;
        public String[] solution(int[][] line) {
            intersection = new HashSet<>();
            xMin = Long.MAX_VALUE; yMin = Long.MAX_VALUE;
            xMax = Long.MIN_VALUE; yMax = Long.MIN_VALUE;

            for(int i=0; i<line.length-1; i++){
                for(int j=i+1; j<line.length; j++){
                    getIntersection(line[i], line[j]);
                }
            }

            String[] answer = new String[(int) (yMax - yMin) + 1];
            for(int i=0; i<answer.length; i++){
                answer[i] = ".".repeat((int)(xMax - xMin) + 1);
            }

            for(long [] star : intersection){
                long x = star[0], y = star[1];
                answer[(int)(yMax-y)] = answer[(int)(yMax-y)].substring(0, (int)(x-xMin)) + "*" + answer[(int)(yMax-y)].substring((int)(x-xMin)+1);
            }

            return answer;
        }

        public void getIntersection(int[] line1, int[] line2){
            double A, B, C, D, E, F;
            A = line1[0]; B = line1[1]; E = line1[2];
            C = line2[0]; D = line2[1]; F = line2[2];

            double slope  = A*D - B*C;
            if(slope == 0)  return;

            double x = (B*F - E*D) / slope, y = (E*C - A*F) / slope;
            long ix = (long) x, iy = (long) y;
            if(x == ix && y == iy){
                intersection.add(new long[] {ix, iy});
                xMin = Math.min(xMin, ix); xMax = Math.max(xMax, ix);
                yMin = Math.min(yMin, iy); yMax = Math.max(yMax, iy);
            }
            return;
        }
    }
}
