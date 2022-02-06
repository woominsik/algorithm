package Programmers;

// 처음에는 일일이 비교해가면서 banned_id에 들어갈 것들을 구해 조합하는 식으로 풀으려 했으나 조합하는 부분에 막혔다.
// 그래서 각 banned_id마다 맞는 user_id를 찾아 dfs하는 식으로 조합을 진행하여 문제를 풀었다.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution_Kakao_2019_Lev3_2 {
    class Solution {
        public int solution(int[] stones, int k) {
            int answer = 0;
            int low=1;
            int high=200000000;
            int mid;
            while(low<=high){
                mid=(low+high)/2;
                if(!check(stones,k,mid)){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                    answer = Math.max(answer, mid);
                }
            }
            return answer;
        }
        boolean check(int [] stones, int k,int mid){
            int count=0;
            for(int i: stones){
                if(i-mid<0){
                    count++;
                }
                else{
                    count=0;
                }
                if(count==k){
                    return false;
                }
            }
            return true;
        }
    }

}
