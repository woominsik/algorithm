package Programmers;
import java.util.*;
public class Solution_Lev3_1 {


    class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            Arrays.sort(times);
            long left=0;
            long right=(long) n*times[times.length-1];
            long mid;
            long count;
            while(left<=right){
                mid=(right+left)/2;
                count=0;
                for(int i=0;i<times.length;i++){
                    count+=mid/times[i];
                }
                if(count>=n){
                    right=mid-1;
                    answer=mid;
                }
                else{
                    left=mid+1;
                }
            }
            return answer;
        }
    }
}

