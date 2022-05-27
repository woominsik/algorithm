package Programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12914
 * DP를 사용하여 해결하였다. n= n-1+n-2라는 점화식을 사용하여 해결하였다.
 */


public class Solution_Lev3_19 {
    class Solution {
        public long solution(int n) {
            long answer = 0;
            long n1=1;
            long n2=2;
            if(n<=3){
                return n;
            }
            long temp=0;
            for(int i=3;i<=n;i++){
                temp=n1+n2;
                n1=n2%1234567;
                n2=temp%1234567;
            }
            return temp%1234567;
        }
    }
}
