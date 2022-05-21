package Programmers;
/**
 *
 */


import java.util.*;

public class Solution_Lev2_40 {

    class Solution {
        public String solution(int n, int t, int m, int p) {
            String answer = "";
            int temp=m*(t-1)+p;
            StringBuffer sb=new StringBuffer();
            int i=0;
            while(sb.length()<temp){
                sb.append(numToString(i,n));
                i++;
            }
            // System.out.println(sb);
            for(int j=0;j<t;j++){
                answer+=sb.charAt(m*j+p-1);
                // System.out.println(sb.charAt(2*j+p-1));
            }
            return answer;
        }
        StringBuffer numToString(int num,int n){
            StringBuffer sb=new StringBuffer();
            if(num==0){
                sb.append(0);
            }
            while(num>0){
                if(num%n<10){
                    sb.append(num%n);
                }
                else{
                    sb.append((char)(num%n-10+'A'));
                }
                num/=n;
            }
            return sb.reverse();
        }
    }
}
