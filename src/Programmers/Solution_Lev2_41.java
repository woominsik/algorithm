package Programmers;
/**
 *  https://programmers.co.kr/learn/courses/30/lessons/12923
 *  먼저 소수일 경우 1 값을 가지고 소수가 아닐 경우 자신의 소인수 중 가장 큰 값을 RETURN해주면 된다 생각했다.
 *  따라서 checkPrime을 통해 소수임을 판단하고 소수일 경우 1값을 return해주어 array에 저장하였다.
 *  그리고 1이 아닌 것들을 확인한 후 소인수 중 10000000보다 작은 소인수를 찾아 return하여 배열에 저장하는 식으로 문제를 풀었다.
 */


public class Solution_Lev2_41 {
    class Solution { //소수는 1, n의 최댓값은 end의 절반
        public int[] solution(long begin, long end) {
            int[] answer = new int[(int)(end-begin)+1];
            int count=0;
            for(long i=begin;i<=end;i++){
                answer[count] = checkPrime(i);
                count++;
            }
            count=0;
            for(long i=begin;i<=end;i++){
                if(answer[count]==0){
                    answer[count] = check(i,end);
                }
                count++;
            }
            return answer;
        }

        int checkPrime(long num){
            if(num==1l)
                return 0;
            for(long i = 2;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    return 0;
                }
            }
            return 1;
        }

        int check(long num, long end){
            if(num==1l)
                return 0;
            for(long i=2;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    int temp = (int)(num/i);
                    if(temp<=end/2){
                        if(temp<=10000000)
                            return temp;
                    }
                }
            }
            return 1;
        }
    }
}
