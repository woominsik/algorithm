package Programmers;
/**
 * makeExp에서 수식과 숫자를 분리해준뒤 앞서 정의 해놓은 priors에 따라 compute힘수를 통해 수식을 풀어간다.
 * 풀어 놓은 값을 절대값으로 바꿔준 후 최대값과 비교하여 클 경우 최신화해주어 answer를 구한다.
 */

import java.util.*;

public class Solution_Lev2_36 {
    class Solution {
        String [] priors = {"*,+,-","*,-,+","+,-,*","+,*,-","-,+,*","-,*,+"};
        public long solution(String expression) {
            long answer = Long.MIN_VALUE;
            for(String prior : priors){
                StringBuilder sb = new StringBuilder(expression);
                Long t = Math.abs(makeExp(prior, sb));
                if(t>answer)
                    answer=t;
            }
            return answer;
        }
        Long makeExp(String prior, StringBuilder expression){
            String []priority = prior.split(",");
            ArrayList<Long> num = new ArrayList<>();
            ArrayList<Character> str = new ArrayList<>();
            String [] sarr = expression.toString().split("\\*|-|\\+");
            for(String s : sarr){
                num.add(Long.parseLong(s));
            }
            for(int i=0;i<expression.length();i++){
                char c = expression.charAt(i);
                if(c>='0'&&c<='9'){
                    ;
                }
                else{
                    str.add(c);
                }
            }

            for(String a:priority){
                char s = a.charAt(0);
                while(str.contains(s)){
                    int check = str.indexOf(s);
                    if(check!=-1){
                        Long temp = compute(str.get(check),num.get(check),num.get(check+1));
                        str.remove(check);
                        num.add(check,temp);
                        num.remove(check+1);
                        num.remove(check+1);
                    }
                }
            }
            return num.get(0);
        }
        Long compute(char s, long a, long b){
            if(s=='+'){
                return a+b;
            }
            else if(s=='-'){
                return a-b;
            }
            else{
                return a*b;
            }
        }
    }
}
