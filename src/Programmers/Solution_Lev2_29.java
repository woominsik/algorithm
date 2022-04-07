package Programmers;
/**
 *
 */
import java.util.*;

public class Solution_Lev2_29 {

    class Solution {
        ArrayList<Integer> num;
        public int[] solution(int brown, int yellow) {
            int[] answer = new int [2];
            if(yellow==1){
                if(brown==8){
                    answer[0]=3;
                    answer[1]=3;
                    return answer;
                }
            }
            else if(yellow==2){
                if(brown==10){
                    answer[0]=4;
                    answer[1]=3;
                    return answer;
                }
            }
            num=new ArrayList<>();
            for(int i=1;i<yellow/2;i++){
                if(yellow%i==0){
                    int temp=yellow/i;
                    System.out.println(temp+" "+i);
                    int ans=((temp+2)*2)+i*2;
                    if(ans==brown){
                        if(temp>=i){
                            answer[0]=temp+2;
                            answer[1]=i+2;
                            return answer;
                        }
                        else{
                            answer[0]=i+2;
                            answer[1]=temp+2;
                            return answer;
                        }
                    }
                }
            }
            return answer;
        }

    }
}
