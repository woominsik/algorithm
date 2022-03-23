package Programmers;
/**
 * 먼저 입력받은 string 배열의 files를 정렬 시켜주는데 splitby3라고 선언한 함수를 통해 각각의 파일명을 3부분의 배열로 나누어주고
 * head값인 [0]부분을 비교하여 같을 경우 [1]부분을 비교하여 정렬한 후 다시 정렬된 배열을 return 해줍니다.
 * splitBy3의 경우 숫자가 등장하기 전까지의 값인 head와 그 후 숫자부분인 Number부분 그 후 .이하 부분인 tail로 나눠주는 함수이다.
 *
 */

import java.util.*;

public class Solution_Lev2_24 {

    class Solution {
        public String[] solution(String[] files) {
            String[] answer = {};
            Arrays.sort(files,new Comparator<String>(){
                public int compare(String s1, String s2){
                    String[] temp=splitBy3(s1);
                    String[] temp2=splitBy3(s2);
                    int headValue= temp[0].compareTo(temp2[0]);
                    if(headValue==0){
                        int num1=Integer.parseInt(temp[1]);
                        int num2=Integer.parseInt(temp2[1]);
                        return num1-num2;
                    }
                    else{
                        return headValue;
                    }
                }
            });



            return files;
        }
        String[] splitBy3(String s){
            ArrayList<String> al=new ArrayList<>();
            String temp=""; //head부분
            int count=0;
            while(s.charAt(count)<'0'||s.charAt(count)>'9'){
                temp+=s.charAt(count);
                count++;
            }
            al.add(temp.toLowerCase());
            s=s.substring(temp.length());


            temp=""; //number부분
            count=0;
            while(s.charAt(count)>='0'&&s.charAt(count)<='9'){
                temp+=s.charAt(count);
                count++;
                // if(count>5){
                //     break;
                // }
                if(count>=s.length())
                    break;
            }
            temp=Integer.toString(Integer.valueOf(temp));
            al.add(temp);

            s=s.substring(temp.length());

            al.add(s); //tail부분
            String [] send=new String[al.size()];
            int index=0;
            for(String tmp:al){
                send[index]=tmp;
                index++;
            }


            return send;
        }
    }
}
