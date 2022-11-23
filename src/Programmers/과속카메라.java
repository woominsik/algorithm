package Programmers;
import java.util.*;
public class 과속카메라 {
    class Solution {
        public int solution(int[][] routes) {
            int answer = 1;
            Arrays.sort(routes, new Comparator<int []>(){
                public int compare(int [] o1, int [] o2){
                    return o1[0]-o2[0];
                }
            });
            int min = routes[0][0];
            int max = routes[0][1];

            for(int [] r : routes){

                if(r[0]>=min && r[0]<=max){
                    if(r[1]>=min && r[1]<=max){
                        max = r[1];
                    }
                    min = r[0];
                }
                else{
                    answer++;
                    min = r[0];
                    max = r[1];
                }
                // System.out.println(min+" "+max+" "+answer);
            }

            return answer;
        }
    }
}
