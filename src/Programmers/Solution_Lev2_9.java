package Programmers;
//  주어진 사각형을 최대공약수를 통해 나누어 패턴 사각형을 만든 후 패턴 사각형에서의 없어져야할 사각형을 구한 뒤
//  다시 최대공약수를 곱하여 얼만큼의 사각형이 비어져야 하는 지 계산한다.


public class Solution_Lev2_9 {
    class Solution {
        public long solution(long w, long h) {
            long answer = 1;
            answer=w*h;
            long gcdNum=gcd(w,h);
            long ansW,ansH;
            ansW=w/gcdNum;
            ansH=h/gcdNum;
            long tmp=(long)(ansW+ansH-1)*gcdNum;
            answer=answer-tmp;
            return answer;
        }
        public long gcd(long w,long h){
            long ans,big, small;
            if(w>=h){
                big=w;
                small=h;
            }
            else{
                big=h;
                small=w;
            }
            if(big%small==0){
                return small;
            }
            else{
                return gcd(small,big%small);
            }
        }
    }
}
