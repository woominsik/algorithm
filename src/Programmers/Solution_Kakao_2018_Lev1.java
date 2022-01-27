package Programmers;

import java.util.Comparator;

public class Solution_Kakao_2018_Lev1 {
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            String [] scores = new String[3];
            int [] num =new int [3];
            String temp="";
            int count=0;
            for(int i=0;i<dartResult.length();i++){
                if(dartResult.charAt(i)>='0'&&dartResult.charAt(i)<='9'){
                    if(temp.length()>1){
                        // System.out.println(temp+" "+count);
                        scores[count]=temp;
                        temp="";
                        count++;
                    }
                }
                temp+=String.valueOf(dartResult.charAt(i));
                // System.out.println(temp);
            }
            scores[count]=temp;
            count=0;
            for(String score : scores){
                int tempnum=0;
                tempnum+=Character.getNumericValue(score.charAt(0));
                for(int i=1;i<score.length();i++){
                    if(score.charAt(i)>='0'&&score.charAt(i)<='9'){
                        tempnum*=10;
                        tempnum+=Character.getNumericValue(score.charAt(i));
                    }
                    else if(score.charAt(i)=='S'||score.charAt(i)=='D'||score.charAt(i)=='T'){
                        tempnum=compute(tempnum,score.charAt(i));
                    }
                    else if(score.charAt(i)=='#'){
                        tempnum*=-1;
                    }
                    else{
                        if(count>0){
                            num[count-1]= num[count-1]*2;
                        }
                        tempnum*=2;
                    }
                }
                num[count]=tempnum;
                count++;
            }
            // for(int n : num){
            //     System.out.println(n);
            // }
            return num[0]+num[1]+num[2];
        }
        int compute(int a,char c){
            int ans=1;
            int b=0;
            if(c=='S'){
                return a;
            }
            else if(c=='D'){
                return a*a;
            }
            else{
                return a*a*a;
            }
        }
    }
}
