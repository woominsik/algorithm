package Programmers;
// 피보나치 수열과 마찬가지로 p[n]= p[n-1]+p[n-2]로 점화식을 구하여 문제를 해결하였다.

import java.util.HashMap;
import java.util.Map;

public class Solution_Lev3_10 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            // int [] tile =new tile[n+1];
            int t1=1;
            int t2=2;
            int temp=0;
            for(int i=3;i<=n;i++){
                temp=(t1+t2)%1000000007;
                t1=t2;
                t2=temp;
            }
            return temp;
        }
    }
}
