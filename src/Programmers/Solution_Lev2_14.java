package Programmers;
/* **
    s라는 문자열의 길이가 1이 될때 까지 while문을 돌린 뒤 for문을 통해 1의 개수를 temp에 저장한 후 temp를
    Integer.toBinaryString을 통해 문자열로 바꿔준다. 이과정을 계속 반복해서 진행하여
    while문을 돈 횟수를 num에, 지운 0의 개수를 zeroNum에 저장하여 해결
 */


public class Solution_Lev2_14 {

    class Solution {
        public int[] solution(String s) {
            int[] answer =new int [2];
            int zeroNum=0;
            int num=0;
            while(s.length()>1){
                num++;
                int temp=0;
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)=='1'){
                        temp++;
                    }
                    else{
                        zeroNum++;
                    }
                }
                s=Integer.toBinaryString(temp);
            }
            answer[0]=num;
            answer[1]=zeroNum;
            return answer;
        }
    }
}
