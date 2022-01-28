package Programmers;

public class Solution_Lev2_2 {
    import java.util.*;
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
                // if(check==true){
                //     if(!(temp>='0'&&temp<='9')){
                //         sb.append((char)(temp-32));
                //     }
                //     else{
                //         sb.append(temp);
                //     }
                //     if(temp!=' '){
                //         check=false;
                //     }
                //     else{
                //         check=true;
                //     }
                // }
                // else{
                //     if(temp==' '){
                //         check=true;
                //     }
                //     sb.append(temp);
                // }
            }
            // System.out.println(sb);
            return sb.toString();
        }
    }
}
