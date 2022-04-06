package Programmers;
/**
 * 반대로 끝에서부터 시작하여 2로 나누었을 때 나머지가 1일 경우 ans에 1을 더해주고 아닐 경우 그대로 나눠준다.
 * 이 과정을 n이 0에 도달할 때 까지 진행하여 답을 구한다.
 */


public class Solution_Lev2_28 {

    public class Solution {
        public int solution(int n) {
            int ans = 0;

            while(n>0){
                if(n%2==1){
                    ans++;
                    n/=2;
                }
                else{
                    n/=2;
                }
            }

            return ans;
        }
    }
}
