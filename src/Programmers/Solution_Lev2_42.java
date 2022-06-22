package Programmers;
/**
 *  https://programmers.co.kr/learn/courses/30/lessons/12902#
 *  점화식을 세워 풀이하는 Dynamic Programming 문제였다.
 *
 */


public class Solution_Lev2_42 {
    class Solution {
        static int mod = 1000000007;
        public int solution(int n) {
            int answer = 0;
            if(n==2)return 3;
            if(n==4)return 11;
            long[] arr = new long[n+1];
            arr[0]=1; arr[2]=3;arr[4]=11;
            for(int i = 6;i<=n;i+=2){
                arr[i]=arr[i-2]*arr[2]; //i-2타일에 2짜리 타일을 더해 n타일 구성
                for(int j = i-4;j>=0; j-=2){
                    arr[i]+=((arr[j]*2)); // 짝수 개마다 유일하게 생긴 두개의 타일 존재
                }
                arr[i]%=mod;
            }
            return (int)arr[n];
        }
    }
}
