package Programmers;
/* **
    입력받은 문자열을 모두 한자리 숫자의 배열로 만든 후 dfs를 통해 만들 수 있는 숫자를 만들어냈다.
    만들어진 숫자를 배열에 저장한 후 각각의 숫자가 소수인지 확인한 후, 소수일 경우 값을 1씩 더해 답을 구했다.
 */

import java.util.*;

public class Solution_Lev2_13 {

    class Solution {
        boolean [] visited;
        int [] arr;
        HashSet<Integer> al;
        public int solution(String numbers) {
            int answer = 0;
            al=new HashSet<>();
            int num=numbers.length();
            arr=new int [num];
            int [] output=new int [num];
            for(int i=0;i<num;i++){
                arr[i]=Character.getNumericValue(numbers.charAt(i));
            }
            visited=new boolean[num];
            for(int i=1;i<=num;i++){
                dfs(0,output,num,i);
            }
            for(int i:al){
                if(i<=1){
                    continue;
                }
                if(isSosu(i)) answer++;
            }
            System.out.println(al);
            return answer;
        }
        boolean isSosu(int num){
            for(int i=2;i<=Math.sqrt(num);i++){
                if(num%i==0)return false;
            }
            return true;
        }
        void dfs(int depth,int []output,int num,int r){
            if(depth==r){
                al.add(arr2Num(output,r));
                return;
            }
            for(int i=0;i<num;i++){
                if(visited[i]!=true){
                    visited[i]=true;
                    output[depth]=arr[i];
                    dfs(depth+1,output,num,r);
                    visited[i]=false;
                }
            }
        }
        int arr2Num(int [] arr,int r){
            int num=0;
            for(int i=0;i<r;i++){
                num*=10;
                num+=arr[i];
            }
            return num;
        }
    }
}
