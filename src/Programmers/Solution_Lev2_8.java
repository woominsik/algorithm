package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution_Lev2_8 {
    class Solution {
        public String solution(String number, int k) {
            StringBuilder sb = new StringBuilder();
            int n_len = number.length();

            // 선택하는 수의 길이 ex) number = 1231234, k = 3 -> select_num = 7 - 3 = 4
            int select_num = n_len - k;
            char maxNum; // 선택한 최대의 숫자 값
            int start = 0; // number의 시작 index
            int end = 0; // number의 끝 index

            // 선택될 수 있는 숫자의 길이만큼 for
            for(int i = 0; i < select_num; i++) {
                maxNum = number.charAt(start);

                // 선택 index보다 큰 숫자가 나오면 해당 숫자를 maxNum에 저장하고,
                // 그 index를 end에 저장
                for(int j = start; j <= (i + k); j++) {
                    if(maxNum < number.charAt(j)) {
                        maxNum = number.charAt(j);
                        end = j;
                    } // if end
                } // for end

                sb.append(maxNum);

                // maxNum에 저장하고 나면 다음 index로 가기
                start = end + 1;

                // end에 start 값을 넣어 index를 옮겨줌
                end = start;

            } // for end
            return sb.toString();
        }
    }
}
