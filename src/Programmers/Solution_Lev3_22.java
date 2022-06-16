package Programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/17676#
 * 먼저 각 시간에 대해서 날짜를 지우고 시간을 초로 바꾸어 진행하였다
 * 초와 처리시간으로 구정된 sec를 만들고 for문을 통해 자신보다 1초더한 것보다 빠르게 시작한 작업에 대해서
 * 수를 세줘서 cnt를 저장한다. 그리고 cnt 배열에서 최대값을 return 하여 해결하였다.
 */

import java.util.*;

public class Solution_Lev3_22 {
    class Solution {
        public int solution(String[] lines) {
            int answer = 0;
            int []cnt = new int[lines.length];
            String []sec = new String[lines.length];
            int count =0;
            for(String line : lines){
                String []temp = line.split(" ");
                String [] time = temp[1].split(":");
                double tsec = Double.parseDouble(time[2])+Double.parseDouble(time[1])*60+Double.parseDouble(time[0])*3600;

                sec[count]=tsec+" "+temp[2].substring(0,temp[2].length()-1);
                count++;
            }

            for(int i=0;i<lines.length;i++){
                String []temp = sec[i].split(" ");
                double tempEndSec = Double.parseDouble(temp[0]);
                tempEndSec +=1;

                for(int j=i;j<lines.length;j++){
                    String []temp2 = sec[j].split(" ");
                    double tempStartSec = Double.parseDouble(temp2[0])-Double.parseDouble(temp2[1])+0.001;

                    if(tempStartSec<tempEndSec){
                        // System.out.println(i+" "+j);
                        cnt[i]++;
                    }
                }
            }
            for(int i=0;i<lines.length;i++){
                if(answer<cnt[i]){
                    answer = cnt[i];
                }
            }
            return answer;
        }
    }
}
