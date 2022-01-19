package Programmers;
import java.util.*;
public class Solution_Kakao_2022_Lev2_1 {

    class Solution {
        public int solution(int n, int k) {
            int answer = 0;
            String temp= change(n,k);
            long a=0;
            for(int i=0;i<temp.length();i++){
                int tmpnum=Character.getNumericValue(temp.charAt(i));
                if(tmpnum==0){
                    if(check(a))
                        answer++;
                    // System.out.println(i+" "+a);
                    a=0;
                }
                else{
                    a*=10;
                    a+=tmpnum;
                }
                if(i==temp.length()-1){
                    if(a!=0){
                        if(check(a))
                            answer++;
                        // System.out.println(i+" "+a);
                    }
                }
            }
            return answer;
        }
        String change(int value,int n){
            StringBuilder builder = new StringBuilder();
            while (value >= 1) {
                builder.insert(0, value % n);
                value /= n;
            }
            return builder.toString();
        }
        boolean check(long num){
            if(num<=1) return false;
            int max = (int)Math.sqrt(num);
            for(int i=2 ; i<=max ; i++) {
                if(num%i==0) return false;
            }
            return true;
        }
    }
}
