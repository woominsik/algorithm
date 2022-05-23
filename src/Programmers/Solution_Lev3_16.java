package Programmers;

/**
 * 먼저 fn을 통해 첫 팩토리얼을 구하고 ArrayList al에 각각의 숫자를 넣는다. 그리고 n번만큼 fn에 n을 나누어 새 팩토리얼값을 구한다.
 * 각각의 구한 값을 index로 하여 al에서 숫자를 찾은후 이를 answer에 넣어준다.
 */

import java.util.*;

public class Solution_Lev3_16 {

    class Solution {
        public int[] solution(int n, long k) {
            int[] answer = new int [n];
            ArrayList<Integer> al=new ArrayList<>();
            long fn=compute(n);
            int idx=0;
            for(int a=1;a<=n;a++){
                al.add(a);
            }
            k--;
            while(n>0){
                fn/=n;
                answer[idx++]=al.get((int)(k/fn));
                al.remove((int)(k/fn));
                k%=fn;
                n--;
            }
            return answer;
        }
        long compute(int n){
            long ans=1;
            for(int i=n;i>0;i--){
                ans*=i;
            }
            return ans;
        }
    }
}
