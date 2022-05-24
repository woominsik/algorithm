package Programmers;

//https://programmers.co.kr/learn/courses/30/lessons/64062
/**
 * stones베열 각 원소값들이 가질 수 있는 최소값인 1과 최대값인 200,000,000을 각각 low값과 high값으로 선언한다.
 * 이분탐색을 통해 mid값을 구한 후 check함수를 통해 가능여부를 확인한다.
 * check함수에서는 각 stones값들에서 mid값을 빼었을 때 count를 올려주고 count값이 k랑 같을 경우 false를 return해준다.
 * check함수에서 true값이 나올 경우 mid값과 answer값을 비교하여 큰 값을 answer에 저장하여 return한다.
 */

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
