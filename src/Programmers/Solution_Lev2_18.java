package Programmers;
/* **
    먼저 입력받은 수의 1의 개수를 센 다음 입력받은 수에 1씩 더해가면서 1의 개수가 같을 때 값을 반납해주어 풀었다.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution_Lev2_18 {

    class Solution {
        public int solution(int n) {
            int answer = 0;
            answer=isRight(n);
            return answer;
        }
        int isRight(int n){
            String nToStr=Integer.toBinaryString(n);
            int num=0;
            for(int i=0;i<nToStr.length();i++){
                if(nToStr.charAt(i)=='1'){
                    num++;
                }
            }
            if(num==1){
                return n*2;
            }
            boolean check=true;
            while(check==true){
                n++;
                int temp=0;
                nToStr=Integer.toBinaryString(n);
                for(int i=0;i<nToStr.length();i++){
                    if(nToStr.charAt(i)=='1'){
                        temp++;
                    }
                }
                if(temp==num){
                    check=false;
                    return n;
                }

            }
            return 1;
        }
    }
}
