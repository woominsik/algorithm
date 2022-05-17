package Programmers;
/**
 * 먼저 각각의 지점을 연결하는 connected배열을 만들어준 후, 각 지점이 직접적으로 1과 연결되있을 경우
 * distance값을 1과의 값으로 바꿔준다.
 * 그리과 1지점과 거리가 가장 가까운 지점을 찾아 index를 저장해놓은다. 해당 지점과 연결된 지점중 1과 연결된 지점을 찾아
 * 경유 거리와 직접거리를 비교하여 작을경우 바꿔준다. 이과정을 N-1번 반복하여 값을 구한다.
 */


import java.util.*;

public class Solution_Lev2_38 {
    class Solution {
        public int solution(int N, int[][] road, int K) {
            int answer = 0;
            ArrayList <Integer> al=new ArrayList<>();
            int [][]connected=new int[N+1][N+1];
            for(int []i:road){
                if(connected[i[0]][i[1]]!=0){
                    int temp=connected[i[0]][i[1]];
                    if(temp>i[2]){
                        connected[i[0]][i[1]]=i[2];
                        connected[i[1]][i[0]]=i[2];
                    }
                }
                else{
                    connected[i[0]][i[1]]=i[2];
                    connected[i[1]][i[0]]=i[2];
                }
            }
            int [] distance=new int[N+1];
            boolean []visited=new boolean[N+1];
            for(int i=1;i<N+1;i++){
                distance[i] = Integer.MAX_VALUE;
            }
            distance[1]=0;
            visited[1]=true;
            for(int i=2;i<N+1;i++){
                if(connected[1][i]!=0){
                    distance[i]=connected[1][i];
                }
            }

            for(int a=0;a<N-1;a++){
                int min=Integer.MAX_VALUE;
                int min_index=-1;
                for(int i=1;i<N+1;i++){
                    if(!visited[i]&&distance[i]!=Integer.MAX_VALUE){
                        if(distance[i]<min){
                            min=distance[i];
                            min_index=i;
                        }
                    }
                }
                visited[min_index]=true;
                for(int i=1;i<N+1;i++){
                    if(!visited[i]&&connected[min_index][i]!=0){
                        if(distance[i]>distance[min_index]+connected[min_index][i]){
                            distance[i]=distance[min_index]+connected[min_index][i];
                        }
                    }
                }
            }
            for(int i=1;i<=N;i++){
                if(distance[i]<=K){
                    al.add(i);
                }
            }
            answer=al.size();
            return answer;
        }
    }
}
