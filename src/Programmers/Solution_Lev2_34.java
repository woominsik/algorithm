package Programmers;
/**
 * 먼저 divide함수를 통해 각각의  string을 나눠주고 각각의 나눠진 String을 check함수를 통해 영문자만 들어갔는 지 확인한다.
 * 확인 후 true인 String은 각 arraylist에 넣어준다 그리고 나눠진 두개의 arrayList를 score로 넘기어 점수를 구한다.
 * score에서는 al에서 하나씩 string을 뺴와서 al2에 제거한후 제거가 될 경우에는 andset에 넣고 orset에 넣어주고
 * 안될 경우에는 orset에만 넣어준다. 다음에 al2에 대해서 모두 or2에 집어넣어 준다.
 * 이렇게 나온 andset과 orset의 사이즈를 통해 점수계산한다.
 */

import java.util.*;

public class Solution_Lev2_34 {
    class Solution {

        public int solution(String str1, String str2) {
            int answer = 0;
            ArrayList<String> al = new ArrayList<>();
            ArrayList<String> al2 = new ArrayList<>();
            divide(str1,al);
            divide(str2,al2);
            answer = score(al,al2);
            return answer;
        }
        int score(ArrayList<String> al,ArrayList<String> al2){
            if(al.size()==0 && al2.size()==0){
                return 65536;
            }
            ArrayList<String> andSet = new ArrayList<>();
            ArrayList<String> orSet = new ArrayList<>();

            for(String s : al){
                if(al2.remove(s)){
                    andSet.add(s);
                }
                orSet.add(s);
            }
            for(String s : al2){
                orSet.add(s);
            }
            // System.out.println(andSet);
            // System.out.println(orSet);
            double score = (double)andSet.size() / orSet.size();
            score*=65536;
            score=Math.floor(score);
            System.out.println(score);
            return (int)score;
        }
        void divide(String s,ArrayList<String> al){
            for(int i=1;i<s.length();i++){
                if(check(s.substring(i-1,i+1))){
                    al.add(s.substring(i-1,i+1).toUpperCase());
                }
            }
        }
        boolean check(String s){
            boolean b=true;
            for(int i=0;i<s.length();i++){
                char t = Character.toUpperCase(s.charAt(i));
                if(t>='A'&&t<='Z'){
                    ;
                }
                else{
                    b=false;
                }
            }
            return b;
        }
    }
}
