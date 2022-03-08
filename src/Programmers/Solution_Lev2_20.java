package Programmers;
/* **
    먼저 입력받은 phone_book배열을 정렬한 후 각각의 문자열을 startsWith 함수를 통해 비교한 후 true인 값이 있을 경우 false를
    return 하고 아닐경우 true를 return 한다.
 */

import java.util.Arrays;

public class Solution_Lev2_20 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            Arrays.sort(phone_book);
            for(int i=0; i<phone_book.length-1; i++) {
                if(phone_book[i+1].startsWith(phone_book[i])){
                    return false;
                }
            }
            return true;
        }
    }
}
