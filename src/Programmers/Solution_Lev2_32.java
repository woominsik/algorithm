package Programmers;
/**
 * check값을 처음에 true로 두고 true일 경우 소문자를 대문자로 바꿔준다. 그리고 check값을 false로 바꾸고
 * 공백을 만날 경우 true로 바꿔준다. 단 숫자를 만날 경우 대문자로 바꾸지 못하므로 숫자를 만날 경우는 false로 바꿔준다
 */

import java.util.ArrayList;

public class Solution_Lev2_32 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            StringBuilder sb =new StringBuilder();
            boolean check=true;
            s=s.toLowerCase();
            for(int i=0;i<s.length();i++){
                char temp= s.charAt(i);
                if(temp==' '){
                    check=true;
                }
                else if(temp>='0'&&temp<='9'){
                    check=false;
                }
                else{
                    if(check==true){
                        temp=(char)(temp-32);
                    }
                    check=false;
                }
                sb.append(temp);
            }
            // System.out.println(sb);
            return sb.toString();
        }
    }
}
