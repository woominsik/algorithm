package Programmers;

import java.util.*;

public class Solution_Lev2_7 {
    class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            String[] str = new String[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                str[i] = Integer.toString(numbers[i]);
            }
            Arrays.sort(str, Collections.reverseOrder());
            Arrays.sort(str, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return (s2 + s1).compareTo(s1 + s2);
                }
            });
            if (str[0].equals("0")) return "0";
            for (String s : str) {
                answer += s;
            }
            return answer;
        }
    }
}
