package Programmers;
import java.util.*;

/**
 * main안에 for문을 통해 dfs의 첫 값을 정해주고 dfs를 호출해준다. 호출된 dfs에서 check함수를 통해 다음 값으로 들어갈 수
 * 있는 지 확인한 후 들어갈 수 있을 경우 다음 dfs에 넣어 다시 호출해준다. 이 과정을 depth가 n-1일 때까지 진행한다.
 * n-1이 될 경우 answer값을 하나 증가 시켜주어 값을 구해낸다.
 */

public class Solution_Lev3_14 {
    public static void main(String[] args) {
        class Solution {
            int N;
            int answer = 0;
            boolean []visited;
            public int solution(int n) {

                N=n;
                for(int i=0;i<n;i++){ // 첫 칸
                    ArrayList<Integer> al =new ArrayList<>();
                    visited = new boolean[n];
                    if(!visited[i]){
                        visited[i]=true;
                        al.add(i);
                        dfs(i,0,al);
                    }
                }
                return answer;
            }
            void dfs(int loc, int depth, ArrayList<Integer> al){
                if(depth==N-1){
                    // System.out.println(depth+" "+loc);
                    answer++;
                    return;
                }

                for(int i=0;i<N;i++){
                    if(!visited[i]&&check(i,depth+1,al)){
                        // System.out.println(depth+" "+loc);
                        visited[loc]=true;
                        al.add(i);
                        dfs(i,depth+1,al);
                        visited[loc]=false;
                        al.remove(Integer.valueOf(i));
                    }
                }

            }
            boolean check(int next,int depth, ArrayList<Integer> al){
                for(int i=0;i<al.size();i++){
                    if(al.get(i)==next)
                        return false;
                    int t1 = Math.abs(al.get(i)-next);
                    int t2 = Math.abs(depth-i);
                    // System.out.println(next+" "+al.get(i)+" "+depth+" "+i);
                    if(t1==t2){
                        return false;
                    }
                }
                return true;
            }

        }
    }
}
